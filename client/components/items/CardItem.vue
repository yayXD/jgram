<template>
  <section class="c-card">
    <div class="c-card_wrapper">
      <ImageComponent class="c-card_image -portrait" :src="image" />
      <div class="c-card_info">
        <div class="c-card_head">
          <h2 class="c-card_name">{{ name }}</h2>
          <span class="c-card_lang">{{ lang }}</span>
        </div>
        <p class="c-card_description">{{ description }}</p>
      </div>
    </div>
    <div class="c-card_overlay"></div>
  </section>
</template>

<script>
export default {
  props: {
    image: {
      type: String,
      required: true,
    },
    name: {
      type: String,
      required: true,
    },
    description: {
      type: String,
      default: '',
    },
    lang: {
      type: String,
      required: true,
    },
  },
}
</script>

<style lang="scss" scoped>
@import '@/assets/styles/settings/config.colors';
@import '@/assets/styles/settings/config';
@import '@/assets/styles/tools/functions';
@import '@/assets/styles/tools/mixins';

.c-card {
  position: relative;
  width: rem($card-width);
  border-radius: 5px;
  box-shadow: rem(10px) rem(10px) rem(20px) rgba(0, 0, 0, 0.2);
  margin: 0 auto;
  overflow: hidden;
  height: 70vh;
  max-height: rem(600px);
  min-height: rem(550px);

  &_wrapper {
    position: relative;
    display: block;
    height: 100%;
    overflow-y: auto;
    padding: rem(20px) rem(30px) 10vh;
    @include scrollbars(5px, rgba(0, 0, 0, 0.5));
  }

  &_info {
    position: relative;
    display: flex;
    flex-direction: column;
    width: 100%;
  }

  &_head {
    position: relative;
    display: flex;
    align-items: center;
    margin-bottom: rem($unit-tiny);
  }

  &_image {
    width: 100%;
    margin-bottom: rem(20px);
  }

  &_description {
    display: inline-block;
  }

  &_lang {
    position: relative;
    display: flex;
    justify-content: center;
    align-items: center;
    width: rem(32px);
    height: rem(32px);
    color: #f2f2f2;
    background-color: red;
    border-radius: 50%;
    font-size: rem(14px);
    line-height: 1;
    margin-left: rem($unit-tiny);
  }

  &_overlay {
    display: block;
    position: absolute;
    top: calc(100% - 10vh);
    left: 0;
    width: calc(100% - 5px);
    pointer-events: none;
    z-index: 0;
    height: 10vh;
    background: linear-gradient(0deg, white, transparent);
    margin-right: 5px;
  }
}
</style>
