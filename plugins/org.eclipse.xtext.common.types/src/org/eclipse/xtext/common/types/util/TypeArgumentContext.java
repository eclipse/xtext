/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstraintOwner;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider.Factory;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider.ResolveInfo;

import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class TypeArgumentContext {
	
	private static final Logger logger = Logger.getLogger(TypeArgumentContext.class);

	private Map<JvmTypeParameter, ResolveInfo> context;
	private Factory typeProviderFactory;
	private TypeReferences typeReferences;
	
	public TypeArgumentContext(Map<JvmTypeParameter, ResolveInfo> context, IJvmTypeProvider.Factory typeProviderFactory, TypeReferences typeReferences) {
		if (context==null)
			throw new NullPointerException("context");
		if (typeProviderFactory==null)
			throw new NullPointerException("typeProviderFactory");
		if (typeReferences==null)
			throw new NullPointerException("typeReferences");
		this.context = context;
		this.typeProviderFactory = typeProviderFactory;
		this.typeReferences = typeReferences;  
	}

	public JvmTypeReference getBoundArgument(JvmTypeParameter param) {
		ResolveInfo info = context.get(param);
		if (info == null)
			return null;
		return info.reference;
	}
	
	/**
	 * Resolve the reference for a contravariant location, i.e. returns the lower bound.
	 * @return the lower bound of a reference or <code>null</code> if there is no lower bound.
	 */
	public JvmTypeReference getLowerBound(JvmTypeReference element) {
		JvmTypeReference copy = doGetResolvedCopy(element);
		if (copy instanceof JvmWildcardTypeReference) {
			for(JvmTypeConstraint constraint: ((JvmWildcardTypeReference) copy).getConstraints()) {
				if (constraint instanceof JvmLowerBound) {
					JvmTypeReference lowerBound = constraint.getTypeReference();
					return lowerBound;
				}
			}
			// only upper bounds set - no valid contravariant value
			return null;
		}
		removeObjectLowerBound(copy);
		return copy;
	}
	
	// TODO: transitive?
	protected void removeObjectLowerBound(JvmTypeReference copy) {
		if (copy instanceof JvmParameterizedTypeReference) {
			ListIterator<JvmTypeReference> argumentIter = ((JvmParameterizedTypeReference) copy).getArguments().listIterator();
			while(argumentIter.hasNext()) {
				JvmTypeReference argument = argumentIter.next();
				if (argument instanceof JvmWildcardTypeReference) {
					Iterator<JvmTypeConstraint> constraintIter = ((JvmWildcardTypeReference) argument).getConstraints().iterator();
					while(constraintIter.hasNext()) {
						JvmTypeConstraint constraint = constraintIter.next();
						if (constraint instanceof JvmLowerBound) {
							if (typeReferences.isInstanceOf(constraint.getTypeReference(), Object.class)) {
								constraintIter.remove();
								argumentIter.set(constraint.getTypeReference());
								break;
							}
						}
					}
				}
			}
		}
		
	}

	/**
	 * Resolve the reference for a covariant location, i.e. returns the upper bound.
	 * @return the upper bound of a reference.
	 */
	public JvmTypeReference getUpperBound(JvmTypeReference element, Notifier context) {
		JvmTypeReference copy = doGetResolvedCopy(element);
		if (copy instanceof JvmWildcardTypeReference) {
			for(JvmTypeConstraint constraint: ((JvmWildcardTypeReference) copy).getConstraints()) {
				if (constraint instanceof JvmUpperBound)
					return constraint.getTypeReference();
			}
			// no explicit upper bound given - return object
			IJvmTypeProvider provider = typeProviderFactory.findOrCreateTypeProvider(getResourceSet(context));
			JvmType objectType = provider.findTypeByName(Object.class.getCanonicalName());
			return typeReferences.createTypeRef(objectType);
		}
		return copy;
	}
	
	protected ResourceSet getResourceSet(Notifier context2) {
		if (context2 == null)
			throw new NullPointerException("the passed context needs to be a or be contained in a ResourceSet.");
		ResourceSet resourceSet = EcoreUtil2.getResourceSet(context2);
		if (resourceSet!=null)
			return resourceSet;
		throw new IllegalArgumentException(" a notifier must be either an EObject, a Resource or a ResourceSet");
	}

	/**
	 * Resolves and returns the reference
	 * @return the resolved reference.
	 */
	public JvmTypeReference resolve(JvmTypeReference element) {
		JvmTypeReference copy = doGetResolvedCopy(element);
		return copy;
	}

	protected JvmTypeReference doGetResolvedCopy(JvmTypeReference element) {
		return doGetResolvedCopy(element, Sets.<JvmType>newHashSet(), Maps.<JvmType, JvmTypeReference>newHashMap());
	}
	
	protected JvmTypeReference doGetResolvedCopy(JvmTypeReference element, final Set<JvmType> resolving, final Map<JvmType, JvmTypeReference> unresolved) {
		if (logger.isDebugEnabled())
			logger.debug("doGetResolvedCopy: " + element + " in context " + this + " resolving: " + resolving + " unresolved: " + unresolved);
		
		@SuppressWarnings("serial")
		EcoreUtil.Copier copier = new EcoreUtil.Copier(false,true) {

			@Override
			public EObject copy(EObject object) {
				EObject resolvedObject = resolveTypeParameters(object);
				EObject result = super.copy(resolvedObject);
				return result;
			}
			
			protected EObject resolveTypeParameters(EObject object) {
				if (object instanceof JvmParameterizedTypeReference) {
					JvmParameterizedTypeReference parameterizedTypeRef = (JvmParameterizedTypeReference) object;
					JvmType type = parameterizedTypeRef.getType();
					if (type instanceof JvmTypeParameter) {
						if (resolving.add(type)) {
							try {
								JvmTypeReference resolved = TypeArgumentContext.this.getBoundArgument((JvmTypeParameter) type);
								if (resolved!=null && resolved != object) {
									if (resolved.getType() == type) {
										return parameterizedTypeRef;
									}
									// wildcard
									if (resolved.getType() == null) {
										if (object.eContainer() instanceof JvmTypeConstraint) {
											return object;
										}
										if (!unresolved.containsKey(type)) {
											JvmTypeReference resolvedCopy = doGetResolvedCopy(resolved, resolving, unresolved);
											unresolved.put(type, resolvedCopy);
											return resolvedCopy;
										} else {
											JvmTypeReference resolvedCopy = unresolved.get(type);
											return EcoreUtil2.clone(resolvedCopy);
										}
									}
									Set<JvmParameterizedTypeReference> referencesToBeReplaced = Sets.newHashSet();
									resolved = EcoreUtil2.cloneIfContained(resolved);
									Iterator<JvmParameterizedTypeReference> iterator = Iterators.filter(EcoreUtil2.eAll(resolved), JvmParameterizedTypeReference.class);
									while(iterator.hasNext()) {
										JvmParameterizedTypeReference containedReference = iterator.next();
										if (resolving.contains(containedReference.getType())) {
											referencesToBeReplaced.add(containedReference);
										}
									}
									if (referencesToBeReplaced.isEmpty()) {
										JvmTypeReference resolvedCopy = doGetResolvedCopy(resolved, resolving, unresolved);
										return resolveTypeParameters(resolvedCopy);
									} else {
										for(JvmParameterizedTypeReference replaceMe: referencesToBeReplaced) {
											if (replaceMe.eContainer() instanceof JvmTypeConstraint) {
												JvmTypeConstraint containerConstraint = (JvmTypeConstraint) replaceMe.eContainer();
												JvmConstraintOwner constraintOwner = (JvmConstraintOwner) replaceMe.getType();
												for(JvmTypeConstraint constraint: constraintOwner.getConstraints()) {
													if (constraint.eClass() == containerConstraint.eClass()) {
														containerConstraint.setTypeReference(EcoreUtil2.clone(constraint.getTypeReference()));
														break;
													}
												}
											} else {
												JvmConstraintOwner constraintOwner = (JvmConstraintOwner) replaceMe.getType();
												JvmWildcardTypeReference wildCard = typeReferences.wildCard();
												for(JvmTypeConstraint constraint: constraintOwner.getConstraints()) {
													wildCard.getConstraints().add(EcoreUtil2.clone(constraint));
												}
												EcoreUtil.replace(replaceMe, wildCard);
											}
										}
										JvmTypeReference resolvedCopy = doGetResolvedCopy(resolved, resolving, unresolved);
										return resolveTypeParameters(resolvedCopy);
									}
								} else {
									return typeReferences.createTypeRef(type);
								}
							} finally {
								resolving.remove(type);
							}
						}
					}
				}
				return object;
			}
		};
		JvmTypeReference copy = (JvmTypeReference) copier.copy(element);
		copier.copyReferences();
		
		if (logger.isDebugEnabled())
			logger.debug("doGetResolvedCopy: " + element + " resolved to: " + copy);
		return copy;
	}

	@Override
	public String toString() {
		return context.toString();
	}
	
	protected Map<JvmTypeParameter, ResolveInfo> getContextMap() {
		return context;
	}

}
