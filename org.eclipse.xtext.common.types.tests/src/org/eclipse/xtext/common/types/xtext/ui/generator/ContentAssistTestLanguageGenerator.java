/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui.generator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.GenerateDirective;
import org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

/**
 * @author Vladimir Piskarev - Initial contribution and API
 */
public class ContentAssistTestLanguageGenerator implements IGenerator {

	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		if (input.getContents().isEmpty())
			return;
		EObject root = input.getContents().get(0);
		if (!(root instanceof Model))
			return;
		GenerateDirective generateDirective = ((Model) root).getGenerateDirective();
		if (generateDirective != null) {
			fsa.generateFile(generateFileName(generateDirective), generateFileContents(generateDirective));
		}
	}

	private String generateFileName(GenerateDirective generateDirective) {
		return generateDirective.getTypeName().replace('.', '/') + ".java";
	}

	private String generateFileContents(GenerateDirective generateDirective) {
		String typeName = generateDirective.getTypeName();
		int lastDot = typeName.lastIndexOf('.');
		String packageName = (lastDot < 0) ? null : typeName.substring(0, lastDot);
		String simpleTypeName = (lastDot < 0) ? typeName : typeName.substring(lastDot + 1);
		StringBuilder result = new StringBuilder();
		if (packageName != null && packageName.length() > 0)
			result.append("package " + packageName + "; ");
		if (simpleTypeName.length() > 0)
			result.append("public class " + simpleTypeName + " {}");
		return result.toString();
	}

}
