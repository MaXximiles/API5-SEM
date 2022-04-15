import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: 
    { 
        emp_id: '',
        emp_nome: '',
        emp_cnpj: '',
        cid_id: '',
        cnae_id: '',
        emp_origem: ''
    },
    mutations: 
    {
        setEmpId(state, valor){ state.emp_id = valor},
        setEmpNome(state, valor){ state.emp_nome = valor},
        setEmpCnpj(state, valor){ state.emp_cnpj = valor},
        setCidId(state, valor){ state.cid_id = valor},
        setCnaeId(state, valor){ state.cnae_id = valor},
        setEmpOrigem(state, valor){ state.emp_origem = valor}
    },
    actions: {},
    modules: {}
})
