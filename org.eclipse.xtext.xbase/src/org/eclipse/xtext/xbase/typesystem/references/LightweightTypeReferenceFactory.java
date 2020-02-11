/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
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

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;

/**
 * Concrete implementation that is used by the {@link StandardTypeReferenceOwner} to
 * provide instances of {@link LightweightTypeReference}. Clients may use a custom
 * implementation of this factory and configure it with a {@link StandardTypeReferenceOwner}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LightweightTypeReferenceFactory extends AbstractXtypeReferenceVisitor<LightweightTypeReference> {

	private final ITypeReferenceOwner owner;
	private final boolean keepUnboundWildcards;

	/**
.	 * Creates a new owned converter with proper substitution of unbound wildcards.
	 * Equivalent to <code>new OwnedConverter(owner, false)</code>.
	 */
	public LightweightTypeReferenceFactory(ITypeReferenceOwner owner) {
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
	public LightweightTypeReferenceFactory(ITypeReferenceOwner owner, boolean keepUnboundWildcards) {
		this.keepUnboundWildcards = keepUnboundWildcards;
		this.owner = Preconditions.checkNotNull(owner, "owner");
	}
	
	public ITypeReferenceOwner getOwner() {
		return owner;
	}
	
	public LightweightTypeReference toLightweightReference(JvmTypeReference reference) {
		return visit(reference);
	}
	
	public LightweightTypeReference toLightweightReference(JvmType type) {
		if (type.eClass() == TypesPackage.Literals.JVM_ARRAY_TYPE) {
			JvmComponentType componentType = ((JvmArrayType) type).getComponentType();
			LightweightTypeReference componentTypeReference = toLightweightReference(componentType);
			return owner.newArrayTypeReference(componentTypeReference);
		}
		ParameterizedTypeReference result = owner.newParameterizedTypeReference(type);
		if (type.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
			result.accept(new TypeReferenceVisitor() {
				@Override
				protected void doVisitInnerTypeReference(InnerTypeReference reference) {
					reference.getOuter().accept(this);
					super.doVisitInnerTypeReference(reference);
				}
				@Override
				protected void doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
					JvmType rawType = reference.getType();
					if (rawType.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
						List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) rawType).getTypeParameters();
						for(int i = 0, size = typeParameters.size(); i < size; i++) {
							JvmTypeParameter typeParameter = typeParameters.get(i);
							reference.addTypeArgument(owner.newParameterizedTypeReference(typeParameter));
						}
					}
				}
			});
		}
		return result;
	}
	
	public LightweightTypeReference toPlainTypeReference(JvmType type) {
		if (type.eClass() == TypesPackage.Literals.JVM_ARRAY_TYPE) {
			JvmComponentType componentType = ((JvmArrayType) type).getComponentType();
			LightweightTypeReference componentTypeReference = toPlainTypeReference(componentType);
			return owner.newArrayTypeReference(componentTypeReference);
		}
		return owner.newParameterizedTypeReference(type);
	}

	@Override
	public LightweightTypeReference doVisitAnyTypeReference(JvmAnyTypeReference reference) {
		return owner.newAnyTypeReference();
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
		return owner.newArrayTypeReference(lightweightComponentType);
	}
	
	@Override
	public LightweightTypeReference doVisitMultiTypeReference(JvmMultiTypeReference reference) {
		return doVisitCompoundReference(reference, false);
	}

	protected LightweightTypeReference doVisitCompoundReference(JvmCompoundTypeReference reference,
			boolean synonym) {
		CompoundTypeReference result = owner.newCompoundTypeReference(synonym);
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
			return owner.newUnknownTypeReference();
		return super.doVisitComputedTypeReference(reference);
	}
	
	@Override
	public LightweightTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
		JvmType type = getType(reference);
		if (type == null || type.eIsProxy()) {
			return createUnknownTypeReference(reference);
		}
		ParameterizedTypeReference result = owner.newParameterizedTypeReference(type);
		for(JvmTypeReference argument: reference.getArguments()) {
			result.addTypeArgument(visit(argument).getWrapperTypeIfPrimitive());
		}
		return result;
	}

	protected boolean isInner(JvmType type) {
		if (type != null && type.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
			if (type.eContainer() instanceof JvmDeclaredType) {
				return !((JvmGenericType) type).isStatic();
			}
		}
		return false;
	}

	private LightweightTypeReference createUnknownTypeReference(JvmParameterizedTypeReference reference) {
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
				return owner.newUnknownTypeReference(name);
			}
		}
		return owner.newUnknownTypeReference();
	}
	
	@Override
	public LightweightTypeReference doVisitInnerTypeReference(JvmInnerTypeReference reference) {
		JvmType type = getType(reference);
		if (type == null || type.eIsProxy()) {
			return createUnknownTypeReference(reference);
		}
		if (!isInner(type)) {
			return doVisitParameterizedTypeReference(reference);
		}
		JvmParameterizedTypeReference outer = reference.getOuter();
		if (outer == null)
			return doVisitParameterizedTypeReference(reference);
		ParameterizedTypeReference lightweightOuter = (ParameterizedTypeReference) outer.accept(this);
		// constructor call instead of owner.newParameterized to avoid second check for isInner(..)
		InnerTypeReference result = new InnerTypeReference(owner, lightweightOuter, type);
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
		WildcardTypeReference result = owner.newWildcardTypeReference();
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
				LightweightTypeReference upperBound = getObjectReference();
				result.addUpperBound(upperBound);
			}
			if (result.getUpperBounds().isEmpty()) {
				throw new IllegalStateException("UpperBounds may not be empty");
			}
		} else {
			if (!upperBoundSeen && result.getLowerBound() != null) {
				LightweightTypeReference upperBound = getObjectReference();
				result.addUpperBound(upperBound);
			}
		}
		return result;
	}
	
	@Override
	public LightweightTypeReference doVisitFunctionTypeReference(XFunctionTypeRef reference) {
		JvmTypeReference equivalent = reference.getEquivalent();
		if (equivalent == null) {
			return super.doVisitFunctionTypeReference(reference);
		}
		FunctionTypeReference result;
		// constructors used below to avoid subsequent checks for isInner which was supposed to be done by 
		// the computation of the equivalent
		if (equivalent.eClass() == TypesPackage.Literals.JVM_INNER_TYPE_REFERENCE) {
			JvmParameterizedTypeReference outer = ((JvmInnerTypeReference) equivalent).getOuter();
			LightweightTypeReference outerEquivalent = outer.accept(this);
			result = new InnerFunctionTypeReference(owner, outerEquivalent, reference.getType());
		} else {
			result = new FunctionTypeReference(owner, reference.getType());
		}
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
			return owner.newUnknownTypeReference(reference.getQualifiedName());
		return owner.newUnknownTypeReference();
	}
	
	@Override
	protected LightweightTypeReference handleNullReference() {
		return owner.newUnknownTypeReference();
	}

	/* @NotNull */
	protected LightweightTypeReference getObjectReference() {
		return owner.newReferenceToObject();
	}

	/* @Nullable */
	protected JvmType getObjectType() {
		return owner.getServices().getTypeReferences().findDeclaredType(Object.class, owner.getContextResourceSet());
	}
	
	@Override
	public LightweightTypeReference doVisitTypeReference(JvmTypeReference reference) {
		throw new IllegalStateException("Did not expect: " + reference);
	}
	
}
