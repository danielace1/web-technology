app.factory("authService", function ($q) {
  return {
    login: function (email, password) {
      return firebase.auth().signInWithEmailAndPassword(email, password);
    },

    logout: function () {
      return firebase.auth().signOut();
    },

    getCurrentUser: function () {
      return firebase.auth().currentUser;
    },

    onAuthStateChanged: function (callback) {
      firebase.auth().onAuthStateChanged(callback);
    },
  };
});
