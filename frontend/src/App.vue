<template>
  <div id="app">

    <header class="app-header">
      <!-- LEFT -->
      <div class="header-left d-flex gap-2">
        <a href="/">
          <img src="@/assets/logo.png" alt="Logo" class="logo" />
        </a>
        <a class="header-title" href="/">Versand Tool HSF</a>
      </div>


      <!-- CENTER -->
      <nav class="header-nav">
        <div class="dropdown">
          <button @click="isOpenAdmin = !isOpenAdmin">{{ $t('administration') }}</button>
          <ul v-if="isOpenAdmin">
            <li><router-link to="/users">User administration</router-link></li>
          </ul>
        </div>
        <router-link to="/import" class="nav-item" active-class="active-link">
          <span>{{ $t('import') }}</span>
        </router-link>
        <router-link to="/expedit_HSF" class="nav-item" active-class="active-link">
          <span>{{ $t('expedit_HSF') }}</span>
        </router-link>
        <router-link to="/quick_search" class="nav-item" active-class="active-link">
          <span>{{ $t('quick_search') }}</span>
        </router-link>
        <router-link to="/disposition" class="nav-item" active-class="active-link">
          <span>{{ $t('disposition') }}</span>
        </router-link>

        <div class="dropdown">
          <button @click="isOpenBackground = !isOpenBackground">{{ $t('Background') }}</button>
          <ul v-if="isOpenBackground">
            <li><router-link to="/Schweizer_karte">{{ $t('Schweizer_Karte') }}</router-link></li>
            <li><router-link to="/users">{{ $t('Mitarbeiter_erefassen') }}</router-link></li>
            <li><router-link to="/customers">{{ $t('Kundenangaben') }}</router-link></li>
          </ul>
        </div>

        <router-link to="/invoice" class="nav-item" active-class="active-link">
          <span>{{ $t('invoice') }}</span>
        </router-link>
        <router-link to="/production" class="nav-item" active-class="active-link">
          <span>{{ $t('production') }}</span>
        </router-link>
        <router-link to="/technology_reports" class="nav-item" active-class="active-link">
          <span>{{ $t('technology_reports') }}</span>
        </router-link>
        <router-link to="/racks" class="nav-item" active-class="active-link">
          <span>{{ $t('racks') }}</span>
        </router-link>
        <router-link to="/user_groups_message" class="nav-item" active-class="active-link">
          <span>{{ $t('user_groups_message') }}</span>
        </router-link>
        <router-link to="/order_processing" class="nav-item" active-class="active-link">
          <span>{{ $t('order_processing') }}</span>
        </router-link>
        <router-link to="/dashboard" class="nav-item" active-class="active-link">
          <span>{{ $t('dashboard') }}</span>
        </router-link>
      </nav>
      <!-- RIGHT -->
      <div class="lang-switcher">
        <select v-model="currentLang" @change="changeLang" class="lang-select">
          <option value="de">Deutsch</option>
          <option value="sk">Slovenský</option>
        </select>
      </div>
    </header>
    <div class="page-strip"></div>
    <!-- MAIN -->
    <main class="flex-grow-1">
      <router-view />
    </main>
    <!-- FOOTER -->
    <footer>
      © {{ new Date().getFullYear() }} HSF Internal software
      <div class="footer-description"> Application which contains logistics, invoices and another functions </div>
    </footer>
  </div>
</template>

<script setup lang="ts">
import { ref, watch } from 'vue'
import { useI18n } from 'vue-i18n'

const { locale } = useI18n()

// current lang
const currentLang = ref(locale.value)

const isOpenAdmin = ref(false)
const isOpenBackground = ref(false)




// then changing select changing lang too
const changeLang = () => {
  locale.value = currentLang.value
}

</script>

<style stoped>
/* container dropdown */
.dropdown {
  position: relative;
  display: inline-block;
  margin-right: 15px;
  /* gap bitween menu elements  */
}

/* button dropdown */
.dropdown>button {
  background: transparent;
  border: none;
  color: #fff;
  /* if header dark */
  cursor: pointer;
  font-size: 14px;
  padding: 8px 10px;
}

/* Hover button */
.dropdown>button:hover {
  background-color: rgba(255, 255, 255, 0.1);
  border-radius: 4px;
}

/* menu */
.dropdown ul {
  position: absolute;
  top: 100%;
  /* under button */
  left: 0;
  background: #fff;
  border: 1px solid #ccc;
  border-radius: 4px;
  list-style: none;
  padding: 5px 0;
  margin: 0;
  min-width: 180px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15);
  z-index: 1000;
}

/* points menu */
.dropdown ul li {
  padding: 8px 15px;
}

/* Hover for points */
.dropdown ul li:hover {
  background-color: #f0f0f0;
}

/* links in menu */
.dropdown ul li a {
  text-decoration: none;
  color: #333;
  display: block;
}

/* Hover for menu */
.dropdown ul li a:hover {
  color: #000;
}

/* adapt for header with flex */
.header-nav {
  display: flex;
  align-items: center;
  gap: 10px;
  /* gap bitween menu points */
}
</style>