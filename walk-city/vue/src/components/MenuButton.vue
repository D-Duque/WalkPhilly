<template>
    <div @click="menuToggle" id="menu-button">
        MENU
    </div>
</template>
<script>
export default {
    name: 'menu-button',
    props: [],
    methods: {
        menuToggle() {
            this.$store.commit('MENU_TOGGLE');
        }
    },
}
</script>
<style>
#menu-button {
    position: fixed;
    display: flex;
    bottom: 0px;
    background: #004953;
    height: 7%;
    width: 100%;
    justify-content: center;
    align-items: center;
    font-size: x-large;
}
</style>