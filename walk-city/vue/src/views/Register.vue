<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-bold">Register</h1>
      <div class="text-center">
        <img src="../assets/llama.png">
      </div>
      <div class="register-message text-center text-uppercase">
        Please create an account so you can find an amazing philly cheesesteak and explore everything Philadelphia has
        to offer!
      </div>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>

      <div class="create-account">
        <label for="username" class="sr-only">Username</label>
        <input type="text" id="username" class="form-control" placeholder="enter username" v-model="user.username"
          required autofocus />
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" class="form-control" placeholder="enter password" v-model="user.password"
          required />
        <input type="password" id="confirmPassword" class="form-control" placeholder="confirm password"
          v-model="user.confirmPassword" required />
      </div>

      <div class="button-container text-center">
        <div><router-link :to="{ name: 'login' }">Have an account?</router-link> </div>
        <div><button class="btn-midnight-green" type="submit"> CREATE ACCOUNT </button> </div>
      </div>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
#app {
  display: grid;  
  font-weight: bold;
  justify-content: center;
  padding: 20px;
}
#register {
  background-image: url("../assets/philadelphia-aerial-view.jpg") !important;
  background-size: cover;
  height: 100vh;
  font-weight: bold;
 
  background-repeat: no-repeat;
}
@media (max-width: 800px) {
  #register {
     background-position: -460px;
  }  
}
h1 {
  font-size: 48px !important;
}
img {
  width: 240px;
}

.user-credentials {
  margin-top: 40px;
}
.form-control{
  align-self: center;
  margin-top: 20px;
  max-width: 20rem;
}
.form-register {
  margin: 30px 20px;
}
.button-container {
  display: flex;
  margin-top: 20px;
}
</style>
