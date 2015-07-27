/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.javaconverter

import com.intellij.execution.configurations.JavaParameters
import com.intellij.execution.util.JavaParametersUtil
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.module.Module
import java.io.File
import org.eclipse.xtend.core.javaconverter.ASTParserFactory

/**
 * @author dhuebner - Initial contribution and API
 */
class IdeaASTParserFactory extends ASTParserFactory {

	override createJavaParser(String compilerCompliance, Object context) {
		if (!(context instanceof Module)) {
			return super.createJavaParser(compilerCompliance, context)
		}
		val parser = createDefaultJavaParser(compilerCompliance)
		val params = new JavaParameters
		ApplicationManager.application.runReadAction [
			JavaParametersUtil.configureModule(context as Module, params, JavaParameters.JDK_AND_CLASSES_AND_TESTS,
				null)
		]
		val cpEntries = params.classPath.pathList.filter[new File(it).exists]
		parser.setEnvironment(cpEntries, null, null, true)
		return parser
	}

}