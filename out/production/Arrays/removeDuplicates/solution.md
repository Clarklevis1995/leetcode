Still provide 2 pointers.
But this time we allow the duplicated numbers for 2 times  
So there are 3 conditions:
1. next number is the second time 
2. next number is more than second time 
3. next number is a new number

for case 1:
* move Pointer 2 to next
* time++  

for case 2:
* move Pointer 2 to next
* countRemove++

for case 3:
* update standard
* Pointer++
* **time = 1**