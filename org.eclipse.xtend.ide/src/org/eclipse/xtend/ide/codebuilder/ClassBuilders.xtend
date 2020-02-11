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
abstract class AbstractClassBuilder extends AbstractCodeBuilder {
	
	@Accessors String className
	
	@Accessors String image = 'newclass_wiz.gif'
	
}

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtendClassBuilder extends AbstractClassBuilder implements ICodeBuilder.Xtend {
	
	@Inject extension InsertionOffsets
	
	override isValid() {
		super.valid && className !== null && visibility == JvmVisibility.PUBLIC  
	}	

	override build(ISourceAppender appendable) {
		appendable.append('class ').append(className).append(' {')
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
class JavaClassBuilder extends AbstractClassBuilder implements ICodeBuilder.Java {
	
	override isValid() {
		super.valid && className !== null  
	}	

	override build(ISourceAppender appendable) {
		appendable.appendVisibility(visibility, JvmVisibility.DEFAULT)
			.append('class ').append(className).append(' {')
			.newLine.append('}')
	}

	override getIType() {
		ownerSource as IType
	}
}