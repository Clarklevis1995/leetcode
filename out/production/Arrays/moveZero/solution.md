利用双指针的方法；  
* 首先利用Pointer 1进行遍历整个数组，Pointer 2指向第一个元素
* 如果Pointer 1指向的元素为非零元素：  
    * 将当前元素值给Pointer 2指向的元素
    * Pointer 2向前移动一位
* 如果Pointer 2指向的元素为0
    * 计数器（zeroCounter++）
* 通过再一次循环，从数组末尾开始添加0

方法2：
* 遍历Pointer 1的时候，如果当前元素为非0元素，就拿这个元素和Pointer 2指向的元素交换