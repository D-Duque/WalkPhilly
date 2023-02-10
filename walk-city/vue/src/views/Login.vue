<template>
  <div id="login" class="text-left">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="mb-3 font-weight-bold text-center">WalkPhilly</h1>
      <router-link :to="{name: 'about-us'}">
      <img src="../assets/llama.png">
      </router-link>
      <div class="welcome-message text-center ">
        <p>Let's go for a walk.</p>
      </div>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">Invalid username and password!</div>
      <div class="alert alert-success" role="alert" v-if="this.$route.query.registration">Thank you for registering,
        please sign in.</div>

      <div class="user-credentials">
        <label for="username" class="sr-only">Username</label>
        <input type="text" id="username" class="form-control" placeholder="enter username" v-model="user.username"
          required autofocus />
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" class="form-control" placeholder="enter password" v-model="user.password"
          required />
      </div>
      <div class="button-container text-center">
        <div><router-link :to="{ name: 'register' }">Need an account?</router-link> </div>
        <div><button type="submit" class="btn-midnight-green">LOGIN</button></div>
        <div><router-link :to="{ name: 'home' }"><button class="btn-midnight-green">GUEST MODE</button></router-link>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
#app {
  display: grid;
  font-weight: bold;
  justify-content: center;
  padding: 20px;
}

#login {
  background-image: url("../assets/philadelphia-aerial-view.jpg") !important;
  background-size: cover;
  height: 100vh;
  background-repeat: no-repeat;
}

@media (max-width: 800px) {
  #login {
    background-position: -460px;
  }

}

h1 {
  font-size: 48px !important;
}

img {
  width: 240px;
  position: relative;
  left: 21vw
}

.user-credentials {
  margin-top: 40px;
}

.form-control {
  align-self: center;
  margin-top: 20px;
  max-width: 20rem;
}

.form-signin {
  margin: 30px 20px;
}

.button-container {
  display: flex;
  margin-top: 20px;
}

.welcome-message {
  font-size: 1.5em
}
</style>