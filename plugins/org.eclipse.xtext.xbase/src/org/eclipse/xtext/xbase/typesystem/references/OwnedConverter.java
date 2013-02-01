/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.util.AbstractXtypeReferenceVisitor;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OwnedConverter extends AbstractXtypeReferenceVisitor<LightweightTypeReference> implements Function<JvmTypeReference, LightweightTypeReference> {

	private final ITypeReferenceOwner owner;
	private final boolean keepUnboundWildcards;

	/**
.	 * Creates a new owneder converter with proper substitution of unbound wildcards.
	 * Equivalent to <code>new OwnedConverter(owner, false)</code>.
	 */
	public OwnedConverter(ITypeReferenceOwner owner) {
		this(owner, false);
	}
	
	/**
	 * @param keepUnboundWildcards <code>true</code> if unbound wildcards should be converted to <code>? extends Object</code>.
	 *   Unbound information is required to do proper cast validation. In other cases, the compiler should
	 *   add the upper bound object.
	 *   
	 * @see WildcardType#getUpperBounds()
	 * 
	 */
	public OwnedConverter(ITypeReferenceOwner owner, boolean keepUnboundWildcards) {
		this.keepUnboundWildcards = keepUnboundWildcards;
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
	
	public List<LightweightTypeReference> toLightweightReferences(Collection<JvmTypeReference> references) {
		if (references.isEmpty())
			return Collections.emptyList();
		List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(references.size());
		for (JvmTypeReference ref : references)
			result.add(toLightweightReference(ref));
		return result;
	}

	@Override
	public LightweightTypeReference doVisitAnyTypeReference(JvmAnyTypeReference reference) {
		return new AnyTypeReference(owner);
	}
	
	@Override
	public LightweightTypeReference doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference) {
		JvmTypeReference originalComponentType = reference.getComponentType();
		LightweightTypeReference lightweightComponentType = null;
		if (originalComponentType != null) {
			lightweightComponentType = visit(originalComponentType);
			if (lightweightComponentType.isAny())
				return lightweightComponentType;
		} else {
			lightweightComponentType = getObjectReference();
		}
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
		JvmType type = reference.getType();
		if (type == null || type.eIsProxy()) {
			return new AnyTypeReference(owner);
		}
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, type);
		for(JvmTypeReference argument: reference.getArguments()) {
			result.addTypeArgument(visit(argument).getWrapperTypeIfPrimitive());
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
			if (constraint.getTypeReference() != null) {
				if (constraint instanceof JvmUpperBound) {
					upperBoundSeen = true;
					result.addUpperBound(visit(constraint.getTypeReference()).getWrapperTypeIfPrimitive());
				} else {
					result.setLowerBound(visit(constraint.getTypeReference()).getWrapperTypeIfPrimitive());
				}
			}
		}
		if (!keepUnboundWildcards) {
			if (!upperBoundSeen) {
				ParameterizedTypeReference upperBound = getObjectReference();
				result.addUpperBound(upperBound);
			}
			if (result.getUpperBounds().isEmpty()) {
				throw new IllegalStateException("UpperBounds may not be empty");
			}
		} else {
			if (!upperBoundSeen && result.getLowerBound() != null) {
				ParameterizedTypeReference upperBound = getObjectReference();
				result.addUpperBound(upperBound);
			}
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
	public LightweightTypeReference doVisitUnknownTypeReference(JvmUnknownTypeReference reference) {
		return getObjectReference();
	}

	protected ParameterizedTypeReference getObjectReference() {
		JvmType objectType = owner.getServices().getTypeReferences().findDeclaredType(Object.class, getOwner().getContextResourceSet());
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, objectType);
		return result;
	}
	
	@Override
	public LightweightTypeReference doVisitTypeReference(JvmTypeReference reference) {
		throw new IllegalStateException("Did not expect: " + reference);
	}
	
}

