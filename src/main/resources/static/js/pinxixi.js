function verificationUserName() {
    var userNameValue = document.getElementById('userName').value;
    if (userNameValue.length <= 0) {
        document.getElementById('userNameErrerTips').innerHTML = '<snap style="padding-left: 0.4rem;padding-right: 0.4rem;background: #e3554c; border-radius: 1rem;color: #FFFAFA">!</snap>' + '昵称不能为空';
        return false;
    } else {
        document.getElementById('userNameErrerTips').innerText = "";
        return true;
    }
}

function verificationCodeFormat() {
    var verificationCodeValue = document.getElementById('verificationCode').value;
    console.log("dada");
    if (verificationCodeValue.length <= 0 || verificationCodeValue.length > 6) {
        document.getElementById('verificationCodeErrerTips').innerHTML = '<snap style="padding-left: 0.4rem;padding-right: 0.4rem;background: #e3554c; border-radius: 1rem;color: #FFFAFA">!</snap>' + '格式错误';
        return false;
    } else {
        document.getElementById('verificationCodeErrerTips').innerHTML = '';
        return true;

    }
}

function verificationEmail() {
    var emailValue = document.getElementById('email').value;
    //验证有所漏洞
    var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if (!myreg.test(emailValue)) {
        document.getElementById('emailInputErrerTips').innerHTML = '<snap style="padding-left: 0.4rem;padding-right: 0.4rem;background: #e3554c; border-radius: 1rem;color: #FFFAFA">!</snap>' + '格式错误';
        return false;
    } else {
        document.getElementById('emailInputErrerTips').innerHTML = '';
        return true;
    }
}

function verificationPassword() {
    var passwordInputValue = document.getElementById('userPassword').value;
    var patrn = /^(?![A-Za-z0-9]+$)(?![a-z0-9\W]+$)(?![A-Za-z\W]+$)(?![A-Z0-9\W]+$)[a-zA-Z0-9\W]{8,}$/;
    if (!patrn.test(passwordInputValue)) {
        document.getElementById('passwordInputErrerTips').innerHTML = '<snap style="padding-left: 0.4rem;padding-right: 0.4rem;background: #e3554c; border-radius: 1rem;color: #FFFAFA">!</snap>' + '格式错误';
        return false;
    } else {
        document.getElementById('passwordInputErrerTips').innerText = '';
        return true;
    }
}

function requestVerificationCode() {
    if (verificationEmail()) {
        var xhr;
        if (window.XMLHttpRequest) {
            // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject('Microsoft.XMLHTTP');
        }

        xhr.open('POST', '/api/v1/GenerateVerificationCode', true);
        xhr.setRequestHeader("content-type", "application/json");
        xhr.onreadystatechange = function () {
            console.log("responseText" + xhr.readyState + "xhr.status" + xhr.status);
            if (xhr.readyState == 4 && xhr.status == 200) {
                let statusCode = JSON.parse(xhr.responseText).statusCode;
                console.log("xhr.responseText: " + xhr.responseText);
                if (statusCode == 0) {
                    //代表资源已经存在，后端接口返回的statusCode只会是0， 100， 200 ，0代表邮箱格式错误，200代表成功，201代表邮箱已存在，100代表邮件发送出现异常
                    alert("请输入正确的有邮箱地址");
                } else if (statusCode == 201) {
                    redirectConfirm("邮箱已经存在，是否跳转到登录页面", "/login");
                } else if (statusCode == 100) {
                    alert("服务器异常，请联系网站管理员");
                }
            } else if (xhr.readyState == 4 && xhr.status != 200) {
                //如果xhr.status 不等于200证明资源或者网络有问题
                alert("请检查网络是否连通后,点击重新获取,若还不行请联系系统管理员！！!");
            }
        };
        var email = document.getElementById('email').value;
        console.log(email + "email");
        var requestData = {'email': email};
        requestData = JSON.stringify(requestData);
        console.log(requestData);
        xhr.send(requestData);
        getVerificationCodeCountdown();
    }
}

function getVerificationCodeCountdown() {
    var InterValObj; //timer变量，控制时间
    var count = 60; //间隔函数，1秒执行
    var curCount;//当前剩余秒数

    curCount = count;
    document.getElementById("getVerificationCode").style.pointerEvents = "none"//设置按钮为禁用状态
    document.getElementById("getVerificationCode").innerText = curCount + "秒后重获";//更改按钮文字
    InterValObj = window.setInterval(function () {
        if (curCount == 0) {
            //超时重新获取验证码
            window.clearInterval(InterValObj);// 停止计时器
            document.getElementById("getVerificationCode").style.pointerEvents = "auto"//设置按钮为禁用状态
            document.getElementById("getVerificationCode").innerText = "重获验证码";
        } else {
            curCount--;
            document.getElementById("getVerificationCode").innerText = curCount + "秒后重获";
        }
    }, 1000); // 启动计时器timer处理函数，1秒执行一次
}

function formatHint(name) {
    switch (name) {
        case 'userName' : {
            document.getElementById('userNameErrerTips').innerHTML = '<p style="color: #cccccc">请输入昵称</p>';
            break;
        }
        case 'password' : {
            document.getElementById('passwordInputErrerTips').innerHTML = '<p style="color: #cccccc">密码格式:至少包含大写字母，小写字母，数字，且不少于8位</p>';
            break;
        }
        case 'email' : {
            document.getElementById('emailInputErrerTips').innerHTML = '<p style="color: #cccccc">邮箱格式:如xxxxxxx@qq.com</p>';
            break;
        }
        default: {
            document.getElementById('verificationCodeErrerTips').innerHTML = '<p style="color: #cccccc">验证码格式:应为6为数字</p>';
        }
    }
}

function register() {
    if (verificationUserName() && verificationPassword() && verificationEmail() && verificationCodeFormat()) {
        var xhr;
        var user;
        var name = document.getElementById('userName').value;
        var password = document.getElementById('userPassword').value;
        var email = document.getElementById('email').value;
        var verificationCode = document.getElementById('verificationCode').value;

        user = {"name": name, "password": password, "email": email, "verificationCode": verificationCode};

        ajax({
            url: '/api/v1/Register',
            type: 'post',
            data: user,
            async: 'true',
            success: function (responseData) {
                console.log(responseData.stateCode);
                switch (responseData.stateCode) {
                    case '0': {
                        //返回0代表前端发来的数据格式错误
                        alert("请按照要求重新输入");
                        break;
                    }
                    case '100': {
                        alert("验证码错误，请重新验证！！！");
                        break;
                    }
                    case '201': {
                        //验证邮箱是否注册过了，注册了返回201用户去登录
                        redirectConfirm("用户已存在是否跳转到登录页面？", '/login');
                        break;
                    }
                    case '301': {
                        alert("服务器异常，请联系网站管理员！！！");
                        break;
                    }
                    default : {
                        redirectConfirm("注册成功，是否跳转至登录页面？", "/login");
                    }
                }
            }
        })

    }
}