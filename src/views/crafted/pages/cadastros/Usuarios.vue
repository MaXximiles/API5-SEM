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
    <input type="text" v-on:keyup="pesquisarUsuarios" v-model="pesqusu" data-kt-user-table-filter="search"  class="form-control form-control-solid w-250px ps-14" placeholder="Pesquisar Usuarios">
    </div>
  </div>  

  <div class="card-toolbar">
    <div class="d-flex justify-content-end" data-kt-user-table-toolbar="base">
    <!--begin::Add user-->
    <button type="button" @click="limparUsuarios()" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#kt_modal_add_user">
      <!--begin::Svg Icon | path: icons/duotune/arrows/arr075.svg-->
      <span class="svg-icon svg-icon-2">
      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
      <rect opacity="0.5" x="11.364" y="20.364" width="16" height="2" rx="1" transform="rotate(-90 11.364 20.364)" fill="currentColor"></rect>
      <rect x="4.36396" y="11.364" width="16" height="2" rx="1" fill="currentColor"></rect>
      </svg>
      </span>
    Adicionar Usuário</button>
  </div>

<!--begin::Group actions-->
<div class="d-flex justify-content-end align-items-center d-none" data-kt-user-table-toolbar="selected">
<div class="fw-bolder me-5">
<span class="me-2" data-kt-user-table-select="selected_count"></span>Selected</div>
<button type="button" class="btn btn-danger" data-kt-user-table-select="delete_selected">Delete Selected</button>
</div>
<!--end::Group actions-->



<!--begin::Modal - Add task-->
<div class="modal fade" id="kt_modal_add_user" tabindex="-1" aria-hidden="true">
  <!--begin::Modal dialog-->
  <div class="modal-dialog modal-dialog-centered mw-650px">
  <!--begin::Modal content-->
  <div class="modal-content">
  <!--begin::Modal header-->
  <div class="modal-header" id="kt_modal_add_user_header">
  <!--begin::Modal title-->
  <h2 class="fw-bolder">Formulário de Usuários</h2>
  <!--end::Modal title-->
  
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
  <form id="kt_modal_add_user_form" @submit.prevent="addUsuario" class="form fv-plugins-bootstrap5 fv-plugins-framework" action="#">
    <div class="d-flex flex-column scroll-y me-n7 pe-7" id="kt_modal_add_user_scroll" data-kt-scroll="true" data-kt-scroll-activate="{default: false, lg: true}" data-kt-scroll-max-height="auto" data-kt-scroll-dependencies="#kt_modal_add_user_header" data-kt-scroll-wrappers="#kt_modal_add_user_scroll" data-kt-scroll-offset="300px" style="">

    <div class="fv-row mb-7 fv-plugins-icon-container">
      <label class="required fw-bold fs-6 mb-2">Nome: </label>
      <input type="text" id="usunome" name="usunome" v-model="usunome" class="form-control form-control-solid mb-3 mb-lg-0" placeholder="Nome do usuário">
      <div class="fv-plugins-message-container invalid-feedback"></div>
    </div>

    <div class="fv-row mb-7 fv-plugins-icon-container">
      <label class="required fw-bold fs-6 mb-2">Email: </label>
      <input type="text" id="usuemail" name="usuemail" v-model="usuemail" class="form-control form-control-solid mb-3 mb-lg-0" placeholder="Email do usuário">
      <div class="fv-plugins-message-container invalid-feedback"></div>
    </div>

    <div class="row mb-7" data-select2-id="select2-data-561-nmjj">
		<div class="col-lg-8 fv-row fv-plugins-icon-container" data-select2-id="select2-data-560-wq70">
			<label class="required fw-bold fs-6 mb-2">Cidade: </label>
			<select id="usucidade" name="usucidade" v-model="usucidade"  data-control="select2" data-placeholder="Selecione o a cidade do Usuario" class="form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible" data-select2-id="select2-data-10-0g0q" tabindex="-1" aria-hidden="true">
			<option value="" data-select2-id="select2-data-12-5j0j"> -- Selecione a Cidade -- </option>
      <option v-for="cidade in ArrayCidades" v-bind:key="cidade.cid_id" :value="cidade.cid_id" data-select2-id="select2-data-12-5j0j">{{ cidade.cid_estado +" - "+cidade.cid_cidade }}</option>
			</select>
			<div class="fv-plugins-message-container invalid-feedback"></div>
		</div>
	</div>

    <div class="fv-row mb-7 fv-plugins-icon-container">
      <label class="required fw-bold fs-6 mb-2">Senha: </label>
      <input type="password" id="ususenha" name="ususenha" v-model="ususenha" class="form-control form-control-solid mb-3 mb-lg-0" placeholder="Digite a senha">
      <div class="fv-plugins-message-container invalid-feedback"></div>
    </div>

    <div class="fv-row mb-7 fv-plugins-icon-container">
      <label class="required fw-bold fs-6 mb-2">Confirme a senha: </label>
      <input type="password" id="ususenha2" name="ususenha2" v-model="ususenha2" class="form-control form-control-solid mb-3 mb-lg-0" placeholder="Confirme a senha">
      <div class="fv-plugins-message-container invalid-feedback"></div>
    </div>

    <div class="row mb-7" data-select2-id="select2-data-561-nmjj">
		<div class="col-lg-8 fv-row fv-plugins-icon-container" data-select2-id="select2-data-560-wq70">
			<label class="required fw-bold fs-6 mb-2">Nível: </label>
			<select id="usunivel" name="usunivel" v-model="usunivel" aria-label="Select a Country" data-control="select2" data-placeholder="Selecione o Nivel do Usuario" class="form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible" data-select2-id="select2-data-10-0g0q" tabindex="-1" aria-hidden="true">
			<option value="" data-select2-id="select2-data-12-5j0j"> -- Selecione o Nivel -- </option>
      <option value="Administrador" data-select2-id="select2-data-12-5j0j">Administrador</option>
      <option value="Inteligência de Vendas" data-select2-id="select2-data-12-5j0j">Inteligência de Vendas</option>
      <option value="Vendedor" data-select2-id="select2-data-12-5j0j">Vendedor</option>
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


          <div>
        </div>
      </form>
    </div>
    </div>
    </div>
    </div>
  </div>
