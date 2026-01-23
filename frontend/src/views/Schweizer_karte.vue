<template>
  <div class="map-wrapper">
    <div id="map"></div>
  </div>
</template>

<script setup>
import { onMounted } from 'vue'
// JSON с почтовыми кодами и координатами
import postalData from '@/assets/geo/zipcodes.ch.json'

onMounted(async () => {
  const L = await import('leaflet')
  await import('leaflet/dist/leaflet.css')

  const markerCluster = await import('leaflet.markercluster')
  await import('leaflet.markercluster/dist/MarkerCluster.css')
  await import('leaflet.markercluster/dist/MarkerCluster.Default.css')

  // Создаём карту
  const map = L.map('map', { attributionControl: false }).setView([46.8, 8.3], 7)

  // TileLayer
  L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    minZoom: 6,
    maxZoom: 18
  }).addTo(map)

  // Attribution
  L.control.attribution({ position: 'bottomright', prefix: false }).addTo(map)
  map.attributionControl.addAttribution(
    '© <a href="https://www.openstreetmap.org/">OpenStreetMap</a>'
  )

  // Кластер маркеров
  const markers = L.markerClusterGroup()

  postalData.forEach(item => {
    const lat = parseFloat(item.latitude)
    const lng = parseFloat(item.longitude)
    if (!lat || !lng) return // безопасно пропускаем пустые координаты

    const marker = L.marker([lat, lng], {
      title: `${item.zipcode} — ${item.place}`
    }).bindPopup(`${item.zipcode} — ${item.place}`)

    markers.addLayer(marker)
  })

  map.addLayer(markers)

  // Автоцентрирование по всем маркерам
  const coords = postalData
    .map(item => [parseFloat(item.latitude), parseFloat(item.longitude)])
    .filter(c => !isNaN(c[0]) && !isNaN(c[1]))

  if (coords.length > 0) {
    map.fitBounds(L.latLngBounds(coords))
  }
})
</script>

<style scoped>
.map-wrapper {
  height: calc(100vh - 4rem);
  width: 100%;
  max-width: 1400px;
  margin: 2rem auto;
  border-radius: 16px;
  overflow: hidden;
  box-shadow: 0 10px 30px rgba(0,0,0,0.12), 0 2px 8px rgba(0,0,0,0.08);
}

/* Zoom controls */
.leaflet-control-zoom {
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 6px 20px rgba(0,0,0,0.15);
}
.leaflet-control-zoom a {
  background: #fff;
  color: #333;
  font-size: 18px;
  width: 36px;
  height: 36px;
  line-height: 36px;
  text-align: center;
  display: block;
  transition: background 0.2s ease;
}
.leaflet-control-zoom a:hover {
  background: #f0f2f5;
}
</style>
