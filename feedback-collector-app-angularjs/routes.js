app.config(function ($routeProvider) {
  $routeProvider
    .when("/admin", {
      templateUrl: "views/admin.html",
      controller: "adminController",
      resolve: {
        auth: function ($rootScope, $location, authService) {
          const user = authService.getCurrentUser();

          if (!user) {
            $location.path("/login");
          }

          if ($rootScope.userRole !== "admin") {
            $location.path("/form");
          }
        },
      },
    })
    .when("/form", {
      templateUrl: "views/form.html",
      controller: "formController",
      resolve: {
        auth: function ($location, authService) {
          const user = authService.getCurrentUser();
          if (!user) {
            $location.path("/login");
          }
        },
      },
    })
    .when("/result", {
      templateUrl: "views/result.html",
      controller: "resultController",
      resolve: {
        auth: function ($rootScope, $location) {
          if ($rootScope.userRole !== "admin") {
            $location.path("/form");
          }
        },
      },
    })
    .when("/signup", {
      templateUrl: "views/signup.html",
      controller: "signupController",
    })
    .when("/login", {
      templateUrl: "views/login.html",
      controller: "loginController",
    })
    .otherwise({
      redirectTo: "/form",
    });
});
