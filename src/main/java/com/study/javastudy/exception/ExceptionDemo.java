package com.study.javastudy.exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 异常处理机制
 *    让程序在异常发生时，按照代码的预先设定的异常处理逻辑，针对性地处理异常，让程序尽最大可能恢复正常并继续执行，且保持代码的清晰。Java中的异常可以是函数中的语句执行时引发的，
 *    也可以是程序员通过throw 语句手动抛出的，只要在Java程序中产生了异常，就会用一个对应类型的异常对象来封装异常，JRE就会试图寻找异常处理程序来处理异常。
 *
 * Throwable类：所有异常对象的父类。Throwable又派生出Error类和Exception类。
 * 错误：Error类以及他的子类的实例，代表了JVM本身的错误。错误不能被程序员通过代码处理，Error很少出现。
 * 异常：Exception以及他的子类，代表程序运行时发送的各种不期望发生的事件。可以被Java异常处理机制使用，是异常处理的核心。
 *
 * 分类：
 *     非检查异常：javac在编译时，不会提示和发现这样的异常，不要求在程序处理这些异常。对于这些异常，我们应该修正代码，而不是去通过异常处理器处理 。
 *        这样的异常发生的原因多半是代码写的有问题，如除0错误ArithmeticException。
 *     检查异常：javac强制要求程序员为这样的异常做预备处理工作（使用try…catch…finally或者throws）。在方法中要么用try-catch语句捕获它并处理，
 *        要么用throws子句声明抛出它，否则编译不会通过。这样的异常一般是由程序的运行环境导致的。如SQLException、IOException等。
 *
 * 异常的链化:以一个异常对象为参数构造新的异常对象。新的异对象将包含先前异常的信息。
 *
 * 自定义异常:
 *      扩展Exception类:检查异常
 *      扩展自RuntimeException:非检查异常
 *
 * 异常的注意事项：
 * 1、当子类重写父类的带有 throws声明的函数时，其throws声明的异常必须在父类异常的可控范围内——用于处理父类的throws方法的异常处理器，必须也适用于子类的这个带throws方法 。
 * 2、java中的异常是线程独立的，线程的问题应该由线程自己来解决，而不要委托到外部，也不会直接影响到其它线程的执行。
 * 3、finally块和return：
 *      在try块中即便有return，break，continue等改变执行流的语句，finally也会执行。
 *      finally中的return会抑制（消灭）前面try或者catch块中的异常。
 *      finally中的异常会覆盖（消灭）前面try或者catch中的异常
 *      在finally 中使用return或者抛出异常，将导致程序可读性不好，应该尽量做到：
 *          不要在fianlly中使用return。
 *          不要在finally中抛出异常。
 *          减轻finally的任务，不要在finally中做一些其它的事情，finally块仅仅用来释放资源是最合适的。
 *          尽量将所有的return写在函数的最后面，而不是try … catch … finally中。
 *
 * 异常的优点：
 *     1. 业务代码和错误处理代码分离。
 *     2. 有利于程序的稳定性。
 *     3. 有利于代码调试(异常信息)。
 *     4. 能保证资源的释放(finally)。
 *
 * 异常的缺点：
 *     1. 异常嵌套难免影响代码可读性。
 *     2. 并不能令程序逻辑更加清晰。
 *     3. 异常并不能解决所有问题。
 *
 *
 * @author wentianlou
 * @date 2019/12/4 13:56
 **/
public class ExceptionDemo {

    public static void main(String[] args) {
        //非检查异常,可以不使用异常处理机制，编译不会报错，执行会抛出异常：ArithmeticException
        int result = 10/0;
        System.out.println("result:" + result); //异常了，不会执行

        try{
            //try块中放可能发生异常的代码。
            //如果执行完try且不发生异常，则接着去执行finally块和finally后面的代码（如果有的话）。
            //如果发生异常，则尝试去匹配catch块。
            testException();
        }catch (IOException e){
            //每一个catch块用于捕获并处理一个特定的异常，或者这异常类型的子类。Java7中可以将多个异常声明在一个catch中。
            //catch后面的括号定义了异常类型和异常参数。如果异常与之匹配且是最先匹配到的，则虚拟机将使用这个catch块来处理异常。
            //在catch块中可以使用这个块的异常参数来获取异常的相关信息。异常参数是这个catch块中的局部变量，其它块不能访问。
            //如果当前try块中发生的异常在后续的所有catch中都没捕获到，则先去执行finally，然后到这个函数的外部caller中去匹配异常处理器。
            //如果try中没有发生异常，则所有的catch块将被忽略。
            System.out.println("捕获异常、相应的处理");
        }finally {
            //finally块通常是可选的。
            //无论异常是否发生，异常是否匹配被处理，finally都会执行。
            //一个try至少要有一个catch块，否则，至少要有1个finally块。但是finally不是用来处理异常的，finally不会捕获异常。
            //finally主要做一些清理工作，如流的关闭，数据库连接的关闭等。
        }

    }

    /**
     * 检查异常:必须使用异常处理机制
     *        1、让函数的调用者去处理可能发生的异常throws
     *        2、使用try…catch…finally语句块处理它
     * @throws IOException
     */
    public static void testException() throws IOException
    {
        //FileInputStream的构造函数会抛出FileNotFoundException
        FileInputStream fileIn = new FileInputStream("E:\\a.txt");

        int word;
        //read方法会抛出IOException
        while((word =  fileIn.read())!=-1)
        {
            System.out.print((char)word);
        }
        //close方法会抛出IOException
        fileIn.close();
    }

    //执行加法计算
    private static int add() throws Exception
    {
        int result;
        try {
            List<Integer> nums =getInputNumbers();
            result = nums.get(0)  + nums.get(1);
        }catch(InputMismatchException immExp){
            //链化:以一个异常对象为参数构造新的异常对象。
            throw new Exception("计算失败",immExp);
        }
        return  result;
    }

    //获取输入的2个整数返回
    private static List<Integer> getInputNumbers()
    {
        List<Integer> nums = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        try {
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            nums.add(new Integer(num1));
            nums.add(new Integer(num2));
        }catch(InputMismatchException immExp){
            throw immExp;
        }finally {
            scan.close();
        }
        return nums;
    }
}
