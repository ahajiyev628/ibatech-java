<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tinder</title>
</head>
<body>
<p>Name:${name}</p>
<img src=${photo} width="400" height="300">
<form method="get"  action="http://localhost:8080/messages" id="form">
    <button type="submit" name="message" value=${id}>Message</button>
</form>
</br>
</br>
</body>
</html>