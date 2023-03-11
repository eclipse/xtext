/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.AnonymousClassUtil;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XConstructorCall;
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
		if(referenceOwner instanceof XConstructorCall) {
			if (referenceOwner.eContainer() instanceof AnonymousClass) {
				AnonymousClass anon = (AnonymousClass) referenceOwner.eContainer();
				JvmGenericType superType = anonymousClassUtil.getSuperType(anon);
				if(superType != null) {
					if (referencedElement instanceof JvmGenericType)  
						return superType;
					else if(referencedElement instanceof JvmConstructor) {
						if(superType.isInterface())
							return superType;
						JvmConstructor superConstructor = anonymousClassUtil.getSuperTypeConstructor(anon);
						if(superConstructor != null)
							return superConstructor;
					}
				}
			}
		}
		return referencedElement;
	}	
	
	
}
