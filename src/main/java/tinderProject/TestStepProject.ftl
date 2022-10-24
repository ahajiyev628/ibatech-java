<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tinder</title>
</head>
<body>
<p>Name:${name}</p>
<img src=${photo} width="400" height="300">
</br>
</br>
<#--<input type="submit" name="yes" value="like">-->
<#--<input type="submit" name="no" value="dislike">-->
<form method="post"  action="http://localhost:8080/peoplelistt" id="form">
    <button type="submit" id="yes" name = "Like">Like</button>
</form>

<form method="get" action="http://localhost:8080/peoplelistt" id="form" >
    <button type="submit" id="no" name ="Dislike">Dislike</button>
</form>

</body>
</html>
