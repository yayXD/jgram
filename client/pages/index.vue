<template>
  <main class="c-content">
    <CardItem
      :image="data.image"
      :name="data.name"
      :lang="data.lang"
      :description="data.description"
    />
  </main>
</template>

<script>
import CardItem from '@/components/items/CardItem'

export default {
  components: { CardItem },
  data() {
    return {
      data: {
        image:
          'https://images.unsplash.com/photo-1616169443520-85e1c9fc6032?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2734&q=80',
        name: 'Vasya Face',
        lang: 'JS',
        description:
          'lasdasdasdasdas dasdasdadsasdasdasd asacasc ascascascas casca casasc anjnsjnvlkjajv blkajb sdv;ba;s djbvlsjb dv;asbv;asjdvb; jdsbvjb asdasdasdas asd a sd as dasdasd as da sd a sda sd a s d as d as d as d a sdasdasdasdasdasd ',
      },
    }
  },
}
</script>

<style lang="scss" scoped>
.c-content {
  position: relative;
  display: grid;
  place-content: center;
}
</style>
