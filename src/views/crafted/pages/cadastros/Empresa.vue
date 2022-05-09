<template>

<div id="kt_content_container" class="container-xxl">
  

	<div class="card">
		<div class="card-header border-0 pt-6">
			<div class="card-title">
				
        		<div class="d-flex align-items-center position-relative my-1">
            		<span class="svg-icon svg-icon-1 position-absolute ms-6">
					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
					<rect opacity="0.5" x="17.0365" y="15.1223" width="8.15546" height="2" rx="1" transform="rotate(45 17.0365 15.1223)" fill="currentColor"></rect>
					<path d="M11 19C6.55556 19 3 15.4444 3 11C3 6.55556 6.55556 3 11 3C15.4444 3 19 6.55556 19 11C19 15.4444 15.4444 19 11 19ZM11 5C7.53333 5 5 7.53333 5 11C5 14.4667 7.53333 17 11 17C14.4667 17 17 14.4667 17 11C17 7.53333 14.4667 5 11 5Z" fill="currentColor"></path>
					</svg>
					</span>
					<input type="text" v-on:keyup="pesquisarEmpresas" v-model="pesqemp" data-kt-user-table-filter="search"  class="form-control form-control-solid w-250px ps-14" placeholder="Pesquisar Empresas">
				</div>
      </div>  

			<div class="card-toolbar">
				<div class="d-flex justify-content-end" data-kt-user-table-toolbar="base">
						<!--begin::Add user-->
						<button type="button" class="btn btn-primary" @click="limparEmpresa()" data-bs-toggle="modal" data-bs-target="#kt_modal_add_user">
						<!--begin::Svg Icon | path: icons/duotune/arrows/arr075.svg-->
						<span class="svg-icon svg-icon-2">
							<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
								<rect opacity="0.5" x="11.364" y="20.364" width="16" height="2" rx="1" transform="rotate(-90 11.364 20.364)" fill="currentColor"></rect>
								<rect x="4.36396" y="11.364" width="16" height="2" rx="1" fill="currentColor"></rect>
							</svg>
						</span>
            Adicionar Empresa</button>
				</div>

				<!--begin::Group actions-->
				<div class="d-flex justify-content-end align-items-center d-none" data-kt-user-table-toolbar="selected">
					<div class="fw-bolder me-5">
					<span class="me-2" data-kt-user-table-select="selected_count"></span>Selected</div>
					<button type="button" class="btn btn-danger" data-kt-user-table-select="delete_selected">Delete Selected</button>
					</div>
				<!--end::Group actions-->


	<!--begin::Modal Formulario de ADICIONAR nova empresa-->
	<div class="modal fade" id="kt_modal_add_user" tabindex="-1" aria-hidden="true">
	<!--begin::Modal dialog-->
	<div class="modal-dialog modal-dialog-centered mw-650px">
	<!--begin::Modal content-->
	<div class="modal-content">
	<!--begin::Modal header-->
	<div class="modal-header" id="kt_modal_add_user_header">
	<!--begin::Modal title-->
	<h2 class="fw-bolder">Formulário de Empresas</h2>
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
	<form id="kt_modal_add_user_form" @submit.prevent="addEmpresa" class="form fv-plugins-bootstrap5 fv-plugins-framework" action="#">
	<div class="d-flex flex-column scroll-y me-n7 pe-7" id="kt_modal_add_user_scroll" data-kt-scroll="true" data-kt-scroll-activate="{default: false, lg: true}" data-kt-scroll-max-height="auto" data-kt-scroll-dependencies="#kt_modal_add_user_header" data-kt-scroll-wrappers="#kt_modal_add_user_scroll" data-kt-scroll-offset="300px" style="">

	<div class="fv-row mb-7 fv-plugins-icon-container">
	<label class="required fw-bold fs-6 mb-2">Nome: </label>
	<input type="text" id="emp_nome" name="emp_nome" v-model="empnome" class="form-control form-control-solid mb-3 mb-lg-0" placeholder="Nome da Empresa">
	<div class="fv-plugins-message-container invalid-feedback"></div>
	</div>

	<div class="fv-row mb-7 fv-plugins-icon-container">
	<label class="required fw-bold fs-6 mb-2">CNPJ: </label>
	<input type="text" id="emp_cnpj" name="emp_cnpj" v-model="empcnpj"  v-mask="'##.###.###/####-##'" maxlength="18" class="form-control form-control-solid mb-3 mb-lg-0" placeholder="00.000.000/0000-00" >
	<div class="fv-plugins-message-container invalid-feedback"></div></div>


	<div class="row mb-7" data-select2-id="select2-data-561-nmjj">
		<div class="col-lg-8 fv-row fv-plugins-icon-container" data-select2-id="select2-data-560-wq70">
			<label class="required fw-bold fs-6 mb-2">CNAE: </label>
			<select id="cnaeid" name="cnaeid" v-model="cnaeid" aria-label="Selecione o Cnae da empresa" data-control="select2" data-placeholder="Selecione o CNAE da sua empresa" class="form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible" data-select2-id="select2-data-10-0g0q" tabindex="-1" aria-hidden="true">
			<option value="" data-select2-id="select2-data-12-5j0j"> -- Selecione o Cnae -- </option>
			<option v-for="cnaes in ArrayCnaes" v-bind:key="cnaes.cnae_id" :value="cnaes.cnae_id">{{ cnaes.cnae_codigo+" - "+cnaes.cnae_descricao }}</option>
			</select>
			<div class="fv-plugins-message-container invalid-feedback"></div>
		</div>
	</div>


	<div class="row mb-7" data-select2-id="select2-data-561-nmjj">
		<div class="col-lg-8 fv-row fv-plugins-icon-container" data-select2-id="select2-data-560-wq70">
			<label class="required fw-bold fs-6 mb-2">Cidade: </label>
			<select id="cidid" name="cidid" v-model="cidid" aria-label="Selecione a cidade" data-control="select2" data-placeholder="Selecione a Cidade" class="form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible" data-select2-id="select2-data-10-0g0q" tabindex="-1" aria-hidden="true">
			<option value="" data-select2-id="select2-data-12-5j0j"> -- Selecione a Cidade -- </option>
			<option v-for="cidade in ArrayCidades" v-bind:key="cidade.cid_id" :value="cidade.cid_id">{{ cidade.cid_estado +" - "+cidade.cid_cidade }}</option>
			</select>
			<div class="fv-plugins-message-container invalid-feedback"></div>
		</div>
	</div>

	<div class="row mb-7" data-select2-id="select2-data-561-nmjj">
		<div class="col-lg-8 fv-row fv-plugins-icon-container" data-select2-id="select2-data-560-wq70">
			<label class="required fw-bold fs-6 mb-2">Origem: </label>
			<select id="emp_origem" name="emp_origem" v-model="emporigem" aria-label="Select a Country" data-control="select2" data-placeholder="Selecione a Origem" class="form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible" data-select2-id="select2-data-10-0g0q" tabindex="-1" aria-hidden="true">
			<option value="" data-select2-id="select2-data-12-5j0j"> -- Selecione a Origem -- </option>
			<option value="CONCORRENTE" data-select2-id="select2-data-12-5j0j"> Concorrente</option>
			<option value="LIVRE" data-select2-id="select2-data-12-5j0j"> Livre </option>
			<option value="SPC" data-select2-id="select2-data-12-5j0j"> SPC </option>
			</select>
			<div class="fv-plugins-message-container invalid-feedback"></div>
		</div>
	</div>

	</div>

	<div class="text-center pt-15">
	<button type="reset" class="btn btn-light me-3" data-kt-users-modal-action="cancel">Descartar</button>
	<button type="submit" class="btn btn-primary" data-kt-users-modal-action="submit">
	<span class="indicator-label">Salvar</span>
	<span class="indicator-progress">Carregando... 
	<span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
	</button>
	</div>
	<!--end::Actions-->
	<div></div></form>
	<!--end::Form-->
	</div>
	<!--end::Modal body-->
	</div>
	<!--end::Modal content-->
	</div>
	<!--end::Modal dialog-->
	</div>
	<!--end::Modal - Add task-->
	</div>
	<!--end::Card toolbar-->
	</div>
	<!--end::Fim do Formulario-->



	<!--begin::Modal - EDITAR EMPRESA Add task-->
	<div class="modal fade" id="kt_modal_editar_user" tabindex="-1" aria-hidden="true">
	<!--begin::Modal dialog-->
	<div class="modal-dialog modal-dialog-centered mw-650px">
	<!--begin::Modal content-->
	<div class="modal-content">
	<!--begin::Modal header-->
	<div class="modal-header" id="kt_modal_add_user_header">
	<!--begin::Modal title-->
	<h2 class="fw-bolder">Formulário de Empresas</h2>
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
	<form id="kt_modal_add_user_form" @submit.prevent="atualizarEmpresa()" class="form fv-plugins-bootstrap5 fv-plugins-framework" action="#">
	<div class="d-flex flex-column scroll-y me-n7 pe-7" id="kt_modal_add_user_scroll" data-kt-scroll="true" data-kt-scroll-activate="{default: false, lg: true}" data-kt-scroll-max-height="auto" data-kt-scroll-dependencies="#kt_modal_add_user_header" data-kt-scroll-wrappers="#kt_modal_add_user_scroll" data-kt-scroll-offset="300px" style="">

	<div class="fv-row mb-7 fv-plugins-icon-container">
	<label class="required fw-bold fs-6 mb-2">Nome: </label>
	<input type="text" id="emp_nome" name="emp_nome" v-model="empnome" class="form-control form-control-solid mb-3 mb-lg-0" placeholder="Nome da Empresa">
	<div class="fv-plugins-message-container invalid-feedback"></div>
	</div>

	<div class="fv-row mb-7 fv-plugins-icon-container">
	<label class="required fw-bold fs-6 mb-2">CNPJ: </label>
	<input type="text" id="emp_cnpj" name="emp_cnpj" v-model="empcnpj" v-mask="'##.###.###/####-##'" class="form-control form-control-solid mb-3 mb-lg-0" placeholder="00.000.000/0000-00" >
	<div class="fv-plugins-message-container invalid-feedback"></div></div>


	<div class="row mb-7" data-select2-id="select2-data-561-nmjj">
		<div class="col-lg-8 fv-row fv-plugins-icon-container" data-select2-id="select2-data-560-wq70">
			<label class="required fw-bold fs-6 mb-2">CNAE: </label>
			<select id="cnaeid" name="cnaeid" v-model="cnaeid" aria-label="Selecione o Cnae da empresa" data-control="select2" data-placeholder="Selecione o CNAE da sua empresa" class="form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible" data-select2-id="select2-data-10-0g0q" tabindex="-1" aria-hidden="true">
			<option value="" data-select2-id="select2-data-12-5j0j"> -- Selecione o Cnae -- </option>
			<option v-for="cnaes in ArrayCnaes" v-bind:key="cnaes.cnae_id" :value="cnaes.cnae_id">{{ cnaes.cnae_codigo+" - "+cnaes.cnae_descricao }}</option>
			</select>
			<div class="fv-plugins-message-container invalid-feedback"></div>
		</div>
	</div>


	<div class="row mb-7" data-select2-id="select2-data-561-nmjj">
		<div class="col-lg-8 fv-row fv-plugins-icon-container" data-select2-id="select2-data-560-wq70">
			<label class="required fw-bold fs-6 mb-2">Cidade: </label>
			<select id="cidid" name="cidid" v-model="cidid" aria-label="Selecione a cidade" data-control="select2" data-placeholder="Selecione a Cidade" class="form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible" data-select2-id="select2-data-10-0g0q" tabindex="-1" aria-hidden="true">
			<option value="" data-select2-id="select2-data-12-5j0j"> -- Selecione a Cidade -- </option>
			<option v-for="cidade in ArrayCidades" v-bind:key="cidade.cid_id" :value="cidade.cid_id">{{ cidade.cid_estado +" - "+cidade.cid_cidade }}</option>
			</select>
			<div class="fv-plugins-message-container invalid-feedback"></div>
		</div>
	</div>

	<div class="row mb-7" data-select2-id="select2-data-561-nmjj">
		<div class="col-lg-8 fv-row fv-plugins-icon-container" data-select2-id="select2-data-560-wq70">
			<label class="required fw-bold fs-6 mb-2">Origem: </label>
			<select id="emp_origem" name="emp_origem" v-model="emporigem" aria-label="Select a Country" data-control="select2" data-placeholder="Selecione a Origem" class="form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible" data-select2-id="select2-data-10-0g0q" tabindex="-1" aria-hidden="true">
			<option value="" data-select2-id="select2-data-12-5j0j"> -- Selecione a Origem -- </option>
			<option value="CONCORRENTE" data-select2-id="select2-data-12-5j0j"> Concorrente</option>
			<option value="LIVRE" data-select2-id="select2-data-12-5j0j"> Livre </option>
			<option value="SPC" data-select2-id="select2-data-12-5j0j"> SPC </option>
			</select>
			<div class="fv-plugins-message-container invalid-feedback"></div>
		</div>
	</div>

	</div>

	<div class="text-center pt-15">
	<button type="reset" class="btn btn-light me-3" data-kt-users-modal-action="cancel">Descartar</button>
	<button type="submit" class="btn btn-primary" data-kt-users-modal-action="submit">
	<span class="indicator-label">Salvar</span>
	<span class="indicator-progress">Carregando... 
	<span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
	</button>
	</div>
	<!--end::Actions-->
	<div></div></form>
	<!--end::Form-->
	</div>
	<!--end::Modal body-->
	</div>
	<!--end::Modal content-->
	</div>
	<!--end::Modal dialog-->
	</div>
	<!--end::Modal - Add task-->
	</div>
	<!--end::Card toolbar-->
	</div>
	<!--end::Fim do Formulario-->

			
            <!--begin::Card body-->
			<div class="card-body py-4">
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
								<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#kt_modal_editar_user" @click="formEditarEmpresa(empresa)" style="width: 105px">Editar</button>
								<button type="button" class="btn btn-primary" @click="deletarEmpresa(empresa)" style="width: 105px">Excluir</button>
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

  
</template>

