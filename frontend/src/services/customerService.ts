import api from './api';

export interface Customer {
  id?: number;
  number: number;
  name: string;
  language: string;
  notificationNumber: string;
  invoiceName: string;
  weekDays: string;
}

export const getAllCustomers = () => {
  return api.get<Customer[]>('/customers');
};

export const createCustomer = (customer: Customer) => {
  return api.post('/customers/add', customer);
};

export const updateCustomer = (id: number, customer: Customer) => {
  return api.put(`/customers/${id}`, customer)
}

export const deleteCustomer = (id: number, customer: Customer) => {
  return api.put(`/customers/${id}/delete`, customer)
}
