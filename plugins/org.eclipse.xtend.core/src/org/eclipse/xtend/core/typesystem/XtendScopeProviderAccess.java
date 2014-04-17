/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.typesystem;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.AnonymousClassConstructorCall;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.internal.ScopeProviderAccess;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendScopeProviderAccess extends ScopeProviderAccess {
	
	@Inject
	private IXtendJvmAssociations associations;

	@Override
	protected String getNameToLookup(XExpression expression, EReference reference, INode node) {
		if(expression instanceof AnonymousClassConstructorCall) {
			JvmGenericType inferredType = associations.getInferredType(((AnonymousClassConstructorCall) expression).getAnonymousClass());
			if(inferredType != null)
				return inferredType.getSimpleName();
		}
		return super.getNameToLookup(expression, reference, node);
	}
}
