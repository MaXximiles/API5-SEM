<template>
  <!--begin::Dashboard-->
  <div style="width: 100%">
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
                  <input
                    type="text"
                    id="usunome"
                    name="usunome"
                    v-model="usunome"
                    class="form-control form-control-solid"
                    placeholder="Nome do usuário"
                  />
                  <div
                    class="fv-plugins-message-container invalid-feedback"
                  ></div>
                </div>

                <div class="fv-row mb-7 fv-plugins-icon-container">
                  <label class="required fw-bold fs-6 mb-2">Email: </label>
                  <input
                    type="text"
                    id="usuemail"
                    name="usuemail"
                    v-model="usuemail"
                    class="form-control form-control-solid mb-3 mb-lg-0"
                    placeholder="Email do usuário"
                  />
                  <div
                    class="fv-plugins-message-container invalid-feedback"
                  ></div>
                </div>

                <div class="fv-row mb-7 fv-plugins-icon-container">
                  <label class="required fw-bold fs-6 mb-2">Senha: </label>
                  <input
                    type="password"
                    id="ususenha"
                    name="ususenha"
                    v-model="ususenha"
                    class="form-control form-control-solid mb-3 mb-lg-0"
                    placeholder="Digite a senha"
                  />
                  <div
                    class="fv-plugins-message-container invalid-feedback"
                  ></div>
                </div>

                <div class="fv-row mb-7 fv-plugins-icon-container">
                  <label class="required fw-bold fs-6 mb-2"
                    >Confirme a senha:
                  </label>
                  <input
                    type="password"
                    id="ususenha2"
                    name="ususenha2"
                    v-model="ususenha2"
                    class="form-control form-control-solid mb-3 mb-lg-0"
                    placeholder="Confirme a senha"
                  />
                  <div
                    class="fv-plugins-message-container invalid-feedback"
                  ></div>
                </div>

                <div class="fv-row mb-7 fv-plugins-icon-container">
                  <label class="required fw-bold fs-6 mb-2">Nível: </label>
                  <select
                    id="usunivel"
                    name="usunivel"
                    v-model="usunivel"
                    class="form-control form-control-solid mb-3 mb-lg-0"
                  >
                    <option>Administrador</option>
                    <option>Vendedor</option>
                    <option>Inteligência de Vendas</option>
                  </select>
                  <div
                    class="fv-plugins-message-container invalid-feedback"
                  ></div>
                </div>
              </div>

              <div class="text-center pt-15">
                <button
                  type="reset"
                  class="btn btn-light me-3"
                  data-kt-users-modal-action="cancel"
                >
                  Descartar
                </button>
                <button
                  type="submit"
                  class="btn btn-primary"
                  data-kt-users-modal-action="submit"
                >
                  <span class="indicator-label">Salvar</span>
                  <span class="indicator-progress"
                    >Carregando...
                    <span
                      class="spinner-border spinner-border-sm align-middle ms-2"
                    ></span
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
  <!--end::Dashboard-->
</template>

<script lang="ts">
import { defineComponent, onMounted } from "vue";

import { setCurrentPageTitle } from "@/core/helpers/breadcrumb";

export default defineComponent({
  name: "profile",
  components: {},
  setup() {
    onMounted(() => {
      setCurrentPageTitle("Meu Perfil");
    });
  },
});
</script>
