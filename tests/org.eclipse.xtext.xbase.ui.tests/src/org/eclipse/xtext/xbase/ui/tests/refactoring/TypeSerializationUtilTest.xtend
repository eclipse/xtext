package org.eclipse.xtext.xbase.ui.tests.refactoring

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider
import org.junit.Test
import org.eclipse.xtext.xbase.ui.refactoring.TypeSerializationUtil
import com.google.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.typing.ITypeProvider
import static org.junit.Assert.*

/**
 * @author Jan Koehnlein
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseInjectorProvider))
class TypeSerializationUtilTest {
	
	@Inject TypeSerializationUtil util
	
	@Inject extension ParseHelper<XExpression>
	 
	@Inject extension ITypeProvider
	
	@Test def testSimple() {
		"val foo = ''".assertSerializedTypeOfFoo('String')	
		"val foo = 1".assertSerializedTypeOfFoo('int')	
	}
	
	@Test def testGenerics() {
		"val foo = newArrayList(new java.util.Date)".assertSerializedTypeOfFoo('java.util.ArrayList<java.util.Date>')	
		"val foo = newHashMap('x'->1, 'y'->2)".assertSerializedTypeOfFoo('java.util.HashMap<String,Integer>')	
	}
	
	@Test def testClosure() {
		"val foo = [|1]".assertSerializedTypeOfFoo('()=>int')	
		"val foo = [String x|x.toFirstUpper]".assertSerializedTypeOfFoo('(String)=>String')	
		"val foo = [String x, int offset|x.substring(offset)]".assertSerializedTypeOfFoo('(String,int)=>String')	
		"val foo = [String x|System.out.println(x)]".assertSerializedTypeOfFoo('(String)=>void')	
	}
	
	def protected assertSerializedTypeOfFoo(CharSequence model, String expectedOutput) {
		val expression = parse("{" + model + "}")
		val varDecl = expression.eAllContents.filter(typeof(XVariableDeclaration)).filter[identifier=='foo'].head
		assertNotNull(varDecl)
		val type = getType(varDecl.right)
		val serialized = util.serialize(type, expression)
		assertEquals(expectedOutput, serialized)
	}
}