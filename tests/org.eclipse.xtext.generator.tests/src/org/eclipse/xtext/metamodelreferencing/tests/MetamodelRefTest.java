package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2t.type.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;
import org.eclipse.xtext.metamodelreferencing.tests.parser.MetamodelRefTestASTFactory;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.xtend.XtendFacade;

public class MetamodelRefTest extends AbstractGeneratorTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextPackage.eINSTANCE.getRuleCall(); // register Xtext EPackage
	}
	
	public void testStuff() throws Exception {
		Object parse = parse("foo 'bar'", new MetamodelRefTestASTFactory());
		assertWithXtend("'SimpleTest::Foo'","metaType.name",parse);
		assertWithXtend("'xtext::RuleCall'","nameRefs.first().metaType.name",parse);
	}
	
	@Override
	protected XtendFacade getXtendFacade() {
		ExecutionContextImpl ctx = new ExecutionContextImpl();
		ctx.registerMetaModel(new EmfRegistryMetaModel() {
			@Override
			protected EPackage[] allPackages() {
				return new EPackage[]{MetamodelRefTestConstants.getSimpleTestEPackage()};
			}
		});
		XtendFacade facade = XtendFacade.create(ctx);
		return facade;
	}
}
