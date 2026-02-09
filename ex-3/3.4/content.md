# Title

Event Registration Form Using DHTML

## Objective

To design and develop an Event Registration Form using DHTML that collects attendee information, allows session selection, validates user inputs dynamically, prevents scheduling conflicts and duplicate registrations, enforces age restrictions for specific sessions, calculates registration cost automatically, and displays a confirmation summary before final submission.

## Tools Required

- HTML5
- CSS3
- JavaScript (DHTML)
- Web Browser
- Code Editor

## Procedure

- Create the basic structure of the event registration form using HTML.
- Add input fields for attendee details such as name, email, and age.
- Provide session selection options using checkboxes with time, cost, and age constraints.
- Apply CSS to enhance the user interface and improve form readability.
- Use JavaScript to validate email format and mandatory input fields.
- Implement age verification logic for sessions with age restrictions.
- Detect and prevent scheduling conflicts when multiple sessions with the same time slot are selected.
- Calculate the total registration cost dynamically based on selected sessions.
- Allow users to add multiple attendees with proper validation for each entry.
- Prevent duplicate registrations using the same email ID.
- Display a confirmation dialog summarizing all validated details before final submission.
- Show the final registration details after successful submission.

## Code

### index.html

```html
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Event Registration Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" href="./assets/css/style.css" />
  </head>

  <body>
    <div class="container">
      <h2>Event Registration Form</h2>

      <form id="registrationForm">
        <!-- Attendee Info -->
        <label>Full Name</label>
        <input type="text" id="name" required />

        <label>Email</label>
        <input type="email" id="email" required />

        <label>Age</label>
        <input type="number" id="age" min="1" required />

        <!-- Sessions -->
        <label>Select Sessions</label>
        <div class="sessions">
          <label>
            <input
              type="checkbox"
              data-cost="500"
              data-age="18"
              data-time="10-12"
            />
            Technical Workshop (10AM–12PM, ₹500, 18+)
          </label>

          <label>
            <input type="checkbox" data-cost="400" data-time="10-12" />
            Design Seminar (10AM–12PM, ₹400)
          </label>

          <label>
            <input type="checkbox" data-cost="300" data-time="14-16" />
            Marketing Talk (2PM–4PM, ₹300)
          </label>
        </div>

        <!-- Special Requirements -->
        <label>Special Requirements</label>
        <textarea rows="3" placeholder="Food, accessibility, etc."></textarea>

        <div class="total">Total Cost: ₹<span id="totalCost">0</span></div>

        <button type="button" class="add-btn" onclick="addAttendee()">
          Add Attendee
        </button>

        <button type="submit" class="submit-btn">Submit Registration</button>

        <p class="note">
          * Time conflicts and duplicate emails are automatically prevented.
        </p>
      </form>

      <div id="output" class="output" style="display: none">
        <h3>Registration Details</h3>
        <div id="outputContent"></div>
      </div>
    </div>

    <script src="./assets/js/main.js"></script>
  </body>
</html>
```

### style.css

```css
body {
  font-family: "Segoe UI", sans-serif;
  background: linear-gradient(135deg, #0d6efd, #6f42c1);
  margin: 0;
  padding: 20px;
}

.container {
  max-width: 750px;
  margin: auto;
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
}

h2 {
  text-align: center;
  color: #0d6efd;
  margin-bottom: 20px;
}

label {
  font-weight: 600;
  margin-top: 12px;
  display: block;
}

input,
textarea {
  width: 100%;
  padding: 12px;
  margin-top: 6px;
  border-radius: 6px;
  border: 1px solid #ccc;
  font-size: 15px;
}

input:valid {
  border-color: green;
}

input:invalid {
  border-color: red;
}

.sessions {
  background: #f8f9fa;
  padding: 15px;
  border-radius: 8px;
  margin-top: 10px;
}

.sessions label {
  font-weight: normal;
  margin-bottom: 8px;
  display: block;
}

.total {
  margin-top: 15px;
  font-size: 18px;
  font-weight: bold;
  color: #198754;
}

button {
  width: 100%;
  padding: 12px;
  font-size: 16px;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  margin-top: 12px;
}

.add-btn {
  background: #198754;
  color: white;
}

.submit-btn {
  background: #0d6efd;
  color: white;
}

button:hover {
  opacity: 0.9;
}

.note {
  font-size: 13px;
  color: #6c757d;
  margin-top: 10px;
}

.output {
  margin-top: 30px;
  padding: 20px;
  background: #f1f5ff;
  border-left: 5px solid #0d6efd;
  border-radius: 8px;
}

.output h3 {
  color: #0d6efd;
}

.output ul {
  padding-left: 20px;
}
```

