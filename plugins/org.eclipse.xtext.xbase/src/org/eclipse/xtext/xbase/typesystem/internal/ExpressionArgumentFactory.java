/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.arguments.AssignmentFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.arguments.ReorderedFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.arguments.ReorderedVarArgFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.arguments.StandardFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.arguments.VarArgFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

import com.google.common.collect.Lists;

/**
 * Externalized for testing purpose.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ExpressionArgumentFactory {

	public IFeatureCallArguments createExpressionArguments(XExpression expression, AbstractLinkingCandidate<?> candidate) {
		JvmIdentifiableElement feature = candidate.getFeature();
		if (feature instanceof JvmExecutable) {
			JvmExecutable executable = (JvmExecutable) feature;
			return createArgumentsForExecutable(executable.isVarArgs(), candidate.getArguments(), executable.getParameters(), candidate.hasReceiver(), candidate.getState().getConverter());
		} else {
			if (expression instanceof XAssignment) {
				XAssignment assignment = (XAssignment) expression;
				LightweightTypeReference featureType = candidate.getActualType(candidate.getFeature(), true);
				return new AssignmentFeatureCallArguments(assignment.getValue(), featureType);
			} else {
				return new StandardFeatureCallArguments(candidate.getArguments(), Collections.<JvmFormalParameter>emptyList(), candidate.hasReceiver(), candidate.getState().getConverter());
			}
		}
	}

	protected IFeatureCallArguments createArgumentsForExecutable(boolean varArgs, List<XExpression> arguments, List<JvmFormalParameter> parameters, boolean hasReceiver, OwnedConverter converter) {
		if (!varArgs) {
			if (requiresReordering(arguments, parameters.size())) {
				List<XExpression> copiedArgumentList = Lists.newArrayList(arguments);
				List<JvmFormalParameter> copiedParameterList = Lists.newArrayList(parameters);
				List<XExpression> shiftedArgumentList = Lists.newArrayListWithCapacity(2);
				List<JvmFormalParameter> shiftedParameterList = Lists.newArrayListWithCapacity(2);
				reorder(varArgs, copiedArgumentList, copiedParameterList, shiftedArgumentList, shiftedParameterList);
				return new ReorderedFeatureCallArguments(copiedArgumentList, copiedParameterList, shiftedArgumentList, shiftedParameterList, hasReceiver, converter);
			}
			return new StandardFeatureCallArguments(arguments, parameters, hasReceiver, converter);
		} else {
			if (requiresReordering(arguments, parameters.size())) {
				List<XExpression> copiedArgumentList = Lists.newArrayList(arguments);
				List<JvmFormalParameter> copiedParameterList = Lists.newArrayList(parameters);
				List<XExpression> shiftedArgumentList = Lists.newArrayListWithCapacity(2);
				List<JvmFormalParameter> shiftedParameterList = Lists.newArrayListWithCapacity(2);
				reorder(varArgs, copiedArgumentList, copiedParameterList, shiftedArgumentList, shiftedParameterList);
				return new ReorderedVarArgFeatureCallArguments(copiedArgumentList, copiedParameterList, shiftedArgumentList, shiftedParameterList, hasReceiver, converter);
			}
			return new VarArgFeatureCallArguments(arguments, parameters, hasReceiver, converter);
		}
	}

	protected void reorder(boolean varArgs, List<XExpression> copiedArgumentList, List<JvmFormalParameter> copiedParameterList,
			List<XExpression> shiftedArgumentList, List<JvmFormalParameter> shiftedParameterList) {
		int max = Math.min(copiedArgumentList.size(), copiedParameterList.size());
		if (varArgs && copiedArgumentList.size() >= copiedParameterList.size())
			max = max - 1;
		for(int i = 0; i < max; i++) {
			XExpression expression = copiedArgumentList.get(i);
			if (expression instanceof XClosure) {
				shiftedArgumentList.add(expression);
				shiftedParameterList.add(copiedParameterList.get(i));
			}
		}
		copiedArgumentList.removeAll(shiftedArgumentList);
		copiedParameterList.removeAll(shiftedParameterList);
	}

	protected boolean requiresReordering(List<XExpression> arguments, int parameterCount) {
		boolean lambdaSeen = false;
		for(int i = 0; i < arguments.size() && i < parameterCount; i++) {
			if (arguments.get(i) instanceof XClosure) {
				lambdaSeen = true;
			} else if (lambdaSeen) {
				return true;
			}
		}
		return false;
	}

}
