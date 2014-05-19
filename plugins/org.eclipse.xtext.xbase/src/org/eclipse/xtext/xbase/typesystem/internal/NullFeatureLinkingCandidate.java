/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NullFeatureLinkingCandidate extends AbstractNullLinkingCandidate implements IFeatureLinkingCandidate {

	private AbstractTypeComputationState state;

	public NullFeatureLinkingCandidate(XAbstractFeatureCall featureCall, AbstractTypeComputationState state) {
		super(featureCall);
		this.state = state;
	}
	
	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		return other;
	}
	
	public XAbstractFeatureCall getFeatureCall() {
		return (XAbstractFeatureCall) featureOrConstructorCall;
	}

	public boolean isStatic() {
		return false;
	}

	public boolean isExtension() {
		return false;
	}
	
	public boolean isTypeLiteral() {
		return false;
	}
	
	public void applyToComputationState() {
		FeatureLinkHelper helper = new FeatureLinkHelper();
		XExpression receiver = helper.getSyntacticReceiver(getFeatureCall());
		state.withNonVoidExpectation().computeTypes(receiver);
		for(XExpression argument: helper.getSyntacticArguments(getFeatureCall())) {
			state.withNonVoidExpectation().computeTypes(argument);
		}
	}

}
