/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.formatting;

import java.util.function.Consumer;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.junit.formatter.FormatterTester;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(XbaseFormatterTestInjectorProvider.class)
public class TypeReferenceFormatterTest {
	@Inject
	private FormatterTester tester;

	private void assertFormattedTypeRef(Consumer<? super FormatterTestRequest> test) {
		tester.assertFormatted(it -> {
			test.accept(it);
			// @formatter:off
			String model = 
					"{" + Strings.newLine() +
					"\tvar " + it.getToBeFormatted() + " x" + Strings.newLine() +
					"}";
			// @formatter:on
			it.setToBeFormatted(model);
		});
	}

	@Test
	public void simple() {
		assertFormattedTypeRef(it -> it.setToBeFormatted("String"));
	}

	@Test
	public void array1() {
		assertFormattedTypeRef(it -> it.setToBeFormatted("String[]"));
	}

	@Test
	public void array2() {
		assertFormattedTypeRef(it -> it.setToBeFormatted("String[][]"));
	}

	@Test
	public void function0() {
		assertFormattedTypeRef(it -> it.setToBeFormatted("=>void"));
	}

	@Test
	public void function1() {
		assertFormattedTypeRef(it -> it.setToBeFormatted("()=>void"));
	}

	@Test
	public void function2() {
		assertFormattedTypeRef(it -> it.setToBeFormatted("(String)=>String"));
	}

	@Test
	public void function3() {
		assertFormattedTypeRef(it -> it.setToBeFormatted("(Collection<?>)=>Collection<?>"));
	}

	@Test
	public void function4() {
		assertFormattedTypeRef(it -> it.setToBeFormatted("(Collection<? extends String>)=>Collection<? extends String>"));
	}

	@Test
	public void function5() {
		assertFormattedTypeRef(it -> it.setToBeFormatted("(String, String)=>String"));
	}

	@Test
	public void parameters1() {
		assertFormattedTypeRef(it -> it.setToBeFormatted("Collection<String>"));
	}

	@Test
	public void parameters2() {
		assertFormattedTypeRef(it -> it.setToBeFormatted("Map<String, String>"));
	}

	@Test
	public void parametersNested() {
		assertFormattedTypeRef(it -> it.setToBeFormatted("Map<Collection<String>, Collection<String>>"));
	}

	@Test
	public void parametersUpperBound() {
		assertFormattedTypeRef(it -> it.setToBeFormatted("Collection<? extends String>"));
	}

	@Test
	public void parametersLowerBound() {
		assertFormattedTypeRef(it -> it.setToBeFormatted("Collection<? super String>"));
	}
}
