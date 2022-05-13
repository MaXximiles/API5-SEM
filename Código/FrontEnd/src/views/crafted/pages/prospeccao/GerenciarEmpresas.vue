<template>


<div class="row g-5 gx-xl-8" ><!-- Carteiras Pendentes -->
  <!--begin::Stats-->
      <div class="flex-grow-1 card-p pb-0 row bg-secondary rounded">
        <div class="d-flex flex-stack flex-wrap">
          <div class="me-2">
            <a class="text-dark text-hover-primary fw-bolder fs-3">Carteiras Pendentes</a>

            <div class="text-muted fs-7 fw-bold">
              Lista de carteiras aguardando aceite do Vendedor.
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

      <input type="text" v-model="pesqvendedor" @keyup="pesquisaCarteira()" data-kt-user-table-filter="search"  class="form-control form-control-solid ps-14" placeholder="Pesquisar Vendedor">
    </div>

    <div class="col" >
      <span class="svg-icon svg-icon-1 position-absolute ms-6">
      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
      <rect opacity="0.5" x="17.0365" y="15.1223" width="8.15546" height="2" rx="1" transform="rotate(45 17.0365 15.1223)" fill="currentColor"></rect>
      <path d="M11 19C6.55556 19 3 15.4444 3 11C3 6.55556 6.55556 3 11 3C15.4444 3 19 6.55556 19 11C19 15.4444 15.4444 19 11 19ZM11 5C7.53333 5 5 7.53333 5 11C5 14.4667 7.53333 17 11 17C14.4667 17 17 14.4667 17 11C17 7.53333 14.4667 5 11 5Z" fill="currentColor"></path>
      </svg>
      </span>

      <input type="text" v-model="pesqempresa" @keyup="pesquisaCarteira()" data-kt-user-table-filter="search"  class="form-control form-control-solid ps-14" placeholder="Pesquisar Empresa">
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
              <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" >VENDEDOR</th>
              <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" >EMPRESA</th>
              <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" >CNPJ</th>
              <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" >STATUS</th>
              <th class="min-w-100px sorting_disabled" rowspan="1" colspan="1" aria-label="Actions" style="width: 100px;">AÇÕES</th>
            </tr>
          </thead>

        <tbody class="text-gray-600 fw-bold">

          <tr class="odd" v-for="carteira in ArrayCarteirasPendentes" :key="carteira.cartid">
            <td class="align-items-center">
              <div class="d-flex flex-column">
              <span>{{ carteira.usuario[0].usunome }}</span>
              </div>
            </td>

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
              <span>{{ carteira.cartstatus }}</span>
              </div>
            </td>

            <td class="text-center">
              <div class='col ' >
                <button  type="button" class="btn btn-secondary" @click="verCarteira(carteira)" data-bs-toggle="modal" data-bs-target="#kt_modal_vercarteira">
                <span class="fa fa-clipboard fs-1x text-gray-700" ></span>
                </button>            

                <button  type="button" class="btn btn-secondary" @click="excluirCarteiraPendente(carteira)">
                <span class="bi bi-trash fs-1x text-gray-700" ></span>
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



<div class="row"> <br><br></div>


<div class="row gx-xl-8"><!-- Carteiras Existentes -->
 
