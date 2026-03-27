app.controller("formController", function ($scope, dataService) {
  $scope.questions = [];
  $scope.answers = [];

  $scope.error = "";
  $scope.success = false;

  // 🚀 Load questions from Firebase
  function loadQuestions() {
    dataService.getForm().then((doc) => {
      if (doc.exists) {
        $scope.questions = doc.data().questions || [];
      } else {
        $scope.questions = [];
      }

      $scope.$apply(); // IMPORTANT for AngularJS
    });
  }

  loadQuestions();

  // 🚀 Submit Form
  $scope.success = false;

  $scope.submitForm = function () {
    // Validation
    for (let i = 0; i < $scope.questions.length; i++) {
      if (!$scope.answers[i]) {
        $scope.error = "Please answer all questions";
        return;
      }
    }

    dataService.addResponse([...$scope.answers]).then(() => {
      $scope.success = true;
      $scope.answers = [];
      $scope.$apply();
    });
  };

  // 🔄 Reset form
  $scope.resetForm = function () {
    $scope.success = false;
  };
});
