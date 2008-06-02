package org.eclipse.xtext.xtext2ecore;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.xtextutil.XtextutilPackage;

public class MultiEPackagesTest extends AbstractGeneratorTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextutilPackage.eINSTANCE.getAbstractType();
		with(XtextStandaloneSetup.class);
	}
	
	@SuppressWarnings("unchecked")
	public void testSimple() throws Exception {
		Grammar model = (Grammar) getModel("generate foo 'foo' generate bar 'bar' as bar Foo : 'foo' bar=Bar; Bar returns bar::Bar : flag?='bar';");
		List<EPackage> result = (List<EPackage>) invokeWithXtend("getAllEPackages()", model);
		assertEquals(3,result.size());
		assertWithXtend("1", "get(0).eClassifiers.size", result);
		assertWithXtend("'Foo'", "get(0).eClassifiers.first().name", result);
		
		assertWithXtend("1", "get(1).eClassifiers.size", result);
		assertWithXtend("'Bar'", "get(1).eClassifiers.first().name", result);
	}
	
	@SuppressWarnings("unchecked")
	public void testInheritance() throws Exception {
		Grammar model = (Grammar) getModel("generate foo 'foo' generate bar 'bar' as bar Main : Foo | Bar; Foo : 'foo' bar=Bar; Bar returns bar::Bar : flag?='bar';");
		List<EPackage> result = (List<EPackage>) invokeWithXtend("getAllEPackages()", model);
		assertEquals(3,result.size());
		assertWithXtend("2", "get(0).eClassifiers.size", result);
		assertWithXtend("1", "get(0).eClassifiers.select(e|e.name=='Main').size", result);
		assertWithXtend("1", "get(0).eClassifiers.select(e|e.name=='Foo').size", result);
		assertWithXtend("'Main'", "get(0).eClassifiers.select(e|e.name=='Foo').first().eSuperTypes.first().name", result);
		
		assertWithXtend("1", "get(1).eClassifiers.size", result);
		assertWithXtend("'Bar'", "get(1).eClassifiers.first().name", result);
		assertWithXtend("'Main'", "get(1).eClassifiers.first().eSuperTypes.first().name", result);
	}
	
	
	@Override
	protected String[] importedExtensions() {
		return new String[]{"org::eclipse::xtext::xtext2ecore::Xtext2Ecore"};
	}
}
