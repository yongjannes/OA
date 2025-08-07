const routes = [
    {
        path: '/security/home',
        name: 'SecurityHome',
        component: () => import("@/views/security/login/index.vue")
    }

];
export default routes;