<template>
  <header class="c-header o-container">
    <button aria-label="Open aside" class="c-aside-open c-button">Open</button>
    <h1 class="c-logo">CodeTidner</h1>
    <button class="c-profile-button c-button">Profile</button>
  </header>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/settings/config.colors';
@import '@/assets/styles/settings/config';
@import '@/assets/styles/tools/functions';

.c-header {
  position: relative;
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  padding-top: rem($unit-tiny);
  padding-bottom: rem($unit-tiny);
}

.c-logo {
  color: #000;
}
</style>
