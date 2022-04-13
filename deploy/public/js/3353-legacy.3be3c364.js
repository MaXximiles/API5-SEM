"use strict";(self["webpackChunkdemo1"]=self["webpackChunkdemo1"]||[]).push([[3353],{79097:function(e,a,t){t.d(a,{O:function(){return r}});var n=t(5080),r=function(e){return"media/illustrations/".concat(n.Gv.value,"/").concat(e)}},68932:function(e,a,t){t.d(a,{M:function(){return i},V:function(){return o}});var n=t(61107),r=t(15758),i=function(e,a){n.Z.dispatch(r.e.SET_BREADCRUMB_ACTION,{title:e,pageBreadcrumbPath:a})},o=function(e){n.Z.dispatch(r.e.SET_BREADCRUMB_ACTION,{title:e})}},5080:function(e,a,t){t.d(a,{Df:function(){return h},F9:function(){return p},Fh:function(){return s},Gv:function(){return w},K1:function(){return v},Lj:function(){return l},Ne:function(){return d},_T:function(){return f},az:function(){return b},jH:function(){return o},o$:function(){return c},o4:function(){return y},pD:function(){return g},vc:function(){return i},vj:function(){return x},xV:function(){return u},zK:function(){return m}});var n=t(66252),r=t(61107),i=(0,n.Fl)((function(){return r.Z.getters.layoutConfig()})),o=((0,n.Fl)((function(){return r.Z.getters.layoutConfig("sidebar.display")})),(0,n.Fl)((function(){return"fluid"===r.Z.getters.layoutConfig("footer.width")}))),s=(0,n.Fl)((function(){return"fluid"===r.Z.getters.layoutConfig("header.width")})),l=(0,n.Fl)((function(){return r.Z.getters.layoutConfig("header.left")})),c=(0,n.Fl)((function(){return!0===r.Z.getters.layoutConfig("aside.display")})),d=(0,n.Fl)((function(){return"fluid"===r.Z.getters.layoutConfig("toolbar.width")})),u=(0,n.Fl)((function(){return r.Z.getters.layoutConfig("toolbar.display")})),m=(0,n.Fl)((function(){return r.Z.getters.layoutConfig("loader.display")})),f=(0,n.Fl)((function(){return"fluid"===r.Z.getters.layoutConfig("content.width")})),g=(0,n.Fl)((function(){return""+r.Z.getters.layoutConfig("loader.logo")})),v=(0,n.Fl)((function(){return!!r.Z.getters.layoutConfig("aside.display")})),p=(0,n.Fl)((function(){return r.Z.getters.layoutConfig("aside.theme")})),b=(0,n.Fl)((function(){return r.Z.getters.layoutConfig("toolbar.display")})),y=(0,n.Fl)((function(){return r.Z.getters.layoutConfig("aside.menuIcon")})),h=(0,n.Fl)((function(){return r.Z.getters.layoutConfig("main.logo.light")})),x=(0,n.Fl)((function(){return r.Z.getters.layoutConfig("main.logo.dark")})),w=((0,n.Fl)((function(){return r.Z.getters.layoutConfig("header.menuIcon")})),(0,n.Fl)((function(){return r.Z.getters.layoutConfig("illustrations.set")})))},81128:function(e,a,t){t.d(a,{Z:function(){return y}});var n=t(66252),r=t(3577),i={class:"card"},o={class:"card-body p-0"},s={class:"card-px text-center py-20 my-10"},l={class:"fs-2x fw-bolder mb-10"},c={class:"text-gray-400 fs-5 fw-bold mb-13"},d=["innerHTML"],u=["data-bs-target"],m={class:"text-center px-5"},f=["src"];function g(e,a,t,g,v,p){return(0,n.wg)(),(0,n.iD)("div",i,[(0,n._)("div",o,[(0,n._)("div",s,[(0,n._)("h2",l,(0,r.zw)(e.title),1),(0,n._)("p",c,[(0,n._)("span",{innerHTML:e.description},null,8,d)]),(0,n._)("button",{type:"button",class:"btn btn-primary er fs-6 px-8 py-4","data-bs-toggle":"modal","data-bs-target":"#".concat(e.modalId)},(0,r.zw)(e.buttonText),9,u)]),(0,n._)("div",m,[(0,n._)("img",{src:e.image,alt:"",class:"mw-100 mh-300px"},null,8,f)])])])}var v=(0,n.aZ)({name:"modal-card",props:{title:String,description:String,buttonText:String,image:String,modalId:String},components:{}}),p=t(83744);const b=(0,p.Z)(v,[["render",g]]);var y=b},67184:function(e,a,t){t.d(a,{Z:function(){return S}});var n=t(66252),r=t(3577),i=t(49963),o={class:"modal fade",id:"kt_modal_invite_friends",tabindex:"-1","aria-hidden":"true"},s={class:"modal-dialog mw-650px"},l={class:"modal-content"},c={class:"modal-header pb-0 border-0 justify-content-end"},d={class:"btn btn-sm btn-icon btn-active-color-primary","data-bs-dismiss":"modal"},u={class:"svg-icon svg-icon-1"},m={class:"modal-body scroll-y mx-5 mx-xl-18 pt-0 pb-15"},f=(0,n.uE)('<div class="text-center mb-13"><h1 class="mb-3">Invite a Friend</h1><div class="text-gray-400 fw-bold fs-5"> If you need more info, please check out <a href="#" class="link-primary fw-bolder">FAQ Page</a>. </div></div><div class="btn btn-light-primary fw-bolder w-100 mb-8"><img alt="Logo" src="media/svg/brand-logos/google-icon.svg" class="h-20px me-3"> Invite Gmail Contacts </div><div class="separator d-flex flex-center mb-8"><span class="text-uppercase bg-white fs-7 fw-bold text-gray-400 px-3">or</span></div><textarea class="form-control form-control-solid mb-8" rows="3" placeholder="Type or paste emails here">\r\n          </textarea>',4),g={class:"mb-10"},v=(0,n._)("div",{class:"fs-6 fw-bold mb-2"},"Your Invitations",-1),p={class:"mh-300px scroll-y me-n7 pe-7"},b={class:"d-flex align-items-center"},y={class:"symbol symbol-35px symbol-circle"},h=["src"],x={class:"ms-5"},w={href:"#",class:"fs-5 fw-bolder text-gray-900 text-hover-primary mb-2"},_={class:"fw-bold text-gray-400"},C={class:"ms-2 w-100px"},Z=["onUpdate:modelValue"],k=(0,n._)("option",{value:"1"},"Guest",-1),F=(0,n._)("option",{value:"2"},"Owner",-1),M=(0,n._)("option",{value:"3"},"Can Edit",-1),I=[k,F,M],T=(0,n.uE)('<div class="d-flex flex-stack"><div class="me-5 fw-bold"><label class="fs-6">Adding Users by Team Members</label><div class="fs-7 text-gray-400"> If you need more info, please check budget planning </div></div><label class="form-check form-switch form-check-custom form-check-solid"><input class="form-check-input" type="checkbox" value="1" checked="checked"><span class="form-check-label fw-bold text-gray-400"> Allowed </span></label></div>',1);function j(e,a,t,k,F,M){var j=(0,n.up)("inline-svg");return(0,n.wg)(),(0,n.iD)("div",o,[(0,n._)("div",s,[(0,n._)("div",l,[(0,n._)("div",c,[(0,n._)("div",d,[(0,n._)("span",u,[(0,n.Wm)(j,{src:"media/icons/duotune/arrows/arr061.svg"})])])]),(0,n._)("div",m,[f,(0,n._)("div",g,[v,(0,n._)("div",p,[((0,n.wg)(!0),(0,n.iD)(n.HY,null,(0,n.Ko)(e.users,(function(e,a){return(0,n.wg)(),(0,n.iD)("div",{key:a,class:"d-flex flex-stack py-4 border-bottom border-gray-300 border-bottom-dashed"},[(0,n._)("div",b,[(0,n._)("div",y,[e.avatar?((0,n.wg)(),(0,n.iD)("img",{key:0,alt:"Pic",src:e.avatar},null,8,h)):((0,n.wg)(),(0,n.iD)("span",{key:1,class:(0,r.C_)(["bg-light-".concat(e.state," text-").concat(e.state),"symbol-label fw-bold"])},(0,r.zw)(e.name.charAt(0)),3))]),(0,n._)("div",x,[(0,n._)("a",w,(0,r.zw)(e.name),1),(0,n._)("div",_,(0,r.zw)(e.email),1)])]),(0,n._)("div",C,[(0,n.wy)((0,n._)("select",{"onUpdate:modelValue":function(a){return e.access=a},class:"form-select form-select-solid form-select-sm","data-control":"select2","data-hide-search":"true"},I,8,Z),[[i.bM,e.access]])])])})),128))])]),T])])])])}var D=(0,n.aZ)({name:"invite-friends-modal",components:{},setup:function(){var e=[{avatar:"media/avatars/300-6.jpg",name:"Emma Smith",email:"e.smith@kpmg.com.au",access:"1"},{state:"danger",name:"Melody Macy",email:"melody@altbox.com",access:"1"},{avatar:"media/avatars/300-1.jpg",name:"Max Smith",email:"max@kt.com",access:"3"},{avatar:"media/avatars/300-1.jpg",name:"Sean Bean",email:"sean@dellito.com",access:"2"},{avatar:"media/avatars/300-25.jpg",name:"Brian Cox",email:"brian@exchange.com",access:"3"},{state:"warning",name:"Mikaela Collins",email:"mikaela@pexcom.com",access:"2"},{avatar:"media/avatars/300-9.jpg",name:"Francis Mitcham",email:"f.mitcham@kpmg.com.au",access:"3"},{state:"danger",name:"Olivia Wild",email:"olivia@corpmail.com",access:"2"},{state:"info",name:"Neil Owen",email:"owen.neil@gmail.com",access:"1"},{avatar:"media/avatars/300-23.jpg",name:"Dan Wilson",email:"dam@consilting.com",access:"3"},{state:"danger",name:"Emma Bold",email:"emma@intenso.com",access:"2"},{avatar:"media/avatars/300-12.jpg",name:"Ana Crown",email:"ana.cf@limtel.com",access:"1"},{state:"primary",name:"Robert Doe",email:"robert@benko.com",access:"3"},{avatar:"media/avatars/300-13.jpg",name:"John Miller",email:"miller@mapple.com",access:"3"},{state:"success",name:"Lucy Kunic",email:"lucy.m@fentech.com",access:"2"},{state:"media/avatars/300-21.jpg",name:"Ethan Wilder",email:"ethan@loop.com.au",access:"1"},{state:"media/avatars/300-12.jpg",name:"Ana Crown",email:"ana.cf@limtel.com",access:"3"}];return{users:e}}}),E=t(83744);const A=(0,E.Z)(D,[["render",j]]);var S=A},23353:function(e,a,t){t.r(a),t.d(a,{default:function(){return m}});var n=t(66252);function r(e,a,t,r,i,o){var s=(0,n.up)("KTModalCard"),l=(0,n.up)("KTInviteFriendsModal");return(0,n.wg)(),(0,n.iD)(n.HY,null,[(0,n.Wm)(s,{title:"Invite Friends Modal Example",description:"Click on the below buttons\r\n  to launch <br />\r\n  a friend invitation example.",image:e.getIllustrationsPath("1.png"),"button-text":"Invite Friends","modal-id":"kt_modal_invite_friends"},null,8,["image"]),(0,n.Wm)(l)],64)}var i=t(81128),o=t(67184),s=t(68932),l=t(79097),c=(0,n.aZ)({name:"invite-friends",components:{KTModalCard:i.Z,KTInviteFriendsModal:o.Z},setup:function(){return(0,n.bv)((function(){(0,s.M)("Invite Friends",["Modals","General"])})),{getIllustrationsPath:l.O}}}),d=t(83744);const u=(0,d.Z)(c,[["render",r]]);var m=u}}]);
//# sourceMappingURL=3353-legacy.3be3c364.js.map