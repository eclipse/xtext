/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.featurecalls;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XVariableDeclaration;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IdentifiableSimpleNameProvider {
	
	public @Nullable String getSimpleName(JvmIdentifiableElement element) {
		if (element == null || element.eIsProxy()) {
			return null;
		}
		if (element instanceof JvmFeature) {
			return ((JvmFeature) element).getSimpleName();
		}
		if (element instanceof JvmFormalParameter) {
			return ((JvmFormalParameter) element).getName();
		}
		if (element instanceof XVariableDeclaration) {
			return ((XVariableDeclaration) element).getName();
		}
		return element.getSimpleName();
	}
}
