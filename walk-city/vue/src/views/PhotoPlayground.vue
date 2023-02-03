<template>
    <div>
        I am photo playground
    </div>
</template>
<script>
import placesServices from "../services/PlacesService"

export default {
    data() {
        return {
            photoJSON: {},
            photoJSONDefault: {}
        }

    },
    created() {

        placesServices.getPhotoReference("12th and Arch Sts., Philadelphia, PA 19107").then((response) => {
            this.photoJSON = response.data
        }),
            placesServices.getPhotoReferenceDefault().then((response) => {
                this.photoJSONDefault = response.data
            })
    }
}


</script>
<style>

</style>