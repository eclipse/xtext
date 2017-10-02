/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring2.rename

import com.google.inject.ImplementedBy
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EcorePackage

/**
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(ISimpleNameProvider.DefaultImpl)
interface ISimpleNameProvider {
	
	def String getSimpleName(EObject target)
	
	def boolean canRename(EObject target)
	
	class DefaultImpl implements ISimpleNameProvider {
		
		override getSimpleName(EObject target) {
			val nameAttribute = target?.nameEAttribute
			if (nameAttribute !== null)
				return target.eGet(nameAttribute) as String
			else
				return null
		}
		
		override canRename(EObject target) {
			target?.nameEAttribute !== null
		}
		
		protected def EAttribute getNameEAttribute(EObject target) {
			target.eClass.EAllAttributes.filter[name == 'name' && EType == EcorePackage.Literals.ESTRING].head
		}
	}
}

