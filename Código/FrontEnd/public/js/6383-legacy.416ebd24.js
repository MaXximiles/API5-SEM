"use strict";(self["webpackChunkdemo1"]=self["webpackChunkdemo1"]||[]).push([[6383],{38561:function(e,a,l){l.d(a,{P:function(){return s},V:function(){return n}});var t=l(91205),n=function(e){if(e){var a=t.u_.getInstance(e);a.hide()}},s=function(){document.querySelectorAll(".modal-backdrop.fade.show").length&&document.querySelectorAll(".modal-backdrop.fade.show").forEach((function(e){e.remove()}))}},6383:function(e,a,l){l.d(a,{Z:function(){return re}});var t=l(66252),n=l(3577),s={class:"modal fade",ref:"newCardModalRef",id:"kt_modal_new_card",tabindex:"-1","aria-hidden":"true"},o={class:"modal-dialog modal-dialog-centered mw-650px"},r={class:"modal-content"},c={class:"modal-header"},i=(0,t._)("h2",null,"Add New Card",-1),d={class:"btn btn-sm btn-icon btn-active-color-primary","data-bs-dismiss":"modal"},m={class:"svg-icon svg-icon-1"},u={class:"modal-body scroll-y mx-5 mx-xl-15 my-7"},f={class:"d-flex flex-column mb-7 fv-row"},v=(0,t._)("label",{class:"d-flex align-items-center fs-6 fw-bold form-label mb-2"},[(0,t._)("span",{class:"required"},"Name On Card"),(0,t._)("i",{class:"fas fa-exclamation-circle ms-2 fs-7","data-bs-toggle":"tooltip",title:"Specify a card holder's name"})],-1),b={class:"fv-plugins-message-container"},p={class:"fv-help-block"},_={class:"d-flex flex-column mb-7 fv-row"},h=(0,t._)("label",{class:"required fs-6 fw-bold form-label mb-2"},"Card Number",-1),g={class:"position-relative"},x={class:"fv-plugins-message-container"},w={class:"fv-help-block"},k=(0,t._)("div",{class:"position-absolute translate-middle-y top-50 end-0 me-5"},[(0,t._)("img",{src:"media/svg/card-logos/visa.svg",alt:"",class:"h-25px"}),(0,t._)("img",{src:"media/svg/card-logos/mastercard.svg",alt:"",class:"h-25px"}),(0,t._)("img",{src:"media/svg/card-logos/american-express.svg",alt:"",class:"h-25px"})],-1),y={class:"row mb-10"},V={class:"col-md-8 fv-row"},C=(0,t._)("label",{class:"required fs-6 fw-bold form-label mb-2"},"Expiration Date",-1),D={class:"row fv-row"},M={class:"col-6"},W=(0,t._)("option",null,null,-1),Y=["value"],q={class:"fv-plugins-message-container"},N={class:"fv-help-block"},S={class:"col-6"},O=(0,t._)("option",null,null,-1),Z=["value"],F={class:"fv-plugins-message-container"},E={class:"fv-help-block"},U={class:"col-md-4 fv-row"},A=(0,t._)("label",{class:"d-flex align-items-center fs-6 fw-bold form-label mb-2"},[(0,t._)("span",{class:"required"},"CVV"),(0,t._)("i",{class:"fas fa-exclamation-circle ms-2 fs-7","data-bs-toggle":"tooltip",title:"Enter a card CVV code"})],-1),B={class:"position-relative"},H={class:"position-absolute translate-middle-y top-50 end-0 me-3"},R={class:"svg-icon svg-icon-2hx"},z={class:"fv-plugins-message-container"},I={class:"fv-help-block"},K=(0,t._)("div",{class:"d-flex flex-stack"},[(0,t._)("div",{class:"me-5"},[(0,t._)("label",{class:"fs-6 fw-bold form-label"},"Save Card for further billing?"),(0,t._)("div",{class:"fs-7 fw-bold text-gray-400"}," If you need more info, please check budget planning ")]),(0,t._)("label",{class:"form-check form-switch form-check-custom form-check-solid"},[(0,t._)("input",{class:"form-check-input",type:"checkbox",value:"1",checked:"checked"}),(0,t._)("span",{class:"form-check-label fw-bold text-gray-400"}," Save Card ")])],-1),P={class:"text-center pt-15"},T=(0,t._)("button",{type:"reset",id:"kt_modal_new_card_cancel",class:"btn btn-white me-3"}," Discard ",-1),j={ref:"submitButtonRef",type:"submit",id:"kt_modal_new_card_submit",class:"btn btn-primary"},G=(0,t._)("span",{class:"indicator-label"}," Submit ",-1),J=(0,t._)("span",{class:"indicator-progress"},[(0,t.Uk)(" Please wait... "),(0,t._)("span",{class:"spinner-border spinner-border-sm align-middle ms-2"})],-1),L=[G,J];function Q(e,a,l,G,J,Q){var X=(0,t.up)("inline-svg"),$=(0,t.up)("Field"),ee=(0,t.up)("ErrorMessage"),ae=(0,t.up)("Form");return(0,t.wg)(),(0,t.iD)("div",s,[(0,t._)("div",o,[(0,t._)("div",r,[(0,t._)("div",c,[i,(0,t._)("div",d,[(0,t._)("span",m,[(0,t.Wm)(X,{src:"media/icons/duotune/arrows/arr061.svg"})])])]),(0,t._)("div",u,[(0,t.Wm)(ae,{id:"kt_modal_new_card_form",class:"form",onSubmit:e.submit,"validation-schema":e.validationSchema},{default:(0,t.w5)((function(){return[(0,t._)("div",f,[v,(0,t.Wm)($,{type:"text",class:"form-control form-control-solid",placeholder:"",name:"nameOnCard",modelValue:e.cardData.nameOnCard,"onUpdate:modelValue":a[0]||(a[0]=function(a){return e.cardData.nameOnCard=a})},null,8,["modelValue"]),(0,t._)("div",b,[(0,t._)("div",p,[(0,t.Wm)(ee,{name:"nameOnCard"})])])]),(0,t._)("div",_,[h,(0,t._)("div",g,[(0,t.Wm)($,{type:"text",class:"form-control form-control-solid",placeholder:"Enter card number",name:"cardNumber",modelValue:e.cardData.cardNumber,"onUpdate:modelValue":a[1]||(a[1]=function(a){return e.cardData.cardNumber=a})},null,8,["modelValue"]),(0,t._)("div",x,[(0,t._)("div",w,[(0,t.Wm)(ee,{name:"cardNumber"})])]),k])]),(0,t._)("div",y,[(0,t._)("div",V,[C,(0,t._)("div",D,[(0,t._)("div",M,[(0,t.Wm)($,{modelValue:e.cardData.expirationMonth,"onUpdate:modelValue":a[2]||(a[2]=function(a){return e.cardData.expirationMonth=a}),name:"expirationMonth",class:"form-select form-select-solid","data-control":"select2","data-hide-search":"true","data-placeholder":"Month",as:"select"},{default:(0,t.w5)((function(){return[W,((0,t.wg)(),(0,t.iD)(t.HY,null,(0,t.Ko)(12,(function(e){return(0,t._)("option",{key:e,value:e},(0,n.zw)(e),9,Y)})),64))]})),_:1},8,["modelValue"]),(0,t._)("div",q,[(0,t._)("div",N,[(0,t.Wm)(ee,{name:"expirationMonth"})])])]),(0,t._)("div",S,[(0,t.Wm)($,{modelValue:e.cardData.expirationYear,"onUpdate:modelValue":a[3]||(a[3]=function(a){return e.cardData.expirationYear=a}),name:"expirationYear",class:"form-select form-select-solid","data-control":"select2","data-hide-search":"true","data-placeholder":"Year",as:"select"},{default:(0,t.w5)((function(){return[O,((0,t.wg)(),(0,t.iD)(t.HY,null,(0,t.Ko)(10,(function(e){return(0,t._)("option",{key:e,value:(new Date).getFullYear()+e},(0,n.zw)((new Date).getFullYear()+e),9,Z)})),64))]})),_:1},8,["modelValue"]),(0,t._)("div",F,[(0,t._)("div",E,[(0,t.Wm)(ee,{name:"expirationYear"})])])])])]),(0,t._)("div",U,[A,(0,t._)("div",B,[(0,t.Wm)($,{modelValue:e.cardData.cvv,"onUpdate:modelValue":a[4]||(a[4]=function(a){return e.cardData.cvv=a}),type:"text",class:"form-control form-control-solid",minlength:"3",maxlength:"4",placeholder:"CVV",name:"cvv"},null,8,["modelValue"]),(0,t._)("div",H,[(0,t._)("span",R,[(0,t.Wm)(X,{src:"media/icons/duotune/finance/fin002.svg"})])])]),(0,t._)("div",z,[(0,t._)("div",I,[(0,t.Wm)(ee,{name:"cvv"})])])])]),K,(0,t._)("div",P,[T,(0,t._)("button",j,L,512)])]})),_:1},8,["onSubmit","validation-schema"])])])])],512)}var X=l(2262),$=l(12954),ee=l(78764),ae=l.n(ee),le=l(38561),te=l(74231),ne=(0,t.aZ)({name:"new-card-modal",components:{ErrorMessage:$.Bc,Field:$.gN,Form:$.l0},setup:function(){var e=(0,X.iH)(null),a=(0,X.iH)(null),l=(0,X.iH)({nameOnCard:"Max Doe",cardNumber:"4111 1111 1111 1111",expirationMonth:"",expirationYear:"",cvv:""}),t=te.Ry().shape({nameOnCard:te.Z_().required().label("Name"),cardNumber:te.Z_().required().label("Card number"),expirationMonth:te.Z_().required().label("Month"),expirationYear:te.Z_().required().label("Year"),cvv:te.Z_().required().label("CVV")}),n=function(){e.value&&(e.value.disabled=!0,e.value.setAttribute("data-kt-indicator","on"),setTimeout((function(){var l;e.value&&(e.value.disabled=!1,null===(l=e.value)||void 0===l||l.removeAttribute("data-kt-indicator")),ae().fire({text:"Form has been successfully submitted!",icon:"success",buttonsStyling:!1,confirmButtonText:"Ok, got it!",customClass:{confirmButton:"btn btn-primary"}}).then((function(){(0,le.V)(a.value)}))}),2e3))};return{cardData:l,validationSchema:t,submit:n,submitButtonRef:e,newCardModalRef:a}}}),se=l(83744);const oe=(0,se.Z)(ne,[["render",Q]]);var re=oe}}]);
//# sourceMappingURL=6383-legacy.416ebd24.js.map