package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;
import org.eclipse.xtext.parsetree.reconstr.parser.ComplexReconstrTestASTFactory;

public class ComplexReconstrTest extends AbstractGeneratorTest {
	public void testSimple() throws Exception {
		String model = "( a + b - c ) !";
		assertEquals(model,parseAndSerialize(model));
	}
	
	public void testComplex() throws Exception {
		String model = "( ( a + b ) ! - c + d + e + f - ( x + s ) - ( ( a + b ) ! - c ) ! ) !";
		assertEquals(model,parseAndSerialize(model));
	}

	private String parseAndSerialize(String model) throws Exception {
		EObject result = (EObject) parse(model,new ComplexReconstrTestASTFactory());
		ComplexReconstrTestParseTreeConstructor con = new ComplexReconstrTestParseTreeConstructor();
		con.proceedOp(result);
		String resultString = con.getText();
		return resultString;
	}
}
