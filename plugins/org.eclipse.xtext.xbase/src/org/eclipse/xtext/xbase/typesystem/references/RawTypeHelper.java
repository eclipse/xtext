/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.ClassURIHelper;
import org.eclipse.xtext.xbase.typesystem.conformance.IRawTypeHelper;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
@NonNullByDefault
public class RawTypeHelper implements IRawTypeHelper {

	private final RawTypeImplementation typeImplementation;
	private final RawTypeReferenceImplementation typeReferenceImplementation;

	@Inject
	public RawTypeHelper(RawTypeImplementation typeImplementation, RawTypeReferenceImplementation typeReferenceImplementation) {
		this.typeImplementation = typeImplementation;
		this.typeReferenceImplementation = typeReferenceImplementation;
	}
	
	// TODO change to accumulating parameter where Object is added iff the list is empty
	public static class RawTypeImplementation extends TypeReferenceVisitorWithParameterAndNonNullResult<ResourceSet, List<JvmType>> {

		private final TypesFactory factory;

		@Inject
		public RawTypeImplementation(TypesFactory factory) {
			this.factory = factory;
		}
		
		public List<JvmType> getAllRawTypes(LightweightTypeReference reference, ResourceSet resourceSet) {
			List<JvmType> result = reference.accept(this, resourceSet);
			return result;
		}
		
		@Override
		protected List<JvmType> doVisitTypeReference(LightweightTypeReference reference, ResourceSet resourceSet) {
			return Collections.emptyList();
		}
		
		@Override
		protected List<JvmType> doVisitCompoundTypeReference(CompoundTypeReference reference, ResourceSet resourceSet) {
			List<LightweightTypeReference> components = reference.getMultiTypeComponents();
			if (components.isEmpty())
				throw new IllegalStateException("Components may not be empty");
			return collectRawTypes(components, resourceSet);
		}

		protected List<JvmType> collectRawTypes(List<LightweightTypeReference> references, ResourceSet resourceSet) {
			List<JvmType> result = Lists.newArrayList();
			for(LightweightTypeReference component: references) {
				result.addAll(component.accept(this, resourceSet));
			}
			return result;
		}
		
		@Override
		protected List<JvmType> doVisitArrayTypeReference(ArrayTypeReference reference, ResourceSet resourceSet) {
			LightweightTypeReference componentType = reference.getComponentType();
			List<JvmType> result;
			if (!componentType.isResolved()) {
				result = createObjectReference(resourceSet);
			} else {
				List<JvmType> rawComponentTypes = componentType.accept(this, resourceSet);
				result = Lists.newArrayListWithCapacity(rawComponentTypes.size());
				for(JvmType rawComponentType: rawComponentTypes) {
					if (!rawComponentType.eIsProxy() && rawComponentType instanceof JvmComponentType) {
						JvmArrayType arrayType = ((JvmComponentType) rawComponentType).getArrayType();
						if (arrayType == null) {
							arrayType = factory.createJvmArrayType();
							arrayType.setComponentType((JvmComponentType) rawComponentType);
						}
						result.add(arrayType);
					}
				}
			}
			return result;
		}
		
		@Override
		protected List<JvmType> doVisitParameterizedTypeReference(ParameterizedTypeReference reference, ResourceSet resourceSet) {
			JvmType type = reference.getType();
			if (!type.eIsProxy()) {
				if (type instanceof JvmTypeParameter) {
					return getRawTypesFromConstraints(reference.getOwner(), ((JvmTypeParameter) type).getConstraints(), resourceSet);
				}
				return Collections.singletonList(type);
			}
			return Collections.emptyList();
		}
		
		@Override
		protected List<JvmType> doVisitWildcardTypeReference(WildcardTypeReference reference, ResourceSet resourceSet) {
			List<LightweightTypeReference> upperBounds = reference.getUpperBounds();
			if (upperBounds.isEmpty()) {
				throw new IllegalStateException("UpperBounds may not be empty");
			}
			return collectRawTypes(upperBounds, resourceSet);
		}
		
		@Override
		protected List<JvmType> doVisitUnboundTypeReference(UnboundTypeReference reference, ResourceSet resourceSet) {
			List<LightweightBoundTypeArgument> hints = reference.getAllHints();
			if (!hints.isEmpty()) {
				if (reference.resolveWithHints(hints)) {
					LightweightTypeReference resolvedTo = reference.getResolvedTo();
					if (resolvedTo != null)
						return resolvedTo.accept(this, resourceSet);
				}
			}
			JvmTypeParameter typeParameter = reference.getTypeParameter();
			return getRawTypesFromConstraints(reference.getOwner(), typeParameter.getConstraints(), resourceSet);
		}

		protected List<JvmType> getRawTypesFromConstraints(ITypeReferenceOwner owner, List<JvmTypeConstraint> constraints, ResourceSet resourceSet) {
			if (!constraints.isEmpty()) {
				List<JvmType> result = Lists.newArrayList();
				OwnedConverter converter = new OwnedConverter(owner);
				for(JvmTypeConstraint constraint: constraints) {
					if (constraint instanceof JvmUpperBound) {
						result.addAll(converter.toLightweightReference(constraint.getTypeReference()).accept(this, resourceSet));
					}
				}
				if (!result.isEmpty())
					return result;
			}
			return createObjectReference(resourceSet);
		}

