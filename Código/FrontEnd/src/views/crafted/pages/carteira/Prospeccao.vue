<template>

  <div class="row g-5 gx-xl-8" ><!-- Carteiras -->
  <!--begin::Stats-->
      <div class="flex-grow-1 card-p pb-0 row bg-secondary rounded">
        <div class="d-flex flex-stack flex-wrap">
          <div class="me-2">
            <a class="text-dark text-hover-primary fw-bolder fs-3">Carteiras Pendentes</a>

            <div class="text-muted fs-7 fw-bold">
              Lista de empresas aguardando aprovação.
            </div>
          </div>

        </div>
      </div>
      <!--end::Stats-->

  <div class="row"> <br> </div>

  <div class="row" >
    
    <div class="col" >
      <span class="svg-icon svg-icon-1 position-absolute ms-6">
      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
      <rect opacity="0.5" x="17.0365" y="15.1223" width="8.15546" height="2" rx="1" transform="rotate(45 17.0365 15.1223)" fill="currentColor"></rect>
      <path d="M11 19C6.55556 19 3 15.4444 3 11C3 6.55556 6.55556 3 11 3C15.4444 3 19 6.55556 19 11C19 15.4444 15.4444 19 11 19ZM11 5C7.53333 5 5 7.53333 5 11C5 14.4667 7.53333 17 11 17C14.4667 17 17 14.4667 17 11C17 7.53333 14.4667 5 11 5Z" fill="currentColor"></path>
      </svg>
      </span>

      <input type="text" v-model="pesqempresa" @keyup="pesquisaCarteirasConcluidas()" data-kt-user-table-filter="search"  class="form-control form-control-solid ps-14" placeholder="Pesquisar Empresa">
    </div>
  </div>

  <div class="row">
    <div class="col scroll-y" style="overflow: auto; height: 400px;">

      <div class="card-body py-4">
        <!--begin::Table-->
        <div id="kt_table_users_wrapper" class="dataTables_wrapper dt-bootstrap4 no-footer">
        <div class="table-responsive">
        <table class="table align-middle table-row-dashed fs-6 gy-5 dataTable no-footer" id="kt_table_empresas">

          <thead>
            <tr class="text-start text-muted fw-bolder fs-7 text-uppercase gs-0">
              <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" >EMPRESA</th>
              <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" >CNPJ</th>
              <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" >CNAE</th>
              <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" >DATA CONVITE</th>
              <th class="min-w-100px sorting_disabled" rowspan="1" colspan="1" aria-label="Actions" style="width: 100px;">AÇÕES</th>
            </tr>
          </thead>

        <tbody class="text-gray-600 fw-bold">

          <tr class="odd" v-for="carteira in ArrayCarteira" :key="carteira.cartid">
            <td class="align-items-center">
              <div class="d-flex flex-column">
              <span>{{ carteira.empresa[0].empnome }}</span>
              </div>
            </td>

            <td class="align-items-center">
              <div class="d-flex flex-column">
              <span>{{ carteira.empresa[0].empcnpj }}</span>
              </div>
            </td>

            <td class="align-items-center">
              <div class="d-flex flex-column">
              <span>{{ carteira.cnae[0].cnae_codigo + " - " + carteira.cnae[0].cnae_descricao }}</span>
              </div>
            </td>

            <td class="align-items-center">
              <div class="d-flex flex-column">
              <span>{{ carteira.cartdataini }}</span>
              </div>
            </td>

            <td>
              <div class='col ' >

                <button  type="button" class="btn btn-secondary" @click="carregarModal(carteira)" data-bs-toggle="modal" data-bs-target="#kt_modal_vercarteira">
                <span class="bi bi-info-circle fs-1x text-gray-700" ></span>
                </button>     
          
              </div>
            </td>

          </tr>
        </tbody>
      </table>
    </div>
          
          <div class="row"><div class="col-sm-12 col-md-5 d-flex align-items-center justify-content-center justify-content-md-start"></div>
          <div class="col-sm-12 col-md-7 d-flex align-items-center justify-content-center justify-content-md-end"> </div>

        </div>
        </div>
        </div>		
        </div>
  </div>
