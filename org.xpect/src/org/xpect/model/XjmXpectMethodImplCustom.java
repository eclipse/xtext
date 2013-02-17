package org.xpect.model;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmOperation;
import org.xpect.runner.IXpectParameterProvider.IXpectMultiParameterProvider;
import org.xpect.runner.IXpectParameterProvider.IXpectSingleParameterProvider;
import org.xpect.runner.XpectMultiParameterProvider;
import org.xpect.runner.XpectSingleParameterProvider;
import org.xpect.util.AnnotationUtil;

public class XjmXpectMethodImplCustom extends XjmXpectMethodImpl {

	@Override
	public String toString() {
		return "@Xpect public void " + getJvmMethod().getSimpleName() + "();";
	}

	@Override
	public void setJvmMethod(JvmOperation newJvmMethod) {
		super.getMultiParameterProviders().clear();
		super.getSingleParameterProviders().clear();
		super.setJvmMethod(newJvmMethod);
	}

	@Override
	public void setJavaMethod(Method newJavaMethod) {
		super.setJavaMethod(newJavaMethod);
		EList<IXpectMultiParameterProvider> multiParameter = super.getMultiParameterProviders();
		EList<IXpectSingleParameterProvider> singleParameter = super.getSingleParameterProviders();
		multiParameter.clear();
		singleParameter.clear();
		if (newJavaMethod != null && newJavaMethod.getParameterTypes().length > 0) {
			multiParameter.addAll(findMultiParameterProvider(newJavaMethod));
			for (int i = 0; i < newJavaMethod.getParameterTypes().length; i++)
				singleParameter.add(findSingleParameterProvider(newJavaMethod, i));
		}
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

	@Override
	public EList<IXpectMultiParameterProvider> getMultiParameterProviders() {
		getJavaMethod();
		return super.getMultiParameterProviders();
	}

	@Override
	public int getParameterCount() {
		return getJavaMethod().getParameterTypes().length;
	}

	@Override
	public EList<IXpectSingleParameterProvider> getSingleParameterProviders() {
		getJavaMethod();
		return super.getSingleParameterProviders();
	}

}
