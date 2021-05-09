

完全二叉树



## 堆排序

堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆是一个近似完全二叉树的结构，并同时满足堆积的性质：即子节点的键值或索引总是小于（或者大于）它的父节点。

大根堆：

小根堆：



，只要求子节点与父节点的关系，两个节点的大小关系与其左右位置没有任何关系。

```python
#!/usr/bin/env python
#-*-coding:utf-8-*-


def heap_sort(lst):
    def sift_down(start, end):
        """最大堆调整"""
        root = start
        while True:
            child = 2 * root + 1
            if child > end:
                break
            if child + 1 <= end and lst[child] < lst[child + 1]:
                child += 1
            if lst[root] < lst[child]:
                lst[root], lst[child] = lst[child], lst[root]
                root = child
            else:
                break

# 创建最大堆

    for start in xrange((len(lst) - 2) // 2, -1, -1):
        sift_down(start, len(lst) - 1)

# 堆排序
    for end in xrange(len(lst) - 1, 0, -1):
        lst[0], lst[end] = lst[end], lst[0]
        sift_down(0, end - 1)
    return lst


def main():
    l = [9, 2, 1, 7, 6, 8, 5, 3, 4]
    heap_sort(l)


if __name__ == "__main__":
    main()
```



堆排序的平均时间复杂度为O (nlog n)，空间复杂度为 O(1)。



[白话讲排序系列（六） 堆排序（绝对让你明白堆排序！）](<https://blog.csdn.net/u013384984/article/details/79496052>)