//Given a positive integer num, return the sum of all odd Fibonacci numbers that are less than or equal to num.

//The first two numbers in the Fibonacci sequence are 1 and 1. Every additional number in the sequence is the sum of the two previous numbers. The first six numbers of the Fibonacci sequence are 1, 1, 2, 3, 5 and 8.

//For example, sumFibs(10) should return 10 because all odd Fibonacci numbers less than 10 are 1, 1, 3, and 5.


function sumFibs1(num) { //changed to sumFibs1 solution using looping
  var arr = [];
  arr[0] = 1;
  arr[1] = 1;
  var index = 2;
  while((arr[index -1] + arr[index - 2]) <= num){
    arr[index] = arr[index -1] + arr[index - 2];
    index++;
  }  
  return addOdd(arr);
}

function addOdd(arr){
  var sum = 0;
  for(var i = 0; i < arr.length; i++){
    if(arr[i] % 2 != 0){
      sum += arr[i];
    }
  }
  return sum;
  
}

function sumFibs(num){
  var arr = [1,1];
  return addOdd(arrFib(arr, num, 1));
}

function arrFib(arr,num, index){
  if(arr[index] <= num){
    var sum = arr[index-1] + arr[index];
    arr.push(sum);
    return arrFib(arr, num, index+1);
  }
  arr.pop();
  return arr;
}

sumFibs(8);
//fact(3);
//sum(2);
