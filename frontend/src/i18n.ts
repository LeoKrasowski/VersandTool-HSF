import { createI18n } from 'vue-i18n'

const messages = {
  en: {
    users: 'Users',
    addUser: 'Add User',
    save: 'Save',
    cancel: 'Cancel',
    editUser: 'Edit User',
  },
  ru: {
    users: 'Пользователи',
    addUser: 'Добавить пользователя',
    save: 'Сохранить',
    cancel: 'Отмена',
    editUser: 'Редактировать пользователя',
  }
}

export const i18n = createI18n({
  locale: 'de',        /*default lang*/
  fallbackLocale: 'de', /*default language if there is no translation*/ 
  messages,
})
