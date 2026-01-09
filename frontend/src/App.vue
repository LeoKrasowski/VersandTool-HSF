<script setup lang="ts">
  import { ref } from 'vue'

  const message = ref('Hello Vue + Vite 🚀')
</script>

<template>
  <h1>Versand Tool HSF</h1>
  <p>
    Visit <a href="https://vuejs.org/" target="_blank" rel="noopener">vuejs.org</a> to read the
    documentation
  </p>
    <div class="app">
    <div class="card">
      <button @click="message = 'Welcome!'">
        HSF
      </button>
    </div>
  </div>
    <h1>{{ message }}</h1>
</template>

<style scoped>
/* reset + base */
* {
  box-sizing: border-box;
}

.app {
  min-height: 60vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: linear-gradient(135deg, #1e1e2f, #2a2a40);
  font-family: Inter, system-ui, Avenir, Helvetica, Arial, sans-serif;
  color: #ffffff;
}

/* card */
.card {
  background: rgba(250, 9, 141, 0.967);
  min-width: 200vh;
  min-height: 10vh;
  margin-bottom: 30rem;
  padding: 1.5rem 6rem;
  border-radius: 10px;
  text-align: center;
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.35);
  backdrop-filter: blur(10px);
  animation: fadeIn 0.6s ease-out;
}

h1 {
  margin-bottom: 0.5rem;
  font-size: 2.2rem;
  color: #090909;
}

p {
  margin-bottom: 1.5rem;
  opacity: 0.85;
}

/* button */
button {
  background: rgba(249, 3, 200, 0.942);
  color: #0f2027;
  border: none;
  border-radius: 1px;
  padding: 0.5rem 50rem;
  font-size: 3rem;
  cursor: pointer;
  transition: all 0.25s ease;
  font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}

button:hover {
  background: #f7f7f8fa;
  transform: translateY(-2px);
  box-shadow: 0 8px 20px rgba(66, 184, 131, 0.35);
}

button:active {
  transform: translateY(0);
}

/* animation */
@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}
</style>
