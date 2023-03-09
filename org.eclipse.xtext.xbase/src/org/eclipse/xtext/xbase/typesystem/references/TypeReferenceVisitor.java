/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class TypeReferenceVisitor {

	protected void doVisitTypeReference(LightweightTypeReference reference) {
		throw new UnsupportedOperationException("Missing implementation for " + reference);
	}
	
	protected void doVisitAnyTypeReference(AnyTypeReference reference) {
		doVisitTypeReference(reference);
	}
	
	protected void doVisitUnknownTypeReference(UnknownTypeReference reference) {
		doVisitTypeReference(reference);
	}
	
	protected void doVisitCompoundTypeReference(CompoundTypeReference reference) {
		List<LightweightTypeReference> components = reference.getMultiTypeComponents();
		if (components.isEmpty())
			doVisitTypeReference(reference);
		else
			for (LightweightTypeReference component: components) {
				component.accept(this);
			}
	}
	
	protected void doVisitMultiTypeReference(CompoundTypeReference reference) {
		doVisitCompoundTypeReference(reference);
	}
	
	protected void doVisitSynonymTypeReference(CompoundTypeReference reference) {
		doVisitCompoundTypeReference(reference);
	}

	protected void doVisitArrayTypeReference(ArrayTypeReference reference) {
		doVisitTypeReference(reference);
	}

	protected void doVisitFunctionTypeReference(FunctionTypeReference reference) {
		doVisitParameterizedTypeReference(reference);
	}
	
	protected void doVisitInnerFunctionTypeReference(InnerFunctionTypeReference reference) {
		doVisitFunctionTypeReference(reference);
	}

	protected void doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
		doVisitTypeReference(reference);
	}
	
	protected void doVisitInnerTypeReference(InnerTypeReference reference) {
		doVisitParameterizedTypeReference(reference);
	}

	protected void doVisitUnboundTypeReference(UnboundTypeReference reference) {
		doVisitTypeReference(reference);
	}

	protected void doVisitWildcardTypeReference(WildcardTypeReference reference) {
		doVisitTypeReference(reference);
	}
	
}
