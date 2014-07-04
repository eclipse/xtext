/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
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
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.util.AbstractXtypeReferenceVisitor;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OwnedConverter extends AbstractXtypeReferenceVisitor<LightweightTypeReference> implements Function<JvmTypeReference, LightweightTypeReference> {

	private final ITypeReferenceOwner owner;
	private final boolean keepUnboundWildcards;

	/**
.	 * Creates a new owned converter with proper substitution of unbound wildcards.
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
	
	public LightweightTypeReference toRawLightweightReference(JvmType type) {
		if (type instanceof JvmArrayType) {
			JvmComponentType componentType = ((JvmArrayType) type).getComponentType();
			LightweightTypeReference componentTypeReference = toRawLightweightReference(componentType);
			return new ArrayTypeReference(getOwner(), componentTypeReference);
		}
		return new ParameterizedTypeReference(getOwner(), type);
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
		LightweightTypeReference lightweightComponentType = null;
		if (originalComponentType != null) {
			lightweightComponentType = visit(originalComponentType);
			if (lightweightComponentType.isAny() || lightweightComponentType.isUnknown())
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
			return new UnknownTypeReference(owner);
		return super.doVisitComputedTypeReference(reference);
	}

	@Override
	public LightweightTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
		JvmType type = getType(reference);
		if (type == null || type.eIsProxy()) {
			List<INode> nodes = NodeModelUtils.findNodesForFeature(reference, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
			if (nodes.isEmpty()) {
				Set<EObject> sourceElements = owner.getServices().getJvmModelAssociations().getSourceElements(reference);
				EObject firstSource = Iterables.getFirst(sourceElements, null);
				if (firstSource instanceof JvmParameterizedTypeReference) {
					nodes = NodeModelUtils.findNodesForFeature(firstSource, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
				}
			}
			if (nodes.size() == 1) {
				String name = nodes.get(0).getText().trim();
				if (name != null && name.length() != 0) {
					int lastDot = name.lastIndexOf('.');
					int lastDollar = name.lastIndexOf('$');
					int lastDotOrDollar = Math.max(lastDot, lastDollar);
					if (lastDotOrDollar != -1 && lastDotOrDollar != name.length() - 1) {
						String shortName = name.substring(lastDotOrDollar + 1);
						if (shortName.length() != 0) {
							name = shortName;
						}
					}
					return new UnknownTypeReference(owner, name);
				}
			}
			return new UnknownTypeReference(owner);
		}
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, type);
		for(JvmTypeReference argument: reference.getArguments()) {
			result.addTypeArgument(visit(argument).getWrapperTypeIfPrimitive());
		}
		return result;
	}

	protected JvmType getType(JvmTypeReference reference) {
		return reference.getType();
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
				} else if (result.getLowerBound() == null) {
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
		if (reference.eIsSet(TypesPackage.Literals.JVM_UNKNOWN_TYPE_REFERENCE__QUALIFIED_NAME))
			return new UnknownTypeReference(getOwner(), reference.getQualifiedName());
		return new UnknownTypeReference(getOwner());
	}
	
	@Override
	protected LightweightTypeReference handleNullReference() {
		return new UnknownTypeReference(getOwner());
	}

	protected ParameterizedTypeReference getObjectReference() {
		JvmType objectType = getObjectType();
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, objectType);
		return result;
	}

	protected JvmType getObjectType() {
		return owner.getServices().getTypeReferences().findDeclaredType(Object.class, getOwner().getContextResourceSet());
	}
	
	@Override
	public LightweightTypeReference doVisitTypeReference(JvmTypeReference reference) {
		throw new IllegalStateException("Did not expect: " + reference);
	}
	
}

