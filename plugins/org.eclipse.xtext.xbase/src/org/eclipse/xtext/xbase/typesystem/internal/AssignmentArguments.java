/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class AssignmentArguments implements IFeatureCallArguments {

	private LightweightTypeReference declaredType;
	private XExpression value;
	private boolean unprocessed = true;
	
	public AssignmentArguments(AbstractLinkingCandidate<? extends XExpression> candidate) {
		XAssignment assignment = (XAssignment) candidate.getExpression();
		declaredType = candidate.getActualType(candidate.getFeature());
		value = assignment.getValue();
	}

	public LightweightTypeReference getDeclaredType(int argumentIndex) {
		return declaredType;
	}

	public int getFixedArityArgumentCount() {
		return 1;
	}

	public boolean isVarArgs() {
		return false;
	}

	public boolean isExactArity() {
		return false;
	}

	public int getArgumentSize() {
		return value != null ? 1 : 0;
	}

	public ArrayTypeReference getVarArgType() {
		throw new UnsupportedOperationException();
	}

	public boolean hasUnprocessedArguments() {
		return value != null && unprocessed; 
	}

	public int getNextUnprocessedNextArgument() {
		return unprocessed ? 0 : 1;
	}

	public boolean isProcessed(int argumentIndex) {
		return !unprocessed;
	}

	public XExpression getArgument(int argumentIndex) {
		return value;
	}

	public void markProcessed(int argumentIndex) {
		unprocessed = false;
	}

}
