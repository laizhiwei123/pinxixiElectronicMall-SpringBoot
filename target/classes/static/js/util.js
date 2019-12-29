<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d57567eb7f790b3d83549bd0d34f30e23631d97d
function ajax(json) {
    var xhr;
    if (window.XMLHttpRequest) {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }

    if (json.type === 'get') {
        xhr.open('GET', json.url + '?' + JSON.stringify(json.data), json.async);
        xhr.send();
    } else if (json.type === 'post') {
        xhr.open('POST', json.url, json.async);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(json.data));
    }

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status >= 200 && xhr.status < 300 || xhr.status == 304) {
                json.success(JSON.parse(xhr.responseText));
            } else {
                json.error && json.error();
            }
        }
    };

    function JsonToString(json) {
        var arr = [];
        for (let i in json) {
            arr.push(i + '=' + json[i]);
        }

        return arr.join('&');
    }
}
function redirectConfirm(content, url) {
    console.log(url);
    var popupWindow =  confirm(content);

    if (popupWindow == true) {
        location.href = url;
    }
<<<<<<< HEAD
=======
function ajax(json) {
    var xhr;
    if (window.XMLHttpRequest) {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    }

    if (json.type === 'get') {
        xhr.open('GET', json.url + '?' + JSON.stringify(json.data), json.async);
        xhr.send();
    } else if (json.type === 'post') {
        xhr.open('POST', json.url, json.async);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(json.data));
    }

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status >= 200 && xhr.status < 300 || xhr.status == 304) {
                json.success(JSON.parse(xhr.responseText));
            } else {
                json.error && json.error();
            }
        }
    };

    function JsonToString(json) {
        var arr = [];
        for (let i in json) {
            arr.push(i + '=' + json[i]);
        }

        return arr.join('&');
    }
}
function redirectConfirm(content, url) {
    console.log(url);
    var popupWindow =  confirm(content);

    if (popupWindow == true) {
        location.href = url;
    }
>>>>>>> pinxixi
=======
>>>>>>> d57567eb7f790b3d83549bd0d34f30e23631d97d
}