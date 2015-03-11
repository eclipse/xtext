package org.eclipse.xtext.purexbase.test

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.purexbase.PureXbaseInjectorProvider
import org.eclipse.xtext.purexbase.pureXbase.Model
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.imports.DefaultImportsConfiguration
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(PureXbaseInjectorProvider)
class DefaultImportsConfigurationTest {
	
	@Inject extension ParseHelper<Model> parser
	@Inject DefaultImportsConfiguration defaultImportsConfiguration
	
	@Test def void testCommentsInImportSection() {
		val model = '''
			// some comment
			import java.util.List
			/* another
			 * comment
			 */
			import java.util.Set
			
			println("Hello World")
		'''.parse
		
		assertEquals(0, defaultImportsConfiguration.getImportSectionOffset(model.eResource as XtextResource))
	}	
}