<template>
 
</template>

<script lang="ts">
import { defineComponent, onMounted } from "vue";
import { setCurrentPageTitle } from "@/core/helpers/breadcrumb";

export default defineComponent({
  name: "busca-cliente",
  components: {

  },
  setup() {
    onMounted(() => {
      setCurrentPageTitle("Busca de Clientes");
    });
  },
});
</script>
