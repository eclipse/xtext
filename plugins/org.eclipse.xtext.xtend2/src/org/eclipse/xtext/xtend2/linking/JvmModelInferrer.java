/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.linking;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;
import org.eclipse.xtext.xtend2.dispatch.DispatchingSupport;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;

import com.google.common.base.Function;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmModelInferrer {

	@Inject
	protected TypesFactory typesFactory;

	@Inject
	private Xtend2InferredJvmAssociator associator;

	@Inject
	private ITypeProvider typeProvider;

	@Inject
	private XbaseTypeConformanceComputer typeConformanceComputer;

	@Inject
	private TypeReferences typeRefs;
	
	@Inject
	private Primitives primitives;

	@Inject
	private DispatchingSupport dispatchingSupport;

	public JvmGenericType inferJvmGenericType(XtendClass xtendClass) {
		associator.disassociate(xtendClass);
		JvmGenericType inferredJvmType = transform(xtendClass);
		return inferredJvmType;
	}

	protected JvmGenericType transform(XtendClass source) {
		JvmGenericType target = typesFactory.createJvmGenericType();
		source.eResource().getContents().add(target);
		target.setFullyQualifiedName(source.getCanonicalName());
		target.setVisibility(JvmVisibility.PUBLIC);
		associator.associate(target, source);
		addConstructor(source, target);
		for (JvmTypeReference superType : source.getSuperTypes())
			target.getSuperTypes().add(cloneWithProxies(superType));
		for (JvmTypeParameter typeParameter : source.getTypeParameters())
			target.getTypeParameters().add(cloneWithProxies(typeParameter));
		for (XtendMember member : source.getMembers())
			target.getMembers().add(transform(member));
		appendSyntheticDispatchMethods(source, target);
		computeInferredReturnTypes(target);
		return target;
	}

	protected void appendSyntheticDispatchMethods(XtendClass source, JvmGenericType target) {
		Multimap<Pair<String, Integer>, JvmOperation> methods = dispatchingSupport.getDispatchMethods(target);
		for (Pair<String, Integer> key : methods.keySet()) {
			Collection<JvmOperation> operations = methods.get(key);
			JvmOperation operation = deriveGenericDispatchOperationSignature(operations);
			operation.setFullyQualifiedName(target.getCanonicalName() + "." + key.getFirst());
			target.getMembers().add(operation);
		}
	}

	/**
	 * @return a {@link JvmOperation} with common denominator argument types of all given operations
	 */
	protected JvmOperation deriveGenericDispatchOperationSignature(Collection<JvmOperation> operations) {
		if (operations.isEmpty())
			return null;
		JvmOperation result = null;
		final Iterator<JvmOperation> iterator = operations.iterator();
		JvmOperation first = iterator.next();
		if (operations.size() == 1) {
			result = EcoreUtil2.clone(first);
		} else {
			result = typesFactory.createJvmOperation();
			for (int i = 0; i < first.getParameters().size(); i++) {
				JvmFormalParameter parameter2 = first.getParameters().get(i);
				final int index = i;
				JvmTypeReference commonType = commonType(operations, new Function<JvmOperation, JvmTypeReference>() {
					public JvmTypeReference apply(JvmOperation from) {
						return from.getParameters().get(index).getParameterType();
					}
				});
				JvmFormalParameter parameter = typesFactory.createJvmFormalParameter();
				parameter.setName(parameter2.getName());
				parameter.setParameterType(EcoreUtil2.cloneIfContained(commonType));
				result.getParameters().add(parameter);
			}
		}
		for (JvmOperation jvmOperation : operations) {
			Iterable<XtendFunction> xtendFunction = associator.getAssociatedElements(jvmOperation, XtendFunction.class);
			for (XtendFunction func : xtendFunction) {
				associator.associate(func, result);
			}
		}
		return result;
	}

	protected <T> JvmTypeReference commonType(Iterable<? extends T> iterable, Function<T, JvmTypeReference> mapping) {
		List<JvmTypeReference> references = newArrayList();
		for (T element : iterable) {
			JvmTypeReference apply = mapping.apply(element);
			if (!typeRefs.isNullOrProxy(apply)) {
				apply = primitives.asWrapperTypeIfPrimitive(apply); 
				references.add(apply);
			}
		}
		return typeConformanceComputer.getCommonSuperType(references);
	}

	protected void addConstructor(XtendClass source, JvmGenericType target) {
		JvmConstructor constructor = typesFactory.createJvmConstructor();
		target.getMembers().add(constructor);
		associator.associate(source, constructor);
		constructor.setFullyQualifiedName(source.getCanonicalName());
	}

	protected JvmMember transform(XtendMember sourceMember) {
		if (sourceMember instanceof XtendFunction) {
			XtendFunction source = (XtendFunction) sourceMember;
			JvmOperation target = typesFactory.createJvmOperation();
			String canonicalName = source.getCanonicalName();
			if (source.isDispatch()) {
				int lastDot = canonicalName.lastIndexOf('.');
				canonicalName = canonicalName.substring(0, lastDot + 1) + "_" + canonicalName.substring(lastDot + 1);
				target.setFullyQualifiedName(canonicalName);
			} else {
				target.setFullyQualifiedName(canonicalName);
			}
			for (JvmFormalParameter parameter : source.getParameters())
				target.getParameters().add(cloneWithProxies(parameter));
			target.setReturnType(cloneWithProxies(source.getReturnType()));
			for (JvmTypeParameter typeParameter : source.getTypeParameters())
				target.getTypeParameters().add(cloneWithProxies(typeParameter));
			associator.associate(target, source);
			return target;
		}
		throw new IllegalArgumentException("Cannot transform " + notNull(sourceMember) + " to a JvmMember");
	}

	@SuppressWarnings("unchecked")
	protected <T extends EObject> T cloneWithProxies(T original) {
		EcoreUtil.Copier copier = new EcoreUtil.Copier(false);
		T copy = (T) copier.copy(original);
		copier.copyReferences();
		return copy;
	}

	protected void computeInferredReturnTypes(JvmGenericType inferredJvmType) {
		Iterable<JvmOperation> operations = inferredJvmType.getDeclaredOperations();
		for (JvmOperation jvmOperation : operations) {
			jvmOperation.setReturnType(inferReturnType(jvmOperation));
		}
	}

	protected JvmTypeReference inferReturnType(JvmOperation jvmOperation) {
		if (jvmOperation.getReturnType() != null)
			return jvmOperation.getReturnType();
		List<JvmTypeReference> associatedReturnTypes = newArrayList();
		for (XtendFunction func : associator.getAssociatedElements(jvmOperation, XtendFunction.class)) {
			JvmTypeReference type = typeProvider.getType(func.getExpression());
			if (type != null)
				associatedReturnTypes.add(type);
		}
		if (!associatedReturnTypes.isEmpty()) {
			JvmTypeReference commonSuperType = typeConformanceComputer.getCommonSuperType(associatedReturnTypes);
			return commonSuperType;
		}
		return null;
	}

}
