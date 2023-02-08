<template >
    <div class="badge-card" :class="{ 'not-earned-card': !isEarned }"> {{ badge.badgeName }}
        <img :src="require(`../assets/${badge.badgeImage}.png`)">
    </div>
</template>
<script>
// import badgesServices from "../services/BadgesServices";

export default {
    props: ["badge", "userBadgeList"],
    mounted() {

    },
    computed: {
        isEarned() {
            return this.userBadgeList.filter(entry => entry.badgeId == this.badge.badgeId).length == 1
        }
    }
}

</script>
<style scoped>
div.badge {
    display: grid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
    color: rgb(0, 73, 83);
    grid-template-columns: repeat(2, 1fr);
    column-gap: 1rem;
    row-gap: 1rem;
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

.not-earned-card {
    -webkit-filter: grayscale(100%);
}
</style>