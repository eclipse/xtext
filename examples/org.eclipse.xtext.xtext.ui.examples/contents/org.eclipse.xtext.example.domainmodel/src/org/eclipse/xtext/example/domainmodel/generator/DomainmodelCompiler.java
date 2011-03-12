/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.generator;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DomainmodelCompiler extends XbaseCompiler {

	public String compile(Operation operation, ImportManager importManager) {
		StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable(importManager);
		for(JvmFormalParameter param: operation.getParams()) {
			appendable.declareVariable(param, param.getName());
		}
		compile(operation.getBody(), appendable, operation.getType());
		return appendable.toString();
	}
	
	@Override
	protected boolean isVariableDeclarationRequired(XExpression expr) {
		if (expr instanceof XAbstractFeatureCall 
				&& ((XAbstractFeatureCall)expr).getFeature() instanceof JvmGenericType) {
			return false;
		}
		return super.isVariableDeclarationRequired(expr);
	}

	@Override
	protected String getJavaVarName(Object ex, IAppendable appendable) {
		if(ex instanceof JvmGenericType) {
			return "this";
		}
		return super.getJavaVarName(ex, appendable);
	}
}
