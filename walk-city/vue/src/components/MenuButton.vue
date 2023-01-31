<template>
    <div id="menu-button">
        MENU
    </div>
</template>
<script>
export default {
    name: 'menu-button',
    props: [],
    methods: {},
}
</script>
<style>
#menu-button {
    position: fixed;
    display: flex;
    bottom: 0px;
    background: #004953;
    height: 5%;
    width: 100%;
    justify-content: center;
    align-items: center;
    font-size: large;
}
</style>