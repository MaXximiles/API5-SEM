"use strict";(self["webpackChunkdemo1"]=self["webpackChunkdemo1"]||[]).push([[6323],{68932:function(e,t,a){a.d(t,{M:function(){return n},V:function(){return r}});var s=a(61107),l=a(15758),n=function(e,t){s.Z.dispatch(l.e.SET_BREADCRUMB_ACTION,{title:e,pageBreadcrumbPath:t})},r=function(e){s.Z.dispatch(l.e.SET_BREADCRUMB_ACTION,{title:e})}},46323:function(e,t,a){a.r(t),a.d(t,{default:function(){return pe}});var s=a(66252),l=a(49963),n=a(3577);const r={id:"kt_content_container",class:"container-xxl"},i=(0,s._)("div",{"data-kt-swapper":"true","data-kt-swapper-mode":"prepend","data-kt-swapper-parent":"{default: '#kt_content_container', 'lg': '#kt_toolbar_container'}",class:"page-title d-flex align-items-center flex-wrap me-3 mb-5 mb-lg-0"},null,-1),o={class:"card"},d={class:"card-header border-0 pt-6"},c={class:"card-title"},m={class:"d-flex align-items-center position-relative my-1"},p=(0,s._)("span",{class:"svg-icon svg-icon-1 position-absolute ms-6"},[(0,s._)("svg",{xmlns:"http://www.w3.org/2000/svg",width:"24",height:"24",viewBox:"0 0 24 24",fill:"none"},[(0,s._)("rect",{opacity:"0.5",x:"17.0365",y:"15.1223",width:"8.15546",height:"2",rx:"1",transform:"rotate(45 17.0365 15.1223)",fill:"currentColor"}),(0,s._)("path",{d:"M11 19C6.55556 19 3 15.4444 3 11C3 6.55556 6.55556 3 11 3C15.4444 3 19 6.55556 19 11C19 15.4444 15.4444 19 11 19ZM11 5C7.53333 5 5 7.53333 5 11C5 14.4667 7.53333 17 11 17C14.4667 17 17 14.4667 17 11C17 7.53333 14.4667 5 11 5Z",fill:"currentColor"})])],-1),u={class:"card-toolbar"},_=(0,s.uE)('<div class="d-flex justify-content-end" data-kt-user-table-toolbar="base"><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#kt_modal_add_user"><span class="svg-icon svg-icon-2"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"><rect opacity="0.5" x="11.364" y="20.364" width="16" height="2" rx="1" transform="rotate(-90 11.364 20.364)" fill="currentColor"></rect><rect x="4.36396" y="11.364" width="16" height="2" rx="1" fill="currentColor"></rect></svg></span> Adicionar Empresa</button></div><div class="d-flex justify-content-end align-items-center d-none" data-kt-user-table-toolbar="selected"><div class="fw-bolder me-5"><span class="me-2" data-kt-user-table-select="selected_count"></span>Selected</div><button type="button" class="btn btn-danger" data-kt-user-table-select="delete_selected">Delete Selected</button></div>',2),g={class:"modal fade",id:"kt_modal_add_user",tabindex:"-1","aria-hidden":"true"},b={class:"modal-dialog modal-dialog-centered mw-650px"},f={class:"modal-content"},h=(0,s.uE)('<div class="modal-header" id="kt_modal_add_user_header"><h2 class="fw-bolder">Formulário de Empresas</h2><div class="btn btn-icon btn-sm btn-active-icon-primary" data-kt-users-modal-action="close"><span class="svg-icon svg-icon-1"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"><rect opacity="0.5" x="6" y="17.3137" width="16" height="2" rx="1" transform="rotate(-45 6 17.3137)" fill="currentColor"></rect><rect x="7.41422" y="6" width="16" height="2" rx="1" transform="rotate(45 7.41422 6)" fill="currentColor"></rect></svg></span></div></div>',1),v={class:"modal-body scroll-y mx-5 mx-xl-15 my-7"},w={class:"d-flex flex-column scroll-y me-n7 pe-7",id:"kt_modal_add_user_scroll","data-kt-scroll":"true","data-kt-scroll-activate":"{default: false, lg: true}","data-kt-scroll-max-height":"auto","data-kt-scroll-dependencies":"#kt_modal_add_user_header","data-kt-scroll-wrappers":"#kt_modal_add_user_scroll","data-kt-scroll-offset":"300px",style:{}},x={class:"fv-row mb-7 fv-plugins-icon-container"},y=(0,s._)("label",{class:"required fw-bold fs-6 mb-2"},"Nome: ",-1),k=(0,s._)("div",{class:"fv-plugins-message-container invalid-feedback"},null,-1),E={class:"fv-row mb-7 fv-plugins-icon-container"},C=(0,s._)("label",{class:"required fw-bold fs-6 mb-2"},"CNPJ: ",-1),j=(0,s._)("div",{class:"fv-plugins-message-container invalid-feedback"},null,-1),A={class:"fv-row mb-7 fv-plugins-icon-container"},q=(0,s._)("label",{class:"required fw-bold fs-6 mb-2"},"CNAE: ",-1),S=(0,s._)("div",{class:"fv-plugins-message-container invalid-feedback"},null,-1),N={class:"fv-row mb-7 fv-plugins-icon-container"},B=(0,s._)("label",{class:"required fw-bold fs-6 mb-2"},"Cidade: ",-1),M=(0,s._)("div",{class:"fv-plugins-message-container invalid-feedback"},null,-1),U={class:"fv-row mb-7 fv-plugins-icon-container"},D=(0,s._)("label",{class:"required fw-bold fs-6 mb-2"},"Origem: ",-1),V=(0,s._)("div",{class:"fv-plugins-message-container invalid-feedback"},null,-1),P=(0,s.uE)('<div class="text-center pt-15"><button type="reset" class="btn btn-light me-3" data-kt-users-modal-action="cancel">Descartar</button><button type="submit" class="btn btn-primary" data-kt-users-modal-action="submit"><span class="indicator-label">Salvar</span><span class="indicator-progress">Carregando... <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span></button></div><div></div>',2),z={class:"card-body py-4"},R={id:"kt_table_users_wrapper",class:"dataTables_wrapper dt-bootstrap4 no-footer"},T={class:"table-responsive"},Z={class:"table align-middle table-row-dashed fs-6 gy-5 dataTable no-footer",id:"kt_table_empresas"},L=(0,s._)("thead",null,[(0,s._)("tr",{class:"text-start text-muted fw-bolder fs-7 text-uppercase gs-0"},[(0,s._)("th",{class:"min-w-125px sorting",tabindex:"0","aria-controls":"kt_table_users",rowspan:"1",colspan:"1",style:{width:"212.875px"}},"CNPJ"),(0,s._)("th",{class:"min-w-125px sorting",tabindex:"0","aria-controls":"kt_table_users",rowspan:"1",colspan:"1",style:{width:"125px"}},"EMPRESA"),(0,s._)("th",{class:"min-w-125px sorting",tabindex:"0","aria-controls":"kt_table_users",rowspan:"1",colspan:"1",style:{width:"125px"}},"CNAE"),(0,s._)("th",{class:"min-w-125px sorting",tabindex:"0","aria-controls":"kt_table_users",rowspan:"1",colspan:"1",style:{width:"125px"}},"ORIGEM"),(0,s._)("th",{class:"text-end min-w-100px sorting_disabled",rowspan:"1",colspan:"1","aria-label":"Actions",style:{width:"100px"}},"AÇÕES")])],-1),O={class:"text-gray-600 fw-bold"},I={class:"align-items-center"},J={class:"d-flex flex-column"},K={class:"align-items-center"},F={class:"d-flex flex-column"},G={class:"align-items-center"},H={class:"d-flex flex-column"},Y={class:"align-items-center"},Q={class:"d-flex flex-column"},W={class:"text-end"},X=(0,s._)("a",{href:"#",class:"btn btn-light btn-active-light-primary btn-sm","data-kt-menu-trigger":"click","data-kt-menu-placement":"bottom-end"},[(0,s.Uk)(" AÇÕES "),(0,s._)("span",{class:"svg-icon svg-icon-5 m-0"},[(0,s._)("svg",{xmlns:"http://www.w3.org/2000/svg",width:"24",viewBox:"0 0 24 24",fill:"none"},[(0,s._)("path",{d:"M11.4343 12.7344L7.25 8.55005C6.83579 8.13583 6.16421 8.13584 5.75 8.55005C5.33579 8.96426 5.33579 9.63583 5.75 10.05L11.2929 15.5929C11.6834 15.9835 12.3166 15.9835 12.7071 15.5929L18.25 10.05C18.6642 9.63584 18.6642 8.96426 18.25 8.55005C17.8358 8.13584 17.1642 8.13584 16.75 8.55005L12.5657 12.7344C12.2533 13.0468 11.7467 13.0468 11.4343 12.7344Z",fill:"currentColor"})])])],-1),$={class:"menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-600 menu-state-bg-light-primary fw-bold fs-7 w-125px py-4","data-kt-menu":"true"},ee={class:"menu-item px-3"},te=["onClick"],ae={class:"menu-item px-3"},se=["onClick"],le=(0,s._)("div",{class:"row"},[(0,s._)("div",{class:"col-sm-12 col-md-5 d-flex align-items-center justify-content-center justify-content-md-start"}),(0,s._)("div",{class:"col-sm-12 col-md-7 d-flex align-items-center justify-content-center justify-content-md-end"})],-1);function ne(e,t,a,ne,re,ie){return(0,s.wg)(),(0,s.iD)("div",r,[i,(0,s._)("div",o,[(0,s._)("div",d,[(0,s._)("div",c,[(0,s._)("div",m,[p,(0,s.wy)((0,s._)("input",{type:"text",onKeyup:t[0]||(t[0]=(...e)=>ie.pesquisarEmpresas&&ie.pesquisarEmpresas(...e)),"onUpdate:modelValue":t[1]||(t[1]=e=>re.pesqemp=e),"data-kt-user-table-filter":"search",class:"form-control form-control-solid w-250px ps-14",placeholder:"Pesquisar Empresas"},null,544),[[l.nr,re.pesqemp]])])]),(0,s._)("div",u,[_,(0,s._)("div",g,[(0,s._)("div",b,[(0,s._)("div",f,[h,(0,s._)("div",v,[(0,s._)("form",{id:"kt_modal_add_user_form",onSubmit:t[7]||(t[7]=(0,l.iM)(((...e)=>ie.addEmpresa&&ie.addEmpresa(...e)),["prevent"])),class:"form fv-plugins-bootstrap5 fv-plugins-framework",action:"#"},[(0,s._)("div",w,[(0,s._)("div",x,[y,(0,s.wy)((0,s._)("input",{type:"text",id:"emp_nome",name:"emp_nome","onUpdate:modelValue":t[2]||(t[2]=e=>re.empnome=e),class:"form-control form-control-solid mb-3 mb-lg-0",placeholder:"Nome da Empresa"},null,512),[[l.nr,re.empnome]]),k]),(0,s._)("div",E,[C,(0,s.wy)((0,s._)("input",{type:"text",id:"emp_cnpj",name:"emp_cnpj","onUpdate:modelValue":t[3]||(t[3]=e=>re.empcnpj=e),class:"form-control form-control-solid mb-3 mb-lg-0",placeholder:"00.000.000/0000-00"},null,512),[[l.nr,re.empcnpj]]),j]),(0,s._)("div",A,[q,(0,s.wy)((0,s._)("input",{type:"text",id:"cnae_id",name:"cnae_id","onUpdate:modelValue":t[4]||(t[4]=e=>re.cnaeid=e),class:"form-control form-control-solid mb-3 mb-lg-0",placeholder:"Numero do CNAE"},null,512),[[l.nr,re.cnaeid]]),S]),(0,s._)("div",N,[B,(0,s.wy)((0,s._)("input",{type:"text",id:"cid_id",name:"cid_id","onUpdate:modelValue":t[5]||(t[5]=e=>re.cidid=e),class:"form-control form-control-solid mb-3 mb-lg-0",placeholder:"Ex: São Paulo"},null,512),[[l.nr,re.cidid]]),M]),(0,s._)("div",U,[D,(0,s.wy)((0,s._)("input",{type:"text",id:"emp_origem",name:"emp_origem","onUpdate:modelValue":t[6]||(t[6]=e=>re.emporigem=e),class:"form-control form-control-solid mb-3 mb-lg-0",placeholder:"SPC, Concorrente, Livre"},null,512),[[l.nr,re.emporigem]]),V])]),P],32)])])])])])]),(0,s._)("div",z,[(0,s._)("div",R,[(0,s._)("div",T,[(0,s._)("table",Z,[L,(0,s._)("tbody",O,[((0,s.wg)(!0),(0,s.iD)(s.HY,null,(0,s.Ko)(re.ArrayEmpresas,(e=>((0,s.wg)(),(0,s.iD)("tr",{class:"odd",key:e.empid},[(0,s._)("td",I,[(0,s._)("div",J,[(0,s._)("span",null,(0,n.zw)(e.empcnpj),1)])]),(0,s._)("td",K,[(0,s._)("div",F,[(0,s._)("span",null,(0,n.zw)(e.empnome),1)])]),(0,s._)("td",G,[(0,s._)("div",H,[(0,s._)("span",null,(0,n.zw)(e.cnaeid),1)])]),(0,s._)("td",Y,[(0,s._)("div",Q,[(0,s._)("span",null,(0,n.zw)(e.emporigem),1)])]),(0,s._)("td",W,[X,(0,s._)("div",$,[(0,s._)("div",ee,[(0,s._)("button",{type:"button",class:"btn btn-primary","data-bs-toggle":"modal","data-bs-target":"#kt_modal_add_user",onClick:t=>ie.formEditarEmpresa(e)},"Editar",8,te)]),(0,s._)("div",ae,[(0,s._)("button",{type:"button",class:"btn btn-primary",onClick:t=>ie.deletarEmpresa(e)},"Excluir",8,se)])])])])))),128))])])]),le])])])])}var re=a(68932),ie=a(9669),oe=a.n(ie),de={name:"empresa",data(){return{empid:"",empnome:"",empcnpj:"",cidid:"",cnaeid:"",emporigem:"",pesqemp:"",ArrayEmpresas:[]}},methods:{addEmpresa(){oe().post("empresas/",{empnome:this.empnome,empcnpj:this.empcnpj,emporigem:this.emporigem,cidid:this.cidid,cnaeid:this.cnaeid}).then((e=>{console.log(e),this.empnome="",this.empcnpj="",this.emporigem="",this.cidid="",this.cnaeid="",this.carregarEmpresas()})).catch((e=>{console.log(e)}))},carregarEmpresas(){oe().get("empresas/",{headers:{Accept:"application/json"}}).then((e=>{console.log(e),this.ArrayEmpresas=e.data})).catch((e=>console.log(e)))},pesquisarEmpresas(){oe().get("empresas/filtronome?nome="+this.pesqemp,{headers:{Accept:"application/json"}}).then((e=>{console.log(e),this.ArrayEmpresas=e.data})).catch((e=>console.log(e)))},atualizarEmpresa(e,t){oe().put("empresas/"+this.empid,{headers:{Accept:"application/json"}},{empnome:t.empnome,empcnpj:t.empcnpj,emporigem:t.emporigem,cidid:t.cidid,cnaeid:t.cnaeid}).then((e=>{console.log(e),this.carregarEmpresas()})).catch((e=>{console.log(e)}))},formEditarEmpresa(e){this.empid=e.empid,this.empnome=e.empnome,this.empcnpj=e.empcnpj,this.emporigem=e.emporigem,this.cidid=e.cidid,this.cnaeid=e.cnaeid,atualizarEmpresa(this.empid,e)},deletarEmpresa(e){1==confirm("Deseja realmente excluir registro? ")?(this.empid=e.empid,oe()["delete"]("empresas/"+this.empid).then((e=>{console.log(e),this.carregarEmpresas()})).catch((e=>{console.log(e)}))):this.carregarEmpresas()}},created(){this.carregarEmpresas()},mutations:{},setup(){(0,s.bv)((()=>{(0,re.V)("Empresa")}))}},ce=a(83744);const me=(0,ce.Z)(de,[["render",ne]]);var pe=me}}]);
//# sourceMappingURL=6323-legacy.50befb2b.js.map