/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ParameterizedTypeReference extends LightweightTypeReference {

	private List<LightweightTypeReference> typeArguments;
	private JvmType type;
	protected boolean resolved;
	
	public ParameterizedTypeReference(ITypeReferenceOwner owner, JvmType type) {
		super(owner);
		if (type == null) {
			throw new NullPointerException("type may not be null");
		}
		if (type instanceof JvmArrayType) {
			throw new IllegalArgumentException("type should be an array type");
		}
		this.type = type;
		// TODO check against owner or specialized representation of the owner
		this.resolved = !(type instanceof JvmTypeParameter);
	}
	
	@Override
	public JvmTypeReference toTypeReference() {
		JvmParameterizedTypeReference result = getTypesFactory().createJvmParameterizedTypeReference();
		result.setType(type);
		if (typeArguments != null) {
			for(LightweightTypeReference typeArgument: typeArguments) {
				result.getArguments().add(typeArgument.toTypeReference());
			}
		}
		return result;
	}
	
	@Override
	public JvmTypeReference toJavaCompliantTypeReference() {
		JvmParameterizedTypeReference result = getTypesFactory().createJvmParameterizedTypeReference();
		result.setType(type);
		if (typeArguments != null) {
			for(LightweightTypeReference typeArgument: typeArguments) {
				result.getArguments().add(typeArgument.toJavaCompliantTypeReference());
			}
		}
		return result;
	}
	
	@Override
	public JvmType getType() {
		return type;
	}
	
	@Override
	public boolean isRawType() {
		if (type instanceof JvmGenericType) {
			if (!((JvmGenericType) type).getTypeParameters().isEmpty() && expose(typeArguments).isEmpty())
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isOwnedBy(ITypeReferenceOwner owner) {
		if (super.isOwnedBy(owner)) {
			for(LightweightTypeReference typeArgument: expose(typeArguments)) {
				if (!typeArgument.isOwnedBy(owner))
					return false;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public LightweightTypeReference getWrapperTypeIfPrimitive() {
		if (type instanceof JvmPrimitiveType) {
			Primitives primitives = getOwner().getServices().getPrimitives();
			JvmType wrapperType = primitives.getWrapperType((JvmPrimitiveType) type);
			return new ParameterizedTypeReference(getOwner(), wrapperType);
		}
		return this;
	}
	
	@Override
	public LightweightTypeReference getPrimitiveIfWrapperType() {
		if (type instanceof JvmDeclaredType) {
			Primitives primitives = getOwner().getServices().getPrimitives();
			JvmType primitiveType = primitives.getPrimitiveTypeIfWrapper((JvmDeclaredType) type);
			if (primitiveType != null) {
				return new ParameterizedTypeReference(getOwner(), primitiveType);
			}
		}
		return this;
	}
	
	@Override
	public boolean isPrimitive() {
		return type instanceof JvmPrimitiveType;
	}
	
	@Override
	public boolean isWrapper() {
		if (type instanceof JvmDeclaredType || type instanceof JvmTypeParameter) {
			Primitives primitives = getOwner().getServices().getPrimitives();
			boolean result = primitives.isWrapperType(type);
			return result;
		}
		return false;
	}
	
	@Override
	protected List<LightweightTypeReference> getSuperTypes(TypeParameterSubstitutor<?> substitutor) {
		// TODO should this be a service?
		if (type instanceof JvmDeclaredType) {
			List<JvmTypeReference> superTypes = ((JvmDeclaredType) type).getSuperTypes();
			if (!superTypes.isEmpty()) {
				if (!isRawType()) {
					OwnedConverter converter = new OwnedConverter(getOwner());
					List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(superTypes.size());
					for(JvmTypeReference superType: superTypes) {
						LightweightTypeReference lightweightSuperType = converter.toLightweightReference(superType);
						if (!lightweightSuperType.isType(Object.class) || superTypes.size() == 1)
							result.add(substitutor.substitute(lightweightSuperType));
					}
					return result;
				} else {
					OwnedConverter converter = new OwnedConverter(getOwner());
					List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(superTypes.size());
					for(JvmTypeReference superType: superTypes) {
						LightweightTypeReference lightweightSuperType = converter.toLightweightReference(superType);
						if (!lightweightSuperType.isType(Object.class) || superTypes.size() == 1)
							result.add(substitutor.substitute(lightweightSuperType).getRawTypeReference());
					}
					return result;
				}
			}
		} else if (type instanceof JvmTypeParameter) {
			List<JvmTypeConstraint> constraints = ((JvmTypeParameter) type).getConstraints();
			if (!constraints.isEmpty()) {
				List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(constraints.size());
				OwnedConverter converter = new OwnedConverter(getOwner());
				for(JvmTypeConstraint constraint: constraints) {
					if (constraint instanceof JvmUpperBound) {
						LightweightTypeReference upperBound = converter.toLightweightReference(constraint.getTypeReference());
						result.add(substitutor.substitute(upperBound));
					}
				}
				return result;
			}
		}
		return Collections.emptyList();
	}
	
	public List<LightweightTypeReference> getTypeArguments() {
		return expose(typeArguments);
	}

	@Override
	protected ParameterizedTypeReference doCopyInto(ITypeReferenceOwner owner) {
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, type);
		copyTypeArguments(result, owner);
		return result;
	}

	protected void copyTypeArguments(ParameterizedTypeReference result, ITypeReferenceOwner owner) {
		if (typeArguments != null && !typeArguments.isEmpty()) {
			for(LightweightTypeReference typeArgument: typeArguments) {
				result.addTypeArgument(typeArgument.copyInto(owner));
			}
		}
	}
	
	@Override
	public boolean isResolved() {
		return resolved;
	}

	public void addTypeArgument(LightweightTypeReference argument) {
		if (argument == null) {
			return;
//			throw new NullPointerException("argument may not be null");
		}
		if (!argument.isOwnedBy(getOwner())) {
			throw new IllegalArgumentException("argument is not valid in current context");
		}
		if (typeArguments == null)
			typeArguments = Lists.newArrayListWithCapacity(2);
		typeArguments.add(argument);
		resolved = resolved && argument.isResolved();
	}
	
	@Override
	public String getSimpleName() {
		return getAsString(type.getSimpleName(), new SimpleNameFunction());
	}
	
	@Override
	public String getIdentifier() {
		return getAsString(type.getIdentifier(), new IdentifierFunction());
	}
	
	protected String getAsString(String type, Function<LightweightTypeReference, String> format) {
		if (typeArguments != null)
			return type + "<" + Joiner.on(", ").join(Iterables.transform(typeArguments, format)) + ">";
		return type;
	}

	@Override
	public boolean isType(Class<?> clazz) {
		if (type != null) {
			return clazz.getCanonicalName().equals(type.getIdentifier());
		}
		return false;
	}
	
	@Override
	public void accept(TypeReferenceVisitor visitor) {
		visitor.doVisitParameterizedTypeReference(this);
	}
	
	@Override
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		visitor.doVisitParameterizedTypeReference(this, param);
	}
	
	@Override
	@Nullable
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		return visitor.doVisitParameterizedTypeReference(this);
	}
	
	@Override
	@Nullable
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		return visitor.doVisitParameterizedTypeReference(this, param);
	}

	@Override
	public FunctionTypeKind getFunctionTypeKind() {
		FunctionTypes functionTypes = getServices().getFunctionTypes();
		return functionTypes.getFunctionTypeKind(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see FunctionTypes#getAsFunctionTypeReference(ParameterizedTypeReference)
	 */
	@Override
	@Nullable
	public FunctionTypeReference getAsFunctionTypeReference() {
		FunctionTypes functionTypes = getServices().getFunctionTypes();
		return functionTypes.getAsFunctionTypeReference(this);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see FunctionTypes#tryConvertToFunctionTypeReference(ParameterizedTypeReference, boolean)
	 */
	@Override
	@Nullable
	public FunctionTypeReference tryConvertToFunctionTypeReference(boolean rawType) {
		FunctionTypes functionTypes = getServices().getFunctionTypes();
		return functionTypes.tryConvertToFunctionTypeReference(this, rawType);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ArrayTypes#tryConvertToArray(ParameterizedTypeReference)
	 */
	@Override
	@Nullable
	public ArrayTypeReference tryConvertToArray() {
		ArrayTypes arrayTypes = getServices().getArrayTypes();
		return arrayTypes.tryConvertToArray(this);
	}
	
	/**
	 * Returns a projection of this type to the instance level. That is, type arguments will 
	 * be replaced by their invariant bounds.
	 * 
	 * The instance projection of <code>ArrayList&lt;? extends Iterable&lt;? extends String&gt;&gt;</code>
	 * is <code>ArrayList&lt;Iterable&lt;? extends String&gt;&gt;</code> since it is possible to create instances
	 * of <code>ArrayList&lt;Iterable&lt;? extends String&gt;&gt;</code>.
	 */
	public ParameterizedTypeReference toInstanceTypeReference() {
		ParameterizedTypeReference result = new ParameterizedTypeReference(getOwner(), getType());
		for(LightweightTypeReference typeArgument: getTypeArguments()) {
			result.addTypeArgument(typeArgument.getInvariantBoundSubstitute());
		}
		return result;
	}
}
