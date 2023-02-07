<template >
    <div class="badge">
        <div class="badge-card"> <img id="badge-img" src="../assets/badge.png"> 
        </div>
        <div class="badge-image"></div>
    
    </div>
</template>
<script>
export default {

}
</script>
<style scoped>
div.badge {
    display: grid;
    /* border: 1px black solid; */
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
    /* background-color: white; */
    color: rgb(0, 73, 83);
    align-items: center;
    align-self: center;
}

div.badge p {
    margin: 20px;
}

div.badge h3 {
    display: inline-block;
}

div.badge h4 {
    font-size: 1rem;
}

.badge-card {
    background: #4FD695;
    border: 1px solid #000000;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    width: 146px;
    height: 158px;
    border-radius: 6px;
    display: flex;
    justify-content: center;
    padding: 1rem;
}


</style>