package org.xpect.model;

import static org.xpect.util.JvmAnnotationUtil.newInstancesViaMetaAnnotation;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.xpect.XjmFactory;
import org.xpect.XpectJavaModelFactory;
import org.xpect.parameter.IParameterParser.IMultiParameterParser;
import org.xpect.parameter.IParameterParser.ISingleParameterParser;
import org.xpect.parameter.IParameterParser.MultiParameterParser;
import org.xpect.parameter.IParameterParser.SingleParameterParser;
import org.xpect.setup.XpectSetup;
import org.xpect.util.JvmAnnotationUtil;

import com.google.common.collect.Sets;

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
	public EList<XjmFactory> getFactories() {
		if (super.factories == null) {
			Set<JvmDeclaredType> types = Sets.newLinkedHashSet();
			JvmOperation method = getJvmMethod();
			if (method != null && !method.eIsProxy()) {
				types.addAll(JvmAnnotationUtil.getAnnotationTypeValue(method, XpectSetup.class));
				for (JvmFormalParameter param : method.getParameters()) {
					JvmType type = param.getParameterType().getType();
					if (type instanceof JvmAnnotationTarget)
						types.addAll(JvmAnnotationUtil.getAnnotationTypeValue((JvmAnnotationTarget) type, XpectSetup.class));
					for (JvmAnnotationReference aref : param.getAnnotations())
						types.addAll(JvmAnnotationUtil.getAnnotationTypeValue(aref.getAnnotation(), XpectSetup.class));
				}
			}
			EList<XjmFactory> facts = super.getFactories();
			for (JvmDeclaredType type : types) {
				XjmFactory factory = XpectJavaModelFactory.eINSTANCE.createXjmFactory();
				factory.setJvmClass(type);
				facts.add(factory);
			}
		}
		return super.getFactories();
	}

	@Override
	public EList<IMultiParameterParser> getMultiParameterProviders() {
		if (super.multiParameterProviders == null)
			super.getMultiParameterProviders().addAll(findMultiParameterProvider(getJvmMethod()));
		return super.getMultiParameterProviders();
	}

	@Override
	public int getParameterCount() {
		JvmOperation method = getJvmMethod();
		if (method != null && !method.eIsProxy())
			return method.getParameters().size();
		return 0;
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
		super.factories = null;
		super.setJvmMethod(newJvmMethod);
	}

	@Override
	public String toString() {
		return "@Xpect public void " + getJvmMethod().getSimpleName() + "();";
	}

}
