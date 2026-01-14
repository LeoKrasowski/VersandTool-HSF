<template>
  <!-- Page header with icon -->
   
    <div class="stripe">
      <div class="page-strip"></div>
        <span class="page-text-img-title">
          <img src="@/assets/people.png" alt="People" class="page-icon"/>
      <span class="page-title">{{ $t('users') }}</span>
    </span>
  </div>
  
  <!-- div for content -->
  <div class="page-content">
    <!-- Button add -->
    <button class="btn btn-primary mb-3" @click="showAddForm = true">
      {{ $t('addUser') }}
    </button>

    <!-- adding form -->
    <div v-if="showAddForm" class="card p-3 mb-3">
      <h5>Benutzer hinzufügen</h5>
      <form @submit.prevent="addUser">
        <div class="mb-2">
          <input v-model="form.name" placeholder="Name" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="form.email" placeholder="Email" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="form.firma" placeholder="Firma" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="form.winUser" placeholder="WinUser" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="form.adresse" placeholder="Adresse" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="form.telefon" placeholder="Telefon" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="form.fax" placeholder="Fax" class="form-control" />
        </div>
        <!-- adding another for UserRequestDTO -->
        <button type="submit" class="btn" :style="{backgroundColor: 'var(--color-accent)', color: '#fff'}">
          {{$t('save')}}
        </button>
        <button type="button" class="btn btn-secondary ms-2" @click="showAddForm = false">{{$t('cancel')}}</button>
      </form>
    </div>

    <!-- editing form -->
    <div v-if="editUser" class="card p-3 mb-3">
      <h5>{{ $t('editUser') }}</h5>
      <form @submit.prevent="updateUserHandler">
        <div class="mb-2">
          <input v-model="editUser.name" placeholder="Name" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="editUser.email" placeholder="Email" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="editUser.winUser" placeholder="WinUser" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="editUser.active" placeholder="Active" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="editUser.firma" placeholder="Firma" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="editUser.adresse" placeholder="Adresse" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="editUser.telefon" placeholder="Telefon" class="form-control" />
        </div>
        <div class="mb-2">
          <input v-model="editUser.fax" placeholder="Fax" class="form-control" />
        </div>
        <!-- more fields -->
        <button type="submit" class="btn" :style="{backgroundColor: 'var(--color-accent)', color: '#fff'}">
          {{$t('update')}}
        </button>
        <button type="button" class="btn btn-secondary ms-2" @click="editUser = null">{{$t('cancel')}}</button>
      </form>
    </div>

    <!-- Tables -->
    <table class="table table-striped table-bordered">
      <thead class="table-style">
        <tr>
          <th>ID</th>
          <th>{{$t('name')}}</th>
          <th>Email</th>
          <th>Win user</th>
          <th>Active</th>
          <th>Firma</th>
          <th>Adresse</th>
          <th>Telefon</th>
          <th>Fax</th>
          <th>{{$t('Actions')}}</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="u in users" :key="u.id">
          <td>{{ u.id }}</td>
          <td>{{ u.name }}</td>
          <td>{{ u.email }}</td>
          <td>{{ u.winUser }}</td>
          <td>{{ u.active }}</td>
          <td>{{ u.firma }}</td>
          <td>{{ u.adresse }}</td>
          <td>{{ u.telefon }}</td>
          <td>{{ u.fax }}</td>
          <td>
            <button class="btn btn-sm btn-warning me-1" @click="startEdit(u)">{{$t('edit')}}</button>
            <button class="btn btn-sm btn-danger" @click="deleteUser(u.id,u)">{{$t('delite')}}</button>
          </td>
        </tr>
      </tbody>
    </table>

  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { getAllUsers, createUser, updateUser, deactivateUser } from '@/services/userService';
import type { User } from '@/services/userService';
import { watch } from 'vue'
import { useI18n } from 'vue-i18n'

const { locale } = useI18n()
// current lang
const currentLang = ref(locale.value)
// then changing select changing lang too
const changeLang = () => {
  locale.value = currentLang.value
}

const users = ref<User[]>([]);

const form = ref<User>({
  name: '',
  email: '',
  winUser: '',
  active: true,
  firma: '',
  adresse: '',
  telefon: '',
  fax: ''
});

//const editUser = ref<User | null>(null);
const showAddForm = ref(false);

const load = async () => {
  const res = await getAllUsers();
  users.value = res.data;
};

const addUser = async () => {
  await createUser(form.value);
  form.value = { name: '', email: '', winUser:'', active: true, firma:'', adresse:'', telefon:'', fax:'' };
  showAddForm.value = false;
  await load();
};

const editUser = ref<User | null>(null);

const startEdit = (user: User) => {
  editUser.value = { ...user };
};

const updateUserHandler = async () => {
  if (!editUser.value || !editUser.value.id) return;

  await updateUser(editUser.value.id, editUser.value);
  editUser.value = null;
  await load();
};


const deleteUser = async (id: number | undefined, user: User) => {
  if (!id) return;
  await deactivateUser(id, user);
  await load();
};

onMounted(load);
</script>
