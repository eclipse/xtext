/**
 * Copyright (c) 2018, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.wizard.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.CodeGenerationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.file.Path;

/**
 * Generate some code to simplify implementation of templates.
 *
 * <ol>
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
public abstract class TemplateProcessor extends AbstractClassProcessor {

	// the annotation processors run in parallel but write the same file ... we synchronize to avoid race conditions
	private static final Object LOCK = TemplateProcessor.class;

	private Map<Path, String> propertyContentMap; // need to make sure to read the files only once

	private String actualPropertyContents; // content from currently active "messages.properties" file

	@Override
	public void doGenerateCode(List<? extends ClassDeclaration> annotatedSourceElements, CodeGenerationContext context) {
		synchronized (TemplateProcessor.LOCK) {
			buildFileMaps(annotatedSourceElements, context);
			for (ClassDeclaration annotatedClass : annotatedSourceElements) {
				actualPropertyContents = propertyContentMap.get(this.getMessagesProperties(annotatedClass));
				doGenerateCode(annotatedClass, context);
			}
			saveFileMaps(annotatedSourceElements, context);
		}
	}

	@Override
	public void doGenerateCode(ClassDeclaration annotatedClass, CodeGenerationContext context) {
		synchronized (TemplateProcessor.LOCK) {
			String propertyContents = generatePropertiesFile(annotatedClass, context);
			generateMessagesClass(propertyContents, annotatedClass, context);
		}
	}

	// read the "label" and "description" from the ProjectTemplateAnnotation and update "messages.properties" with the values
	private String generatePropertiesFile(ClassDeclaration annotatedClass, CodeGenerationContext context) {
		String label = replaceNewlines(getLabel(annotatedClass, context));
		String description = replaceNewlines(getDescription(annotatedClass, context));
		String labelLineStart = annotatedClass.getSimpleName() + "_Label=";
		String labelLine = labelLineStart + label;
		if (actualPropertyContents.contains(labelLineStart)) {
			actualPropertyContents = actualPropertyContents.replaceFirst("(?m)^" + labelLineStart + ".*$", labelLine);
		} else {
			actualPropertyContents = actualPropertyContents + (labelLine + System.lineSeparator());
		}
		String descriptionLineStart = annotatedClass.getSimpleName() + "_Description=";
		String descriptionLine = descriptionLineStart + description;
		if (actualPropertyContents.contains(descriptionLineStart)) {
			actualPropertyContents = actualPropertyContents.replaceFirst("(?m)^" + descriptionLineStart + ".*$", descriptionLine);
		} else {
			actualPropertyContents = actualPropertyContents + (descriptionLine + System.lineSeparator());
		}
		propertyContentMap.put(getMessagesProperties(annotatedClass), actualPropertyContents);
		return actualPropertyContents;
	}

	// generate a "Messages.java" out of the given content from "messages.properties"
	private void generateMessagesClass(String propertyContents, ClassDeclaration annotatedClass, CodeGenerationContext context) {
		Path classFile = annotatedClass.getCompilationUnit().getFilePath().getParent().append("Messages.java");
		String contents = "";
		if (context.exists(classFile)) {
			String oldContents = context.getContents(classFile).toString();
			if (oldContents.trim().startsWith("/*") && oldContents.contains("*/") && oldContents.length() > oldContents.indexOf("*/") + 2) {
				contents = contents + (oldContents.substring(0, oldContents.indexOf("*/") + 2) + System.lineSeparator());
			}
		} else {
			contents = contents + (annotatedClass.getCompilationUnit().getDocComment() + System.lineSeparator());
		}
		contents = contents + "package " + annotatedClass.getCompilationUnit().getPackageName() + ";" + System.lineSeparator();
		contents = contents + 
				System.lineSeparator() +
				"import org.eclipse.osgi.util.NLS;" + System.lineSeparator() +
				System.lineSeparator() +
				"public class Messages extends NLS {" + System.lineSeparator() +
				"	private static final String BUNDLE_NAME = \"" + annotatedClass.getCompilationUnit().getPackageName() + ".messages\"; //$NON-NLS-1$" + System.lineSeparator() +
				"	" + System.lineSeparator();
		for (String line : propertyContents.split("(\r?\n)+")) {
			if (line.contains("=")) {
				String[] parts = line.split("=");
				contents = contents + "	public static String " + parts[0].trim() + ";" + System.lineSeparator();
			}
		}
		contents = contents + 
				"	" + System.lineSeparator() +
				"	static {" + System.lineSeparator() +
				"	// initialize resource bundle" + System.lineSeparator() +
				"	NLS.initializeMessages(BUNDLE_NAME, Messages.class);" + System.lineSeparator() +
				"	}" + System.lineSeparator() +
				"	" + System.lineSeparator() +
				"	private Messages() {" + System.lineSeparator() +
				"	}" + System.lineSeparator() +
				"}" + System.lineSeparator();
		context.setContents(classFile, contents);
	}

	private String replaceNewlines(String input) {
		return input.replaceAll("(\r?\n" +
				")+", " ");
	}

	protected void buildFileMaps(List<? extends ClassDeclaration> annotatedSourceElements, CodeGenerationContext context) {
		propertyContentMap = new HashMap<>();
		for (ClassDeclaration annotatedClass : annotatedSourceElements) {
			Path propertyFile = getMessagesProperties(annotatedClass);
			if (!propertyContentMap.containsKey(propertyFile)) {
				if (context.exists(propertyFile)) {
					String propertyContents = context.getContents(propertyFile).toString();
					if (propertyContents.length() > 0) {
						boolean endsWithWindowsLineSeparator = propertyContents.endsWith("\r\n");
						boolean endsWithUnixLineSeparator = propertyContents.endsWith("\n");
						if (!endsWithWindowsLineSeparator && !endsWithUnixLineSeparator) {
							propertyContents = propertyContents + System.lineSeparator();
						}
					}
					propertyContentMap.put(propertyFile, propertyContents);
				} else {
					propertyContentMap.put(propertyFile, "");
				}
			}
		}
	}

	protected void saveFileMaps(List<? extends ClassDeclaration> annotatedSourceElements, CodeGenerationContext context) {
		for (ClassDeclaration annotatedClass : annotatedSourceElements) {
			actualPropertyContents = propertyContentMap.get(getMessagesProperties(annotatedClass));
			context.setContents(getMessagesProperties(annotatedClass), actualPropertyContents);
		}
	}

	private Path getMessagesProperties(ClassDeclaration annotatedClass) {
		return annotatedClass.getCompilationUnit().getFilePath().getParent().append("messages.properties");
	}

	protected abstract String getLabel(ClassDeclaration annotatedClass, CodeGenerationContext context);

	protected abstract String getDescription(ClassDeclaration annotatedClass, CodeGenerationContext context);
}
