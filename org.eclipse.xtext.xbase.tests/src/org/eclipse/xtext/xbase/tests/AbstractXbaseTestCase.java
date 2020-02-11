/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XExpression;
import org.junit.Assert;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseInjectorProvider.class)
public abstract class AbstractXbaseTestCase extends Assert {
	
	private static final boolean isJava11OrLater = determineJava11OrLater();
	
	public static boolean isJava11OrLater() {
		return isJava11OrLater;
	}
	
	private static final boolean isJava12OrLater = determineJava12OrLater();
	
	public static boolean isJava12OrLater() {
		return isJava12OrLater;
	}

	private static boolean determineJava11OrLater() {
		String javaVersion = System.getProperty("java.version");
		try {
			Pattern p = Pattern.compile("(\\d+)(.)*");
			Matcher matcher = p.matcher(javaVersion);
			if (matcher.matches()) {
				String first = matcher.group(1);
				int version = Integer.parseInt(first);
				return version >= 11;
			}
		} catch (NumberFormatException e) {
			// ok
		}
		return false;
	}

	private static boolean determineJava12OrLater() {
		String javaVersion = System.getProperty("java.version");
		try {
			Pattern p = Pattern.compile("(\\d+)(.)*");
			Matcher matcher = p.matcher(javaVersion);
			if (matcher.matches()) {
				String first = matcher.group(1);
				int version = Integer.parseInt(first);
				return version >= 12;
			}
		} catch (NumberFormatException e) {
			// ok
		}
		return false;
	}

	@Inject
	private Injector injector;

	public Injector getInjector() {
		return injector;
	}

	public <T> T get(Class<T> clazz) {
		return getInjector().getInstance(clazz);
	}

	protected XExpression expression(CharSequence string) throws Exception {
		return expression(string, false);
	}

	@Inject
	private ParseHelper<XExpression> parseHelper;
	@Inject
	private ValidationTestHelper validationHelper;
	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	protected XExpression expression(CharSequence string, boolean resolve) throws Exception {
		XExpression parse = parseHelper.parse(string);
		if (resolve)
			validationHelper.assertNoErrors(parse);
		return parse;
	}

	protected Resource newResource(CharSequence input) throws IOException {
		XtextResourceSet set = newXtextResourceSet();
		Resource resource = set.createResource(URI.createURI("Test.___xbase"));
		resource.load(new StringInputStream(input.toString()), null);
		return resource;
	}

	private XtextResourceSet newXtextResourceSet() {
		return resourceSetProvider.get();
	}

}
