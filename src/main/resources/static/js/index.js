$(function () {
    getCurrentUserInfo();
});

function getCurrentUserInfo() {
    ztool.net.asyncAjaxData('get', '/user/getCurrentUser', null, function (res) {
        if (res.status) {
            console.log(res.data)
            $("#username").html(res.data.username);
        }
    });
}