/*Create a function that takes two or more arrays and 
returns an array of the symmetric difference (△ or ⊕) of the provided arrays.
Given two sets (for example set A = {1, 2, 3} and set B = {2, 3, 4}), the mathematical 
term "symmetric difference" of two sets is the set of elements which are in either 
of the two sets, but not in both (A △ B = C = {1, 4}). For every additional 
symmetric difference you take (say on a set D = {2, 3}), you should get the set
 with elements which are in either of the two the sets but not both (C △ D = {1, 4} △ {2, 3} = {1, 2, 3, 4}).*/


function sym(args) {
	var arr = Array.from(arguments);
	return removeRepeats(arr).reduce(function(a,b){
		return a.filter(function(element){return b.indexOf(element) == -1}).concat
		      (b.filter(function(element){return a.indexOf(element) == -1;
		}));
	});
}

function removeRepeats(arrOfArr){
var newArr = [];
	arrOfArr.forEach(function(arr){
		var uniq = arr.reduce(function(a,b){
    	if (a.indexOf(b) == -1) a.push(b);
    	return a;
  		},[]);
		newArr.push(uniq);
	});
	return newArr;
}

console.log(sym([1, 1, 2, 5], [2, 2, 3, 5], [3, 4, 5, 5]));
