/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.common.outline

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmDeclaredType

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendOutlineJvmTreeBuilder extends AbstractXtendOutlineTreeBuilder {

	def dispatch void build(XtendFile xtendFile, IXtendOutlineContext context) {
		xtendFile.buildPackageAndImportSection(context)
		xtendFile.eResource.contents.filter(JvmDeclaredType).forEach[buildType(context)]
	}

	def dispatch void build(JvmDeclaredType jvmDeclaredType, IXtendOutlineContext context) {
		jvmDeclaredType.buildMembers(jvmDeclaredType, context)
	}

	override protected buildType(EObject someType, IXtendOutlineContext context) {
		if (someType instanceof JvmDeclaredType) {
			someType.buildJvmType(context)
		} else if (someType instanceof XtendTypeDeclaration) {
			val jvmElement = someType.getPrimaryJvmElement
			if (jvmElement instanceof JvmDeclaredType) {
				jvmElement.buildJvmType(context)
			}
		}
	}

}