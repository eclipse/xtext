/*******************************************************************************
 * Copyright (c) 2017, 2018 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template

import com.google.common.annotations.Beta
import org.eclipse.xtend.lib.macro.CodeGenerationContext
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

/**
 * Generate some code to simplify implementation of project templates.
 * 
 * <ol>
 * <li>Automatically extend AbstractFileTemplate</li>
 * <li>Generate "messages.properties" for i18n</li>
 * <li>Generate "Messages.java" for i18n</li>
 * </ol>
 * 
 * The generated files for i18n contain the "label" and "description" of all the project templates. The files may be
 * extended manually by the user to externalize more strings. The generator then merges its own changes into the
 * existing files.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
@Beta
class FileTemplateProcessor extends TemplateProcessor {

	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		annotatedClass.extendedClass = AbstractFileTemplate.newTypeReference // extend AbstractFileTemplate
	}

	override protected getLabel(ClassDeclaration annotatedClass, extension CodeGenerationContext context) {
		return annotatedClass.findAnnotation(findTypeGlobally(FileTemplate)).getStringValue("label")
	}

	override protected getDescription(ClassDeclaration annotatedClass, extension CodeGenerationContext context) {
		return annotatedClass.findAnnotation(findTypeGlobally(FileTemplate)).getStringValue("description")
	}

}
