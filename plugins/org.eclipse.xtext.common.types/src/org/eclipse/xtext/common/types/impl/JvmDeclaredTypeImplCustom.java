/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.JvmTypeChangeDispatcher;
import org.eclipse.xtext.common.types.util.RawTypeHelper.RawTypeReferenceImplementation;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmDeclaredTypeImplCustom extends JvmDeclaredTypeImpl {
	
	@Override
	public String getPackageName() {
		JvmDeclaredType declaringType = getDeclaringType();
		if (declaringType != null)
			return declaringType.getPackageName();
		return packageName;
	}
	
	@Override
	protected String computeIdentifier() {
		if (simpleName == null)
			return null;
		JvmDeclaredType declaringType = getDeclaringType();
		if (declaringType == null) {
			if (Strings.isEmpty(packageName))
				return simpleName;
			return packageName + "." + simpleName;
		}
		String parentName = declaringType.getIdentifier();
		if (parentName == null)
			return null;
		return parentName + '$' + simpleName;
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		if (simpleName == null)
			return null;
		JvmDeclaredType declaringType = getDeclaringType();
		if (declaringType == null) {
			if (Strings.isEmpty(packageName))
				return simpleName;
			return packageName + "." + simpleName;
		}
		String parentName = declaringType.getQualifiedName(innerClassDelimiter);
		if (parentName == null)
			return null;
		return parentName + innerClassDelimiter + simpleName;
	}
	
	@Override
	public Iterable<JvmField> getDeclaredFields() {
		return Iterables.filter(getMembers(), JvmField.class);
	}
	
	@Override
	public Iterable<JvmOperation> getDeclaredOperations() {
		return Iterables.filter(getMembers(), JvmOperation.class);
	}
	
	protected Map<String, Set<JvmFeature>> allFeaturesByName;
	
	// TODO HashSet is not threadsafe
	protected Set<String> removedOverridden = Sets.newHashSet();
	
	@Override
	public Iterable<JvmFeature> findAllFeaturesByName(String simpleName) {
		Map<String, Set<JvmFeature>> allFeaturesByName = getAllFeaturesMap(); 
		Set<JvmFeature> result = allFeaturesByName.get(simpleName);
		if (result != null) {
			if (result.size() <= 1 || removedOverridden.contains(simpleName)) {
				return result;
			}
			// TODO use the number of parameters as a first fast criteria
			Set<String> signatures = Sets.newHashSet();
			Iterator<JvmFeature> iter = result.iterator();
			while(iter.hasNext()) {
				JvmFeature next = iter.next();
				if (next instanceof JvmOperation) {
					/* 
					 * TODO use upper bound information for cases like
					 * class MyStringList extends ArrayList<String>
					 * where add(String) actually overrides add(T/Object)
					 */
					List<JvmFormalParameter> parameters = ((JvmOperation) next).getParameters();
					StringBuilder signature = new StringBuilder(next.getSimpleName());
					if (parameters.isEmpty()) {
						signature.append("()");
					} else {
						signature.append("(");
						for(JvmFormalParameter parameter: parameters) {
							JvmType parameterType = getRawType(parameter.getParameterType());
							if (parameterType != null) {
								signature.append(parameterType.getIdentifier());
								signature.append(",");
							}
						}
						signature.replace(signature.length() - 1, signature.length(), ")");
					}
					if (!signatures.add(signature.toString())) {
						iter.remove();
					}
				} else if (next instanceof JvmField) {
					if (!signatures.add(next.getSimpleName())) {
						iter.remove();
					}
				}
			}
			removedOverridden.add(simpleName);
			return result;
		}
		return Collections.emptyList();
	}
	
	protected Map<String, Set<JvmFeature>> getAllFeaturesMap() {
		Set<JvmDeclaredType> processedSuperTypes = Sets.newHashSet();
		return internalGetAllFeaturesMap(processedSuperTypes);
	}
	
	protected Map<String, Set<JvmFeature>> internalGetAllFeaturesMap(Set<JvmDeclaredType> processedSuperTypes) {
		Map<String, Set<JvmFeature>> result = allFeaturesByName;
		if (result == null) {
			result = Maps.newLinkedHashMap();
			processMembers(result, getMembers());
			for(JvmTypeReference superTypeReference: getSuperTypes()) {
				JvmType superType = getRawType(superTypeReference);
				if (superType instanceof JvmDeclaredTypeImplCustom && !superType.eIsProxy() && !processedSuperTypes.contains(superType)) {
					processedSuperTypes.add((JvmDeclaredType) superType);
					Map<String, Set<JvmFeature>> superTypeFeatureMap = ((JvmDeclaredTypeImplCustom) superType).internalGetAllFeaturesMap(processedSuperTypes);
					processedSuperTypes.remove(superType);					
					for(Set<JvmFeature> features: superTypeFeatureMap.values())
						processMembers(result, features);
				}
			}
			Runnable runnable = new Runnable() {
				public void run() {
					removedOverridden.clear();
					allFeaturesByName = null;
				}
			};
			requestNotificationOnChange(runnable);
			allFeaturesByName = result;
		}
		return result;
	}

	protected void requestNotificationOnChange(Runnable listener) {
		Resource resource = eResource();
		Notifier notifier = this;
		if (resource != null) {
			if (resource.getResourceSet() != null)
				notifier = resource.getResourceSet();
			else
				notifier = resource;
		}
		JvmTypeChangeDispatcher dispatcher = JvmTypeChangeDispatcher.findResourceChangeDispatcher(notifier);
		dispatcher.requestNotificationOnChange(this, listener);
	}

	protected void processMembers(Map<String, Set<JvmFeature>> result, Collection<? extends JvmMember> members) {
		for(JvmMember member: members) {
			if (member instanceof JvmOperation) {
				Set<JvmFeature> knownMembers = result.get(member.getSimpleName());
				if (knownMembers == null) {
					// Sets.newLinkedHashSet(capacity) does not exist
					knownMembers = new LinkedHashSet<JvmFeature>(2);
					result.put(member.getSimpleName(), knownMembers);
				}
				knownMembers.add((JvmFeature) member);
			} else if (member instanceof JvmField) {
				Set<JvmFeature> knownMembers = result.get(member.getSimpleName());
				if (knownMembers == null) {
					// Sets.newLinkedHashSet(capacity) does not exist
					knownMembers = new LinkedHashSet<JvmFeature>(2);
					result.put(member.getSimpleName(), knownMembers);
				}
				knownMembers.add((JvmFeature) member);
			}
		}
	}

	protected Set<JvmFeature> allFeatures;
	
	@Override
	public Iterable<JvmFeature> getAllFeatures() {
		if (allFeatures == null) {
			Set<JvmFeature> result = Sets.newLinkedHashSet();
			Map<String, Set<JvmFeature>> allFeaturesMap = getAllFeaturesMap();
			for (String name : allFeaturesMap.keySet()) {
				Iterables.addAll(result, findAllFeaturesByName(name) );
			}
			Runnable runnable = new Runnable() {
				public void run() {
					allFeatures = null;
				}
			};
			requestNotificationOnChange(runnable);
			allFeatures = result;
		}
		return allFeatures;
	}

	protected JvmType getRawType(JvmTypeReference reference) {
		RawTypeReferenceImplementation strategy = new RawTypeReferenceImplementation(TypesFactory.eINSTANCE);
		JvmTypeReference result = strategy.getRawTypeReference(reference, eResource());
		return result.getType();
	}
	
}
