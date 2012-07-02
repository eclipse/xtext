package generator

import java.io.File

import static extension generator.Generator.*

class Generator {
	
	def static void main(String[] args) {
		System::setProperty("java.awt.headless", "true")

		val out = new File("website")
		out.generateFiles(
			new Index,
			new Download, 
			new ExamplesResource, 
			new Documentation, 
			new SevenLanguages,
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
