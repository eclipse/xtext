/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template

import com.google.common.annotations.Beta
import java.util.HashMap
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.CodeGenerationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.file.Path

/**
 * Generate some code to simplify implementation of templates.
 * 
 * <ol>
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
abstract class TemplateProcessor extends AbstractClassProcessor {

	// the annotation processors run in parallel but write the same file ... we synchronize to avoid race conditions 
	static final Object LOCK = TemplateProcessor

	Map<Path, String> propertyContentMap // need to make sure to read the files only once
	String actualPropertyContents // content from currently active "messages.properties" file

	override doGenerateCode(List<? extends ClassDeclaration> annotatedSourceElements,
		extension CodeGenerationContext context) {
		synchronized (LOCK) {
			buildFileMaps(annotatedSourceElements, context)
			for (ClassDeclaration annotatedClass : annotatedSourceElements) {
				actualPropertyContents = propertyContentMap.get(annotatedClass.messagesProperties)
				doGenerateCode(annotatedClass, context);
			}
			saveFileMaps(annotatedSourceElements, context)
		}
	}

	override doGenerateCode(ClassDeclaration annotatedClass, extension CodeGenerationContext context) {
		synchronized (LOCK) {
			val propertyContents = generatePropertiesFile(annotatedClass, context) // "messages.properties" for i18n
			generateMessagesClass(propertyContents, annotatedClass, context) // "Messages.java" for i18n
		}
	}

	// read the "label" and "description" from the ProjectTemplateAnnotation and update "messages.properties" with the values
	private def generatePropertiesFile(ClassDeclaration annotatedClass, extension CodeGenerationContext context) {
		val label = replaceNewlines(getLabel(annotatedClass, context))
		val description = replaceNewlines(getDescription(annotatedClass, context))
		val labelLineStart = annotatedClass.simpleName + "_Label="
		val labelLine = labelLineStart + label
		if (actualPropertyContents.contains(labelLineStart)) {
			actualPropertyContents = actualPropertyContents.replaceFirst("(?m)^" + labelLineStart + ".*$", labelLine)
		} else {
			actualPropertyContents += labelLine + System.lineSeparator
		}
		val descriptionLineStart = annotatedClass.simpleName + "_Description="
		val descriptionLine = descriptionLineStart + description
		if (actualPropertyContents.contains(descriptionLineStart)) {
			actualPropertyContents = actualPropertyContents.replaceFirst("(?m)^" + descriptionLineStart + ".*$",
				descriptionLine)
		} else {
			actualPropertyContents += descriptionLine + System.lineSeparator
		}
		propertyContentMap.put(annotatedClass.messagesProperties, actualPropertyContents)
		return actualPropertyContents
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

	protected def void buildFileMaps(List<? extends ClassDeclaration> annotatedSourceElements,
		extension CodeGenerationContext context) {
		propertyContentMap = new HashMap
		for (ClassDeclaration annotatedClass : annotatedSourceElements) {
			val propertyFile = annotatedClass.messagesProperties
			if (!propertyContentMap.containsKey(propertyFile)) {
				if (propertyFile.exists) {
					var propertyContents = propertyFile.contents.toString
					if (propertyContents.length > 0 && !propertyContents.endsWith(System.lineSeparator)) {
						propertyContents += System.lineSeparator
					}
					propertyContentMap.put(propertyFile, propertyContents)
				} else {
					propertyContentMap.put(propertyFile, "")
				}
			}
		}
	}

	protected def void saveFileMaps(List<? extends ClassDeclaration> annotatedSourceElements,
		extension CodeGenerationContext context) {
		for (ClassDeclaration annotatedClass : annotatedSourceElements) {
			actualPropertyContents = propertyContentMap.get(annotatedClass.messagesProperties)
			annotatedClass.messagesProperties.contents = actualPropertyContents
		}
	}

	private def Path getMessagesProperties(ClassDeclaration annotatedClass) {
		annotatedClass.compilationUnit.filePath.parent.append("messages.properties")
	}

	abstract def protected String getLabel(ClassDeclaration annotatedClass, extension CodeGenerationContext context);

	abstract def protected String getDescription(ClassDeclaration annotatedClass,
		extension CodeGenerationContext context);

}
