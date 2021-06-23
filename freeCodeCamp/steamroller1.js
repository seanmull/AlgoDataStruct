//Flatten a nested array. You must account for varying levels of nesting.

function steamrollArray(arr) {
  return arr.reduce(function(a,b){  
  		console.log("a is: " + a);
  		console.log("b is: " + b);  
  		return a.concat(Array.isArray(b) ? steamrollArray(b) : b );
  },[]);
}

//console.log(steamrollArray([[0, 1], [2, 3], [4, 5]]));
//console.log(steamrollArray([1, [], [3, [[4]]]]));
console.log(steamrollArray([[[[4]]]]));

/*
a is: 
b is: 4
a is: 
b is: 4
a is: 
b is: 4
a is: 
b is: 4
[ 4 ]
*/
