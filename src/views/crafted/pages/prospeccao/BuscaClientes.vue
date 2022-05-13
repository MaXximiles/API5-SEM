<template>
  <!--begin::Dashboard-->

  <div class="row g-5 gx-xxl-8" >

    <div class="col">
      <div class="card card-xl-stretch-50 mb-5 mb-xl-8">
      <MixedWidget5Regiao widget-classes="card-xl-stretch mb-xl-8" chart-color="success" chart-height="100" :mesesRegiao="this.ArrayMesesRegiao" :consumoRegiao="this.ArrayConsumoRegiao" :totalRegiao="this.ConsumoTotalRegiao"></MixedWidget5Regiao>
      </div>
    </div>
    
    <div class="col">
      <div class="card card-xl-stretch-50 mb-5 mb-x1-8" >
      <MixedWidget5Cnae widget-classes="card-xl-stretch mb-xl-8" chart-color="red" chart-height="100" :mesesCnae="this.ArrayMesesCnae" :consumoCnae="this.ArrayConsumoCnae" :totalCnae="this.ConsumoTotalCnae"></MixedWidget5Cnae>
      </div>
    </div>   

  </div>

  <div class="row g-5 gx-xxl-8" >

        <div class="col" >
          <select id="cidid" @change="carregarSelectCnae()" name="cidid" v-model="cidid" aria-label="Selecione a cidade" data-control="select2" data-placeholder="Selecione a Cidade" class="form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible  ps-14" data-select2-id="select2-data-10-0g0q" tabindex="-1" aria-hidden="true">
          <option value="" data-select2-id="select2-data-12-5j0j"> Selecione a Região </option>
          <option v-for="cidade in CidadesSelect" v-bind:key="cidade.cidade[0].cid_regiaoibge" :value="cidade.cidade[0].cid_regiaoibge">{{ "REGIÃO "+cidade.cidade[0].cid_regiaoibge }}</option>
          </select>
        </div>

        <div class="col-4" >
          <select  id="cnaeid" @change="carregarSelectRegiao()" name="cnaeid" v-model="cnaeid" aria-label="Selecione o Cnae da empresa" data-control="select2" data-placeholder="Selecione o CNAE da sua empresa" class="form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible  ps-14" data-select2-id="select2-data-10-0g0q" tabindex="-1" aria-hidden="true">
          <option value="" data-select2-id="select2-data-12-5j0j">  Selecione o Cnae   </option>
          <option v-for="cnaes in CnaeSelect" v-bind:key="cnaes.cnae[0].cnae_codigo" :value="cnaes.cnae[0].cnae_codigo" >{{ cnaes.cnae[0].cnae_codigo + " - " + cnaes.cnae[0].cnae_descricao }}</option>
          </select>
        </div>       

        <div class="col" >
          <span class="svg-icon svg-icon-1 position-absolute ms-6">
					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
					<rect opacity="0.5" x="17.0365" y="15.1223" width="8.15546" height="2" rx="1" transform="rotate(45 17.0365 15.1223)" fill="currentColor"></rect>
					<path d="M11 19C6.55556 19 3 15.4444 3 11C3 6.55556 6.55556 3 11 3C15.4444 3 19 6.55556 19 11C19 15.4444 15.4444 19 11 19ZM11 5C7.53333 5 5 7.53333 5 11C5 14.4667 7.53333 17 11 17C14.4667 17 17 14.4667 17 11C17 7.53333 14.4667 5 11 5Z" fill="currentColor"></path>
					</svg>
					</span>

          <input type="text" v-model="pesqemp" data-kt-user-table-filter="search"  class="form-control form-control-solid ps-14" placeholder="Pesquisar Empresas">
        </div>

        <div class="col" >
          <button type="submit" class="btn btn-light-primary me-3" data-kt-menu-trigger="click" data-kt-menu-placement="bottom-end" @click="carregaFiltros()">
              <span class="svg-icon svg-icon-2">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
                  <path d="M19.0759 3H4.72777C3.95892 3 3.47768 3.83148 3.86067 4.49814L8.56967 12.6949C9.17923 13.7559 9.5 14.9582 9.5 16.1819V19.5072C9.5 20.2189 10.2223 20.7028 10.8805 20.432L13.8805 19.1977C14.2553 19.0435 14.5 18.6783 14.5 18.273V13.8372C14.5 12.8089 14.8171 11.8056 15.408 10.964L19.8943 4.57465C20.3596 3.912 19.8856 3 19.0759 3Z" fill="currentColor"></path>
                </svg>
              </span>
              Filtrar
          </button>

           <button type="button" class="btn btn-light-primary me-3" data-kt-menu-trigger="click" data-kt-menu-placement="bottom-end" @click="limpaFiltros()">
              <span class="svg-icon svg-icon-2">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
                  <path d="M19.0759 3H4.72777C3.95892 3 3.47768 3.83148 3.86067 4.49814L8.56967 12.6949C9.17923 13.7559 9.5 14.9582 9.5 16.1819V19.5072C9.5 20.2189 10.2223 20.7028 10.8805 20.432L13.8805 19.1977C14.2553 19.0435 14.5 18.6783 14.5 18.273V13.8372C14.5 12.8089 14.8171 11.8056 15.408 10.964L19.8943 4.57465C20.3596 3.912 19.8856 3 19.0759 3Z" fill="currentColor"></path>
                </svg>
              </span>
              Limpar
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
          <div class='col ' >
            <button @click="carregarConsumo(empresa)" v-if="mostraBotao(empresa)" type="button" class="btn btn-secondary" >
            <span class="bi bi-graph-down fs-2x text-gray-700" ></span>
            </button>            
          </div>


          <!--Carregar Carteira vendedor-->
          <div class='col '>
            <button v-if="mostraBotao2(empresa)" @click="carregarVendedores(empresa.empid)" type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#kt_modal_carteira">
            <span class="bi bi-diagram-3 fs-2x text-gray-700"> </span>
            </button>   
          </div>
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




