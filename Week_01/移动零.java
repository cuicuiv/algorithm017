```java
class Solution {
	public void moveZeroes(int[] nums) {
		if(nums==null) {
			return;
		}
		//设置指针i j
		//遍历nums[i] 当nums[i]!=0 即当值不为0时 nums[j]=nums[i]；j++;
		int j = 0;
		for(int i=0;i<nums.length;++i) {
			if(nums[i]!=0) {
				nums[j++] = nums[i];
			}
		}
		//可以使i j指针同时向右移 只有当nums[i]!=0 j才移动 造成j指针是慢的一方 所有0遍历完后 数组中>j&&<nums.length的全放0即可
		for(int i=j;i<nums.length;++i) {
			nums[i] = 0;
		}
	}
}	



```
==优化==

```java
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        //优化之处在于只进行一次循环，边循环的同时移动i j指针 当数非0时赋给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; i ++){
            //nums[i]==0 时不需要进行操作 
            //nums[i]!=0 时 将j指针对应的非0值交换左移 导致j的左边全是非0值
            if (nums[i] != 0) {
            //当i=j 时 不需要交换 因为j指针是慢的一方 下次移动是判定交换 将非0值又换给了j
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j ++;
            }
        }
    }
}





```
==精简==

```java
public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) return;        

    int insertPos = 0;//慢指针
    for (int num: nums) {
        if (num != 0) nums[insertPos++] = num;
    }        

    while (insertPos < nums.length) {
        nums[insertPos++] = 0;
    }
}
```
*****