package org.eclipse.xtext.xbase.tests.compiler

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.generator.trace.ITraceURIConverter
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XCastedExpression
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider
import org.eclipse.xtext.xbase.compiler.ErrorSafeExtensions
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.LoopParams
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.Test

class ErrorSafeExtensionsTest extends AbstractXbaseTestCase {
	
	@Inject ILocationInFileProvider locationProvider
	
	@Inject IJvmModelAssociations jvmModelAssociations
	
	@Inject ElementIssueProvider$Factory issueProviderFactory
	
	@Inject ITraceURIConverter converter
	
	@Inject extension ErrorSafeExtensions 

	@Test
	def testAppendForEachSafely() {
		val e = validatedExpression('{ val x=42 val y=42 }') as XBlockExpression
		val app = createTreeAppendable(e)
		assertFalse(e.expressions.get(0).hasErrors())
		assertFalse(e.expressions.get(1).hasErrors())
		app.forEachSafely(e.expressions, loopInitializer, [it, app2| app2.append(text)])
		assertEquals('(val x=42:val y=42)', app.content)
	}
	
	@Test
	def testAppendForEachSafely_0() {
		val e = validatedExpression('{ error val x=42 val y=42 }') as XBlockExpression
		val app = createTreeAppendable(e)
		assertTrue(e.expressions.get(0).hasErrors())
		assertFalse(e.expressions.get(1).hasErrors())
		assertFalse(e.expressions.get(2).hasErrors())
		app.forEachSafely(e.expressions, loopInitializer, [it, app2| app2.append(text)])
		assertEquals('(/* error */val x=42:val y=42)', app.content)
	}
	
	@Test
	def testAppendForEachSafely_1() {
		val e = validatedExpression('{ val x=42 error val y=42 }') as XBlockExpression
		val app = createTreeAppendable(e)
		assertFalse(e.expressions.get(0).hasErrors())
		assertTrue(e.expressions.get(1).hasErrors())
		assertFalse(e.expressions.get(2).hasErrors())
		app.forEachSafely(e.expressions, loopInitializer, [it, app2| app2.append(text)])
		assertEquals('(val x=42/* :error */:val y=42)', app.content)
	}
	
	@Test
	def testAppendForEachSafely_2() {
		val e = validatedExpression('{ val x=42 val y=42 error }') as XBlockExpression
		val app = createTreeAppendable(e)
		assertFalse(e.expressions.get(0).hasErrors())
		assertFalse(e.expressions.get(1).hasErrors())
		assertTrue(e.expressions.get(2).hasErrors())
		app.forEachSafely(e.expressions, loopInitializer, [it, app2| app2.append(text)])
		assertEquals('(val x=42:val y=42/* :error */)', app.content)
	}
	
	@Test
	def testAppendForEachSafely_3() {
		val e = validatedExpression('{ error }') as XBlockExpression
		val app = createTreeAppendable(e)
		assertTrue(e.expressions.get(0).hasErrors())
		app.forEachSafely(e.expressions, loopInitializer, [it, app2| app2.append(text)])
		assertEquals('/* (error) */', app.content)
	}
	
	@Test
	def testAppendForEachSafely_4() {
		val e = validatedExpression('{ error1 error2 }') as XBlockExpression
		val app = createTreeAppendable(e)
		assertTrue(e.expressions.get(0).hasErrors())
		assertTrue(e.expressions.get(1).hasErrors())
		app.forEachSafely(e.expressions, loopInitializer, [it, app2| app2.append(text)])
		assertEquals('/* (error1:error2) */', app.content)
	}
	
	@Test
	def testSerializeSafely() {
		val e = validatedExpression('null as Unresolved') as XCastedExpression
		val app = createTreeAppendable(e)
		assertTrue(e.hasErrors())
		e.type.serializeSafely(app)
		assertEquals('/* Unresolved */', app.content)
	}
	
	@Test
	def testSerializeSafely_1() {
		val e = validatedExpression('null as Unresolved') as XCastedExpression
		val app = createTreeAppendable(e)
		assertTrue(e.hasErrors())
		e.type.serializeSafely('Object', app)
		assertEquals('/* Unresolved */Object', app.content)
	}
	
	@Test
	def testSerializeSafely_2() {
		val e = validatedExpression('null as String') as XCastedExpression
		val app = createTreeAppendable(e)
		assertFalse(e.hasErrors())
		e.type.serializeSafely(app)
		assertEquals('String', app.content)
	}
	
	
	def protected validatedExpression(CharSequence model) {
		val expression = expression(model, false)
		issueProviderFactory.attachData(expression.eResource)
		expression
	}
	
	def protected createTreeAppendable(EObject source) {
		new TreeAppendable(new ImportManager(true), converter, locationProvider, jvmModelAssociations, source, " ", "<newline>")
	}
	
	def protected getText(EObject object) {
		NodeModelUtils::findActualNodeFor(object).text.trim
	}
	
	def protected (LoopParams)=>void getLoopInitializer() {
		 [prefix='(' separator=':' suffix=')']
	}
}