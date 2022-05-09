"use strict";(self["webpackChunkdemo1"]=self["webpackChunkdemo1"]||[]).push([[7414],{68932:function(e,s,a){a.d(s,{M:function(){return i},V:function(){return o}});var t=a(61107),l=a(15758),i=function(e,s){t.Z.dispatch(l.e.SET_BREADCRUMB_ACTION,{title:e,pageBreadcrumbPath:s})},o=function(e){t.Z.dispatch(l.e.SET_BREADCRUMB_ACTION,{title:e})}},37414:function(e,s,a){a.r(s),a.d(s,{default:function(){return Re}});var t=a(66252),l=a(49963),i=a(3577);const o={id:"kt_content_container",class:"container-xxl"},n={class:"card"},r={class:"card-header border-0 pt-6"},d={class:"card-title"},u={class:"d-flex align-items-center position-relative my-1"},c=(0,t._)("span",{class:"svg-icon svg-icon-1 position-absolute ms-6"},[(0,t._)("svg",{xmlns:"http://www.w3.org/2000/svg",width:"24",height:"24",viewBox:"0 0 24 24",fill:"none"},[(0,t._)("rect",{opacity:"0.5",x:"17.0365",y:"15.1223",width:"8.15546",height:"2",rx:"1",transform:"rotate(45 17.0365 15.1223)",fill:"currentColor"}),(0,t._)("path",{d:"M11 19C6.55556 19 3 15.4444 3 11C3 6.55556 6.55556 3 11 3C15.4444 3 19 6.55556 19 11C19 15.4444 15.4444 19 11 19ZM11 5C7.53333 5 5 7.53333 5 11C5 14.4667 7.53333 17 11 17C14.4667 17 17 14.4667 17 11C17 7.53333 14.4667 5 11 5Z",fill:"currentColor"})])],-1),m={class:"card-toolbar"},p={class:"d-flex justify-content-end","data-kt-user-table-toolbar":"base"},h=(0,t._)("span",{class:"svg-icon svg-icon-2"},[(0,t._)("svg",{xmlns:"http://www.w3.org/2000/svg",width:"24",height:"24",viewBox:"0 0 24 24",fill:"none"},[(0,t._)("rect",{opacity:"0.5",x:"11.364",y:"20.364",width:"16",height:"2",rx:"1",transform:"rotate(-90 11.364 20.364)",fill:"currentColor"}),(0,t._)("rect",{x:"4.36396",y:"11.364",width:"16",height:"2",rx:"1",fill:"currentColor"})])],-1),f=(0,t.Uk)(" Adicionar Usuário"),_=[h,f],b=(0,t._)("div",{class:"d-flex justify-content-end align-items-center d-none","data-kt-user-table-toolbar":"selected"},[(0,t._)("div",{class:"fw-bolder me-5"},[(0,t._)("span",{class:"me-2","data-kt-user-table-select":"selected_count"}),(0,t.Uk)("Selected")]),(0,t._)("button",{type:"button",class:"btn btn-danger","data-kt-user-table-select":"delete_selected"},"Delete Selected")],-1),v={class:"modal fade",id:"kt_modal_add_user",tabindex:"-1","aria-hidden":"true"},g={class:"modal-dialog modal-dialog-centered mw-650px"},w={class:"modal-content"},y=(0,t.uE)('<div class="modal-header" id="kt_modal_add_user_header"><h2 class="fw-bolder">Formulário de Usuários</h2><div class="btn btn-sm btn-icon btn-active-color-primary" data-bs-dismiss="modal"><span class="svg-icon svg-icon-1"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"><rect opacity="0.5" x="6" y="17.3137" width="16" height="2" rx="1" transform="rotate(-45 6 17.3137)" fill="currentColor"></rect><rect x="7.41422" y="6" width="16" height="2" rx="1" transform="rotate(45 7.41422 6)" fill="currentColor"></rect></svg></span></div></div>',1),x={class:"modal-body scroll-y mx-5 mx-xl-15 my-7"},k={class:"d-flex flex-column scroll-y me-n7 pe-7",id:"kt_modal_add_user_scroll","data-kt-scroll":"true","data-kt-scroll-activate":"{default: false, lg: true}","data-kt-scroll-max-height":"auto","data-kt-scroll-dependencies":"#kt_modal_add_user_header","data-kt-scroll-wrappers":"#kt_modal_add_user_scroll","data-kt-scroll-offset":"300px",style:{}},U={class:"fv-row mb-7 fv-plugins-icon-container"},C=(0,t._)("label",{class:"required fw-bold fs-6 mb-2"},"Nome: ",-1),j=(0,t._)("div",{class:"fv-plugins-message-container invalid-feedback"},null,-1),E={class:"fv-row mb-7 fv-plugins-icon-container"},q=(0,t._)("label",{class:"required fw-bold fs-6 mb-2"},"Email: ",-1),V=(0,t._)("div",{class:"fv-plugins-message-container invalid-feedback"},null,-1),S={class:"fv-row mb-7 fv-plugins-icon-container"},A=(0,t._)("label",{class:"required fw-bold fs-6 mb-2"},"Senha: ",-1),B=(0,t._)("div",{class:"fv-plugins-message-container invalid-feedback"},null,-1),D={class:"fv-row mb-7 fv-plugins-icon-container"},I=(0,t._)("label",{class:"required fw-bold fs-6 mb-2"},"Confirme a senha: ",-1),N=(0,t._)("div",{class:"fv-plugins-message-container invalid-feedback"},null,-1),M={class:"row mb-7","data-select2-id":"select2-data-561-nmjj"},T={class:"col-lg-8 fv-row fv-plugins-icon-container","data-select2-id":"select2-data-560-wq70"},z=(0,t._)("label",{class:"required fw-bold fs-6 mb-2"},"Origem: ",-1),F=(0,t._)("option",{value:"","data-select2-id":"select2-data-12-5j0j"}," -- Selecione o Nivel -- ",-1),O=(0,t._)("option",{value:"Administrador","data-select2-id":"select2-data-12-5j0j"},"Administrador",-1),Z=(0,t._)("option",{value:"Inteligência de Vendas","data-select2-id":"select2-data-12-5j0j"},"Inteligência de Vendas",-1),P=(0,t._)("option",{value:"Vendedor","data-select2-id":"select2-data-12-5j0j"},"Vendedor",-1),R=[F,O,Z,P],$=(0,t._)("div",{class:"fv-plugins-message-container invalid-feedback"},null,-1),H=(0,t.uE)('<div class="text-center pt-15"><button type="reset" class="btn btn-light me-3" data-kt-users-modal-action="cancel">Descartar</button><button type="submit" class="btn btn-primary" data-kt-users-modal-action="submit"><span class="indicator-label">Salvar</span><span class="indicator-progress">Carregando... <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span></button></div><div></div>',2),K={class:"modal fade",id:"kt_modal_editar_user",tabindex:"-1","aria-hidden":"true"},L={class:"modal-dialog modal-dialog-centered mw-650px"},Y={class:"modal-content"},G=(0,t.uE)('<div class="modal-header" id="kt_modal_add_user_header"><h2 class="fw-bolder">Formulário de Usuários</h2><div class="btn btn-sm btn-icon btn-active-color-primary" data-bs-dismiss="modal"><span class="svg-icon svg-icon-1"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"><rect opacity="0.5" x="6" y="17.3137" width="16" height="2" rx="1" transform="rotate(-45 6 17.3137)" fill="currentColor"></rect><rect x="7.41422" y="6" width="16" height="2" rx="1" transform="rotate(45 7.41422 6)" fill="currentColor"></rect></svg></span></div></div>',1),J={class:"modal-body scroll-y mx-5 mx-xl-15 my-7"},Q={class:"d-flex flex-column scroll-y me-n7 pe-7",id:"kt_modal_add_user_scroll","data-kt-scroll":"true","data-kt-scroll-activate":"{default: false, lg: true}","data-kt-scroll-max-height":"auto","data-kt-scroll-dependencies":"#kt_modal_add_user_header","data-kt-scroll-wrappers":"#kt_modal_add_user_scroll","data-kt-scroll-offset":"300px",style:{}},W={class:"fv-row mb-7 fv-plugins-icon-container"},X=(0,t._)("label",{class:"required fw-bold fs-6 mb-2"},"Nome: ",-1),ee=(0,t._)("div",{class:"fv-plugins-message-container invalid-feedback"},null,-1),se={class:"fv-row mb-7 fv-plugins-icon-container"},ae=(0,t._)("label",{class:"required fw-bold fs-6 mb-2"},"Email: ",-1),te=(0,t._)("div",{class:"fv-plugins-message-container invalid-feedback"},null,-1),le={class:"fv-row mb-7 fv-plugins-icon-container"},ie=(0,t._)("label",{class:"required fw-bold fs-6 mb-2"},"Senha: ",-1),oe=(0,t._)("div",{class:"fv-plugins-message-container invalid-feedback"},null,-1),ne={class:"fv-row mb-7 fv-plugins-icon-container"},re=(0,t._)("label",{class:"required fw-bold fs-6 mb-2"},"Confirme a senha: ",-1),de=(0,t._)("div",{class:"fv-plugins-message-container invalid-feedback"},null,-1),ue={class:"row mb-7","data-select2-id":"select2-data-561-nmjj"},ce={class:"col-lg-8 fv-row fv-plugins-icon-container","data-select2-id":"select2-data-560-wq70"},me=(0,t._)("label",{class:"required fw-bold fs-6 mb-2"},"Origem: ",-1),pe=(0,t._)("option",{value:"","data-select2-id":"select2-data-12-5j0j"}," -- Selecione o Nivel -- ",-1),he=(0,t._)("option",{value:"Administrador","data-select2-id":"select2-data-12-5j0j"},"Administrador",-1),fe=(0,t._)("option",{value:"Inteligência de Vendas","data-select2-id":"select2-data-12-5j0j"},"Inteligência de Vendas",-1),_e=(0,t._)("option",{value:"Vendedor","data-select2-id":"select2-data-12-5j0j"},"Vendedor",-1),be=[pe,he,fe,_e],ve=(0,t._)("div",{class:"fv-plugins-message-container invalid-feedback"},null,-1),ge=(0,t.uE)('<div class="text-center pt-15"><button type="reset" class="btn btn-light me-3" data-kt-users-modal-action="cancel">Descartar</button><button type="submit" class="btn btn-primary" data-kt-users-modal-action="submit"><span class="indicator-label">Salvar</span><span class="indicator-progress">Carregando... <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span></button></div><div></div>',2),we={class:"card-body py-4"},ye={id:"kt_table_users_wrapper",class:"dataTables_wrapper dt-bootstrap4 no-footer"},xe={class:"table-responsive"},ke={class:"table align-middle table-row-dashed fs-6 gy-5 dataTable no-footer",id:"kt_table_empresas"},Ue=(0,t._)("thead",null,[(0,t._)("tr",{class:"text-start text-muted fw-bolder fs-7 text-uppercase gs-0"},[(0,t._)("th",{class:"min-w-125px sorting",tabindex:"0","aria-controls":"kt_table_users",rowspan:"1",colspan:"1",style:{width:"212.875px"}},"NOME"),(0,t._)("th",{class:"min-w-125px sorting",tabindex:"0","aria-controls":"kt_table_users",rowspan:"1",colspan:"1",style:{width:"125px"}},"EMAIL"),(0,t._)("th",{class:"min-w-125px sorting",tabindex:"0","aria-controls":"kt_table_users",rowspan:"1",colspan:"1",style:{width:"125px"}},"NIVEL"),(0,t._)("th",{class:"text-end min-w-100px sorting_disabled",rowspan:"1",colspan:"1","aria-label":"Actions",style:{width:"100px"}},"AÇÕES")])],-1),Ce={class:"text-gray-600 fw-bold"},je={class:"align-items-center"},Ee={class:"d-flex flex-column"},qe={class:"align-items-center"},Ve={class:"d-flex flex-column"},Se={class:"align-items-center"},Ae={class:"d-flex flex-column"},Be={class:"text-center"},De=["onClick"],Ie=["onClick"],Ne=(0,t._)("div",{class:"row"},[(0,t._)("div",{class:"col-sm-12 col-md-5 d-flex align-items-center justify-content-center justify-content-md-start"}),(0,t._)("div",{class:"col-sm-12 col-md-7 d-flex align-items-center justify-content-center justify-content-md-end"})],-1);function Me(e,s,a,h,f,F){return(0,t.wg)(),(0,t.iD)(t.HY,null,[(0,t._)("div",o,[(0,t._)("div",n,[(0,t._)("div",r,[(0,t._)("div",d,[(0,t._)("div",u,[c,(0,t.wy)((0,t._)("input",{type:"text",onKeyup:s[0]||(s[0]=(...e)=>F.pesquisarUsuarios&&F.pesquisarUsuarios(...e)),"onUpdate:modelValue":s[1]||(s[1]=e=>f.pesqusu=e),"data-kt-user-table-filter":"search",class:"form-control form-control-solid w-250px ps-14",placeholder:"Pesquisar Usuarios"},null,544),[[l.nr,f.pesqusu]])])]),(0,t._)("div",m,[(0,t._)("div",p,[(0,t._)("button",{type:"button",onClick:s[2]||(s[2]=e=>F.limparUsuarios()),class:"btn btn-primary","data-bs-toggle":"modal","data-bs-target":"#kt_modal_add_user"},_)]),b,(0,t._)("div",v,[(0,t._)("div",g,[(0,t._)("div",w,[y,(0,t._)("div",x,[(0,t._)("form",{id:"kt_modal_add_user_form",onSubmit:s[8]||(s[8]=(0,l.iM)(((...e)=>F.addUsuario&&F.addUsuario(...e)),["prevent"])),class:"form fv-plugins-bootstrap5 fv-plugins-framework",action:"#"},[(0,t._)("div",k,[(0,t._)("div",U,[C,(0,t.wy)((0,t._)("input",{type:"text",id:"usunome",name:"usunome","onUpdate:modelValue":s[3]||(s[3]=e=>f.usunome=e),class:"form-control form-control-solid mb-3 mb-lg-0",placeholder:"Nome do usuário"},null,512),[[l.nr,f.usunome]]),j]),(0,t._)("div",E,[q,(0,t.wy)((0,t._)("input",{type:"text",id:"usuemail",name:"usuemail","onUpdate:modelValue":s[4]||(s[4]=e=>f.usuemail=e),class:"form-control form-control-solid mb-3 mb-lg-0",placeholder:"Email do usuário"},null,512),[[l.nr,f.usuemail]]),V]),(0,t._)("div",S,[A,(0,t.wy)((0,t._)("input",{type:"password",id:"ususenha",name:"ususenha","onUpdate:modelValue":s[5]||(s[5]=e=>f.ususenha=e),class:"form-control form-control-solid mb-3 mb-lg-0",placeholder:"Digite a senha"},null,512),[[l.nr,f.ususenha]]),B]),(0,t._)("div",D,[I,(0,t.wy)((0,t._)("input",{type:"password",id:"ususenha2",name:"ususenha2","onUpdate:modelValue":s[6]||(s[6]=e=>f.ususenha2=e),class:"form-control form-control-solid mb-3 mb-lg-0",placeholder:"Confirme a senha"},null,512),[[l.nr,f.ususenha2]]),N]),(0,t._)("div",M,[(0,t._)("div",T,[z,(0,t.wy)((0,t._)("select",{id:"usunivel",name:"usunivel","onUpdate:modelValue":s[7]||(s[7]=e=>f.usunivel=e),"aria-label":"Select a Country","data-control":"select2","data-placeholder":"Selecione o Nivel do Usuario",class:"form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible","data-select2-id":"select2-data-10-0g0q",tabindex:"-1","aria-hidden":"true"},R,512),[[l.bM,f.usunivel]]),$])])]),H],32)])])])])])]),(0,t._)("div",K,[(0,t._)("div",L,[(0,t._)("div",Y,[G,(0,t._)("div",J,[(0,t._)("form",{id:"kt_modal_add_user_form",onSubmit:s[14]||(s[14]=(0,l.iM)((e=>F.atualizarUsuarios()),["prevent"])),class:"form fv-plugins-bootstrap5 fv-plugins-framework",action:"#"},[(0,t._)("div",Q,[(0,t._)("div",W,[X,(0,t.wy)((0,t._)("input",{type:"text",id:"usunome",name:"usunome","onUpdate:modelValue":s[9]||(s[9]=e=>f.usunome=e),class:"form-control form-control-solid mb-3 mb-lg-0",placeholder:"Nome do usuário"},null,512),[[l.nr,f.usunome]]),ee]),(0,t._)("div",se,[ae,(0,t.wy)((0,t._)("input",{type:"text",id:"usuemail",name:"usuemail","onUpdate:modelValue":s[10]||(s[10]=e=>f.usuemail=e),class:"form-control form-control-solid mb-3 mb-lg-0",placeholder:"Email do usuário"},null,512),[[l.nr,f.usuemail]]),te]),(0,t._)("div",le,[ie,(0,t.wy)((0,t._)("input",{type:"password",id:"ususenha",name:"ususenha","onUpdate:modelValue":s[11]||(s[11]=e=>f.ususenha=e),class:"form-control form-control-solid mb-3 mb-lg-0",placeholder:"Digite a senha"},null,512),[[l.nr,f.ususenha]]),oe]),(0,t._)("div",ne,[re,(0,t.wy)((0,t._)("input",{type:"password",id:"ususenha2",name:"ususenha2","onUpdate:modelValue":s[12]||(s[12]=e=>f.ususenha2=e),class:"form-control form-control-solid mb-3 mb-lg-0",placeholder:"Confirme a senha"},null,512),[[l.nr,f.ususenha2]]),de]),(0,t._)("div",ue,[(0,t._)("div",ce,[me,(0,t.wy)((0,t._)("select",{id:"usunivel",name:"usunivel","onUpdate:modelValue":s[13]||(s[13]=e=>f.usunivel=e),"aria-label":"Select a Country","data-control":"select2","data-placeholder":"Selecione o Nivel do Usuario",class:"form-select form-select-solid form-select-lg fw-bold select2-hidden-accessible","data-select2-id":"select2-data-10-0g0q",tabindex:"-1","aria-hidden":"true"},be,512),[[l.bM,f.usunivel]]),ve])])]),ge],32)])])])])])]),(0,t._)("div",we,[(0,t._)("div",ye,[(0,t._)("div",xe,[(0,t._)("table",ke,[Ue,(0,t._)("tbody",Ce,[((0,t.wg)(!0),(0,t.iD)(t.HY,null,(0,t.Ko)(f.ArrayUsuarios,(e=>((0,t.wg)(),(0,t.iD)("tr",{class:"odd",key:e.usuid},[(0,t._)("td",je,[(0,t._)("div",Ee,[(0,t._)("span",null,(0,i.zw)(e.usunome),1)])]),(0,t._)("td",qe,[(0,t._)("div",Ve,[(0,t._)("span",null,(0,i.zw)(e.usuemail),1)])]),(0,t._)("td",Se,[(0,t._)("div",Ae,[(0,t._)("span",null,(0,i.zw)(e.usunivel),1)])]),(0,t._)("td",Be,[(0,t._)("button",{type:"button",class:"btn btn-primary","data-bs-toggle":"modal","data-bs-target":"#kt_modal_editar_user",onClick:s=>F.formEditarUsuarios(e),style:{width:"105px"}},"Editar",8,De),(0,t._)("button",{type:"button",class:"btn btn-primary",onClick:s=>F.deletarUsuario(e),style:{width:"105px"}},"Excluir",8,Ie)])])))),128))])])]),Ne])])],64)}var Te=a(68932),ze=a(9669),Fe=a.n(ze),Oe={name:"usuario",data(){return{usuid:"",usunome:"",usuemail:"",ususenha:"",ususenha2:"",usunivel:"",pesqusu:"",ArrayUsuarios:[]}},methods:{limparUsuarios(){this.usunome="",this.usuemail="",this.ususenha="",this.ususenha2="",this.usunivel=""},addUsuario(){this.confirmarForm()&&Fe().post("usuario/",{usunome:this.usunome,usuemail:this.usuemail,ususenha:this.ususenha,usunivel:this.usunivel}).then((e=>{this.usunome="",this.usuemail="",this.ususenha="",this.ususenha2="",this.usunivel="",alert("Dados inseridos com sucesso!"),this.carregarUsuarios()})).catch((e=>{console.log(e)}))},carregarUsuarios(){Fe().get("usuario/",{headers:{Accept:"application/json"}}).then((e=>{this.ArrayUsuarios=e.data})).catch((e=>console.log(e)))},pesquisarUsuarios(){Fe().get("usuario/filtronome?nome="+this.pesqusu,{headers:{Accept:"application/json"}}).then((e=>{this.ArrayUsuarios=e.data})).catch((e=>console.log(e)))},atualizarUsuarios(){this.confirmarForm()&&Fe().put("usuario/"+this.usuid,{usunome:this.$data.usunome,usuemail:this.$data.usuemail,ususenha:this.$data.ususenha,usunivel:this.$data.usunivel}).then((e=>{alert("Dados alterados com sucesso!"),this.carregarUsuarios()})).catch((e=>{console.log(e)}))},formEditarUsuarios(e){this.usuid=e.usuid,this.usunome=e.usunome,this.usuemail=e.usuemail,this.ususenha=e.ususenha,this.usunivel=e.usunivel},deletarUsuario(e){1==confirm("Deseja realmente excluir registro? ")?(this.usuid=e.usuid,Fe()["delete"]("usuario/"+this.usuid).then((e=>{this.carregarUsuarios()})).catch((e=>{console.log(e)}))):this.carregarUsuarios()},confirmarForm(){return""==this.usunome?(alert("Preencha o nome do Usuário !"),document.getElementById("usunome").onfocus,!1):""==this.usuemail?(alert("Preencha o email do Usuário !"),document.getElementById("usuemail").onfocus,!1):""==this.ususenha&&""==this.ususenha2?(alert("Digite uma senha e confirme !"),document.getElementById("ususenha").onfocus,!1):this.ususenha!=this.ususenha2?(alert("Senhas não conferem !"),document.getElementById("ususenha").onfocus,!1):""!=this.usunivel||(alert("Selecione o nível do Usuário !"),document.getElementById("usunome").onfocus,!1)}},created(){this.carregarUsuarios()},mutations:{},setup(){(0,t.bv)((()=>{(0,Te.V)("Usuários")}))}},Ze=a(83744);const Pe=(0,Ze.Z)(Oe,[["render",Me]]);var Re=Pe}}]);
//# sourceMappingURL=7414-legacy.bd927f7a.js.map