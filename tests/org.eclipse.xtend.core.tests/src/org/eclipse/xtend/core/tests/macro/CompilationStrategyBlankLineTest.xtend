package org.eclipse.xtend.core.tests.macro

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.junit.Test
import org.eclipse.xtend2.lib.StringConcatenation

class CompilationStrategyBlankLineTest extends AbstractActiveAnnotationTest {
	
	@Test def void testTrimEmptyLines() {
		'''
			import org.eclipse.xtend.core.tests.macro.ArtificialMethods
			
			@ArtificialMethods
			class A {
			}
		'''.compile [
			assertEquals('''
				import org.eclipse.xtend.core.tests.macro.ArtificialMethods;
				
				@ArtificialMethods
				@SuppressWarnings("all")
				public class A {
				  public void blank() {
				    
				  }
				  
				  public void blank_1() {
				    				
				  }
				  
				  public void blank_2() {
				    
				  }
				  
				  public void blank_3() {
				    
				  }
				  
				  public void blank_4() {
				    int foo = 42;
				  }
				}
			 '''.toString, getGeneratedCode("A"))
		]
	}
}

@Active(ArtificialMethodsProcessor)
annotation ArtificialMethods {
}

class ArtificialMethodsProcessor extends AbstractClassProcessor {

	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		annotatedClass.addMethod('blank', [
			body = [
				'''
				'''
			]
		])
		annotatedClass.addMethod('blank_1', [
			body = [
				'''
				
				'''
			]
		])
		annotatedClass.addMethod('blank_2', [
			body = [
				''
			]
		])
		annotatedClass.addMethod('blank_3', [
			body = [
				StringConcatenation.DEFAULT_LINE_DELIMITER
			]
		])
		annotatedClass.addMethod('blank_4', [
			body = [
				'''
					int foo = 42;
				'''
			]
		])
	}
	
}
