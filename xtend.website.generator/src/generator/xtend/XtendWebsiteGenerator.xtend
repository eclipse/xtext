package generator.xtend

import generator.Resource
import java.io.File
import org.eclipse.xtend.core.XtendStandaloneSetup

class XtendWebsiteGenerator {
	
	def static void main(String[] args) {
		System::setProperty("java.awt.headless", "true")
		XtendStandaloneSetup::doSetup
		// clean dir
		val out = new File("website")
		out.generateFiles(
			new Index,
			new News,
			new Download, 
			new Documentation, 
			new ReleaseNotes,
			new Community 
		)
		println("Done.")
	}
	
	def static void generateFiles(File targetDir, Resource ... sites) {
		for (site : sites) {
			site.generateTo(targetDir)
		}
	}
	
}
