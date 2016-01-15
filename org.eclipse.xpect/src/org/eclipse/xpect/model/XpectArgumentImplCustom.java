package org.eclipse.xpect.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.xpect.XjmXpectMethod;
import org.eclipse.xpect.XpectInvocation;
import org.eclipse.xpect.state.XpectStateAnnotation;
import org.eclipse.xpect.util.AnnotationUtil;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class XpectArgumentImplCustom extends XpectArgumentImpl {
	@Override
	public <T extends Annotation> T getAnnotationOrDefault(Class<T> annotationType) {
		Method javaMethod = getJavaMethod();
		if (javaMethod == null)
			return null;
		Annotation[] annotations = javaMethod.getParameterAnnotations()[getIndex()];
		for (Annotation a : annotations)
			if (annotationType.isInstance(a))
				return annotationType.cast(a);
		return AnnotationUtil.newInstanceWithDefaults(annotationType);
	}

	private Method getJavaMethod() {
		XpectInvocation statement = getStatement();
		if (statement != null) {
			XjmXpectMethod xjmMethod = statement.getMethod();
			if (xjmMethod != null && !xjmMethod.eIsProxy()) {
				Method javaMethod = xjmMethod.getJavaMethod();
				if (javaMethod != null)
					return javaMethod;
			}
		}
		return null;
	}

	@Override
	public Class<?> getJavaType() {
		Method javaMethod = getJavaMethod();
		if (javaMethod == null)
			return null;
		return javaMethod.getParameterTypes()[getIndex()];
	}

	@Override
	public Annotation getStateAnnotation() {
		Method method = getJavaMethod();
		if (method == null)
			return null;
		Annotation[] candidates = method.getParameterAnnotations()[getIndex()];
		for (Annotation a : candidates)
			if (a.annotationType().getAnnotation(XpectStateAnnotation.class) != null)
				return a;
		return null;
	}

	@Override
	public XpectInvocation getStatement() {
		return (XpectInvocation) eContainer();
	}

	@Override
	public String toString() {
		return toTypeAndName();
	}

	@Override
	public String toString(boolean showClass, boolean showMethod) {
		Method javaMethod = getJavaMethod();
		if (javaMethod == null)
			return "(unresolved)";
		StringBuilder builder = new StringBuilder();
		if (showClass) {
			builder.append(javaMethod.getDeclaringClass().getName());
			builder.append(".");
		}
		if (showMethod || showClass) {
			builder.append(javaMethod.getName());
			builder.append("(");
			int i = getIndex();
			List<String> args = Lists.newArrayList();
			if (i > 0)
				args.add("...");
			args.add(toTypeAndName());
			if (i < javaMethod.getParameterTypes().length - 1)
				args.add("...");
			builder.append(Joiner.on(", ").join(args));
			builder.append(")");
			return builder.toString();
		} else
			return toTypeAndName();
	}

	private String toTypeAndName() {
		String name = " arg" + getIndex();
		Class<?> javaType = getJavaType();
		if (javaType == null)
			return name;
		return javaType.getSimpleName() + name;
	}
}
