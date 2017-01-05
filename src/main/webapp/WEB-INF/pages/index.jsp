<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>File Upload Example in JSP and Servlet - Java web application</title>
</head>

<body>
<div>

    <h3> Choose .jar to Upload and Obfuscate in Server </h3>
    <h4> Note* It needs to take a long time to obfuscate, Plz wait in patient</h4>

    <form action="upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <input type="submit" value="upload"/>
    </form>
</div>

<script src="https://www.gstatic.com/firebasejs/3.6.4/firebase.js"></script>
<script>
  // Initialize Firebase
  var config = {
    apiKey: "AIzaSyAfooiQhsnLujyZejthyW-N46LAeibUq1s",
    authDomain: "seniorproject-37440.firebaseapp.com",
    databaseURL: "https://seniorproject-37440.firebaseio.com",
    storageBucket: "seniorproject-37440.appspot.com",
    messagingSenderId: "327192954445"
  };
  firebase.initializeApp(config);
</script>


</body>
</html>