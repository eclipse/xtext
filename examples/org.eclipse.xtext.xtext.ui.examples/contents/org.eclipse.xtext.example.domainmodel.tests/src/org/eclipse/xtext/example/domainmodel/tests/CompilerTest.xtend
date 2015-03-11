package org.eclipse.xtext.example.domainmodel.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.TemporaryFolder
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(InjectorProviderCustom)
class CompilerTest {
	
	@Rule
	@Inject public TemporaryFolder temporaryFolder 
	@Inject extension CompilationTestHelper
	@Inject extension ReflectExtensions
	
	@Test
	def void testGeneratedJava() {
		'''
			entity Foo {
				name : String
				op doStuff(String x) : String {
					return x + ' ' + this.name
				}
			}
		'''.compile [
			val obj = it.compiledClass.newInstance
			obj.invoke('setName', 'Foo')
			assertEquals("Hello Foo", obj.invoke('doStuff','Hello'))
		]
	}

	@Test
	def void testGeneratedJavaFromSeveralInputs() {
		#[
		'''
			entity Foo {
				bar : Bar
				op doStuff(String x) : String {
					return x + ' ' + bar.getName()
				}
			}
		''',
		'''
			entity Bar {
				name : String
			}
		'''
		].compile [
			val barObj = it.getCompiledClass("Bar").newInstance
			barObj.invoke('setName', 'Bar')
			val fooObj = it.getCompiledClass("Foo").newInstance
			fooObj.invoke('setBar', barObj)
			assertEquals("Hello Bar", fooObj.invoke('doStuff','Hello'))
		]
	}
	
	@Test
	def void compareGeneratedJava() {
		'''
			entity Foo {
				name : String
			}
		'''.compile[assertEquals('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
			
			@SuppressWarnings("all")
			public class Foo {
			  public Foo() {
			  }
			  
			  public Foo(final Procedure1<Foo> initializer) {
			    initializer.apply(this);
			  }
			  
			  private String name;
			  
			  public String getName() {
			    return this.name;
			  }
			  
			  public void setName(final String name) {
			    this.name = name;
			  }
			  
			  @Override
			  public String toString() {
			    String result = new ToStringBuilder(this).addAllFields().toString();
			    return result;
			  }
			}
		'''.toString, getSingleGeneratedCode)
		]
	}
	
	
}