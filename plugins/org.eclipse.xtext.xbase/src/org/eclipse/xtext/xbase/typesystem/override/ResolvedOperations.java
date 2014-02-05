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
 */
public class ResolvedOperations extends AbstractResolvedFeatures {

	private List<IResolvedOperation> allOperations;
	private List<IResolvedOperation> declaredOperations;
	private List<IResolvedConstructor> declaredConstructors;
	private ListMultimap<String, IResolvedOperation> allOperationsPerErasure;
	
	public ResolvedOperations(LightweightTypeReference type, OverrideTester overrideTester) {
		super(type, overrideTester);
	}
	
	public ResolvedOperations(LightweightTypeReference type) {
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
		List<IResolvedOperation> operations = getAllOperations(erasedSignature);
		for(int i = 0; i < operations.size(); i++) {
			IResolvedOperation current = operations.get(i);
			if (current.getDeclaration().getDeclaringType() != getRawType()) {
				return operations.subList(0, i);
			}
		}
		return operations;
	}
	
	public List<IResolvedOperation> getAllOperations(String erasedSignature) {
		if (allOperationsPerErasure != null) {
			return allOperationsPerErasure.get(erasedSignature);
		}
		return (allOperationsPerErasure = computeIndex()).get(erasedSignature);
	}
	
	protected ListMultimap<String, IResolvedOperation> computeIndex() {
		// produces an immutable index which is what we want to have
		return Multimaps.index(getAllOperations(), new Function<IResolvedOperation, String>() {
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
		List<IResolvedOperation> result = Lists.newArrayList();
		Multimap<String, AbstractResolvedOperation> processed = HashMultimap.create();
		Set<JvmDeclaredType> processedTypes = Sets.newHashSet();
		computeAllOperations((JvmDeclaredType)rawType, processed, processedTypes, result);
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
			for(JvmTypeReference superType: type.getSuperTypes()) {
				JvmType rawSuperType = superType.getType();
				if (rawSuperType instanceof JvmDeclaredType) {
					computeAllOperations((JvmDeclaredType) rawSuperType, processedOperations, processedTypes, result);
				}
			}
		}
	}
	
	protected List<IResolvedOperation> computeDeclaredOperations() {
		JvmType rawType = getRawType();
		if (!(rawType instanceof JvmDeclaredType)) {
			return Collections.emptyList();
		}
		List<IResolvedOperation> result = Lists.newArrayList();
		for(IResolvedOperation operation: getAllOperations()) {
			if (operation.getDeclaration().getDeclaringType() == rawType) {
				result.add(operation);
			}
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
