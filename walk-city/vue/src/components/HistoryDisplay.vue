<template>
    <div class="history">
        <div class="histoy-card">
            <img id="verified-img" src="../assets/verified-account.png">
            <h3>Location Name</h3>
            <h4>Time Stamp</h4>
        </div>
    </div>
</template>
<script>
export default {

}
</script>
<style scoped>

div.history {
  display: grid;
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
}

/* #history-card {
    display: flex;
    flex-direction: column;
} */

</style>