/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.scoping;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.Strings;
import org.xpect.Assignment;
import org.xpect.Component;
import org.xpect.XjmMethod;
import org.xpect.XjmTest;
import org.xpect.XpectFile;
import org.xpect.XpectJavaModel;
import org.xpect.XpectPackage;
import org.xpect.XpectTest;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XpectScopeProvider extends AbstractScopeProvider {

	@Inject
	@Named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)
	private IScopeProvider delegate;

	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;

	private Set<JvmDeclaredType> getAssignableTypes(EObject context) {
		EObject current = context;
		XpectJavaModel xjm = EcoreUtil2.getContainerOfType(context, XpectFile.class).getJavaModel();
		ComponentUtil util = new ComponentUtil(xjm);
		while (current != null) {
			if (current instanceof Assignment)
				return util.getValidTypes((Assignment) current);
			if (current instanceof XpectTest)
				return util.getValidRootTypes();
			current = current.eContainer();
		}
		return Collections.emptySet();
	}

	private String getAssignmentTargetFeatureName(JvmFeature feature) {
		if (feature instanceof JvmOperation) {
			JvmOperation op = (JvmOperation) feature;
			if (op.getParameters().size() == 1) {
				String fullname = op.getSimpleName();
				if (fullname.startsWith("set") || fullname.startsWith("add")) {
					String name = Strings.toFirstLower(fullname.substring(3));
					if (name.length() > 0)
						return name;
				}
			}
		}
		return null;
	}

	public IScope getScope(EObject context, EReference reference) {
		if (reference == XpectPackage.Literals.XPECT_TEST__DECLARED_SUITE)
			return getScopeForTestClassOrSuite(EcoreUtil2.getContainerOfType(context, XpectFile.class));
		if (reference == XpectPackage.Literals.XPECT_INVOCATION__METHOD)
			return getScopeForXpectInvocationTestMethod(EcoreUtil2.getContainerOfType(context, XpectFile.class));
		if (reference == XpectPackage.Literals.ASSIGNMENT__DECLARED_TARGET)
			return getScopeForAssignmentTarget(EcoreUtil2.getContainerOfType(context, Component.class));
		if (reference == XpectPackage.Literals.COMPONENT__COMPONENT_CLASS) {
			return getScopeForComponentClass(context, reference);
		}
		return delegate.getScope(context, reference);
	}

	private IScope getScopeForAssignmentTarget(Component owner) {
		List<IEObjectDescription> descs = Lists.newArrayList();
		if (owner != null) {
			JvmDeclaredType type = ((Component) owner).getComponentClass();
			if (type != null && !type.eIsProxy())
				for (JvmFeature feature : type.getAllFeatures()) {
					String name = getAssignmentTargetFeatureName(feature);
					if (name != null)
						descs.add(EObjectDescription.create(QualifiedName.create(name), feature));
				}
		}
		return new SimpleScope(descs);
	}

	private IScope getScopeForComponentClass(EObject context, EReference reference) {
		Set<JvmDeclaredType> types = getAssignableTypes(context);
		List<IEObjectDescription> descriptions = Lists.newArrayList();
		for (JvmDeclaredType type : types)
			descriptions.add(EObjectDescription.create(QualifiedName.create(type.getSimpleName()), type));
		SimpleTypeScope typeScope = new SimpleTypeScope(typeProviderFactory.findOrCreateTypeProvider(context.eResource().getResourceSet()));
		return new SimpleScope(typeScope, descriptions);
	}

	private IScope getScopeForTestClassOrSuite(XpectFile xpectFile) {
		ResourceSet resourceSet = xpectFile.eResource().getResourceSet();
		return new SimpleTypeScope(typeProviderFactory.findOrCreateTypeProvider(resourceSet));
	}

	private IScope getScopeForXpectInvocationTestMethod(XpectFile file) {
		XpectJavaModel model = file.getJavaModel();
		if (model == null || model.eIsProxy())
			return IScope.NULLSCOPE;
		List<IEObjectDescription> descs = Lists.newArrayList();
		for (XjmTest op : model.getTests())
			for (XjmMethod method : op.getMethods())
				if (method != null)
					descs.add(EObjectDescription.create(QualifiedName.create(method.getName()), method));
		return new SimpleScope(descs);
	}

}
