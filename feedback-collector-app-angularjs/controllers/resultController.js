app.controller("resultController", function ($scope, dataService) {
  $scope.responses = [];
  $scope.questions = [];

  $scope.avgRatings = [];
  $scope.yesNoStats = [];

  // 🚀 Load everything from Firebase
  function loadData() {
    // 📥 Load questions
    dataService.getForm().then((doc) => {
      if (doc.exists) {
        $scope.questions = doc.data().questions || [];
      }

      $scope.$apply();
    });

    // 📥 Load responses
    dataService.getResponses().then((snapshot) => {
      $scope.responses = [];

      snapshot.forEach((doc) => {
        $scope.responses.push(doc.data().answers);
      });

      calculateAnalytics();

      $scope.$apply();
    });
  }

  // 🔥 Analytics Calculation
  function calculateAnalytics() {
    let ratingTotals = [];
    let ratingCounts = [];
    let yesCounts = [];
    let noCounts = [];

    for (let i = 0; i < $scope.questions.length; i++) {
      ratingTotals[i] = 0;
      ratingCounts[i] = 0;
      yesCounts[i] = 0;
      noCounts[i] = 0;
    }

    $scope.responses.forEach((res) => {
      res.forEach((ans, i) => {
        if ($scope.questions[i]?.type === "rating" && ans) {
          ratingTotals[i] += parseInt(ans);
          ratingCounts[i]++;
        }

        if ($scope.questions[i]?.type === "yesno") {
          if (ans === "Yes") yesCounts[i]++;
          if (ans === "No") noCounts[i]++;
        }
      });
    });

    for (let i = 0; i < $scope.questions.length; i++) {
      if (ratingCounts[i] > 0) {
        $scope.avgRatings[i] = (ratingTotals[i] / ratingCounts[i]).toFixed(1);
      } else {
        $scope.avgRatings[i] = null;
      }

      $scope.yesNoStats[i] = {
        yes: yesCounts[i],
        no: noCounts[i],
      };
    }
  }

  loadData();
});
