
package main.java.solutions.unclassified;

import java.util.PriorityQueue;

/*
1.
标准大根堆，默认初始容量为 11 ，我们这里指定了 1 ，不断向优先级队列添加元素时，容量会自动扩容。
要注意的是，o1=1, o2=-2147483648 时，o2 - o1 = -2147483649 溢出，所以尽量不要 return o2 - o1;
PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
    @Override
    public int compare(Integer o1, Integer o2){
        // return o2 - o1;
        return o2.compareTo(o1);
    }
});

2. 简写一，同样避免使用 (o1, o2) -> (o2 - o1)
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));

3. 简写二
PriorityQueue<Double> maxHeap=new PriorityQueue<>(1, Collections.reverseOrder());

*/

// 排序的时间复杂度为O(NlogN)，但事实上我们只对中位数感兴趣，用小/大根堆可以达到O(logN)。
// 小的一半用大根堆保存，大的一半用小根堆保存，这样只需要取两个队列的队首元素即可。

/**
 * 295. Find Median from Data Stream -- 数据流的中位数。中位数是有序列表中间的数
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * @author zx
 * @since 2020-12-23
 */
public class Q295MedianFinder {
    // 默认的 PriorityQueue 并非保证了整个队列都是有序的，只是保证了队头是最小的。
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    /**
     * initialize your data structure here.
     */
    public Q295MedianFinder() {
        // x.compareTo(y)，x > y 返回 1，x = y 返回 0，x < y 返回 -1
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
    }

    /**
     * 中位数是有序列表中间的数。把数据流分成两部分，小的一半用大根堆保存，大的一半用小根堆保存
     * [3, 2, 1] -- [4, 5, 6]，中位数取两个队列的队首元素即可。
     *
     * @param num 数字
     */
    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return (double) maxHeap.peek();
        }
    }
}
