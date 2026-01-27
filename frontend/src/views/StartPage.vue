<template>
    <main class="flex-grow-1 dashboard-main">
        <div class="dashboard-grid">
            <div class="dashboard-block">
                <div class="ttl-strp">
                    <div class="ttl-strp-line"></div>
                    <img src="@/assets/import.png" class="title-icon-in" alt="Import" />
                    <h5>Import</h5>
                </div>
                <button class="tile-btn">{{ $t('daten_importieren') }}</button>
                <button class="tile-btn">Forecast</button>
                <button class="tile-btn">Zollrechnungen</button>
                <button class="tile-btn">Kundenrechnungen</button>
            </div>

            <div class="dashboard-block">
                <div class="ttl-strp">
                    <div class="ttl-strp-line"></div>
                    <img src="@/assets/delivery-truck.png" class="title-icon-in" alt="Expedit" />
                    <h5>Expedit HSF</h5>
                </div>
                <button class="tile-btn">Sendungen an Auftragen zuordnen</button>
                <button class="tile-btn">Gestelle einer sendung zugeordnet</button>
                <button class="tile-btn">AVISO</button>
                <button class="tile-btn">SMS senden</button>
                <button class="tile-btn">Leiferscheinkontrolle</button>
                <button class="tile-btn">LS Kontrolle NAV ADULO</button>
                <button class="tile-btn">Touren Ankunft/ abfahrt</button>
            </div>

            <div class="dashboard-block">
                <div class="ttl-strp">
                    <div class="ttl-strp-line"></div>
                    <img src="@/assets/looking.png" class="title-icon-in" alt="Schnellsuche">
                    <h5>Schnellsuche</h5>
                </div>
                <button class="tile-btn">LOU LOU</button>
                <button class="tile-btn">Vor aviso</button>
            </div>

            <div class="dashboard-block">
                <div class="ttl-strp">
                    <div class="ttl-strp-line"></div>
                    <img src="@/assets/international.png" class="title-icon-in" alt="Disposition">
                    <h5>Disposition</h5>
                </div>
                <button class="tile-btn">Touren disposition</button>
                <button class="tile-btn">Tourübersicht</button>
                <button class="tile-btn">Tourenplan drucken</button>
                <button class="tile-btn">Stauplan</button>
                <button class="tile-btn">CMR Druck</button>
                <button class="tile-btn">Kopierte Auftrage ubersicht</button>
                <button class="tile-btn">Hornbach</button>
            </div>

            <div class="dashboard-block">
                <div class="ttl-strp">
                    <div class="ttl-strp-line"></div>
                    <img src="@/assets/board.png" class="title-icon-in" alt="Background">
                    <h5>Background</h5>
                </div>
                <router-link to="/Schweizer_karte" class="nav-item" active-class="active-link">
                    <button class="tile-btn">Schweizer Karte</button>
                </router-link>
                <router-link to="/users" class="nav-item" active-class="active-link">
                    <button class="tile-btn">Mitarbeiter erfassen</button>
                </router-link>
                <router-link to="/customers" class="nav-item" active-class="active-link">
                    <button class="tile-btn">Kundenangaben</button>
                </router-link>
            </div>

            <div class="dashboard-block">
                <div class="ttl-strp">
                    <div class="ttl-strp-line"></div>
                    <img src="@/assets/calc.png" class="title-icon-in" alt="Abrechnung">
                    <h5>Abrechnung</h5>
                </div>
                <button class="tile-btn">Tourenabrechnung</button>
                <button class="tile-btn">Wochenabechnung</button>
                <button class="tile-btn">Gelieferte Aufträge Export</button>
                <button class="tile-btn">Buchhaltung LW Kontrolle</button>
            </div>

            <div class="dashboard-block">
                <div class="ttl-strp">
                    <div class="ttl-strp-line"></div>
                    <img src="@/assets/factory.png" class="title-icon-in" alt="Produktion">
                    <h5>Produktion</h5>
                </div>
                <button class="tile-btn">Produktionsdatum</button>
            </div>

            <div class="dashboard-block">
                <div class="ttl-strp">
                    <div class="ttl-strp-line"></div>
                    <img src="@/assets/report.png" class="title-icon-in" alt="Technik meldungen">
                    <h5>Technik<br> meldungen</h5>
                </div>
                <button class="tile-btn">Technikermeldung</button>
                <button class="tile-btn">Meldungen erledigen ?</button>
            </div>

            <div class="dashboard-block">
                <div class="ttl-strp">
                    <div class="ttl-strp-line"></div>
                    <img src="@/assets/container-crane.png" class="title-icon-in" alt="Gestelle">
                    <h5>Gestelle</h5>
                </div>
                <button class="tile-btn">Gestellbuchung</button>
                <button class="tile-btn">Gestelle zuruck buchen</button>
            </div>

            <div class="dashboard-block">
                <div class="ttl-strp">
                    <div class="ttl-strp-line"></div>
                    <img src="@/assets/report.png" class="title-icon-in" alt="Benutzengruppen meldung">
                    <h5>Benutzengruppen<br> meldung</h5>
                </div>
                <button class="tile-btn">Meldung an Benutzergruppe</button>
                <button class="tile-btn">Meldung antworten</button>
                <button class="tile-btn">Offene Meldungen anschauen</button>
            </div>

            <div class="dashboard-block">
                <div class="ttl-strp">
                    <div class="ttl-strp-line"></div>
                    <img src="@/assets/workflow.png" class="title-icon-in" alt="Auftrag bearbeitung">
                    <h5>Auftrag bearbeitung</h5>
                </div>
                <button class="tile-btn">Ruckholung machen</button>
                <button class="tile-btn">Lieferwoche andern</button>
                <button class="tile-btn">Auftrag Kopieren</button>
                <button class="tile-btn">Manuelle auftragsanlage</button>
            </div>
        </div>

    </main>
</template>