### main.js

```javascript
let attendees = [];
let registeredEmails = [];

const form = document.getElementById("registrationForm");
const totalCostSpan = document.getElementById("totalCost");
const sessionCheckboxes = document.querySelectorAll(".sessions input");

sessionCheckboxes.forEach((cb) => cb.addEventListener("change", calculateCost));

function calculateCost() {
  let total = 0;
  sessionCheckboxes.forEach((cb) => {
    if (cb.checked) {
      total += parseInt(cb.dataset.cost);
    }
  });
  totalCostSpan.textContent = total;
}

function hasTimeConflict() {
  let times = [];
  for (let cb of sessionCheckboxes) {
    if (cb.checked) {
      if (times.includes(cb.dataset.time)) {
        return true;
      }
      times.push(cb.dataset.time);
    }
  }
  return false;
}

function addAttendee() {
  const name = document.getElementById("name").value.trim();
  const email = document.getElementById("email").value.trim();
  const age = parseInt(document.getElementById("age").value);

  if (!name || !email || !age) {
    alert("Please fill all attendee details.");
    return;
  }

  if (registeredEmails.includes(email)) {
    alert("Duplicate email registration is not allowed.");
    return;
  }

  let selectedSessions = [];
  let cost = 0;
  let times = [];

  for (let cb of sessionCheckboxes) {
    if (cb.checked) {
      // Age validation
      if (cb.dataset.age && age < cb.dataset.age) {
        alert("Age requirement not met for selected session.");
        return;
      }

      // Time conflict check
      if (times.includes(cb.dataset.time)) {
        alert("Selected sessions have scheduling conflicts.");
        return;
      }

      times.push(cb.dataset.time);
      cost += parseInt(cb.dataset.cost);

      selectedSessions.push(cb.parentElement.innerText.trim());
    }
  }

  if (selectedSessions.length === 0) {
    alert("Please select at least one session.");
    return;
  }

  attendees.push({
    name,
    email,
    age,
    sessions: selectedSessions,
    cost,
  });

  registeredEmails.push(email);

  alert("Attendee added successfully!");

  form.reset();
  totalCostSpan.textContent = "0";
}

function showDataOnPage() {
  const output = document.getElementById("output");
  const outputContent = document.getElementById("outputContent");

  let html = "";

  attendees.forEach((a, i) => {
    html += `
      <div style="margin-bottom:15px">
        <h4>Attendee ${i + 1}</h4>
        <p><strong>Name:</strong> ${a.name}</p>
        <p><strong>Email:</strong> ${a.email}</p>
        <p><strong>Age:</strong> ${a.age}</p>
        <p><strong>Sessions:</strong></p>
        <ul>
          ${a.sessions.map((s) => `<li>${s}</li>`).join("")}
        </ul>
        <p><strong>Cost:</strong> ₹${a.cost}</p>
      </div>
      <hr />
    `;
  });

  const total = attendees.reduce((sum, a) => sum + a.cost, 0);
  html += `<h3>Total Amount Paid: ₹${total}</h3>`;

  outputContent.innerHTML = html;
  output.style.display = "block";
}

form.addEventListener("submit", function (e) {
  e.preventDefault();

  if (attendees.length === 0) {
    alert("Please add at least one attendee.");
    return;
  }

  let summary = "Registration Summary:\n\n";

  attendees.forEach((a, i) => {
    summary += `${i + 1}. ${a.name} | ${a.email} | Age: ${a.age}\n`;
  });

  summary += `\nTotal Attendees: ${attendees.length}`;
  summary += `\nTotal Amount: ₹${totalCostSpan.textContent}`;

  if (confirm(summary)) {
    showDataOnPage();
    alert("Registration Successful!");
    form.reset();
    totalCostSpan.textContent = "0";
    attendees = [];
    registeredEmails = [];
  }
});
```

## Learning Outcome

- Gained knowledge of creating interactive web forms using DHTML.
- Learned to perform client-side validation using JavaScript.
- Understood how to handle dynamic data without page reload.
- Learned to prevent logical errors such as duplicate entries and scheduling conflicts.
- Improved skills in designing user-friendly and responsive web interfaces.
