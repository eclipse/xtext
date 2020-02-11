/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.xbase.compiler.ISourceAppender

import static org.eclipse.xtext.common.types.JvmVisibility.*
import org.eclipse.xtext.resource.XtextResource

/**
 * @author Jan Koehnlein
 */
abstract class AbstractConstructorBuilder extends AbstractExecutableBuilder {
}

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtendConstructorBuilder extends AbstractConstructorBuilder implements ICodeBuilder.Xtend {
	
	@Inject extension InsertionOffsets

	override build(ISourceAppender appendable) {
		appendable
			.appendVisibility(visibility, PUBLIC)
			.append('new')
			.appendParameters()
			.appendThrowsClause()
			.appendBody('')
	}

	override getInsertOffset(XtextResource resource) {
		getNewConstructorInsertOffset(context, resource.findByFragment(xtendType))
	}
	
	override getIndentationLevel() {
		1
	}
	
	override getXtendType() {
		ownerSource as XtendTypeDeclaration
	}
}

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class JavaConstructorBuilder extends AbstractConstructorBuilder implements ICodeBuilder.Java {
	
	override build(ISourceAppender appendable) {
		appendable
			.appendVisibility(visibility, PUBLIC)
			.append(owner.simpleName)
			.appendParameters()
			.appendThrowsClause()
			.appendBody(';')
	}

	override getIType() {
		ownerSource as IType
	}
}