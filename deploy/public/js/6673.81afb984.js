"use strict";(self["webpackChunkdemo1"]=self["webpackChunkdemo1"]||[]).push([[6673],{79097:function(e,t,a){a.d(t,{O:function(){return l}});var n=a(5080),l=function(e){return"media/illustrations/".concat(n.Gv.value,"/").concat(e)}},68932:function(e,t,a){a.d(t,{M:function(){return r},V:function(){return o}});var n=a(61107),l=a(15758),r=function(e,t){n.Z.dispatch(l.e.SET_BREADCRUMB_ACTION,{title:e,pageBreadcrumbPath:t})},o=function(e){n.Z.dispatch(l.e.SET_BREADCRUMB_ACTION,{title:e})}},5080:function(e,t,a){a.d(t,{Df:function(){return w},F9:function(){return b},Fh:function(){return i},Gv:function(){return y},K1:function(){return p},Lj:function(){return s},Ne:function(){return c},_T:function(){return m},az:function(){return v},jH:function(){return o},o$:function(){return u},o4:function(){return _},pD:function(){return g},vc:function(){return r},vj:function(){return h},xV:function(){return d},zK:function(){return f}});var n=a(66252),l=a(61107),r=(0,n.Fl)((function(){return l.Z.getters.layoutConfig()})),o=((0,n.Fl)((function(){return l.Z.getters.layoutConfig("sidebar.display")})),(0,n.Fl)((function(){return"fluid"===l.Z.getters.layoutConfig("footer.width")}))),i=(0,n.Fl)((function(){return"fluid"===l.Z.getters.layoutConfig("header.width")})),s=(0,n.Fl)((function(){return l.Z.getters.layoutConfig("header.left")})),u=(0,n.Fl)((function(){return!0===l.Z.getters.layoutConfig("aside.display")})),c=(0,n.Fl)((function(){return"fluid"===l.Z.getters.layoutConfig("toolbar.width")})),d=(0,n.Fl)((function(){return l.Z.getters.layoutConfig("toolbar.display")})),f=(0,n.Fl)((function(){return l.Z.getters.layoutConfig("loader.display")})),m=(0,n.Fl)((function(){return"fluid"===l.Z.getters.layoutConfig("content.width")})),g=(0,n.Fl)((function(){return""+l.Z.getters.layoutConfig("loader.logo")})),p=(0,n.Fl)((function(){return!!l.Z.getters.layoutConfig("aside.display")})),b=(0,n.Fl)((function(){return l.Z.getters.layoutConfig("aside.theme")})),v=(0,n.Fl)((function(){return l.Z.getters.layoutConfig("toolbar.display")})),_=(0,n.Fl)((function(){return l.Z.getters.layoutConfig("aside.menuIcon")})),w=(0,n.Fl)((function(){return l.Z.getters.layoutConfig("main.logo.light")})),h=(0,n.Fl)((function(){return l.Z.getters.layoutConfig("main.logo.dark")})),y=((0,n.Fl)((function(){return l.Z.getters.layoutConfig("header.menuIcon")})),(0,n.Fl)((function(){return l.Z.getters.layoutConfig("illustrations.set")})))},38561:function(e,t,a){a.d(t,{P:function(){return r},V:function(){return l}});var n=a(91205),l=function(e){if(e){var t=n.u_.getInstance(e);t.hide()}},r=function(){document.querySelectorAll(".modal-backdrop.fade.show").length&&document.querySelectorAll(".modal-backdrop.fade.show").forEach((function(e){e.remove()}))}},81128:function(e,t,a){a.d(t,{Z:function(){return _}});var n=a(66252),l=a(3577),r={class:"card"},o={class:"card-body p-0"},i={class:"card-px text-center py-20 my-10"},s={class:"fs-2x fw-bolder mb-10"},u={class:"text-gray-400 fs-5 fw-bold mb-13"},c=["innerHTML"],d=["data-bs-target"],f={class:"text-center px-5"},m=["src"];function g(e,t,a,g,p,b){return(0,n.wg)(),(0,n.iD)("div",r,[(0,n._)("div",o,[(0,n._)("div",i,[(0,n._)("h2",s,(0,l.zw)(e.title),1),(0,n._)("p",u,[(0,n._)("span",{innerHTML:e.description},null,8,c)]),(0,n._)("button",{type:"button",class:"btn btn-primary er fs-6 px-8 py-4","data-bs-toggle":"modal","data-bs-target":"#".concat(e.modalId)},(0,l.zw)(e.buttonText),9,d)]),(0,n._)("div",f,[(0,n._)("img",{src:e.image,alt:"",class:"mw-100 mh-300px"},null,8,m)])])])}var p=(0,n.aZ)({name:"modal-card",props:{title:String,description:String,buttonText:String,image:String,modalId:String},components:{}}),b=a(83744);const v=(0,b.Z)(p,[["render",g]]);var _=v},6673:function(e,t,a){a.r(t),a.d(t,{default:function(){return ie}});var n=a(66252);function l(e,t,a,l,r,o){var i=(0,n.up)("KTModalCard"),s=(0,n.up)("KTNewTargetModal");return(0,n.wg)(),(0,n.iD)(n.HY,null,[(0,n.Wm)(i,{title:"New Target Modal Example",description:"Click on the below buttons to launch <br/>a new target example.",image:e.getIllustrationsPath("17.png"),"button-text":"Add New Target","modal-id":"kt_modal_new_target"},null,8,["image"]),(0,n.Wm)(s)],64)}var r=a(81128),o=a(49963),i={class:"modal fade",id:"kt_modal_new_target",ref:"newTargetModalRef",tabindex:"-1","aria-hidden":"true"},s={class:"modal-dialog modal-dialog-centered mw-650px"},u={class:"modal-content rounded"},c={class:"modal-header pb-0 border-0 justify-content-end"},d={class:"btn btn-sm btn-icon btn-active-color-primary","data-bs-dismiss":"modal"},f={class:"svg-icon svg-icon-1"},m={class:"modal-body scroll-y px-10 px-lg-15 pt-0 pb-15"},g=(0,n._)("div",{class:"mb-13 text-center"},[(0,n._)("h1",{class:"mb-3"},"Set First Target"),(0,n._)("div",{class:"text-gray-400 fw-bold fs-5"},[(0,n.Uk)(" If you need more info, please check "),(0,n._)("a",{href:"#",class:"fw-bolder link-primary"},"Project Guidelines"),(0,n.Uk)(". ")])],-1),p={class:"d-flex flex-column mb-8 fv-row"},b=(0,n._)("label",{class:"d-flex align-items-center fs-6 fw-bold mb-2"},[(0,n._)("span",{class:"required"},"Target Title"),(0,n._)("i",{class:"fas fa-exclamation-circle ms-2 fs-7","data-bs-toggle":"tooltip",title:"Specify a target name for future usage and reference"})],-1),v={class:"row g-9 mb-8"},_={class:"col-md-6 fv-row"},w=(0,n._)("label",{class:"required fs-6 fw-bold mb-2"},"Assign",-1),h=(0,n.Uk)("Select user..."),y=(0,n.Uk)("Karina Clark"),k=(0,n.Uk)("Robert Doe"),x=(0,n.Uk)("Niel Owen"),T=(0,n.Uk)("Olivia Wild"),D=(0,n.Uk)("Sean Bean"),C={class:"col-md-6 fv-row"},W=(0,n._)("label",{class:"required fs-6 fw-bold mb-2"},"Due Date",-1),Z={class:"position-relative align-items-center"},F={class:"symbol symbol-20px me-4 position-absolute ms-4"},S={class:"symbol-label bg-secondary"},U={class:"svg-icon"},V={class:"d-flex flex-column mb-8"},M=(0,n._)("label",{class:"fs-6 fw-bold mb-2"},"Target Details",-1),A={class:"d-flex flex-column mb-8 fv-row"},q=(0,n._)("label",{class:"d-flex align-items-center fs-6 fw-bold mb-2"},[(0,n._)("span",{class:"required"},"Tags"),(0,n._)("i",{class:"fas fa-exclamation-circle ms-2 fs-7","data-bs-toggle":"tooltip",title:"Specify a target priorty"})],-1),I=(0,n._)("div",{class:"d-flex flex-stack mb-8"},[(0,n._)("div",{class:"me-5"},[(0,n._)("label",{class:"fs-6 fw-bold"},"Adding Users by Team Members"),(0,n._)("div",{class:"fs-7 fw-bold text-gray-400"}," If you need more info, please check budget planning ")]),(0,n._)("label",{class:"form-check form-switch form-check-custom form-check-solid"},[(0,n._)("input",{class:"form-check-input",type:"checkbox",value:"1",checked:"checked"}),(0,n._)("span",{class:"form-check-label fw-bold text-gray-400"}," Allowed ")])],-1),N=(0,n._)("div",{class:"mb-15 fv-row"},[(0,n._)("div",{class:"d-flex flex-stack"},[(0,n._)("div",{class:"fw-bold me-5"},[(0,n._)("label",{class:"fs-6"},"Notifications"),(0,n._)("div",{class:"fs-7 text-gray-400"}," Allow Notifications by Phone or Email ")]),(0,n._)("div",{class:"d-flex align-items-center"},[(0,n._)("label",{class:"form-check form-check-custom form-check-solid me-10"},[(0,n._)("input",{class:"form-check-input h-20px w-20px",type:"checkbox",name:"communication[]",value:"email",checked:"checked"}),(0,n._)("span",{class:"form-check-label fw-bold"}," Email ")]),(0,n._)("label",{class:"form-check form-check-custom form-check-solid"},[(0,n._)("input",{class:"form-check-input h-20px w-20px",type:"checkbox",name:"communication[]",value:"phone"}),(0,n._)("span",{class:"form-check-label fw-bold"}," Phone ")])])])],-1),P={class:"text-center"},B=(0,n._)("button",{type:"reset",id:"kt_modal_new_target_cancel",class:"btn btn-white me-3"}," Cancel ",-1),O=["data-kt-indicator"],R={key:0,class:"indicator-label"},E=(0,n.Uk)(" Submit "),H={class:"svg-icon svg-icon-3 ms-2 me-0"},K={key:1,class:"indicator-progress"},z=(0,n.Uk)(" Please wait... "),j=(0,n._)("span",{class:"spinner-border spinner-border-sm align-middle ms-2"},null,-1),G=[z,j];function L(e,t,a,l,r,z){var j=(0,n.up)("inline-svg"),L=(0,n.up)("el-input"),Y=(0,n.up)("el-form-item"),$=(0,n.up)("el-option"),J=(0,n.up)("el-select"),Q=(0,n.up)("el-date-picker"),X=(0,n.up)("el-form");return(0,n.wg)(),(0,n.iD)("div",i,[(0,n._)("div",s,[(0,n._)("div",u,[(0,n._)("div",c,[(0,n._)("div",d,[(0,n._)("span",f,[(0,n.Wm)(j,{src:"media/icons/duotune/arrows/arr061.svg"})])])]),(0,n._)("div",m,[(0,n.Wm)(X,{id:"kt_modal_new_target_form",onSubmit:t[5]||(t[5]=(0,o.iM)((function(t){return e.submit()}),["prevent"])),model:e.targetData,rules:e.rules,ref:"formRef",class:"form"},{default:(0,n.w5)((function(){return[g,(0,n._)("div",p,[b,(0,n.Wm)(Y,{prop:"targetTitle"},{default:(0,n.w5)((function(){return[(0,n.Wm)(L,{modelValue:e.targetData.targetTitle,"onUpdate:modelValue":t[0]||(t[0]=function(t){return e.targetData.targetTitle=t}),placeholder:"Enter Target Title",name:"targetTitle"},null,8,["modelValue"])]})),_:1})]),(0,n._)("div",v,[(0,n._)("div",_,[w,(0,n.Wm)(Y,{prop:"assign"},{default:(0,n.w5)((function(){return[(0,n.Wm)(J,{modelValue:e.targetData.assign,"onUpdate:modelValue":t[1]||(t[1]=function(t){return e.targetData.assign=t}),placeholder:"Select a Team Member",name:"assign",as:"select"},{default:(0,n.w5)((function(){return[(0,n.Wm)($,{value:""},{default:(0,n.w5)((function(){return[h]})),_:1}),(0,n.Wm)($,{label:"Karina Clark",value:"1"},{default:(0,n.w5)((function(){return[y]})),_:1}),(0,n.Wm)($,{label:"Robert Doe",value:"2"},{default:(0,n.w5)((function(){return[k]})),_:1}),(0,n.Wm)($,{label:"Niel Owen",value:"3"},{default:(0,n.w5)((function(){return[x]})),_:1}),(0,n.Wm)($,{label:"Olivia Wild",value:"4"},{default:(0,n.w5)((function(){return[T]})),_:1}),(0,n.Wm)($,{label:"Sean Bean",value:"5"},{default:(0,n.w5)((function(){return[D]})),_:1})]})),_:1},8,["modelValue"])]})),_:1})]),(0,n._)("div",C,[W,(0,n._)("div",Z,[(0,n._)("div",F,[(0,n._)("span",S,[(0,n._)("span",U,[(0,n.Wm)(j,{src:"media/icons/duotune/general/gen025.svg"})])])]),(0,n.Wm)(Y,{prop:"dueDate"},{default:(0,n.w5)((function(){return[(0,n.Wm)(Q,{modelValue:e.targetData.dueDate,"onUpdate:modelValue":t[2]||(t[2]=function(t){return e.targetData.dueDate=t}),placeholder:"Select a date",name:"dueDate"},null,8,["modelValue"])]})),_:1})])])]),(0,n._)("div",V,[M,(0,n.Wm)(Y,{prop:"targetDetails"},{default:(0,n.w5)((function(){return[(0,n.Wm)(L,{modelValue:e.targetData.targetDetails,"onUpdate:modelValue":t[3]||(t[3]=function(t){return e.targetData.targetDetails=t}),type:"textarea",rows:"3",name:"targetDetails",placeholder:"Type Target Details"},null,8,["modelValue"])]})),_:1})]),(0,n._)("div",A,[q,(0,n.Wm)(Y,{prop:"tags"},{default:(0,n.w5)((function(){return[(0,n.Wm)(J,{modelValue:e.targetData.tags,"onUpdate:modelValue":t[4]||(t[4]=function(t){return e.targetData.tags=t}),multiple:"",filterable:"","allow-create":"","default-first-option":"",placeholder:"Choose tags for your target"},{default:(0,n.w5)((function(){return[(0,n.Wm)($,{label:"Important",value:"important"}),(0,n.Wm)($,{label:"Urgent",value:"urgent"}),(0,n.Wm)($,{label:"high",value:"high"}),(0,n.Wm)($,{label:"low",value:"low"}),(0,n.Wm)($,{label:"medium",value:"medium"})]})),_:1},8,["modelValue"])]})),_:1})]),I,N,(0,n._)("div",P,[B,(0,n._)("button",{"data-kt-indicator":e.loading?"on":null,class:"btn btn-lg btn-primary",type:"submit"},[e.loading?(0,n.kq)("",!0):((0,n.wg)(),(0,n.iD)("span",R,[E,(0,n._)("span",H,[(0,n.Wm)(j,{src:"icons/duotune/arrows/arr064.svg"})])])),e.loading?((0,n.wg)(),(0,n.iD)("span",K,G)):(0,n.kq)("",!0)],8,O)])]})),_:1},8,["model","rules"])])])])],512)}var Y=a(2262),$=a(38561),J=a(78764),Q=a.n(J),X=(0,n.aZ)({name:"new-target-modal",components:{},setup:function(){var e=(0,Y.iH)(null),t=(0,Y.iH)(null),a=(0,Y.iH)(!1),n=(0,Y.iH)({targetTitle:"",assign:"",dueDate:"",targetDetails:"",tags:["important","urgent"]}),l=(0,Y.iH)({targetTitle:[{required:!0,message:"Please input Activity name",trigger:"blur"}],assign:[{required:!0,message:"Please select Activity zone",trigger:"change"}],dueDate:[{required:!0,message:"Please select Activity zone",trigger:"change"}],tags:[{required:!0,message:"Please select Activity zone",trigger:"change"}]}),r=function(){e.value&&e.value.validate((function(e){if(!e)return Q().fire({text:"Sorry, looks like there are some errors detected, please try again.",icon:"error",buttonsStyling:!1,confirmButtonText:"Ok, got it!",customClass:{confirmButton:"btn btn-primary"}}),!1;a.value=!0,setTimeout((function(){a.value=!1,Q().fire({text:"Form has been successfully submitted!",icon:"success",buttonsStyling:!1,confirmButtonText:"Ok, got it!",customClass:{confirmButton:"btn btn-primary"}}).then((function(){(0,$.V)(t.value)}))}),2e3)}))};return{targetData:n,submit:r,loading:a,formRef:e,rules:l,newTargetModalRef:t}}}),ee=a(83744);const te=(0,ee.Z)(X,[["render",L]]);var ae=te,ne=a(68932),le=a(79097),re=(0,n.aZ)({name:"new-target",components:{KTModalCard:r.Z,KTNewTargetModal:ae},setup:function(){return(0,n.bv)((function(){(0,ne.M)("New Target",["Modals","Forms"])})),{getIllustrationsPath:le.O}}});const oe=(0,ee.Z)(re,[["render",l]]);var ie=oe}}]);
//# sourceMappingURL=6673.81afb984.js.map