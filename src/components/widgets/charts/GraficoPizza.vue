<template>
  <!--begin::Mixed Widget 4-->
  <div :class="widgetClasses" class="card">
    <!--begin::Beader-->
    <div class="card-header border-0 py-5">
      <h3 class="card-title align-items-start flex-column">
        <span class="card-label fw-bolder fs-3 mb-1">Grafíco de Consumo por Regiões</span>
      </h3>

    </div>
    <!--end::Header-->

    <!--begin::Body-->
    <div class="card-body d-flex flex-column">
      
      <div class="flex-grow-1">
        <!--begin::Chart-->
        <apexchart :options="chartOptions" :series="series" :height="chartHeight" type="pie" ></apexchart>
        <!--end::Chart-->
      </div>
    
    </div>
    <!--end::Body-->
  </div>
  <!--end::Mixed Widget 4-->
</template>

<script>
import {  ref } from "vue";
import Dropdown1 from "@/components/dropdown/Dropdown1.vue";

export default({
  name: "widget-1",
  components: {
    Dropdown1,
  },
  props: {
    widgetClasses: String,
    chartColor: String,
    chartHeight: String,
    btnColor: String,
    regiaotop1: [],
    regiaotop1consumo: [],
  },
  setup(props) {
    const color = ref(props.chartColor);
    //const series = [44000, 20000, 63987, 27444, 33020];
    const series = props.regiaotop1consumo;
      
    const chartOptions = 
    {
      chart: 
      {
        width: 450,
        type: 'pie',
      },
      //labels: ['Team A', 'Team B', 'Team C', 'Team D', 'Team E'],
      labels: props.regiaotop1,
      responsive: 
      [{
        breakpoint: 1500,
        options: 
        {
          chart: { width: 400 },
          legend: { position: 'bottom' }
        }
      }]
    };
    
    return {
      series,
      chartOptions,
    };
  },
});
</script>
