<template>
  <div class="stripe-page-name">
    <span class="page-text-img-title">
      <img src="@/assets/people.png" alt="People" class="page-icon" />
      <span class="page-title">{{ pageTitle }}</span>
    </span>
  </div>

  <main class="flex-grow-1 page-content">
    <!-- Toggle Add User Form -->
    <button class="btn-ord mb-3" @click="toggleAddForm">
      {{ showAddForm ? $t('cancel') : $t('addUser') }}
    </button>

    <!-- Add User Form -->
    <transition name="slide-fade">
      <div v-if="showAddForm" class="add-form card p-3 mb-3">
        <h5>{{ $t('addUser') }}</h5>
        <form @submit.prevent="handleAddUser">
          <div class="mb-2">
            <input v-model="form.name" :placeholder="$t('name')" class="form-control" />
          </div>
          <div class="mb-2">
            <input v-model="form.email" :placeholder="$t('Email')" class="form-control" />
          </div>
          <div class="mb-2">
            <input v-model="form.firma" :placeholder="$t('firma')" class="form-control" />
          </div>
          <div class="mb-2">
            <input v-model="form.winUser" placeholder="WinUser" class="form-control" />
          </div>
          <div class="mb-2">
            <input v-model="form.adresse" :placeholder="$t('adresse')" class="form-control" />
          </div>
          <div class="mb-2">
            <input v-model="form.telefon" :placeholder="$t('telefon')" class="form-control" />
          </div>
          <div class="mb-2">
            <input v-model="form.fax" placeholder="Fax" class="form-control" />
          </div>

          <button type="submit" class="btn-submit" :disabled="isSaving">
            {{ isSaving ? $t('save') + '...' : $t('save') }}
          </button>
        </form>
      </div>
    </transition>

    <!-- Edit User Form -->
    <div v-if="editUser" class="card p-3 mb-3">
      <h5>{{ $t('editUser') }}</h5>
      <form @submit.prevent="handleUpdateUser">
        <div class="mb-2">
          <input v-model="editUser.name" :placeholder="$t('name')" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="editUser.email" :placeholder="$t('Email')" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="editUser.firma" :placeholder="$t('firma')" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="editUser.winUser" placeholder="WinUser" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="editUser.adresse" :placeholder="$t('adresse')" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="editUser.telefon" :placeholder="$t('telefon')" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="editUser.fax" placeholder="Fax" class="form-control" />
        </div>

        <!-- Active checkbox -->
        <div class="mb-2 form-check">
          <input type="checkbox" v-model="editUser.active" class="form-check-input" id="activeUserCheckbox"
            @change="onActiveChange" />
          <label class="form-check-label" for="activeUserCheckbox">
            {{ $t('active_user') }}
          </label>
        </div>

        <button type="submit" class="btn" :style="{ backgroundColor: 'var(--color-accent)', color: '#fff' }">
          {{ $t('update') }}
        </button>
        <button type="button" class="btn btn-secondary ms-2" @click="editUser = null">
          {{ $t('cancel') }}
        </button>
      </form>
    </div>

    <!-- Users Table -->
    <table class="table table-striped table-bordered">
      <thead class="table-style">
        <tr>
          <th>{{ $t('name') }}</th>
          <th>Email</th>
          <th>Win user</th>
          <th>{{ $t('active_user') }}</th>
          <th>{{ $t('firma') }}</th>
          <th>{{ $t('adresse') }}</th>
          <th>{{ $t('telefon') }}</th>
          <th>Fax</th>
          <th>{{ $t('actions') }}</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="u in users" :key="u.id" :class="{ 'table-secondary text-muted': !u.active }">
          <td>{{ u.name }}</td>
          <td>{{ u.email }}</td>
          <td>{{ u.winUser }}</td>
          <td>{{ u.active ? $t('active_user') : $t('inactive') }}</td>
          <td>{{ u.firma }}</td>
          <td>{{ u.adresse }}</td>
          <td>{{ u.telefon }}</td>
          <td>{{ u.fax }}</td>
          <td>
            <button class="btnedit btntab-sm" @click="startEdit(u)">{{ $t('edit')
              }}</button>
            <button class="btndel btntab-sm" @click="handleDeactivate(u)" :disabled="!u.active">
              {{ $t('delite') }}
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </main>
</template>

<script setup lang="ts">
import { ref, onMounted, computed } from 'vue'
import { useRoute } from 'vue-router'
import { useI18n } from 'vue-i18n'
import { getAllUsers, createUser, updateUser, deactivateUser } from '@/services/userService'
import type { User } from '@/services/userService'

const route = useRoute()
const { t } = useI18n()
const pageTitle = computed(() => t(route.meta.titleKey as string || ''))

const users = ref<User[]>([])
const showAddForm = ref(false)
const isSaving = ref(false)

const form = ref<User>({
  name: '',
  email: '',
  winUser: '',
  active: true,
  firma: '',
  adresse: '',
  telefon: '',
  fax: ''
})

const editUser = ref<User | null>(null)

/* ---------------- LOAD USERS ---------------- */
const loadUsers = async () => {
  const res = await getAllUsers()
  users.value = res.data
}

/* ---------------- ADD USER ---------------- */
const toggleAddForm = () => {
  showAddForm.value = !showAddForm.value
}

const resetForm = () => {
  form.value = {
    name: '',
    email: '',
    winUser: '',
    active: true,
    firma: '',
    adresse: '',
    telefon: '',
    fax: ''
  }
}

const handleAddUser = async () => {
  if (isSaving.value) return
  isSaving.value = true
  try {
    await createUser(form.value)
    resetForm()
    showAddForm.value = false
    await loadUsers()
  } catch (err) {
    console.error('Create user failed', err)
  } finally {
    isSaving.value = false
  }
}

/* ---------------- EDIT USER ---------------- */
const startEdit = (user: User) => {
  // select active to boolean, check
  editUser.value = { ...user, active: !!user.active };
};

const handleUpdateUser = async () => {
  if (!editUser.value?.id) return;

  try {
    const payload: User = {
      ...editUser.value,
      // active: editUser.value.active
    };

    await updateUser(editUser.value.id, payload);

    editUser.value = null;
    await loadUsers();
  } catch (err) {
    console.error('Update user failed', err);
  }
};

const onActiveChange = async () => {
  if (!editUser.value?.id) return;

  if (!editUser.value.active) {
    await handleDeactivate(editUser.value);
    editUser.value = null;
  }
};

/* ---------------- DELETE USER ---------------- */

const handleDeactivate = async (user: User) => {
  if (!user.id) return;

  await deactivateUser(user.id);
  await loadUsers();
};

/* ---------------- ON MOUNT ---------------- */
onMounted(loadUsers)
</script>
