# leetcode


IDEA 打开可能会有两个问题
1. “提示引不到类”，需要删除缓存重新建立索引。
> **解决：IDEA –> File –> Invalidate Caches/Restart 。**
   
   
2. “示找不到 Junit，或者报错 java.lang.NoClassDefFoundError: org/hamcrest/SelfDescribing”。这是因为 Junit 4.11 以上版本不再包含 hamcrest，所以如果使用 Junit 4.11 以上版本就需要导入 hamcrest，或者降到 Junit 4.10 版本也行。
> **解决，导入 lib：**
> 
> File –> Project Structure –> Libraries –> "+"(New Project Library) –> Java –> D:\JetBrains\IntelliJ IDEA Community Edition 2020.3\lib\junit-4.12.jar
> 
> File –> Project Structure –> Libraries –> "+"(New Project Library) –> Java –> D:\JetBrains\IntelliJ IDEA Community Edition 2020.3\lib\hamcrest-core-1.3.jar
