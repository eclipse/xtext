/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XClosureImplCustom extends XClosureImpl {

	@Override
	public EList<JvmFormalParameter> getFormalParameters() {
		EList<JvmFormalParameter> parameters = getDeclaredFormalParameters();
		if (expression != null && parameters.isEmpty() && !isExplicitSyntax()) {
			BasicEList<JvmFormalParameter> result = new BasicEList<JvmFormalParameter>(1);
			result.add(getImplicitParameter());
			return result;
		}
		return parameters;
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
			super.setImplicitParameter(implicitParameter);
		}
	}
	
}
