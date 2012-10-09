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
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XUnaryOperation;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureLinkHelper {

	// TODO this should be part of XAbstractFeatureCall or even XExpression
	@Nullable
	public XExpression getReceiver(@NonNull XExpression expression) {
		if (expression instanceof XAbstractFeatureCall) {
			XAbstractFeatureCall casted = (XAbstractFeatureCall) expression;
			if (casted.getImplicitReceiver() != null)
				return casted.getImplicitReceiver();
			if (isStatic(((XAbstractFeatureCall) expression).getFeature()))
				return null;
			return getSyntacticReceiver(expression);
		}
		return null;
	}
	
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

	// TODO this should be part of JvmFeature
	public boolean isStatic(JvmIdentifiableElement identifiable) {
		if (identifiable instanceof JvmField)
			return ((JvmField) identifiable).isStatic();
		if (identifiable instanceof JvmOperation)
			return ((JvmOperation) identifiable).isStatic();
		return false;
	}

	public List<XExpression> getArguments(XAbstractFeatureCall expression) {
		boolean isStatic = isStatic(expression.getFeature());
		XExpression syntacticReceiver = getSyntacticReceiver(expression);
		List<XExpression> syntacticArguments = getSyntacticArguments(expression);
		if (isStatic) {
			if (syntacticReceiver != null) {
				return createArgumentList(syntacticReceiver, syntacticArguments);
			}
			XExpression implicitFirstArgument = expression.getImplicitFirstArgument();
			if (implicitFirstArgument != null) {
				return createArgumentList(implicitFirstArgument, syntacticArguments);
			}
		} else {
			XExpression implicitReceiver = expression.getImplicitReceiver();
			if (implicitReceiver != null && syntacticReceiver != null) {
				return createArgumentList(syntacticReceiver, syntacticArguments);
			}
			XExpression implicitFirstArgument = expression.getImplicitFirstArgument();
			if (implicitFirstArgument != null) {
				return createArgumentList(implicitFirstArgument, syntacticArguments);
			}
		}
		return syntacticArguments;
	}
	
	protected List<XExpression> createArgumentList(XExpression head, List<XExpression> tail) {
		// TODO investigate in optimized List impls like HEAD, syntacticArguments
		List<XExpression> result = Lists.newArrayListWithExpectedSize(tail.size() + 1);
		result.add(head);
		result.addAll(tail);
		return result;
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
