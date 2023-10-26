// Header Top guide Function
window.addEventListener("scroll", function () {
  var lnb = document.getElementById("lnb");
  var gnb = document.getElementById("gnb");
	var header = document.getElementById("header");
  var scrollPosition = window.pageYOffset;


  if (scrollPosition >= 100) {
    gnb.style.display = "block";
		lnb.style.display = "none";
		header.style.opacity = "0.8";
  } else {
    gnb.style.display = "block";
		lnb.style.display = "flex";
		header.style.opacity = "1";
  }
});

