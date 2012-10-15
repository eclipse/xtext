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
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.util.AbstractXtypeReferenceVisitor;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OwnedConverter extends AbstractXtypeReferenceVisitor<LightweightTypeReference> implements Function<JvmTypeReference, LightweightTypeReference> {

	private final ITypeReferenceOwner owner;

	public OwnedConverter(ITypeReferenceOwner owner) {
		this.owner = Preconditions.checkNotNull(owner, "owner");
	}
	
	public ITypeReferenceOwner getOwner() {
		return owner;
	}
	
	public LightweightTypeReference toLightweightReference(JvmTypeReference reference) {
		return visit(reference);
	}

	public LightweightTypeReference apply(JvmTypeReference reference) {
		return toLightweightReference(reference);
	}

	@Override
	public LightweightTypeReference doVisitAnyTypeReference(JvmAnyTypeReference reference) {
		return new AnyTypeReference(owner);
	}
	
	@Override
	public LightweightTypeReference doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference) {
		JvmTypeReference originalComponentType = reference.getComponentType();
		LightweightTypeReference lightweightComponentType = visit(originalComponentType);
		return new ArrayTypeReference(owner, lightweightComponentType);
	}
	
	@Override
	public LightweightTypeReference doVisitMultiTypeReference(JvmMultiTypeReference reference) {
		return doVisitCompoundReference(reference, false);
	}

	protected LightweightTypeReference doVisitCompoundReference(JvmCompoundTypeReference reference,
			boolean synonym) {
		CompoundTypeReference result = new CompoundTypeReference(owner, synonym);
		for(JvmTypeReference component: reference.getReferences()) {
			result.addComponent(visit(component));
		}
		return result;
	}
	
	@Override
	public LightweightTypeReference doVisitComputedTypeReference(XComputedTypeReference reference) {
		IJvmTypeReferenceProvider typeProvider = reference.getTypeProvider();
		if (typeProvider instanceof UnboundTypeReferenceResolver) {
			UnboundTypeReference typeReference = ((UnboundTypeReferenceResolver) typeProvider).getUnboundTypeReference();
			return typeReference.copyInto(owner);
		}
		JvmTypeReference equivalent = reference.getEquivalent();
		if (equivalent == null)
			return null;
		return super.doVisitComputedTypeReference(reference);
	}

	@Override
	public LightweightTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, reference.getType());
		for(JvmTypeReference argument: reference.getArguments()) {
			result.addTypeArgument(visit(argument));
		}
		return result;
	}
	
	@Override
	public LightweightTypeReference doVisitSynonymTypeReference(JvmSynonymTypeReference reference) {
		return doVisitCompoundReference(reference, true);
	}
	
	@Override
	public LightweightTypeReference doVisitWildcardTypeReference(JvmWildcardTypeReference reference) {
		WildcardTypeReference result = new WildcardTypeReference(owner);
		boolean upperBoundSeen = false;
		for(JvmTypeConstraint constraint: reference.getConstraints()) {
			if (constraint instanceof JvmUpperBound) {
				upperBoundSeen = true;
				result.addUpperBound(visit(constraint.getTypeReference()));
			} else {
				result.setLowerBound(visit(constraint.getTypeReference()));
			}
		}
		if (!upperBoundSeen) {
			JvmType objectType = owner.getServices().getTypeReferences().findDeclaredType(Object.class, reference);
			ParameterizedTypeReference upperBound = new ParameterizedTypeReference(owner, objectType);
			result.addUpperBound(upperBound);
		}
		return result;
	}
	
	@Override
	public LightweightTypeReference doVisitFunctionTypeReference(XFunctionTypeRef reference) {
		FunctionTypeReference result = new FunctionTypeReference(owner, reference.getType());
		JvmTypeReference equivalent = reference.getEquivalent();
		if (equivalent instanceof JvmParameterizedTypeReference) {
			for(JvmTypeReference argument: ((JvmParameterizedTypeReference)equivalent).getArguments()) {
				result.addTypeArgument(visit(argument));
			}
		}
		for(JvmTypeReference parameter: reference.getParamTypes()) {
			result.addParameterType(visit(parameter));
		}
		if (reference.getReturnType() != null) {
			result.setReturnType(visit(reference.getReturnType()));
		}
		return result;
	}
	
	@Override
	public LightweightTypeReference doVisitTypeReference(JvmTypeReference reference) {
		throw new IllegalStateException("Did not expect: " + reference);
	}
	
}

