/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.AnonymousClassUtil;
import org.eclipse.xtend.core.xtend.AnonymousClassConstructorCall;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.linking.BrokenConstructorCallAwareEObjectAtOffsetHelper;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendEObjectAtOffsetHelper extends BrokenConstructorCallAwareEObjectAtOffsetHelper {

	@Inject
	private AnonymousClassUtil anonymousClassUtil;
	
	@Override
	protected EObject resolveCrossReferencedElement(INode node) {
		EObject referencedElement = super.resolveCrossReferencedElement(node);
		EObject referenceOwner = NodeModelUtils.findActualSemanticObjectFor(node);
		if(referenceOwner instanceof AnonymousClassConstructorCall) {
			JvmGenericType superType = anonymousClassUtil.getSuperType((AnonymousClassConstructorCall) referenceOwner);
			if(superType != null) {
				if (referencedElement instanceof JvmGenericType)  
					return superType;
				else if(referencedElement instanceof JvmConstructor) {
					if(superType.isInterface())
						return superType;
					JvmConstructor superConstructor = anonymousClassUtil.getSuperTypeConstructor((AnonymousClassConstructorCall) referenceOwner);
					if(superConstructor != null)
						return superConstructor;
				}
			}
		}
		return referencedElement;
	}	
	
	
}
