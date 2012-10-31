package org.xpect.runner;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.junit.runners.model.InitializationError;
import org.xpect.runner.IXpectParameterProvider.IXpectMultiParameterProvider;
import org.xpect.runner.IXpectParameterProvider.IXpectSingleParameterProvider;
import org.xpect.util.AnnotationUtil;

@SuppressWarnings("restriction")
public class XpectFrameworkMethod {

	private JvmOperation operation;

	private Class<?> clazz;

	private Method method;

	private List<IXpectMultiParameterProvider> multiParameterProvider;

	private List<IXpectSingleParameterProvider> singleParameterProvider;

	public XpectFrameworkMethod(Class<?> clazz, JvmOperation operation) throws InitializationError {
		super();
		this.operation = operation;
		this.method = findMethod(clazz, operation);
		if (this.method == null)
			throw new NullPointerException("Could not find Java method for " + operation);
		if (this.method.getParameterTypes().length > 0) {
			this.multiParameterProvider = findMultiParameterProvider(method);
			this.singleParameterProvider = Arrays.asList(new IXpectSingleParameterProvider[getParameterCount()]);
			for (int i = 0; i < getParameterCount(); i++)
				this.singleParameterProvider.set(i, findSingleParameterProvider(method, i));
		} else {
			this.multiParameterProvider = Collections.emptyList();
			this.singleParameterProvider = Collections.emptyList();
		}
	}

	public JvmOperation getOperation() {
		return operation;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public int getParameterCount() {
		return method.getParameterTypes().length;
	}

	public Method getMethod() {
		return method;
	}

	public List<IXpectMultiParameterProvider> getMultiParameterProvider() {
		return multiParameterProvider;
	}

	public List<IXpectSingleParameterProvider> getSingleParameterProvider() {
		return singleParameterProvider;
	}

	protected Method findMethod(Class<?> clazz, JvmOperation operation) {
		JavaReflectAccess jra = new JavaReflectAccess();
		jra.setClassLoader(clazz.getClassLoader());
		return jra.getMethod(operation);
	}

	protected List<IXpectMultiParameterProvider> findMultiParameterProvider(Method method) {
		if (method == null)
			return Collections.emptyList();
		return AnnotationUtil.newInstancesViaMetaAnnotation(method, XpectMultiParameterProvider.class, IXpectMultiParameterProvider.class);
	}

	protected IXpectSingleParameterProvider findSingleParameterProvider(Method method, int paramIndex) {
		if (method == null)
			return null;
		List<IXpectSingleParameterProvider> handler = AnnotationUtil.newInstancesViaMetaAnnotation(method, paramIndex,
				XpectSingleParameterProvider.class, IXpectSingleParameterProvider.class);
		if (handler.isEmpty())
			return null;
		if (handler.size() == 1)
			return handler.get(0);
		throw new RuntimeException("Method " + method + " has more than one annotation that is annotated with "
				+ XpectSingleParameterProvider.class);
	}

}
