<template>
  <div id="login" class="text-left">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal text-center">WalkPhilly</h1>
      <div class="text-center">
        <img src="../assets/llama.png">
      </div>
      <div class="welcome-message text-center">
        Hello and welcome to our app. Please take a walk and eat a philly cheesecake outside of Betsy Ross's
        house--where American was born!
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
        <div><button type="submit" class="btn-midnight-green">LOGIN</button></div>
        <div><router-link :to="{ name: 'register' }"><button type="register"
              class="btn-midnight-green">REGISTER</button></router-link>
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