<!-- MODAL -->


<!--begin::Modal - EDITAR EMPRESA Add task-->
	<div class="modal fade" id="kt_modal_carteira" tabindex="-1" aria-hidden="true">
	<!--begin::Modal dialog-->
	<div class="modal-dialog modal-dialog-centered mw-750px">
	<!--begin::Modal content-->
	<div class="modal-content">
	<!--begin::Modal header-->
	<div class="modal-header" id="kt_modal_add_user_header">
	<!--begin::Modal title-->
	<h2 class="fw-bolder">Carteira de Vendedor</h2>
	<!--end::Modal title-->
	<!--begin::Close-->

	<!-- BOTÃO FECHAR (X) QUE ESTA FUNCIONANDO -->
	<div class="btn btn-sm btn-icon btn-active-color-primary" data-bs-dismiss="modal">
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

    <div class="fv-row mb-7 fv-plugins-icon-container" >
      <span class="svg-icon svg-icon-1 position-absolute ms-6">
      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
      <rect opacity="0.5" x="17.0365" y="15.1223" width="8.15546" height="2" rx="1" transform="rotate(45 17.0365 15.1223)" fill="currentColor"></rect>
      <path d="M11 19C6.55556 19 3 15.4444 3 11C3 6.55556 6.55556 3 11 3C15.4444 3 19 6.55556 19 11C19 15.4444 15.4444 19 11 19ZM11 5C7.53333 5 5 7.53333 5 11C5 14.4667 7.53333 17 11 17C14.4667 17 17 14.4667 17 11C17 7.53333 14.4667 5 11 5Z" fill="currentColor"></path>
      </svg>
      </span>

      <input type="text" v-model="pesqvend" @keyup="carregarVendedores()" data-kt-user-table-filter="search"  class="form-control form-control-solid ps-14" placeholder="Pesquisar Vendedor">
    </div>

  <div class="text-center mb-13">
		<h1 class="d-flex justify-content-center align-items-center mb-3">Selecione o Vendedor</h1>
	</div>

<!--****************-->
      <div  class="modal-body scroll-y mx-5 mx-xl-10 pt-0 pb-15">

						<div class="mh-475px scroll-y me-n7 pe-7" v-for="vendedor in ArrayVendedores" :key="vendedor.usu_id">
							<div class="border border-hover-primary p-7 rounded mb-7">
								<div class="d-flex flex-stack pb-3">
									<div class="d-flex">

										<div class="symbol symbol-circle symbol-45px"><img src="media/avatars/blank.png" alt=""></div>

                      <div class="ms-5">
                        <div class="d-flex align-items-center">
                          <a class="text-dark fw-bolder text-hover-primary fs-5 me-4">{{ vendedor.usunome }}</a>
                          <span class="badge badge-light-success d-flex align-items-center fs-8 fw-bold">
                            <span class="svg-icon svg-icon-8 svg-icon-success me-1">
                              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
                                <path d="M11.1359 4.48359C11.5216 3.82132 12.4784 3.82132 12.8641 4.48359L15.011 8.16962C15.1523 8.41222 15.3891 8.58425 15.6635 8.64367L19.8326 9.54646C20.5816 9.70867 20.8773 10.6186 20.3666 11.1901L17.5244 14.371C17.3374 14.5803 17.2469 14.8587 17.2752 15.138L17.7049 19.382C17.7821 20.1445 17.0081 20.7069 16.3067 20.3978L12.4032 18.6777C12.1463 18.5645 11.8537 18.5645 11.5968 18.6777L7.69326 20.3978C6.99192 20.7069 6.21789 20.1445 6.2951 19.382L6.7248 15.138C6.75308 14.8587 6.66264 14.5803 6.47558 14.371L3.63339 11.1901C3.12273 10.6186 3.41838 9.70867 4.16744 9.54646L8.3365 8.64367C8.61089 8.58425 8.84767 8.41222 8.98897 8.16962L11.1359 4.48359Z" fill="currentColor"></path>
                              </svg>
                            </span>
                          Vendedor</span>
                        </div>
                        <span class="text-muted fw-bold mb-3">{{ vendedor.usuemail }}</span>
                      </div>
									  </div>
								</div>


								<div class="p-0">
									<div class="d-flex flex-column">
										<p class="text-gray-700 fw-bold fs-6 mb-4"> </p><!--Mostrar endereço do vendedor-->
									</div>
									<div class="d-flex flex-column">
										<div class="separator separator-dashed border-muted my-5"></div>
										<div class="d-flex flex-stack">
											<div class="d-flex flex-column mw-200px">
												<div class="progress h-6px w-200px">
													<div class="progress-bar bg-primary" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>

                        <button type="button" @click="verificaCarteira(vendedor.usuid)" class="btn btn-primary" >
                        <span class="indicator-label">Selecionar</span>
                        <span class="indicator-progress">Carregando... 
                        <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                        </button> <!-- Botão para chamar a função de salvar na cartera -->          

										</div>
									</div>
								</div>
							</div>
							
						<!--end::Users-->
					</div>
      </div>
