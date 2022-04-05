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
  <form action="saveStudent" method="post">
    <h1>Add Student</h1>
    <div class="content">
      <div class="input-field">
        <input type="text" placeholder="FirstName" autocomplete="nope" name="fname" required="required">
      </div>
      <div class="input-field">
        <input type="text" placeholder="LastName" autocomplete="nope" name="lname" required="required">
      </div>
      <div class="input-field">
        <input type="text" placeholder="UserName" autocomplete="nope" name="uname" required="required">
      </div>
       <div class="input-field">
        <input type="password" placeholder="Password" autocomplete="nope" name="pwd" required="required">
      </div>
      <div class="input-field">
        <input type="number" placeholder="Maths Mark" autocomplete="nope" name="maths" required="required">
      </div>
      <div class="input-field">
        <input type="number" placeholder="English Mark" autocomplete="nope" name="english" required="required">
      </div>
        <div class="input-field">
        <input type="number" placeholder="Gujarati Mark" autocomplete="nope" name="gujarati" required="required">
      </div>
    </div>
    <div class="action">
   
      <button>Add Student</button>
    </div>
  </form>

</div>
<!-- partial -->
  <script  src="js/script.js"></script>

</body>
</html>
