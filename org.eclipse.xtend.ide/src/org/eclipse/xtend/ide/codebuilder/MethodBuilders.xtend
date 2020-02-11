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
import org.eclipse.xtext.xbase.compiler.ISourceAppender
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference

import static org.eclipse.xtext.common.types.JvmVisibility.*
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.XtextResource

/**
 * @author Jan Koehnlein
 */
abstract class AbstractMethodBuilder extends AbstractExecutableBuilder {
	
	@Accessors String methodName
	@Accessors LightweightTypeReference returnType
	@Accessors boolean staticFlag
	@Accessors boolean abstractFlag
	@Accessors boolean overrideFlag
	@Accessors boolean synchronizedFlag
}

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtendMethodBuilder extends AbstractMethodBuilder implements ICodeBuilder.Xtend {
	
	@Inject extension InsertionOffsets

	override isValid() {
		super.isValid() && methodName !== null
	}
	
	override build(ISourceAppender appendable) {
		appendable.append(if(overrideFlag) 'override ' else 'def ')
			.appendVisibility(visibility, PUBLIC)
		if(staticFlag)
			appendable.append('static ')
		if(synchronizedFlag)
			appendable.append('synchronized ')
		appendable.appendTypeParameters(typeParameters)
		if(abstractFlag)
			appendable.appendType(returnType, "void").append(' ')
		appendable.append(methodName)
			.appendParameters()
			.appendThrowsClause()
		if(!abstractFlag)
			appendable.appendBody('')
		appendable
	}

	override getInsertOffset(XtextResource resource) {
		getNewMethodInsertOffset(context, resource.findByFragment(xtendType))
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
class JavaMethodBuilder extends AbstractMethodBuilder implements ICodeBuilder.Java {
	
	override isValid() {
		super.isValid() && methodName !== null
	}
	
	override build(ISourceAppender appendable) {
		if(overrideFlag)
			appendable.append("@Override").newLine 
		appendable
			.appendVisibility(visibility, DEFAULT)
		if(abstractFlag)
			appendable.append('abstract ')
		if(staticFlag)
			appendable.append('static ')
		if(synchronizedFlag)
			appendable.append('synchronized ')
		appendable
			.appendTypeParameters(typeParameters)
			.appendType(returnType, "void").append(' ')
			.append(methodName)
			.appendParameters()
			.appendThrowsClause()
		if(abstractFlag)
			appendable.append(';')
		else
			appendable.appendBody(';')
		appendable
	}

	override getIType() {
		ownerSource as IType
	}
}

