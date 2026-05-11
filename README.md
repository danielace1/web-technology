## Web Technology Lab

This repository contains various projects and experiments related to web technologies, including HTML, CSS, JavaScript, and modern web frameworks. The goal is to explore new techniques, share knowledge, and contribute to the web development community.

---

## Experiments

### Ex-1: Image Mapping Using HTML

| Sl. No | Experiment Title                       | View                | Live                                                            |
| ------ | -------------------------------------- | ------------------- | --------------------------------------------------------------- |
| 1.3    | Solar System – Image Map               | [View](./ex-1/1.3/) | [Live](https://cs23students.github.io/web-technology/ex-1/1.3/) |
| 1.4    | Computer System Components – Image Map | [View](./ex-1/1.4/) | [Live](https://cs23students.github.io/web-technology/ex-1/1.4/) |
| 1.5    | College Layout – Image Map             | [View](./ex-1/1.5/) | [Live](https://cs23students.github.io/web-technology/ex-1/1.5/) |

---

### Ex-2: Creating Web Page with All Types of Cascading Style Sheets

| Sl. No | Experiment Title                | View                | Live                                                            |
| ------ | ------------------------------- | ------------------- | --------------------------------------------------------------- |
| 2.3    | Responsive Restaurant Web Page  | [View](./ex-2/2.3/) | [Live](https://cs23students.github.io/web-technology/ex-2/2.3/) |
| 2.4    | Responsive Travel Blog Web Page | [View](./ex-2/2.4/) | [Live](https://cs23students.github.io/web-technology/ex-2/2.4/) |
| 2.5    | Portfolio Website               | [View](./ex-2/2.5/) | [Live](https://cs23students.github.io/web-technology/ex-2/2.5/) |

---

### Ex-3: Client Side Scripts for Validating Web Form Controls using DHTML

| Sl. No | Experiment Title                                   | View                | Live                                                            |
| ------ | -------------------------------------------------- | ------------------- | --------------------------------------------------------------- |
| 3.4    | Event Registration Form using DHTML and JavaScript | [View](./ex-3/3.4/) | [Live](https://cs23students.github.io/web-technology/ex-3/3.4/) |

## commands to compile jsp file with servlet-api.jar (5th, 6th experiment)

- Create HTML/JSP and Servlet files.
- Place servlet .java file inside: `WEB-INF/classes`
- Compile servlet using:

```bash
  javac -cp "..\..\..\..\lib\servlet-api.jar" filename.java
```

- Start Apache Tomcat server using: `startup.bat`
- Open browser and run:
- http://localhost:8080/AppName

## 6th experiment

- Install MySQL and MySQL Workbench.
- Create database and tables using SQL queries.
- Store JSP files inside Tomcat webapps/AppName folder.
- Add MySQL JDBC driver (mysql-connector.jar) inside:
  `apache-tomcat/lib`
- Start Tomcat server.
- Open browser and run:
  http://localhost:8080/AppName/login.jsp
- JSP pages automatically compile and connect with database using JDBC.

## for 7th experiment

- Create:
  students.xml
  students.dtd
  students.xsl
- Store all files in the same folder.
- Open folder in VS Code.
- Install Live Server extension.
- Right click students.xml → Open with Live Server
- Browser displays formatted student details using XSL stylesheet.
