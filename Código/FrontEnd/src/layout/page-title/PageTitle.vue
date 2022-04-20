<template>
  <!--begin::Page title-->
  <!--begin::Title-->
  <h1 class="d-flex align-items-center text-dark fw-bolder my-1 fs-3"></h1>
  <!--end::Title-->
  <!--end::Page title-->
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "kt-page-title",
  props: {
    breadcrumbs: Array,
    title: String,
  },
  component: {},
});
</script>
