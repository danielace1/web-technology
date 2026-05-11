app.controller("formController", function ($scope, dataService) {
  $scope.questions = [];
  $scope.answers = [];

  $scope.error = "";
  $scope.success = false;

  function loadQuestions() {
    dataService.getForm().then((doc) => {
      if (doc.exists) {
        $scope.questions = doc.data().questions || [];
      } else {
        $scope.questions = [];
      }

      $scope.$apply();
    });
  }

  loadQuestions();

  $scope.success = false;

  $scope.submitForm = function () {
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

  $scope.resetForm = function () {
    $scope.success = false;
  };
});