</div>

<!-- MODAL  VER PROSPECCAO -->

	<div class="modal fade" id="kt_modal_vercarteira" tabindex="-1" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered mw-750px">
	<div class="modal-content">
	<div class="modal-header" id="kt_modal_add_user_header">
	<h2 class="fw-bolder">Carteira de Vendedor</h2>


	<!-- BOTÃO FECHAR (X) QUE ESTA FUNCIONANDO -->
	<div class="btn btn-sm btn-icon btn-active-color-primary" id="fecharModal" data-bs-dismiss="modal">
	<span class="svg-icon svg-icon-1">
	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
	<rect opacity="0.5" x="6" y="17.3137" width="16" height="2" rx="1" transform="rotate(-45 6 17.3137)" fill="currentColor"></rect>
	<rect x="7.41422" y="6" width="16" height="2" rx="1" transform="rotate(45 7.41422 6)" fill="currentColor"></rect>
	</svg>
	</span>
	</div>
	<!-- BOTÃO FECHAR (X) QUE ESTA FUNCIONANDO -->

	</div>

	<div class="modal-body scroll-y mx-5 mx-xl-15 my-7">
	<form id="kt_modal_carteira" class="form fv-plugins-bootstrap5 fv-plugins-framework" >
	<div class="d-flex flex-column scroll-y me-n7 pe-7" id="kt_modal_add_user_scroll" data-kt-scroll="true" data-kt-scroll-activate="{default: false, lg: true}" data-kt-scroll-max-height="auto" data-kt-scroll-dependencies="#kt_modal_add_user_header" data-kt-scroll-wrappers="#kt_modal_add_user_scroll" data-kt-scroll-offset="300px" style="">

<!--******* Dados Carteira *********--> 
      <div  class="row">
        
        <div class="col">
          <label class="required fw-bold fs-6 mb-2">Nº da Carteira: </label>
          <input type="text" id="vercartid" name="vercartid" v-model="vercartid" class="form-control form-control-solid mb-3 mb-lg-0" readonly>
          <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>

        <div class="col">
          <label class="required fw-bold fs-6 mb-2">Status Carteira: </label>
          <input type="text" id="vercartstatus" name="vercartstatus" v-model="vercartstatus" class="form-control form-control-solid mb-3 mb-lg-0" readonly >
          <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>

        <div class="col">
          <label class="required fw-bold fs-6 mb-2">Data de Envio: </label>
          <input type="text" id="vercartdata" name="vercartdata" v-model="vercartdata" class="form-control form-control-solid mb-3 mb-lg-0" readonly >
          <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>

      </div>

<!-- Graficos -->

  <div class="row">
    <div class="row">
      <MixedWidget5Regiao widget-classes="card-xl-stretch mb-xl-8" chart-color="success" chart-height="100" :mesesRegiao="this.ArrayMesesRegiao" :consumoRegiao="this.ArrayConsumoRegiao" :totalRegiao="this.ConsumoTotalRegiao"></MixedWidget5Regiao>
    </div>
  </div>

  <div class="row">
    <div class="row">
      <MixedWidget5Cnae widget-classes="card-xl-stretch mb-xl-8" chart-color="red" chart-height="100" :mesesCnae="this.ArrayMesesCnae" :consumoCnae="this.ArrayConsumoCnae" :totalCnae="this.ConsumoTotalCnae"></MixedWidget5Cnae>
    </div>
  </div>

