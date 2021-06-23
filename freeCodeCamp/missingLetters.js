//Find the missing letter in the passed letter range and return it.
//If all letters are present in the range, return undefined.

function fearNotLetter(str) {
	var arr = str.split("");
	var last = arr[arr.length - 1];
	var missing = arr.reduce(function(a,b){
		return (b.charCodeAt(0) > a.charCodeAt(0) + 1) ?
		       String.fromCharCode(b.charCodeAt(0) - 1) :
		       b;
	});
	return (missing == last) ? undefined : missing;  
}




console.log(fearNotLetter("abce")); //d
console.log(fearNotLetter("bcd")); //undefined
