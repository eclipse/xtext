/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

	protected void doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
		doVisitTypeReference(reference);
	}

	protected void doVisitUnboundTypeReference(UnboundTypeReference reference) {
		doVisitTypeReference(reference);
	}

	protected void doVisitWildcardTypeReference(WildcardTypeReference reference) {
		doVisitTypeReference(reference);
	}
	
}
