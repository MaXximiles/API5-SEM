"use strict";(self["webpackChunkdemo1"]=self["webpackChunkdemo1"]||[]).push([[1165],{21165:function(e,s,t){t.r(s),t.d(s,{default:function(){return Z}});var o=t(66252),n={class:"w-lg-500px bg-white rounded shadow-sm p-10 p-lg-15 mx-auto"},a=(0,o._)("div",{class:"mb-10 bg-light-info p-8 rounded"},[(0,o._)("div",{class:"text-info"},[(0,o.Uk)(" Utilize o email: "),(0,o._)("strong",null,"admin@demo.com"),(0,o.Uk)(" e a senha: "),(0,o._)("strong",null,"demo"),(0,o.Uk)(" para acessar. ")])],-1),r={class:"fv-row mb-10"},l=(0,o._)("label",{class:"form-label fs-6 fw-bolder text-dark"},"Email",-1),i={class:"fv-plugins-message-container"},c={class:"fv-help-block"},d={class:"fv-row mb-10"},m={class:"d-flex flex-stack mb-2"},u=(0,o._)("label",{class:"form-label fw-bolder text-dark fs-6 mb-0"},"Password",-1),f=(0,o.Uk)("Esqueceu sua senha?"),b={class:"fv-plugins-message-container"},p={class:"fv-help-block"},g={class:"text-center"},v={type:"submit",ref:"submitButton",id:"kt_sign_in_submit",class:"btn btn-lg btn-primary w-100 mb-5"},_=(0,o._)("span",{class:"indicator-label"}," Acessar ",-1),h=(0,o._)("span",{class:"indicator-progress"},[(0,o.Uk)("Carregando... "),(0,o._)("span",{class:"spinner-border spinner-border-sm align-middle ms-2"})],-1),w=[_,h];function k(e,s,t,_,h,k){var x=(0,o.up)("Field"),y=(0,o.up)("ErrorMessage"),E=(0,o.up)("router-link"),B=(0,o.up)("Form");return(0,o.wg)(),(0,o.iD)("div",n,[(0,o.Wm)(B,{class:"form w-100",id:"kt_login_signin_form",onSubmit:e.onSubmitLogin,"validation-schema":e.login},{default:(0,o.w5)((function(){return[a,(0,o._)("div",r,[l,(0,o.Wm)(x,{class:"form-control form-control-lg form-control-solid",type:"text",name:"email",placeholder:"Email"}),(0,o._)("div",i,[(0,o._)("div",c,[(0,o.Wm)(y,{name:"email"})])])]),(0,o._)("div",d,[(0,o._)("div",m,[u,(0,o.Wm)(E,{to:"/password-reset",class:"link-primary fs-6 fw-bolder"},{default:(0,o.w5)((function(){return[f]})),_:1})]),(0,o.Wm)(x,{class:"form-control form-control-lg form-control-solid",type:"password",name:"password",placeholder:"Senha",autocomplete:"off"}),(0,o._)("div",b,[(0,o._)("div",p,[(0,o.Wm)(y,{name:"password"})])])]),(0,o._)("div",g,[(0,o._)("button",v,w,512)])]})),_:1},8,["onSubmit","validation-schema"])])}var x=t(70655),y=t(2262),E=t(12954),B=t(15758),S=t(33907),U=t(42119),W=t(48542),C=t.n(W),L=t(74231),O=(0,o.aZ)({name:"sign-in",components:{Field:E.gN,Form:E.l0,ErrorMessage:E.Bc},setup:function(){var e=this,s=(0,S.oR)(),t=(0,U.tv)(),o=(0,y.iH)(null),n=L.Ry().shape({email:L.Z_().email().required().label("Email"),password:L.Z_().min(4).required().label("Password")}),a=function(n){return(0,x.mG)(e,void 0,void 0,(function(){var e,a,r;return(0,x.Jh)(this,(function(l){switch(l.label){case 0:return s.dispatch(B.e.LOGOUT),o.value&&(o.value.disabled=!0,o.value.setAttribute("data-kt-indicator","on")),[4,s.dispatch(B.e.LOGIN,n)];case 1:return l.sent(),console.log(n),e=Object.keys(s.getters.getErrors)[0],a=s.getters.getErrors[e],a?C().fire({text:a[0],icon:"error",buttonsStyling:!1,confirmButtonText:"Try again!",customClass:{confirmButton:"btn fw-bold btn-light-danger"}}):C().fire({text:"Login realizado com sucesso!",icon:"success",buttonsStyling:!1,confirmButtonText:"Ok, Vamos lá!",customClass:{confirmButton:"btn fw-bold btn-light-primary"}}).then((function(){t.push({name:"dashboard"})})),null===(r=o.value)||void 0===r||r.removeAttribute("data-kt-indicator"),o.value.disabled=!1,[2]}}))}))};return{onSubmitLogin:a,login:n,submitButton:o}}}),F=t(83744);const T=(0,F.Z)(O,[["render",k]]);var Z=T}}]);
//# sourceMappingURL=1165-legacy.9b2c1873.js.map