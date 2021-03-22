<template>
  <figure class="c-image">
    <img
      class="c-image_media lazyload blur-up"
      data-sizes="auto"
      :data-src="src"
      :data-loading="src"
      :alt="alt"
    />
  </figure>
</template>

<script>
export default {
  props: {
    src: {
      type: String,
      required: true,
    },
    alt: {
      type: String,
      default: '',
    },
  },
}
</script>

<style lang="scss" scoped>
.c-image {
  position: relative;
  display: block;
  overflow: hidden;

  &::after {
    content: '';
    display: block;
  }

  &.-portrait {
    padding-bottom: 124.5%;
  }

  &_media {
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    object-fit: cover;
  }

  .blur-up {
    filter: blur(15px);
    transition: filter 400ms;
  }

  .blur-up.lazyloaded {
    filter: blur(0px);
  }
}
</style>
