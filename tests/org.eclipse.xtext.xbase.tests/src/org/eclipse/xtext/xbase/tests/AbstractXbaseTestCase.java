package org.eclipse.xtext.xbase.tests;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.CustomXbaseStandaloneSetup;
import org.eclipse.xtext.xbase.File;
import org.eclipse.xtext.xpression.Expression;

import com.google.inject.Injector;

import junit.framework.TestCase;

public abstract class AbstractXbaseTestCase extends TestCase {

	public AbstractXbaseTestCase() {
		super();
	}

	public AbstractXbaseTestCase(String name) {
		super(name);
	}
	
	protected Injector injector;

	@Override
	protected void setUp() throws Exception {
		injector = new CustomXbaseStandaloneSetup()
				.createInjectorAndDoEMFRegistration();
	}

	/**
	 * @param expr
	 */
	protected void log(EObject expr) {
		System.out.println(EmfFormatter.objToStr(expr));
	}

	protected Expression expression(String string) throws IOException {
		String model = "foo() : " + string + ";";
		File file = file(model);
		return file.getFunctions().get(0).getExpression();
	}

	/**
	 * @param model
	 * @return
	 * @throws IOException
	 */
	protected File file(String model) throws IOException {
		XtextResourceSet set = injector.getInstance(XtextResourceSet.class);
		Resource resource = set.createResource(URI.createURI("Test.xbase"));
		resource.load(new StringInputStream(model), null);
		File file = (File) resource.getContents().get(0);
		assertTrue(resource.getErrors().toString(), resource.getErrors()
				.isEmpty());
		return file;
	}

}