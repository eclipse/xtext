/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.structureview

import com.intellij.ide.util.treeView.smartTree.TreeElement
import org.eclipse.xtext.idea.structureview.DefaultComparator
import org.eclipse.xtext.idea.structureview.EObjectTreeElement
import org.eclipse.xtext.idea.structureview.EStructuralFeatureTreeElement

import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*
import static org.eclipse.xtext.common.types.TypesPackage.Literals.*

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendTreeElementComparator extends DefaultComparator {

	override getCategory(TreeElement element) {
		if (element instanceof XtendEObjectTreeElement) {
			element.internalGetCategory + 100 * element.inheritanceDepth
		} else {
			element.internalGetCategory
		}
	}
	
	protected def internalGetCategory(TreeElement element) {
		if (element instanceof EStructuralFeatureTreeElement) {
			return if(element.feature == XTEND_FILE__PACKAGE) 0 else 10
		}
		if (element instanceof EObjectTreeElement) {
			switch eClass : element.object.eClass {
				case XTEND_TYPE_DECLARATION.isSuperTypeOf(eClass),
				case JVM_DECLARED_TYPE.isSuperTypeOf(eClass),
				case JVM_ENUMERATION_LITERAL.isSuperTypeOf(eClass):
					return 20
				case XTEND_FIELD,
				case JVM_FIELD:
					return if(element.static) 30 else 50
				case XTEND_CONSTRUCTOR,
				case JVM_CONSTRUCTOR:
					return 60
				case XTEND_FUNCTION,
				case JVM_OPERATION:
					return if(element.static) 40 else if(element.dispatch) 70 else 80
			}
		}
		Integer.MAX_VALUE
	} 

	protected def isStatic(TreeElement element) {
		if (element instanceof XtendFeatureTreeElement) {
			element.isStatic
		}
	}

	protected def isDispatch(TreeElement element) {
		if (element instanceof XtendFeatureTreeElement) {
			element.isDispatch
		}
	}

}