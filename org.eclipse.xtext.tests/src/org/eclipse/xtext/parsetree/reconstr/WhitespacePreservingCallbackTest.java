package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

public class WhitespacePreservingCallbackTest extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(ComplexReconstrTestLanguageStandaloneSetup.class);
	}

	@Test public void testSimple() throws Exception {
		check("a");
	}

	@Test public void testHiddenInBetween() throws Exception {
		check("a \t /* foo bar */ + b");
	}

	@Test
	public void testFail1() throws Exception {
		IAstFactory f = getASTFactory();
		failsWith(f.create(ComplexrewritetestPackage.Literals.ADD), XtextSerializationException.class);
	}

	@Test
	public void testFail2() throws Exception {
		IAstFactory f = getASTFactory();
		EObject add = f.create(ComplexrewritetestPackage.Literals.ADD);

		// one operand INVALID
		EObject atom1 = f.create(ComplexrewritetestPackage.Literals.ATOM);
		f.set(atom1, "name", "x", null, null);
		f.add(add, "addOperands", atom1, null, null);
		failsWith(add, XtextSerializationException.class);

		// two operands VALID
		EObject atom2 = f.create(ComplexrewritetestPackage.Literals.ATOM);
		f.set(atom2, "name", "x", null, null);
		f.add(add, "addOperands", atom2, null, null);
		assertNotNull(serialize(add));

		// three operands INVALID
		EObject atom3 = f.create(ComplexrewritetestPackage.Literals.ATOM);
		f.set(atom3, "name", "x", null, null);
		f.add(add, "addOperands", atom3, null, null);
		failsWith(add, XtextSerializationException.class);
	}

	private void check(String m1) throws Exception {
		assertEquals(m1, parseAndSerialize(m1));
	}

	private String parseAndSerialize(String model) throws Exception {
		EObject result = getModel(model);
		return getSerializer().serialize(result, SaveOptions.defaultOptions());
	}

	@SuppressWarnings("deprecation")
	private void failsWith(EObject o, Class<? extends RuntimeException> clazz) {
		try {
			get(Serializer.class).serialize(o);
			fail("Should fail with "+clazz.getSimpleName());
		} catch (RuntimeException e) {
			if (!clazz.isInstance(e)) {
				throw e;
			}
		}
	}
}
