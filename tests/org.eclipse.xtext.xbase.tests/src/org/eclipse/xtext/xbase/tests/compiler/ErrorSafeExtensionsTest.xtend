package org.eclipse.xtext.xbase.tests.compiler

import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.Test
import org.eclipse.xtext.resource.ILocationInFileProvider
import com.google.inject.Inject
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider
import org.eclipse.xtext.util.OnChangeEvictingCache
import org.eclipse.xtext.xbase.compiler.IElementIssueProvider
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.xbase.compiler.ErrorSafeExtensions
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.compiler.LoopParams
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.XCastedExpression

class ErrorSafeExtensionsTest extends AbstractXbaseTestCase {
	
	@Inject ILocationInFileProvider locationProvider
	
	@Inject IJvmModelAssociations jvmModelAssociations
	
	@Inject IResourceValidator resourceValidator 
	
	@Inject ElementIssueProvider$Factory issueProviderFactory
	
	@Inject OnChangeEvictingCache cache
	
	@Inject extension ErrorSafeExtensions 

	@Test
	def testAppendForEachSafely() {
		val e = validatedExpression('{ val x=42 val y=42 }') as XBlockExpression
		val app = createTreeAppendable(e)
		assertFalse(e.expressions.get(0).hasErrors(true))
		assertFalse(e.expressions.get(1).hasErrors(true))
		app.forEachSafely(e.expressions, loopInitializer, [it, app2| app2.append(text)])
		assertEquals('(val x=42:val y=42)', app.content)
	}
	
	@Test
	def testAppendForEachSafely_0() {
		val e = validatedExpression('{ error val x=42 val y=42 }') as XBlockExpression
		val app = createTreeAppendable(e)
		assertTrue(e.expressions.get(0).hasErrors(true))
		assertFalse(e.expressions.get(1).hasErrors(true))
		assertFalse(e.expressions.get(2).hasErrors(true))
		app.forEachSafely(e.expressions, loopInitializer, [it, app2| app2.append(text)])
		assertEquals('(/* error */val x=42:val y=42)', app.content)
	}
	
	@Test
	def testAppendForEachSafely_1() {
		val e = validatedExpression('{ val x=42 error val y=42 }') as XBlockExpression
		val app = createTreeAppendable(e)
		assertFalse(e.expressions.get(0).hasErrors(true))
		assertTrue(e.expressions.get(1).hasErrors(true))
		assertFalse(e.expressions.get(2).hasErrors(true))
		app.forEachSafely(e.expressions, loopInitializer, [it, app2| app2.append(text)])
		assertEquals('(val x=42/* :error */:val y=42)', app.content)
	}
	
	@Test
	def testAppendForEachSafely_2() {
		val e = validatedExpression('{ val x=42 val y=42 error }') as XBlockExpression
		val app = createTreeAppendable(e)
		assertFalse(e.expressions.get(0).hasErrors(true))
		assertFalse(e.expressions.get(1).hasErrors(true))
		assertTrue(e.expressions.get(2).hasErrors(true))
		app.forEachSafely(e.expressions, loopInitializer, [it, app2| app2.append(text)])
		assertEquals('(val x=42:val y=42/* :error */)', app.content)
	}
	
	@Test
	def testAppendForEachSafely_3() {
		val e = validatedExpression('{ error }') as XBlockExpression
		val app = createTreeAppendable(e)
		assertTrue(e.expressions.get(0).hasErrors(true))
		app.forEachSafely(e.expressions, loopInitializer, [it, app2| app2.append(text)])
		assertEquals('/* (error) */', app.content)
	}
	
	@Test
	def testAppendForEachSafely_4() {
		val e = validatedExpression('{ error1 error2 }') as XBlockExpression
		val app = createTreeAppendable(e)
		assertTrue(e.expressions.get(0).hasErrors(true))
		assertTrue(e.expressions.get(1).hasErrors(true))
		app.forEachSafely(e.expressions, loopInitializer, [it, app2| app2.append(text)])
		assertEquals('/* (error1:error2) */', app.content)
	}
	
	@Test
	def testSerializeSafely() {
		val e = validatedExpression('null as Unresolved') as XCastedExpression
		val app = createTreeAppendable(e)
		assertTrue(e.hasErrors(true))
		e.type.serializeSafely(app)
		assertEquals('/* Unresolved */', app.content)
	}
	
	@Test
	def testSerializeSafely_1() {
		val e = validatedExpression('null as Unresolved') as XCastedExpression
		val app = createTreeAppendable(e)
		assertTrue(e.hasErrors(true))
		e.type.serializeSafely('Object', app)
		assertEquals('/* Unresolved */Object', app.content)
	}
	
	@Test
	def testSerializeSafely_2() {
		val e = validatedExpression('null as String') as XCastedExpression
		val app = createTreeAppendable(e)
		assertFalse(e.hasErrors(true))
		e.type.serializeSafely(app)
		assertEquals('String', app.content)
	}
	
	
	def protected validatedExpression(CharSequence model) {
		val expression = expression(model, false)
		cache.get(typeof(IElementIssueProvider).name, expression.eResource, [|
			val issues = resourceValidator.validate(expression.eResource, CheckMode::ALL, CancelIndicator::NullImpl)
			issueProviderFactory.create(expression.eResource, issues)
		])
		expression
	}
	
	def protected createTreeAppendable(EObject source) {
		new TreeAppendable(new ImportManager(true), locationProvider, jvmModelAssociations, source, " ", "<newline>")
	}
	
	def protected getText(EObject object) {
		NodeModelUtils::findActualNodeFor(object).text.trim
	}
	
	def protected (LoopParams)=>void getLoopInitializer() {
		 [prefix='(' separator=':' suffix=')']
	}
}