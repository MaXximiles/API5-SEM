<template>

<div v-if="mostraDiv(1)" class="row gy-5 g-xl-8">
  <div class="col-xxl-5">
    <grafico2 widget-classes="card-xl-stretch mb-xl-8" chart-color="success" chart-height="450"
    :regiaotop1="this.regiaoTop1"
    :regiaotop1consumo="this.regiaoTop1Consumo"
    ></grafico2>
  </div>

  <div class="col-xxl-7">
    <listaDados widget-classes="card-xl-stretch mb-xl-8" chart-color="success" chart-height="450"
    :empresasspc="this.empresasSPC"
    :empresasconcorrente="this.empresasConcorrente"
    :empresaslivres="this.empresasLivres"
    :empresastotal="this.empresasTotal"
    :vendedorestotal="this.vendedoresTotal"
    ></listaDados>
  </div>
</div>

<div v-if="mostraDiv(2)" class="row gy-5 g-xl-8">
    <div class="col-xxl-4">
      <listaUsu widget-classes="card-xl-stretch mb-xl-8" chart-color="success" chart-height="100" 
      :vendedortop1="this.vendedorTop1" :vendedortop1email="this.vendedorTop1Email"
      :vendedortop2="this.vendedorTop2" :vendedortop2email="this.vendedorTop2Email"
      :vendedortop3="this.vendedorTop3" :vendedortop3email="this.vendedorTop3Email"
      :vendedortop4="this.vendedorTop4" :vendedortop4email="this.vendedorTop4Email"
      :vendedortop5="this.vendedorTop5" :vendedortop5email="this.vendedorTop5Email"
      :vendedortop6="this.vendedorTop6" :vendedortop6email="this.vendedorTop6Email"
      :vendedortop7="this.vendedorTop7" :vendedortop7email="this.vendedorTop7Email"
      :vendedortop8="this.vendedorTop8" :vendedortop8email="this.vendedorTop8Email"
      ></listaUsu>
    </div>
  
    <div class="col-xxl-8">
      <grafico widget-classes="card-xl-stretch mb-xl-8" chart-color="success" chart-height="100" 
      :topvendedor1="this.TopVendedor1" 
      :topvendedor2="this.TopVendedor2" 
      :topvendedor3="this.TopVendedor3" 
      :consumovendedor1="this.ArrayTopConsumo1" 
      :mesesconsumo1="this.ArrayTopMesVendedor1" 
      :consumovendedor2="this.ArrayTopConsumo2" 
      :mesesconsumo2="this.ArrayTopMesVendedor2" 
      :consumovendedor3="this.ArrayTopConsumo3" 
      :mesesconsumo3="this.ArrayTopMesVendedor3"
      ></grafico>
    </div>
</div>

<div v-if="mostraDiv(3)" class="row gy-5 g-xl-8">
    <div class="col-xxl-8">
      <grafico1 widget-classes="card-xl-stretch mb-xl-8" chart-color="success" chart-height="100" 
      :empresatop1="this.empresaTop1" 
      :empresatop1consumo="this.empresaTop1Consumo"
      :empresatop2="this.empresaTop2" 
      :empresatop2consumo="this.empresaTop2Consumo"
      :empresatop3="this.empresaTop3" 
      :empresatop3consumo="this.empresaTop3Consumo"
      ></grafico1>
    </div>
    
    <div class="col-xxl-4">
      <listaEmp widget-classes="card-xl-stretch mb-xl-8" chart-color="success" chart-height="100" 
      :empresatop1="this.empresaTop1" :empresatop1cnpj="this.empresaTop1Cnpj"
      :empresatop2="this.empresaTop2" :empresatop2cnpj="this.empresaTop2Cnpj"
      :empresatop3="this.empresaTop3" :empresatop3cnpj="this.empresaTop3Cnpj"
      :empresatop4="this.empresaTop4" :empresatop4cnpj="this.empresaTop4Cnpj"
      :empresatop5="this.empresaTop5" :empresatop5cnpj="this.empresaTop5Cnpj"
      :empresatop6="this.empresaTop6" :empresatop6cnpj="this.empresaTop6Cnpj"
      :empresatop7="this.empresaTop7" :empresatop7cnpj="this.empresaTop7Cnpj"
      :empresatop8="this.empresaTop8" :empresatop8cnpj="this.empresaTop8Cnpj"
      ></listaEmp>
    </div>
