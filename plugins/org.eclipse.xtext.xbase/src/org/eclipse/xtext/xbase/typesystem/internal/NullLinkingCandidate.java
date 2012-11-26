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
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class NullLinkingCandidate implements IFeatureLinkingCandidate, IConstructorLinkingCandidate {

	private XExpression featureOrConstructorCall;

	public NullLinkingCandidate(XAbstractFeatureCall featureCall) {
		this.featureOrConstructorCall = featureCall;
	}
	public NullLinkingCandidate(XConstructorCall constructorCall) {
		this.featureOrConstructorCall = constructorCall;
	}
	
	public void apply() {
		// no op
	}

	public void resolveLinkingProxy() {
		// no op
	}

	public boolean isPreferredOver(ILinkingCandidate other) {
		return false;
	}

	public JvmIdentifiableElement getFeature() {
		throw new UnsupportedOperationException();
	}

	public List<LightweightTypeReference> getTypeArguments() {
		return Collections.emptyList();
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

	public XConstructorCall getConstructorCall() {
		return (XConstructorCall) featureOrConstructorCall;
	}

	public JvmConstructor getConstructor() {
		throw new UnsupportedOperationException();
	}

}
