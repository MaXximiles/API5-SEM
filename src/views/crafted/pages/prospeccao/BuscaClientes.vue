<template>
  <!--begin::Dashboard-->

  <div class="row g-5 gx-xxl-8" >
    
    <div class="col">
      <div class="card card-xl-stretch-50 mb-5 mb-x1-8" >
      <MixedWidget5Cnae widget-classes="card-xl-stretch mb-xl-8" chart-color="red" chart-height="100" :mesesCnae="this.ArrayMesesCnae" :consumoCnae="this.ArrayConsumoCnae" :totalCnae="this.ConsumoTotalCnae"></MixedWidget5Cnae>
      </div>
    </div>
    
    <div class="col">
      <div class="card card-xl-stretch-50 mb-5 mb-xl-8">
      <MixedWidget5Regiao widget-classes="card-xl-stretch mb-xl-8" chart-color="success" chart-height="100" :mesesRegiao="this.ArrayMesesRegiao" :consumoRegiao="this.ArrayConsumoRegiao" :totalRegiao="this.ConsumoTotalRegiao"></MixedWidget5Regiao>
      </div>
    </div>

  </div>

  <div class="row g-5 gx-xxl-8" >

        <div class="col" >
          <span class="svg-icon svg-icon-1 position-absolute ms-6">
					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
					<rect opacity="0.5" x="17.0365" y="15.1223" width="8.15546" height="2" rx="1" transform="rotate(45 17.0365 15.1223)" fill="currentColor"></rect>
					<path d="M11 19C6.55556 19 3 15.4444 3 11C3 6.55556 6.55556 3 11 3C15.4444 3 19 6.55556 19 11C19 15.4444 15.4444 19 11 19ZM11 5C7.53333 5 5 7.53333 5 11C5 14.4667 7.53333 17 11 17C14.4667 17 17 14.4667 17 11C17 7.53333 14.4667 5 11 5Z" fill="currentColor"></path>
					</svg>
					</span>

          <input type="text" @keyup="carregaFiltros()" v-model="pesqemp" data-kt-user-table-filter="search"  class="form-control form-control-solid ps-14" placeholder="Pesquisar Empresas">
        </div>

        <div class="col" >
          <select id="cidid" @change="carregarSelectCnae()" name="cidid" v-model="cidid" aria-label="Selecione a cidade" data-control="select2" data-placeholder="Selecione a Cidade" class="form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible  ps-14" data-select2-id="select2-data-10-0g0q" tabindex="-1" aria-hidden="true">
          <option value="" data-select2-id="select2-data-12-5j0j"> Selecione a Região </option>
          <option v-for="cidade in CidadesSelect" v-bind:key="cidade.cidade[0].cid_regiaoibge" :value="cidade.cidade[0].cid_regiaoibge">{{ "REGIÃO "+cidade.cidade[0].cid_regiaoibge }}</option>
          </select>
        </div>

        <div class="col" >
          <select  id="cnaeid" @change="carregarSelectRegiao()" name="cnaeid" v-model="cnaeid" aria-label="Selecione o Cnae da empresa" data-control="select2" data-placeholder="Selecione o CNAE da sua empresa" class="form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible  ps-14" data-select2-id="select2-data-10-0g0q" tabindex="-1" aria-hidden="true">
          <option value="" data-select2-id="select2-data-12-5j0j">  Selecione o Cnae   </option>
          <option v-for="cnaes in CnaeSelect" v-bind:key="cnaes.cnae[0].cnae_codigo" :value="cnaes.cnae[0].cnae_codigo" >{{ cnaes.cnae[0].cnae_codigo + " - " + cnaes.cnae[0].cnae_descricao }}</option>
          </select>
        </div>

        <div class="col" >
          <button type="button" class="btn btn-light-primary me-3" data-kt-menu-trigger="click" data-kt-menu-placement="bottom-end" @click="carregaFiltros()">
              <span class="svg-icon svg-icon-2">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
                  <path d="M19.0759 3H4.72777C3.95892 3 3.47768 3.83148 3.86067 4.49814L8.56967 12.6949C9.17923 13.7559 9.5 14.9582 9.5 16.1819V19.5072C9.5 20.2189 10.2223 20.7028 10.8805 20.432L13.8805 19.1977C14.2553 19.0435 14.5 18.6783 14.5 18.273V13.8372C14.5 12.8089 14.8171 11.8056 15.408 10.964L19.8943 4.57465C20.3596 3.912 19.8856 3 19.0759 3Z" fill="currentColor"></path>
                </svg>
              </span>
              Filtrar
          </button>
        </div>

  </div>

  <div class="row g-5 gx-xl-8">
    <div class="col">
      <br>
      <MixedWidget7 widget-classes="card-xxl-stretch-50 mb-5 mb-xl-8" chart-color="primary" chart-height="150" :meses="this.ArrayMeses" :consumo="this.ArrayConsumo" :total="this.consumoTotal"></MixedWidget7>
    </div>
  </div>

  <div class="row g-5 gx-xxl-8">
    <div class="col">
      
        <div class="card-body d-flex flex-column p-0">
         
        <!--begin::Table-->
        <div id="kt_table_users_wrapper" class="dataTables_wrapper dt-bootstrap4 no-footer">
        <div class="table-responsive">
        <table class="table align-middle table-row-dashed fs-6 gy-5 dataTable no-footer" id="kt_table_empresas">

        <thead>
        <tr class="text-start text-muted fw-bolder fs-7 text-uppercase gs-0">
        <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" style="width: 212.875px;">CNPJ</th>
        <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" style="width: 125px;">EMPRESA</th>
        <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" style="width: 125px;">CNAE</th>
        <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" style="width: 125px;">ORIGEM</th>
        <th class="text-end min-w-100px sorting_disabled" rowspan="1" colspan="1" aria-label="Actions" style="width: 100px;">AÇÕES</th>
        </tr>
        </thead>

        <tbody class="text-gray-600 fw-bold">

        <tr class="odd" v-for="empresa in ArrayEmpresas" :key="empresa.empid">
        <td class="align-items-center">
        <div class="d-flex flex-column">
        <span>{{ empresa.empcnpj }}</span>
        </div>
        </td>

        <td class="align-items-center">
        <div class="d-flex flex-column">
        <span>{{ empresa.empnome }}</span>
        </div>
        </td>

        <td class="align-items-center">
        <div class="d-flex flex-column">
        <span>{{ empresa.cnae[0].cnae_codigo + " - " + empresa.cnae[0].cnae_descricao }}</span>

        </div>
        </td>

        <td class="align-items-center">
        <div class="d-flex flex-column">
        <span>{{ empresa.emporigem }}</span>
        </div>
        </td>

        <td class="text-center">
          <!--Carregar Grafico-->
          <a @click="carregarConsumo(empresa)" v-if="mostraBotao(empresa)" class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1" >
            <span class="bi bi-graph-down fs-2x text-gray-700"></span>
          </a>

          <!--Carregar Carteira vendedor-->
          <a  v-if="mostraBotao2(empresa)" class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1" >
            <span class="bi bi-diagram-3 fs-2x text-gray-700"></span>
          </a>
        </td>
        </tr>

        </tbody>

        </table>
        </div>
        <div class="row"><div class="col-sm-12 col-md-5 d-flex align-items-center justify-content-center justify-content-md-start"></div>
        <div class="col-sm-12 col-md-7 d-flex align-items-center justify-content-center justify-content-md-end">
        </div>
        </div>
        </div>
        </div>

    </div>
  </div>

