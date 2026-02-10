const eventData = {
  technical: [
    {
      name: "Technical Workshop",
      cost: 500,
      time: "10:00 AM-12:00 PM",
      age: 18,
    },
    { name: "Design Seminar", cost: 400, time: "10:00 AM-12:00 PM" },
    { name: "Marketing Talk", cost: 300, time: "2:00 PM-4:00 PM" },
  ],
  cultural: [
    { name: "Dance Program", cost: 200, time: "10:00 AM-12:00 PM" },
    { name: "Music Show", cost: 300, time: "2:00 PM-4:00 PM" },
  ],
  sports: [
    { name: "Cricket Match", cost: 400, time: "10:00 AM-1:00 PM", age: 16 },
    { name: "Badminton", cost: 250, time: "2:00 PM-4:00 PM" },
  ],
};

function loadSessions() {
  const event = document.getElementById("eventSelect").value;
  const container = document.getElementById("sessionsContainer");

  container.innerHTML = "";
  totalCostSpan.textContent = "0";

  if (!event) return;

  eventData[event].forEach((s) => {
    container.innerHTML += `
      <label>
        <input type="checkbox"
          data-cost="${s.cost}"
          data-time="${s.time}"
          data-age="${s.age || ""}">
        ${s.name} (${s.time}, ₹${s.cost}${s.age ? ", " + s.age + "+" : ""})
      </label>
    `;
  });

  document
    .querySelectorAll("#sessionsContainer input")
    .forEach((cb) => cb.addEventListener("change", calculateCost));
}

let attendees = [];
let registeredEmails = [];

const form = document.getElementById("registrationForm");
const totalCostSpan = document.getElementById("totalCost");

function getSessionCheckboxes() {
  return document.querySelectorAll("#sessionsContainer input");
}

function calculateCost() {
  let total = 0;
  getSessionCheckboxes().forEach((cb) => {
    if (cb.checked) total += parseInt(cb.dataset.cost);
  });
  totalCostSpan.textContent = total;
}

function hasTimeConflict() {
  let times = [];
  for (let cb of getSessionCheckboxes()) {
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
  const event = document.getElementById("eventSelect").value;

  if (!name || !email || !age) {
    alert("Please fill all attendee details.");
    return;
  }

  if (!event) {
    alert("Please select an event.");
    return;
  }

  if (registeredEmails.includes(email)) {
    alert("Duplicate email registration is not allowed.");
    return;
  }

  let selectedSessions = [];
  let cost = 0;
  let times = [];

  for (let cb of getSessionCheckboxes()) {
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
    event,
    sessions: selectedSessions,
    cost,
  });

  showDataOnPage();

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
        <p><strong>Event:</strong> ${a.event}</p>
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
