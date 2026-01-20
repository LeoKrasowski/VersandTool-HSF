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
      <router-link to="/users" class="nav-item" active-class="active-link">
        <img src="@/assets/profile-picture.png" class="nav-icon" />
        <span>{{ $t('users') }}</span>
      </router-link>

      <router-link to="/dashboard" class="nav-item" active-class="active-link">
        <img src="@/assets/dashboard.png" class="nav-icon">
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