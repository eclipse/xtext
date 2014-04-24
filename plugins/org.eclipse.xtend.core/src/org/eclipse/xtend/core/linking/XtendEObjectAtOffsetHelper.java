/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtend.core.xtend.AnonymousClassConstructorCall;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.linking.BrokenConstructorCallAwareEObjectAtOffsetHelper;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendEObjectAtOffsetHelper extends BrokenConstructorCallAwareEObjectAtOffsetHelper {

	@Override
	protected EObject resolveCrossReferencedElement(INode node) {
		EObject referencedElement = super.resolveCrossReferencedElement(node);
		EObject referenceOwner = NodeModelUtils.findActualSemanticObjectFor(node);
		if(referenceOwner instanceof AnonymousClassConstructorCall) {
			if (referencedElement instanceof JvmGenericType) { 
				JvmType superType = getSuperTypeOfAnonymousClass(referencedElement);
				if (superType != null) 
					return superType;
			} else if(referencedElement instanceof JvmConstructor) {
				JvmConstructor constructor = (JvmConstructor) referencedElement;
				JvmType superType = getSuperTypeOfAnonymousClass(constructor.getDeclaringType());
				if(superType instanceof JvmGenericType) {
					if(((JvmGenericType) superType).isInterface())
						return superType;
					JvmConstructor superConstructor = findSuperConstructor(constructor, (JvmGenericType) superType);
					if(superConstructor != null)
						return superConstructor;
				}
			}
			
		}
		return referencedElement;
	}	
	
	@Nullable
	protected JvmType getSuperTypeOfAnonymousClass(EObject element) {
		if (element instanceof JvmGenericType) { 
			JvmGenericType genericType = (JvmGenericType) element;
			if(!genericType.getSuperTypes().isEmpty())
				return genericType.getSuperTypes().get(0).getType();
		}
		return null;
	}
	
	@Nullable
	protected JvmConstructor findSuperConstructor(JvmConstructor constructor, JvmGenericType superType) {
		for(JvmMember superMember: superType.getMembers()) {
			if(superMember instanceof JvmConstructor && isSameSignature(constructor, (JvmConstructor) superMember)) 
				return (JvmConstructor) superMember;
		}
		return null;
	}

	protected boolean isSameSignature(JvmConstructor constructor, JvmConstructor superConstructor) {
		if(constructor.getParameters().size() != superConstructor.getParameters().size())
			return false;
		for(int i=0; i<constructor.getParameters().size(); ++i) {
			JvmTypeReference paramType = constructor.getParameters().get(i).getParameterType();
			JvmTypeReference superParamType = superConstructor.getParameters().get(i).getParameterType();
			if(!paramType.getQualifiedName().equals(superParamType.getQualifiedName()))
				return false;
		}
		return true;
	}
}
