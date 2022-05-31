<template>
  <!--begin::List Widget 2-->
  <div class="card" :class="widgetClasses">
    <!--begin::Header-->
    <div class="card-header border-0">
      <h3 class="card-title fw-bolder text-dark">Top 6 Empresas</h3>
    </div>
    <!--end::Header-->

    <!--begin::Body-->
    <div class="card-body pt-2">
        
        <div class="row">
          <div class="col-sm">
            <span class="text-dark fw-bolder text-hover-primary fs-6 text-center">Empresa</span>
          </div>

          <div class="col me-5">
            <span class="text-dark fw-bolder text-hover-primary text-center ">Ranking</span>
          </div>
        </div>
      <div class="row">

        <template v-for="(item, index) in list" :key="index">
          <!--begin::Item-->
          <div :class="{ 'mb-7': list.length - 1 !== index }" class="d-flex align-items-center col">
            <!--begin::Text-->
            <div class="flex-grow-1 ">
              <a href="#" class="text-dark fw-bolder text-hover-primary fs-6">{{ item.name[0] }}</a>
              <span class="text-muted d-block fw-bold">{{ item.description[0] }}</span>
            </div>
            <!--end::Text-->

            <!--begin::Avatar-->
            <div class="symbol symbol-50px me-5 col">
              <img :src="item.avatar" class="" alt="" />
            </div>
            <!--end::Avatar-->
          </div>
          <!--end::Item-->
        </template>

      </div>
    </div>
    <!--end::Body-->
  </div>
  <!--end::List Widget 2-->
</template>

<script>
import { defineComponent, ref } from "vue";
import Dropdown2 from "@/components/dropdown/Dropdown2.vue";

export default ({
  name: "kt-widget-2",
  components: {
    Dropdown2,
  },
  props: 
  {
    widgetClasses: String,
    empresatop1: [],
    empresatop1cnpj: [],
    empresatop2: [],
    empresatop2cnpj: [],
    empresatop3: [],
    empresatop3cnpj: [],
    empresatop4: [],
    empresatop4cnpj: [],
    empresatop5: [],
    empresatop5cnpj: [],
    empresatop6: [],
    empresatop6cnpj: [],
    empresatop7: [],
    empresatop7cnpj: [],
    empresatop8: [],
    empresatop8cnpj: [],
  },
  setup(props) 
  {
    const list = ref([
      {
        avatar: "media/avatars/top1.png",
        name: props.empresatop1,
        description: props.empresatop1cnpj,
      },
      {
        avatar: "media/avatars/top2.png",
        name: props.empresatop2,
        description: props.empresatop2cnpj,
      },
      {
        avatar: "media/avatars/top3.png",
        name: props.empresatop3,
        description: props.empresatop3cnpj,
      },
      {
        avatar: "media/avatars/top4.png",
        name: props.empresatop4,
        description: props.empresatop4cnpj,
      },
      {
        avatar: "media/avatars/top5.png",
        name: props.empresatop5,
        description: props.empresatop5cnpj,
      },
      {
        avatar: "media/avatars/top6.png",
        name: props.empresatop6,
        description: props.empresatop6cnpj,
      },
      
    ]);

    return { list, };
  },
});
</script>
