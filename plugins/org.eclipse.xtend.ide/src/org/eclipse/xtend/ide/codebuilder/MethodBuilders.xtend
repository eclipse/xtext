/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import java.util.List
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
abstract class AbstractMethodBuilder extends AbstractCodeBuilder {
	
	@Property String methodName
	@Property JvmTypeReference returnType
	@Property List<JvmTypeReference> parameterTypes = emptyList
	@Property boolean staticFlag
	@Property boolean abstractFlag

	def protected appendDefaultBody(IAppendable appendable, String statementSeparator) {
		if(!abstractFlag) 
			appendable.append(' {').increaseIndentation.newLine
				.append('throw new UnsupportedOperationException("TODO: auto-generated method stub")')
				.append(statementSeparator)
				.decreaseIndentation.newLine
				.append('}')
		appendable
	}
	
	override getImage() {
		switch visibility {
			case PRIVATE: 'methpri_obj.gif'
			case PROTECTED: 'methpro_obj.gif'
			case PUBLIC: 'methpub_obj.gif'
			default: 'methdef_obj.gif'
		}
	}
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
		appendable.append('def ')
			.appendVisibility(visibility, PUBLIC)
		if(staticFlag)
			appendable.append('static ')
		if(abstractFlag)
			appendable.appendType(returnType, "void").append(' ')
		appendable.append(methodName)
			.appendParameters(parameterTypes)
			.appendDefaultBody('')
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
		appendable
			.appendVisibility(visibility, DEFAULT)
		if(abstractFlag)
			appendable.append('abstract ')
		if(staticFlag)
			appendable.append('static ')
		appendable
			.appendType(returnType, "void").append(' ')
			.append(methodName)
			.appendParameters(parameterTypes)
			.appendDefaultBody(';')
		if(abstractFlag)
			appendable.append(';')
		appendable
	}

	override getIType() {
		ownerSource as IType
	}
}