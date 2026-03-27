app.factory("dataService", function () {
  const db = window.db;

  return {
    getForm: function () {
      return db.collection("forms").doc("main").get();
    },

    addQuestion: function (q) {
      return db
        .collection("forms")
        .doc("main")
        .set(
          {
            questions: firebase.firestore.FieldValue.arrayUnion(q),
          },
          { merge: true },
        );
    },

    getResponses: function () {
      return db.collection("responses").get();
    },

    addResponse: function (res) {
      return db.collection("responses").add({
        answers: res,
        createdAt: new Date(),
      });
    },
  };
});
