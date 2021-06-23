/*Create a function that sums two arguments together. If only one argument is provided, 
then return a function that expects one argument and returns the sum.
For example, addTogether(2, 3) should return 5, and addTogether(2) should return a function.
Calling this returned function with a single argument will then return the sum:
var sumTwoAnd = addTogether(2);
sumTwoAnd(3) returns 5.
If either argument isn't a valid number, return undefined.*/

function addTogether() {
	if((!Number.isInteger(arguments[0]) ||
	    !Number.isInteger(arguments[1])) &&
	    arguments.length == 2)
		return undefined;
	else if(arguments.length == 2)
		return arguments[0] + arguments[1];
	else if(!Number.isInteger(arguments[0]))
		return undefined;
	var x = arguments[0];
	return function add(){
		if(!Number.isInteger(arguments[0]))
			return undefined;
		return x + arguments[0];
	};

}


console.log(addTogether(2, 3)) // case 1
console.log(addTogether(2)(3)); // case 2
console.log(addTogether(2, "3")); // case 3
console.log(addTogether(2)([3])); // case 4
console.log(addTogether("http://bit.ly/IqT6zt")) // case 5
