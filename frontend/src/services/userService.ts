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
