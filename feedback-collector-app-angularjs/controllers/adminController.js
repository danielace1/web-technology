app.controller("adminController", function ($scope, dataService) {
  $scope.questions = [];
  $scope.error = "";

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

  $scope.addQuestion = function () {
    if (!$scope.questionText || !$scope.questionType) {
      $scope.error = "Please enter question and select type";
      return;
    }

    const newQ = {
      text: $scope.questionText,
      type: $scope.questionType,
    };

    dataService.addQuestion(newQ).then(() => {
      $scope.questionText = "";
      $scope.questionType = "";
      $scope.error = "";

      loadQuestions();
    });
  };

  $scope.removeQuestion = function (index) {
    $scope.questions.splice(index, 1);
  };
});
