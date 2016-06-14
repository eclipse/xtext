package org.eclipse.xtend.core.tests.macro

import java.math.BigDecimal
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.junit.Test

class CompilationStrategyBlankLineTest extends AbstractActiveAnnotationTest {
	
	@Test def void testTrimEmptyLines() {
		'''
			import org.eclipse.xtend.core.tests.macro.ArtificialMethods
			
			@ArtificialMethods
			class A {
			}
		'''.compile [
			assertEquals('''
				import java.math.BigDecimal;
				import java.util.ArrayList;
				import java.util.List;
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
				  
				  public void blank_5() {
				    int foo = 42;
				  }
				  
				  public void blank_6() {
				    int foo = 42;
				  }
				  
				  public void blank_7() {
				    List<? extends Object> list = new ArrayList<BigDecimal>();
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
				'\n'
			]
		])
		annotatedClass.addMethod('blank_4', [
			body = [
				'''
					int foo = 42;
				'''
			]
		])
		annotatedClass.addMethod('blank_5', [
			body = '''
				int foo = 42;
			'''
		])
		annotatedClass.addMethod('blank_6', [
			body = '''int foo = 42;'''
		])
		annotatedClass.addMethod('blank_7', [
			body = '''
				«List»<? extends Object> list = new «ArrayList»<«BigDecimal»>();'''
		])
	}
	
}
