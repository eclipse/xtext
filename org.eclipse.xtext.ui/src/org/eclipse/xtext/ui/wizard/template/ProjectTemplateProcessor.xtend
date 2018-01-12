/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.CodeGenerationContext
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

/**
 * Generate some code to simplify implementation of project templates.
 * 
 * <ol>
 * <li>Automatically extend AbstractProjectTemplate</li>
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
class ProjectTemplateProcessor extends AbstractClassProcessor {

	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		annotatedClass.extendedClass = AbstractProjectTemplate.newTypeReference // extend AbstractProjectTemplate
	}

	override doGenerateCode(ClassDeclaration annotatedClass, extension CodeGenerationContext context) {
		val propertyContents = generatePropertiesFile(annotatedClass, context) // "messages.properties" for i18n
		generateMessagesClass(propertyContents, annotatedClass, context) // "Messages.java" for i18n
	}

	// read the "label" and "description" from the ProjectTemplateAnnotation and update "messages.properties" with the values
	private def generatePropertiesFile(ClassDeclaration annotatedClass, extension CodeGenerationContext context) {
		val annotation = annotatedClass.findAnnotation(context.findTypeGlobally(ProjectTemplate))
		val label = replaceNewlines(annotation.getStringValue("label"))
		val description = replaceNewlines(annotation.getStringValue("description"))
		val propertyFile = annotatedClass.compilationUnit.filePath.parent.append("messages.properties")
		var propertyContents = ""
		if (propertyFile.exists) {
			propertyContents = propertyFile.contents.toString
		}
		if (propertyContents.length > 0 && !propertyContents.endsWith(System.lineSeparator)) {
			propertyContents += System.lineSeparator
		}
		val labelLineStart = annotatedClass.simpleName + "_Label="
		val labelLine = labelLineStart + label
		if (propertyContents.contains(labelLineStart)) {
			propertyContents = propertyContents.replaceFirst("^(?m)" + labelLineStart + ".*$", labelLine)
		} else {
			propertyContents += labelLine + System.lineSeparator
		}
		val descriptionLineStart = annotatedClass.simpleName + "_Description="
		val descriptionLine = descriptionLineStart + description
		if (propertyContents.contains(descriptionLineStart)) {
			propertyContents = propertyContents.replaceFirst("^(?m)" + descriptionLineStart + ".*$", descriptionLine)
		} else {
			propertyContents += descriptionLine + System.lineSeparator
		}
		propertyFile.contents = propertyContents
		return propertyContents
	}

	// generate a "Messages.java" out of the given content from "messages.properties"
	private def generateMessagesClass(String propertyContents, ClassDeclaration annotatedClass,
		extension CodeGenerationContext context) {
		val classFile = annotatedClass.compilationUnit.filePath.parent.append("Messages.java")
		var contents = '''
			package «annotatedClass.compilationUnit.packageName»;
			
			import org.eclipse.osgi.util.NLS;
			
			public class Messages extends NLS {
				private static final String BUNDLE_NAME = "«annotatedClass.compilationUnit.packageName».messages"; //$NON-NLS-1$
				
		'''
		for (line : propertyContents.split("(\r?\n)+")) {
			if (line.contains("=")) {
				val parts = line.split("=")
				contents += '''	public static String «parts.get(0).trim»;
				'''
			}
		}
		contents += '''
				
				static {
				// initialize resource bundle
				NLS.initializeMessages(BUNDLE_NAME, Messages.class);
				}
			
				private Messages() {
				}
			}
		'''
		classFile.contents = contents
	}

	private def String replaceNewlines(String input) { input.replaceAll("(\r?\n)+", " ") }

}
