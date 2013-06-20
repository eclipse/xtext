package org.eclipse.xtend.core.tests.macro

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target
import java.util.List
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.junit.Test

class HttpGetAnnotationTest extends AbstractActiveAnnotationTest {
	
	@Test def void testGetAnnotation() {
		'''
			import org.eclipse.xtend.core.tests.macro.Get
			
			class MyServlet {
				@Get("user/:id") def findUser() {
					
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtend.core.tests.macro.Get;
			
			@SuppressWarnings("all")
			public class MyServlet {
			  @Get("user/:id")
			  public Object findUser() {
			    return null;
			  }
			}
		''')
	}
}

@Retention(RetentionPolicy::RUNTIME)
@Target(ElementType::METHOD)
@Active(typeof(GetProcessor))
annotation Get { 
	String value
}

class GetProcessor implements TransformationParticipant<MutableMethodDeclaration> {
	
	override doTransform(List<? extends MutableMethodDeclaration> methods, extension TransformationContext context) {
		for (m : methods) {
			val annotation = m.findAnnotation(typeof(Get).findTypeGlobally)
			val pattern = annotation.getValue('value')
			if (pattern == null) {
				annotation.addError('A URL pattern must be provided.')
			} else {
				
			}
		}
	}
	
}

