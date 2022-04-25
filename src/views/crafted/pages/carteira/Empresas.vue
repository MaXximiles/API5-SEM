<template>

</template>

<script lang="ts">
import { defineComponent, onMounted } from "vue";
import { setCurrentPageTitle } from "@/core/helpers/breadcrumb";

export default defineComponent({
  name: "empresa",
  components: {
 
  },
  setup() {
    onMounted(() => {
      setCurrentPageTitle("Minhas Empresas");
    });
  },
});
</script>
