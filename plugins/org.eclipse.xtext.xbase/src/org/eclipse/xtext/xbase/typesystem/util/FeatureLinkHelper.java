/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XUnaryOperation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureLinkHelper {

	// TODO this should be part of XAbstractFeatureCall or even XExpression
	@Nullable
	public XExpression getSyntacticReceiver(@NonNull XExpression expression) {
		if (expression instanceof XAbstractFeatureCall) {
			if (expression instanceof XFeatureCall) {
				return null;
			}
			if (expression instanceof XMemberFeatureCall) {
				return ((XMemberFeatureCall) expression).getMemberCallTarget();
			}
			if (expression instanceof XAssignment) {
				return ((XAssignment) expression).getAssignable();
			}
			if (expression instanceof XBinaryOperation) {
				return ((XBinaryOperation) expression).getLeftOperand();
			}
			if (expression instanceof XUnaryOperation) {
				return ((XUnaryOperation) expression).getOperand();
			}
		}
		return null;
	}

	public List<XExpression> getSyntacticArguments(XAbstractFeatureCall expression) {
		if (expression instanceof XFeatureCall) {
			return ((XFeatureCall) expression).getFeatureCallArguments();
		}
		if (expression instanceof XMemberFeatureCall) {
			return ((XMemberFeatureCall) expression).getMemberCallArguments();
		}
		if (expression instanceof XAssignment) {
			return Collections.singletonList(((XAssignment) expression).getValue());
		}
		if (expression instanceof XBinaryOperation) {
			return Collections.singletonList(((XBinaryOperation) expression).getRightOperand());
		}
		// explicit condition to make sure we thought about it
		if (expression instanceof XUnaryOperation) {
			return Collections.emptyList();
		}
		return Collections.emptyList();
	}
	
}
