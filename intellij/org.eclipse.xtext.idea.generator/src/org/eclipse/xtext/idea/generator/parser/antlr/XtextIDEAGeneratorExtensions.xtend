/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.generator.parser.antlr

import com.google.inject.Singleton
import org.eclipse.xpand2.output.Outlet
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.NewlineNormalizer

@Singleton
class XtextIDEAGeneratorExtensions {

	val IDEA_SRC = 'IDEA_SRC'

	val IDEA_SRC_GEN = 'IDEA_SRC_GEN'

	def Outlet getOutlet(Xtend2ExecutionContext it, String outletName) {
		xpandExecutionContext.output.getOutlet(outletName)
	}

	def Outlet getSrcOutlet(Xtend2ExecutionContext it) {
		getOutlet(IDEA_SRC)
	}

	def Outlet getSrcGenOutlet(Xtend2ExecutionContext it) {
		getOutlet(IDEA_SRC_GEN)
	}

	protected def installOutlet(Xtend2ExecutionContext it, 
				String pathIdeaPluginProject, 
				String outletName, 
				String projectPath, 
				String encoding,
				boolean overwrite,
				String defaultOutletName,
				String lineDelimiter) {
		if (getOutlet(outletName) != null) {
			return
		}
		val outlet = new Outlet(outletName)
		outlet.name = outletName
		outlet.overwrite = overwrite
		outlet.fileEncoding = if (encoding != null) {
			encoding
		} else {
			getOutlet(defaultOutletName).fileEncoding
		}
		outlet.path = if (pathIdeaPluginProject != null) {
			pathIdeaPluginProject + projectPath
		} else {
			getOutlet(defaultOutletName).path
		}
		outlet.addPostprocessor(new NewlineNormalizer(lineDelimiter));
		xpandExecutionContext.output.addOutlet(outlet)
	}

	def void installOutlets(Xtend2ExecutionContext it, String pathIdeaPluginProject, String encoding, String lineDelimiter) {
		installOutlet(pathIdeaPluginProject, IDEA_SRC, '/src', encoding, false, Generator.SRC, lineDelimiter)
		installOutlet(pathIdeaPluginProject, IDEA_SRC_GEN, '/src-gen', encoding, true, Generator.SRC_GEN, lineDelimiter)
	}

}
