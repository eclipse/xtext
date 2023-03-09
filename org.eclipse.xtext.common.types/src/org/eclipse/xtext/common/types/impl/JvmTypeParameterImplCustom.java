/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmTypeParameterImplCustom extends JvmTypeParameterImpl {
	
	@Override
	public String getIdentifier() {
		return name;
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return name;
	}
	
	@Override
	public String getSimpleName() {
		return name;
	}
	
	@Override
	public String toString() {
		EObject container = eContainer();
		if (container instanceof JvmIdentifiableElement) {
			StringBuilder result = new StringBuilder(eClass().getName());
			result.append(" <");
			result.append(name);
			result.append("> ");
			result.append(((JvmIdentifiableElement) container).getQualifiedName());
			return result.toString();
		} else {
			StringBuilder result = new StringBuilder(eClass().getName());
			result.append(" <");
			result.append(name);
			result.append(">");
			if (constraints != null) {
				result.append(constraints);
			}
			return result.toString();
		}
	}

}
