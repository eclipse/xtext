/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class NullFeatureLinkingCandidate extends AbstractNullLinkingCandidate<IFeatureLinkingCandidate> implements IFeatureLinkingCandidate {

	public NullFeatureLinkingCandidate(XAbstractFeatureCall featureCall) {
		super(featureCall);
	}
	
	public IFeatureLinkingCandidate getPreferredCandidate(IFeatureLinkingCandidate other) {
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

}
