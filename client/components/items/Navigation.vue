<template>
  <nav class="c-nav">
    <button class="c-nav_button c-button">Like</button>
    <button class="c-nav_button c-button">Dislike</button>
  </nav>
</template>

<script>
export default {}
</script>

<style lang="scss" scoped>
@import '@/assets/styles/settings/config.colors';
@import '@/assets/styles/settings/config';
@import '@/assets/styles/tools/functions';

.c-nav {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: rem($unit-tiny) rem($unit-small);
  width: rem($card-width);
  margin: 0 auto;

  &_button {
    width: rem(100px);
    height: rem(100px);
    border-radius: 50%;
    background-color: #0d0d0d;
    color: #f2f2f2;
    margin-right: rem($unit);

    &:last-child {
      margin-right: 0px;
    }
  }
}
</style>
