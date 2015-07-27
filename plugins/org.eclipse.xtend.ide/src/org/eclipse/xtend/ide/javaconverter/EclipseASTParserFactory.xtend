/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.javaconverter

import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.core.dom.ASTParser
import org.eclipse.jdt.core.ICompilationUnit

/**
 * @author dhuebner - Initial contribution and API
 */
class EclipseASTParserFactory extends org.eclipse.xtend.core.javaconverter.ASTParserFactory {

	override createJavaParser(String compilerCompliance, Object context) {
		if (context instanceof IJavaProject) {
			val parser = createDefaultJavaParser(compilerCompliance)
			val project = context
			parser.project = project
			parser.tweakOptions(project)
			return parser
		} else if (context instanceof ICompilationUnit) {
			val parser = createDefaultJavaParser(compilerCompliance)
			parser.statementsRecovery = true
			parser.resolveBindings = true
			parser.bindingsRecovery = true
			parser.source = context
			// setSources resets compiler options to projects default, need totweak again
			parser.tweakOptions(context.javaProject)
			return parser
		}
		return super.createJavaParser(compilerCompliance, context)
	}

	def tweakOptions(ASTParser parser, IJavaProject project) {
		if (project != null) {
			val options = project.getOptions(true);
			options.remove(JavaCore.COMPILER_TASK_TAGS);
			options.put(JavaCore.COMPILER_DOC_COMMENT_SUPPORT, JavaCore.ENABLED)
			parser.compilerOptions = options;
		}
	}
}
