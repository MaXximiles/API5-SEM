<template>
 
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
  <!--begin::Close-->
  <div class="btn btn-icon btn-sm btn-active-icon-primary" data-kt-users-modal-action="close">
  <!--begin::Svg Icon | path: icons/duotune/arrows/arr061.svg-->
  <span class="svg-icon svg-icon-1">
  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
  <rect opacity="0.5" x="6" y="17.3137" width="16" height="2" rx="1" transform="rotate(-45 6 17.3137)" fill="currentColor"></rect>
  <rect x="7.41422" y="6" width="16" height="2" rx="1" transform="rotate(45 7.41422 6)" fill="currentColor"></rect>
  </svg>
  </span>
  </div>
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


    <div class="fv-row mb-7 fv-plugins-icon-container">
      <label class="required fw-bold fs-6 mb-2">Nível: </label>
      <select id="usunivel" name="usunivel" v-model="usunivel" class="form-control form-control-solid mb-3 mb-lg-0" disabled>
        <option >Administrador</option>
        <option >Vendedor</option>
        <option >Inteligência de Vendas</option>
      </select>
      <div class="fv-plugins-message-container invalid-feedback"></div>
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

<!--end::Fim do Formulario-->

</template>

<script lang="ts">
import { defineComponent, onMounted } from "vue";
import { setCurrentPageTitle } from "@/core/helpers/breadcrumb";

export default defineComponent({
  name: "Meus Dados",
  components: 
  {
    
  },
  setup() 
  {
    onMounted(() => { setCurrentPageTitle("Meus Dados");});
  },
});
</script>