<!--begin::Stats-->
      <div class="flex-grow-1 card-p pb-0 row bg-secondary rounded">
        <div class="d-flex flex-stack flex-wrap">
          <div class="me-2">
            <a class="text-dark text-hover-primary fw-bolder fs-3">Carteiras Concluidas</a>

            <div class="text-muted fs-7 fw-bold">
              Lista de carteiras com vinculo entre vendedor e empresa.
            </div>
          </div>

        </div>
      </div>
      <!--end::Stats-->
  <div class="row"> <br> </div>

  <div class="row">

    <div class="col" >
      <span class="svg-icon svg-icon-1 position-absolute ms-6">
      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
      <rect opacity="0.5" x="17.0365" y="15.1223" width="8.15546" height="2" rx="1" transform="rotate(45 17.0365 15.1223)" fill="currentColor"></rect>
      <path d="M11 19C6.55556 19 3 15.4444 3 11C3 6.55556 6.55556 3 11 3C15.4444 3 19 6.55556 19 11C19 15.4444 15.4444 19 11 19ZM11 5C7.53333 5 5 7.53333 5 11C5 14.4667 7.53333 17 11 17C14.4667 17 17 14.4667 17 11C17 7.53333 14.4667 5 11 5Z" fill="currentColor"></path>
      </svg>
      </span>

      <input type="text" v-model="pesqConcvendedor" @keyup="pesquisaCarteiraExistente()" data-kt-user-table-filter="search"  class="form-control form-control-solid ps-14" placeholder="Pesquisar Vendedor">
    </div>

    <div class="col" >
      <span class="svg-icon svg-icon-1 position-absolute ms-6">
      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
      <rect opacity="0.5" x="17.0365" y="15.1223" width="8.15546" height="2" rx="1" transform="rotate(45 17.0365 15.1223)" fill="currentColor"></rect>
      <path d="M11 19C6.55556 19 3 15.4444 3 11C3 6.55556 6.55556 3 11 3C15.4444 3 19 6.55556 19 11C19 15.4444 15.4444 19 11 19ZM11 5C7.53333 5 5 7.53333 5 11C5 14.4667 7.53333 17 11 17C14.4667 17 17 14.4667 17 11C17 7.53333 14.4667 5 11 5Z" fill="currentColor"></path>
      </svg>
      </span>

      <input type="text" v-model="pesqConcempresa" @keyup="pesquisaCarteiraExistente()" data-kt-user-table-filter="search"  class="form-control form-control-solid ps-14" placeholder="Pesquisar Empresa">
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
              <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" >VENDEDOR</th>
              <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" >EMPRESA</th>
              <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" >CNPJ</th>
              <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" >DATA</th>
              <th class="min-w-100px sorting_disabled" rowspan="1" colspan="1" aria-label="Actions" style="width: 100px;">AÇÕES</th>
            </tr>
          </thead>

        <tbody class="text-gray-600 fw-bold">

          <tr class="odd" v-for="carteira in ArrayCarteirasConcluidas" :key="carteira.cartid">
            <td class="align-items-center">
              <div class="d-flex flex-column">
              <span>{{ carteira.usuario[0].usunome }}</span>
              </div>
            </td>

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
              <span>{{ carteira.cartstatus }}</span>
              </div>
            </td>

            <td class="text-center">
              <div class='col ' >
                <button  type="button" class="btn btn-secondary" @click="verCarteira(carteira)" data-bs-toggle="modal" data-bs-target="#kt_modal_vercarteira">
                <span class="fa fa-clipboard fs-1x text-gray-700" ></span>
                </button>            

                <!-- Verificar Opção de excluir carteira existente
                <button  type="button" class="btn btn-secondary" @click="excluirCarteiraPendente(carteira)">
                <span class="bi bi-trash fs-1x text-gray-700" ></span>
                </button>  -->
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









<!-- MODAL  VER CARTEIRA -->



	<div class="modal fade" id="kt_modal_vercarteira" tabindex="-1" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered mw-750px">
	<div class="modal-content">
	<div class="modal-header" id="kt_modal_add_user_header">
	<h2 class="fw-bolder">Carteira de Vendedor</h2>


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

<!--******* Dados Carteira *********--> 
      <div  class="row modal-body mx-5 mx-xl-10 pt-0 pb-15">
        
        <div class="col col-md-4">
          <label class="required fw-bold fs-6 mb-2">Nº da Carteira: </label>
          <input type="text" id="vercartid" name="vercartid" v-model="vercartid" class="form-control form-control-solid mb-3 mb-lg-0" readonly>
          <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>

        <div class="col mb-7 fv-plugins-icon-container">
          <label class="required fw-bold fs-6 mb-2">Status Carteira: </label>
          <input type="text" id="vercartstatus" name="vercartstatus" v-model="vercartstatus" class="form-control form-control-solid mb-3 mb-lg-0" readonly >
          <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>

        <div class="col mb-7 fv-plugins-icon-container">
          <label class="required fw-bold fs-6 mb-2">Data de Envio: </label>
          <input type="text" id="vercartdata" name="vercartdata" v-model="vercartdata" class="form-control form-control-solid mb-3 mb-lg-0" readonly >
          <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>

      </div>

<!--******* VENDEDOR *********--> 
      <div  class="row modal-body mx-5 mx-xl-10 pt-0 pb-15">

        <div class="fv-row mb-7 fv-plugins-icon-container">
          <label class="required fw-bold fs-6 mb-2">Vendedor: </label>
          <input type="text" id="verusunome" name="verusunome" v-model="verusunome"  class="form-control form-control-solid mb-3 mb-lg-0" readonly  >
          <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>

        <div class="fv-row mb-7 fv-plugins-icon-container">
          <label class="required fw-bold fs-6 mb-2">Email: </label>
          <input type="text" id="verusuemail" name="verusuemail" v-model="verusuemail" class="form-control form-control-solid mb-3 mb-lg-0" readonly  >
          <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>

      </div>
