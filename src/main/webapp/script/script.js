const x = window.matchMedia("screen and (min-width: 1025px)");
let f = document.querySelectorAll("form");
window.onload = function () {
    if(x.matches) {
        changeToIframe4(f);
    } else {
        changeToIframe2(f);
    }
}
x.addEventListener("change",() => {
    if (x.matches) {
        changeToIframe4(f);
    } else {
        changeToIframe2(f);
    }
})

function changeToIframe4(fo) {
    for(var i = 0; i < fo.length; i++) {
        fo.item(i).setAttribute("target", "iframe4");
    }
}function changeToIframe2(fo) {
    for(var i = 0; i < fo.length; i++) {
        fo.item(i).setAttribute("target", "iframe2");
    }
}
let items = document.querySelectorAll(".button");
for (var i = 0; i < items.length; i++) {
    items[i].addEventListener("click", function (e) {
        if(e.target.parentElement.parentElement.parentElement.getAttribute("target") === "iframe4") {
            let target = document.getElementById("hidden-frame").classList;
            if (target.contains("active")) {
                target.remove("active");
            } else {
                target.remove("active");
                target.add("active");
            }
        } else {
            if (e.target.classList.contains("active")) {
                e.target.classList.remove("active");
            } else {
                for (var x = 0; x < items.length; x++) {
                    items[x].classList.remove("active");
                }
                e.target.classList.add("active");
            }
        }
    });
}

function isLogin(userID) {
    if(userID != null) return true;
    else {
        alert("로그인이 필요합니다.");
    }
}

function openNav() {
    document.getElementById("sideNav").style.width = "250px";
}

function closeNav() {
    document.getElementById("sideNav").style.width = "0px";
}