window.initMap = function() {
	const map = new google.maps.Map(document.getElementById("map"), {
		center: {lat: 37.555208, lng: 126.936915},
		zoom: 15,
	});
	
	const infoWindow = new google.maps.InfoWindow();
	
	new google.maps.Marker({
		position: {lat: 37.555208, lng: 126.936915},
		label: "A",
		name: "멍이랑 냥이랑 신촌역점",
		map: map
	});
	marker.addListener("click", () => {
		infoWindow.setContent(name);
		infoWIndow.open({
			anchor: marker,
			map: map
		});
	});
};