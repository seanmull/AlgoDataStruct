/*Design a cash register drawer function checkCashRegister() 
that accepts purchase price as the first argument (price), 
payment as the second argument (cash), and cash-in-drawer (cid) as the third argument.
cid is a 2D array listing available currency.
Return the string "Insufficient Funds" if cash-in-drawer is less than the change due. 
Return the string "Closed" if cash-in-drawer is equal to the change due.
Otherwise, return change in coin and bills, sorted in highest to lowest order.*/

var values = [["PENNY", 0.01], ["NICKEL", 0.05], ["DIME", 0.10], ["QUARTER", 0.25], 
	["ONE", 1.00], ["FIVE", 5.00], ["TEN", 10.00], ["TWENTY", 20.00], ["ONE HUNDRED", 100.00]];

function checkCashRegister(price, cash, cid) {
  var totalCash = getTotalCash(cid);
  var change = round(cash - price, 2);
  if (change == totalCash) 
  	return "Closed";
  var changeArr = [];
  for(var i = cid.length - 1; i >= 0; i--){
  	var tmp = [];
  	if(change >= values[i][1]){
  		var value = change - (change % values[i][1]);
  		if(value > cid[i][1]) // check if there is enough change
  			value = cid[i][1];
  		tmp[0] = values[i][0]; tmp[1] = value;
  		changeArr.push(tmp);
  		change = round(change-value,2);
  	}
  }
  return (change == 0) ? changeArr : "Insufficient Funds";
}

function round(value, decimals) {
  return Number(Math.round(value+'e'+decimals)+'e-'+decimals);
}

function getTotalCash(cid){
	var sum = 0;
	return cid.reduce(function(a,b){
		sum += b[1]; return sum;
	},0);
}

console.log(checkCashRegister(3.26, 100.00, [["PENNY", 1.01], ["NICKEL", 2.05], ["DIME", 3.10], ["QUARTER", 4.25], ["ONE", 90.00], ["FIVE", 55.00], ["TEN", 20.00], ["TWENTY", 60.00], ["ONE HUNDRED", 100.00]]));
