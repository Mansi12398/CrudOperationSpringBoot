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
  <form action="verifyLogin" method="post">
    <h1>Login</h1>
    <div class="content">
      <div class="input-field">
        <input type="text" placeholder="username" autocomplete="nope" name="username" required="required">
      </div>
      <div class="input-field">
        <input type="password" placeholder="Password" autocomplete="new-password" name="password" required="required">
      </div>
    </div>
    <div class="action">
   
      <button>Sign in</button>
    </div>
  </form>

  <h3 style="color:red;text-align: center;">${errorMsg}</h3>
</div>
<!-- partial -->
  <script  src="js/script.js"></script>

</body>
</html>
