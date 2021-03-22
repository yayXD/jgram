<template>
  <div class="c-page">
    <HeaderComponent />
    <Nuxt />
    <Navigation />
  </div>
</template>

<script>
import HeaderComponent from '@/components/items/HeaderComponent'
import Navigation from '@/components/items/Navigation'

export default {
  components: {
    HeaderComponent,
    Navigation,
  },
}
</script>

<style lang="scss">
.c-page {
  position: relative;
  display: grid;
  grid-template-rows: min-content auto min-content;
  width: 100%;
  min-height: 100vh;
  overflow: hidden;
  background-color: #f2f2f2;
}
</style>
