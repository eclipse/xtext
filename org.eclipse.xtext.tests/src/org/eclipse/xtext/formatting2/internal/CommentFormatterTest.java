/**
 * Copyright (c) 2017, 2021 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList;
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FormatterTestLanguageInjectorProvider.class)
public class CommentFormatterTest {
	public static class CustomFormatter extends GenericFormatter<IDList> {
		@Override
		public void format(IDList model, ITextRegionExtensions regionAccess, IFormattableDocument document) {
			document.append(textRegionExtensions.regionFor(model).keyword("idlist"), (IHiddenRegionFormatter it) -> {
				it.oneSpace();
			});
		}
	}

	@Inject
	private GenericFormatterTester genericFormatterTester;

	@Test
	public void SL_inline() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setFormatter(new CustomFormatter());
			String model =
					"idlist  //x\n" +
					"a\n";
			it.setToBeFormatted(model);
			String expectation =
					"idlist //x\n" +
					"a\n";
			it.setExpectation(expectation);
		});
	}

	@Test
	public void SL_multiline() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setFormatter(new CustomFormatter());
			String model =
					"idlist  \n" +
					"\n" +
					"//x\n" +
					"\n" +
					"\n" +
					"a\n";
			it.setToBeFormatted(model);
			String expectation =
					"idlist //x\n" +
					"a\n";
			it.setExpectation(expectation);
		});
	}

	@Test
	public void MLSL_inline() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setFormatter(new CustomFormatter());
			String model = "idlist  /*x*/  a\n";
			it.setToBeFormatted(model);
			String expectation = "idlist /*x*/ a\n";
			it.setExpectation(expectation);
		});
	}

	@Test
	public void MLSL_double_inline() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setFormatter(new CustomFormatter());
			String model = "idlist  /*x*//*y*/  a\n";
			it.setToBeFormatted(model);
			String expectation = "idlist /*x*/ /*y*/ a\n";
			it.setExpectation(expectation);
		});
	}

	@Test
	public void MLSL_paragraph() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setFormatter(new CustomFormatter());
			String model =
					"idlist\n" +
					"\n" +
					"\n" +
					"/*x*/\n" +
					"\n" +
					"\n" +
					"a\n";
			it.setToBeFormatted(model);
			String expectation =
					"idlist /*x*/\n" +
					"a\n";
			it.setExpectation(expectation);
		});
	}

	@Test
	public void MLML_inline() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setFormatter(new CustomFormatter());
			String model =
					"idlist  /*\n" +
					"x\n" +
					"*/  a\n";
			it.setToBeFormatted(model);
			String expectation =
					"idlist\n" +
					"/*\n" +
					" * x\n" +
					" */\n" +
					"a\n";
			it.setExpectation(expectation);
		});
	}

	@Test
	public void MLML_paragraph() {
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setFormatter(new CustomFormatter());
			String model =
					"idlist\n" +
					"\n" +
					"\n" +
					"/*\n" +
					"x\n" +
					"*/\n" +
					"\n" +
					"\n" +
					"a\n";
			it.setToBeFormatted(model);
			String expectation = 
					"idlist\n" +
					"\n" +
					"\n" +
					"/*\n" +
					" * x\n" +
					" */\n" +
					"a\n";
			it.setExpectation(expectation);
		});
	}
}
