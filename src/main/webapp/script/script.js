const x = window.matchMedia("screen and (min-width: 1025px)");
let form = document.getElementById("form2");
window.onload = function () {
    if(x.matches) {
        form.setAttribute("target", "iframe4");
    } else {
        form.setAttribute("target", "iframe2");
    }
}
x.addEventListener("change",() => {
    if (x.matches) {
        form.setAttribute("target", "iframe4");

    } else {
        form.setAttribute("target", "iframe2");
    }
})

let items = document.querySelectorAll(".button");
for (var i = 0; i < items.length; i++) {
    items[i].addEventListener("click", function (e) {
        if(form.getAttribute("target") === "iframe4") {
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
    return userID != null;
}