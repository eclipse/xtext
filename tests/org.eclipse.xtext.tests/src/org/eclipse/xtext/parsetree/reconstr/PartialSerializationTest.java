package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parsetree.reconstr.partialserializationtest.NodeRoot;
import org.eclipse.xtext.resource.SaveOptions;

public class PartialSerializationTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(PartialSerializationTestLanguageStandaloneSetup.class);
	}

	private String ser(EObject obj) {
		return getSerializer().serialize(obj, SaveOptions.defaultOptions());
	}

	public void testSimple() throws Exception {
		String model = " #1  node  test  (  node  subnode  )";
		NodeRoot root = (NodeRoot) getModel(model);
		assertEquals("node  test  (  node  subnode  )", ser(root.getNode()));
	}

	public void testSimpleSurroundComments1() throws Exception {
		String model = "/* x1 */ #1 /* x2 */ node /* x3 */ test  (  node  subnode /* x4 */ ) /* x5 */";
		NodeRoot root = (NodeRoot) getModel(model);
		assertEquals(model, ser(root));
	}

	public void testSimpleSurroundComments2() throws Exception {
		String model = "/* x1 */ #1 /* x2 */ node /* x3 */ test  (  node  subnode /* x4 */ ) /* x5 */";
		NodeRoot root = (NodeRoot) getModel(model);
		assertEquals("/* x2 */ node /* x3 */ test  (  node  subnode /* x4 */ ) ", ser(root.getNode()));
	}

	public void testSimpleSurroundComments3() throws Exception {
		String model = "/* x1 */ #1 /* x2 */ node /* x3 */ test /* x4 */  ( /* x5 */ node /* x6 */ subnode /* x7 */ ) /* x8 */";
		NodeRoot root = (NodeRoot) getModel(model);
		String ser = ser(root.getNode().getChildren().get(0));
		assertEquals("/* x5 */ node /* x6 */ subnode", ser);
	}

}
