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
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer

import static org.eclipse.xtext.common.types.JvmVisibility.*
import org.eclipse.xtext.xbase.compiler.output.XtypeTypeReferenceSerializer

/**
 * @author Jan Koehnlein
 */
abstract class AbstractConstructorBuilder extends AbstractCodeBuilder {
	
	@Property List<JvmTypeReference> parameterTypes = emptyList

	def protected appendDefaultBody(IAppendable appendable, String statementSeparator) {
		appendable.append('throw new UnsupportedOperationException("TODO: auto-generated method stub")')
			.append(statementSeparator)
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

class XtendConstructorBuilder extends AbstractConstructorBuilder implements ICodeBuilder$Xtend {
	
	@Inject XtypeTypeReferenceSerializer typeRefSerializer

	@Inject extension InsertionOffsets

	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		appendable
			.appendVisibility(visibility, PUBLIC)
			.append('new')
			.appendParameters(parameterTypes)
			.append(' {').increaseIndentation.newLine
			.appendDefaultBody('')
			.decreaseIndentation.newLine
			.append('}')
	}

	override getInsertOffset() {
		getNewConstructorInsertOffset(context, xtendType)
	}
	
	override getIndentationLevel() {
		1
	}
	
	override getXtendType() {
		ownerSource as XtendClass
	}
}

class JavaConstructorBuilder extends AbstractConstructorBuilder implements ICodeBuilder$Java {
	
	@Inject TypeReferenceSerializer typeRefSerializer

	override protected getTypeReferenceSerializer() {
		typeRefSerializer
	}
	
	override build(IAppendable appendable) {
		appendable
			.appendVisibility(visibility, PUBLIC)
			.append(owner.simpleName)
			.appendParameters(parameterTypes)
			.append(' {').increaseIndentation.newLine
			.appendDefaultBody(';')
			.decreaseIndentation.newLine
			.append('}')
	}

	override getIType() {
		ownerSource as IType
	}
}