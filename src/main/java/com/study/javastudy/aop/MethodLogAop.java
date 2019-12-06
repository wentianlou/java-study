package com.study.javastudy.aop;

import com.study.javastudy.annotation.LogMe;
import com.study.javastudy.plugin.ParameterRecorder;
import com.study.javastudy.plugin.ValueRecorder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wentianlou
 * @date 2019/12/4 17:45
 **/
@Aspect
public class MethodLogAop {
    private static final Logger log = LoggerFactory.getLogger(MethodLogAop.class);

    private List<ValueRecorder> returnValueRecorders = new LinkedList<>();
    private List<ValueRecorder> paramValueRecorders = new LinkedList<>();
    private List<ParameterRecorder> parameterRecorders = new LinkedList<>();

    public void addReturnValueRecorder(ValueRecorder returnValueRecorder) {
        if (returnValueRecorder != null) {
            this.returnValueRecorders.add(returnValueRecorder);
        }
    }

    public void addParamValueRecorder(ValueRecorder paramValueRecorder) {
        if (paramValueRecorder != null) {
            this.paramValueRecorders.add(paramValueRecorder);
        }
    }

    public void addParameterRecorder(ParameterRecorder parameterRecorder) {
        if (parameterRecorder != null) {
            this.parameterRecorders.add(parameterRecorder);
        }
    }

    @Pointcut(value = "@annotation(com.study.javastudy.annotation.LogMe)")
    public void pointCutOfAnnotation(){

    }

    /**
     * @Around的执行顺序： 进来方法之前和执行方法之后都会被执行,这里说的方法是指加了注解LogMe的方法
     * @param joinPoint
     * @param logAnnotation
     * @return
     * @throws Throwable
     */
    @Around(value = "MethodLogAop.pointCutOfAnnotation() && @annotation(logAnnotation)")
    public Object aroundService(ProceedingJoinPoint joinPoint, LogMe logAnnotation) throws Throwable {
        Signature signature = joinPoint.getSignature();
        try {
            if (logAnnotation.logParam()) {
                String[] argNames = null;
                //是否是方法签名
                if (signature instanceof MethodSignature) {
                    MethodSignature methodSignature = (MethodSignature) signature;
                    //获取方法所有的参数
                    argNames = methodSignature.getParameterNames();
                }
                MethodLogAop.log.info(getMethodInfo(signature) + " start, {}", getArgs(joinPoint.getArgs(), argNames));
            } else {
                MethodLogAop.log.info(getMethodInfo(signature) + " start");
            }
        } catch (Exception ignored) {

        }

        long start = System.currentTimeMillis();
        Object proceed;
        try {
            proceed = joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable) {
            log.info(getMethodInfo(signature) + " exp  , time spent: {}ms, exception message: {}", getTimeSpent(start), throwable.getMessage());
            throw throwable;
        }
        try {
            if (logAnnotation.logReturn()) {
                log.info(getMethodInfo(signature) + " end  , time spent: {}ms, return {}", getTimeSpent(start) , getReturn(proceed));
            } else {
                log.info(getMethodInfo(signature) + " end  , time spent: {}ms", getTimeSpent(start));
            }
        } catch (Exception ignored) {}
        return proceed;
    }

    private String getMethodInfo(Signature signature) {
        return getClassName(signature) + " - " + getMethodName(signature);
    }

    private String getClassName(Signature signature) {
        return signature.getDeclaringType().getName();
    }

    private String getMethodName(Signature signature) {
        return signature.getName();
    }

    private String getArgs(Object[] args, String[] argNames) {
        if (args == null || args.length == 0) {
            return "";
        }
        StringBuilder argsStr = new StringBuilder();
        argsStr.append("args ( ");
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            String argName = getArgName(i, argNames);
            if (arg == null) {
                argsStr.append(argName).append(": ").append("null").append(", ");
            } else {
                ParameterRecorder parameterRecorder = getParameterRecorder(argName, arg);
                if (parameterRecorder != null) {
                    argsStr.append(argName).append(": ").append(parameterRecorder.record(argName, arg)).append(", ");
                } else {
                    ValueRecorder paramValueRecorder = getParamValueRecorder(arg);
                    if (paramValueRecorder != null) {
                        argsStr.append(argName).append(": ").append(paramValueRecorder.record(arg)).append(", ");
                    } else {
                        argsStr.append(argName).append(": ").append(arg.toString()).append(", ");
                    }
                }
            }
        }
        argsStr.delete(argsStr.lastIndexOf(", "), argsStr.length());
        argsStr.append(" )");
        return argsStr.toString();
    }

    private ParameterRecorder getParameterRecorder(String paramName, Object value) {
        for (ParameterRecorder parameterRecorder : parameterRecorders) {
            if (parameterRecorder.test(paramName, value.getClass())) {
                return parameterRecorder;
            }
        }
        return null;
    }

    private ValueRecorder getParamValueRecorder(Object object) {
        for (ValueRecorder valueRecorder : paramValueRecorders) {
            if (valueRecorder.test(object.getClass())) {
                return valueRecorder;
            }
        }
        return null;
    }

    private String getReturn(Object returnV) {
        if (returnV == null) {
            return "null";
        }
        ValueRecorder valueRecorder = getReturnValueRecorder(returnV);
        if (valueRecorder == null) {
            return returnV.toString();
        }
        return valueRecorder.record(returnV);
    }

    private ValueRecorder getReturnValueRecorder(Object object) {
        for (ValueRecorder valueRecorder : returnValueRecorders) {
            if (valueRecorder.test(object.getClass())) {
                return valueRecorder;
            }
        }
        return null;
    }

    private String getArgName(int index, String[] argNames) {
        if (argNames == null || argNames.length == 0) {
            return String.valueOf(index + 1);
        }
        int length = argNames.length;
        if (index >= length) {
            return String.valueOf(index + 1);
        }
        return argNames[index];
    }

    private long getTimeSpent(long start) {
        return System.currentTimeMillis() - start;
    }
}
