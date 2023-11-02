

# JDK11

## 基于嵌套的访问控制

### 概述

如果你在一个类中嵌套了多个类，各类中可以直接访问彼此的私有成员。因为JDK 11开始在 private,public,protected的基础上，JVM又提供了一种新的访问机制：Nest

JDK 11开始，嵌套是一种访问控制上下文，它允许多个class同属一个逻辑代码块，但是被编译成多个分散的class文 件，它们访问彼此的私有成员无需通过编译器添加访问扩展方法，而是可以直接进行访问，如果上述代码可以直接通过反射访问外部类的私有成员，而不会出现权限问题



### 使用



```java
package mao;

import java.lang.reflect.Field;

/**
 * Project name(项目名称)：JDK11_nesting_based_access_control
 * Package(包名): mao
 * Class(类名): Test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/11/2
 * Time(创建时间)： 16:52
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test1
{
    private int outerInt;

    class Inner
    {
        public void test() throws Exception
        {
            System.out.println("Outer int = " + outerInt);
            // JDK 11之前，如下代码报出异常：IllegalAccessException
            Class c = Test1.class;
            Field f = c.getDeclaredField("outerInt");
            f.set(Test1.this, 23);
        }
    }

    public static void main(String[] args) throws Exception
    {
        new Test1().new Inner().test();
    }

}
```



