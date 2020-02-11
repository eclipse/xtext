/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.xbase.typesystem.conformance.IRawTypeHelper;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class RawTypeHelper implements IRawTypeHelper {

	@Inject
	private TypesFactory factory;
	
	// TODO change to accumulating parameter where Object is added iff the list is empty
	public static class RawTypeImplementation extends TypeReferenceVisitorWithParameterAndResult<ResourceSet, List<JvmType>> {

		private final TypesFactory factory;

		private Set<JvmType> visited = Sets.newHashSetWithExpectedSize(2);
		
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
		
		@Override
		protected List<JvmType> doVisitSynonymTypeReference(CompoundTypeReference reference, ResourceSet resourceSet) {
			List<LightweightTypeReference> components = reference.getMultiTypeComponents();
			if (components.isEmpty())
				throw new IllegalStateException("Components may not be empty");
			return components.get(components.size() - 1).accept(this, resourceSet);
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
					return getRawTypesFromConstraints(reference.getOwner(), (JvmTypeParameter) type, resourceSet);
				}
				return Collections.singletonList(type);
			}
			return Collections.emptyList();
		}
		
		@Override
		protected List<JvmType> doVisitWildcardTypeReference(WildcardTypeReference reference, ResourceSet resourceSet) {
			if (reference.isUnbounded()) {
				return createObjectReference(resourceSet);
			}
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
			return getRawTypesFromConstraints(reference.getOwner(), typeParameter, resourceSet);
		}

		protected List<JvmType> getRawTypesFromConstraints(ITypeReferenceOwner owner, JvmTypeParameter typeParameter, ResourceSet resourceSet) {
			if (visited.add(typeParameter)) {
				List<JvmTypeConstraint> constraints = typeParameter.getConstraints();
				if (!constraints.isEmpty()) {
					List<JvmType> result = Lists.newArrayList();
					for(JvmTypeConstraint constraint: constraints) {
						if (constraint instanceof JvmUpperBound && constraint.getTypeReference() != null) {
							result.addAll(owner.toLightweightTypeReference(constraint.getTypeReference()).accept(this, resourceSet));
						}
					}
					if (!result.isEmpty())
						return result;
				}
			}
			return createObjectReference(resourceSet);
		}

		protected List<JvmType> createObjectReference(ResourceSet resourceSet) {
			// no upper bound found - seems to be an invalid - assume object as upper bound
			JvmType objectType = factory.createJvmGenericType();
			String objectClassName = Object.class.getName();
			((InternalEObject) objectType).eSetProxyURI(URIHelperConstants.OBJECTS_URI.appendSegment(objectClassName).appendFragment(objectClassName));
			objectType = (JvmType) EcoreUtil.resolve(objectType, resourceSet);
			return Collections.singletonList(objectType);
		}
	}
	
	// TODO avoid deeply nested compound references iff possible
	public static class RawTypeReferenceImplementation extends TypeReferenceVisitorWithParameterAndResult<ResourceSet, LightweightTypeReference> {

		private final TypesFactory factory;

		private Set<JvmType> visited = Sets.newHashSetWithExpectedSize(2);
		
		@Inject
		public RawTypeReferenceImplementation(TypesFactory factory) {
			this.factory = factory;
		}
		
		public LightweightTypeReference getRawTypeReference(LightweightTypeReference reference, ResourceSet resourceSet) {
			LightweightTypeReference result = reference.accept(this, resourceSet);
			return result;
		}
		
		@Override
		protected LightweightTypeReference doVisitTypeReference(LightweightTypeReference reference, ResourceSet resourceSet) {
			return reference;
		}
		
		@Override
		protected LightweightTypeReference doVisitCompoundTypeReference(CompoundTypeReference reference, ResourceSet resourceSet) {
			if (reference.isRawType())
				return reference;
			CompoundTypeReference result = reference.getOwner().newCompoundTypeReference(reference.isSynonym());
			enhanceCompoundReference(reference.getMultiTypeComponents(), result, resourceSet);
			return result;
		}
		
		@Override
		protected LightweightTypeReference doVisitSynonymTypeReference(CompoundTypeReference reference, ResourceSet resourceSet) {
			if (reference.isRawType())
				return reference;
			List<LightweightTypeReference> components = reference.getMultiTypeComponents();
			return components.get(components.size() - 1).accept(this, resourceSet);
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
		protected ArrayTypeReference doVisitArrayTypeReference(ArrayTypeReference reference, ResourceSet resourceSet) {
			if (reference.isRawType())
				return reference;
			LightweightTypeReference componentType = reference.getComponentType();
			LightweightTypeReference rawComponentType = componentType.accept(this, resourceSet);
			return reference.getOwner().newArrayTypeReference(rawComponentType);
		}
		
		@Override
		protected LightweightTypeReference doVisitParameterizedTypeReference(ParameterizedTypeReference reference, ResourceSet resourceSet) {
			JvmType type = reference.getType();
			if (reference.isRawType() && !(type instanceof JvmTypeParameter)) {
				return reference;
			}
			if (type instanceof JvmTypeParameter) {
				return getRawTypeFromConstraints(reference.getOwner(), (JvmTypeParameter) type, resourceSet);
			} 
			return reference.getOwner().toPlainTypeReference(type);
		}
		
		@Override
		protected LightweightTypeReference doVisitWildcardTypeReference(WildcardTypeReference reference, ResourceSet resourceSet) {
			if (reference.isUnbounded()) {
				return reference.getUpperBoundSubstitute();
			}
			if (reference.getUpperBounds().size() == 1) {
				return reference.getUpperBoundSubstitute().accept(this, resourceSet);
			}
			CompoundTypeReference result = reference.getOwner().newCompoundTypeReference(false);
			enhanceCompoundReference(reference.getUpperBounds(), result, resourceSet);
			return result;
		}

		protected LightweightTypeReference getRawTypeFromConstraints(ITypeReferenceOwner owner, JvmTypeParameter typeParameter, ResourceSet resourceSet) {
			if (visited.add(typeParameter)) {
				List<JvmTypeConstraint> constraints = typeParameter.getConstraints();
				if (!constraints.isEmpty()) {
					if (constraints.size() > 1) {
						CompoundTypeReference result = owner.newCompoundTypeReference(false);
						for(JvmTypeConstraint constraint: constraints) {
							if (constraint instanceof JvmUpperBound) {
								JvmTypeReference typeReference = constraint.getTypeReference();
								if (typeReference != null)
									result.addComponent(owner.toLightweightTypeReference(typeReference).accept(this, resourceSet));
							}
						}
						return result;
					} else {
						JvmTypeReference typeReference = constraints.get(0).getTypeReference();
						if (typeReference != null) {
							LightweightTypeReference result = owner.toLightweightTypeReference(typeReference).accept(this, resourceSet);
							return result;
						}
					}
				}
			}
			return createObjectReference(owner, resourceSet);
		}

		protected LightweightTypeReference createObjectReference(ITypeReferenceOwner owner, ResourceSet resourceSet) {
			// no upper bound found - seems to be an invalid - assume object as upper bound
			JvmType objectType = factory.createJvmGenericType();
			String objectClassName = Object.class.getName();
			((InternalEObject) objectType).eSetProxyURI(URIHelperConstants.OBJECTS_URI.appendSegment(objectClassName).appendFragment(objectClassName));
			objectType = (JvmType) EcoreUtil.resolve(objectType, resourceSet);
			return owner.newParameterizedTypeReference(objectType);
		}
	}
	
	@Override
	public List<JvmType> getAllRawTypes(LightweightTypeReference reference, ResourceSet resourceSet) {
		List<JvmType> result = new RawTypeImplementation(factory).getAllRawTypes(reference, resourceSet);
		return result;
	}

	@Override
	public LightweightTypeReference getRawTypeReference(LightweightTypeReference reference, ResourceSet resourceSet) {
		LightweightTypeReference result = new RawTypeReferenceImplementation(factory).getRawTypeReference(reference, resourceSet);
		return result;
	}
}