<!-- ***************-->
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
      cartid: '',
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

      //Modal de pesquisa de vendedores
      pesqvend: '',
      usuid: '',
      usunome: '',
      usuemail: '',
      mostraCarteira: [],
      ArrayVendedores: [],
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
    limpaFiltros()
    {
        //Grafico de consumo por empresa
        this.ArrayConsumo.length = [];
        for(let i = 0; i < 6; i++){this.ArrayConsumo.push(0);}
        this.ArrayMeses.length = [];
        for(let i = 0; i < 6; i++){this.ArrayMeses.push(0);}
     
        //Grafico de consumo por cnae
        this.ArrayConsumoCnae.length = [];
        for(let i = 0; i < 6; i++){this.ArrayConsumoCnae.push(0);}
        this.ArrayMesesCnae.length = [];
        for(let i = 0; i < 6; i++){this.ArrayMesesCnae.push(0);}

        //Grafico de consumo por regiao 
        this.ArrayConsumoRegiao.length = [];
        for(let i = 0; i < 6; i++){this.ArrayConsumoRegiao.push(0);}
        this.ArrayMesesRegiao.length = [];
        for(let i = 0; i < 6; i++){this.ArrayMesesRegiao.push(0);}

        
        this.pesqemp = '';
        this.cnaeid = '';
        this.cidid= '';

        this.carregaFiltros();

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
    carregarVendedores(id)
    {
      var regiao = '';
      if(cidid.value != ""){regiao = cidid.value;}
      this.empid = id;

      axios.get('usuario/vendedores?regiao='+regiao+'&nome='+this.pesqvend, 
      { headers: { Accept: 'application/json' } })
      .then(res => {
        this.ArrayVendedores = res.data
      })
      .catch(error => console.log(error))
    },
    pegaData()
    {
      //var monName = new Array ("janeiro", "fevereiro", "março", "abril", "maio", "junho", "agosto", "outubro", "novembro", "dezembro")
      var monName = new Array ("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
      var now = new Date
      var data = now.getDate () + "/" + monName [now.getMonth() ] +"/" + now.getFullYear () ;
      return data;
    },
    async verificaCarteira(usuid) //Verificando se ja existe carteira
    {
      await axios.get('carteira/carteira?usuid='+usuid+"&empid="+this.empid, 
      { headers: { Accept: 'application/json' } })
      .then(res => {
        
        if(res.data != "")
        {
          alert("Ja foi enviado para este vendedor !")
          return false
        }
        else{this.addCarteira(usuid)}
      })
      .catch(error => console.log(error))     
    },
    addCarteira(idusu)
    {
          var data = this.pegaData();
          axios.post('carteira/', 
          {
              usuid: idusu,
              empid: this.empid,
              cartstatus: "Aguardando",
              cartdataini: data,          
          })
          .then(res => {
          alert("Dados inseridos com sucesso!");
          })
          .catch(error => console.log(error))
    },
    addEmpresa() //Cadastro de empresas
	  {
      if(this.confirmarForm())
      {
        axios.post('empresas/', 
        {   
        empnome: this.empnome, 
        empcnpj: this.empcnpj,
        emporigem: this.emporigem,
        cidid: this.cidid,
        cnaeid: this.cnaeid
        })
        .then(res => {
          // Limpando campos do formulario
          this.empnome = '';
          this.empcnpj = '';
          this.emporigem = '';
          this.cidid = '';
          this.cnaeid = '';
          alert("Dados inseridos com sucesso!");
          this.carregarEmpresas();
          })
        .catch(error => {console.log(error);})
      }
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