</div>
<!--end::Fim do Formulario-->


<!-- FORMULARIO DE EDITAR -->


<!--begin::Modal - Add task-->
<div class="modal fade" id="kt_modal_editar_user" tabindex="-1" aria-hidden="true">
  <!--begin::Modal dialog-->
  <div class="modal-dialog modal-dialog-centered mw-650px">
  <!--begin::Modal content-->
  <div class="modal-content">
  <!--begin::Modal header-->
  <div class="modal-header" id="kt_modal_add_user_header">
  <!--begin::Modal title-->
  <h2 class="fw-bolder">Formulário de Usuários</h2>
  <!--end::Modal title-->
  
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
  <form id="kt_modal_add_user_form" @submit.prevent="atualizarUsuarios()" class="form fv-plugins-bootstrap5 fv-plugins-framework" action="#">
    <div class="d-flex flex-column scroll-y me-n7 pe-7" id="kt_modal_add_user_scroll" data-kt-scroll="true" data-kt-scroll-activate="{default: false, lg: true}" data-kt-scroll-max-height="auto" data-kt-scroll-dependencies="#kt_modal_add_user_header" data-kt-scroll-wrappers="#kt_modal_add_user_scroll" data-kt-scroll-offset="300px" style="">

    <div class="fv-row mb-7 fv-plugins-icon-container">
      <label class="required fw-bold fs-6 mb-2">Nome: </label>
      <input type="text" id="usunome" name="usunome" v-model="usunome" class="form-control form-control-solid mb-3 mb-lg-0" placeholder="Nome do usuário">
      <div class="fv-plugins-message-container invalid-feedback"></div>
    </div>

    <div class="fv-row mb-7 fv-plugins-icon-container">
      <label class="required fw-bold fs-6 mb-2">Email: </label>
      <input type="text" id="usuemail" name="usuemail" v-model="usuemail" class="form-control form-control-solid mb-3 mb-lg-0" placeholder="Email do usuário">
      <div class="fv-plugins-message-container invalid-feedback"></div>
    </div>
     
    <div class="row mb-7" data-select2-id="select2-data-561-nmjj">
		<div class="col-lg-8 fv-row fv-plugins-icon-container" data-select2-id="select2-data-560-wq70">
			<label class="required fw-bold fs-6 mb-2">Cidade: </label>
			<select id="usucidade" name="usucidade" v-model="usucidade"  data-control="select2" data-placeholder="Selecione o a cidade do Usuario" class="form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible" data-select2-id="select2-data-10-0g0q" tabindex="-1" aria-hidden="true">
			<option value="" data-select2-id="select2-data-12-5j0j"> -- Selecione a Cidade -- </option>
      <option v-for="cidade in ArrayCidades" v-bind:key="cidade.cid_id" :value="cidade.cid_id" data-select2-id="select2-data-12-5j0j">{{ cidade.cid_estado +" - "+cidade.cid_cidade }}</option>
			</select>
			<div class="fv-plugins-message-container invalid-feedback"></div>
		</div>
	</div>

    <div class="fv-row mb-7 fv-plugins-icon-container">
      <label class="required fw-bold fs-6 mb-2">Senha: </label>
      <input type="password" id="ususenha" name="ususenha" v-model="ususenha" class="form-control form-control-solid mb-3 mb-lg-0" placeholder="Digite a senha">
      <div class="fv-plugins-message-container invalid-feedback"></div>
    </div>

    <div class="fv-row mb-7 fv-plugins-icon-container">
      <label class="required fw-bold fs-6 mb-2">Confirme a senha: </label>
      <input type="password" id="ususenha2" name="ususenha2" v-model="ususenha2" class="form-control form-control-solid mb-3 mb-lg-0" placeholder="Confirme a senha">
      <div class="fv-plugins-message-container invalid-feedback"></div>
    </div>

    <div class="row mb-7" data-select2-id="select2-data-561-nmjj">
		<div class="col-lg-8 fv-row fv-plugins-icon-container" data-select2-id="select2-data-560-wq70">
			<label class="required fw-bold fs-6 mb-2">Nível: </label>
			<select id="usunivel" name="usunivel" v-model="usunivel" aria-label="Select a Country" data-control="select2" data-placeholder="Selecione o Nivel do Usuario" class="form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible" data-select2-id="select2-data-10-0g0q" tabindex="-1" aria-hidden="true">
			<option value="" data-select2-id="select2-data-12-5j0j"> -- Selecione o Nivel -- </option>
      <option value="Administrador" data-select2-id="select2-data-12-5j0j">Administrador</option>
      <option value="Inteligência de Vendas" data-select2-id="select2-data-12-5j0j">Inteligência de Vendas</option>
      <option value="Vendedor" data-select2-id="select2-data-12-5j0j">Vendedor</option>
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


          <div>
        </div>
      </form>
    </div>
    </div>
    </div>
    </div>
  </div>
