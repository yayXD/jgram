<template>
  <aside class="c-aside">
    <nav class="c-main-nav">
      <ul class="c-main-nav_list">
        <li
          v-for="(item, index) in navigation"
          :key="index"
          class="c-main-nav_item"
        >
          <nuxt-link class="c-main-nav_link" to="messages"
            >{{ item.name }}
          </nuxt-link>
        </li>
      </ul>
    </nav>
  </aside>
</template>

<script>
export default {
  data() {
    return {
      navigation: [
        {
          name: 'Сообщения',
          route: 'messages',
        },
      ],
    }
  },
}
</script>

<style></style>
