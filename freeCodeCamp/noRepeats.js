/*Return the number of total permutations of the provided string 
that don't have repeated consecutive letters. Assume that all 
characters in the provided string are each unique.
For example, aab should return 2 because it has 
6 total permutations (aab, aab, aba, aba, baa, baa), 
but only 2 of them (aba and aba) don't 
have the same letter (in this case a) repeating.*/

function permAlone(s){
	return permuteHelper(s,"",[]).length;
}

function permuteHelper(s, chosen, store){
	if(s == ""){
		if(!/(.)\1/.test(chosen))
			store.push(chosen);
	}else{ 
		for(var i = 0; i < s.length; i++){
			var c = s.charAt(i);
			chosen += c;
			s = s.replace(c, "");
			permuteHelper(s, chosen, store);
			s = [s.slice(0, i), c, s.slice(i)].join('');
			chosen = chosen.substr(0, chosen.length - 1);
		}
	}
	return store;
}
console.log(permAlone('acc'));
