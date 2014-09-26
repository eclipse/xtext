package org.xpect.model;

import java.lang.annotation.Annotation;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.util.Strings;
import org.xpect.Environment;
import org.xpect.XjmContribution;
import org.xpect.XpectRequiredEnvironment;
import org.xpect.util.JvmAnnotationUtil;

import com.google.common.collect.Lists;

public class XjmContributionImplCustom extends XjmContributionImpl {

	public void initialize(JvmDeclaredType type, Collection<? extends Annotation> roles) {
		super.setDeactivationReason(null);
		super.setJvmClass(type);
		EList<Annotation> newRoles = super.getRoles();
		newRoles.clear();
		newRoles.addAll(roles);
		EList<Environment> newEnvironments = getEnvironments();
		newEnvironments.clear();
		XpectRequiredEnvironment xpectEnvironment = JvmAnnotationUtil.getJavaAnnotation(getJvmClass(), XpectRequiredEnvironment.class);
		if (xpectEnvironment != null)
			newEnvironments.addAll(Lists.newArrayList(xpectEnvironment.value()));
		else
			newEnvironments.addAll(Lists.newArrayList(Environment.values()));
	}

	@Override
	public boolean isActive() {
		JvmDeclaredType cls = getJvmClass();
		return cls != null && !cls.eIsProxy() && Strings.isEmpty(getDeactivationReason());
	}

	@Override
	public void setJvmClass(JvmDeclaredType newJvmClass) {
		throw new UnsupportedOperationException(); // use initialize()
	}

	@Override
	public void setReplacedBy(XjmContribution newReplacedBy) {
		super.setReplacedBy(newReplacedBy);
		setDeactivationReason("ReplacedBy: " + newReplacedBy.getJvmClass().getQualifiedName());
	}
}
