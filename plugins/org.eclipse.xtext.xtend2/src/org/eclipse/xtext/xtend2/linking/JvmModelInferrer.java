/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.linking;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmModelInferrer {

	@Inject
	protected TypesFactory typesFactory;
	
	@Inject
	private XtendSourceAssociator associator;
	
	@Inject
	private ITypeProvider typeProvider;
	
	public JvmGenericType inferJvmGenericType(XtendClass xtendClass) {
		return transform(xtendClass);
	}

	protected JvmGenericType transform(XtendClass source) {
		JvmGenericType target = typesFactory.createJvmGenericType();
		target.setFullyQualifiedName(source.getCanonicalName());
		target.setVisibility(JvmVisibility.PUBLIC);
		for(JvmTypeReference superType: source.getSuperTypes()) 
			target.getSuperTypes().add(cloneWithProxies(superType));
		for(JvmTypeParameter typeParameter: source.getTypeParameters()) 
			target.getTypeParameters().add(cloneWithProxies(typeParameter));
		for(XtendMember member: source.getMembers())
			target.getMembers().add(transform(member));
		associator.associate(target, source);
		return target;
	}
	
	protected JvmMember transform(XtendMember sourceMember) {
		if(sourceMember instanceof XtendFunction) {
			XtendFunction source = (XtendFunction) sourceMember;
			JvmOperation target = typesFactory.createJvmOperation();
			target.setFullyQualifiedName(source.getCanonicalName());
			for(JvmFormalParameter parameter: source.getParameters())
				target.getParameters().add(cloneWithProxies(parameter));
			target.setReturnType(cloneWithProxies(source.getReturnType()));
			for(JvmTypeParameter typeParameter: source.getTypeParameters())
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

	public void computeInferredReturnTypes(JvmGenericType inferredJvmType) {
		Iterable<JvmOperation> operations = inferredJvmType.getDeclaredOperations();
		for (JvmOperation jvmOperation : operations) {
			if (jvmOperation.getReturnType()==null) {
				XtendFunction func = associator.getAssociatedElement(jvmOperation);
				JvmTypeReference reference = typeProvider.getType(func.getExpression());
				jvmOperation.setReturnType(reference);
			}
		}
	}
	
}
