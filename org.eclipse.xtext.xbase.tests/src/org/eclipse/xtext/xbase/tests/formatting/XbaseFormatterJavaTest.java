/*******************************************************************************
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.formatting;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter;
import org.eclipse.xtext.xbase.tests.formatting.XbaseFormatterJavaTest.XbaseFormatterJavaTestInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author cdietrich - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseFormatterJavaTestInjectorProvider.class)
public class XbaseFormatterJavaTest extends XbaseFormatterTest {
	
	public static class XbaseFormatterJavaTestInjectorProvider extends XbaseFormatterTestInjectorProvider {
		@Override
		protected Injector internalCreateInjector() {
			return new FunctionTypeRefAwareTestStandaloneSetup() {
				@Override
				public Injector createInjector() {
					return Guice.createInjector(new XbaseTestRuntimeModule() {
						@Override
						public void configure(com.google.inject.Binder binder) {
							super.configure(binder);
							binder.bind(XbaseFormatter.class).to(XbaseFormatterJava.class);
						}
					});
				}
			}.createInjectorAndDoEMFRegistration();
		}
	}
	
	public static class XbaseFormatterJava extends XbaseFormatter {
		@Override
		public void format(Object expr, IFormattableDocument format) {
			formatUsingPolymorphicDispatcher(expr, format);
		}
		
		@Override
		protected void _format(XPostfixOperation expr, IFormattableDocument doc) {
			doc.prepend(regionFor(expr).feature(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE), this::oneSpace);
			doc.format(expr.getOperand());
		}
	}
	
	@Override
	@Test
	public void formatPostfix() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String expectation =
					"val i = j ++\n";
			it.setExpectation(expectation);
			String toBeFormatted =
					"val i = j++\n";
			it.setToBeFormatted(toBeFormatted);
		});
	}

}
