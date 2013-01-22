package org.eclipse.xtend.ide.tests.codebuilder

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

import static extension org.junit.Assert.*

class AbstractBuilderTest extends AbstractXtendUITestCase {
	
	@Inject extension WorkbenchTestHelper
	
	@Inject extension IXtendJvmAssociations  
	
	@Inject extension TypeReferences
	
	JvmDeclaredType xtendClass

	JvmDeclaredType javaClass
	
	def protected getXtendClass() {
		if(xtendClass == null) {
			xtendClass = (xtendFile('Foo', '''
				class Foo {
				}
			''').xtendTypes.head as XtendClass).inferredType
		}
		xtendClass
	}
	
	def protected getJavaClass() {
		if(javaClass == null) {	
			createFile('Bar.java', '''
				public class Bar {
				}
			''')
			waitForAutoBuild
			javaClass = getTypeForName('Bar', getXtendClass).type as JvmDeclaredType
		}
		javaClass
	}
	
	def protected assertBuilds(ICodeBuilder builder, String expectedCode) {
		val appendable = new StringBuilderBasedAppendable
		builder.build(appendable)
		assertEquals(expectedCode, appendable.toString)
	}
}