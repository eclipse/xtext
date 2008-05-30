package org.eclipse.xtext.typeresolution;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.xtextutil.ResolvedType;
import org.eclipse.xtext.xtextutil.XtextutilPackage;

public class TypeResolutionExtensionsTest extends AbstractGeneratorTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextutilPackage.eINSTANCE.getAbstractType();
		with(XtextStandaloneSetup.class);
	}
	
	public void test_resolveReturnType() throws Exception {
		Grammar model = (Grammar) getModel("generate foo 'bar' as x Model returns x::Foo : 'holla' name=ID;");
		ResolvedType type = (ResolvedType) invokeWithXtend("parserRules.first().resolveReturnType()", model);
		assertNotNull(type);
		assertWithXtend("'x::Foo'", "qualifiedName()", type);
	}
	
	@Override
	protected String[] importedExtensions() {
		return new String[] { "org::eclipse::xtext::TypeResolution", "org::eclipse::xtext::Extensions"};
	}
}
