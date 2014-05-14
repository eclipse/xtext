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
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractNullLinkingCandidate implements ILinkingCandidate {

	protected final XExpression featureOrConstructorCall;

	protected AbstractNullLinkingCandidate(XExpression featureOrConstructorCall) {
		this.featureOrConstructorCall = featureOrConstructorCall;
	}
	
	public void applyToModel() {
		// no op
	}
	
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		// no op
		return true;
	}
	
	public XExpression getExpression() {
		return featureOrConstructorCall;
	}

	public JvmIdentifiableElement getFeature() {
		return null;
	}

	public List<LightweightTypeReference> getTypeArguments() {
		return Collections.emptyList();
	}
	
}
