package org.eclipse.xtext.xtend2.tests;

import static com.google.common.collect.Lists.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xtend2.Xtend2RuntimeModule;
import org.eclipse.xtext.xtend2.Xtend2StandaloneSetup;
import org.eclipse.xtext.xtend2.validation.ClasspathBasedChecks;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Factory;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendConstructor;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;

public abstract class AbstractXtend2TestCase extends TestCase {

	private static Injector injector = new TestSetup().createInjectorAndDoEMFRegistration();

	private static class TestSetup extends Xtend2StandaloneSetup {
		
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new Xtend2RuntimeModule() {
				@Override
				public ClassLoader bindClassLoaderToInstance() {
					return AbstractXtend2TestCase.class.getClassLoader();
				}
				
				@SuppressWarnings("unused")
				public Xtend2Factory bindFactory() {
					return Xtend2Factory.eINSTANCE;
				}

				@SuppressWarnings("unused")
				public ClasspathBasedChecks bindClassPathBasedChecks() {
					return new ClasspathBasedChecks() {
						@Override
						public void checkFileNamingConventions(XtendFile xtendFile) {
							// disabled
						}
					};
				}

			});
		}
	}

	@Override
	protected void setUp() throws Exception {
		doGetInjector().injectMembers(this);
	}

	public static Injector getInjector() {
//		if (injector == null)
//			injector = new TestSetup().createInjectorAndDoEMFRegistration();
		return injector;
	}
	
	protected Injector doGetInjector() {
		return getInjector();
	}

	public <T> T get(Class<T> clazz) {
		return doGetInjector().getInstance(clazz);
	}

	protected XtendClass clazz(String string) throws Exception {
		return file(string).getXtendClass();
	}

	protected XtendFile file(String string) throws Exception {
		return file(string, false);
	}

	protected XtendFile file(String string, boolean validate) throws Exception {
		XtextResourceSet set = getResourceSet();
		String fileName = getFileName(string);
		Resource resource = set.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new StringInputStream(string), null);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
		if (validate) {
			List<Issue> issues = Lists.newArrayList(Iterables.filter(((XtextResource) resource).getResourceServiceProvider().getResourceValidator()
					.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl), new Predicate<Issue>() {
						public boolean apply(Issue issue) {
							return issue.getSeverity() == Severity.ERROR;
						}
					}));
			assertTrue("Resource contained errors : " + issues.toString(), issues.isEmpty());
		}
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file;
	}

	protected XtextResourceSet getResourceSet() {
		XtextResourceSet set = get(XtextResourceSet.class);
		return set;
	}
	
	protected Iterable<XtendFile> files(boolean validate, String ... contents) throws Exception {
		XtextResourceSet set = getResourceSet();
		List<XtendFile> result = newArrayList();
		for (String string : contents) {
			String fileName = getFileName(string);
			Resource resource = set.createResource(URI.createURI(fileName + ".xtend"));
			resource.load(new StringInputStream(string), null);
			assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
			XtendFile file = (XtendFile) resource.getContents().get(0);
			result.add(file);
		}
		if (validate) {
			for (XtendFile file : result) {
				List<Issue> issues = ((XtextResource) file.eResource()).getResourceServiceProvider().getResourceValidator()
						.validate(file.eResource(), CheckMode.ALL, CancelIndicator.NullImpl);
				assertTrue("Resource contained errors : " + issues.toString(), issues.isEmpty());
			}
		}
		return result;
	}

	protected String getFileName(String string) {
		Matcher packMatcher = Pattern.compile("package (\\S+)").matcher(string);
		Matcher classMatcher = Pattern.compile("class (\\w+)").matcher(string);
		String pathName = "";
		if (packMatcher.find()) {
			pathName = packMatcher.group(1).replace('.', '/') + "/";
		}
		if (classMatcher.find())
			return pathName + classMatcher.group(1);
		return "Sample";
	}

	protected XtendFunction function(String string) throws Exception {
		XtendClass clazz = clazz("class Foo { " + string + "}");
		return (XtendFunction) clazz.getMembers().get(0);
	}
	
	protected XtendConstructor constructor(String string) throws Exception {
		XtendClass clazz = clazz("class Foo { " + string + "}");
		return (XtendConstructor) clazz.getMembers().get(0);
	}

}