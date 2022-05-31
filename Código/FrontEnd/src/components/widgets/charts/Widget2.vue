<template>
  <!--begin::Charts Widget 2-->
  <div :class="widgetClasses" class="card">
    <!--begin::Header-->
    <div class="card-header border-0 pt-5">
      <h3 class="card-title align-items-start flex-column">
        <span class="card-label fw-bolder fs-3 mb-1">Desempenho do top 3 Melhores Vendedores</span>

        <span class="text-muted fw-bold fs-7">Grafico de desempenho do top 3 melhores vendedores.</span>
      </h3>

    </div>
    <!--end::Header-->

    <!--begin::Body-->
    <div class="card-body">
      <!--begin::Chart-->
      <apexchart type="bar" :options="options" :series="series"  :consumovendedor1="ArrayTopConsumo1" :mesesvendedor1="ArrayTopMesVendedor1" :consumovendedor2="ArrayTopConsumo2" :mesesvendedor2="ArrayTopMesVendedor2" :consumovendedor3="ArrayTopConsumo3" :mesesvendedor3="ArrayTopMesVendedor3"></apexchart>
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
    topvendedor1: '',
    topvendedor2: '',
    topvendedor3: '',
    consumovendedor1: [],
    mesesvendedor1: [],
    consumovendedor2: [],
    mesesvendedor2: [],
    consumovendedor3: [],
    mesesvendedor3: [],
  },
  components: {},
  setup(props) {
    const labelColor = getCSSVariableValue("--bs-gray-500");
    const borderColor = getCSSVariableValue("--bs-gray-200");
    const baseColor = getCSSVariableValue("--bs-danger");
    const secondaryColor = getCSSVariableValue("--bs-primary");
    const terciaryColor = getCSSVariableValue("--bs-gray-900");

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
          horizontal: true, //mudar para vertical colocar false
          columnWidth: ["30%"],
          endingShape: "rounded",
        },
      },
      legend: { show: true, }, //Legenda do grafico
      dataLabels: { enabled: false, },
      stroke: 
      {
        show: true,
        width: 2,
        colors: ["transparent"],
      },
      xaxis: {
        categories: ["Set", "Out", "Nov", "Dez", "Jan", "Fev"],
        axisBorder: { show: false, },
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
      tooltip: {
        style: { fontSize: "12px", },
        y: {
          formatter: function (val) 
          { 
            return val +" Vendas realizadas"; 
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
        name: props.topvendedor1,
        data: props.consumovendedor1,
      },
      {
        name: props.topvendedor2,
        data: props.consumovendedor2,
      },
      {
        name: props.topvendedor3,
        data: props.consumovendedor3,
      },
    ];

    return {
      options,
      series,
    };
  },
});
</script>
