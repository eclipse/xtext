package org.eclipse.xtext.xbase.ui.tests.refactoring

import com.google.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typing.ITypeProvider
import org.eclipse.xtext.xbase.ui.refactoring.TypeSerializationUtil
import org.junit.Ignore
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Jan Koehnlein
 */
class TypeSerializationUtilTest extends AbstractXbaseTestCase {
	
	@Inject TypeSerializationUtil util
	
	@Inject extension ParseHelper<XExpression>
	 
	@Inject extension ITypeProvider
	
	@Test def testSimple() {
		"val foo = ''".assertSerializedTypeOfFoo('String')	
		"val foo = 1".assertSerializedTypeOfFoo('int')	
	}
	
	@Ignore
	@Test def testGenerics() {
		"val foo = newArrayList(new java.util.Date)".assertSerializedTypeOfFoo('ArrayList<Date>', 'java.util.ArrayList', 'java.util.Date')	
		"val foo = newHashMap('x'->1, 'y'->2)".assertSerializedTypeOfFoo('HashMap<String,Integer>', 'java.util.HashMap')	
	}
	
	@Test def testClosure() {
		"val foo = [|1]".assertSerializedTypeOfFoo('()=>int')	
		"val foo = [String x|x.toFirstUpper]".assertSerializedTypeOfFoo('(String)=>String')	
		"val foo = [String x, int offset|x.substring(offset)]".assertSerializedTypeOfFoo('(String, int)=>String')
	}
	
	@Ignore("TODO implement me")
	@Test def testClosureToVoid() {
		"val foo = [String x|System::out.println(x)]".assertSerializedTypeOfFoo('(String)=>void')	
	}
	
	@Test def testClosureWithExpectation() {
		"val Runnable foo = [|1]".assertSerializedTypeOfFoo('()=>void')	
	}
	
	def protected assertSerializedTypeOfFoo(CharSequence model, String expectedOutput, String... expectedImports) {
		val expression = parse("{" + model + "}")
		val varDecl = expression.eAllContents.filter(typeof(XVariableDeclaration)).filter[identifier=='foo'].head
		assertNotNull(varDecl)
		val type = getType(varDecl.right)
		val serialized = util.serialize(type, expression)
		assertEquals(expectedOutput, serialized)
		val actualImports = util.getImportManager(expression).imports
		assertEquals(actualImports.size, expectedImports.size)
		assertTrue(actualImports.containsAll(expectedImports))
	}
}