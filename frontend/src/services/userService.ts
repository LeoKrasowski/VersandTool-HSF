import api from './api';

export interface User {
  id?: number;
  name: string;
  email: string;
  winUser: string;
  active: boolean;
  firma: string;
  adresse: string;
  telefon: string;
  fax: string;
}

export const getAllUsers = () => {
  return api.get<User[]>('/users');
};

export const createUser = (user: User) => {
  return api.post('/users/add', user);
};

export const updateUser = (id: number, user: User) => {
  const payload = { ...user, active: user.active ? false : true };
  return api.put(`/users/${id}`, payload);
}

export const deactivateUser = (id: number) => {
  return api.put(`/users/${id}/deactivate`);
};
