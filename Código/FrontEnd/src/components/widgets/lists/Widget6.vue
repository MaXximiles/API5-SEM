<template>
  <!--begin::List Widget 6-->
  <div class="card" :class="widgetClasses">
    <!--begin::Header-->
    <div class="card-header border-0">
      <h3 class="card-title fw-bolder text-dark">Informações do Sistema</h3>

    </div>

    <!--begin::Body-->
    <div class="card-body pt-0">
      <template v-for="(item, index) in list" :key="index">
        <!--begin::Item-->
        <div :class="[ 'mb-7' && list.length - 1 !== index, `bg-light-${item.color}`, ]" class="d-flex align-items-center rounded p-5 mb-7" >

          <span :class="`svg-icon-${item.color}`" class="svg-icon me-5">
            <span class="svg-icon svg-icon-1">
              <inline-svg src="media/icons/duotune/abstract/abs027.svg" />
            </span>
          </span>

          <!--begin::Title-->
          <div class="flex-grow-1 me-2">
            <a href="#" class="fw-bolder text-gray-800 text-hover-primary fs-6 " >{{ item.title }}</a >
            <span class="text-muted fw-bold d-block">{{ item.text }}</span>
          </div>
          <!--end::Title-->

          <!--begin::Lable-->
          <span :class="`text-${item.color}`" class="fw-bolder py-2 h3">{{ item.number[0] }}</span>
          <!--end::Lable-->
        </div>
        <!--end::Item-->
      </template>
    </div>
    <!--end::Body-->
  </div>
  <!--end::List Widget 6-->
</template>

<script>
import { ref } from "vue";
import Dropdown3 from "@/components/dropdown/Dropdown3.vue";

export default({
  name: "kt-widget-6",
  components: {
    Dropdown3,
  },
  props: {
    widgetClasses: String,
    empresasspc: [],
    empresasconcorrente: [],
    empresaslivres: [],
    empresastotal: [],
    vendedorestotal: [],
  },
  setup(props) {
    const list = ref([
      {
        color: "warning",
        icon: "icons/duotune/abstract/abs027.svg",
        title: "Quantidade de Empresas Cadastradas",
        text: "Empresas cadastradas no sistema",
        number: props.empresastotal,
      },
      {
        color: "success",
        icon: "icons/duotune/art/art005.svg",
        title: "Quantidade de Empresas Livres",
        text: "Empresas livres, prontas para serem prospectadas",
        number: props.empresaslivres,
      },
      {
        color: "danger",
        icon: "icons/duotune/communication/com012.svg",
        title: "Quantidade de Empresas SPC",
        text: "Empresas na carteira da SPC",
        number: props.empresasspc,
      },
      {
        color: "info",
        icon: "icons/duotune/communication/com012.svg",
        title: "Quantidade de Empresas Concorrente",
        text: "Empresas na carteira do concorrente",
        number: props.empresasconcorrente,
      },
      {
        color: "primary",
        icon: "icons/duotune/communication/com012.svg",
        title: "Quantidade de Vendedores no Sistema",
        text: "Vendedores cadastrados no sistema",
        number: props.vendedorestotal,
      },
    ]);

    return {
      list,
    };
  },
});
</script>
