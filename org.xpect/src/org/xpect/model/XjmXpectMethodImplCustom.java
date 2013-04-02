package org.xpect.model;

import static org.xpect.util.JvmAnnotationUtil.newInstancesViaMetaAnnotation;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.xpect.parameter.IParameterParser.IMultiParameterParser;
import org.xpect.parameter.IParameterParser.ISingleParameterParser;
import org.xpect.parameter.IParameterParser.MultiParameterParser;
import org.xpect.parameter.IParameterParser.SingleParameterParser;

public class XjmXpectMethodImplCustom extends XjmXpectMethodImpl {

	protected List<IMultiParameterParser> findMultiParameterProvider(JvmOperation method) {
		return newInstancesViaMetaAnnotation(method, IMultiParameterParser.class, MultiParameterParser.class);
	}

	protected ISingleParameterParser findSingleParameterProvider(JvmFormalParameter parameter) {
		List<ISingleParameterParser> handler = newInstancesViaMetaAnnotation(parameter, ISingleParameterParser.class,
				SingleParameterParser.class);
		if (handler.isEmpty())
			return null;
		if (handler.size() == 1)
			return handler.get(0);
		throw new RuntimeException("Method " + parameter + " has more than one annotation that is annotated with "
				+ SingleParameterParser.class);
	}

	@Override
	public EList<IMultiParameterParser> getMultiParameterProviders() {
		if (super.multiParameterProviders == null)
			super.getMultiParameterProviders().addAll(findMultiParameterProvider(getJvmMethod()));
		return super.getMultiParameterProviders();
	}

	@Override
	public int getParameterCount() {
		return getJavaMethod().getParameterTypes().length;
	}

	@Override
	public EList<ISingleParameterParser> getSingleParameterProviders() {
		if (super.singleParameterProviders == null) {
			EList<ISingleParameterParser> providers = super.getSingleParameterProviders();
			for (JvmFormalParameter param : getJvmMethod().getParameters())
				providers.add(findSingleParameterProvider(param));
		}
		return super.getSingleParameterProviders();
	}

	@Override
	public void setJvmMethod(JvmOperation newJvmMethod) {
		super.multiParameterProviders = null;
		super.singleParameterProviders = null;
		super.setJvmMethod(newJvmMethod);
	}

	@Override
	public String toString() {
		return "@Xpect public void " + getJvmMethod().getSimpleName() + "();";
	}

}
