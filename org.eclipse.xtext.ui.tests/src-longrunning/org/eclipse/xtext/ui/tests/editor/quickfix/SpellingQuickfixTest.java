/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.quickfix;

import static com.google.common.collect.Iterables.*;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.quickassist.QuickAssistAssistant;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.jface.text.source.TextInvocationContext;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.reconciler.XtextReconciler;
import org.eclipse.xtext.ui.testing.AbstractMultiQuickfixTest;
import org.eclipse.xtext.ui.tests.quickfix.ui.tests.QuickfixCrossrefTestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Predicate;

/**
 * @author Michael Clay - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(QuickfixCrossrefTestLanguageUiInjectorProvider.class)
public class SpellingQuickfixTest extends AbstractMultiQuickfixTest {

	private static final String MODEL_WITH_SPELLING_QUICKFIX_IN_SL_COLMMENT = "Foo {  } \n // Single Line Komment Spelling Error";
	private static final String MODEL_WITH_SPELLING_QUICKFIX_IN_ML_COLMMENT = "Foo {  } \n /* Multi Line \n Komment Spelling Error */";
	private static final String MODEL_WITH_SPELLING_QUICKFIX_IN_STRINGS = "'String Speling Error' Foo {  } \n";

	private XtextEditor xtextEditor;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		IFile dslFile = dslFile(MODEL_WITH_SPELLING_QUICKFIX_IN_SL_COLMMENT);
		xtextEditor = openEditor(dslFile);
	}

	@Test
	public void testSpellingQuickfixInSlComment() throws Exception {
		ICompletionProposal[] quickAssistProposals = computeQuickAssistProposals(getDocument().getLength());
		List<ICompletionProposal> proposals = Arrays.asList(quickAssistProposals);
		assertSpellingQuickfixProposals(proposals);
	}

	@Test
	public void testSpellingQuickfixInMlComment() throws Exception {
		xtextEditor.getDocument().set(MODEL_WITH_SPELLING_QUICKFIX_IN_ML_COLMMENT);
		ICompletionProposal[] quickAssistProposals = computeQuickAssistProposals(getDocument().getLength());
		List<ICompletionProposal> proposals = Arrays.asList(quickAssistProposals);
		assertSpellingQuickfixProposals(proposals);
	}

	@Test
	public void testSpellingQuickfixInString() throws Exception {
		xtextEditor.getDocument().set(MODEL_WITH_SPELLING_QUICKFIX_IN_STRINGS);
		ICompletionProposal[] quickAssistProposals = computeQuickAssistProposals(0);
		List<ICompletionProposal> proposals = Arrays.asList(quickAssistProposals);
		assertSpellingQuickfixProposals(proposals);
	}
	
	protected void assertSpellingQuickfixProposals(List<ICompletionProposal> proposals) {
		assertEquals(4, proposals.size());
		assertEquals(1, size(filter(proposals, classNameEquals("AddWordProposal"))));
		assertEquals(1, size(filter(proposals, classNameEquals("WordCorrectionProposal"))));
		assertEquals(1, size(filter(proposals, classNameEquals("DisableSpellCheckingProposal"))));
		assertEquals(1, size(filter(proposals, classNameEquals("WordIgnoreProposal"))));
	}

	protected ICompletionProposal[] computeQuickAssistProposals(int offset) {
		XtextSourceViewer sourceViewer = getSourceViewer();
		XtextReconciler reconciler = (XtextReconciler) sourceViewer.getAdapter(IReconciler.class);
		IReconcilingStrategyExtension reconcilingStrategyExtension = (IReconcilingStrategyExtension) reconciler.getReconcilingStrategy("");
		reconcilingStrategyExtension.initialReconcile();
		QuickAssistAssistant quickAssistAssistant = (QuickAssistAssistant) sourceViewer.getQuickAssistAssistant();
		IQuickAssistProcessor quickAssistProcessor = quickAssistAssistant.getQuickAssistProcessor();
		ICompletionProposal[] quickAssistProposals = quickAssistProcessor
				.computeQuickAssistProposals(new TextInvocationContext(sourceViewer, offset, -1));
		return quickAssistProposals;
	}

	protected IDocument getDocument() {
		return getSourceViewer().getDocument();
	}

	protected XtextSourceViewer getSourceViewer() {
		XtextSourceViewer sourceViewer = (XtextSourceViewer) xtextEditor.getInternalSourceViewer();
		return sourceViewer;
	}

	public Predicate<ICompletionProposal> classNameEquals(final String simpleName) {
		return new Predicate<ICompletionProposal>() {
			@Override
			public boolean apply(ICompletionProposal input) {
				return input.getClass().getSimpleName().equals(simpleName);
			}
		};
	}

}