/*Return a new array that transforms the element's average altitude into their orbital periods.
The array will contain objects in the format {name: 'name', avgAlt: avgAlt}.
You can read about orbital periods on wikipedia.
The values should be rounded to the nearest whole number. The body being orbited is Earth.
The radius of the earth is 6367.4447 kilometers, and the GM value of earth is 398600.4418 km3s-2.*/

function orbitalPeriod(arr) {
  var GM = 398600.4418;
  var earthRadius = 6367.4447;
  for(var i = 0; i < arr.length; i++){
  	arr[i].orbitalPeriod = Math.round(2*Math.PI*Math.pow(Math.pow(arr[i].avgAlt + earthRadius, 3)/GM , 0.5));
  	//console.log(arr[i].orbitalPeriod); return;
  	delete arr[i].avgAlt;
  }
  return arr;
}

console.log(orbitalPeriod([{name: "iss", avgAlt: 413.6}, {name: "hubble", avgAlt: 556.7}, {name: "moon", avgAlt: 378632.553}]));
//console.log(orbitalPeriod([{name : "sputnik", avgAlt : 35873.5553}]));
