<template>
  <!--begin::Charts Widget 2-->
  <div :class="widgetClasses" class="card">
    <!--begin::Header-->
    <div class="card-header border-0 pt-5">
      <h3 class="card-title align-items-start flex-column">
        <span class="card-label fw-bolder fs-3 mb-1">Grafico do Top 3 Empresas</span>

        <span class="text-muted fw-bold fs-7">Grafico de empresas que mais consumiram no periodo</span>
      </h3>

    </div>
    <!--end::Header-->

    <!--begin::Body-->
    <div class="card-body">
      <!--begin::Chart-->
      <apexchart type="bar" :options="options" :series="series" ></apexchart>
      <!--end::Chart-->
    </div>
    <!--end::Body-->
  </div>
  <!--end::Charts Widget 2-->
</template>

<script>
import { getCSSVariableValue } from "@/assets/ts/_utils";

export default ({
  name: "widget-1",
  props: {
    widgetClasses: String,
    empresatop1: [],
    empresatop1consumo: [],
    empresatop2: [],
    empresatop2consumo: [],
    empresatop3: [],
    empresatop3consumo: [],
    empresatop4: [],
    empresatop4consumo: [],
    empresatop5: [],
    empresatop5consumo: [],
    empresatop6: [],
    empresatop6consumo: [],
    empresatop7: [],
    empresatop7consumo: [],
    empresatop8: [],
    empresatop8consumo: [],
    empresatopMes: [],
  },
  components: {},
  setup(props) {
    const labelColor = getCSSVariableValue("--bs-gray-500");
    const borderColor = getCSSVariableValue("--bs-gray-200");
    const baseColor = getCSSVariableValue("--bs-success");
    const secondaryColor = getCSSVariableValue("--bs-warning");
    const terciaryColor = getCSSVariableValue("--bs-info");

    const options = {
      chart: 
      {
        fontFamily: "inherit",
        type: "bar",
        toolbar: { show: false, },
      },
      plotOptions: 
      {
        bar: {
          horizontal: false, //mudar para vertical colocar false
          columnWidth: ["45%"],
          endingShape: "rounded",
        },
      },
      legend: { show: true, }, //Legenda do grafico
      dataLabels: { enabled: false, },
      stroke: 
      {
        show: true,
        width: 3,
        colors: ["transparent"],
      },
      xaxis: {
        categories: ["Set", "Out", "Nov", "Dez", "Jan", "Fev"],
        axisBorder: { show: true, },
        axisTicks: { show: true, },
        labels: 
        {
          style: 
          {
            colors: labelColor,
            fontSize: "12px",
          },
        },
      },
      yaxis: {
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
      states: 
      {
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
          formatter: function (val) 
          { 
            return val +" Produtos Consumidos"; 
          },
        },
      },
      colors: [secondaryColor, baseColor, terciaryColor],
      grid: 
      {
        borderColor: borderColor,
        strokeDashArray: 4,
        yaxis: { lines: { show: true, }, },
      },
    };

    const series = [
      {
        name: props.empresatop1,
        data: props.empresatop1consumo,
      },
      {
        name: props.empresatop2,
        data: props.empresatop2consumo,
      },
      {
        name: props.empresatop3,
        data: props.empresatop3consumo,
      },
     
    ];

    return {
      options,
      series,
    };
  },
});
</script>
