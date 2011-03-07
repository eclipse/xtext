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

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
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
import org.eclipse.xtext.xtend2.xtend2.DeclaredDependency;
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
		target.setPackageName(source.getPackageName());
		target.setSimpleName(source.getName());
		target.setVisibility(JvmVisibility.PUBLIC);
		associator.associate(target, source);
		addConstructor(source, target);
		for (JvmTypeReference superType : source.getSuperTypes())
			target.getSuperTypes().add(EcoreUtil2.cloneWithProxies(superType));
		for (JvmTypeParameter typeParameter : source.getTypeParameters())
			target.getTypeParameters().add(EcoreUtil2.cloneWithProxies(typeParameter));
		for (XtendMember member : source.getMembers())
			if (member.getName() != null)
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
			operation.setSimpleName(key.getFirst());
			operation.setVisibility(JvmVisibility.PUBLIC);
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
				if (commonType != null)
					parameter.setParameterType(EcoreUtil2.cloneIfContained(commonType));
				result.getParameters().add(parameter);
			}
		}
		for (JvmOperation jvmOperation : operations) {
			Iterable<XtendFunction> xtendFunctions = associator.getAssociatedElements(jvmOperation, XtendFunction.class);
			for (XtendFunction func : xtendFunctions) {
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
		constructor.setSimpleName(source.getName());
		constructor.setVisibility(JvmVisibility.PUBLIC);
	}

	protected JvmMember transform(XtendMember sourceMember) {
		if (sourceMember instanceof XtendFunction) {
			XtendFunction source = (XtendFunction) sourceMember;
			JvmOperation target = typesFactory.createJvmOperation();
			associator.associate(target, source);
			String sourceName = source.getName();
			if (source.isDispatch()) {
				sourceName = "_" + sourceName;
			}
			target.setSimpleName(sourceName);
			target.setVisibility(JvmVisibility.PUBLIC);
			for (JvmFormalParameter parameter : source.getParameters())
				target.getParameters().add(EcoreUtil2.cloneWithProxies(parameter));
			inferReturnType(target);
			for (JvmTypeParameter typeParameter : source.getTypeParameters())
				target.getTypeParameters().add(EcoreUtil2.cloneWithProxies(typeParameter));
			return target;
		} else if (sourceMember instanceof DeclaredDependency) {
			DeclaredDependency dep = (DeclaredDependency) sourceMember;
			JvmField field = typesFactory.createJvmField();
			associator.associate(field, dep);
			field.setVisibility(JvmVisibility.PRIVATE);
			field.setSimpleName(dep.getName());
			field.setType(EcoreUtil2.cloneWithProxies(dep.getType()));
			return field;
		}
		throw new IllegalArgumentException("Cannot transform " + notNull(sourceMember) + " to a JvmMember");
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
			JvmTypeReference type = typeProvider.getTypeForIdentifiable(func);
			if (type != null)
				associatedReturnTypes.add(type);
		}
		if (!associatedReturnTypes.isEmpty()) {
			JvmTypeReference commonSuperType = typeConformanceComputer.getCommonSuperType(associatedReturnTypes);
			return EcoreUtil2.cloneWithProxies(commonSuperType);
		}
		return null;
	}

}
