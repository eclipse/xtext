/*******************************************************************************
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests;

import static com.google.common.collect.Lists.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.util.TemporaryFolder;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.LazyStringInputStream;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.runner.RunWith;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Abstract base for Xtend tests.
 */
@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
public abstract class AbstractXtendTestCase extends Assert {

	@Rule
	@Inject public TemporaryFolder temporaryFolder;
	
	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	protected XtendClass clazz(String string) throws Exception {
		return (XtendClass) file(string).getXtendTypes().get(0);
	}

	protected XtendFile file(String string) throws Exception {
		return file(string, false);
	}
	
	protected XtendFile file(String string, boolean validate) throws Exception {
		return file(string, validate, true);
	}

	protected XtendFile file(String string, boolean validate, boolean shouldBeSyntacticallyValid) throws Exception {
		XtextResourceSet set = getResourceSet();
		String fileName = getFileName(string);
		Resource resource = set.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new LazyStringInputStream(string, StandardCharsets.ISO_8859_1.name()), null);
		if (shouldBeSyntacticallyValid) {
			assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
		}
		if (validate) {
			List<Issue> issues = Lists.newArrayList(Iterables.filter(((XtextResource) resource).getResourceServiceProvider().getResourceValidator()
					.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl), new Predicate<Issue>() {
						@Override
						public boolean apply(Issue issue) {
							return issue.getSeverity() == Severity.ERROR;
						}
					}));
			assertTrue("Resource contained errors : " + issues.toString(), issues.isEmpty());
		}
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file;
	}
	
	protected XtendFile fileWithErrors(String string) throws Exception {
		XtextResourceSet set = getResourceSet();
		String fileName = getFileName(string);
		Resource resource = set.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new StringInputStream(string), null);
		assertTrue(resource.getErrors().toString(), resource.getErrors().size() > 0);
		XtendFile file = (XtendFile) resource.getContents().get(0);
		return file;
	}

	protected XtextResourceSet getResourceSet() {
		XtextResourceSet set = resourceSetProvider.get();
		set.setClasspathURIContext(getClass().getClassLoader());
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
		}
		for (Resource resource: new ArrayList<Resource>(set.getResources())) {
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
		if (classMatcher.find()) {
			String className = classMatcher.group(1);
			String pathName = "";
			if (packMatcher.find() && packMatcher.end(0) < classMatcher.start(0)) {
				pathName = packMatcher.group(1).replace('.', '/') + "/";
			}
			return pathName + className;
		}
		return "Sample";
	}
	
	protected XtendAnnotationType annotationType(String string) throws Exception {
		return (XtendAnnotationType) file(string).getXtendTypes().get(0);
	}

	protected XtendInterface interfaze(String string) throws Exception {
		return (XtendInterface) file(string).getXtendTypes().get(0);
	}

	protected XtendEnum enumeration(String string) throws Exception {
		return (XtendEnum) file(string).getXtendTypes().get(0);
	}

	protected XtendFunction function(String string) throws Exception {
		XtendClass clazz = clazz("class Foo { " + string + "}");
		return (XtendFunction) clazz.getMembers().get(0);
	}

	protected XtendFunction abstractFunction(String string) throws Exception {
		XtendClass clazz = clazz("abstract class Foo { " + string + "}");
		return (XtendFunction) clazz.getMembers().get(0);
	}

	protected XtendConstructor constructor(String string) throws Exception {
		XtendClass clazz = clazz("class Foo { " + string + "}");
		return (XtendConstructor) clazz.getMembers().get(0);
	}

	protected XtendField field(String string) throws Exception {
		XtendClass clazz = clazz("class Foo { " + string + "}");
		return (XtendField) clazz.getMembers().get(0);
	}

}