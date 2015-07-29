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
import org.eclipse.jdt.core.IJavaElement

/**
 * @author dhuebner - Initial contribution and API
 */
class EclipseASTParserFactory extends org.eclipse.xtend.core.javaconverter.ASTParserFactory {

	override createJavaParser(Object context) {
		if (context instanceof IJavaElement) {
			val project = context.javaProject
			val projlevel = project.getOption(JavaCore.COMPILER_SOURCE, true)
			
			val parser = createDefaultJavaParser(projlevel)
			if (context instanceof IJavaProject) {
				parser.project = project
				parser.tweakOptions(project)
			} else if (context instanceof ICompilationUnit) {
				parser.source = context
				// setSources resets compiler options to projects default, need to tweak again
				parser.tweakOptions(context.javaProject)
			}
			return new ASTParserWrapper(projlevel, parser)
		}
		return super.createJavaParser(context)
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
