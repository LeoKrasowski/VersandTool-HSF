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
    firma: 'Firma',
    adresse: 'Adresse',
    telefon: 'Telefon',
    active: 'Active',
    dashboard: 'Dashboard',
    daten_importieren: 'Daten importieren',
    add_customer: 'Kunde hinzufügen',
    customer_number: 'Kundennummer',
    language: 'Sprache',
    notification_number: 'Benachrichtigungsnummer',
    invoice_name: 'Rechnungsname',
    week_days: 'Wochentage',
    editCustomer: 'Kunden bearbeiten'

  },
  sk: {
    users: 'Používateľ',
    addUser: 'Pridať používateľa',
    save: 'Uložiť',
    cancel: 'Zrušiť',
    editUser: 'Upraviť používateľa',
    update: 'Aktualizovať',
    name: 'Meno',
    actions: 'Akcie',
    edit: 'Upraviť',
    delite: 'Vymazať',
    firma: 'Podnik',
    adresse: 'Adresa',
    telefon: 'Telefón',
    active: 'Aktívne',
    dashboard: 'Prehľad',
    daten_importieren: 'Importovať údaje',
    add_customer: 'Pridať zákazníka',
    customer_number: 'Zákaznícke číslo',
    language: 'Jazyk',
    notification_number: 'Číslo oznámenia',
    invoice_name: 'Názov faktúry',
    week_days: 'Týždenné dni',
    editCustomer: 'Upraviť zákazníka'
  }
}

export const i18n = createI18n({
  locale: 'de',        /*default lang*/
  fallbackLocale: 'de', /*default language if there is no translation*/ 
  messages,
})