<!-- ****** EMPRESA *********-->

      <div class="row">

        <div class="col mb-7 fv-plugins-icon-container">
          <label class="required fw-bold fs-6 mb-2">Empresa: </label>
          <input type="text" id="verempnome" name="verempnome" v-model="verempnome" class="form-control form-control-solid mb-3 mb-lg-0" readonly >
          <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>

        <div class="col mb-7 fv-plugins-icon-container">
          <label class="required fw-bold fs-6 mb-2">CNPJ: </label>
          <input type="text" id="verempcnpj" name="verempcnpj" v-model="verempcnpj" class="form-control form-control-solid mb-3 mb-lg-0" readonly >
          <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>

        <div class="fv-row mb-7 fv-plugins-icon-container">
          <label class="required fw-bold fs-6 mb-2">CNAE: </label>
          <input type="text" id="verempcnae" name="verempcnae" v-model="verempcnae" class="form-control form-control-solid mb-3 mb-lg-0" readonly >
          <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>

        <div class="col mb-7 fv-plugins-icon-container">
          <label class="required fw-bold fs-6 mb-2">Região: </label>
          <input type="text" id="verempregiao" name="verempregiao" v-model="verempregiao" class="form-control form-control-solid mb-3 mb-lg-0" readonly >
          <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>

        <div class="col mb-7 fv-plugins-icon-container">
          <label class="required fw-bold fs-6 mb-2">Cidade: </label>
          <input type="text" id="verempcidade" name="verempcidade" v-model="verempcidade" class="form-control form-control-solid mb-3 mb-lg-0" readonly >
          <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>

      </div>

      <div class="row">
        <div class="col mb-7 fv-plugins-icon-container">
          <button type="button" class="btn btn-primary" @click="aceitarCarteira()">
          <span class="bi bi-check-circle">Aceitar</span>
          </button> <!-- Botão para chamar a função de salvar na cartera -->          
        </div>

        <div class="col">               
          <button type="button" class="btn btn-danger" >
          <span class="bi bi-x-circle fs-1x" @click="rejeitarCarteira()"> Rejeitar</span>
          </button> <!-- Botão para chamar a função de rejeitar na cartera -->    
        </div>      
      </div>

<!--*******************-->
    </div>
    <!--end::Actions-->
    <div>
    </div>
    </form>
    <!--end::Form-->
    </div>
    <!--end::Modal body-->
    </div>
    <!--end::Modal content-->
    </div>
    <!--end::Modal dialog-->
    </div>
    <!--end::Modal - Add task-->


</template>

<script>
import { onMounted } from "vue";
import { setCurrentPageTitle } from "@/core/helpers/breadcrumb";
import MixedWidget5Cnae from "@/components/widgets/mixed/Widget5Cnae.vue";
import MixedWidget5Regiao from "@/components/widgets/mixed/Widget5Regiao.vue";
import axios from "axios";

