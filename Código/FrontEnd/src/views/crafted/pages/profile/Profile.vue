<template>


  <div class="card">
    <td class="" style="width: 100%; min-width: 800px; align: center">
      <!--begin::Modal dialog-->
      <div class="container" style="">
        <!--begin::Modal content-->
        <div class="modal-content">
          <!--begin::Modal header-->

          <div class="modal-body" style="">
            <form>
              <div class="d-flex flex-column container" style="max-width: 100%">
                <div class="fv-row mb-7 fv-plugins-icon-container">
                  <label class="required fw-bold fs-6 mb-2">Nome: </label>
                  <input type="text" id="usunome1" name="usunome1" v-model="usunome1" class="form-control form-control-solid" placeholder="Nome do usuário" />
                  <div class="fv-plugins-message-container invalid-feedback" ></div>
                </div>

                <div class="fv-row mb-7 fv-plugins-icon-container">
                  <label class="required fw-bold fs-6 mb-2">Email: </label>
                  <input type="text" id="usuemail1" name="usuemail1" v-model="usuemail1" class="form-control form-control-solid mb-3 mb-lg-0" placeholder="Email do usuário" />
                  <div class="fv-plugins-message-container invalid-feedback" ></div>
                </div>

                <div class="fv-row mb-7 fv-plugins-icon-container">
                  <label class="required fw-bold fs-6 mb-2">Senha: </label>
                  <input type="password" id="ususenha1" name="ususenha1" v-model="ususenha1" @change="mudarSenha()" class="form-control form-control-solid mb-3 mb-lg-0" placeholder="Digite a senha" />
                  <div class="fv-plugins-message-container invalid-feedback" ></div>
                </div>

                <div class="fv-row mb-7 fv-plugins-icon-container">
                  <label class="required fw-bold fs-6 mb-2">Confirme a senha:
                  </label>
                  <input type="password" id="ususenha21" name="ususenha21" v-model="ususenha21" class="form-control form-control-solid mb-3 mb-lg-0" placeholder="Confirme a senha"/>
                  <div class="fv-plugins-message-container invalid-feedback" ></div>
                </div>

                <div class="fv-row mb-7 fv-plugins-icon-container">
                  <label class="required fw-bold fs-6 mb-2">Nível: </label>
                  <select id="usunivel1" name="usunivel1" v-model="usunivel1" class="form-control form-control-solid mb-3 mb-lg-0" >
                    <option>Administrador</option>
                    <option>Vendedor</option>
                    <option>Inteligência de Vendas</option>
                  </select>
                  <div class="fv-plugins-message-container invalid-feedback" ></div>
                </div>
              </div>

              <div class="text-center pt-15">
                <button type="reset" class="btn btn-light me-3" data-kt-users-modal-action="cancel" > Descartar </button>
                <button type="button" @click="atualizarUsuario()" class="btn btn-primary" data-kt-users-modal-action="submit" >
                  <span class="indicator-label">Salvar</span>
                  <span class="indicator-progress" >Carregando... <span class="spinner-border spinner-border-sm align-middle ms-2" ></span
                  ></span>
                </button>
              </div>

              <div></div>
            </form>
          </div>
        </div>
      </div>

      <!--end::Fim do Formulario-->
    </td>
  </div>

</template>

<script lang="ts">
import { defineComponent, onMounted } from "vue";
import { setCurrentPageTitle } from "@/core/helpers/breadcrumb";
import axios from "axios";

export default defineComponent({
  name: 'profile',
  data() {
    return {
	    usuid1: '',
      usunome1: '',
      usuemail1: '',
      ususenha1: '',
      ususenha21: '',
      usunivel1: '',
      mudarsenha: 0,
    }
  },
  methods:
  {
    carregarUsuario()
    {
      var idUsu = localStorage.getItem("loginId");
      axios.get('usuario/'+idUsu, 
        { headers: { Accept: 'application/json' } })
        .then(res => {
          this.usuid1 = res.data.usuid;
          this.usunome1 = res.data.usunome;
          this.usuemail1 = res.data.usuemail;
          this.ususenha1 = res.data.ususenha;
          this.usunivel1 = res.data.usunivel;
        })
        .catch(error => console.log(error))
    },
    limparUsuarios()
    {
      this.usunome1 = '';
      this.usuemail1 = '';
      this.ususenha1 = '';
      this.ususenha21 = '';
      this.usunivel1 = '';
    },
	atualizarUsuario() // Editar Usuario
	{
    if(this.confereFormulario())
    {
      axios.put('usuario/'+this.usuid1,
      { 
        usunome: this.$data.usunome1, 
        usuemail: this.$data.usuemail1,
        ususenha: this.$data.ususenha1,
        usunivel: this.$data.usunivel1
      })
      .then(res => {alert("Dados alterados com sucesso!");})
      .catch(error => {console.log(error);})
    }
	},
  mudarSenha(){this.mudarsenha = 1;},
  confereFormulario()
  {
    if(this.mudarsenha == 1)
    {
      if(this.ususenha1 == this.ususenha21) { return true; }
      else 
      {
        alert("Senhas não conferem !");
        document.getElementById("ususenha")?.focus();
        return false;
      }
    }
    else { return true; }
  }
	
},
  created() { this.carregarUsuario(); },
  setup() { onMounted(() => {setCurrentPageTitle("Meu Perfil");}); },
});
</script>
