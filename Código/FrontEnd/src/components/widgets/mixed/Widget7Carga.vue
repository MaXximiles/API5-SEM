<template>
 <MixedWidget7Carga widget-classes="card-xxl-stretch-50 mb-5 mb-xl-8" chart-color="primary" chart-height="150" :meses="this.ArrayMeses" :consumo="this.ArrayConsumo" :total="this.consumoTotal"></MixedWidget7Carga>
</template>

<script>
import axios from "axios";

export default {
  name: "widget-7",
  data()
  {
    return {
      loaded: false,
      ArrayConsumo: [],
	    ArrayMeses: [],
	    ArrayCidades: [],
      meses: [],
	    ArrayCnaes: [],
      ConsumoTotal: 0
    }
  }, 
  async mounted()// Carregando informações no grafico de forma assincrona
  {
    const {data} = await axios.get('consumo/', { headers: { Accept: 'application/json' } });
    data.forEach(consumo => 
    {
      var data = consumo.cons_mes.split(" ")[0];
      var data = data.split("/");

      this.ConsumoTotal =  parseInt(this.ConsumoTotal) + parseInt(consumo.cons_qtdconsumo);
      this.ArrayMeses.push(data[1]+"/"+data[2]);
      this.ArrayConsumo.push(consumo.cons_qtdconsumo);
    });
    this.loaded = true;
  },  
};
</script>
