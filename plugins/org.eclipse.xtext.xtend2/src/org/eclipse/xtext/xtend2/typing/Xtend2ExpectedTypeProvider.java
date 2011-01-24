/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.typing;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.xbase.typing.XExpressionExpectedTypeProvider;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Xtend2ExpectedTypeProvider extends XExpressionExpectedTypeProvider {

	protected JvmTypeReference _expectedType(XtendFunction function, EReference reference, int index) {
		if (reference==Xtend2Package.Literals.XTEND_FUNCTION__EXPRESSION) {
			if (function.getReturnType()==null || function.getReturnType().getType() instanceof JvmVoid)
				return null;
			return function.getReturnType();
		}
		return null;
	}
}
