/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.jdt.core.IType
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.output.XtypeTypeReferenceSerializer

import static org.eclipse.xtext.common.types.JvmVisibility.*

/**
 * @author Jan Koehnlein
 */
abstract class AbstractMethodBuilder extends AbstractExecutableBuilder {
	
	@Property String methodName
	@Property JvmTypeReference returnType
	@Property boolean staticFlag
	@Property boolean abstractFlag
	@Property boolean overrideFlag

}

class XtendMethodBuilder extends AbstractMethodBuilder implements ICodeBuilder.Xtend {
	
	@Inject XtypeTypeReferenceSerializer typeRefSerializer

	@Inject extension InsertionOffsets

	override isValid() {
		super.isValid() && methodName != null
	}
	
	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		appendable.append(if(overrideFlag) 'override ' else 'def ')
			.appendVisibility(visibility, PUBLIC)
		if(staticFlag)
			appendable.append('static ')
		appendable.appendTypeParameters(typeParameters)
		if(abstractFlag)
			appendable.appendType(returnType, "void").append(' ')
		appendable.append(methodName)
			.appendParameters()
			.appendThrowsClause()
			.appendBody('')
	}

	override getInsertOffset() {
		getNewMethodInsertOffset(context, xtendType)
	}
	
	override getIndentationLevel() {
		1
	}
	
	override getXtendType() {
		ownerSource as XtendTypeDeclaration
	}
}

class JavaMethodBuilder extends AbstractMethodBuilder implements ICodeBuilder.Java {
	
	@Inject TypeReferenceSerializer typeRefSerializer

	override isValid() {
		super.isValid() && methodName != null
	}
	
	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		if(overrideFlag)
			appendable.append("@Override").newLine 
		appendable
			.appendVisibility(visibility, DEFAULT)
		if(abstractFlag)
			appendable.append('abstract ')
		if(staticFlag)
			appendable.append('static ')
		appendable
			.appendTypeParameters(typeParameters)
			.appendType(returnType, "void").append(' ')
			.append(methodName)
			.appendParameters()
			.appendThrowsClause()
			.appendBody(';')
		if(abstractFlag)
			appendable.append(';')
		appendable
	}

	override getIType() {
		ownerSource as IType
	}
}