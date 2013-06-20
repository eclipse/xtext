package org.eclipse.xtext.example.tutorial

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import com.google.inject.Inject
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.junit.Test

@RunWith(typeof(XtextRunner))
// You need to provide the injector that instantiates and initializes
// the test class and its dependencies

//@InjectWith(typeof(TutorialInjectorProvider))
class TypesBuilderExercise {
	
	/**
	 * The test helper allows to compile DSL code on the fly to Java.
	 * We want to use its utility function 
	 * {@link CompilationTestHelper#assertCompilesTo(CharSequence, CharSequence) assertCompilesTo(..)}
	 * to test drive the {@link TutorialJvmModelInferrer model inferrer}.
	 */
	@Inject extension CompilationTestHelper
	
	@Test
	def void testMe() { 
		'''
			package tutorial
			
			import java.util.Date
			
			/**
			 * A simple entity to describe a Person
			 */
			entity Person {
				firstName: String
				lastName: String
				birthday: Date
			}
			
		'''.assertCompilesTo('''
			package tutorial;
			
			import java.util.Date;
			
			/**
			 * A simple entity to describe a Person
			 */
			public class Person {
			  private String firstName;
			  
			  public String getFirstName() {
			    return this.firstName;
			  }
			  
			  public void setFirstName(final String firstName) {
			    this.firstName = firstName;
			  }
			  
			  private String lastName;
			  
			  public String getLastName() {
			    return this.lastName;
			  }
			  
			  public void setLastName(final String lastName) {
			    this.lastName = lastName;
			  }
			  
			  private Date birthday;
			  
			  public Date getBirthday() {
			    return this.birthday;
			  }
			  
			  public void setBirthday(final Date birthday) {
			    this.birthday = birthday;
			  }
			}
		''')
	}
	
	new() {
		// workaround for bug on windows boxes
		System::setProperty("line.separator", "\n")
	}
	
}