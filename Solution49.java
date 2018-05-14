package sword_offer;
// page 240 丑数

public class Solution49 {
    // 方法1：一个一个判断是否是丑数，直到找到目标值
    public static int getUglyNum_s1(int index) {
        int count = 0;
        int num = 0;
        while (count < index) {
            num++;    // 把num++放在循环的开头而非末尾
            if (isUglyNum(num))
                count++;

        }
        return num;
    }

    // 判断是否是丑数
    private static boolean isUglyNum(int n) {
        while (n % 2 == 0)
            n /= 2;
        while (n % 3 == 0)
            n /= 3;
        while (n % 5 == 0)
            n /= 5;
        return n == 1 ? true : false;
    }

    // 方法2：额外定义个缓存数组，将丑数存下来，注意里面使用3个变量跟踪的技巧
    public static int getUglyNum_s2(int index) {
        int[] uglyNums = new int[index];
        uglyNums[0] = 1;
        int pm2 = 0;
        int pm3 = 0;
        int pm5 = 0;
        int nextIndex = 1;
        while (nextIndex < index) {
            int min = minNum(uglyNums[pm2] * 2, uglyNums[pm3] * 3, uglyNums[pm5] * 5);
            uglyNums[nextIndex] = min;
            while (uglyNums[pm2] * 2 <= min)
                pm2++;
            while (uglyNums[pm3] * 3 <= min)
                pm3++;
            while (uglyNums[pm5] * 5 <= min)
                pm5++;
            nextIndex++; // 这里将nextIndex++放到末尾，因为是索引
        }
        return uglyNums[nextIndex - 1];

    }

    // 三个数中的最小值
    public static int minNum(int x, int y, int z) {
        int min = x < y ? x : y;
        min = z < min ? z : min;
        return min;
    }
    
    // 测试
    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        System.out.println("方法1计算的第1500个丑数：" + getUglyNum_s1(250));
        long t1 = System.currentTimeMillis();
        System.out.println("方法1耗时：" + (t1 - t0) + "ms");
        //System.out.println("方法2计算的第1500个丑数：" + getUglyNum_s2(1500));
        long t2 = System.currentTimeMillis();
        System.out.println("方法2耗时：" +(t2 - t1) + "ms");
    }
}