/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.typesystem.conformance.SuperTypeAcceptor;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputer;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceResult;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO document the purpose of this class
 *  - get rid of containment constraints
 *  - easier copying
 *  - isResolved
 *  - getSynonyms
 *  - getSuperTypes (resolved)
 *  - isAssignableFrom
 *  - collectSuperTypes
 *  - getAllSuperTypes
 * ?? - getFeatures (returns feature handles?)
 *  - getFeatureByName
 */
@NonNullByDefault
public abstract class LightweightTypeReference {
	
	protected static class IdentifierFunction implements Function<LightweightTypeReference, String> {
		public String apply(@Nullable LightweightTypeReference reference) {
			if (reference == null)
				throw new NullPointerException("reference");
			return reference.getIdentifier();
		}
	}
	
	protected static class SimpleNameFunction implements Function<LightweightTypeReference, String> {
		public String apply(@Nullable LightweightTypeReference reference) {
			if (reference == null)
				throw new NullPointerException("reference");
			return reference.getSimpleName();
		}
	}
	
	private TypeReferenceOwner owner;
	
	protected LightweightTypeReference(TypeReferenceOwner owner) {
		this.owner = Preconditions.checkNotNull(owner, "owner");
	}

	public boolean isResolved() {
		return true;
	}
	
	public TypeReferenceOwner getOwner() {
		return owner;
	}
	
	protected TypesFactory getTypesFactory() {
		return getOwner().getServices().getTypesFactory();
	}
	
	protected CommonTypeComputationServices getServices() {
		return getOwner().getServices();
	}
	
	public boolean isOwnedBy(TypeReferenceOwner owner) {
		if (isResolved()) {
			return true;
		}
		return owner == getOwner();
	}
	
