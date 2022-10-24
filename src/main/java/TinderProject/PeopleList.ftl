<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/favicon.ico">

    <title>People list</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-8 offset-2">
            <div class="panel panel-default user_panel">
                <div class="panel-heading">
                    <h3 class="panel-title">User List</h3>
                </div>
                <div class="panel-body">
                    <div class="table-container">

                        <table class="table-users table" border="0">
                            <tbody>
                            <#list data as user>
                                <tr>
                                    <td width="10">
                                        <div class="avatar-img">
                                            <img class="img-circle" width="400" height="300" src="${user.img}" />
                                        </div>

                                    </td>
                                    <td class="align-middle">
                                        ${user.username}
                                        <#--                                       Herbert Hoover-->
                                    </td>
                                    <td class="align-middle">
                                        Builder Sales Agent
                                    </td>
                                    <td  class="align-middle">
                                        Last Login:  0 <br><small class="text-muted">5 days ago</small>
                                        <#--                                       ${user.getDate()}-->
                                    </td>
                                    <td>

                                        <form method="get" >
                                            <input type="hidden" name="user_idd" value="${user.id}"/>
                                            <input type="submit" value="Send Message" class="btn-btn-outline-success">

                                        </form>
                                    </td>
                                </tr>

                            </#list>
                            <a href="/liked" class="btn btn-danger" style="color: white">Back</a>
                            <a href="/logout" class="btn btn-danger ml-2" style="color: white">Logout</a>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>