		protected List<JvmType> createObjectReference(ResourceSet resourceSet) {
			// no upper bound found - seems to be an invalid - assume object as upper bound
			URI objectURI = new ClassURIHelper().getFullURI(Object.class);
			JvmType objectType = factory.createJvmGenericType();
			((InternalEObject)objectType).eSetProxyURI(objectURI);
			objectType = (JvmType) EcoreUtil.resolve(objectType, resourceSet);
			return Collections.singletonList(objectType);
		}
	}
	
	// TODO avoid deeply nested compound references iff possible
	public static class RawTypeReferenceImplementation extends TypeReferenceVisitorWithParameterAndNonNullResult<ResourceSet, LightweightTypeReference> {

		private final TypesFactory factory;

		@Inject
		public RawTypeReferenceImplementation(TypesFactory factory) {
			this.factory = factory;
		}
		
		public LightweightTypeReference getRawTypeReference(LightweightTypeReference reference, ResourceSet resourceSet) {
			LightweightTypeReference result = reference.accept(this, resourceSet);
			return result;
		}
		
		@Override
		public LightweightTypeReference doVisitTypeReference(LightweightTypeReference reference, ResourceSet resourceSet) {
			return reference;
		}
		
		@Override
		public LightweightTypeReference doVisitCompoundTypeReference(CompoundTypeReference reference, ResourceSet resourceSet) {
			if (reference.isRawType())
				return reference;
			CompoundTypeReference result = new CompoundTypeReference(reference.getOwner(), reference.isSynonym());
			enhanceCompoundReference(reference.getMultiTypeComponents(), result, resourceSet);
			return result;
		}

		protected void enhanceCompoundReference(List<LightweightTypeReference> references,
				CompoundTypeReference result, ResourceSet resourceSet) {
			if (references.isEmpty()) {
				throw new IllegalStateException("References may not be empty");
			}
			for(LightweightTypeReference component: references) {
				result.addComponent(component.accept(this, resourceSet));
			}
		}
		
		@Override
		public ArrayTypeReference doVisitArrayTypeReference(ArrayTypeReference reference, ResourceSet resourceSet) {
			if (reference.isRawType())
				return reference;
			LightweightTypeReference componentType = reference.getComponentType();
			LightweightTypeReference rawComponentType = componentType.accept(this, resourceSet);
			return new ArrayTypeReference(reference.getOwner(), rawComponentType);
		}
		
		@Override
		public LightweightTypeReference doVisitParameterizedTypeReference(ParameterizedTypeReference reference, ResourceSet resourceSet) {
			if (reference.isRawType())
				return reference;
			JvmType type = reference.getType();
			if (type instanceof JvmTypeParameter) {
				return getRawTypeFromConstraints(reference.getOwner(), (JvmTypeParameter) type, resourceSet);
			} 
			return new ParameterizedTypeReference(reference.getOwner(), type);
		}
		
		@Override
		public LightweightTypeReference doVisitWildcardTypeReference(WildcardTypeReference reference, ResourceSet resourceSet) {
			CompoundTypeReference result = new CompoundTypeReference(reference.getOwner(), false);
			enhanceCompoundReference(reference.getUpperBounds(), result, resourceSet);
			return result;
		}

		protected LightweightTypeReference getRawTypeFromConstraints(ITypeReferenceOwner owner, JvmTypeParameter typeParameter, ResourceSet resourceSet) {
			List<JvmTypeConstraint> constraints = typeParameter.getConstraints();
			if (!constraints.isEmpty()) {
				CompoundTypeReference result = new CompoundTypeReference(owner, false);
				OwnedConverter converter = new OwnedConverter(owner);
				for(JvmTypeConstraint constraint: constraints) {
					if (constraint instanceof JvmUpperBound) {
						result.addComponent(converter.toLightweightReference(constraint.getTypeReference()).accept(this, resourceSet));
					}
				}
				return result;
			}
			return createObjectReference(owner, resourceSet);
		}

		protected LightweightTypeReference createObjectReference(ITypeReferenceOwner owner, ResourceSet resourceSet) {
			// no upper bound found - seems to be an invalid - assume object as upper bound
			URI objectURI = new ClassURIHelper().getFullURI(Object.class);
			JvmType objectType = factory.createJvmGenericType();
			((InternalEObject)objectType).eSetProxyURI(objectURI);
			objectType = (JvmType) EcoreUtil.resolve(objectType, resourceSet);
			return new ParameterizedTypeReference(owner, objectType);
		}
	}
	
	public List<JvmType> getAllRawTypes(LightweightTypeReference reference, ResourceSet resourceSet) {
		List<JvmType> result = typeImplementation.getAllRawTypes(reference, resourceSet);
		return result;
	}

	public LightweightTypeReference getRawTypeReference(LightweightTypeReference reference, ResourceSet resourceSet) {
		LightweightTypeReference result = typeReferenceImplementation.getRawTypeReference(reference, resourceSet);
		return result;
	}
}
