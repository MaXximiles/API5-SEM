const DocMenuConfig = [
  {
    pages: [
      {
        heading: "dashboard",
        route: "/dashboard",
        svgIcon: "media/icons/duotune/art/art002.svg",
        fontIcon: "bi-app-indicator",
      },
      /*{
        heading: "layoutBuilder",
        route: "/builder",
        svgIcon: "media/icons/duotune/general/gen019.svg",
        fontIcon: "bi-layers",
      },*/
    ],
  },
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
            route: "#",//Adicionar pagina
          },
          {
            heading: "Vendedores",
            route: "#",//Adicionar pagina
          },
          {
            heading: "Inteligência de Vendas",
            route: "#",//Adicionar pagina
          },
        ],
      },
      {
        sectionTitle: "Carteira Empresa/Vendedor",
        route: "/account",
        svgIcon: "media/icons/duotune/communication/com006.svg",
        fontIcon: "bi-person",
        sub: [
          {
            heading: "Minhas Empresas",
            route: "#",//Adicionar pagina
          },
          {
            heading: "Prospecção Empresas",
            route: "#",//Adicionar pagina
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
              route: "#",//Adicionar pagina
          },
          {
            heading: "Gerenciar Empresas/Vendedor",
            route: "#",//Adicionar pagina
          },
        ],
      },
      /*{
        sectionTitle: "modals",
        route: "/modals",
        svgIcon: "media/icons/duotune/art/art009.svg",
        fontIcon: "bi-shield-check",
        sub: [
          {
            sectionTitle: "general",
            route: "/general",
            sub: [
              {
                heading: "inviteFriends",
                route: "/crafted/modals/general/invite-friends",
              },
              {
                heading: "viewUsers",
                route: "/crafted/modals/general/view-user",
              },
              {
                heading: "upgradePlan",
                route: "/crafted/modals/general/upgrade-plan",
              },
              {
                heading: "shareAndEarn",
                route: "/crafted/modals/general/share-and-earn",
              },
            ],
          },
          {
            sectionTitle: "forms",
            route: "/forms",
            sub: [
              {
                heading: "newTarget",
                route: "/crafted/modals/forms/new-target",
              },
              {
                heading: "newCard",
                route: "/crafted/modals/forms/new-card",
              },
              {
                heading: "newAddress",
                route: "/crafted/modals/forms/new-address",
              },
              {
                heading: "createAPIKey",
                route: "/crafted/modals/forms/create-api-key",
              },
            ],
          },
          {
            sectionTitle: "wizards",
            route: "/wizards",
            sub: [
              {
                heading: "twoFactorAuth",
                route: "/crafted/modals/wizards/two-factor-auth",
              },
              {
                heading: "createApp",
                route: "/crafted/modals/wizards/create-app",
              },
              {
                heading: "createAccount",
                route: "/crafted/modals/wizards/create-account",
              },
            ],
          },
        ],
      },
      {
        sectionTitle: "widgets",
        route: "/widgets",
        svgIcon: "media/icons/duotune/general/gen025.svg",
        fontIcon: "bi-layers",
        sub: [
          {
            heading: "widgetsLists",
            route: "/crafted/widgets/lists",
          },
          {
            heading: "widgetsStatistics",
            route: "/crafted/widgets/statistics",
          },
          {
            heading: "widgetsCharts",
            route: "/crafted/widgets/charts",
          },
          {
            heading: "widgetsMixed",
            route: "/crafted/widgets/mixed",
          },
          {
            heading: "widgetsTables",
            route: "/crafted/widgets/tables",
          },
          {
            heading: "widgetsFeeds",
            route: "/crafted/widgets/feeds",
          },
        ],
      },*/
    ],
  },
 
];

export default DocMenuConfig;
