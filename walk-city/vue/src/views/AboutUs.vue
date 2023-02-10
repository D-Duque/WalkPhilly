<style scoped>
#about-us{
  margin: 5%;
}
#team-container{
  display: grid;
  grid-template-columns: 1fr 1fr;
  justify-items: center;
  align-items: center;
  text-align: center;
  margin-top: 20%;
    gap: 10px;
}
.name{
 
}
.headshot{
  object-fit:cover;
  width: 125px !important;
  height: 125px;
  border-radius: 50%;

  left: -1000%;
  right: -1000%;
  top: -1000%;
  bottom: -1000%;
  border-color: black;
}
#emma>.headshot {
  
}
</style>

<template>
  <div id="about-us">
    <h1 id="title">Meet Team Llama Drama</h1>
    <div id="team-container">
      <div id="daniel">
        <h4 class="name">Daniel Duque</h4>
        <img class= "headshot" src="../assets/llama-drama/daniel.jpg" alt="" />
      </div>
      <div id="patricia">
        <h4 class="name">Patricia Kamlley</h4>
        <img class= "headshot" src="../assets/llama-drama/patricia.png" alt="" />
      </div>
      <div id="hong">
        <h4 class="name">Hong Le</h4>
        <img class= "headshot" src="../assets/llama-drama/hong.jpg" alt="" />
      </div>
      <div id="emma">
        <h4 class="name">Emma Nguyen</h4>
        <img class= "headshot" src="../assets/llama-drama/emma.png" alt="" />
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

