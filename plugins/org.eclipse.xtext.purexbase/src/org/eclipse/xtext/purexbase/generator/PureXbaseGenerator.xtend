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

import static org.eclipse.xtext.xtend2.lib.EObjectExtensions.*
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XReturnExpression
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer

class PureXbaseGenerator implements IGenerator {
	
	@Inject XbaseCompiler compiler
	@Inject TypeReferences typeReferences
	@Inject IEarlyExitComputer computer
	
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
		if (containsReturn(m.block)) {
			'''
				«impMnr.imports.map(e | 'import ' + e + ';\n').join()»
				
				@SuppressWarnings("all")
				public class «m.eResource.name» {
					public static void main(String[] args) {
						try {
							xbaseExpression();
						} catch (Throwable t) {}
					}
					public static Object xbaseExpression() throws Throwable {
						if (Boolean.TRUE) {
							«appendable»
						}
						return null;
					}
				}
			'''
		} else {
			'''
				«impMnr.imports.map(e | 'import ' + e + ';\n').join()»
				
				@SuppressWarnings("all")
				public class «m.eResource.name» {
					public static void main(String[] args) {
						try {
							«appendable»
						} catch (Throwable t) {}
					}
				}
			'''
		}
	}
	
	def containsReturn(XExpression expr) {
		val exitPoints = computer.getExitPoints(expr)
		for (point : exitPoints) {
			if (point.expression instanceof XReturnExpression)
				return true
		}
		return false
	}
}
