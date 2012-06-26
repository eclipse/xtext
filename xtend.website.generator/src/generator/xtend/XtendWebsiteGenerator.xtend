package generator.xtend

import java.io.File

import static extension generator.Generator.*
import generator.Resource

class XtendWebsiteGenerator {
	
	def static void main(String[] args) {
		// clean dir
		val out = new File("website")
		out.generateFiles(
			new Index,
			new Download, 
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