export default {
  name: "empresa",
   components: {
    MixedWidget5Cnae,
    MixedWidget5Regiao,
  },
  data() {
    return {
      pesqempresa: '',
      ArrayCarteira: [],

      //Modal Ver Carteira
      vercartid: '',
      vercartstatus: '',
      vercartdata: '',
      verempnome: '',
      verempcnpj: '',
      verempcnae: '',
      verempregiao: '',
      verempcidade: '',
      verempid: '',

      //Grafico de Consumo
      ArrayConsumo: [0, 0, 0, 0, 0, 0],
	    ArrayMeses: [0, 0, 0, 0, 0, 0],

      //Grafico de consumo por cnae
      ArrayConsumoCnae: [0, 0, 0, 0, 0, 0],
      ArrayMesesCnae: [0, 0, 0, 0, 0, 0],
      ArrayCidadesCnae: [0, 0, 0, 0, 0, 0],
      mesesCnae: [0, 0, 0, 0, 0, 0],

      //Grafico de consumo por regiao 
      ArrayConsumoRegiao: [0, 0, 0, 0, 0, 0],
      ArrayMesesRegiao: [0, 0, 0, 0, 0, 0],
      ArrayCidadesRegiao: [0, 0, 0, 0, 0, 0],
      mesesRegiao: [0, 0, 0, 0, 0, 0],
      
    }
  },
  methods: 
  {
    carregarCarteiras() 
    {
      var idvende = localStorage.getItem("loginId");

      axios.get('carteira/carteira/vendedor/prospec?idvende='+idvende,
      { headers: { Accept: 'application/json' } })
      .then(res => {
        this.ArrayCarteira = res.data
      })
      .catch(error => console.log(error))
    },
    pesquisaCarteiras()
    {
      var idvende = localStorage.getItem("loginId");

      axios.get('carteira/carteira/vendedor/prospec/filtro?idvende='+idvende+'&empresa='+this.pesqempresa,
      { headers: { Accept: 'application/json' } })
      .then(res => {
        this.ArrayCarteira = res.data
      })
      .catch(error => console.log(error))
    },
    carregarModal(carteira)
    {
      this.vercartid = carteira.cartid;
      this.verempid = carteira.empresa[0].empid
      this.verusuid = localStorage.getItem("loginId");
      this.vercartstatus = carteira.cartstatus
      this.vercartdata = carteira.cartdataini
      this.verempnome = carteira.empresa[0].empnome
      this.verempcnpj = carteira.empresa[0].empcnpj
      this.verempcnae = carteira.cnae[0].cnae_codigo + "-" + carteira.cnae[0].cnae_descricao
      this.verempregiao = carteira.cidade[0].cid_regiaoibge
      this.verempcidade = carteira.cidade[0].cid_estado + "-" + carteira.cidade[0].cid_cidade

      //Chamar funções de pesquisa por regiao e por cnae da empresa

      this.carregaGraficoCnae(carteira.cnae[0].cnae_codigo);
      this.carregaGraficoRegiao(carteira.cidade[0].cid_regiaoibge);
    },
    carregaGraficoCnae(cnaecod)
    {    
      this.ArrayConsumoCnae.length = 0;
      this.ArrayMesesCnae.length = 0;
      this.ArrayConsumoCnae.splice(0, this.ArrayConsumoCnae.length);
      this.ArrayMesesCnae.splice(0, this.ArrayMesesCnae.length);

      axios.get('empresas/cnae?cnae='+cnaecod, 
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
    carregaGraficoRegiao(regiao)
    {   
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
    aceitarCarteira()//Criar metodos para aceitar e rejeitar carteira
    { 
        var data = this.pegaData();
        axios.put('carteira/'+this.vercartid,
        { 
            //cartid: this.$data.usunome, 
            usuid: this.verusuid,
            empid: this.verempid,
            cartstatus: "Concluido",
            cartdataini: data,
        })
        .then(res => { alert("Empresa adicionada a sua carteira!");})
        .catch(error => {console.log(error);})

        axios.put('empresas/'+this.verempid,{ emporigem: "SPC" })
        .then(res => { this.carregarCarteiras(); })
        .catch(error => {console.log(error);})

        
    },
    rejeitarCarteira()
    {
      if(confirm("Deseja realmente rejeitar essa carteira? ") == true)
      {
        axios.delete('carteira/'+this.vercartid)
        .then(res => 
        {
          this.carregarCarteiras();
        })
        .catch(error => {console.log(error);})
      }
      else{ this.carregarCarteiras();}
    },
    pegaData()
    {
      //var monName = new Array ("janeiro", "fevereiro", "março", "abril", "maio", "junho", "agosto", "outubro", "novembro", "dezembro")
      var monName = new Array ("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
      var now = new Date
      var data = now.getDate () + "/" + monName [now.getMonth() ] +"/" + now.getFullYear () ;
      return data;
    },
  },
  created()
  {
    this.carregarCarteiras();
  },
  setup() 
  {
    onMounted(() => { setCurrentPageTitle("Prospecção de Empresas");});
  },
};
</script>
