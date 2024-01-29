

# 所使用到的开发工具

## 开发平台
> windows 11

## c/c++ 部分
> clion 
> mingw64
> cmake

## java 部分
> idea
> maven
> jdk8 (64位)



# 编译工具说明

在windows 平台上，我们通过mingw64 来编译。
> 参考 https://zhuanlan.zhihu.com/p/76613134
> 
> 

遇到的坑：
> mingw64 非4.8 版本，编译出来的dll，java程序加载总是报错。
> 为了能够成功让java 程序加载，尝试了很多版本，最终只有4.8 的版本编译出来没有问题