<template>
  <div id="app">

  <header class="app-header">
    <!-- LEFT -->
    <div class="header-left d-flex gap-2">
      <img src="@/assets/logo.png" alt="Logo" class="logo" />
      <h4 class="header-title">Versand Tool HSF</h4>
    </div>

    <!-- CENTER -->
    <nav class="header-nav">
      <router-link to="/users" class="nav-item" active-class="active-link">
        <img src="@/assets/profile-picture.png" class="nav-icon" />
        <span>{{ $t('Users') }}</span>
      </router-link>

      <router-link to="/orders" class="nav-item" active-class="active-link">
        <span>Orders</span>
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

// then changing select changing lang too
const changeLang = () => {
  locale.value = currentLang.value
}
</script>