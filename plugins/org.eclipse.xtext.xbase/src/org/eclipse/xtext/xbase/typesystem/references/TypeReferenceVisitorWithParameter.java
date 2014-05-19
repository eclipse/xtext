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
public abstract class TypeReferenceVisitorWithParameter<Param> {

	protected void doVisitTypeReference(LightweightTypeReference reference, Param param) {
		throw new UnsupportedOperationException("Missing implementation for " + reference);
	}
	
	protected void doVisitAnyTypeReference(AnyTypeReference reference, Param param) {
		doVisitTypeReference(reference, param);
	}
	
	protected void doVisitUnknownTypeReference(UnknownTypeReference reference, Param param) {
		doVisitTypeReference(reference, param);
	}
	
	protected void doVisitCompoundTypeReference(CompoundTypeReference reference, Param param) {
		List<LightweightTypeReference> components = reference.getMultiTypeComponents();
		if (components.isEmpty())
			doVisitTypeReference(reference, param);
		else
			for (LightweightTypeReference component: components) {
				component.accept(this, param);
			}
	}
	
	protected void doVisitMultiTypeReference(CompoundTypeReference reference, Param param) {
		doVisitCompoundTypeReference(reference, param);
	}
	
	protected void doVisitSynonymTypeReference(CompoundTypeReference reference, Param param) {
		doVisitCompoundTypeReference(reference, param);
	}

	protected void doVisitArrayTypeReference(ArrayTypeReference reference, Param param) {
		doVisitTypeReference(reference, param);
	}

	protected void doVisitFunctionTypeReference(FunctionTypeReference reference, Param param) {
		doVisitParameterizedTypeReference(reference, param);
	}

	protected void doVisitParameterizedTypeReference(ParameterizedTypeReference reference, Param param) {
		doVisitTypeReference(reference, param);
	}

	protected void doVisitUnboundTypeReference(UnboundTypeReference reference, Param param) {
		doVisitTypeReference(reference, param);
	}

	protected void doVisitWildcardTypeReference(WildcardTypeReference reference, Param param) {
		doVisitTypeReference(reference, param);
	}
	
}
