$(function () {
    $("#login").click(function () {
        check_login();
        return false;
    });
});

function check_login() {
    let username = $("#username").val();
    let password = $("#password").val();
    ztool.net.asyncAjaxData('post', '/login1', {
        username: username,
        password: password
    }, function (res) {
        if (res.status){
            window.location = ztool.util.net.getURL() + "/index.html";
        } else {
            $("#login_form").removeClass('shake_effect');
            setTimeout(function () {
                $("#login_form").addClass('shake_effect')
            }, 1);
        }
    });
}


