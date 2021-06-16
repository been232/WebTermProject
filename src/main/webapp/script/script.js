var items = document.querySelectorAll(".item-heading");
for (var i = 0; i < items.length; i++) {
    items[i].addEventListener("click", function (e) {
        if(e.target.classList.contains("active")) {
            e.target.classList.remove("active");
        } else {
            for (var x = 0; x < items.length; x++) {
                items[x].classList.remove("active");
            }
            e.target.classList.add("active");

        }
    });
}