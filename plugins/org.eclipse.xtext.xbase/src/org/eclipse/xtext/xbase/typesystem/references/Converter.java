/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.xtype.util.AbstractXtypeReferenceVisitorWithParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Converter extends AbstractXtypeReferenceVisitorWithParameter<TypeReferenceOwner, LightweightTypeReference> {

	@Override
	public LightweightTypeReference doVisitAnyTypeReference(JvmAnyTypeReference reference, TypeReferenceOwner owner) {
		return new AnyTypeReference(owner);
	}
	
	@Override
	public LightweightTypeReference doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference,
			TypeReferenceOwner owner) {
		JvmTypeReference originalComponentType = reference.getComponentType();
		LightweightTypeReference lightweightComponentType = visit(originalComponentType, owner);
		return new ArrayTypeReference(owner, lightweightComponentType);
	}
	
	@Override
	public LightweightTypeReference doVisitMultiTypeReference(JvmMultiTypeReference reference, TypeReferenceOwner owner) {
		return doVisitCompoundReference(reference, owner, false);
	}

	protected LightweightTypeReference doVisitCompoundReference(JvmCompoundTypeReference reference,
			TypeReferenceOwner owner, boolean synonym) {
		CompoundTypeReference result = new CompoundTypeReference(owner, synonym);
		for(JvmTypeReference component: reference.getReferences()) {
			result.addComponent(visit(component, owner));
		}
		return result;
	}

	@Override
	public LightweightTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference,
			TypeReferenceOwner owner) {
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, reference.getType());
		for(JvmTypeReference argument: reference.getArguments()) {
			result.addTypeArgument(visit(argument, owner));
		}
		return result;
	}
	
	@Override
	public LightweightTypeReference doVisitSynonymTypeReference(JvmSynonymTypeReference reference,
			TypeReferenceOwner owner) {
		return doVisitCompoundReference(reference, owner, true);
	}
	
	@Override
	public LightweightTypeReference doVisitWildcardTypeReference(JvmWildcardTypeReference reference,
			TypeReferenceOwner owner) {
		WildcardTypeReference result = new WildcardTypeReference(owner);
		for(JvmTypeConstraint constraint: reference.getConstraints()) {
			if (constraint instanceof JvmUpperBound) {
				result.addUpperBound(visit(constraint.getTypeReference(), owner));
			} else {
				result.setLowerBound(visit(constraint.getTypeReference(), owner));
			}
		}
		return result;
	}
	
	@Override
	public LightweightTypeReference doVisitTypeReference(JvmTypeReference reference, TypeReferenceOwner owner) {
		throw new IllegalStateException("Did not expect: " + reference);
	}
	
	
}
