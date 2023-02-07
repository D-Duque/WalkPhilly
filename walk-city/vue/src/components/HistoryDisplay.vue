<template>
    <div class="history">
        <div class="history-card">
            <img id="verified-img" src="../assets/verified-account.png">
            <h3>{{ locationObject.locationName }}</h3>
            <h4>{{ entry.checkInTime }}</h4>
        </div>
    </div>
</template>
<script>

import locationService from '../services/LocationService';

export default {
    components: {

    },
    data() {
        return {
            locationObject: {}
        }
    },
    props: ["entry"],

    created() {
        locationService.getLocationById(this.entry.locationId).then(response => {
            this.locationObject = response.data
        })

    }
}


</script>
<style scoped>
div.history {
    /* display: grid; */
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
    background-color: white;
    color: rgb(0, 73, 83);
    align-items: center;
    align-self: center;
}

div.history p {
    margin: 20px;
}

div.history h3 {
    display: inline-block;
}

div.history h4 {
    font-size: 1rem;
    margin: 3px;
    display: flex;
    justify-content: center;
}

#history-card {
    display: flex;
    justify-content: center;
}

#verified-img {
    margin-right: 10px;
    justify-content: left;
}

</style>