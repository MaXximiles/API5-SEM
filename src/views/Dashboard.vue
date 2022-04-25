<template>

</template>

<script >
import { defineComponent, onMounted } from "vue";
import { setCurrentPageTitle } from "@/core/helpers/breadcrumb";

export default defineComponent({
  name: "dashboard",
  components: {

  },
  methods: 
  {
    recarregarPagina()
    {
      if(localStorage.getItem("recarregar") == "0")
      {
        localStorage.setItem("recarregar","1")
        location.reload();
      }    
    }
  },
  created() { this.recarregarPagina();},
  setup() {
    onMounted(() => {
      setCurrentPageTitle("Dashboard");
    });
  },
});
</script>
