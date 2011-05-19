/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.jvmmodel;

import static com.google.common.collect.Iterables.*;
import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xtend2.dispatch.DispatchingSupport;
import org.eclipse.xtext.xtend2.resource.Xtend2Resource;
import org.eclipse.xtext.xtend2.xtend2.XtendField;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;
import org.eclipse.xtext.xtend2.xtend2.XtendParameter;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2JvmModelInferrer implements IJvmModelInferrer {

	@Inject
	protected TypesFactory typesFactory;
	
	@Inject
	private IJvmModelAssociator associator;

	@Inject
	private IJvmModelAssociations associations;

	@Inject
	private DispatchingSupport dispatchingSupport;
	
	public List<? extends JvmDeclaredType> inferJvmModel(EObject xtendFile) {
		associator.disassociate(xtendFile);
		final XtendFile xtendFile2 = (XtendFile)xtendFile;
		if (xtendFile2.getXtendClass()==null || xtendFile2.getXtendClass().getName()==null)
			return emptyList();
		JvmGenericType inferredJvmType = transform(xtendFile2.getXtendClass());
		return singletonList(inferredJvmType);
	}

	protected JvmGenericType transform(XtendClass source) {
		JvmGenericType target = typesFactory.createJvmGenericType();
		source.eResource().getContents().add(target);
		associator.associatePrimary(source, target);
		target.setPackageName(source.getPackageName());
		target.setSimpleName(source.getName());
		target.setVisibility(JvmVisibility.PUBLIC);
		addConstructor(source, target);
		for (JvmTypeReference superType : source.getSuperTypes())
			target.getSuperTypes().add(EcoreUtil2.cloneWithProxies(superType));
		for (JvmTypeParameter typeParameter : source.getTypeParameters())
			target.getTypeParameters().add(EcoreUtil2.cloneWithProxies(typeParameter));
		for (XtendMember member : source.getMembers()) {
			if (member instanceof XtendField && ((XtendField) member).getName()!=null
				|| member instanceof XtendFunction && ((XtendFunction) member).getName()!=null) {
				transform(member, target);
			}
		}
		appendSyntheticDispatchMethods(source, target);
		computeInferredReturnTypes(target);
		return target;
	}

	protected void appendSyntheticDispatchMethods(XtendClass source, JvmGenericType target) {
		Multimap<Pair<String, Integer>, JvmOperation> methods = dispatchingSupport.getDispatchMethods(target);
		for (Pair<String, Integer> key : methods.keySet()) {
			Collection<JvmOperation> operations = methods.get(key);
			JvmOperation operation = deriveGenericDispatchOperationSignature(dispatchingSupport.sort(operations), target);
			operation.setSimpleName(key.getFirst());
			operation.setVisibility(JvmVisibility.PUBLIC);
		}
	}

	/**
	 * @return a {@link JvmOperation} with common denominator argument types of all given operations
	 */
	protected JvmOperation deriveGenericDispatchOperationSignature(Collection<JvmOperation> operations, JvmGenericType target) {
		if (operations.isEmpty())
			return null;
		final Iterator<JvmOperation> iterator = operations.iterator();
		JvmOperation first = iterator.next();
		JvmOperation result = typesFactory.createJvmOperation();
		target.getMembers().add(result);
		for (int i = 0; i < first.getParameters().size(); i++) {
			JvmFormalParameter parameter = typesFactory.createJvmFormalParameter();
			result.getParameters().add(parameter);
			parameter.setParameterType(getTypeProxy(parameter));
			JvmFormalParameter parameter2 = first.getParameters().get(i);
			parameter.setName(parameter2.getName());
		}
		for (JvmOperation jvmOperation : operations) {
			Iterable<XtendFunction> xtendFunctions = filter(associations.getSourceElements(jvmOperation), XtendFunction.class);
			for (XtendFunction func : xtendFunctions) {
				associator.associate(func, result);
			}
		}
		return result;
	}

	protected void addConstructor(XtendClass source, JvmGenericType target) {
		JvmConstructor constructor = typesFactory.createJvmConstructor();
		target.getMembers().add(constructor);
		associator.associatePrimary(source, constructor);
		constructor.setSimpleName(source.getName());
		constructor.setVisibility(JvmVisibility.PUBLIC);
	}

	protected JvmMember transform(XtendMember sourceMember, JvmGenericType container) {
		if (sourceMember instanceof XtendFunction) {
			XtendFunction source = (XtendFunction) sourceMember;
			JvmOperation target = typesFactory.createJvmOperation();
			container.getMembers().add(target);
			associator.associatePrimary(source, target);
			String sourceName = source.getName();
			JvmVisibility visibility = JvmVisibility.PUBLIC;
			if (source.isDispatch()) {
				sourceName = "_" + sourceName;
				visibility = JvmVisibility.PROTECTED;
			}
			target.setSimpleName(sourceName);
			target.setVisibility(visibility);
			for (XtendParameter parameter : source.getParameters()) {
				JvmFormalParameter jvmParam = typesFactory.createJvmFormalParameter();
				jvmParam.setName(parameter.getName());
				jvmParam.setParameterType(EcoreUtil2.cloneWithProxies(parameter.getParameterType()));
				target.getParameters().add(jvmParam);
			}
			if (source.getReturnType()!=null) {
				target.setReturnType(EcoreUtil2.cloneWithProxies(source.getReturnType()));
			} else {
				target.setReturnType(getTypeProxy(target));
			}
			for (JvmTypeParameter typeParameter : source.getTypeParameters())
				target.getTypeParameters().add(EcoreUtil2.cloneWithProxies(typeParameter));
			return target;
		} else if (sourceMember instanceof XtendField) {
			XtendField dep = (XtendField) sourceMember;
			JvmField field = typesFactory.createJvmField();
			container.getMembers().add(field);
			associator.associatePrimary(dep, field);
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
			jvmOperation.setReturnType(getTypeProxy(jvmOperation));
		}
	}

	protected JvmTypeReference getTypeProxy(EObject pointer) {
		JvmParameterizedTypeReference typeReference = typesFactory.createJvmParameterizedTypeReference();
		final Resource eResource = pointer.eResource();
		String fragment = eResource.getURIFragment(pointer);
		URI uri = eResource.getURI();
		uri = uri.appendFragment(Xtend2Resource.FRAGMENT_PREFIX+fragment);
		((InternalEObject)typeReference).eSetProxyURI(uri);
		return typeReference;
	}

}
