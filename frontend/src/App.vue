<template>
  <header class="d-flex align-items-center justify-content-between">
    <img src="@/assets/logo.png" alt="Logo" />
    <h3 class="m-0 text-white">Versand Tool HSF</h3>
  </header>

  <div class="container my-4">
    <router-link to="/users">Users</router-link>
    <router-view />
  </div>

  <footer class="text-center">
    © 2026 HSF
  </footer>
</template>

