/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AmbiguousConstructorLinkingCandidate extends AbstractAmbiguousLinkingCandidate<ConstructorLinkingCandidate> implements IConstructorLinkingCandidate {

	protected AmbiguousConstructorLinkingCandidate(ConstructorLinkingCandidate first, AbstractPendingLinkingCandidate<?> second) {
		super(first, second);
	}
	
	@Override
	protected String getSyntaxDescriptions() {
		return "constructor call";
	}

	@Override
	public XConstructorCall getConstructorCall() {
		return getPrimaryCandidate().getConstructorCall();
	}

	/* @Nullable */
	@Override
	public JvmConstructor getConstructor() {
		return getPrimaryCandidate().getConstructor();
	}
	
	@Override
	public boolean isAnonymousClassConstructorCall() {
		return getPrimaryCandidate().isAnonymousClassConstructorCall();
	}
	
	@Override
	protected EStructuralFeature getFeatureToMark() {
		return XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR;
	}

	@Override
	protected String[] getDiagnosticData() {
		return null;
	}
	
}
