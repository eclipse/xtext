package org.eclipse.xtext.xtend2.tests;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtend2.Xtend2RuntimeModule;
import org.eclipse.xtext.xtend2.Xtend2StandaloneSetup;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Guice;
import com.google.inject.Injector;

public abstract class AbstractXtend2TestCase extends TestCase {

	static Injector injector = new Xtend2StandaloneSetup() {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new Xtend2RuntimeModule() {
				@Override
				public ClassLoader bindClassLoaderToInstance() {
					return AbstractXtend2TestCase.class.getClassLoader();
				}
			});
		}
	}.createInjectorAndDoEMFRegistration();
	
	@Override
	protected void setUp() throws Exception {
		getInjector().injectMembers(this);
	}

	public Injector getInjector() {
		return injector;
	}
	
	public <T> T get(Class<T> clazz) {
		return getInjector().getInstance(clazz);
	}

	protected XtendClass clazz(String string) throws Exception {
		return file(string).getClasses().get(0);
	}
	
	protected XtendFile file(String string) throws Exception {
		XtextResourceSet set = get(XtextResourceSet.class);
		Resource resource = set.createResource(URI.createURI("Test.xtd"));
		resource.load(new StringInputStream(string), null);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file;
	}

	protected XtendFunction function(String string) throws Exception {
		XtendClass clazz = clazz("class Foo { "+string+"}");
		return (XtendFunction) clazz.getMembers().get(0);
	}

}