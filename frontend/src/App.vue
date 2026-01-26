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
          <span>{{ $t('administration') }}</span>
        </router-link>
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

        <ul class="nav-list">
          <li class="nav-item" @mouseenter="showMenu('background')" @mouseleave="hideMenu">
            <span>{{ $t('Background') }}</span>
            <ul v-if="activeMenu === 'background'" class="dropdown-menu">
              <li><router-link to="/background/option1">{{ $t('Option 1') }}</router-link></li>
              <li><router-link to="/background/option2">{{ $t('Option 2') }}</router-link></li>
              <li><router-link to="/background/option3">{{ $t('Option 3') }}</router-link></li>
            </ul>
          </li>

          <li class="nav-item" @mouseenter="showMenu('kunden')" @mouseleave="hideMenu">
            <span>{{ $t('Kundenangaben') }}</span>
            <ul v-if="activeMenu === 'kunden'" class="dropdown-menu">
              <li><router-link to="/kunden/add">{{ $t('Add Kunde') }}</router-link></li>
              <li><router-link to="/kunden/list">{{ $t('List Kunde') }}</router-link></li>
            </ul>
          </li>
        </ul>



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

const activeMenu = ref<string | null>(null)

const showMenu = (menuName: string) => {
  activeMenu.value = menuName
}

const hideMenu = () => {
  activeMenu.value = null
}

// then changing select changing lang too
const changeLang = () => {
  locale.value = currentLang.value
}

</script>