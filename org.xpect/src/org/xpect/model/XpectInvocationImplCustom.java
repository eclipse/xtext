package org.xpect.model;

import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.xpect.XjmContribution;
import org.xpect.XjmXpectMethod;
import org.xpect.XpectArgument;
import org.xpect.XpectFactory;
import org.xpect.XpectJavaModel;
import org.xpect.XpectPackage;
import org.xpect.parameter.IStatementRelatedRegion;
import org.xpect.parameter.IStatementRelatedRegionProvider;
import org.xpect.parameter.StatementRelatedRegionProvider;
import org.xpect.util.IJavaReflectAccess;

import com.google.common.collect.Lists;

public class XpectInvocationImplCustom extends XpectInvocationImpl {

	@Override
	public EList<XpectArgument> getArguments() {
		if (this.arguments == null) {
			XjmXpectMethod xjmMethod = getMethod();
			if (xjmMethod != null && !xjmMethod.eIsProxy()) {
				Method javaMethod = xjmMethod.getJavaMethod();
				if (javaMethod != null) {
					EList<XpectArgument> sup = super.getArguments();
					int count = javaMethod.getParameterTypes().length;
					for (int i = 0; i < count; i++) {
						XpectArgument argument = XpectFactory.eINSTANCE.createXpectArgument();
						argument.setIndex(i);
						sup.add(argument);
					}
				}
			}
		}
		return super.getArguments();
	}

	@Override
	public String getId() {
		if (this.id == null)
			((XpectFileImplCustom) this.getFile()).initalizeInvocationsIDs();
		return super.getId();
	}

	@Override
	public String getMethodName() {
		XjmXpectMethod method = basicGetMethod();
		return method != null && !method.eIsProxy() ? method.getName() : getMethodNameFromNodeModel();
	}

	protected String getMethodNameFromNodeModel() {
		for (INode node : NodeModelUtils.findNodesForFeature(this, XpectPackage.Literals.XPECT_INVOCATION__METHOD))
			return NodeModelUtils.getTokenText(node);
		return null;
	}

	protected Class<?> getParameterType(int paramIndex) {
		XjmXpectMethod xpectMethod = getMethod();
		if (xpectMethod == null)
			return null;
		JvmOperation jvmMethod = xpectMethod.getJvmMethod();
		if (jvmMethod == null || jvmMethod.eIsProxy())
			return null;
		JvmTypeReference parameterType = jvmMethod.getParameters().get(paramIndex).getParameterType();
		if (parameterType == null || parameterType.eIsProxy() || parameterType.getType() == null)
			return null;
		Class<?> expectedType = IJavaReflectAccess.INSTANCE.getRawType(parameterType.getType());
		return expectedType;
	}

	@Override
	public <T extends IStatementRelatedRegion> T getRelatedRegion(Class<T> type) {
		for (IStatementRelatedRegion region : getRelatedRegions())
			if (type.isInstance(region))
				return type.cast(region);
		return null;
	}

	@Override
	public EList<IStatementRelatedRegion> getRelatedRegions() {
		if (this.relatedRegions == null) {
			List<IStatementRelatedRegion> regions = Lists.newArrayList();
			XpectJavaModel xjm = getFile().getJavaModel();
			if (xjm != null) {
				for (XjmContribution contrib : xjm.getContributions(StatementRelatedRegionProvider.class)) {
					IStatementRelatedRegionProvider provider = contrib.newInstance(IStatementRelatedRegionProvider.class);
					if (provider != null) {
						IStatementRelatedRegion region = provider.getRegion(this);
						if (region != null)
							regions.add(region);
					}
				}
				for (int i = 0; i < regions.size(); i++) {
					IStatementRelatedRegion region = regions.get(i);
					if (region instanceof IStatementRelatedRegionProvider.IRefinableStatementRelatedRegion) {
						IStatementRelatedRegion refined = ((IStatementRelatedRegionProvider.IRefinableStatementRelatedRegion) region).refine(regions);
						regions.set(i, refined);
					}
				}
			}
			super.getRelatedRegions().addAll(regions);
		}
		return super.getRelatedRegions();
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setMethod(XjmXpectMethod newMethod) {
		((XpectFileImplCustom) getFile()).unsetInvocationIDs();
		this.relatedRegions = null;
		this.arguments = null;
		super.setMethod(newMethod);
	}

}
