/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;

import com.google.common.base.Joiner;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XClosureImplCustom extends XClosureImpl {

	private boolean linked;

	@Override
	public String toString() {
		String expressionAsString = Strings.emptyIfNull(expression == null ? null : expression.toString());
		if (isExplicitSyntax()) {
			return String.format("[%s | %s ]", Joiner.on(", ").join(getFormalParameters()), expressionAsString);
		} else {
			return String.format("[ %s ]", expressionAsString);
		}
	}
	
	@Override
	public EList<JvmFormalParameter> getFormalParameters() {
		if (isExplicitSyntax()) {
			return getDeclaredFormalParameters();
		}
		ensureLinked();
		return getImplicitFormalParameters();
	}

	private void ensureLinked() {
		if (!linked) {
			Resource resource = eResource();
			if (resource != null) {
				if (resource instanceof BatchLinkableResource) {
					((BatchLinkableResource) resource).resolveLazyCrossReferences(null);
				} else {
					EcoreUtil.resolveAll(resource);
				}
				linked = true;
			}
		}
	}

	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case XbasePackage.XCLOSURE__DECLARED_FORMAL_PARAMETERS:
				linked = false;
				getDeclaredFormalParameters().clear();
				return;
		}
		super.eUnset(featureID);
	}
	
	/**
	 * Sets the closure's expression.
	 * ATTENTION! Also sets an implicit receiver if {@link #isExplicitSyntax()} wasn't set to true.
	 * This is based on the assumption that a closure is constructed by the xbase parser and that the syntax is such that
	 * the explicit parameter list is set before the expression is set.
	 * 
	 * Doing it like this is much simpler and also ensures proper notifications.
	 */
	@Override
	public void setExpression(XExpression newExpression) {
		super.setExpression(newExpression);
		/**
		 * Add the implicit parameter for the short cut syntax [ my-expression-using-it ]
		 */
		if (!isExplicitSyntax()) {
			JvmFormalParameter implicitParameter = TypesFactory.eINSTANCE.createJvmFormalParameter();
			implicitParameter.setName(IFeatureNames.IT.toString());
			getImplicitFormalParameters().add(implicitParameter);
		}
	}

}
