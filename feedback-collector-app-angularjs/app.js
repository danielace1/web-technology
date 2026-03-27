var app = angular.module("feedbackApp", ["ngRoute"]);

app.run(function ($rootScope, $location, authService) {
  // 🔥 Detect login page
  $rootScope.$on("$routeChangeStart", function (event, next) {
    const path = next.$$route?.originalPath;

    $rootScope.isLoginPage = path === "/login";
    $rootScope.isAuthPage = path === "/login" || path === "/signup";
  });

  // 🔥 Logout
  $rootScope.logout = function () {
    authService.logout().then(() => {
      $rootScope.userRole = null;
      $location.path("/login");
      $rootScope.$apply();
    });
  };

  // 🔥 Auth state listener (MOVE HERE ✅)
  authService.onAuthStateChanged(function (user) {
    if (user) {
      if (!$rootScope.userRole) {
        $rootScope.userRole = "user"; // fallback
      }
    } else {
      $location.path("/login");
    }

    if (!$rootScope.$$phase) {
      $rootScope.$apply();
    }
  });
});
