<template>
  <div class="map-wrapper">
    <div id="map"></div>
  </div>
</template>

<script setup>
import { onMounted } from 'vue'
import L from 'leaflet'
import 'leaflet/dist/leaflet.css'
import 'leaflet.markercluster/dist/leaflet.markercluster.js'
import 'leaflet.markercluster/dist/MarkerCluster.css'
import 'leaflet.markercluster/dist/MarkerCluster.Default.css'

import postalDataCH from '@/assets/geo/zipcodes.ch.json'
import postalDataAT from '@/assets/geo/zipcodes.at.json'
import postalDataDE from '@/assets/geo/zipcodes.de.json'
import postalDataFR from '@/assets/geo/zipcodes.fr.json'
import postalDataSK from '@/assets/geo/zipcodes.sk.json'

// path
const icons = {
  CH: '/icons/ch-pin.png',
  AT: '/icons/at-pin.png',
  DE: '/icons/de-pin.png',
  FR: '/icons/fr-pin.png',
  SK: '/icons/sk-pin.png',
  DEFAULT: 'public/icons/default-pin.png'
}

onMounted(() => {
    
  const map = L.map('map', { attributionControl: false }).setView([46.8, 8.3], 7)

  L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    minZoom: 6,
    maxZoom: 18
  }).addTo(map)

  L.control.attribution({ position: 'bottomright', prefix: false }).addTo(map)
  map.attributionControl.addAttribution(
    '© <a href="https://www.openstreetmap.org/">OpenStreetMap</a>'
  )

  const allPostalData = [...postalDataCH, ...postalDataAT, ...postalDataDE, ...postalDataFR, ...postalDataSK,]
  const markers = L.markerClusterGroup()

  allPostalData.forEach(item => {
    const lat = parseFloat(item.latitude)
    const lng = parseFloat(item.longitude)
    if (isNaN(lat) || isNaN(lng)) return

    const country = item.country_code?.trim().toUpperCase() || 'DEFAULT'
    const iconUrl = icons[country] || icons.DEFAULT

    // divIcon with img, postal, city
    const icon = L.divIcon({
      className: 'postal-divicon',
      html: `
        <div class="pin-wrapper">
          <img src="${iconUrl}" alt="${item.country_code}" class="pin-img"/>
          <div class="pin-text">
          <span class="zipcode">${item.zipcode}</span>
          <span class="place">${item.place}</span>
         </div>
        </div> 
      `,
      iconSize: [20, 20],
      iconAnchor: [30, 60],
      popupAnchor: [0, -60]
    })

    const marker = L.marker([lat, lng], { icon })

     // add popup by click
  marker.bindPopup(`
    <strong>${item.zipcode}</strong><br/>
    ${item.place}<br/>
    <em>${country}</em>
  `)
    markers.addLayer(marker)
  })

  map.addLayer(markers)

  // auto centered by swiss
  const swissMarkers = allPostalData
  .filter(item => item.country_code?.toUpperCase() === 'CH')
  .map(item => [parseFloat(item.latitude), parseFloat(item.longitude)])
  .filter(c => !isNaN(c[0]) && !isNaN(c[1]))

if (swissMarkers.length > 0) {
  map.fitBounds(L.latLngBounds(swissMarkers), { padding: [50, 50] })
}
})
</script>

<style scoped>
.map-wrapper {
  height: calc(80vh - 6rem);
  width: 80%;
  max-width: 1220px;
  margin: 2rem auto;
  border-radius: 16px;
  overflow: hidden;
  box-shadow: 0 10px 30px rgba(0,0,0,0.12), 0 2px 8px rgba(0,0,0,0.08);
}

/* Зум контрол */
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

.postal-divicon .pin-wrapper {
  position: relative;
  width: 60px;
  height: 60px;
  text-align: center;
  font-family: sans-serif;
}

.postal-divicon .pin-img {
   width: 20px;       /* ширина пина */
  height: 20px;      /* высота пина */
  object-fit: contain;
  display: block;
  margin: 0 auto;
}

.postal-divicon .pin-text {
  position: absolute;
  top: 4px;
  left: 50%;
  transform: translateX(-50%);
  color: #fff;
  text-shadow: 0 0 3px rgba(0,0,0,0.8);
}

.postal-divicon .zipcode {
  font-weight: bold;
  font-size: 12px;
}

.postal-divicon .place {
  font-size: 10px;
}

</style>
