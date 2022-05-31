<template>
  <!--begin::List Widget 2-->
  <div class="card" :class="widgetClasses">
    <!--begin::Header-->
    <div class="card-header border-0">
      <h3 class="card-title fw-bolder text-dark">Top 6 Vendedores</h3>
    </div>
    <!--end::Header-->

    <!--begin::Body-->
    <div class="card-body pt-2">
      <template v-for="(item, index) in list" :key="index">
        <!--begin::Item-->
        <div :class="{ 'mb-7': list.length - 1 !== index }" class="d-flex align-items-center">
          
          <!--begin::Avatar-->
          <div class="symbol symbol-50px me-5">
            <img :src="item.avatar" class="" alt="" />
          </div>
          <!--end::Avatar-->

          <!--begin::Text-->
          <div class="flex-grow-1">
            <a href="#" class="text-dark fw-bolder text-hover-primary fs-6">{{ item.name[0] }}</a>
            <span class="text-muted d-block fw-bold">{{ item.description[0] }}</span>
          </div>
          <!--end::Text-->
        </div>
        <!--end::Item-->
      </template>
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
    vendedortop1: '',
    vendedortop1email: [],
    vendedortop2: [],
    vendedortop2email: [],
    vendedortop3: [],
    vendedortop3email: [],
    vendedortop4: [],
    vendedortop4email: [],
    vendedortop5: [],
    vendedortop5email: [],
    vendedortop6: [],
    vendedortop6email: [],
    vendedortop7: [],
    vendedortop7email: [],
    vendedortop8: [],
    vendedortop8email: [],
  },
  setup(props) 
  {
    const list = ref([
      {
        avatar: "media/avatars/top1.png",
        name: props.vendedortop1,
        description: props.vendedortop1email,
      },
       {
        avatar: "media/avatars/top2.png",
        name: props.vendedortop2,
        description: props.vendedortop2email,
      },
       {
        avatar: "media/avatars/top3.png",
        name: props.vendedortop3,
        description: props.vendedortop3email,
      },
      {
        avatar: "media/avatars/top4.png",
        name: props.vendedortop4,
        description: props.vendedortop4email,
      },
      {
        avatar: "media/avatars/top5.png",
        name: props.vendedortop5,
        description: props.vendedortop5email,
      },
      {
        avatar: "media/avatars/top6.png",
        name: props.vendedortop6,
        description: props.vendedortop6email,
      },
    ]);

    return { list, };
  },
});
</script>
