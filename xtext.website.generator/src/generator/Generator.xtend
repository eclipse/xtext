package generator

import java.io.File

import static extension generator.Generator.*

class Generator {
	
	def static void main(String[] args) {
		// clean dir
		val out = new File("website")
		out.generateFiles(
			new Index,
			new Download, 
			new Examples, 
			new Documentation, 
			new Community 
		)
	}
	
	def static void generateFiles(File targetDir, Resource ... sites) {
		for (site : sites) {
			site.generateTo(targetDir)
		}
	}
	
}
