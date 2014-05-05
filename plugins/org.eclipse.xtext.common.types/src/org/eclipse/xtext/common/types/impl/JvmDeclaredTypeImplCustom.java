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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.IMirrorExtension;
import org.eclipse.xtext.common.types.access.JvmTypeChangeDispatcher;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.util.RawTypeHelper.RawTypeReferenceImplementation;
import org.eclipse.xtext.resource.ISynchronizable;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmDeclaredTypeImplCustom extends JvmDeclaredTypeImpl {
	
	@Override
	public JvmArrayType getArrayType() {
		JvmArrayType result = super.getArrayType();
		if (result == null) {
			result = doSynchronized(new Provider<JvmArrayType>() {
				public JvmArrayType get() {
					JvmArrayType result = TypesFactory.eINSTANCE.createJvmArrayType();
					boolean wasDeliver = eDeliver();
					eSetDeliver(false);
					try {
						setArrayType(result);
					} finally {
						eSetDeliver(wasDeliver);
					}
					return result;
				}
			});
		}
		return result;
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.JVM_DECLARED_TYPE__ARRAY_TYPE:
				// don't demand-create the array if queried reflectively
				return arrayType;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	protected JvmDeclaredType internalGetDeclaringType() {
		JvmDeclaredType result = getDeclaringType();
		if (result == null) {
			EObject container = eContainer();
			if (container instanceof JvmFeature) {
				result = ((JvmFeature) container).getDeclaringType();
			}
		}
		return result;
	}
	
	@Override
	public String getPackageName() {
		JvmDeclaredType declaringType = internalGetDeclaringType();
		if (declaringType != null)
			return declaringType.getPackageName();
		return packageName;
	}

	@Override
	protected String computeIdentifier() {
		if (simpleName == null)
			return null;
		JvmDeclaredType declaringType = internalGetDeclaringType();
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

	protected Set<String> removedOverridden;

	@Override
	public Iterable<JvmFeature> findAllFeaturesByName(final String simpleName) {
		return doSynchronized(new Provider<Iterable<JvmFeature>>() {
			public Iterable<JvmFeature> get() {
				Map<String, Set<JvmFeature>> allFeaturesByName = getAllFeaturesMap();
				Set<JvmFeature> result = allFeaturesByName.get(simpleName);
				if (result != null) {
					if (result.size() <= 1 || (removedOverridden != null && removedOverridden.contains(simpleName))) {
						return result;
					}
					// TODO use the number of parameters as a first fast criteria
					Set<String> signatures = Sets.newHashSet();
					Iterator<JvmFeature> iter = result.iterator();
					while (iter.hasNext()) {
						JvmFeature next = iter.next();
						if (next instanceof JvmOperation) {
							JvmOperation operation = (JvmOperation) next;
							if (!operation.isStatic()) {
								/* 
								 * TODO use upper bound information for cases like
								 * class MyStringList extends ArrayList<String>
								 * where add(String) actually overrides add(T/Object)
								 */
								List<JvmFormalParameter> parameters = operation.getParameters();
								StringBuilder signature = new StringBuilder(operation.getSimpleName());
								if (parameters.isEmpty()) {
									signature.append("()");
								} else {
									signature.append("(");
									for (JvmFormalParameter parameter : parameters) {
										String parameterType = getRawTypeIdentifier(parameter.getParameterType());
										if (parameterType != null) {
											signature.append(parameterType);
											signature.append(",");
										}
									}
									signature.replace(signature.length() - 1, signature.length(), ")");
								}
								if (!signatures.add(signature.toString())) {
									iter.remove();
								}
							}
						} else if (next instanceof JvmField) {
							JvmField field = (JvmField) next;
							if (!field.isStatic() && !signatures.add(field.getSimpleName())) {
								iter.remove();
							}
						}
					}
					if (removedOverridden == null) {
						removedOverridden = Sets.newHashSet(simpleName);
					} else {
						removedOverridden.add(simpleName);
					}
					return result;
				}
				return Collections.emptyList();
			}
		});
	}

	protected <T> T doSynchronized(final Provider<? extends T> provider) {
		Resource eResource = eResource();
		if (eResource instanceof ISynchronizable<?>) {
			try {
				T result = ((ISynchronizable<?>) eResource).execute(new IUnitOfWork<T, Object>() {
					public T exec(Object state) throws Exception {
						T result = provider.get();
						return result;
					}
				});
				return result;
			} catch (RuntimeException e) {
				throw e;
			} catch (Exception e) {
				throw new WrappedException(e);
			}
		} else {
			// not in a resource, don't lock
			return provider.get();
		}
	}

	protected Map<String, Set<JvmFeature>> getAllFeaturesMap() {
		return internalGetAllFeaturesMap(null);
	}

	protected Map<String, Set<JvmFeature>> internalGetAllFeaturesMap(final Set<JvmDeclaredType> processedtypes) {
		if (allFeaturesByName == null) {
			final Set<JvmDeclaredType> processedSuperTypes = processedtypes == null ? Sets.<JvmDeclaredType>newHashSet() : processedtypes;
			allFeaturesByName = doSynchronized(new Provider<Map<String, Set<JvmFeature>>>() {
				public Map<String, Set<JvmFeature>> get() {
					if (allFeaturesByName != null)
						return allFeaturesByName;
					Map<String, Set<JvmFeature>> result = Maps.newLinkedHashMap();
					processMembers(result, getMembers());
					for (JvmTypeReference superTypeReference : getSuperTypes()) {
						JvmType superType = getRawType(superTypeReference);
						if (superType instanceof JvmDeclaredTypeImplCustom && !superType.eIsProxy()
								&& !processedSuperTypes.contains(superType)) {
							processedSuperTypes.add((JvmDeclaredType) superType);
							Map<String, Set<JvmFeature>> superTypeFeatureMap = ((JvmDeclaredTypeImplCustom) superType)
									.internalGetAllFeaturesMap(processedSuperTypes);
							processedSuperTypes.remove(superType);
							for (Set<JvmFeature> features : superTypeFeatureMap.values())
								processMembers(result, features);
						}
					}
					Runnable runnable = new Runnable() {
						public void run() {
							doSynchronized(new Provider<Object>() {
								public Object get() {
									removedOverridden = null;
									allFeaturesByName = null;
									return null;
								}});
						}
					};
					requestNotificationOnChange(runnable);
					return result;
				}
			});
		}
		return allFeaturesByName;
	}

	protected void requestNotificationOnChange(Runnable listener) {
		Resource resource = eResource();
		if (resource instanceof TypeResource) {
			IMirror mirror = ((TypeResource) resource).getMirror();
			if (mirror instanceof IMirrorExtension) {
				if (((IMirrorExtension) mirror).isSealed())
					return;
			}
		}
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
		for (JvmMember member : members) {
			if (member instanceof JvmOperation || member instanceof JvmField) {
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
			allFeatures = doSynchronized(new Provider<Set<JvmFeature>>() {
				public Set<JvmFeature> get() {
					if (allFeatures != null)
						return allFeatures;
					Set<JvmFeature> result = Sets.newLinkedHashSet();
					Map<String, Set<JvmFeature>> allFeaturesMap = getAllFeaturesMap();
					for (String name : allFeaturesMap.keySet()) {
						Iterables.addAll(result, findAllFeaturesByName(name));
					}
					Runnable runnable = new Runnable() {
						public void run() {
							doSynchronized(new Provider<Object>() {
								public Object get() {
									allFeatures = null;
									return null;
								}});
						}
					};
					requestNotificationOnChange(runnable);
					return result;
				}});
		}
		return allFeatures;
	}
	
	protected String getRawTypeIdentifier(JvmTypeReference reference) {
		if (reference instanceof JvmParameterizedTypeReference) {
			JvmType typeOrProxy = (JvmType) reference.eGet(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, false);
			if (typeOrProxy.eIsProxy()) {
				URI uri = ((InternalEObject)typeOrProxy).eProxyURI();
				if (URIHelperConstants.PROTOCOL.equals(uri.scheme())) {
					if (URIHelperConstants.PRIMITIVES.regionMatches(1, uri.segment(0), 0, URIHelperConstants.PRIMITIVES.length() - 1)) {
						String fragment = uri.fragment();
						return fragment;
					} else if (URIHelperConstants.OBJECTS.regionMatches(1, uri.segment(0), 0, URIHelperConstants.OBJECTS.length() - 2)) {
						String fragment = uri.fragment();
						if (fragment.lastIndexOf('/') == -1)
							return fragment;
					}
				}
			}
		}
		RawTypeReferenceImplementation strategy = new RawTypeReferenceImplementation(TypesFactory.eINSTANCE);
		JvmTypeReference result = strategy.getRawTypeReference(reference, eResource());
		if (result == null)
			return null;
		JvmType rawResult = result.getType();
		return rawResult == null ? null : rawResult.getIdentifier();
	}

	protected JvmType getRawType(JvmTypeReference reference) {
		RawTypeReferenceImplementation strategy = new RawTypeReferenceImplementation(TypesFactory.eINSTANCE);
		JvmTypeReference result = strategy.getRawTypeReference(reference, eResource());
		return result == null ? null : result.getType();
	}
}
