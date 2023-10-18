// Header Top guide Function
window.addEventListener("scroll", function () {
  var lnb = document.getElementById("lnb");
  var gnb = document.getElementById("gnb");
  var scrollPosition = window.pageYOffset;


  if (scrollPosition >= 100) {
    gnb.style.display = "block";
		lnb.style.display = "none";
  } else {
    gnb.style.display = "block";
		lnb.style.display = "flex";
  }
});

