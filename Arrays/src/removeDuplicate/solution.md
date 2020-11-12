Still provide two pointers:  
Pointer 1 traverse the whole array.  
Pointer 2 point to the position, which stores unique number  
Provide a standard number: used to store the number first show up.  
If ```nums[Pointer 1] == standard```, this element is duplicated, we need to remove it.  
switch ```nums[Pointer 1]```and ```nums[Pointer 2]```  
If ```nums[Pointer 1]``` is a new number, update standard number and move Pointer 2 forward

