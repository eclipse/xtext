package org.eclipse.xtext.xbase.ui.tests.editor

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.jface.text.Region


class Bug379238Test extends AbstractXbaseUITestCase {
	
	@Inject
	ParseHelper<XConstructorCall> parseHelper
	
	@Inject
	TestingXbaseHoverProvider hoverProvider
	
	
	
	@Test
	def testXConstructorWithNullConstructorNoException() throws Exception {
		val constructorCall = parseHelper.parse('''
			new()
		''')
		val result = hoverProvider.getHoverInfo(constructorCall)
		assertNull(result)
	}
}

class TestingXbaseHoverProvider extends XbaseHoverProvider {
		
   def getHoverInfo(EObject element) {
		super.getHoverInfo(element, new Region(0,0) , null)
	}
	
}