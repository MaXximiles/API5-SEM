"use strict";(self["webpackChunkdemo1"]=self["webpackChunkdemo1"]||[]).push([[2134],{79097:function(e,a,n){n.d(a,{O:function(){return s}});var t=n(5080),s=function(e){return"media/illustrations/".concat(t.Gv.value,"/").concat(e)}},68932:function(e,a,n){n.d(a,{M:function(){return r},V:function(){return l}});var t=n(61107),s=n(15758),r=function(e,a){t.Z.dispatch(s.e.SET_BREADCRUMB_ACTION,{title:e,pageBreadcrumbPath:a})},l=function(e){t.Z.dispatch(s.e.SET_BREADCRUMB_ACTION,{title:e})}},81128:function(e,a,n){n.d(a,{Z:function(){return h}});var t=n(66252),s=n(3577),r={class:"card"},l={class:"card-body p-0"},o={class:"card-px text-center py-20 my-10"},i={class:"fs-2x fw-bolder mb-10"},c={class:"text-gray-400 fs-5 fw-bold mb-13"},d=["innerHTML"],u=["data-bs-target"],m={class:"text-center px-5"},f=["src"];function v(e,a,n,v,b,p){return(0,t.wg)(),(0,t.iD)("div",r,[(0,t._)("div",l,[(0,t._)("div",o,[(0,t._)("h2",i,(0,s.zw)(e.title),1),(0,t._)("p",c,[(0,t._)("span",{innerHTML:e.description},null,8,d)]),(0,t._)("button",{type:"button",class:"btn btn-primary er fs-6 px-8 py-4","data-bs-toggle":"modal","data-bs-target":"#".concat(e.modalId)},(0,s.zw)(e.buttonText),9,u)]),(0,t._)("div",m,[(0,t._)("img",{src:e.image,alt:"",class:"mw-100 mh-300px"},null,8,f)])])])}var b=(0,t.aZ)({name:"modal-card",props:{title:String,description:String,buttonText:String,image:String,modalId:String},components:{}}),p=n(83744);const g=(0,p.Z)(b,[["render",v]]);var h=g},92134:function(e,a,n){n.r(a),n.d(a,{default:function(){return H}});var t=n(66252);function s(e,a,n,s,r,l){var o=(0,t.up)("KTModalsCard"),i=(0,t.up)("KTShareAndEarnModal");return(0,t.wg)(),(0,t.iD)(t.HY,null,[(0,t.Wm)(o,{title:"Share & Earn Modal Example",description:"Click on the below buttons to launch <br/>a share & earn example.",image:e.getIllustrationsPath("9.png"),"button-text":"Share & Earn","modal-id":"kt_modal_share_earn"},null,8,["image"]),(0,t.Wm)(i)],64)}var r=n(81128),l={class:"modal fade",id:"kt_modal_share_earn",tabindex:"-1","aria-hidden":"true"},o={class:"modal-dialog modal-dialog-centered mw-800px"},i={class:"modal-content"},c={class:"modal-header pb-0 border-0 justify-content-end"},d={class:"btn btn-sm btn-icon btn-active-color-primary","data-bs-dismiss":"modal"},u={class:"svg-icon svg-icon-1"},m={class:"modal-body scroll-y pt-0 pb-15"},f={class:"mw-lg-600px mx-auto"},v=(0,t._)("div",{class:"mb-13 text-center"},[(0,t._)("h1",{class:"mb-3"},"Share & Earn"),(0,t._)("div",{class:"text-gray-400 fw-bold fs-5"},[(0,t.Uk)(" If you need more info, please check "),(0,t._)("a",{href:"#",class:"link-primary fw-bolder"},"Author Commision"),(0,t.Uk)(". ")])],-1),b={class:"mb-10"},p=(0,t._)("h4",{class:"fs-5 fw-bold text-gray-800"}," Share my referral link with friends ",-1),g={class:"d-flex"},h={ref:"inputRef",id:"kt_share_earn_link_input",type:"text",class:"form-control form-control-solid me-3 flex-grow-1",name:"search",value:"https://keenthemes.com/?ref=skitechnology"},_={ref:"copyButtonRef",id:"kt_share_earn_link_copy_button",class:"btn btn-light fw-bolder flex-shrink-0","data-clipboard-target":"#kt_share_earn_link_input"},x=(0,t.uE)('<div class="d-flex"><a href="#" class="btn btn-light-primary w-100"><img alt="Logo" src="media/svg/brand-logos/google-icon.svg" class="h-15px me-3"> Import Contacts </a><a href="#" class="btn btn-icon btn-facebook w-100 mx-6"><img alt="Logo" src="media/svg/brand-logos/facebook-2.svg" class="h-20px me-3"> Facebook </a><a href="#" class="btn btn-icon btn-twitter w-100"><img alt="Logo" src="media/svg/brand-logos/twitter.svg" class="h-20px me-3"> Twitter </a></div><div class="d-flex align-items-center mt-10"><div class="flex-grow-1"><span class="fs-6 fw-bold text-gray-800 d-block">Adding Users by Team Members</span><span class="fs-7 fw-bold text-gray-400">If you need more info, please check budget planning</span></div><label class="form-check form-switch form-check-custom form-check-solid"><input class="form-check-input" type="checkbox" value="1" checked="checked"><span class="form-check-label"> Allowed </span></label></div>',2);function k(e,a,n,s,r,k){var w=(0,t.up)("inline-svg");return(0,t.wg)(),(0,t.iD)("div",l,[(0,t._)("div",o,[(0,t._)("div",i,[(0,t._)("div",c,[(0,t._)("div",d,[(0,t._)("span",u,[(0,t.Wm)(w,{src:"media/icons/duotune/arrows/arr061.svg"})])])]),(0,t._)("div",m,[(0,t._)("div",f,[v,(0,t._)("div",b,[p,(0,t._)("div",g,[(0,t._)("input",h,null,512),(0,t._)("button",_," Copy Link ",512)])]),x])])])])])}var w=n(2262),y=n(42152),T=n.n(y),M=(0,t.aZ)({name:"share-and-earn-modal",components:{},setup:function(){var e=(0,w.iH)(null),a=(0,w.iH)(null);return(0,t.bv)((function(){var n=new(T())(e.value);n.on("success",(function(n){var t,s,r,l=null===(t=e.value)||void 0===t?void 0:t.innerHTML;null===(s=a.value)||void 0===s||s.classList.add("bg-success"),null===(r=a.value)||void 0===r||r.classList.add("text-inverse-success"),e.value&&(e.value.innerHTML="Copied!"),setTimeout((function(){var n,t;e.value&&l&&(e.value.innerHTML=l),null===(n=a.value)||void 0===n||n.classList.remove("bg-success"),null===(t=a.value)||void 0===t||t.classList.remove("text-inverse-success")}),3e3),n.clearSelection()}))})),{copyButtonRef:e,inputRef:a}}}),S=n(83744);const C=(0,S.Z)(M,[["render",k]]);var L=C,E=n(68932),Z=n(79097),A=(0,t.aZ)({name:"share-and-earn",components:{KTModalsCard:r.Z,KTShareAndEarnModal:L},setup:function(){return(0,t.bv)((function(){(0,E.M)("Share & Earn",["Modals","General"])})),{getIllustrationsPath:Z.O}}});const I=(0,S.Z)(A,[["render",s]]);var H=I}}]);
//# sourceMappingURL=2134.8e6aa935.js.map