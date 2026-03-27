app.controller("adminController", function ($scope, dataService) {
  $scope.questions = [];
  $scope.error = "";

  // 🚀 Load questions from Firebase
  function loadQuestions() {
    dataService.getForm().then((doc) => {
      if (doc.exists) {
        $scope.questions = doc.data().questions || [];
      } else {
        $scope.questions = [];
      }

      $scope.$apply(); // IMPORTANT (Angular digest)
    });
  }

  loadQuestions();

  // ➕ Add Question
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

      loadQuestions(); // 🔄 refresh UI
    });
  };

  // ❌ Remove Question (local only for now)
  $scope.removeQuestion = function (index) {
    $scope.questions.splice(index, 1);
  };
});
