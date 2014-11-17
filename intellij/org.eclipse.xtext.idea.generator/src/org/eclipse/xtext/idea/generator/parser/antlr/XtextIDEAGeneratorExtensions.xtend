package org.eclipse.xtext.idea.generator.parser.antlr

import com.google.inject.Singleton
import org.eclipse.xpand2.output.Outlet
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.Xtend2ExecutionContext

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
				String defaultOutletName) {
		if (getOutlet(outletName) != null) {
			return
		}
		val outlet = new Outlet(outletName)
		outlet.name = outletName
		outlet.overwrite = overwrite
		outlet.fileEncoding = encoding
		outlet.path = if (pathIdeaPluginProject != null) {
			pathIdeaPluginProject + projectPath
		} else {
			getOutlet(defaultOutletName).path
		}
		xpandExecutionContext.output.addOutlet(outlet)
	}

	def void installOutlets(Xtend2ExecutionContext it, String pathIdeaPluginProject, String encoding) {
		installOutlet(pathIdeaPluginProject, IDEA_SRC, '/src', encoding, false, Generator.SRC)
		installOutlet(pathIdeaPluginProject, IDEA_SRC_GEN, '/src-gen', encoding, true, Generator.SRC_GEN)
	}

}
