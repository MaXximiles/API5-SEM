if(process.env.VUE_APP_USER_NIVEL != ""){ console.log(process.env.VUE_APP_USER_NIVEL)}
else{ console.log("Esta Vazio "+process.env.VUE_APP_USER_NIVEL) }
const DocMenuConfig = [
  {
    pages: [
      {
        heading: "dashboard",
        route: "/dashboard",
        svgIcon: "media/icons/duotune/art/art002.svg",
        fontIcon: "bi-app-indicator",
      }
    ],
  },
  //FIND DATA
  {
    heading: "",
    route: "/crafted",
    pages: [
      {
        sectionTitle: "Cadastros",
        route: "/pages",
        svgIcon: "media/icons/duotune/general/gen022.svg",
        fontIcon: "bi-archive",
        sub: [
          {
            heading: "Empresa",
            route: "/crafted/pages/cadastros/empresa", //Adicionar pagina
          },
          {
            heading: "Usuários",
            route: "/crafted/pages/cadastros/usuarios", //Adicionar pagina
          },
        ],
      },
      {
        sectionTitle: "Carteira Empresa/Vendedor",
        route: "/pages",
        svgIcon: "media/icons/duotune/communication/com006.svg",
        fontIcon: "bi-person",
        sub: [
          {
            heading: "Minhas Empresas",
            route: "/crafted/pages/carteira/minhas-empresas", //Adicionar pagina
          },
          {
            heading: "Prospecção Empresas",
            route: "/crafted/pages/carteira/prospeccao", //Adicionar pagina
          },
        ],
      },
      {
        sectionTitle: "Prospecção de Empresas",
        svgIcon: "media/icons/duotune/technology/teh004.svg",
        fontIcon: "bi-sticky",
        sub: [
          {
            heading: "Busca de Clientes",
            route: "/crafted/pages/prospeccao/busca-cliente", //Adicionar pagina
          },
          {
            heading: "Gerenciar Empresas/Vendedor",
            route: "/crafted/pages/prospeccao/gerenciar-empresas", //Adicionar pagina
          },
        ],
      },
    ],
  },

];

export default DocMenuConfig;
