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
import org.eclipse.xtext.xbase.compiler.ISourceAppender
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference

import static org.eclipse.xtext.common.types.JvmVisibility.*
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.XtextResource

/**
 * @author Jan Koehnlein
 */
abstract class AbstractFieldBuilder extends AbstractCodeBuilder {
	
	@Accessors String fieldName
	@Accessors LightweightTypeReference fieldType
	@Accessors boolean staticFlag
	
	override getImage() {
		switch visibility {
			case PRIVATE: 'field_private_obj.gif'
			case PROTECTED: 'field_protected_obj.gif'
			case PUBLIC: 'field_public_obj.gif'
			default: 'field_default_obj.gif'
		}
	}
}

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtendFieldBuilder extends AbstractFieldBuilder implements ICodeBuilder.Xtend {
	
	@Inject extension InsertionOffsets
	
	override isValid() {
		super.isValid() && fieldName != null
	}
	
	override build(ISourceAppender appendable) {
		appendable.appendVisibility(visibility, PRIVATE)
		if(staticFlag)
			appendable.append('static ')
		appendable.appendType(fieldType, "Object").append(' ').append(fieldName)
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
}

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class JavaFieldBuilder extends AbstractFieldBuilder implements ICodeBuilder.Java {
	
	override isValid() {
		super.isValid() && fieldName != null && fieldType != null
	}
	
	override build(ISourceAppender appendable) {
		appendable.appendVisibility(visibility, DEFAULT)
		if(staticFlag)
			appendable.append('static ')
		appendable.appendType(fieldType, "Object").append(' ').append(fieldName).append(';')
	}

	override getIType() {
		ownerSource as IType
	}
}