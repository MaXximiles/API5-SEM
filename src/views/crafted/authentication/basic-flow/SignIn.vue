<template>

  <div class="w-lg-500px bg-white rounded shadow-sm p-10 p-lg-15 mx-auto">

    <Form class="form w-100" id="kt_login_signin_form" @submit="onSubmitLogin" :validation-schema="login">
     

      <div class="mb-10 bg-light-info p-8 rounded">
        <div class="text-info">
          Utilize o email: <strong>admin@demo.com</strong> e a senha: <strong>demo</strong> para acessar.
        </div>
      </div>

      <div class="fv-row mb-10">
        <label class="form-label fs-6 fw-bolder text-dark">Email</label>
        <Field class="form-control form-control-lg form-control-solid" type="text" name="email" placeholder="Email" autocomplete="off"/>

        <div class="fv-plugins-message-container">
          <div class="fv-help-block">
            <ErrorMessage name="email" />
          </div>
        </div>
      </div>

      <div class="fv-row mb-10">
        <div class="d-flex flex-stack mb-2">
          <label class="form-label fw-bolder text-dark fs-6 mb-0">Password</label>
          <router-link to="/password-reset" class="link-primary fs-6 fw-bolder">Esqueceu sua senha?</router-link>
        </div>

        <Field class="form-control form-control-lg form-control-solid" type="password" name="password" placeholder="Senha" autocomplete="off" />

        <div class="fv-plugins-message-container">
          <div class="fv-help-block">
            <ErrorMessage name="password" />
          </div>
        </div>
      </div>

      <div class="text-center">
        <button type="submit" ref="submitButton" id="kt_sign_in_submit" class="btn btn-lg btn-primary w-100 mb-5">
          <span class="indicator-label"> Acessar </span>

          <span class="indicator-progress">Carregando...
            <span class="spinner-border spinner-border-sm align-middle ms-2" ></span>
          </span>
        </button>
      </div>

    </Form>

  </div>

</template>

<script lang="ts">
import { defineComponent, ref } from "vue";
import { ErrorMessage, Field, Form } from "vee-validate";
import { Actions } from "@/store/enums/StoreEnums";
import { useStore } from "vuex";
import { useRouter } from "vue-router";
import Swal from "sweetalert2/dist/sweetalert2.min.js";
import * as Yup from "yup";

export default defineComponent({
  name: "sign-in",
  components: {
    Field,
    Form,
    ErrorMessage,
  },
  setup() {
    const store = useStore();
    const router = useRouter();

    const submitButton = ref<HTMLButtonElement | null>(null);

    //Create form validation object
    const login = Yup.object().shape({
      email: Yup.string().email().required().label("Email"),
      password: Yup.string().min(4).required().label("Password"),
    });

    //Form submit function
    const onSubmitLogin = async (values) => 
    {
      // Clear existing errors
      store.dispatch(Actions.LOGOUT);

      if (submitButton.value)
      {
        // eslint-disable-next-line
        submitButton.value!.disabled = true;
        // Activate indicator
        submitButton.value.setAttribute("data-kt-indicator", "on");
      }

      // Send login request
      await store.dispatch(Actions.LOGIN, values);
      const [errorName] = Object.keys(store.getters.getErrors);
      const error = store.getters.getErrors[errorName];

      if (!error) 
      {
        Swal.fire({
          text: "Login realizado com sucesso!",
          icon: "success",
          buttonsStyling: false,
          confirmButtonText: "Ok, Vamos lá!",
          customClass: {
            confirmButton: "btn fw-bold btn-light-primary",
          },
        }).then(function () {
          // Go to page after successfully login
          router.push({ name: "dashboard" });
        });
      } else {
        Swal.fire({
          text: error[0],
          icon: "error",
          buttonsStyling: false,
          confirmButtonText: "Try again!",
          customClass: {
            confirmButton: "btn fw-bold btn-light-danger",
          },
        });
      }

      //Deactivate indicator
      submitButton.value?.removeAttribute("data-kt-indicator");
      // eslint-disable-next-line
        submitButton.value!.disabled = false;
    };

    return {
      onSubmitLogin,
      login,
      submitButton,
    };
  },
});
</script>