</div>
<!--end::Fim do Formulario-->

<!--begin::Card body-->
<div class="card-body py-4">
<!--begin::Table-->
  <div id="kt_table_users_wrapper" class="dataTables_wrapper dt-bootstrap4 no-footer">
  <div class="table-responsive">
  <table class="table align-middle table-row-dashed fs-6 gy-5 dataTable no-footer" id="kt_table_empresas">
  <!--begin::Table head-->


  <thead>
  <tr class="text-start text-muted fw-bolder fs-7 text-uppercase gs-0">
  <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" style="width: 212.875px;">NOME</th>
  <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" style="width: 125px;">EMAIL</th>
  <th class="min-w-125px sorting" tabindex="0" aria-controls="kt_table_users" rowspan="1" colspan="1" style="width: 125px;">NIVEL</th>
  <th class="text-end min-w-100px sorting_disabled" rowspan="1" colspan="1" aria-label="Actions" style="width: 100px;">AÇÕES</th>
  </tr>
  </thead>

  <tbody class="text-gray-600 fw-bold">

  <tr class="odd" v-for="usuario in ArrayUsuarios" :key="usuario.usuid">
  <td class="align-items-center">
  <div class="d-flex flex-column">
  <span>{{ usuario.usunome }}</span>
  </div>
  </td>

  <td class="align-items-center">
  <div class="d-flex flex-column">
  <span>{{ usuario.usuemail }}</span>
  </div>
  </td>

    <td class="align-items-center">
    <div class="d-flex flex-column">
    <span>{{ usuario.usunivel }}</span>
    </div>
    </td>

    <td class="text-center">
      <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#kt_modal_editar_user" @click="formEditarUsuarios(usuario)" style="width: 105px">Editar</button>
      <button type="button" class="btn btn-primary" @click="deletarUsuario(usuario)" style="width: 105px">Excluir</button>
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
  name: 'usuario',
  data() {
    return {
	    usuid: '',
      usunome: '',
      usuemail: '',
      ususenha: '',
      ususenha2: '',
      usunivel: '',
      usucidade: '',
	    pesqusu: '',
      ArrayUsuarios: [],
      ArrayCidades: []
    }
  },
  methods:
  {
    limparUsuarios()
    {
        this.usunome = '';
        this.usuemail = '';
        this.ususenha = '';
        this.ususenha2 = '';
        this.usunivel = '';
        this.usucidade = '';
    },
    carregarCidades() // Carregar option para Cidades
    {
      axios.get('cidade/', 
          { headers: { Accept: 'application/json' } })
          .then(res => {
            this.ArrayCidades = res.data
          })
          .catch(error => console.log(error))
    },
    addUsuario() //Cadastro de usuarios
    {
      //if(this.ususenha == this.ususenha2) // Confirmando se senha e confirmação de senha coincidem
      if(this.confirmarForm())
      {
          axios.post('usuario/', 
          {  
              usunome: this.usunome, 
              usuemail: this.usuemail,
              ususenha: this.ususenha,
              usunivel: this.usunivel,
              usucidade: this.usucidade
          })
          .then(res => {
            // Limpando campos do formulario
              this.usunome = '';
              this.usuemail = '';
              this.ususenha = '';
              this.ususenha2 = '';
              this.usunivel = '';
              this.usucidade = '';
              alert("Dados inseridos com sucesso!");
            this.carregarUsuarios();
            })
              .catch(error => {console.log(error);})
      }
      
    },
    carregarUsuarios() // Lista usuarios na tabela
    {
      axios.get('usuario/', 
          { headers: { Accept: 'application/json' } })
          .then(res => {
            this.ArrayUsuarios = res.data
          })
          .catch(error => console.log(error))
    },
    pesquisarUsuarios() // Pesquisa de usuarios por nome
    {
      axios.get('usuario/filtronome?nome='+this.pesqusu, 
          { headers: { Accept: 'application/json' } })
          .then(res => {
            this.ArrayUsuarios = res.data
          })
          .catch(error => console.log(error))
    },
    atualizarUsuarios() // Editar Usuario
    {
      if(this.confirmarForm())
      {
        axios.put('usuario/'+this.usuid,
        { 
            usunome: this.$data.usunome, 
            usuemail: this.$data.usuemail,
            ususenha: this.$data.ususenha,
            usunivel: this.$data.usunivel,
            usucidade: this.$data.usucidade
        })
        .then(res => 
        {
          alert("Dados alterados com sucesso!");
          this.carregarUsuarios();
        })
            .catch(error => {console.log(error);})
      }	  
    },
    formEditarUsuarios(usuario)
    {
      this.usuid = usuario.usuid;
      this.usunome = usuario.usunome;
      this.usuemail = usuario.usuemail;
      this.ususenha = usuario.ususenha;
      this.usunivel = usuario.usunivel;
      this.usucidade = usuario.usucidade;
    },
    deletarUsuario(usuario)
    {
      if(confirm("Deseja realmente excluir registro? ") == true)
      {
        this.usuid = usuario.usuid;
        axios.delete('usuario/'+this.usuid)
        .then(res => 
        {
          this.carregarUsuarios();
        })
            .catch(error => {console.log(error);})
      }
      else{ this.carregarUsuarios();}
    },
    confirmarForm()
    {
      if(this.usunome == "")
      { 
        alert("Preencha o nome do Usuário !");
        document.getElementById("usunome").onfocus;
        return false;
      }
      else if(this.usuemail == "")
      { 
        alert("Preencha o email do Usuário !");
        document.getElementById("usuemail").onfocus;
        return false;
      }
      else if(this.ususenha == "" && this.ususenha2 == "")
      { 
        alert("Digite uma senha e confirme !");
        document.getElementById("ususenha").onfocus;
        return false;
      }
      else if(this.ususenha != this.ususenha2)
      {
        alert("Senhas não conferem !");
        document.getElementById("ususenha").onfocus;
        return false;
      }
      else if(this.usucidade == "")
      { 
        alert("Selecione uma cidade !");
        document.getElementById("usucidade").onfocus;
        return false;
      }
      else if(this.usunivel == "")
      { 
        alert("Selecione o nível do Usuário !");
        document.getElementById("usunome").onfocus;
        return false;
      }
      else{return true}
    }
  },
  created () 
  { 
    this.carregarUsuarios(); 
    this.carregarCidades();
  }, // Carregando lista de usuarios na tabela ao abrir pagina
  mutations: {  },
  setup() 
  {
        onMounted(() => { setCurrentPageTitle("Usuários"); });
  },
};
</script>
