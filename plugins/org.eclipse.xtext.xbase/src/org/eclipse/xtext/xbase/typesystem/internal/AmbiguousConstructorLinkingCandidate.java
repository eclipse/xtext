/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class AmbiguousConstructorLinkingCandidate extends AbstractAmbiguousLinkingCandidate<ConstructorLinkingCandidate> implements IConstructorLinkingCandidate {

	protected AmbiguousConstructorLinkingCandidate(ConstructorLinkingCandidate first, AbstractPendingLinkingCandidate<?> second) {
		super(first, second);
	}
	
	@Override
	protected String getSyntaxDescriptions() {
		return "constructor call";
	}

	public XConstructorCall getConstructorCall() {
		return getPrimaryCandidate().getConstructorCall();
	}

	@Nullable
	public JvmConstructor getConstructor() {
		return getPrimaryCandidate().getConstructor();
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
