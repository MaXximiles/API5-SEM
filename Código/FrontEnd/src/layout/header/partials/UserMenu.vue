<template>
  <!--begin::Menu-->
  <div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-600 menu-state-bg-light-primary fw-bold py-4 fs-6 w-275px" data-kt-menu="true" >
    
    <!--begin::Menu item-->
    <div class="menu-item px-3">
      <div class="menu-content d-flex align-items-center px-3">
        <!--begin::Username-->
        <div class="d-flex flex-column">
          <div class="fw-bolder d-flex align-items-center fs-5">
            {{ this.nomeUsuario }}
            <span class="badge badge-light-success fw-bolder fs-8 px-2 py-1 ms-2">{{ this.nivelUsuario }}</span>
          </div>
          <a href="#" class="fw-bold text-muted text-hover-primary fs-7">{{this.emailUsuario}}</a>
        </div>
        <!--end::Username-->
      </div>
    </div>
    <!--end::Menu item-->

     <!--begin::Menu separator-->
        <div class="separator my-2"></div>
        <!--end::Menu separator-->

    <!--begin::Menu item Colocar tela para recuperação de senha-->
    <div class="menu-item px-5">
      <router-link to="/crafted/pages/profile/usuario" class="menu-link px-5">
        Meus Dados
      </router-link>
    </div>
    <!--end::Menu item-->

        <!--begin::Menu separator-->
        <div class="separator my-2"></div>
        <!--end::Menu separator-->

    <!--begin::Menu item-->
    <div class="menu-item px-5">
      <a @click="signOut()" class="menu-link px-5"> Sair do sistema </a>
    </div>
    <!--end::Menu item-->
  </div>
  <!--end::Menu-->

</template>

<script>
import { defineComponent, computed } from "vue";
import { useI18n } from "vue-i18n/index";
import { useStore } from "vuex";
import { useRouter } from "vue-router";
import { Actions } from "@/store/enums/StoreEnums";

export default defineComponent({
  name: "kt-user-menu",
  data()
  {
    return {
      nomeUsuario: '',
      nivelUsuario: '',
      emailUsuario: ''
    }
  },
  created()
  {
    this.nomeUsuario = localStorage.getItem("loginNome"),
    this.nivelUsuario = localStorage.getItem("loginNivel")
    this.emailUsuario = localStorage.getItem("loginEmail")
  },
  setup() 
  {
    const router = useRouter();
    const i18n = useI18n();
    const store = useStore();

    const signOut = () => {
      localStorage.clear();
      store
        .dispatch(Actions.LOGOUT)
        .then(() => router.push({ name: "sign-in" }));
    };

    return {
      signOut
    };
  },
});
</script>


