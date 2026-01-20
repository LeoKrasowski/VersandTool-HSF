<template>

<div class="page-strip"></div>
    <main class="flex-grow-1 dashboard-main">
      <div class="dashboard-grid">
        <div class="dashboard-block">
            <img src="@/assets/file-import.png" class="title-icon">
            <h4>Import</h4>
            <button class="tile-btn">{{ $t('daten_importieren') }}</button>
            <button class="tile-btn">Forecast</button>
            <button class="tile-btn">Zollrechnungen</button>
            <button class="tile-btn">Kundenrechnungen</button>
        </div>
        <div class="dashboard-block">
            <img src="@/assets/delivery-truck.png" class="title-icon-tr">
            <h4>Expedit HSF</h4>
            <button class="tile-btn">Sendungen an Auftragen zuordnen</button>
            <button class="tile-btn">Gestelle einer sendung zugeordnet</button>
            <button class="tile-btn">AVISO</button>
            <button class="tile-btn">SMS senden</button>
            <button class="tile-btn">Leiferscheinkontrolle</button>
            <button class="tile-btn">LS Kontrolle NAV ADULO</button>
            <button class="tile-btn">Touren Ankunft/ abfahrt</button>
        </div>
        <div class="dashboard-block">
            <img src="@/assets/looking.png" class="title-icon">
            <h4>Schnellsuche</h4>
            <button class="tile-btn">LOU LOU</button>
            <button class="tile-btn">Vor aviso</button>
        </div>
        <div class="dashboard-block">
            <img src="@/assets/international.png" class="title-icon-in">
            <h4>Disposition</h4>
            <button class="tile-btn">Touren disposition</button>
            <button class="tile-btn">Tourübersicht</button>
            <button class="tile-btn">Tourenplan drucken</button>
            <button class="tile-btn">Stauplan</button>
            <button class="tile-btn">CMR Druck</button>
            <button class="tile-btn">Kopierte Auftrage ubersicht</button>
            <button class="tile-btn">Hornbach</button>
        </div>
        <div class="dashboard-block">Block 5</div>
        <div class="dashboard-block">Block 6</div>
        <div class="dashboard-block">Block 7</div>
        <div class="dashboard-block">Block 8</div>
        <div class="dashboard-block">Block 9</div>
        <div class="dashboard-block">Block 10</div>
        <div class="dashboard-block">Block 11</div>
      </div>

        
      </main>
</template>