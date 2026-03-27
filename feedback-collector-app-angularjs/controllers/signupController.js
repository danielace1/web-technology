app.controller("signupController", function ($scope, $location) {
  $scope.signup = function () {
    firebase
      .auth()
      .createUserWithEmailAndPassword($scope.email, $scope.password)
      .then((userCredential) => {
        const user = userCredential.user;

        // 🔥 Save user in Firestore (IMPORTANT)
        window.db.collection("users").doc(user.uid).set({
          name: $scope.name,
          email: $scope.email,
          role: "user", // default role
        });

        // Redirect to login
        $location.path("/login");
        $scope.$apply();
      })
      .catch((err) => {
        $scope.error = err.message;
        $scope.$apply();
      });
  };
});
