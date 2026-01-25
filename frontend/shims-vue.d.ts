// shims-vue.d.ts

import { ComponentOptions } from 'vue';

declare module "*.vue" {
  const component: ComponentOptions
  export default component
}
