package org.eclipse.xtext.purexbase.generator

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.purexbase.pureXbase.Model
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable
import org.eclipse.xtext.xbase.compiler.XbaseCompiler

class PureXbaseGenerator implements IGenerator {
	
	@Inject XbaseCompiler compiler
	@Inject TypeReferences typeReferences
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		fsa.generateFile(resource.name + ".java", generateMain(resource.contents.head as Model))
	}
	
	def name(Resource res) {
		val s = res.URI.lastSegment
		return s.substring(0, s.length - '.xbase'.length)
	}
	
	def generateMain(Model m) {
		val impMnr = new ImportManager(true)
		val appendable = new StringBuilderBasedAppendable(impMnr)
		compiler.compile(m.block, appendable, typeReferences.getTypeForName("void",m))
		'''
			«impMnr.imports.map(e | 'import ' + e + ';\n').join()»
			
			@SuppressWarnings("all")
			public class «m.eResource.name» {
				public static void main(String[] args) {
					«appendable»
				}
			}
		'''
	}
}
