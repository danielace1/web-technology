app.controller(
  "loginController",
  function ($scope, $rootScope, $location, authService) {
    $scope.login = function () {
      authService
        .login($scope.email, $scope.password)
        .then(() => {
          // 🔥 Temporary role logic
          if ($scope.email === "admin@gmail.com") {
            $rootScope.userRole = "admin";
            $location.path("/admin");
          } else {
            $rootScope.userRole = "user";
            $location.path("/form");
          }

          $scope.$apply();
        })
        .catch((err) => {
          $scope.error = err.message;
          $scope.$apply();
        });
    };
  },
);
