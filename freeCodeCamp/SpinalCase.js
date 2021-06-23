//Convert a string to spinal case. Spinal case is all-lowercase-words-joined-by-dashes.

function spinalCase(str) {
	var arr = [];
	str.split("").forEach(function(char){
		if(/[^[A-Za-z]/.test(char))
			return arr.push("-");
		else if(/[A-Z]/.test(char))
			return arr.push(" " + char);
		else
			return arr.push(char);
	});
	return arr.join("")
	          .replace(/[" "]/g, "")
	          .toLowerCase();
}




console.log(spinalCase("The_Andy_Griffith_Show"));
//console.log(spinalCase("thisIsSpinalTap"));
