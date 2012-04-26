/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.featurecalls.IValidatedEObjectDescription;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class FeatureLinkingCandidate implements IFeatureLinkingCandidate {

	private final XAbstractFeatureCall featureCall;
	private final IValidatedEObjectDescription description;
	private final AbstractTypeComputationState state;

	public FeatureLinkingCandidate(XAbstractFeatureCall featureCall, IValidatedEObjectDescription description,
			AbstractTypeComputationState state) {
		this.featureCall = featureCall;
		this.description = description;
		this.state = state;
	}


	public void apply() {
		state.getTypeResolution().setLinkingInformation(featureCall, this);
		List<ITypeExpectation> expectations = state.getImmediateExpectations();
		for(ITypeExpectation expectation: expectations) {
			// TODO implement bounds / type parameter resolution
			JvmIdentifiableElement feature = getFeature();
			JvmTypeReference featureType = state.getType(feature);
			if (featureType == null) {
				if (feature instanceof JvmOperation) {
					 featureType = ((JvmOperation) feature).getReturnType();
				} else if (feature instanceof JvmConstructor) {
					featureType = state.getTypeReferences().getTypeForName(Void.TYPE, featureCall);
				} else if (feature instanceof JvmField) {
					featureType = ((JvmField) feature).getType();
				}
			}
			expectation.acceptActualType(featureType, ConformanceHint.UNCHECKED);
		}
	}

	public JvmIdentifiableElement getFeature() {
		return description.getEObjectOrProxy();
	}

	public List<XExpression> getArguments() {
		// TODO implement me
		return featureCall.getExplicitArguments();
	}

	public XAbstractFeatureCall getFeatureCall() {
		return featureCall;
	}

}
