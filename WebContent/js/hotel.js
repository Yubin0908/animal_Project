window.initMap = function() {
  const map = new google.maps.Map(document.getElementById("map"), {
    center: {lat: 37.555208, lng: 126.936915},
    zoom: 15,
    styles: [
      {
        "featureType": "road.highway",
        "stylers": [
          {
            "visibility": "simplified"
          },
          {
            "weight": 8
          }
        ]
      },
      {
        "featureType": "water",
        "stylers": [
          {
            "color": "#0011ff"
          }
        ]
      }
    ]
  });

 // const infoWindow = new google.maps.InfoWindow();

/*  const marker = new google.maps.Marker({
    position: {lat: 37.555208, lng: 126.936915},
    label: "A",
    name: "멍이랑 냥이랑 신촌역점",
    map: map
});*/

	const markers = [
		{
			position: {lat: 37.555208, lng: 126.936915},
			label: "A",
   	 	name: "멍이랑 냥이랑 신촌역점",
		},
		{
			position: {lat: 37.556831, lng: 126.941553},
			label: "B",
			name: "이젠아카데미 신촌캠퍼스"
		}
	];

  const infoWindows = [];

  markers.forEach(markerData => {
    const marker = new google.maps.Marker({
      position: markerData.position,
      label: markerData.label,
      map: map
    });

    const infoWindow = new google.maps.InfoWindow({
      content: markerData.name
    });

    marker.addListener("click", () => {
      infoWindows.forEach(infoWindow => infoWindow.close());
      infoWindow.open(map, marker);
    });

    infoWindows.push(infoWindow);
  });
};
