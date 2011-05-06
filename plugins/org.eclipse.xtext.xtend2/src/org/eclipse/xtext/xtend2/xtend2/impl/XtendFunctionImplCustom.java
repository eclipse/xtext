/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.xtend2.impl;

import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendParameter;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendFunctionImplCustom extends XtendFunctionImpl {
	
	@Override
	public String getSimpleName() {
		return getName();
	}
	
	@Override
	public String getIdentifier() {
		String qn = getQualifiedName();
		if (qn == null)
			return null;
		StringBuilder builder = new StringBuilder(qn);
		builder.append('(');
		boolean first = true;
		for(XtendParameter parameter: getParameters()) {
			if (!first) {
				builder.append(',');
			} else {
				first = false;
			}
			if (parameter.getParameterType() != null && parameter.getParameterType().getType() != null)
				builder.append(parameter.getParameterType().getType().getIdentifier());
			else
				builder.append("null");
		}
		builder.append(')');
		return builder.toString();
	}
	
	@Override
	public String getQualifiedName() {
		if (!(eContainer() instanceof XtendClass))
			return getSimpleName();
		StringBuilder builder = new StringBuilder(((XtendClass)eContainer()).getIdentifier());
		builder.append(".");
		builder.append(getName());
		return builder.toString();
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return getQualifiedName();
	}

	@Override
	public String toString() {
		return EmfFormatter.objToStr(this, Xtend2Package.Literals.XTEND_FUNCTION__EXPRESSION);
	}
	
}
