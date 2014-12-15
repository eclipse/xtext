/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Lorenzo Bettini - https://bugs.eclipse.org/bugs/show_bug.cgi?id=454786
 */
public class ResolvedFeatures extends AbstractResolvedFeatures {

	private List<IResolvedField> declaredFields;
	private List<IResolvedConstructor> declaredConstructors;
	private List<IResolvedOperation> allOperations;
	private List<IResolvedOperation> declaredOperations;
	private ListMultimap<String, IResolvedOperation> allOperationsPerErasure;
	private ListMultimap<String, IResolvedOperation> declaredOperationsPerErasure;
	
	public ResolvedFeatures(LightweightTypeReference type, OverrideTester overrideTester) {
		super(type, overrideTester);
	}
	
	public ResolvedFeatures(LightweightTypeReference type) {
		this(type, new OverrideTester());
	}
	
	public List<IResolvedOperation> getAllOperations() {
		if (allOperations != null) {
			return allOperations;
		}
		return allOperations = computeAllOperations();
	}
	
	public IResolvedOperation getResolvedOperation(JvmOperation operation) {
		return createResolvedOperation(operation);
	}
	
	public List<IResolvedField> getDeclaredFields() {
		if (declaredFields != null) {
			return declaredFields;
		}
		return declaredFields = computeDeclaredFields();
	}
	
	public List<IResolvedConstructor> getDeclaredConstructors() {
		if (declaredConstructors != null) {
			return declaredConstructors;
		}
		return declaredConstructors = computeDeclaredConstructors();
	}
	
	public List<IResolvedOperation> getDeclaredOperations() {
		if (declaredOperations != null) {
			return declaredOperations;
		}
		return declaredOperations = computeDeclaredOperations();
	}
	
	public List<IResolvedOperation> getDeclaredOperations(String erasedSignature) {
		if (declaredOperationsPerErasure != null) {
			return declaredOperationsPerErasure.get(erasedSignature);
		}
		return (declaredOperationsPerErasure = computeIndex(getDeclaredOperations())).get(erasedSignature);
	}
	
	public List<IResolvedOperation> getAllOperations(String erasedSignature) {
		if (allOperationsPerErasure != null) {
			return allOperationsPerErasure.get(erasedSignature);
		}
		return (allOperationsPerErasure = computeIndex(getAllOperations())).get(erasedSignature);
	}
	
	protected ListMultimap<String, IResolvedOperation> computeIndex(List<IResolvedOperation> operations) {
		// produces an immutable index which is what we want to have
		return Multimaps.index(operations, new Function<IResolvedOperation, String>() {
			@Override
			public String apply(IResolvedOperation input) {
				return input.getResolvedErasureSignature();
			}
		});
	}

	protected List<IResolvedOperation> computeAllOperations() {
		JvmType rawType = getRawType();
		if (!(rawType instanceof JvmDeclaredType)) {
			return Collections.emptyList();
		}
		List<IResolvedOperation> result = Lists.newArrayList(getDeclaredOperations());
		Multimap<String, AbstractResolvedOperation> processed = HashMultimap.create();
		for (IResolvedOperation resolvedOperation : result) {
			processed.put(resolvedOperation.getDeclaration().getSimpleName(), (AbstractResolvedOperation)resolvedOperation);
		}
		Set<JvmDeclaredType> processedTypes = Sets.newHashSet((JvmDeclaredType)rawType);
		computeAllOperationsFromSuperTypes((JvmDeclaredType)rawType, processed, processedTypes, result);
		return Collections.unmodifiableList(result);
	}

	protected void computeAllOperations(JvmDeclaredType type, Multimap<String, AbstractResolvedOperation> processedOperations, Set<JvmDeclaredType> processedTypes, List<IResolvedOperation> result) {
		if (type != null && !type.eIsProxy() && processedTypes.add(type)) {
			Iterable<JvmOperation> operations = type.getDeclaredOperations();
			for(JvmOperation operation: operations) {
				String simpleName = operation.getSimpleName();
				if (processedOperations.containsKey(simpleName)) {
					if (isOverridden(operation, processedOperations.get(simpleName))) {
						continue;
					}
				}
				BottomResolvedOperation resolvedOperation = createResolvedOperation(operation);
				processedOperations.put(simpleName, resolvedOperation);
				result.add(resolvedOperation);
			}
			computeAllOperationsFromSuperTypes(type, processedOperations, processedTypes, result);
		}
	}

	protected void computeAllOperationsFromSuperTypes(JvmDeclaredType type, Multimap<String, AbstractResolvedOperation> processedOperations,
			Set<JvmDeclaredType> processedTypes, List<IResolvedOperation> result) {
		for(JvmTypeReference superType: type.getSuperTypes()) {
			JvmType rawSuperType = superType.getType();
			if (rawSuperType instanceof JvmDeclaredType) {
				computeAllOperations((JvmDeclaredType) rawSuperType, processedOperations, processedTypes, result);
			}
		}
	}

	protected List<IResolvedOperation> computeDeclaredOperations() {
		JvmType rawType = getRawType();
		if (!(rawType instanceof JvmDeclaredType)) {
			return Collections.emptyList();
		}
		List<IResolvedOperation> result = Lists.newArrayList();
		Iterable<JvmOperation> operations = ((JvmDeclaredType)rawType).getDeclaredOperations();
		for(JvmOperation operation: operations) {
			BottomResolvedOperation resolvedOperation = createResolvedOperation(operation);
			result.add(resolvedOperation);
		}
		return Collections.unmodifiableList(result);
	}
	
	protected List<IResolvedField> computeDeclaredFields() {
		JvmType rawType = getRawType();
		if (!(rawType instanceof JvmGenericType)) {
			return Collections.emptyList();
		}
		List<IResolvedField> result = Lists.newArrayList();
		for(JvmField field: ((JvmGenericType)rawType).getDeclaredFields()) {
			result.add(new ResolvedField(field, getType()));
		}
		return Collections.unmodifiableList(result);
	}
	
	protected List<IResolvedConstructor> computeDeclaredConstructors() {
		JvmType rawType = getRawType();
		if (!(rawType instanceof JvmGenericType)) {
			return Collections.emptyList();
		}
		List<IResolvedConstructor> result = Lists.newArrayList();
		for(JvmConstructor constructor: ((JvmGenericType)rawType).getDeclaredConstructors()) {
			result.add(new ResolvedConstructor(constructor, getType()));
		}
		return Collections.unmodifiableList(result);
	}

}