	protected <T> List<T> expose(@Nullable List<T> list) {
		if (list == null) {
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(list);
	}
	
	public abstract JvmTypeReference toTypeReference();
	
	@Nullable
	public abstract JvmType getType();
	
	public LightweightTypeReference getWrapperTypeIfPrimitive() {
		return this;
	}
	
	public LightweightTypeReference getPrimitiveIfWrapperType() {
		return this;
	}
	
	public List<JvmType> getRawTypes() {
		return getServices().getRawTypeHelper().getAllRawTypes(this, getOwner().getContextResourceSet());
	}
	
	/*
	 * Replaced wildcards and type parameters by their respective
	 * constraints. Returns the JvmTypes without arguments.
	 * TODO implement me
	 */
	public LightweightTypeReference getRawTypeReference() {
		return getServices().getRawTypeHelper().getRawTypeReference(this, getOwner().getContextResourceSet());
	}
	
	public boolean isRawType() {
		return false;
	}
	
	public boolean isArray() {
		return false;
	}
	
	public List<LightweightTypeReference> getSuperTypes() {
		TypeParameterSubstitutor<?> substitutor = createSubstitutor();
		return getSuperTypes(substitutor);
	}
	
	public List<LightweightTypeReference> getAllSuperTypes() {
		final List<LightweightTypeReference> result = Lists.newArrayList();
		final Multiset<JvmType> distances = HashMultiset.create(7);
		final Multiset<JvmType> counterPerType = HashMultiset.create(7);
		collectSuperTypes(new SuperTypeAcceptor() {

			int counter = 0;
			
			public boolean accept(LightweightTypeReference superType, int distance) {
				JvmType type = superType.getType();
				counterPerType.add(type, counter++);
				if (distances.contains(type)) {
					int currentCount = distances.count(type);
					if (currentCount < distance + 1) {
						distances.setCount(type, distance + 1);
					} else {
						return false;
					}
				} else {
					result.add(superType);
					distances.add(type, distance + 1);
				}
				return true;
			}
			
		});
		Collections.sort(result, new Comparator<LightweightTypeReference>() {
			public int compare(@Nullable LightweightTypeReference o1, @Nullable LightweightTypeReference o2) {
				if (o1 == null || o2 == null) {
					throw new IllegalArgumentException();
				}
				JvmType type1 = o1.getType();
				JvmType type2 = o2.getType();
				if (type1 == null)
					return 1;
				if (type2 == null)
					return -1;
				int distanceCompare = Ints.compare(distances.count(type1), distances.count(type2));
				if (distanceCompare != 0)
					return distanceCompare;
				return Ints.compare(counterPerType.count(type1), counterPerType.count(type2));
			}
		});
		return result;
	}

	protected TypeParameterSubstitutor<?> createSubstitutor() {
		DeclaratorTypeArgumentCollector collector = new DeclaratorTypeArgumentCollector();
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = collector.getTypeParameterMapping(this);
		StandardTypeParameterSubstitutor substitutor = new StandardTypeParameterSubstitutor(mapping, getOwner());
		return substitutor;
	}
	
	protected abstract List<LightweightTypeReference> getSuperTypes(TypeParameterSubstitutor<?> substitutor);
	
	public void collectSuperTypes(SuperTypeAcceptor acceptor) {
		TypeParameterSubstitutor<?> substitutor = createSubstitutor();
		List<LightweightTypeReference> superTypes = getSuperTypes(substitutor);
		collectSuperTypes(1, superTypes, substitutor, acceptor);
	}
	
	protected void collectSuperTypes(int level, List<LightweightTypeReference> references, TypeParameterSubstitutor<?> substitutor, SuperTypeAcceptor acceptor) {
		for(LightweightTypeReference reference: references) {
			if (acceptor.accept(reference, level)) {
				collectSuperTypes(level + 1, reference.getSuperTypes(substitutor), substitutor, acceptor);
			}
		}
	}
	
//	public abstract List<LightweightTypeReference> getAllSuperTypes();
	
	public boolean isPrimitive() {
		return false;
	}
	
	public boolean isPrimitiveVoid() {
		return isType(Void.TYPE);
	}
	
	public boolean isAssignableFrom(LightweightTypeReference reference) {
		TypeConformanceComputationArgument argument = new TypeConformanceComputationArgument(false, false, true);
		return isAssignableFrom(reference, argument);
	}
	
	public boolean isAssignableFrom(LightweightTypeReference reference, TypeConformanceComputationArgument argument) {
		TypeConformanceComputer conformanceCompouter = getOwner().getServices().getTypeConformanceComputer();
		TypeConformanceResult result = conformanceCompouter.isConformant(this, reference, argument);
		return result.isConformant();
	}
	
	public LightweightTypeReference copyInto(TypeReferenceOwner owner) {
		if (isResolved()) {
			return this;
		}
		return doCopyInto(owner);
	}

	protected abstract LightweightTypeReference doCopyInto(TypeReferenceOwner owner);
	
	@Override
	public final String toString() {
		return getSimpleName();
	}
	
	public abstract String getSimpleName();
	
	public abstract String getIdentifier();
	
	protected JvmType findType(Class<?> type) {
		return getServices().getTypeReferences().findDeclaredType(type, getOwner().getContextResourceSet());
	}

	public abstract boolean isType(Class<?> clazz);
	
	public void accept(TypeReferenceVisitor visitor) {
		visitor.doVisitTypeReference(this);
	}
	
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		visitor.doVisitTypeReference(this, param);
	}
	
	@Nullable
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		return visitor.doVisitTypeReference(this);
	}
	
	@Nullable
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		return visitor.doVisitTypeReference(this, param);
	}
	
	public <Result> Result accept(TypeReferenceVisitorWithNonNullResult<Result> visitor) {
		Result result = accept((TypeReferenceVisitorWithResult<Result>)visitor);
		if (result == null)
			throw new IllegalStateException("result may not be null");
		return result;
	}
	
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndNonNullResult<Param, Result> visitor, Param param) {
		Result result = accept((TypeReferenceVisitorWithParameterAndResult<Param, Result>)visitor, param);
		if (result == null)
			throw new IllegalStateException("result may not be null");
		return result;
	}

	// TODO move to utility / factory
	public CompoundTypeReference toMultiType(LightweightTypeReference reference) {
		if (reference == null) {
			throw new NullPointerException("reference may not be null");
		}
		CompoundTypeReference result = new CompoundTypeReference(getOwner(), false);
		result.addComponent(this);
		result.addComponent(reference);
		return result;
	}

}
