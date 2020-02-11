/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.ExpectationTypeParameterHintCollector;

/**
 * If this collector encounters an unbound type reference that was already resolved
 * internally or transitively, it'll use the resolved version of that reference.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResolvingTypeParameterHintCollector extends ExpectationTypeParameterHintCollector {
	private final BoundTypeArgumentSource source;

	public ResolvingTypeParameterHintCollector(ITypeReferenceOwner owner, BoundTypeArgumentSource source) {
		super(owner);
		this.source = source;
	}

	protected class UnboundParameterizedTypeReferencePreserver extends DeferredParameterizedTypeReferenceTraverser {
		@Override
		public void doVisitUnboundTypeReference(UnboundTypeReference reference,
				ParameterizedTypeReference declaration) {
			if (reference.internalIsResolved() || getOwner().isResolved(reference.getHandle())) {
				reference.tryResolve();
				outerVisit(reference, declaration);
			} else {
				addHint(reference, declaration);
			}
		}
	}

	protected class UnboundArrayTypeReferencePreserver extends DeferredArrayTypeReferenceTraverser {
		@Override
		public void doVisitUnboundTypeReference(UnboundTypeReference reference,
				ArrayTypeReference declaration) {
			if (reference.internalIsResolved() || getOwner().isResolved(reference.getHandle())) {
				reference.tryResolve();
				outerVisit(reference, declaration);
			} else {
				addHint(reference, declaration);
			}
		}
	}
	
	@Override
	protected BoundTypeArgumentSource getTypeArgumentSource() {
		return source;
	}

	@Override
	protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
		return new UnboundParameterizedTypeReferencePreserver();
	}

	@Override
	protected ArrayTypeReferenceTraverser createArrayTypeReferenceTraverser() {
		return new UnboundArrayTypeReferencePreserver();
	}
}