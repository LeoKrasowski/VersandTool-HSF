<template>
    <div class="stripe-page-name">
        <span class="page-text-img-title">
          <img src="@/assets/customers.png" alt="Customers" class="page-icon"/>
            <span class="page-title">{{ pageTitle }} </span> <!--used page naming from route-->
        </span>
    </div>

</template>


<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { watch } from 'vue'
import { useI18n } from 'vue-i18n'
import { computed } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute() 
const { t } = useI18n() 
const pageTitle = computed(() => t(route.meta.titleKey as string || '')) //used for naming by route


</script>