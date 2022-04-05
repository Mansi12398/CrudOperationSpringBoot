<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Simple Login Form Example</title>
  <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rubik:400,700'>
  <link rel="stylesheet" href="css/style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="login-form">
  <form action="updateSaveStudent" method="post">
    <h1>Update Student</h1>
    <div class="content">
    	<input type="hidden" value="${stud.studentId}" name="id"/>
      <div class="input-field">
        <input type="text" value="${stud.firstName}" placeholder="FirstName" autocomplete="nope" name="fname" required="required">
      </div>
      <div class="input-field">
        <input type="text" value="${stud.lastName}" placeholder="LastName" autocomplete="nope" name="lname" required="required">
      </div>
      <div class="input-field">
        <input type="text" value="${stud.userName}" placeholder="UserName" autocomplete="nope" name="uname" required="required">
      </div>
       <div class="input-field">
        <input type="password" value="${stud.password}" placeholder="Password" autocomplete="nope" name="pwd" required="required">
      </div>
      <div class="input-field">
        <input type="number" value="${stud.maths}" placeholder="Maths Mark" autocomplete="nope" name="maths" required="required">
      </div>
      <div class="input-field">
        <input type="number" value="${stud.english}" placeholder="English Mark" autocomplete="nope" name="english" required="required">
      </div>
        <div class="input-field">
        <input type="number" value="${stud.gujarati}" placeholder="Gujarati Mark" autocomplete="nope" name="gujarati" required="required">
      </div>
    </div>
    <div class="action">
   
      <button>Update Student</button>
    </div>
  </form>

</div>
<!-- partial -->
  <script  src="js/script.js"></script>

</body>
</html>