</div>

<div v-if="mostraDiv(4)" class="row gy-5 g-xl-8">
    <div class="col">
      <grafico3 widget-classes="card-xl-stretch mb-xl-8" chart-color="success" chart-height="100" 
      :empresa1consumovend="this.empresa1ConsumoVend"
      :empresa2consumovend="this.empresa2ConsumoVend"
      :empresa3consumovend="this.empresa3ConsumoVend"
      :empresa1empresavend="this.empresa1EmpresaVend"
      :empresa2empresavend="this.empresa2EmpresaVend"
      :empresa3empresavend="this.empresa3EmpresaVend"
      :empresatopmesvend="this.empresaTopMesVend"
      ></grafico3>
    </div>
</div>

</template>

<script >
import { onMounted } from "vue";
import { setCurrentPageTitle } from "@/core/helpers/breadcrumb";
import grafico from "@/components/widgets/charts/Widget2.vue";
import grafico1 from "@/components/widgets/charts/Widget2TopEmpresa.vue";
import grafico2 from "@/components/widgets/charts/GraficoPizza.vue";
import grafico3 from "@/components/widgets/charts/Widget1.vue";
import listaUsu from "@/components/widgets/lists/ListaTopVendedor.vue";
import listaEmp from "@/components/widgets/lists/ListaTopEmpresa.vue";
import listaDados from "@/components/widgets/lists/Widget6.vue";
import axios from "axios";

