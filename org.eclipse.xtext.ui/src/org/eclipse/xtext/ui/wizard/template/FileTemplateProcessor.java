/**
 * Copyright (c) 2017, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.xtend.lib.macro.CodeGenerationContext;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * Generate some code to simplify implementation of project templates.
 * 
 * <ol>
 * <li>Automatically extend AbstractFileTemplate</li>
 * <li>Generate "messages.properties" for i18n</li>
 * <li>Generate "Messages.java" for i18n</li>
 * </ol>
 * 
 * The generated files for i18n contain the "label" and "description" of all the project templates. The files may be extended manually by
 * the user to externalize more strings. The generator then merges its own changes into the existing files.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public class FileTemplateProcessor extends TemplateProcessor {
	@Override
	public void doTransform(MutableClassDeclaration annotatedClass, @Extension TransformationContext context) {
		annotatedClass.setExtendedClass(context.newTypeReference(AbstractFileTemplate.class));
	}

	@Override
	protected String getLabel(ClassDeclaration annotatedClass, @Extension CodeGenerationContext context) {
		return annotatedClass.findAnnotation(context.findTypeGlobally(FileTemplate.class)).getStringValue("label");
	}

	@Override
	protected String getDescription(ClassDeclaration annotatedClass, @Extension CodeGenerationContext context) {
		return annotatedClass.findAnnotation(context.findTypeGlobally(FileTemplate.class)).getStringValue("description");
	}
}
