/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import java.util.List;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;

public class JvmWildcardTypeReferenceImplCustom extends JvmWildcardTypeReferenceImpl {
	static void appendConstraintsCanonicalName(StringBuilder result, List<JvmTypeConstraint> constraints) {
		if (constraints == null || constraints.isEmpty())
			return;
		int wasLength = result.length();
		for (JvmTypeConstraint constraint : constraints) {
			if (result.length() != wasLength)
				result.append(" & ");
			result.append(constraint.getCanonicalName());
		}
	}

	@Override
	public String getCanonicalName() {
		if (constraints != null && !constraints.isEmpty()) {
			StringBuilder mutableResult = new StringBuilder(64);
			mutableResult.append("? ");
			appendConstraintsCanonicalName(mutableResult, constraints);
			return mutableResult.toString();
		}
		return "?";
	}
	
	@Override
	public JvmType getType() {
		return null;
	}

}
