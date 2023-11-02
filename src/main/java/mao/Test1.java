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
