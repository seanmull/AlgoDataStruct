//Find the smallest common multiple of the provided parameters that can be evenly divided by both, as well as by all sequential numbers in the range between these parameters.

//The range will be an array of two numbers that will not necessarily be in numerical order.

//e.g. for 1 and 3 - find the smallest common multiple of both 1 and 3 that is evenly divisible by all numbers between 1 and 3.


function smallestCommons(arr) {
  var rangeArr = getRange(arr);
  return grandlcd(rangeArr, lcd(rangeArr[0],rangeArr[1]), 
                  rangeArr[0], rangeArr[1], 2);
}


function grandlcd(arr, lcd1, a, b, index){ 
  if(index != arr.length){                                             
    b = arr[index]; 
    a = lcd1;       
    lcd2 = lcd(a,b); 
    grandlcd(arr, lcd2, a, b, index+1); 
    return lcd2;                              
  }
}
  
function lcd(a, b){
  return (a * b)/gcd(a,b);
}

function gcd(a, b){ //euclids algorithm
  if(b == 0)
    return a;
  else
    return gcd(b,a%b);
}

function getRange(arr){
  arr.sort();
  var newArr = [];
  for(var i = arr[0]; i <= arr[1]; i++){
    newArr.push(i);
  }
  return newArr;
}

smallestCommons([1,3]);
