/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.typing;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * Xtend specific extension to the {@link TypeArgumentContextProvider} that is aware
 * of the inferred {@link IJvmModelAssociations jvm model}.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtendTypeArgumentContextProvider extends TypeArgumentContextProvider {

	@Inject
	private IJvmModelAssociations jvmAssociations;
	
	/**
	 * {@inheritDoc}
	 * 
	 * <p>This implementation uses the type parameters that are declared in the original
	 * method instead of the inferred {@link JvmTypeParameterDeclarator declarator} to match arguments
	 * and type parameters.</p>
	 * <p>This is due to the fact that the created {@link TypeArgumentContext}
	 * considers the identity of the {@link org.eclipse.xtext.common.types.JvmTypeParameter type parameters}.</p>
	 */
	@Override
	public TypeArgumentContext getExplicitMethodInvocationContext(JvmTypeParameterDeclarator parameterDeclarator,
			JvmTypeReference receiverType, List<JvmTypeReference> typeArguments) {
		TypeArgumentContext result;
		EObject sourceElement = jvmAssociations.getPrimarySourceElement(parameterDeclarator);
		if (sourceElement instanceof JvmTypeParameterDeclarator)
			result = super.getExplicitMethodInvocationContext((JvmTypeParameterDeclarator) sourceElement, receiverType, typeArguments);
		else
			result = super.getExplicitMethodInvocationContext(parameterDeclarator, receiverType, typeArguments);
		return result;
	}
	
}
