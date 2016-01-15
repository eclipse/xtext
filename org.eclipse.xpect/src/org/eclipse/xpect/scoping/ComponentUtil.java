package org.eclipse.xpect.scoping;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.xpect.AbstractComponent;
import org.eclipse.xpect.Assignment;
import org.eclipse.xpect.Component;
import org.eclipse.xpect.XjmContribution;
import org.eclipse.xpect.XpectJavaModel;
import org.eclipse.xpect.XpectTest;
import org.eclipse.xpect.setup.XpectSetupComponent;
import org.eclipse.xpect.setup.XpectSetupRoot;
import org.eclipse.xpect.util.JvmTypesUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class ComponentUtil {

	private final XpectJavaModel xjm;

	public ComponentUtil(XpectJavaModel xjm) {
		super();
		this.xjm = xjm;
	}

	private Set<JvmDeclaredType> getCompatibleContributions(Set<JvmDeclaredType> types) {
		Set<JvmDeclaredType> result = Sets.newHashSet();
		Set<JvmDeclaredType> inactive = Sets.newHashSet();
		Iterable<XjmContribution> contributions = xjm.getContributions(XpectSetupComponent.class);
		CONT: for (XjmContribution contribution : contributions) {
			JvmDeclaredType jvmClass = contribution.getJvmClass();
			if (contribution.isActive()) {
				Set<JvmType> superTypes = JvmTypesUtil.getSelfAndAllSuperTypes(jvmClass);
				for (JvmType superType : superTypes)
					if (superType instanceof JvmDeclaredType && types.contains(superType)) {
						result.add(jvmClass);
						continue CONT;
					}
			} else {
				inactive.add(jvmClass);
			}
		}
		for (JvmDeclaredType type : types)
			if (!type.isAbstract() && type instanceof JvmGenericType && !((JvmGenericType) type).isInterface() && !inactive.contains(type))
				result.add(type);
		return result;
	}

	private void collectAdders(JvmType type, List<JvmOperation> ops) {
		if (type instanceof JvmDeclaredType && !type.eIsProxy())
			for (JvmFeature feat : ((JvmDeclaredType) type).getAllFeatures())
				if (feat instanceof JvmOperation && "add".equals(feat.getSimpleName()))
					ops.add((JvmOperation) feat);
	}

	private Set<JvmDeclaredType> getFirstParameterTypes(List<JvmOperation> ops) {
		Set<JvmDeclaredType> result = Sets.newHashSet();
		for (JvmOperation op : ops)
			if (op.getParameters().size() == 1) {
				JvmTypeReference paramType = op.getParameters().get(0).getParameterType();
				if (paramType != null && !paramType.eIsProxy()) {
					JvmType type = paramType.getType();
					if (type instanceof JvmDeclaredType && !type.eIsProxy())
						result.add((JvmDeclaredType) type);
				}
			}
		return result;
	}

	public Set<JvmDeclaredType> getValidRootTypes() {
		Iterable<XjmContribution> contributions = xjm.getContributions(XpectSetupRoot.class);
		List<JvmOperation> ops = Lists.newArrayList();
		for (XjmContribution contribution : contributions)
			if (contribution.isActive()) {
				JvmDeclaredType jvmClass = contribution.getJvmClass();
				collectAdders(jvmClass, ops);
			}
		Set<JvmDeclaredType> firstParameterTypes = getFirstParameterTypes(ops);
		Set<JvmDeclaredType> compatibleContributions = getCompatibleContributions(firstParameterTypes);
		return compatibleContributions;
	}

	public Set<JvmDeclaredType> getValidTypes(Assignment assignment) {
		List<JvmOperation> ops = Lists.newArrayList();
		JvmOperation operation = assignment.getDeclaredTarget();
		if (operation != null) {
			if (operation.eIsProxy())
				return Collections.emptySet();
			ops.add(operation);
		} else {
			AbstractComponent container = assignment.getInstance();
			if (container instanceof Component) {
				JvmDeclaredType type = ((Component) container).getComponentClass();
				if (type != null && !type.eIsProxy())
					collectAdders(type, ops);
				return getCompatibleContributions(getFirstParameterTypes(ops));
			} else if (container instanceof XpectTest) {
				return getValidRootTypes();
			} else
				return Collections.emptySet();
		}
		return getCompatibleContributions(getFirstParameterTypes(ops));
	}
}
