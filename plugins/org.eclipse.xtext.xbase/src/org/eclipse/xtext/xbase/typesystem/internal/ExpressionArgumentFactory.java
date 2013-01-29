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
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.arguments.AssignmentFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.arguments.StandardFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.arguments.VarArgFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

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
				return new AssignmentFeatureCallArguments(assignment.getValue(), candidate.getActualType(candidate.getFeature()));
			} else {
				return new StandardFeatureCallArguments(candidate.getArguments(), Collections.<JvmFormalParameter>emptyList(), candidate.hasReceiver(), candidate.getState().getConverter());
			}
		}
	}

	protected IFeatureCallArguments createArgumentsForExecutable(boolean varArgs, List<XExpression> arguments, List<JvmFormalParameter> parameters, boolean hasReceiver, OwnedConverter converter) {
		if (!varArgs) {
			return new StandardFeatureCallArguments(arguments, parameters, hasReceiver, converter);
		} else {
			return new VarArgFeatureCallArguments(arguments, parameters, hasReceiver, converter);
		}
	}

}
