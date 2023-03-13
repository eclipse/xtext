/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.jdt.core.IType
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.compiler.ISourceAppender
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.XtextResource

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
abstract class AbstractInterfaceBuilder extends AbstractCodeBuilder {
	
	@Accessors String interfaceName
	
	@Accessors String image ='newint_wiz.gif'
	
}

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtendInterfaceBuilder extends AbstractInterfaceBuilder implements ICodeBuilder.Xtend {
	
	@Inject extension InsertionOffsets
	
	override isValid() {
		super.valid && interfaceName !== null && visibility == JvmVisibility.PUBLIC  
	}	

	override build(ISourceAppender appendable) {
		appendable.append('interface ').append(interfaceName).append(' {')
			.newLine.append('}')
	}

	override getInsertOffset(XtextResource resource) {
		getNewTypeInsertOffset(context, resource.findByFragment(xtendType))
	}
	
	override getIndentationLevel() {
		0
	}
	
	override getXtendType() {
		ownerSource as XtendTypeDeclaration
	}
}

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class JavaInterfaceBuilder extends AbstractInterfaceBuilder implements ICodeBuilder.Java {
	
	override isValid() {
		super.valid && interfaceName !== null  
	}	

	override build(ISourceAppender appendable) {
		appendable.appendVisibility(visibility, JvmVisibility.DEFAULT)
			.append('interface ').append(interfaceName).append(' {')
			.newLine.append('}')
	}

	override getIType() {
		ownerSource as IType
	}
}