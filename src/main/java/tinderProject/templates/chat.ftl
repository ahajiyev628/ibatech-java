<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Message</title>
</head>
<body>
                <table class="table-users table" border="0">
                    <tbody>
                    <#list data as msg>
                        <tr>
                            <td width="10">
                                <div class="avatar-img">
                                    <p>${msg.message}</p>
                                </div>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>

                <form method="post" id="form">
                    <input type="text" class="border-0" name="msg" placeholder=" Send message" />
                    <button type="submit" name="send" value="sent">Send</button>
                </form>
</body>
</html>