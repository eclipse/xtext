/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ui.testing.util.LineDelimiters;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ReplacementTextApplier;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * see https://github.com/eclipse/xtext-eclipse/issues/28
 *
 * @author Stephane Galland - Initial contribution and API
 * @since 2.11
 */
public class EclipseBug28DirtyStateModifierContentAssistTest extends AbstractXtendContentAssistBugTest {

	@Test public void testDirtyStateModifiers_01() throws Exception {
		final ContentAssistProcessorTestBuilder builder = newBuilder().withDirtyState()
				.appendNl("final class FooA1 {}")
				.appendNl("class FooA2 {}")
				.append("class FooA3 extends FooA")
				.assertText("FooA2", "FooA3");
		assertNoText(builder, "FooA1");
	}

	@Test public void testDirtyStateModifiers_02() throws Exception {
		newBuilder().withDirtyState()
				.appendNl("class FooA1 {}")
				.appendNl("class FooA2 {}")
				.append("class FooA3 extends FooA")
				.assertText("FooA1", "FooA2", "FooA3");
	}

	/**
	 * Assert that all the given texts are not in the proposal.
	 *
	 * TODO: Move this function into {@link ContentAssistProcessorTestBuilder}.
	 *
	 * @param builder the proposal builder.
	 * @param notExpectations the texts to not be proposed.
	 * @return the builder.
	 * @throws Exception
	 * @since 2.11
	 */
	protected static ContentAssistProcessorTestBuilder assertNoText(ContentAssistProcessorTestBuilder builder,
			String... notExpectations) throws Exception {
		ICompletionProposal[] computeCompletionProposals = builder.computeCompletionProposals();

		if (computeCompletionProposals == null) {
			computeCompletionProposals = new ICompletionProposal[0];
		}

		Arrays.sort(notExpectations);
		List<String> sortedNotExpectations = Lists.newArrayList();
		for (String expectation : notExpectations) {
			sortedNotExpectations.add(LineDelimiters.toPlatform(expectation));
		}

		for (final ICompletionProposal completionProposal : computeCompletionProposals) {
			String proposedText = getProposedText(completionProposal);
			Assert.assertFalse("Unexpected proposal '" + proposedText + "'",
					sortedNotExpectations.contains(proposedText));
		}

		return builder;
	}

	private static String getProposedText(ICompletionProposal completionProposal) {
		String proposedText = completionProposal.getDisplayString();
		if (completionProposal instanceof ConfigurableCompletionProposal) {
			ConfigurableCompletionProposal configurableProposal = (ConfigurableCompletionProposal) completionProposal;
			proposedText = configurableProposal.getReplacementString();
			if (configurableProposal.getTextApplier() instanceof ReplacementTextApplier) {
				proposedText = ((ReplacementTextApplier) configurableProposal.getTextApplier())
						.getActualReplacementString(configurableProposal);
			}
		}
		return proposedText;
	}

}