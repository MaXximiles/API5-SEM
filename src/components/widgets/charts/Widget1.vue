<template>
  <!--begin::Charts Widget 1-->
  <div class="card" :class="widgetClasses">
    <!--begin::Header-->
    <div class="card-header border-0 pt-5">
      <!--begin::Title-->
      <h3 class="card-title align-items-start flex-column">
        <span class="card-label fw-bolder fs-3 mb-1">Estastisticas de Minhas Empresas</span>

        <span class="text-muted fw-bold fs-7">Consumo de empresas em minha carteira</span>
      </h3>
      <!--end::Title-->
    </div>
    <!--end::Header-->

    <!--begin::Body-->
    <div class="card-body">
      <!--begin::Chart-->
      <apexchart type="bar" :options="options" :series="series"></apexchart>
      <!--end::Chart-->
    </div>
    <!--end::Body-->
  </div>
  <!--end::Charts Widget 1-->
</template>

<script>
import { getCSSVariableValue } from "@/assets/ts/_utils";
import Dropdown1 from "@/components/dropdown/Dropdown1.vue";

export default({
  name: "widget-1",
  props: {
    widgetClasses: String,
    empresa1consumovend: [],
    empresa2consumovend: [],
    empresa3consumovend: [],
    empresa1empresavend: [],
    empresa2empresavend: [],
    empresa3empresavend: [],
    empresatopmesvend: [],
  },
  components: {
    Dropdown1,
  },
  setup(props) {
    const labelColor = getCSSVariableValue("--bs-gray-500");
    const borderColor = getCSSVariableValue("--bs-gray-200");
    const baseColor = getCSSVariableValue("--bs-primary");
    const secondaryColor = getCSSVariableValue("--bs-success");
    const terciaryColor = getCSSVariableValue("--bs-danger");

    const options = {
      chart: {
        fontFamily: "inherit",
        type: "bar",
        toolbar: {
          show: false,
        },
      },
      plotOptions: {
        bar: {
          horizontal: false,
          columnWidth: ["30%"],
          endingShape: "rounded",
        },
      },
      legend: {
        show: false,
      },
      dataLabels: {
        enabled: false,
      },
      stroke: {
        show: true,
        width: 2,
        colors: ["transparent"],
      },
      xaxis: {
        categories: ["Feb", "Mar", "Apr", "May", "Jun", "Jul"],
        axisBorder: {
          show: false,
        },
        axisTicks: { show: false, },
        labels: 
        {
          style: 
          {
            colors: labelColor,
            fontSize: "12px",
          },
        },
      },
      yaxis: 
      {
        labels: 
        {
          style: 
          {
            colors: labelColor,
            fontSize: "12px",
          },
        },
      },
      fill: { opacity: 1, },
      states: {

        normal: 
        {
          filter: 
          {
            type: "none",
            value: 0,
          },
        },
        hover: 
        {
          filter: 
          {
            type: "none",
            value: 0,
          },
        },
        active: 
        {
          allowMultipleDataPointsSelection: false,
          filter: 
          {
            type: "none",
            value: 0,
          },
        },
      },
      tooltip:
       {
        style: { fontSize: "12px", },
        y: {
          formatter: function (val) {  return val + " produtos consumidos"; },
        },
      },
      colors: [baseColor, secondaryColor, terciaryColor],
      grid: 
      {
        borderColor: borderColor,
        strokeDashArray: 4,
        yaxis:
        {
          lines: { show: true, },
        },
      },
    };

    const series = [
      {
        name: props.empresa1empresavend,
        data: props.empresa1consumovend,
      },
      {
        name: props.empresa2empresavend,
        data: props.empresa2consumovend,
      },
     {
        name: props.empresa3empresavend,
        data: props.empresa3consumovend,
      },
    ];

    return {
      options,
      series,
    };
  },
});
</script>
