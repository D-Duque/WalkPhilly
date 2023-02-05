<template>
    <div>
        I am photo playground
        <p>This is your place ID: {{this.placeId}}</p>
    </div>
</template>
<script>
import placesServices from "../services/PlacesService"

export default {
    data() {
        return {
            photoJSON: {},
            photoJSONDefault: {},
            placeId: '',
        }

    },
    created() {

        // placesServices.getPhotoReference("12th and Arch Sts., Philadelphia, PA 19107").then((response) => {
        //     this.photoJSON = response.data
        // }),
        //     placesServices.getPhotoReferenceDefault().then((response) => {
        //         this.photoJSONDefault = response.data
        //     })

        placesServices.getPlaceId("Reading Terminal Market").then(response => {
            this.placeId=response.data
        })
    }
}


</script>
<style>

</style>