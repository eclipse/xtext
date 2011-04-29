/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.generator;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DomainmodelCompiler extends XbaseCompiler {
	
	@Inject
	private IJvmModelAssociations associations;

	public String compile(Operation operation, ImportManager importManager) {
		StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable(importManager);
		registerThis(operation, appendable);
		for(JvmFormalParameter param: operation.getParams()) {
			appendable.declareVariable(param, param.getName());
		}
		return compile(operation.getBody(), appendable, operation.getType()).toString();
	}

	protected void registerThis(Operation operation, StringBuilderBasedAppendable appendable) {
		Set<EObject> elements = associations.getJvmElements(operation);
		JvmOperation jvmOp = (JvmOperation) elements.iterator().next();
		appendable.declareVariable(jvmOp.getDeclaringType(), "this");
	}
	
	@Override
	protected boolean isVariableDeclarationRequired(XExpression expr, IAppendable b) {
		if (expr instanceof XAbstractFeatureCall 
				&& ((XAbstractFeatureCall)expr).getFeature() instanceof JvmGenericType) {
			return false;
		}
		return super.isVariableDeclarationRequired(expr,b);
	}

	@Override
	protected String getVarName(Object ex, IAppendable appendable) {
		if(ex instanceof JvmGenericType) {
			return "this";
		}
		return super.getVarName(ex, appendable);
	}
}
