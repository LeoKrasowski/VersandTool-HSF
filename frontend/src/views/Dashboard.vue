<template>
    <main class="flex-grow-1 erp-content">
        <router-view />
    <!-- KPI ROW -->
        <section class="erp-section kpi-row">
          <div class="kpi-box">
            <span>Finished routes</span>
            <strong>124</strong>
          </div>
          <div class="kpi-box">
            <span>Orders</span>
            <strong>56</strong>
          </div>
          <div class="kpi-box">
            <span>Invoices</span>
            <strong>18</strong>
          </div>
          <div class="kpi-box">
            <span>Revenue</span>
            <strong>€12 340</strong>
          </div>
        </section>

        <!-- DATA -->
        <section class="erp-section">
          <h3>Recent Orders</h3>
          <div class="erp-table-placeholder">
            Table here
          </div>
        </section>

        <section class="erp-section">
          <h3>System alerts</h3>
          <div class="erp-alert">
            No critical alerts
          </div>
        </section>
    </main>    
    </template>