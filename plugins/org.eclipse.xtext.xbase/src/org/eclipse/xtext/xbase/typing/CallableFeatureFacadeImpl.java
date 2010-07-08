/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xpression.XVariableDeclaration;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CallableFeatureFacadeImpl implements ICallableFeatureFacade {

	public boolean isCallableFeature(EObject eobject) {
		return eobject instanceof JvmFeature || eobject instanceof XVariableDeclaration || eobject instanceof JvmFormalParameter;
	}

	public String getFeatureName(EObject eobject) {
		if (eobject instanceof JvmFeature) {
			return ((JvmFeature)eobject).getSimpleName();
		} else if (eobject instanceof JvmFormalParameter) {
			return ((JvmFormalParameter)eobject).getName();
		} else if (eobject instanceof XVariableDeclaration) {
			return ((XVariableDeclaration) eobject).getName();
		}
		return null;
	}

	public JvmTypeReference getReturnType(EObject eobject) {
		if (eobject instanceof JvmField) {
			return ((JvmField)eobject).getType();
		} else if (eobject instanceof JvmOperation) {
			return ((JvmOperation) eobject).getReturnType();
		} else if (eobject instanceof JvmFormalParameter) {
			return ((JvmFormalParameter)eobject).getParameterType();
		} else if (eobject instanceof XVariableDeclaration) {
			return ((XVariableDeclaration) eobject).getDerivedReturnType();
		}
		return null;
	}

}
