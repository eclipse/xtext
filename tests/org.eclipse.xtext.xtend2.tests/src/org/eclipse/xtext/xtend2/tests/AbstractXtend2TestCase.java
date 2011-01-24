package org.eclipse.xtext.xtend2.tests;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xtend2.Xtend2RuntimeModule;
import org.eclipse.xtext.xtend2.Xtend2StandaloneSetup;
import org.eclipse.xtext.xtend2.validation.Xtend2JavaValidator;
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
		return file(string).getXtendClass();
	}

	protected XtendFile file(String string) throws Exception {
		return file(string, false);
	}

	protected XtendFile file(String string, boolean validate) throws Exception {
		XtextResourceSet set = get(XtextResourceSet.class);
		String fileName = getFileName(string);
		Resource resource = set.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new StringInputStream(string), null);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
		if (validate) {
			setTestModeValidation(true);
			List<Issue> issues = ((XtextResource) resource).getResourceServiceProvider().getResourceValidator()
					.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
			assertTrue("Resource contained errors : " + issues.toString(), issues.isEmpty());
			setTestModeValidation(false);
		}
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file;
	}

	protected void setTestModeValidation(boolean b) {
		get(Xtend2JavaValidator.class).executeClassPathDependentValidation = !b;
	}

	protected String getFileName(String string) {
		Matcher packMatcher = Pattern.compile("package (\\S+)").matcher(string);
		Matcher classMatcher = Pattern.compile("class (\\w+)").matcher(string);
		String pathName = "";
		if (packMatcher.find()) {
			pathName = packMatcher.group(1).replace('.', '/') + "/";
		}
		classMatcher.find();
		return pathName + classMatcher.group(1);
	}

	protected XtendFunction function(String string) throws Exception {
		XtendClass clazz = clazz("class Foo { " + string + "}");
		return (XtendFunction) clazz.getMembers().get(0);
	}

}