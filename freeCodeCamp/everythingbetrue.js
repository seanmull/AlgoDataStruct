/*Check if the predicate (second argument) is truthy on 
all elements of a collection (first argument).
Remember, you can access object properties 
through either dot notation or [] notation.*/

function truthCheck(collection, pre) {
	var arr = collection.filter(function(item){
		return item[pre];
	});
	return (collection.length == arr.length ? true : false);
}

console.log(truthCheck([{"user": "Tinky-Winky", "sex": "male"}, 
	{"user": "Dipsy"}, {"user": "Laa-Laa", "sex": "female"}, 
	{"user": "Po", "sex": "female"}], "sex"));
