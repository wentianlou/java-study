package com.study.javastudy.exception;

/**
 * 定义自定义异常的惯例
 *     一个无参构造函数
 *     一个带有String参数的构造函数，并传递给父类的构造函数。
 *     一个带有String参数和Throwable参数，并都传递给父类构造函数
 *     一个带有Throwable 参数的构造函数，并传递给父类的构造函数。
 *
 * @author wentianlou
 * @date 2019/12/4 15:13
 **/
public class MyException extends Exception {
    static final long serialVersionUID = 7818375828146090155L;

    public MyException()
    {
        super();
    }

    public MyException(String message)
    {
        super(message);
    }

    public MyException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public MyException(Throwable cause)
    {
        super(cause);
    }
}
