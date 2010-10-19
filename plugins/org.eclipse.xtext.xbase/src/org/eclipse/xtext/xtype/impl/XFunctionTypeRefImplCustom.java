/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtype.impl;

import org.eclipse.xtext.common.types.JvmTypeReference;


/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XFunctionTypeRefImplCustom extends XFunctionTypeRefImpl {
	
	@Override
	public String getCanonicalName() {
		StringBuilder result = new StringBuilder("(");
		for (int i = 0;i< getParamTypes().size();i++) {
			JvmTypeReference reference = getParamTypes().get(i);
			result.append(reference.getCanonicalName());
			if (i<getParamTypes().size()-1)
				result.append(", ");
		}
		result.append(") => ");
		if (getReturnType()!=null)
			result.append(getReturnType().getCanonicalName());
		return result.toString();
	}
}
