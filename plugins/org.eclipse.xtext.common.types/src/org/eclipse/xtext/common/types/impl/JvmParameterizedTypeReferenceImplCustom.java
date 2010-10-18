/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import java.util.List;

import org.eclipse.xtext.common.types.JvmTypeArgument;

public class JvmParameterizedTypeReferenceImplCustom extends JvmParameterizedTypeReferenceImpl {

	@Override
	public String getCanonicalName() {
		if (type == null)
			return null;
		String result = getType().getCanonicalName();
		if (arguments != null && !arguments.isEmpty()) {
			StringBuilder mutableResult = new StringBuilder(result);
			mutableResult.append("<");
			appendCanonicalArguments(mutableResult, arguments);
			mutableResult.append(">");
			return mutableResult.toString();
		}
		return result;
	}

	void appendCanonicalArguments(StringBuilder result, List<JvmTypeArgument> arguments) {
		if (arguments == null || arguments.isEmpty())
			return;
		int wasLength = result.length();
		for (JvmTypeArgument argument : arguments) {
			if (result.length() != wasLength)
				result.append(",");
			result.append(argument.getCanonicalName());
		}
	}

}