</template>

<script>
import { defineComponent, ref, onMounted } from "vue";
import MixedWidget5Cnae from "@/components/widgets/mixed/Widget5Cnae.vue";
import MixedWidget5Regiao from "@/components/widgets/mixed/Widget5Regiao.vue";
import MixedWidget7 from "@/components/widgets/mixed/Widget7.vue";
import TableWidget9 from "@/components/widgets/tables/Widget9.vue";
import { setCurrentPageTitle } from "@/core/helpers/breadcrumb";
import axios from "axios";

export default defineComponent({
  name: "Gerenciar Empresa",
  components: {
    TableWidget9,
    MixedWidget5Cnae,
    MixedWidget5Regiao,
    MixedWidget7,
  },
  data()
  {
    return {
      empid: '',
      empnome: '', 
      empcnpj: '',
      cidid: '',
      cnaeid: '',
      emporigem: '',
      cnae_descricao: '',
      cnae_codigo: '',
      pesqemp: '',
      ArrayEmpresas: [],
	    ArrayCidades: [],
	    ArrayCnaes: [],
      CidadesSelect: [],
      CnaeSelect: [],
      
      //Grafico de consumo por empresa
      loaded: false,
      ArrayConsumo: [0, 0, 0, 0, 0, 0],
	    ArrayMeses: [0, 0, 0, 0, 0, 0],
	    ArrayCidades: [],
      meses: [],
	    ArrayCnaes: [],
      cnpj: '',
      ConsumoTotal: 0,

      //Grafico de consumo por cnae
      grafCnae: [],
      CnaeArray: [],
      ArrayConsumoCnae: [0, 0, 0, 0, 0, 0],
	    ArrayMesesCnae: [0, 0, 0, 0, 0, 0],
	    ArrayCidadesCnae: [0, 0, 0, 0, 0, 0],
      mesesCnae: [0, 0, 0, 0, 0, 0],
      ConsumoTotalCnae: 0,

      //Grafico de consumo por regiao 
      CidadesArray: [],
      grafRegiao: [],
      RegiaoArray: [],
      ArrayConsumoRegiao: [0, 0, 0, 0, 0, 0],
	    ArrayMesesRegiao: [0, 0, 0, 0, 0, 0],
	    ArrayCidadesRegiao: [0, 0, 0, 0, 0, 0],
      mesesRegiao: [0, 0, 0, 0, 0, 0],
      ConsumoTotalRegiao: 0,
    } 
  },
  methods:
  {
    carregarSelectCnae()
    {
      if(cidid.value!='')
      {
        this.CnaeSelect = []
        this.CnaeArray.forEach(item=>{
          if(item.cidade[0].cid_regiaoibge == cidid.value){ this.CnaeSelect.push(item) }
        })
      }
      else { this.CnaeSelect = this.CnaeArray }
    },
    carregarSelectRegiao(){
    if(cnaeid.value!='')
      {
         this.CidadesArray.forEach(item=>{
          if(item.cnae[0].cnae_codigo == cnaeid.value.split(" ")[0]){this.CidadesSelect.push(item)}
        })
      }
      else{ this.CidadesSelect = this.CidadesArray }
    },
    carregarEmpresas() // Lista empresas na tabela
    {
      axios.get('empresas/', 
          { headers: { Accept: 'application/json' } })
          .then(res => {
            this.ArrayEmpresas = res.data
          })
          .catch(error => console.log(error))
    },
    carregarCnae() // Carregando select somente com cnaes que possuem empresas
    {
      axios.get('empresas/ordem', 
          { headers: { Accept: 'application/json' } })
          .then(res => {
            this.CnaeArray = res.data;
            this.CnaeSelect = this.CnaeArray;
          })
          .catch(error => console.log(error))
    },
    carregarCidades() // Carregando select somente cpm cidades que possuem empresas
    {
      axios.get('empresas/cidades', 
          { headers: { Accept: 'application/json' } })
          .then(res => {
            this.CidadesArray = res.data
            this.CidadesSelect = this.CidadesArray;
          })
          .catch(error => console.log(error))
         
    },
    mostraBotao(empresa)
    { 
        if(empresa.emporigem == "LIVRE"){return false}
        else{return true}
    },
    mostraBotao2(empresa)
    { 
        if(empresa.emporigem == "LIVRE"){return true}
        else{return false}
    },
    carregarConsumo(empresa)//Carregando grafico de consumo por empresa
    {
      axios.get('consumo/cnpj?cnpj='+empresa.empcnpj, 
          { headers: { Accept: 'application/json' } })
          .then(res => {
            this.ArrayConsumo.splice(0, this.ArrayConsumo.length);
            this.ArrayMeses.splice(0, this.ArrayMeses.length);
            res.data.forEach(consumo => {
                var data = consumo.cons_mes.split(" ")[0];
                var data = data.split("/");
                
               this.ConsumoTotal = parseInt(this.ConsumoTotal) + parseInt(consumo.cons_qtdconsumo);
               this.ArrayMeses.push(data[1]+" "+data[2]);
               this.ArrayConsumo.push(consumo.cons_qtdconsumo);
            });
          })
          .catch(error => console.log(error))
    },
    carregaGraficoCnae()
    {    
      var cod;
      if(cnaeid.value == "") {cod = cnaeid.value.split(" ")[1];}
      else{cod = cnaeid.value.split(" ")[0];}

      this.ArrayConsumoRegiao.length = 0;
      this.ArrayMesesRegiao.length = 0;
      this.ArrayConsumoRegiao.splice(0,this.ArrayConsumoRegiao.length);
      this.ArrayMesesRegiao.splice(0,this.ArrayMesesRegiao.length);

      this.ArrayConsumoCnae.length = 0;
      this.ArrayMesesCnae.length = 0;
      this.ArrayConsumoCnae.splice(0, this.ArrayConsumoCnae.length);
      this.ArrayMesesCnae.splice(0, this.ArrayMesesCnae.length);

      axios.get('empresas/cnae?cnae='+cod, 
      { headers: { Accept: 'application/json' } })
      .then(res => {
        let test = [0, 0, 0, 0, 0, 0];
        let tmes = [0, 0, 0, 0, 0, 0];
        let counter = 0;
            res.data.forEach(empresa => {
               
                  empresa.consumo.forEach(cons => {
                      test[counter] = test[counter] + parseInt(cons.cons_qtdconsumo);

                      var data = cons.cons_mes.split(" ")[0];
                      var data = data.split("/");
                      tmes[counter] = data[1]+" "+data[2];
                      counter += 1;
                  });
                  counter = 0;
            });

            test.forEach(cont1 => {this.ArrayConsumoCnae.push(cont1);})
            tmes.forEach(cont2 => {this.ArrayMesesCnae.push(cont2);})
      })
      .catch(error => console.log(error))
    },
    carregaGraficoRegiao()
    {   
      var regiao;

      if(cidid.value == "") {regiao = cidid.value.split(" ")[1];}
      else{regiao = cidid.value;}

      this.ArrayConsumoCnae.length = 0;
      this.ArrayMesesCnae.length = 0;
      this.ArrayConsumoCnae.splice(0, this.ArrayConsumoCnae.length);
      this.ArrayMesesCnae.splice(0, this.ArrayMesesCnae.length);

      this.ArrayConsumoRegiao.length = 0;
      this.ArrayMesesRegiao.length = 0;
      this.ArrayConsumoRegiao.splice(0,this.ArrayConsumoRegiao.length);
      this.ArrayMesesRegiao.splice(0,this.ArrayMesesRegiao.length);

      axios.get('empresas/regiao?regiao='+regiao, 
      { headers: { Accept: 'application/json' } })
      .then(res => {
        let test = [0, 0, 0, 0, 0, 0];
        let tmes = [0, 0, 0, 0, 0, 0];
        let counter = 0;
            res.data.forEach(empresa => {

                empresa.consumo.forEach(cons => {
                    test[counter] = test[counter] + parseInt(cons.cons_qtdconsumo);

                    var data = cons.cons_mes.split(" ")[0];
                    var data = data.split("/");
                    tmes[counter] = data[1]+" "+data[2];

                    counter += 1;
                });
                counter = 0 
             });

            test.forEach(cont3 => {this.ArrayConsumoRegiao.push(cont3);})
            tmes.forEach(cont4 => {this.ArrayMesesRegiao.push(cont4);})

      })
      .catch(error => console.log(error))
    },
    carregaFiltros()
    {
      var regiao = '';
      var cnae =  '';

      if(cnaeid.value != ""){cnae = cnaeid.value.split(" ")[0];}
      if(cidid.value != ""){regiao = cidid.value;}
     
      var nome = this.pesqemp;
      
      axios.get('empresas/filtros?regiao='+regiao+'&nome='+nome+'&cnae='+cnae, 
      { headers: { Accept: 'application/json' } })
      .then(res => {
        this.ArrayEmpresas = res.data
      })
      .catch(error => console.log(error))

      this.carregaGraficoCnae();
      this.carregaGraficoRegiao();
    },
    limparGraficos(qual)
    {
      if(qual == 1)
      {
        //Grafico de consumo por empresa
        ArrayConsumo.length = 0;
        ArrayMeses.length = 0;
        ArrayCidades.length = 0;
        meses.length = 0;
        ArrayCnaes.length = 0;
        cnpj.length = 0;
        ConsumoTotal.length = 0;
      }
      if(qual == 2)
      {
        //Grafico de consumo por cnae
        grafCnae.length = 0;
        CnaeArray.length = 0;
        ArrayConsumoCnae.length = 0;
        ArrayMesesCnae.length = 0;
        ArrayCidadesCnae.length = 0;
       mesesCnae.length = 0;
      }
      if(qual == 3)
      {
        //Grafico de consumo por regiao 
        CidadesArray.length = 0;
        grafRegiao.length = 0;
        RegiaoArray.length = 0;
        ArrayConsumoRegiao.length = 0;
        ArrayMesesRegiao.length = 0;
        ArrayCidadesRegiao.length = 0;
        mesesRegiao.length = 0;
      }
    },
    pesquisarEmpresas() // Pesquisa de empresas por nome
    {
      axios.get('empresas/filtronome?nome='+this.pesqemp, 
          { headers: { Accept: 'application/json' } })
          .then(res => {
            this.ArrayEmpresas = res.data
          })
          .catch(error => console.log(error))
    },    
  },
  created () 
  {    
    this.carregarEmpresas();
    this.carregarCnae();
    this.carregarCidades();
  }, 
  setup() { onMounted(() => { setCurrentPageTitle("Gerenciar Empresas/Vendedores"); }); },
});
</script>
