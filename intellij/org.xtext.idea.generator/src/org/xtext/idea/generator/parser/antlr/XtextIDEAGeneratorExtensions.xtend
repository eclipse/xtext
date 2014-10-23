package org.xtext.idea.generator.parser.antlr

import com.google.inject.Singleton
import org.eclipse.xpand2.output.Outlet
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.Xtend2ExecutionContext

@Singleton
class XtextIDEAGeneratorExtensions {

	val IDEA_SRC = 'IDEA_SRC'

	val IDEA_SRC_GEN = 'IDEA_SRC_GEN'

	def Outlet getSrcOutlet(Xtend2ExecutionContext it) {
		getOutlet(IDEA_SRC)
	}

	def Outlet getSrcGenOutlet(Xtend2ExecutionContext it) {
		getOutlet(IDEA_SRC_GEN)
	}

	def Outlet getOutlet(Xtend2ExecutionContext it, String outletName) {
		xpandExecutionContext.output.getOutlet(outletName)
	}

	def void installOutlets(Xtend2ExecutionContext it, String pathIdeaPluginProject, String encoding) {
		installOutlet(pathIdeaPluginProject, IDEA_SRC, '/src', encoding, Generator.SRC)
		installOutlet(pathIdeaPluginProject, IDEA_SRC_GEN, '/src-gen', encoding, Generator.SRC_GEN)
	}

	def installOutlet(Xtend2ExecutionContext it, 
				String pathIdeaPluginProject, 
				String outletName, 
				String projectPath, 
				String encoding,
				String defaultOutletName) {
		if (getOutlet(outletName) != null) {
			return
		}
		val outlet = new Outlet(outletName)
		outlet.name = outletName
		outlet.fileEncoding = encoding
		outlet.path = if (pathIdeaPluginProject != null) {
			pathIdeaPluginProject + projectPath
		} else {
			getOutlet(defaultOutletName).path
		}
		xpandExecutionContext.output.addOutlet(outlet)
	}

}
