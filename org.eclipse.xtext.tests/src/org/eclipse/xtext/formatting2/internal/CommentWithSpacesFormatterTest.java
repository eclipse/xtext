/*******************************************************************************
 * Copyright (c) 2017, 2022 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.IAutowrapFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList;
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
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
public class CommentWithSpacesFormatterTest {
	public static class CustomFormatter extends GenericFormatter<IDList> {
		@Override
		public void format(IDList model, ITextRegionExtensions regionAccess, IFormattableDocument document) {
			document.append(textRegionExtensions.regionFor(model).keyword("idlist"), (IHiddenRegionFormatter it) -> {
				it.oneSpace();
			});
			document.append(textRegionExtensions.regionFor(model).keyword("idlist"), (IHiddenRegionFormatter it) -> {
				it.setNewLines(0);
				it.highPriority();
			});
			document.append(textRegionExtensions.regionFor(model).keyword("idlist").getNextSemanticRegion(),
					(IHiddenRegionFormatter it) -> {
						it.setNewLines(0, 1, 2);
					});
		}
	}

	public static class TabsAndSpacesSupportingFormatter extends CustomFormatter {
		@Override
		public ITextReplacer createWhitespaceReplacer(ITextSegment hiddens, IHiddenRegionFormatting formatting) {
			return new TabAndSpacesSupportingWhiteSpaceReplacer(hiddens, formatting);
		}
	}

	private static class TabAndSpacesSupportingWhiteSpaceReplacer extends WhitespaceReplacer {
		public TabAndSpacesSupportingWhiteSpaceReplacer(ITextSegment whitespace, IHiddenRegionFormatting formatting) {
			super(whitespace, formatting);
		}

		/**
		 * Copied from {@link WhitespaceReplacer}
		 */
		@Override
		public ITextReplacerContext createReplacements(ITextReplacerContext context) {
			if (getFormatting().getAutowrap() != null && getFormatting().getAutowrap().intValue() >= 0) {
				context.setCanAutowrap(getFormatting().getAutowrap());
			}
			String space = getFormatting().getSpace();
			int trailingNewLinesOfPreviousRegion = trailingNewLinesOfPreviousRegion();
			int computedNewLineCount = computeNewLineCount(context);
			int newLineCount = Math.max(computedNewLineCount- trailingNewLinesOfPreviousRegion, 0);
			if (newLineCount == 0 && context.isAutowrap()) {
				IAutowrapFormatter onAutowrap = getFormatting().getOnAutowrap();
				if (onAutowrap != null) {
					onAutowrap.format(getRegion(), getFormatting(), context.getDocument());
				}
				newLineCount = 1;
			}
			int indentationCount = computeNewIndentation(context);
			if (newLineCount == 0 && trailingNewLinesOfPreviousRegion == 0) {
				if (space != null) {
					context.addReplacement(getRegion().replaceWith(space));
				}
			} else {
				boolean noIndentation = Boolean.TRUE.equals(getFormatting().getNoIndentation());
				String newLines = context.getNewLinesString(newLineCount);
				String indentation = null;
				if (noIndentation) {
					indentation = "";
				} else {
					indentation = context.getIndentationString(indentationCount);
				}
				// START CHANGE
				// Added "+ space" on the next line
				boolean addSpace = trailingNewLinesOfPreviousRegion == 0 && space != null;
				context.addReplacement(getRegion().replaceWith(newLines+ indentation + (addSpace ? space : "")));
				// END CHANGE
			}
			return context.withIndentation(indentationCount);
		}
	}

	@Inject
	private GenericFormatterTester genericFormatterTester;

	@Test
	public void SL_inline() {
		String input =
				"idlist  //x\n" +
				"a\n";
		String output =
				"idlist //x\n" +
				"a\n";
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new TabsAndSpacesSupportingFormatter());
			// Space before comment because of `oneSpace` no space after because
			// `addSpace` is false because there is a
			// trailing new lines
			it.setExpectation(output);
		});
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new CustomFormatter());
			it.setExpectation(output);
		});
	}

	@Test
	public void SL_multiline() {
		String input =
				"idlist\n" +
				"\n" +
				"//x\n" +
				"\n" +
				"\n" +
				"a\n";
		String output =
				"idlist //x\n" +
				"a\n";
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new TabsAndSpacesSupportingFormatter());
			// Space before comment because of `oneSpace` and `addSpace` is
			// false because `space == null`
			it.setExpectation(output);
		});
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new CustomFormatter());
			it.setExpectation(output);
		});
	}

	@Test
	public void MLSL_inline() {
		String input = "idlist  /*x*/  a\n";
		String output = "idlist /*x*/ a\n";
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new TabsAndSpacesSupportingFormatter());
			// The spaces around here are from the `oneSpace` being propagated
			// in MultilineCommentReplacer.configureWhitespace()
			it.setExpectation(output);
		});
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new CustomFormatter());
			it.setExpectation(output);
		});
	}

	@Test
	public void MLSLOnSecondLine() {
		String input =
				"idlist a\n" +
				"/*x*/\n";
		String output =
				"idlist a\n" +
				"/*x*/\n";
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new TabsAndSpacesSupportingFormatter());
			it.setExpectation(output);
		});
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new CustomFormatter());
			it.setExpectation(output);
		});
	}

	@Test
	public void MLSL_paragraph() {
		String input =
				"idlist\n" +
				"\n" +
				"\n" +
				"/*x*/\n" +
				"\n" +
				"\n" +
				"a\n";
		String output =
				"idlist /*x*/\n" +
				"a\n";
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new TabsAndSpacesSupportingFormatter());
			// Space before comment because of `oneSpace` and `addSpace` is
			// false because `space == null`
			it.setExpectation(output);
		});
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new CustomFormatter());
			it.setExpectation(output);
		});
	}

	@Test
	public void MLML_inline() {
		String input =
				"idlist  /*\n" +
				"x\n" +
				"*/  a\n";
		String output =
				"idlist\n" +
				"/*\n" +
				" * x\n" +
				" */ a\n";
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new TabsAndSpacesSupportingFormatter());
			it.setExpectation(output);
		});
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new CustomFormatter());
			it.setExpectation(output);
		});
	}

	@Test
	public void MLML_paragraph() {
		String input =
				"idlist\n" +
				"\n" +
				"\n" +
				"/*\n" +
				"x\n" +
				"*/\n" +
				"\n" +
				"\n" +
				"a\n" +
				"b\n";
		String output =
				"idlist /*\n" +
				" * x\n" +
				" */\n" +
				"a\n" +
				"b\n";
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new TabsAndSpacesSupportingFormatter());
			// Follows the regular path
			it.setExpectation(output);
		});
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new CustomFormatter());
			it.setExpectation(output);
		});
	}

	@Test
	public void MLOverOneLineSLML() {
		String input =
				"idlist  /* i\n" +
				"j *//*y*/  a\n";
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new TabsAndSpacesSupportingFormatter());
			String expectation =
					"idlist\n" +
					"/* i\n" +
					" j */\n" +
					" /*y*/ a\n";
			it.setExpectation(expectation);
		});
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new CustomFormatter());
			String expectation =
					"idlist\n" +
					"/* i\n" +
					" j */\n" +
					"/*y*/ a\n";
			it.setExpectation(expectation);
		});
	}

	@Test
	public void MLOverOneLineMLOverOneLine() {
		String input =
				"idlist  /* i\n" +
				"j *//*x\n" +
				"               y*/  a\n";
		String output =
				"idlist\n" +
				"/* i\n" +
				" j */\n" +
				"/*x\n" +
				" y*/ a\n";
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new TabsAndSpacesSupportingFormatter());
			it.setExpectation(output);
		});
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new CustomFormatter());
			it.setExpectation(output);
		});
	}

	@Test
	public void SLMLMLOverOneLine() {
		String input =
				"idlist  /* n *//*x\n" +
				"               y*/  a\n";
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new TabsAndSpacesSupportingFormatter());
			String expectation =
					"idlist /* n */\n" +
					" /*x\n" +
					" y*/ a\n";
			it.setExpectation(expectation);
		});
		genericFormatterTester.assertFormatted((GenericFormatterTestRequest it) -> {
			it.setToBeFormatted(input);
			it.setFormatter(new CustomFormatter());
			String expectation =
					"idlist /* n */\n" +
					"/*x\n" +
					" y*/ a\n";
			it.setExpectation(expectation);
		});
	}
}
