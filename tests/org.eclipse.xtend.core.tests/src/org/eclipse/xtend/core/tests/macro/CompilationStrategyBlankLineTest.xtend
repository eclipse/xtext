package org.eclipse.xtend.core.tests.macro

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.junit.Test
import java.util.List
import java.util.ArrayList
import java.math.BigDecimal

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
				    
				  }
				  
				  public void blank_5() {
				    
				  }
				  
				  public void newline_1() {
				    
				    
				  }
				  
				  public void newline_2() {
				    
				    
				  }
				  
				  public void newline_3() {
				    
				    
				  }
				  
				  public void newline_4() {
				    
				    
				  }
				  
				  public void def_1() {
				    int foo = 42;
				  }
				  
				  public void def_2() {
				    int foo = 42;
				  }
				  
				  public void def_3() {
				    int foo = 42;
				  }
				  
				  public void def_4() {
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
				'\n' // Linux
			]
		])
		annotatedClass.addMethod('blank_4', [
			body = [
				"\r\n" // Windows
			]
		])
		annotatedClass.addMethod('blank_5', [
			body = [
				'\r' // Mac
			]
		])
		annotatedClass.addMethod('newline_1', [
			body = [
				"\n\n" // Linux
			]
		])
		annotatedClass.addMethod('newline_2', [
			body = [
				"\r\n\r\n" // Windows
			]
		])
		annotatedClass.addMethod('newline_3', [
			body = [
				"\r\r" // Mac
			]
		])
		annotatedClass.addMethod('newline_4', [
			body = [
				"\n\r" // Mix
			]
		])
		annotatedClass.addMethod('def_1', [
			body = [
				'''
					int foo = 42;
				'''
			]
		])
		annotatedClass.addMethod('def_2', [
			body = '''
				int foo = 42;
			'''
		])
		annotatedClass.addMethod('def_3', [
			body = '''int foo = 42;'''
		])
		annotatedClass.addMethod('def_4', [
			body = '''
				«List»<? extends Object> list = new «ArrayList»<«BigDecimal»>();'''
		])
	}
	
}
