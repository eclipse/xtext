/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting
import org.eclipse.xtext.formatting2.ITextReplacer
import org.eclipse.xtext.formatting2.ITextReplacerContext
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(FormatterTestLanguageInjectorProvider)
class CommentWithSpacesFormatterTest {

	@Inject extension GenericFormatterTester

	static class CustomFormatter extends GenericFormatter<IDList> {
		override format(IDList model, ITextRegionExtensions regionAccess, extension IFormattableDocument document) {
			model.regionFor.keyword("idlist").append[oneSpace].append[newLines = 0 highPriority]
			model.regionFor.keyword("idlist").nextSemanticRegion.append[setNewLines(0,1,2)]
		}
	}

	static class TabsAndSpacesSupportingFormatter extends CustomFormatter {
		override ITextReplacer createWhitespaceReplacer(ITextSegment hiddens, IHiddenRegionFormatting formatting) {
			return new TabAndSpacesSupportingWhiteSpaceReplacer(hiddens, formatting);
		}
	}

	@Test
	def void SL_inline() {
		val input = '''
			idlist  //x
			a
		'''

		val output = '''
			idlist //x
			a
		'''

		assertFormatted[
			toBeFormatted = input
			formatter = new TabsAndSpacesSupportingFormatter()
			// Space before comment because of `oneSpace` no space after because `addSpace` is false because there is a
			// trailing new lines
			expectation = output
		]

		assertFormatted[
			toBeFormatted = input
			formatter = new CustomFormatter()
			expectation = output
		]
	}

	@Test
	def void SL_multiline() {
		val input = '''
			idlist

			//x


			a
		'''

		val output = '''
			idlist //x
			a
		'''

		assertFormatted[
			toBeFormatted = input
			formatter = new TabsAndSpacesSupportingFormatter()
			// Space before comment because of `oneSpace` and `addSpace` is false because `space == null`
			expectation = output
		]

		assertFormatted[
			toBeFormatted = input
			formatter = new CustomFormatter()
			expectation = output
		]
	}

	@Test
	def void MLSL_inline() {
		val input = '''
			idlist  /*x*/  a
		'''

		val output = '''
			idlist /*x*/ a
		'''

		assertFormatted[
			toBeFormatted = input
			formatter = new TabsAndSpacesSupportingFormatter()
			// The spaces around here are from the `oneSpace` being propagated
			// in MultilineCommentReplacer.configureWhitespace()
			expectation = output
		]

		assertFormatted[
			toBeFormatted = input
			formatter = new CustomFormatter()
			expectation = output
		]
	}

	@Test
	def void MLSLOnSecondLine() {
		val input = '''
			idlist a
			/*x*/
		'''

		val output = '''
			idlist a
			/*x*/
		'''

		assertFormatted[
			toBeFormatted = input
			formatter = new TabsAndSpacesSupportingFormatter()
			expectation = output
		]

		assertFormatted[
			toBeFormatted = input
			formatter = new CustomFormatter()
			expectation = output
		]
	}

	@Test
	def void MLSL_paragraph() {
		val input = '''
			idlist


			/*x*/


			a
		'''

		val output = '''
			idlist /*x*/
			a
		'''

		assertFormatted[
			toBeFormatted = input
			formatter = new TabsAndSpacesSupportingFormatter()
			// Space before comment because of `oneSpace` and `addSpace` is false because `space == null`
			expectation = output
		]

		assertFormatted[
			toBeFormatted = input
			formatter = new CustomFormatter()
			expectation = output
		]
	}

	@Test
	def void MLML_inline() {
		val input = '''
			idlist  /*
			x
			*/  a
		'''

		val output = '''
			idlist
			/*
			 * x
			 */ a
		'''

		assertFormatted[
			toBeFormatted = input
			formatter = new TabsAndSpacesSupportingFormatter()
			// Follows the regular path
			expectation = output
		]

		assertFormatted[
			toBeFormatted = input
			formatter = new CustomFormatter()
			expectation = output
		]
	}

