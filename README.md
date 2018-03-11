# TheSuperTinyCompiler

## 该项目的功能是: 将lisp风格的函数转换为C风格的函数

     *                  LISP                      C
     *
     *   2 + 2          (add 2 2)                 add(2, 2)
     *   4 - 2          (subtract 4 2)            subtract(4, 2)
     *   2 + (4 - 2)    (add 2 (subtract 4 2))    add(2, subtract(4, 2))

## JS中文翻译版本
    
    https://github.com/starkwang/the-super-tiny-compiler-cn

## JS英文原版(这么一个小小的compiler有9000多个star,哈哈)

    https://github.com/jamiebuilds/the-super-tiny-compiler

## 运行结果

    lisp func:  (add 2 2) 
    C func: add(2,2);
    
    lisp func: (subtract 4 2) 
    C func: subtract(4,2);
    
    lisp func: (add (add 2 (subtract 4 2)) 9)
    C func: add(add(2,subtract(4,2)),9);