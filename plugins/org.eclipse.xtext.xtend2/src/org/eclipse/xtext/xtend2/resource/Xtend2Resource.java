/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.resource;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmConstraintOwner;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.resource.XbaseResource;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.JvmOnlyTypeConformanceComputer;
import org.eclipse.xtext.xtend2.dispatch.DispatchingSupport;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.typing.XtendOverridesService;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Xtend2Resource extends XbaseResource {

	public static final String FRAGMENT_PREFIX = "§lazyType$";
	public static final Logger LOG = Logger.getLogger(Xtend2Resource.class);
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Inject
	private IXtend2JvmAssociations associations;
	
	@Inject
	private TypeConformanceComputer typeConformanceComputer;
	
	@Inject
	private JvmOnlyTypeConformanceComputer jvmTypeConformanceComputer;
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private DispatchingSupport dispatchingSupport;
	
	@Inject
	private XtendOverridesService overridesService;
	
	private Set<String> computingFragments = newLinkedHashSet();

	@Override
	public synchronized EObject getEObject(String uriFragment) {
		if (!uriFragment.startsWith(FRAGMENT_PREFIX)) 
			return super.getEObject(uriFragment);
		if (!computingFragments.add(uriFragment)) 
			return null;
		try {
			final String fragmentToJvmOperation = uriFragment.substring(FRAGMENT_PREFIX.length());
			final EObject eObject = super.getEObject(fragmentToJvmOperation);
			if (eObject instanceof XExpression) {
				return EcoreUtil2.cloneIfContained(typeProvider.getType((XExpression)eObject));
			} else if (eObject instanceof JvmOperation) {
				JvmOperation op  = (JvmOperation) eObject;
				JvmTypeReference typeReference = inferReturnType(op);
				if (typeReference==null || typeReference.getType() == null)
					return typeReferences.getTypeForName(Object.class, getContents().get(0));
				if (typeReference.eContainer()!=null && typeReference.eContainer()!=op) {
					typeReference = EcoreUtil2.cloneWithProxies(typeReference);
				}
				return typeReference;
			} else if (eObject instanceof JvmFormalParameter) {
				JvmFormalParameter param = (JvmFormalParameter) eObject;
				JvmOperation op = (JvmOperation) param.eContainer();
				Multimap<Pair<String, Integer>, JvmOperation> dispatchMethods = dispatchingSupport.getDispatchMethods((JvmGenericType) op.getDeclaringType());
				Collection<JvmOperation> dispatchOperations = dispatchMethods.get(Tuples.pair(op.getSimpleName(), op.getParameters().size()));
				final int index = op.getParameters().indexOf(param);
				JvmTypeReference commonType = commonType(dispatchOperations, new Function<JvmOperation, JvmTypeReference>() {
					public JvmTypeReference apply(JvmOperation from) {
						return from.getParameters().get(index).getParameterType();
					}
				});
				if (commonType != null && commonType.eContainer()!=null) {
					commonType = EcoreUtil2.cloneWithProxies(commonType);
				}
				return commonType;
			} else {
				throw new IllegalStateException("couldn't resolve type proxy in "+eObject);
			}
		} catch (RuntimeException e) {
			if (LOG.isInfoEnabled())
				LOG.info(e.getMessage(), e);
			throw e;
		} finally {
			computingFragments.remove(uriFragment);
		}
	}
	
	protected JvmTypeReference inferReturnType(JvmOperation jvmOperation) {
		List<JvmTypeReference> associatedReturnTypes = newArrayList();
		final Iterable<XtendFunction> associatedElements = filter(associations.getSourceElements(jvmOperation), XtendFunction.class);
		boolean wasDispatch = false;
		for (XtendFunction func : associatedElements) {
			JvmTypeReference type = computeReturnType(func);
			if (type != null && !(type instanceof JvmAnyTypeReference))
				associatedReturnTypes.add(type);
			wasDispatch |= func.isDispatch();
		}
		if (wasDispatch) {
			if (jvmOperation.getSimpleName().startsWith("_")) {
				for(XtendFunction func: associatedElements) {
					if (func.getReturnType() != null) {
						return EcoreUtil2.cloneWithProxies(func.getReturnType());	
					}
					JvmOperation overriddenOperation = overridesService.findOverriddenOperation(jvmOperation);
					if (overriddenOperation != null) {
						JvmTypeReference result = overriddenOperation.getReturnType();
						return EcoreUtil2.cloneWithProxies(result);
					}
					JvmOperation dispatchOperation = associations.getDispatchOperation(func);
					if (dispatchOperation != null) {
						JvmTypeReference result = dispatchOperation.getReturnType();
						return EcoreUtil2.cloneWithProxies(result);
					}
				}
			} else {
				JvmOperation overriddenOperation = overridesService.findOverriddenOperation(jvmOperation);
				if (overriddenOperation != null) {
					JvmTypeReference result = overriddenOperation.getReturnType();
					return EcoreUtil2.cloneWithProxies(result);
				}
			}
		}
		if (!associatedReturnTypes.isEmpty()) {
			JvmTypeReference commonSuperType = typeConformanceComputer.getCommonSuperType(associatedReturnTypes);
			return commonSuperType;
		}
		return null;
	}
	
	protected <T> JvmTypeReference commonType(Iterable<? extends T> iterable, Function<T, JvmTypeReference> mapping) {
		List<JvmTypeReference> references = newArrayList();
		for (T element : iterable) {
			JvmTypeReference apply = mapping.apply(element);
			if (!typeReferences.isNullOrProxy(apply) && !typeReferences.is(apply, Void.class)) {
				references.add(apply);
			}
		}
		if (references.isEmpty()) {
			// broken model - include Void.class in parameter type computation
			for (T element : iterable) {
				JvmTypeReference apply = mapping.apply(element);
				if (!typeReferences.isNullOrProxy(apply)) {
					references.add(apply);
				}
			}	
		}
		JvmTypeReference result = jvmTypeConformanceComputer.getCommonSuperType(references);
		while(result instanceof JvmMultiTypeReference) {
			result = jvmTypeConformanceComputer.getCommonSuperType(((JvmMultiTypeReference) result).getReferences());
		}
		return result;
	}
	
	protected JvmTypeReference computeReturnType(XtendFunction function) {
		JvmTypeReference declaredOrInferredReturnType = getDeclaredOrOverriddenReturnType(function);
		if (declaredOrInferredReturnType != null)
			return declaredOrInferredReturnType;
		JvmTypeReference returnType = typeProvider.getCommonReturnType(function.getExpression(), true);
		if (returnType!=null && returnType.getType() != null) {
			JvmOperation operation = associations.getDirectlyInferredOperation(function);
			if (operation == null)
				return null;
			JvmDeclaredType declaringType = operation.getDeclaringType();
			for(JvmTypeReference reference: Iterables.filter(EcoreUtil2.eAllContents(returnType), JvmTypeReference.class)) {
				if (reference.getType() instanceof JvmTypeParameter) {
					JvmTypeParameter parameter = (JvmTypeParameter) reference.getType();
					if (parameter.getDeclarator() != declaringType && parameter.getDeclarator() != operation) {
						returnType = EcoreUtil2.cloneIfContained(returnType);
						Set<JvmTypeReference> replaceUs = Sets.newHashSet();
						for(JvmTypeReference containerOfReplaced: Iterables.filter(EcoreUtil2.eAllContents(returnType), JvmTypeReference.class)) {
							if (containerOfReplaced.getType() instanceof JvmTypeParameter)
								replaceUs.add(containerOfReplaced);
						}
						for(JvmTypeReference replaceMe: replaceUs) {
							if (replaceMe.eContainer() instanceof JvmTypeConstraint) {
								JvmTypeConstraint containerConstraint = (JvmTypeConstraint) replaceMe.eContainer();
								JvmConstraintOwner constraintOwner = (JvmConstraintOwner) replaceMe.getType();
								for(JvmTypeConstraint constraint: constraintOwner.getConstraints()) {
									if (constraint.eClass() == containerConstraint.eClass()) {
										containerConstraint.setTypeReference(EcoreUtil2.clone(constraint.getTypeReference()));
										break;
									}
								}
							} else if (replaceMe.eContainer() != null) {
								JvmConstraintOwner constraintOwner = (JvmConstraintOwner) replaceMe.getType();
								JvmWildcardTypeReference wildCard = typeReferences.wildCard();
								for(JvmTypeConstraint constraint: constraintOwner.getConstraints()) {
									wildCard.getConstraints().add(EcoreUtil2.clone(constraint));
								}
								EcoreUtil.replace(replaceMe, wildCard);
							} else {
								JvmConstraintOwner constraintOwner = (JvmConstraintOwner) replaceMe.getType();
								List<JvmTypeReference> superTypes = Lists.newArrayListWithExpectedSize(constraintOwner.getConstraints().size());
								for(JvmTypeConstraint constraint: constraintOwner.getConstraints()) {
									if (constraint instanceof JvmUpperBound) {
										superTypes.add(constraint.getTypeReference());
									}
								}
								if (superTypes.isEmpty())
									return typeReferences.getTypeForName(Object.class, function);
								return typeConformanceComputer.getCommonSuperType(superTypes);
							}
						}
						return returnType;
					}
				}
			}
			return returnType;
		}
		return typeReferences.getTypeForName(Object.class, function);
	}
	
	public JvmTypeReference getDeclaredOrOverriddenReturnType(XtendFunction func) {
		if (func.getReturnType() != null)
			return func.getReturnType();
		if (func.isOverride()) {
			JvmTypeReference overridden = overridesService.getOverriddenReturnType(func);
			if (overridden != null)
				return overridden;
		}
		if (func.getCreateExtensionInfo()!=null) {
			return typeProvider.getType(func.getCreateExtensionInfo().getCreateExpression());
		}
		return null;
	}
	
}
