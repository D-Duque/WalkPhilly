<style scoped>
#about-us {
  padding: 5%;
  background-image: url("../assets/philadelphia-aerial-view.jpg") !important;
  background-size: cover;
  height: 100vh;
  background-repeat: no-repeat;
}
#header-container {
  display: flex;
  flex-direction: row;
  padding: 5% 5%;
  font-weight: bold;
  background: rgba(23, 19, 19, 0.25) !important;
  backdrop-filter: blur(15px) !important;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 6px;
  align-items: center;
}
#title {
  text-align: center;
  font-weight:100px;
}
#logo {
  width: 30%;
  height: 30%;
}
#team-container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  justify-items: center;
  align-items: center;
  text-align: center;
  margin-top: 10%;
  gap: 10px;
}

.headshot {
  object-fit: cover;
  width: 125px;
  height: 125px;
  border-radius: 50%;
  border-style: solid;
  align-self: center;
  left: -1000%;
  right: -1000%;
  top: -1000%;
  bottom: -1000%;
  border-color: white;
}
#emma > .headshot {
  
}
.profile-card {
  background: rgba(23, 19, 19, 0.25) !important;
  backdrop-filter: blur(15px) !important;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  height: 223px;
  width: 170px;
  border-radius: 6px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding: 10%;
  color: white;
  font-weight: 100;
  text-align: center;
  font-size: 1rem;
}
.back-button {
  margin-top: 20%;
}
</style>

<template>
  <div id="about-us">
    <div id="header-container">
      <img id="logo" src="../assets/llama.png" alt="" />
      <h1 id="title">Team Llama Drama</h1>
    </div>

    <div id="team-container">
      <div class="profile-card" id="daniel">
        <h4 class="name">Daniel Duque</h4>
        <img class="headshot" src="../assets/llama-drama/daniel.jpg" alt="" />
      </div>
      <div class="profile-card" id="patricia">
        <h4 class="name">Patricia Kamlley</h4>
        <img class="headshot" src="../assets/llama-drama/patricia.png" alt="" />
      </div>
      <div class="profile-card" id="hong">
        <h4 class="name">Hong Le</h4>
        <img class="headshot" src="../assets/llama-drama/hong.jpg" alt="" />
      </div>
      <div class="profile-card" id="emma">
        <h4 class="name">Emma Nguyen</h4>
        <img class="headshot" src="../assets/llama-drama/emma-cropped.png" alt="" />
      </div>
    </div>
    <div class="back-button">
      <router-link id="back-button" to="/login">
        <img src="../assets/back-arrow.png" />
      </router-link>
    </div>
  </div>
</template>

<script>
export default {};
</script>

