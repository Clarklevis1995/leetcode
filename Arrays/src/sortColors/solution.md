solution 1:  
* calculate the number of 0,1,2
* renter the number in sequent to the original array

solution 2:  
use double pointer  
p0   p2,  
use index i to traverse  
if ```nums[i] == 0```,exchange the value of index p0 and i, p0++;  
if ```nums[i] == 2```,exchange the value of index p2 and i, p2--, but we need to consider if the value after exchange of index i is still 2. We need keep exchanging until ```nums[i] != 2```.  
