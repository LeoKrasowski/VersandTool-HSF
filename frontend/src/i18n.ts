import { createI18n } from 'vue-i18n'

const messages = {
  de: {
    users: 'Benutzer',
    addUser: 'Benutzer hinzufügen',
    save: 'Speichern',
    cancel: 'Abbrechen',
    editUser: 'Benutzer bearbeiten',
    update: 'Aktualisieren',
    name: 'Name',
    actions: 'Aktionen',
    edit: 'Bearbeiten',
    delite: 'Löschen',

  },
  sk: {
    users: 'Používateľ',
    addUser: 'Pridať používateľa',
    save: 'Uložiť',
    cancel: 'Zrušiť',
    editUser: 'Upraviť používateľa',
    update: 'Aktualizovať',
    name: 'Meno',
    edit: 'Upraviť',
    delite: 'Vymazať',
  }
}

export const i18n = createI18n({
  locale: 'de',        /*default lang*/
  fallbackLocale: 'de', /*default language if there is no translation*/ 
  messages,
})
