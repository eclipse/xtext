/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.findUsages

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendAnnotationType
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendEnum
import org.eclipse.xtend.core.xtend.XtendEnumLiteral
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendInterface
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtend.core.xtend.XtendVariableDeclaration
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.idea.findusages.BaseXtextFindUsageProvider

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendFindUsageProvider extends BaseXtextFindUsageProvider {

	override protected getType(EObject object) {
		switch object {
			XtendEnum:
				'enum'
			XtendInterface:
				'interface'
			XtendAnnotationType:
				'@interface'
			XtendTypeDeclaration:
				'class'
			JvmTypeParameter:
				'type parameter'
			XtendField,
			XtendEnumLiteral:
				'field'
			XtendFunction:
				'method'
			XtendConstructor:
				'constructor'
			XtendParameter:
				'parameter'
			XtendVariableDeclaration:
				'variable'
			default:
				super.getType(object)
		}
	}

}