export default {
  name: "dashboard",
  components: 
  { 
    grafico, 
    grafico1,
    grafico2,
    grafico3,
    listaUsu,
    listaEmp,
    listaDados,
  },
  data() {
    return {
      ArrayTopConsumo1: [0, 0, 0, 0, 0, 0],
      ArrayTopMesVendedor1: [],
      TopVendedor1: [""],
      ArrayTopConsumo2: [0, 0, 0, 0, 0, 0],
      ArrayTopMesVendedor2: [],
      TopVendedor2: [""],
      ArrayTopConsumo3: [0, 0, 0, 0, 0, 0],
      ArrayTopMesVendedor3: [],
      TopVendedor3: [""],

      //Grafico Top 8 vendedores
      vendedorTop1: [],
      vendedorTop1Email: [],
      vendedorTop2: [],
      vendedorTop2Email: [],
      vendedorTop3: [],
      vendedorTop3Email: [],
      vendedorTop4: [],
      vendedorTop4Email: [],
      vendedorTop5: [],
      vendedorTop5Email: [],
      vendedorTop6: [],
      vendedorTop6Email: [],
      vendedorTop7: [],
      vendedorTop7Email: [],
      vendedorTop8: [],
      vendedorTop8Email: [],

      // Grafico Top 8 empresas
      empresaTop1: [],
      empresaTop1Cnpj: [],
      empresaTop1Consumo: [0, 0, 0, 0, 0, 0],
      empresaTop2: [],
      empresaTop2Cnpj: [],
      empresaTop2Consumo: [0, 0, 0, 0, 0, 0],
      empresaTop3: [],
      empresaTop3Cnpj: [],
      empresaTop3Consumo: [0, 0, 0, 0, 0, 0],
      empresaTop4: [],
      empresaTop4Cnpj: [],
      empresaTop4Consumo: [0, 0, 0, 0, 0, 0],
      empresaTop5: [],
      empresaTop5Cnpj: [],
      empresaTop5Consumo: [0, 0, 0, 0, 0, 0],
      empresaTop6: [],
      empresaTop6Cnpj: [],
      empresaTop6Consumo: [0, 0, 0, 0, 0, 0],
      empresaTop7: [],
      empresaTop7Cnpj: [],
      empresaTop7Consumo: [0, 0, 0, 0, 0, 0],
      empresaTop8: [],
      empresaTop8Cnpj: [],
      empresaTop8Consumo: [0, 0, 0, 0, 0, 0],
      empresaTopMes: [],

      //Grafico de Regioes
      regiaoTop1: [],
      regiaoTop1Consumo: [],

      //Lista de Dados
      empresasSPC: [],
      empresasConcorrente: [],
      empresasLivres: [],
      empresasTotal: [],
      vendedoresTotal: [],

      //Grafico de Empresas por vendedor
      empresa1ConsumoVend: [],
      empresa2ConsumoVend: [],
      empresa3ConsumoVend: [],
      empresa1EmpresaVend: [],
      empresa2EmpresaVend: [],
      empresa3EmpresaVend: [],
      empresaTopMesVend: [],
    }
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
    },
    async carregarGraficoTopVendedor() 
    {
      this.ArrayTopConsumo1.splice(0, this.ArrayTopConsumo1.length);
      this.ArrayTopMesVendedor1.splice(0, this.ArrayTopMesVendedor1.length);
      this.ArrayTopConsumo2.splice(0, this.ArrayTopConsumo2.length);
      this.ArrayTopMesVendedor2.splice(0, this.ArrayTopMesVendedor2.length);
      this.ArrayTopConsumo3.splice(0, this.ArrayTopConsumo3.length);
      this.ArrayTopMesVendedor3.splice(0, this.ArrayTopMesVendedor3.length);
              
      await axios.get('/carteira/top/vendedor', 
      { headers: { Authorization: `Bearer ${localStorage.getItem("id_token")}`, Accept: 'application/json' } })
      .then(res => {
        let cons1 = [0, 0, 0, 0, 0, 0];
        let mes1 = [0, 0, 0, 0, 0, 0];
        let cons2 = [0, 0, 0, 0, 0, 0];
        let mes2 = [0, 0, 0, 0, 0, 0];
        let cons3 = [0, 0, 0, 0, 0, 0];
        let mes3 = [0, 0, 0, 0, 0, 0];
        let counter = 0;
        let top = 0;
           
        res.data.forEach(carteira => { 
          
          // Pegando nome dos Vendedores
          carteira.usuario.forEach(usu => {
              if(top == 0){ this.TopVendedor1.push(usu.usunome);}
              if(top == 1){ this.TopVendedor2.push(usu.usunome);}
              if(top == 2){ this.TopVendedor3.push(usu.usunome);}
          })                 
          
          //Pegando meses e consumo por vendedores
          carteira.consumo.forEach(cons => {
            if(top == 0)
            {
              cons1[counter] = cons1[counter] + parseInt(cons.cons_qtdconsumo);
              var data = cons.cons_mes.split(" ")[0];
              var data = data.split("/");
              mes1[counter] = data[1]+" "+data[2];
            }
            if(top == 1)
            {
              cons2[counter] = cons2[counter] + parseInt(cons.cons_qtdconsumo);
              var data = cons.cons_mes.split(" ")[0];
              var data = data.split("/");
              mes2[counter] = data[1]+" "+data[2];
            }
            if(top == 2)
            {
              cons3[counter] = cons3[counter] + parseInt(cons.cons_qtdconsumo);
              var data = cons.cons_mes.split(" ")[0];
              var data = data.split("/");
              mes3[counter] = data[1]+" "+data[2];
            }
            counter += 1;
          });
          counter = 0; 
          top += 1;
        });
            cons1.forEach(cont1 => {this.ArrayTopConsumo1.push(cont1);})
            mes1.forEach(cont2 => {this.ArrayTopMesVendedor1.push(cont2);})
            
            cons2.forEach(cont3 => {this.ArrayTopConsumo2.push(cont3);})
            mes2.forEach(cont4 => {this.ArrayTopMesVendedor2.push(cont4);})

            cons3.forEach(cont5 => {this.ArrayTopConsumo3.push(cont5);})
            mes3.forEach(cont6 => {this.ArrayTopMesVendedor3.push(cont6);})
     })
      .catch(error => console.log(error))
    },
    async carregarGraficoTop8Vendedor() 
    {   
      await axios.get('/carteira/top/vendedores', 
      { headers: { Authorization: `Bearer ${localStorage.getItem("id_token")}`, Accept: 'application/json' } })
      .then(res => {
       let top = 0;
        res.data.forEach(carteira => {
          carteira.usuario.forEach(usu => {
              if(top == 0)
              { 
                this.vendedorTop1.push(usu.usunome);
                this.vendedorTop1Email.push(usu.usuemail);
              }
              if(top == 1)
              { 
                this.vendedorTop2.push(usu.usunome);
                this.vendedorTop2Email.push(usu.usuemail);
              }
              if(top == 2)
              { 
                this.vendedorTop3.push(usu.usunome);
                this.vendedorTop3Email.push(usu.usuemail);
              }
              if(top == 3)
              { 
                this.vendedorTop4.push(usu.usunome);
                this.vendedorTop4Email.push(usu.usuemail);
              }
              if(top == 4)
              { 
                this.vendedorTop5.push(usu.usunome);
                this.vendedorTop5Email.push(usu.usuemail);
              }
              if(top == 5)
              { 
                this.vendedorTop6.push(usu.usunome);
                this.vendedorTop6Email.push(usu.usuemail);
              }
              if(top == 6)
              { 
                this.vendedorTop7.push(usu.usunome);
                this.vendedorTop7Email.push(usu.usuemail);
              }
              if(top == 7)
              { 
                this.vendedorTop8.push(usu.usunome);
                this.vendedorTop8Email.push(usu.usuemail);
              }
          })                 
          top += 1;
        });

     })
      .catch(error => console.log(error))
    },
    async carregarGraficoTopEmpresas()
    {      
      this.empresaTop1Consumo.splice(0, this.empresaTop1Consumo.length);
      this.empresaTop2Consumo.splice(0, this.empresaTop2Consumo.length);
      this.empresaTop3Consumo.splice(0, this.empresaTop3Consumo.length);
      this.empresaTop4Consumo.splice(0, this.empresaTop4Consumo.length);
      this.empresaTop5Consumo.splice(0, this.empresaTop5Consumo.length);
      this.empresaTop6Consumo.splice(0, this.empresaTop6Consumo.length);
      this.empresaTop7Consumo.splice(0, this.empresaTop7Consumo.length);
      this.empresaTop8Consumo.splice(0, this.empresaTop8Consumo.length);
      this.empresaTopMes.splice(0,this.empresaTopMes);

      await axios.get('/carteira/top/vendedores', 
      { headers: { Authorization: `Bearer ${localStorage.getItem("id_token")}`, Accept: 'application/json' } })
      .then(res => {

        let cons1 = [0, 0, 0, 0, 0, 0];
        let mes1 = [0, 0, 0, 0, 0, 0];
        let cons2 = [0, 0, 0, 0, 0, 0];
        let mes2 = [0, 0, 0, 0, 0, 0];
        let cons3 = [0, 0, 0, 0, 0, 0];
        let mes3 = [0, 0, 0, 0, 0, 0];
        let counter = 0;
        let top = 0;
       
        res.data.forEach(carteira => {
          carteira.empresa.forEach(emp => {
              if(top == 0){ this.empresaTop1.push(emp.empnome); this.empresaTop1Cnpj.push(emp.empcnpj);}
              if(top == 1){ this.empresaTop2.push(emp.empnome); this.empresaTop2Cnpj.push(emp.empcnpj);}
              if(top == 2){ this.empresaTop3.push(emp.empnome); this.empresaTop3Cnpj.push(emp.empcnpj);}
              if(top == 3){ this.empresaTop4.push(emp.empnome); this.empresaTop4Cnpj.push(emp.empcnpj);}
              if(top == 4){ this.empresaTop5.push(emp.empnome); this.empresaTop5Cnpj.push(emp.empcnpj);}
              if(top == 5){ this.empresaTop6.push(emp.empnome); this.empresaTop6Cnpj.push(emp.empcnpj);}
              if(top == 6){ this.empresaTop7.push(emp.empnome); this.empresaTop7Cnpj.push(emp.empcnpj);}
              if(top == 7){ this.empresaTop8.push(emp.empnome); this.empresaTop8Cnpj.push(emp.empcnpj);}
          })                 
          
          carteira.consumo.forEach(cons => {
            if(top == 0)
            {
              cons1[counter] = cons1[counter] + parseInt(cons.cons_qtdconsumo);
              var data = cons.cons_mes.split(" ")[0];
              var data = data.split("/");
              mes1[counter] = data[1]+" "+data[2];
            }
            if(top == 1)
            {
              cons2[counter] = cons2[counter] + parseInt(cons.cons_qtdconsumo);
              var data = cons.cons_mes.split(" ")[0];
              var data = data.split("/");
              mes2[counter] = data[1]+" "+data[2];
            }
            if(top == 2)
            {
              cons3[counter] = cons3[counter] + parseInt(cons.cons_qtdconsumo);
              var data = cons.cons_mes.split(" ")[0];
              var data = data.split("/");
              mes3[counter] = data[1]+" "+data[2];
            }
            counter += 1;
          });
          counter = 0; 
          top += 1;
        })
        cons1.forEach(cont1 => {this.empresaTop1Consumo.push(cont1);})
        cons2.forEach(cont3 => {this.empresaTop2Consumo.push(cont3);})
        cons3.forEach(cont5 => {this.empresaTop3Consumo.push(cont5);})
        mes1.forEach(cont2 => {this.empresaTopMes.push(cont2);})
     })
      .catch(error => console.log(error))

    },
    async carregarGraficoTopRegiao()
    {      
      this.regiaoTop1.splice(0, this.regiaoTop1.length);
      this.regiaoTop1Consumo.splice(0, this.regiaoTop1Consumo.length);
     
      await axios.get('/carteira/top/regiao', 
      { headers: { Authorization: `Bearer ${localStorage.getItem("id_token")}`, Accept: 'application/json' } })
      .then(res => {
      
        res.data.forEach(carteira => {

          carteira.cidade.forEach(reg => { this.regiaoTop1.push(reg.cid_regiaoibge); })
          
          this.regiaoTop1Consumo.splice(0, this.regiaoTop1Consumo.length);
          carteira.consumo.forEach(cons => { 
            var consumo = cons.cons_qtdconsumo.split(".")[0];
            this.regiaoTop1Consumo.push(parseInt(consumo)); 
          });
        })
     })
      .catch(error => console.log(error))
    },
    async carregarDadosSistema()
    {
      this.empresasSPC.splice(0, this.empresasSPC.length);
      this.empresasConcorrente.splice(0, this.empresasConcorrente.length);
      this.empresasLivres.splice(0, this.empresasLivres.length);
      this.empresasTotal.splice(0, this.empresasTotal.length);

      await axios.get('/empresas/', 
      { headers: { Authorization: `Bearer ${localStorage.getItem("id_token")}`, Accept: 'application/json' } })
      .then(res => {
        var spc = 0;
        var livre = 0;
        var concorrente = 0;
        var total = 0;

        res.data.forEach(empresa => {
            if(empresa.emporigem == "SPC") { spc += 1; }
            if(empresa.emporigem == "LIVRE") { livre += 1; }
            if(empresa.emporigem == "CONCORRENTE") { concorrente += 1; }
            total += 1;
        })
         this.empresasSPC.push(spc);
         this.empresasConcorrente.push(concorrente);
         this.empresasLivres.push(livre);
         this.empresasTotal.push(total);
      })

      await axios.get('/usuario/', 
      { headers: { Accept: 'application/json' } })
      .then(res => {
        var total = 0;

        res.data.forEach(usuario => {
            if(usuario.usunivel == "Vendedor") { total += 1; }          
        })
         this.vendedoresTotal.push(total);
      })

    },
    async carregarGraficoEmpresasVendedor()
    {
      this.empresa1ConsumoVend.splice(0, this.empresa1ConsumoVend.length);
      this.empresa2ConsumoVend.splice(0, this.empresa2ConsumoVend.length);
      this.empresa3ConsumoVend.splice(0, this.empresa3ConsumoVend.length);
      this.empresaTopMesVend.splice(0, this.empresaTopMesVend.length);

      var idUsu = localStorage.getItem("loginId");

      await axios.get('carteira/carteira/vendedor?idvende='+idUsu, 
      { headers: { Authorization: `Bearer ${localStorage.getItem("id_token")}`, Accept: 'application/json' } })
      .then(res => {

        let cons1 = [0, 0, 0, 0, 0, 0];
        let mes1 = [0, 0, 0, 0, 0, 0];
        let cons2 = [0, 0, 0, 0, 0, 0];
        let mes2 = [0, 0, 0, 0, 0, 0];
        let cons3 = [0, 0, 0, 0, 0, 0];
        let mes3 = [0, 0, 0, 0, 0, 0];
        let counter = 0;
        let top = 0;
       
        res.data.forEach(carteira => {
          carteira.empresa.forEach(emp => {
              if(top == 0){ this.empresa1EmpresaVend.push(emp.empnome); }
              if(top == 1){ this.empresa2EmpresaVend.push(emp.empnome); }
              if(top == 2){ this.empresa3EmpresaVend.push(emp.empnome); }
          })                 
          
          carteira.consumo.forEach(cons => {
            if(top == 0)
            {
              cons1[counter] = cons1[counter] + parseInt(cons.cons_qtdconsumo);
              var data = cons.cons_mes.split(" ")[0];
              var data = data.split("/");
              mes1[counter] = data[1]+" "+data[2];
            }
            if(top == 1)
            {
              cons2[counter] = cons2[counter] + parseInt(cons.cons_qtdconsumo);
              var data = cons.cons_mes.split(" ")[0];
              var data = data.split("/");
              mes2[counter] = data[1]+" "+data[2];
            }
            if(top == 2)
            {
              cons3[counter] = cons3[counter] + parseInt(cons.cons_qtdconsumo);
              var data = cons.cons_mes.split(" ")[0];
              var data = data.split("/");
              mes3[counter] = data[1]+" "+data[2];
            }
            counter += 1;
          });
          counter = 0; 
          top += 1;
        })
        cons1.forEach(cont1 => {this.empresa1ConsumoVend.push(cont1);})
        cons2.forEach(cont3 => {this.empresa2ConsumoVend.push(cont3);})
        cons3.forEach(cont5 => {this.empresa3ConsumoVend.push(cont5);})
        mes1.forEach(cont2 => {this.empresaTopMesVend.push(cont2);})
     })
      .catch(error => console.log(error))
    },
    mostraDiv(div)
    {
      var nivelUsu = localStorage.getItem("loginNivel");

      if(div == 1 && nivelUsu != "Vendedor"){return true;}
      if(div == 2 && nivelUsu != "Vendedor"){return true;}
      if(div == 3 && nivelUsu != "Administrador"){return true;}
      if(div == 4 && nivelUsu == "Vendedor"){return true;}
    },
  },
  created() 
  { 
    this.recarregarPagina();
    this.carregarGraficoTopVendedor();
    this.carregarGraficoTop8Vendedor();
    this.carregarGraficoTopEmpresas();
    this.carregarGraficoTopRegiao();
    this.carregarDadosSistema();
    this.carregarGraficoEmpresasVendedor();
  },
  setup() 
  {
    onMounted(() => { setCurrentPageTitle("Dashboard"); });
  },
};
</script>
