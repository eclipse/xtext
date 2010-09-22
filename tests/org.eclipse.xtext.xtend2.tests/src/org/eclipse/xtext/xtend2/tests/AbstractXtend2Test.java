package org.eclipse.xtext.xtend2.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtend2.Xtend2StandaloneSetup;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

public abstract class AbstractXtend2Test extends AbstractXtextTests {

	public AbstractXtend2Test() {
		super();
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new Xtend2StandaloneSetup());
	}

	protected XtendClass clazz(String string) throws Exception {
		return file(string).getClasses().get(0);
	}
	protected XtendFile file(String string) throws Exception {
		XtextResourceSet set = get(XtextResourceSet.class);
		Resource resource = set.createResource(URI.createURI("Test.xtd"));
		resource.load(new StringInputStream(string), null);
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file;
	}

	protected XtendFunction function(String string) throws Exception {
		XtendClass clazz = clazz("class Foo { "+string+"}");
		return (XtendFunction) clazz.getMembers().get(0);
	}

}