<script>
import { defineComponent, onMounted } from "vue";
import { setCurrentPageTitle } from "@/core/helpers/breadcrumb";
import axios from "axios";

export default {
  name: 'empresa',
  data() {
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
	  ArrayCnaes: []
    } 
  },
  mounted()
  {
	axios.get('cnae/', 
    	{ headers: { Accept: 'application/json' } })
    	.then(res => {
          this.ArrayCnaes = res.data
        })
        .catch(error => console.log(error)),
	axios.get('cidade/', 
        { headers: { Accept: 'application/json' } })
        .then(res => {
          this.ArrayCidades = res.data
        })
        .catch(error => console.log(error))
  },
  methods:
  {
	limparEmpresa()
	{
		this.empnome = '';
		this.empcnpj = '';
		this.emporigem = '';
		this.cidid = '';
		this.cnaeid = '';
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
	carregarEmpresas() // Lista empresas na tabela
	{
		axios.get('empresas/', 
        { headers: { Accept: 'application/json' } })
        .then(res => {
          this.ArrayEmpresas = res.data
        })
        .catch(error => console.log(error))
	},
	pesquisarEmpresas() // Pesquisa de empresas por nome
	{
		axios.get('empresas/filtronome?nome='+this.pesqemp, 
        { headers: { Accept: 'application/json' } })
        .then(res => {
			console.log(res)
          this.ArrayEmpresas = res.data
        })
        .catch(error => console.log(error))
	},
	formEditarEmpresa(empresa) 
	{
		this.empid = empresa.empid;
		this.empnome = empresa.empnome;
		this.empcnpj = empresa.empcnpj;
		this.emporigem = empresa.emporigem;
		this.cidid = empresa.cidid;
		this.cnaeid = empresa.cnaeid;
	},
	atualizarEmpresa() // Editar Empresa
	{		
		var dta ={empnome: this.$data.empnome, 
        empcnpj: this.$data.empcnpj,
        emporigem:this.$data.emporigem,
        cidid: this.$data.cidid,
        cnaeid: this.$data.cnaeid}

		if(this.confirmarForm())
		{
		axios.put('empresas/'+this.$data.empid,dta)
			.then(res => 
			{
				alert("Dados alterados com sucesso!");
				this.carregarEmpresas();
			})
			.catch(error => {console.log(error);})
		}
	},
	deletarEmpresa(empresa)
	{
		if(confirm("Deseja realmente excluir registro? ") == true)
		{
			this.empid = empresa.empid;
			axios.delete('empresas/'+this.empid)
			.then(res => 
			{
				this.carregarEmpresas();
			})
        	.catch(error => {console.log(error);})
		}
		else{ this.carregarEmpresas();}

		
	},
	confirmarForm()
	{
		if(this.empnome == "")
		{ 
			alert("Preencha o nome da empresa !")
			document.getElementById("empnome").onfocus();
			return false;
		}
		else if(this.empcnpj == "")
		{ 
			alert("Preencha o cnpj da empresa !")
			document.getElementById("empcnpj").onfocus();
			return false;
		}
		else if(this.cnaeid == "")
		{ 
			alert("Selecione o CNAE da empresa !")
			document.getElementById("empcnaeid").onfocus();
			return false;
		}
		else if(this.cidid == "")
		{ 
			alert("Selecione uma cidade !")
			document.getElementById("empcidid").onfocus();
			return false;
		}
		else if(this.emporigem == "")
		{ 
			alert("Preencha o origem da empresa !")
			document.getElementById("emporigem").onfocus();
			return false;
		}
		
		
		else{ return true}
	},
	carregarCnae() // Carregar option para CNAE
	{
		axios.get('cnae/', 
        { headers: { Accept: 'application/json' } })
        .then(res => {
          this.ArrayCnaes = res.data
        })
        .catch(error => console.log(error))
	},
	carregarCidades() // Carregar option para Cidades
	{
		axios.get('cidade/', 
        { headers: { Accept: 'application/json' } })
        .then(res => {
          this.ArrayCidades = res.data
        })
        .catch(error => console.log(error))
	}
  },
  created () 
  { 
	  this.carregarEmpresas();
  }, // Carregando lista de empresas na tabela ao abrir pagina
  mutations: {  },
  setup() {
    onMounted(() => {
      setCurrentPageTitle("Empresa");
    });
  },
};
</script>
