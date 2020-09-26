```java
class Solution {
	public void moveZeroes(int[] nums) {
		if(nums==null) {
			return;
		}
		//����ָ��i j
		//����nums[i] ��nums[i]!=0 ����ֵ��Ϊ0ʱ nums[j]=nums[i]��j++;
		int j = 0;
		for(int i=0;i<nums.length;++i) {
			if(nums[i]!=0) {
				nums[j++] = nums[i];
			}
		}
		//����ʹi jָ��ͬʱ������ ֻ�е�nums[i]!=0 j���ƶ� ���jָ��������һ�� ����0������� ������>j&&<nums.length��ȫ��0����
		for(int i=j;i<nums.length;++i) {
			nums[i] = 0;
		}
	}
}	



```
==�Ż�==

```java
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        //�Ż�֮������ֻ����һ��ѭ������ѭ����ͬʱ�ƶ�i jָ�� ������0ʱ����nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; i ++){
            //nums[i]==0 ʱ����Ҫ���в��� 
            //nums[i]!=0 ʱ ��jָ���Ӧ�ķ�0ֵ�������� ����j�����ȫ�Ƿ�0ֵ
            if (nums[i] != 0) {
            //��i=j ʱ ����Ҫ���� ��Ϊjָ��������һ�� �´��ƶ����ж����� ����0ֵ�ֻ�����j
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
==����==

```java
public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) return;        

    int insertPos = 0;//��ָ��
    for (int num: nums) {
        if (num != 0) nums[insertPos++] = num;
    }        

    while (insertPos < nums.length) {
        nums[insertPos++] = 0;
    }
}
```
*****