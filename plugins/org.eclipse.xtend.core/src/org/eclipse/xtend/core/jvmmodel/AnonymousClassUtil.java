/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;


/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class AnonymousClassUtil {

	@Nullable
	public JvmGenericType getSuperType(AnonymousClass anonymousClass) {
		JvmConstructor constructor = anonymousClass.getConstructorCall().getConstructor();
		if(constructor != null && ! constructor.eIsProxy()) {
			JvmDeclaredType declaringType = constructor.getDeclaringType();
			if(!declaringType.getSuperTypes().isEmpty()) {
				JvmType superType = declaringType.getSuperTypes().get(0).getType();
				if(superType instanceof JvmGenericType)
					return (JvmGenericType) superType;
			}
		}
		return null;
	}
	
	public JvmConstructor getSuperTypeConstructor(AnonymousClass anonymousClass) {
		JvmGenericType superType = getSuperType(anonymousClass);
		if(superType != null) {
			JvmConstructor constructor = anonymousClass.getConstructorCall().getConstructor();
			for(JvmMember superMember: superType.getMembers()) {
				if(superMember instanceof JvmConstructor && isSameSignature(constructor, (JvmConstructor) superMember)) 
					return (JvmConstructor) superMember;
			}
		}
		return null;
	}

	protected boolean isSameSignature(JvmConstructor constructor, JvmConstructor superConstructor) {
		if(constructor.getParameters().size() != superConstructor.getParameters().size())
			return false;
		for(int i=0; i<constructor.getParameters().size(); ++i) {
			JvmTypeReference paramType = constructor.getParameters().get(i).getParameterType();
			JvmTypeReference superParamType = superConstructor.getParameters().get(i).getParameterType();
			if(!paramType.getIdentifier().equals(superParamType.getIdentifier()))
				return false;
		}
		return true;
	}
}