	@Test
	def void MLML_paragraph() {
		val input = '''
			idlist


			/*
			x
			*/


			a
			b
		'''

		val output = '''
			idlist /*
			 * x
			 */
			a
			b
		'''

		assertFormatted[
			toBeFormatted = input
			formatter = new TabsAndSpacesSupportingFormatter()
			// Follows the regular path
			expectation = output
		]

		assertFormatted[
			toBeFormatted = input
			formatter = new CustomFormatter()
			expectation = output
		]
	}

	@Test
	def void MLOverOneLineSLML() {
		val input = '''
			idlist  /* i
			j *//*y*/  a
		'''
		assertFormatted[
			toBeFormatted = input
			formatter = new TabsAndSpacesSupportingFormatter()
			expectation = '''
				idlist
				/* i
				 j */
				 /*y*/ a
			'''
		]

		assertFormatted[
			toBeFormatted = input
			formatter = new CustomFormatter()
			expectation = '''
				idlist
				/* i
				 j */
				/*y*/ a
			'''
		]
	}

	@Test
	def void MLOverOneLineMLOverOneLine() {
		val input = '''
			idlist  /* i
			j *//*x
			               y*/  a
		'''

		val output = '''
			idlist
			/* i
			 j */
			/*x
			 y*/ a
		'''

		assertFormatted[
			toBeFormatted = input
			formatter = new TabsAndSpacesSupportingFormatter()
			expectation = output
		]

		assertFormatted[
			toBeFormatted = input
			formatter = new CustomFormatter()
			expectation = output
		]
	}

	@Test
	def void SLMLMLOverOneLine() {
		val input = '''
			idlist  /* n *//*x
			               y*/  a
		'''
		assertFormatted[
			toBeFormatted = input
			formatter = new TabsAndSpacesSupportingFormatter()
			expectation = '''
				idlist /* n */
				 /*x
				 y*/ a
			'''
		]

		assertFormatted[
			toBeFormatted = input
			formatter = new CustomFormatter()
			expectation = '''
				idlist /* n */
				/*x
				 y*/ a
			'''
		]
	}

	private static class TabAndSpacesSupportingWhiteSpaceReplacer extends WhitespaceReplacer {

		new(ITextSegment whitespace, IHiddenRegionFormatting formatting) {
			super(whitespace, formatting)
		}

		/**
		 * Copied from {@link WhitespaceReplacer}
		 */
		override ITextReplacerContext createReplacements(ITextReplacerContext context) {
			if (formatting.getAutowrap() !== null && formatting.getAutowrap() >= 0)
				context.setCanAutowrap(formatting.getAutowrap());
			val space = formatting.getSpace();
			val trailingNewLinesOfPreviousRegion = trailingNewLinesOfPreviousRegion();
			val computedNewLineCount = computeNewLineCount(context);
			var newLineCount = Math.max(computedNewLineCount - trailingNewLinesOfPreviousRegion, 0);

			if (newLineCount == 0 && context.isAutowrap()) {
				val onAutowrap = formatting.getOnAutowrap();
				if (onAutowrap !== null) {
					onAutowrap.format(region, formatting, context.getDocument());
				}
				newLineCount = 1;
			}
			val indentationCount = computeNewIndentation(context);
			if (newLineCount == 0 && trailingNewLinesOfPreviousRegion == 0) {
				if (space !== null)
					context.addReplacement(region.replaceWith(space));
			} else {
				val noIndentation = formatting.getNoIndentation() == Boolean.TRUE;
				val newLines = context.getNewLinesString(newLineCount);
				val indentation = if(noIndentation) "" else context.getIndentationString(indentationCount);
				// START CHANGE
				// Added "+ space" on the next line
				val addSpace = trailingNewLinesOfPreviousRegion == 0 && space !== null
				context.addReplacement(region.replaceWith(newLines + indentation + (addSpace ? space : "")));
				// END CHANGE
			}
			return context.withIndentation(indentationCount)
		}
	}
}
