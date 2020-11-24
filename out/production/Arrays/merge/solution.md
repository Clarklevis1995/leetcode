方法一：  
双指针，额外数组空间：  
num1[pointer1]和num2[pointer2]谁大就把谁放到新的数组中，最后用arraycopy方法给nums1数组赋值，不能直接将nums1引用到新的数组，因为nums1只是应用的副本  

方法二：  
三指针，在原数组上操作：  
p指向要更改的位置  
p1指向nums1中的末尾  
p2指向nums2中的末尾  
如果nums2[p2]>nums1[p1], nums1[p] = nums2[p2], 否则nums1[p] = nums1[p1],
对应的向前移动p1或者p2，最后移动p