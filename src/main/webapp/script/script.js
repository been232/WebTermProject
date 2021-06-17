const x = window.matchMedia("screen and (min-width: 1025px)");
let f = document.querySelectorAll("form");
window.onload = function () {
    if (x.matches) {
        changeToIframe4(f);
    } else {
        changeToIframe(f);
    }
}
x.addEventListener("change", () => {
    if (x.matches) {
        changeToIframe4(f);
    } else {
        changeToIframe(f);
    }
})

function changeToIframe4(fo) {
    for (var i = 0; i < fo.length; i++) {
        let item = fo.item(i);
        if (!item.classList.contains("formMan"))
            item.setAttribute("target", "iframe4");
        else {
            item.setAttribute("target", "iframe7");
        }
    }
}

function changeToIframe(fo) {
    for (var i = 0; i < fo.length; i++) {
        let item = fo.item(i);
        if (!item.classList.contains("formMan"))
            item.setAttribute("target", "iframe" + (i + 1));
        else {
            item.setAttribute("target", "iframe" + (i + 2));
        }
    }
}

let items = document.querySelectorAll(".button");
for (var i = 0; i < items.length; i++) {
    items[i].addEventListener("click", function (e) {
        if (e.target.parentElement.parentElement.parentElement.getAttribute("target") === "iframe4") {
            let target = document.getElementById("hidden-frame").classList;
            if (target.contains("active")) {
                target.remove("active");
            } else {
                target.remove("active");
                target.add("active");
            }
        } else if (e.target.parentElement.parentElement.parentElement.getAttribute("target") === "iframe7") {
            let target = document.getElementById("hidden-frame1").classList;
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
    if (userID != null) return true;
    else {
        alert("로그인이 필요합니다.")
        return false;
    }
}