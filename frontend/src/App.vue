<template>
  <div id="app">

    <!-- HEADER с навигацией -->
    <header class="app-header d-flex align-items-center ">
      <!-- Логотип + название -->
      <div class="header-left d-flex align-items-center gap-2">
        <img src="@/assets/logo.png" alt="Logo" class="logo" />
        <h4 class="header-title">Versand Tool HSF</h4>
      </div>

      <!-- Navigation -->
      <nav class="header-nav">
        <router-link to="/users" class="nav-item" active-class="active-link">
          <img src="@/assets/profile-picture.png" alt="Profile-picture" class="nav-icon" />
          <span>Users</span>
        </router-link>

        <router-link to="/orders" class="nav-item" active-class="active-link">
          <span>Orders</span>
        </router-link>
      </nav>
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
