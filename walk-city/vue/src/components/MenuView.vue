<template>
    <div @click="menuToggle" id="main-menu">
        WHEE I AM MENU
    </div>
</template>
<script>
export default {
    name: 'menu-view',
    props: [],
    methods: {
        menuToggle() {
            this.$store.commit('MENU_TOGGLE');
        }
    },
}
</script>

<style>
main-menu {
    position: absolute;
    width: 501px;
    height: 844px;
    left: -14px;
    top: 207px;
    background: #004953
}
</style>