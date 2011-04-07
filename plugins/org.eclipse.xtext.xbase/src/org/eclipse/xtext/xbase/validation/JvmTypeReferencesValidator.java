/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmTypeReferencesValidator extends AbstractDeclarativeValidator {
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private Primitives primitives;
	
	@Override
	protected List<EPackage> getEPackages() {
		return newArrayList(TypesPackage.eINSTANCE, XtypePackage.eINSTANCE);
	}
	
	@Check
	public void checkTypeArgumentsNotPrimitive(JvmParameterizedTypeReference typeRef) {
		EList<JvmTypeReference> arguments = typeRef.getArguments();
		for (int i=0;i<arguments.size();i++) {
			JvmTypeReference jvmTypeReference = arguments.get(i);
			checkNotPrimitive(jvmTypeReference);
		}
	}
	
	@Check
	public void checkTypeArgumentsNotPrimitive(JvmTypeConstraint typeRef) {
		checkNotPrimitive(typeRef.getTypeReference());
	}
	
	protected void checkNotPrimitive(JvmTypeReference jvmTypeReference) {
		if (primitives.isPrimitive(jvmTypeReference)) {
			error("The primitive '"+jvmTypeReference.getIdentifier()+"' cannot be a type argument", jvmTypeReference, null, IssueCodes.INVALID_USE_OF_TYPE);
		}
	}
	
	@Check
	public void checkJvmFormalParameterNotPrimitiveVoid(JvmFormalParameter param) {
		if (typeReferences.is(param.getParameterType(), Void.TYPE)) {
			error("The primitive 'void' cannot be the type of a parameter", param.getParameterType(), null, IssueCodes.INVALID_USE_OF_TYPE);
		}
	}
}
