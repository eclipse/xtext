package org.eclipse.xtext.xbase.tests.compiler.output

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.generator.trace.ITraceURIConverter
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.Test

import static org.eclipse.xtext.xbase.XbasePackage$Literals.*

class ErrorTreeAppendableTest extends AbstractXbaseTestCase {
	
	@Inject 
	private ILocationInFileProvider locationProvider
	
	@Inject 
	private IJvmModelAssociations jvmModelAssociations
	
	@Inject 
	private ITraceURIConverter converter;
	
	@Test
	def testTraceChildIsSelf() {
		val e = expression('42')
		val app = e.createErrorTreeAppendable
		assertEquals(app, app.trace(e))
		assertEquals(app, app.trace(e, true))
		assertEquals(app, app.trace(e, XNUMBER_LITERAL__VALUE, -1))
	}
	
	@Test
	def testAppendUnresolvedType() {
		val e = expression('typeof(  \tUnresolved\n)') as XTypeLiteral
		val app = e.createErrorTreeAppendable
		app.append(e.type)
		assertEquals('Unresolved', app.content)
	}
	
	def createErrorTreeAppendable(EObject source) {
		new TreeAppendable(new ImportManager(true), converter, locationProvider, jvmModelAssociations, source, " ", "<newline>").errorChild()
	}
}