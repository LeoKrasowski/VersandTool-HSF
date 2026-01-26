<template>
  <!-- Page header -->
  <div class="stripe-page-name">
    <span class="page-text-img-title">
      <img src="@/assets/customers.png" alt="Customers" class="page-icon" />
      <span class="page-title">{{ pageTitle }}</span>
    </span>
  </div>
  <main class="flex-grow-1">
    <div class="page-content">
      <!-- Add Customer toggle button -->
      <button class="btn-ord mb-3" @click="handleAddButton">
        {{ showAddForm ? $t('cancel') : $t('addCustomer') }}
      </button>

      <!-- Add Customer Form -->
      <transition name="slide-fade">
        <div v-if="showAddForm" class="add-form card p-3 mb-3">
          <h5>{{ $t('addCustomer') }}</h5>
          <form @submit.prevent="addCustomer">
            <div class="mb-2">
              <input v-model="form.number" :placeholder="$t('customer number')" class="form-control" />
            </div>
            <div class="mb-2">
              <input v-model="form.name" :placeholder="$t('name')" class="form-control" />
            </div>
            <div class="mb-2">
              <input v-model="form.language" :placeholder="$t('language')" class="form-control" />
            </div>
            <div class="mb-2">
              <input v-model="form.notificationNumber" :placeholder="$t('notification number')" class="form-control" />
            </div>
            <div class="mb-2">
              <input v-model="form.invoiceName" :placeholder="$t('invoice name')" class="form-control" />
            </div>
            <div class="mb-2">
              <input v-model="form.weekDays" :placeholder="$t('week days')" class="form-control" />
            </div>

            <button type="submit" class="btn-submit" :disabled="isSaving">
              {{ isSaving ? $t('save') + '...' : $t('save') }}
            </button>
          </form>
        </div>
      </transition>

      <!-- Edit Customer Form -->
      <div v-if="editCustomer" class="card p-3 mb-3">
        <h5>{{ $t('editUser') }}</h5>
        <form @submit.prevent="updateCustomerHandler">
          <div class="mb-2">
            <input v-model="editCustomer.number" :placeholder="$t('customer number')" class="form-control" />
          </div>
          <div class="mb-2">
            <input v-model="editCustomer.name" :placeholder="$t('name')" class="form-control" />
          </div>
          <div class="mb-2">
            <input v-model="editCustomer.language" :placeholder="$t('language')" class="form-control" />
          </div>
          <div class="mb-2">
            <input v-model="editCustomer.notificationNumber" :placeholder="$t('notification number')"
              class="form-control" />
          </div>
          <div class="mb-2">
            <input v-model="editCustomer.invoiceName" :placeholder="$t('invoice name')" class="form-control" />
          </div>
          <div class="mb-2">
            <input v-model="editCustomer.weekDays" :placeholder="$t('week days')" class="form-control" />
          </div>

          <button type="submit" class="btn" :style="{ backgroundColor: 'var(--color-accent)', color: '#fff' }">
            {{ $t('update') }}
          </button>
          <button type="button" class="btn btn-secondary ms-2" @click="editCustomer = null">{{ $t('cancel') }}</button>
        </form>
      </div>

      <!-- Customers Table -->
      <table class="table table-striped table-bordered">
        <thead class="table-style">
          <tr>
            <th>{{ $t('customer number') }}</th>
            <th>{{ $t('name') }}</th>
            <th>{{ $t('language') }}</th>
            <th>{{ $t('notification number') }}</th>
            <th>{{ $t('invoice name') }}</th>
            <th>{{ $t('week days') }}</th>
            <th>{{ $t('actions') }}</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="customer in customers" :key="customer.id">
            <td>{{ customer.number }}</td>
            <td>{{ customer.name }}</td>
            <td>{{ customer.language }}</td>
            <td>{{ customer.notificationNumber }}</td>
            <td>{{ customer.invoiceName }}</td>
            <td>{{ customer.weekDays }}</td>
            <td>
              <button class="btn btn-sm btn-warning me-1" @click="startEdit(customer)">
                {{ $t('edit') }}
              </button>
              <button class="btn btn-sm btn-danger" @click="deleteCustomerHandler(customer.id, customer)">
                {{ $t('delite') }}
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </main>
</template>

<script setup lang="ts">
import { ref, onMounted, computed } from 'vue'
import { useRoute } from 'vue-router'
import { useI18n } from 'vue-i18n'
import { getAllCustomers, createCustomer, updateCustomer, deleteCustomer as deleteCustomerApi } from '@/services/customerService'
import type { Customer } from '@/services/customerService'

/* ---------------- PAGE TITLE ---------------- */
const route = useRoute()
const { t } = useI18n()
const pageTitle = computed(() => t(route.meta.titleKey as string || ''))

/* ---------------- STATE ---------------- */
const customers = ref<Customer[]>([])
const showAddForm = ref(false)
const isSaving = ref(false)
const editCustomer = ref<Customer | null>(null)

/* ---------------- FORM MODEL ---------------- */
interface CustomerForm {
  number: number | null
  name: string
  language: string
  notificationNumber: string
  invoiceName: string
  weekDays: string
}
const form = ref<CustomerForm>({
  number: null,
  name: '',
  language: '',
  notificationNumber: '',
  invoiceName: '',
  weekDays: '',
})

/* ---------------- API ---------------- */
const load = async () => {
  const res = await getAllCustomers()
  customers.value = res.data
}

/* ---------------- FORM LOGIC ---------------- */
const resetForm = () => {
  form.value = {
    number: null,
    name: '',
    language: '',
    notificationNumber: '',
    invoiceName: '',
    weekDays: '',
  }
}

const addCustomer = async () => {
  if (isSaving.value || form.value.number === null) return
  isSaving.value = true
  try {
    await createCustomer({ ...form.value, number: form.value.number })
    resetForm()
    showAddForm.value = false
    await load()
  } catch (err) {
    console.error('Create customer failed', err)
  } finally {
    isSaving.value = false
  }
}

const handleAddButton = () => {
  if (showAddForm.value) {
    resetForm()
    showAddForm.value = false
  } else {
    showAddForm.value = true
  }
}

/* ---------------- EDIT ---------------- */
const startEdit = (customer: Customer) => {
  editCustomer.value = { ...customer }
}

const updateCustomerHandler = async () => {
  if (!editCustomer.value?.id) return
  await updateCustomer(editCustomer.value.id, editCustomer.value)
  editCustomer.value = null
  await load()
}

/* ---------------- DELETE ---------------- */
const deleteCustomerHandler = async (id: number | undefined, customer: Customer) => {
  if (!id) return
  await deleteCustomerApi(id, customer)
  await load()
}

/* ---------------- INIT ---------------- */
onMounted(load)
</script>
