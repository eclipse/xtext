package generator

import java.io.File

import static extension generator.Generator.*
import org.eclipse.xtend.core.XtendStandaloneSetup

class Generator {
	
	def static void main(String[] args) {
		System::setProperty("java.awt.headless", "true")
		XtendStandaloneSetup::doSetup
		val out = new File("website")
		out.generateFiles(
			new Index,
			new Download, 
			new SevenLanguages,
			new SevenLanguagesDocumentation, 
			new Documentation, 
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
