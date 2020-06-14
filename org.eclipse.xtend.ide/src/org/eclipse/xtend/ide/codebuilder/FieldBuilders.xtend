/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmPrimitiveType
import org.eclipse.xtext.common.types.util.Primitives
import org.eclipse.xtext.common.types.util.Primitives.Primitive
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.compiler.ISourceAppender
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference

import static org.eclipse.xtext.common.types.JvmVisibility.*

/**
 * @author Jan Koehnlein
 */
abstract class AbstractFieldBuilder extends AbstractCodeBuilder {
	
	@Accessors String fieldName
	@Accessors LightweightTypeReference fieldType
	@Accessors boolean staticFlag
	@Accessors boolean finalFlag
	
	@Inject Primitives primitives
	
	override getImage() {
		switch visibility {
			case PRIVATE: 'field_private_obj.gif'
			case PROTECTED: 'field_protected_obj.gif'
			case PUBLIC: 'field_public_obj.gif'
			default: 'field_default_obj.gif'
		}
	}
	
	def protected appendDefaultValueLiteral(ISourceAppender appendable, LightweightTypeReference typeRef, String surrogate) {
		if (typeRef !== null && typeRef.primitive) {
			appendable.append(primitives
				.primitiveKind(typeRef.type as JvmPrimitiveType)
				.primitiveKindRepresentation)
		} else { 
			appendable.append(surrogate)
		}
		appendable 
	}
	
	def abstract String getPrimitiveKindRepresentation(Primitive primitiveKind)
	
}

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtendFieldBuilder extends AbstractFieldBuilder implements ICodeBuilder.Xtend {
	
	@Inject extension InsertionOffsets
	
	override isValid() {
		super.isValid() && fieldName !== null
	}
	
	override build(ISourceAppender appendable) {
		appendable.appendVisibility(visibility, PRIVATE)
		if(staticFlag)
			appendable.append('static ')
		if (finalFlag)
			appendable.append('val ')
		appendable.appendType(fieldType, "Object").append(' ').append(fieldName)
		if (finalFlag)
			appendable.append(' = ').appendDefaultValueLiteral(fieldType, "null")
		appendable
	}

	override getInsertOffset(XtextResource resource) {
		getNewFieldInsertOffset(context, resource.findByFragment(xtendType))
	}
	
	override getIndentationLevel() {
		1
	}
	
	override getXtendType() {
		ownerSource as XtendTypeDeclaration
	}
	
	override getPrimitiveKindRepresentation(Primitive primitiveKind) {
		switch (primitiveKind) {
			case Primitive.Boolean: "false"
			default: "0 as " + fieldType.simpleName
		}
	}
 
}

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class JavaFieldBuilder extends AbstractFieldBuilder implements ICodeBuilder.Java {
	
	override isValid() {
		super.isValid() && fieldName !== null && fieldType !== null
	}
	
	override build(ISourceAppender appendable) {
		appendable.appendVisibility(visibility, DEFAULT)
		if(staticFlag)
			appendable.append('static ')
		if (finalFlag)
			appendable.append('final ')
		appendable.appendType(fieldType, "Object").append(' ').append(fieldName)
		if (finalFlag)
			appendable.append(' = ').appendDefaultValueLiteral(fieldType, "null")
		appendable.append(";")
	}

	override getIType() {
		ownerSource as IType
	}
	
	
	override getPrimitiveKindRepresentation(Primitive primitiveKind) {
		switch (primitiveKind) {
			case Primitive.Boolean: "false"
			default: "(" + fieldType.simpleName + " 0"
		}	
	}
	
}