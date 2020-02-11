/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
	
	@Override
	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		return other;
	}
	
	@Override
	public XAbstractFeatureCall getFeatureCall() {
		return (XAbstractFeatureCall) featureOrConstructorCall;
	}

	@Override
	public boolean isStatic() {
		return false;
	}

	@Override
	public boolean isExtension() {
		return false;
	}
	
	@Override
	public boolean isTypeLiteral() {
		return false;
	}
	
	@Override
	public void applyToComputationState() {
		FeatureLinkHelper helper = new FeatureLinkHelper();
		XExpression receiver = helper.getSyntacticReceiver(getFeatureCall());
		state.withNonVoidExpectation().computeTypes(receiver);
		for(XExpression argument: helper.getSyntacticArguments(getFeatureCall())) {
			state.withNonVoidExpectation().computeTypes(argument);
		}
	}

}
