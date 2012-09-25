/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureLinkHelper {

	public XExpression getReceiver(XExpression expression) {
		if (expression instanceof XAbstractFeatureCall) {
			XAbstractFeatureCall casted = (XAbstractFeatureCall) expression;
			if (casted.getImplicitReceiver() != null)
				return casted.getImplicitReceiver();
//			if (isStatic(identifiable))
//				return null;
			if (expression instanceof XMemberFeatureCall)
				return ((XMemberFeatureCall) expression).getMemberCallTarget();
			if (expression instanceof XBinaryOperation)
				return ((XBinaryOperation) expression).getLeftOperand();
			if (expression instanceof XAssignment) {
				return ((XAssignment) expression).getAssignable();
			}
		}
		return null;
	}
	
	public boolean isStatic(JvmIdentifiableElement identifiable) {
		if (identifiable instanceof JvmField)
			return ((JvmField) identifiable).isStatic();
		if (identifiable instanceof JvmOperation)
			return ((JvmOperation) identifiable).isStatic();
		return false;
	}
	
}