<!-- ****** EMPRESA *********-->

      <div  class="row modal-body mx-5 mx-xl-10 pt-0 pb-15">

        <div class="fv-row mb-7 fv-plugins-icon-container">
          <label class="required fw-bold fs-6 mb-2">Empresa: </label>
          <input type="text" id="verempnome" name="verempnome" v-model="verempnome" class="form-control form-control-solid mb-3 mb-lg-0" readonly >
          <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>

        <div class="fv-row mb-7 fv-plugins-icon-container">
          <label class="required fw-bold fs-6 mb-2">CNPJ: </label>
          <input type="text" id="verempcnpj" name="verempcnpj" v-model="verempcnpj" class="form-control form-control-solid mb-3 mb-lg-0" readonly >
          <div class="fv-plugins-message-container invalid-feedback"></div>
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
import { defineComponent, onMounted } from "vue";
import { setCurrentPageTitle } from "@/core/helpers/breadcrumb";
import axios from "axios";

export default {
  name: 'empresa',
  data() {
    return {
    cartid: '',
    cartdataini: '',
    empid: '',
    usuid: '',
    cartstatus: '',
    pesqempresa: '',
    pesqvendedor: '',
    pesqConcempresa: '',
    pesqConcvendedor: '',

    vercartid: '',
    vercartstatus: '',
    verusunome: '',
    verusuemail: '',
    verempnome: '',
    verempcnpj: '',
    vercartdata: '',

    ArrayCarteirasConcluidas: [],
	  ArrayCarteirasPendentes: [],
    ArrayVerCarteirasPendentes: [],
    } 
  },
  methods:
  {
    carregarCarteirasPendentes() 
    {
      axios.get('carteira/carteirasPendentes/', 
      { headers: { Accept: 'application/json' } })
      .then(res => {
        this.ArrayCarteirasPendentes = res.data
      })
      .catch(error => console.log(error))
    },
    carregarCarteirasConcluidas() 
    {
      axios.get('carteira/carteira/concluida/nome?usunome='+this.pesqConcvendedor+'&empnome='+this.pesqConcempresa,
      { headers: { Accept: 'application/json' } })
      .then(res => {
        this.ArrayCarteirasConcluidas = res.data
      })
      .catch(error => console.log(error))
    },
    verCarteira(carteira)
    {
      this.vercartid = carteira.cartid;
      this.vercartstatus = carteira.cartstatus;
      this.vercartdata = carteira.cartdataini;
      this.verusunome = carteira.usuario[0].usunome;
      this.verusuemail = carteira.usuario[0].usuemail;
      this.verempnome = carteira.empresa[0].empnome;
      this.verempcnpj = carteira.empresa[0].empcnpj;
    },
    excluirCarteiraPendente(carteira)
    {
      if(confirm("Deseja realmente excluir essa carteira? ") == true)
      {
        this.cartid = carteira.cartid;
        axios.delete('carteira/'+this.cartid)
        .then(res => 
        {
          this.carregarCarteirasPendentes();
        })
            .catch(error => {console.log(error);})
      }
      else{ this.carregarCarteirasPendentes();}

    },
    pesquisaCarteira()
    {
        axios.get('carteira/carteira/nome?usunome='+this.pesqvendedor+'&empnome='+this.pesqempresa, 
        { headers: { Accept: 'application/json' } })
        .then(res => {
          this.ArrayCarteirasPendentes = res.data
        })
        .catch(error => console.log(error))
    },
    pesquisaCarteiraExistente()
    {
        axios.get('carteira/carteira/concluida/nome?usunome='+this.pesqConcvendedor+'&empnome='+this.pesqConcempresa, 
        { headers: { Accept: 'application/json' } })
        .then(res => {
          this.ArrayCarteirasConcluidas = res.data
        })
        .catch(error => console.log(error))
    },
    
  },
  created () 
  { 
	  this.carregarCarteirasPendentes();
    this.carregarCarteirasConcluidas()
  },

  setup() {
    onMounted(() => {
      setCurrentPageTitle("Gerenciar Carteiras Empresa Vendedor");
    });
  },
};
</script>
