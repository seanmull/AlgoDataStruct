//Flatten a nested array. You must account for varying levels of nesting.


function steamrollArray(arr) {
  // I'm a steamroller, baby
  return steamroll(arr,[]);
}

function steamroll(arr,steamarr){ 
  if(arr.length == 0){ //base case
    return steamarr;
  }else if(arr.length == 1 && Array.isArray(arr[0])){ //recursive case 1
    arr = arr[0];
    return steamroll(arr,steamarr);
  }else{
    if(Array.isArray(arr[0])){ //recursive case 2
      var modArr = [];
      modArr[0] = arr[0][0];
      arr.shift();
      return steamroll(modArr.concat(arr),steamarr);
    }else{                     //recursive case 3
      if(arr[0] != null)
        steamarr.push(arr[0]);
      arr.shift();
      return steamroll(arr,steamarr);
    }
  }
}

steamrollArray([1, [], [3, [[4]]]]);
