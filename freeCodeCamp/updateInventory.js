/*Compare and update the inventory stored in a 2D array against a second 2D array of a fresh delivery. 
Update the current existing inventory item quantities (in arr1). If an item cannot be found, 
add the new item and quantity into the inventory array. 
The returned inventory array should be in alphabetical order by item.*/


function updateInventory(arr1, arr2) {
    var updated = [];
    arr1.concat(arr2).forEach(function(item1){
        var inUpdated = false;
        updated.forEach(function(item2){
            if(item1[1] == item2[1]){
                item2[0] = item1[0] + item2[0];
                inUpdated = true;
            }
        });
        if(!inUpdated)
            updated.push(item1);
    });
    return updated.sort(function(a, b) {
           if(a[1] < b[1]) return -1;
           if(a[1] > b[1]) return 1;
           return 0;
    });
}

// Example inventory lists
var curInv = [
    [21, "Bowling Ball"],
    [2, "Dirty Sock"],
    [1, "Hair Pin"],
    [5, "Microphone"]
];

var newInv = [
    [2, "Hair Pin"],
    [3, "Half-Eaten Apple"],
    [67, "Bowling Ball"],
    [7, "Toothpaste"]
];

console.log(updateInventory(curInv, newInv));
