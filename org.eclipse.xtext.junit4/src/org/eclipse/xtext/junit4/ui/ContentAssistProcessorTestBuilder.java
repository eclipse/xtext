/*******************************************************************************
 * Copyright (c) 2008, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension2;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.internal.LineDelimiters;
import org.eclipse.xtext.junit4.util.ResourceLoadHelper;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.IDirtyResource;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ReplacementTextApplier;
import org.eclipse.xtext.ui.editor.model.DocumentPartitioner;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Strings;
import org.junit.Assert;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Represents a builder for <code>IContentAssistProcessor</code> tests.
 *
 * @author Michael Clay - Initial contribution and API
 * @author Sven Efftinge
 * @author Sebastian Zarnekow
 * @deprecated Use org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder instead
 */
@Deprecated(forRemoval = true)
public class ContentAssistProcessorTestBuilder implements Cloneable {

	private String model;
	private String suffix;
	private int cursorPosition;
	private Injector injector;
	private boolean announceDirtyState;
	private final ResourceLoadHelper loadHelper;
	@Inject(optional = true)
	private IDirtyStateManager dirtyStateManager;
	private IDirtyResource dirtyResource;

	public static class Factory {
		private Injector injector;

		@Inject
	    public Factory(Injector injector) {
	    	this.injector = injector;
	    }

	    public ContentAssistProcessorTestBuilder create(ResourceLoadHelper resourceLoadHelper) throws Exception {
	    	return new ContentAssistProcessorTestBuilder(this.injector, resourceLoadHelper);
	    }
	}

	public ContentAssistProcessorTestBuilder(ISetup setupClazz, AbstractXtextTests tests) throws Exception {
		tests.with(setupClazz);
		injector = tests.getInjector();
		this.injector.injectMembers(this);
		this.loadHelper = tests;
	}
	
	public ContentAssistProcessorTestBuilder(Injector injector, ResourceLoadHelper helper) throws Exception {
		this.injector = injector;
		this.injector.injectMembers(this);
		this.loadHelper = helper;
	}

	public ContentAssistProcessorTestBuilder reset() throws Exception {
		return clone("",0);
	}

	public ContentAssistProcessorTestBuilder append(String model) throws Exception {
		return clone(getModel()+model, cursorPosition+model.length());
	}
	
	public ContentAssistProcessorTestBuilder appendSuffix(String suffix) throws Exception {
		return cloneWithSuffix(this.suffix==null?suffix:this.suffix+suffix);
	}

	public ContentAssistProcessorTestBuilder appendNl(String model) throws Exception {
		return append(model).append(Strings.newLine());
	}

	/**
	 * Inserts the given text at the current cursor position.
	 * The cursor position will be moved to the end of the inserted text.
	 */
	public ContentAssistProcessorTestBuilder insert(String model) throws Exception {
		return insert(model, getCursorPosition());
	}
	
	public ContentAssistProcessorTestBuilder insert(String model, int cursorPosition) throws Exception {
		StringBuilder builder = new StringBuilder(getModel()).insert(cursorPosition, model);
		return clone(builder.toString(), cursorPosition + model.length());
	}

	public ContentAssistProcessorTestBuilder cursorBack(int times) throws Exception {
		return clone(model, this.cursorPosition -= times);
	}
	
	public ContentAssistProcessorTestBuilder appendAndApplyProposal(String model) throws Exception {
		return appendAndApplyProposal(model, cursorPosition);
	}
	
	public ContentAssistProcessorTestBuilder appendAndApplyProposal(String model, String proposal) throws Exception {
		return appendAndApplyProposal(model, cursorPosition, proposal);
	}
	
	public ContentAssistProcessorTestBuilder appendAndApplyProposal(String model, int position) throws Exception {
		return appendAndApplyProposal(model, position, null);
	}
	
	public ContentAssistProcessorTestBuilder appendAndApplyProposal(String model, int position, String proposalString) throws Exception {
		IXtextDocument document = getDocument(getModel());
		Shell shell = new Shell();
		try {
			XtextSourceViewerConfiguration configuration = get(XtextSourceViewerConfiguration.class);
			ISourceViewer sourceViewer = getSourceViewer(shell, document, configuration);
			ICompletionProposal[] proposals = computeCompletionProposals(document, position, shell);
			ICompletionProposal proposal = findProposal(proposalString, proposals);
			return appendAndApplyProposal(proposal, sourceViewer, model, position);
		} finally {
			shell.dispose();
		}
	}

	protected ContentAssistProcessorTestBuilder appendAndApplyProposal(ICompletionProposal proposal, ISourceViewer sourceViewer, String model, int position)
			throws Exception {
		IDocument document = sourceViewer.getDocument();
		int offset = position;
		if (model != null) {
			document.set(getModel() + model);
			offset += model.length();
		}
		if (proposal instanceof ICompletionProposalExtension2) {
			ICompletionProposalExtension2 proposalExtension2 = (ICompletionProposalExtension2) proposal;
			proposalExtension2.apply(sourceViewer, (char) 0, SWT.NONE, offset);	
		} else if (proposal instanceof ICompletionProposalExtension) {
			ICompletionProposalExtension proposalExtension = (ICompletionProposalExtension) proposal;
			proposalExtension.apply(document, (char) 0, offset);	
		} else  {
			proposal.apply(document);
		}
		return reset().append(document.get());
	}
	
	public ContentAssistProcessorTestBuilder applyProposal() throws Exception {
		return applyProposal(cursorPosition);
	}
	
	public ContentAssistProcessorTestBuilder applyProposal(String proposal) throws Exception {
		return applyProposal(cursorPosition, proposal);
	}

	public ContentAssistProcessorTestBuilder applyProposal(int position) throws Exception {
		return applyProposal(position, null);
	}
	
	public ContentAssistProcessorTestBuilder applyProposal(int position, String proposalString) throws Exception {
		IXtextDocument document = getDocument(getModel());
		Shell shell = new Shell();
		try {
			ICompletionProposal[] proposals = computeCompletionProposals(document, position, shell);
			ICompletionProposal proposal = findProposal(proposalString, proposals);
			return applyProposal(proposal, position, document);
		} finally {
			shell.dispose();
		}
	}

	protected ICompletionProposal findProposal(String proposalString, ICompletionProposal[] proposals) {
		if (proposalString != null) {
			String platformDelimitedProposal = LineDelimiters.toPlatform(proposalString);
			for (ICompletionProposal candidate : proposals) {
				if (platformDelimitedProposal.equals(getProposedText(candidate))) {
					return candidate;
				}
			}
		}
		return proposals[0];
	}

	protected ContentAssistProcessorTestBuilder applyProposal(ICompletionProposal proposal) throws Exception {
		IXtextDocument document = getDocument(model);
		return applyProposal(proposal, document);
	}

	protected ContentAssistProcessorTestBuilder applyProposal(ICompletionProposal proposal, IXtextDocument document)
			throws Exception {
			return applyProposal(proposal, cursorPosition, document);
	}

	protected ContentAssistProcessorTestBuilder applyProposal(ICompletionProposal proposal, int position, IXtextDocument document)
			throws Exception {
		Shell shell = new Shell();
		try {
			XtextSourceViewerConfiguration configuration = get(XtextSourceViewerConfiguration.class);
			ISourceViewer sourceViewer = getSourceViewer(shell, document, configuration);
			return appendAndApplyProposal(proposal, sourceViewer, model, position);
		} finally {
			shell.dispose();
		}
	}

	public ContentAssistProcessorTestBuilder expectContent(String expectation){
		Assert.assertEquals(expectation, getModel());
		return this;
	}

	public ContentAssistProcessorTestBuilder assertCount(int completionProposalCount) throws Exception {
		return assertCountAtCursorPosition(completionProposalCount, this.cursorPosition);
	}

	public ContentAssistProcessorTestBuilder assertText(String... expectedText) throws Exception {
		return assertTextAtCursorPosition(this.cursorPosition, expectedText);
	}
	
	/**
	 * Asserts the presence of at least single the proposal with the given replacement string
	 * at the cursor position {@code <|>} in the currently configured {@link #model}.
	 */
	public ProposalTester assertProposalAtCursor(String expectedText) throws Exception {
		ICompletionProposal[] proposals = getProposalsAtCursorIndicator();
		for(ICompletionProposal proposal: proposals) {
			if (expectedText.equals(toString(proposal))) {
				return new ProposalTester(proposal);
			}
		}
		Assert.fail("No such proposal: " + expectedText + " Found: " + toString(proposals));
		return null;
	}
	
	/**
	 * Asserts the absence of a proposal with the given replacement string
	 * at the cursor position {@code <|>} in the currently configured {@link #model}.
	 * @since 2.8
	 */
	public void assertNoProposalAtCursor(String unexpectedText) throws Exception {
		ICompletionProposal[] proposals = getProposalsAtCursorIndicator();
		for(ICompletionProposal proposal: proposals) {
			if (unexpectedText.equals(toString(proposal))) {
				Assert.fail("Unexpected proposal: " + unexpectedText + " Found: " + toString(proposals));
			}
		}
	}

	/**
	 * Computes all proposals at the cursor position {@code <|>} in the currently configured {@link #model}.
	 */
	public ICompletionProposal[] getProposalsAtCursorIndicator() throws Exception {
		String currentModelToParse = getFullTextToBeParsed();
		int idx = currentModelToParse.indexOf("<|>");
		currentModelToParse = currentModelToParse.substring(0, idx) + currentModelToParse.substring(idx + 3);
		ICompletionProposal[] proposals = computeCompletionProposals(currentModelToParse, idx);

		if (proposals == null)
			proposals = new ICompletionProposal[0];
		return proposals;
	}
	
	/**
	 * Asserts the presence of at least single the proposal with the given display string
	 * at the cursor position {@code <|>} in the currently configured {@link #model}.
	 * 
	 * @see #assertProposalAtCursor(String)
	 */
	public ProposalTester assertProposalDisplayedAtCursor(String displayString) throws Exception {
		ICompletionProposal[] proposals = getProposalsAtCursorIndicator();
		for(ICompletionProposal proposal: proposals) {
			if (displayString.equals(proposal.getDisplayString())) {
				return new ProposalTester(proposal);
			}
		}
		Assert.fail("No such proposal: " + displayString + " Found: " + toDisplayString(proposals));
		return null;
	}
	
	/**
	 * Asserts the presence of at least single the proposal with the given replacement string
	 * at the cursor position {@link #cursorPosition} in the currently configured {@link #model}.
	 */
	public ProposalTester assertProposal(String expectedText) throws Exception {
		String currentModelToParse = getFullTextToBeParsed();

		ICompletionProposal[] proposals = computeCompletionProposals(currentModelToParse,
				cursorPosition);

		if (proposals == null)
			proposals = new ICompletionProposal[0];
		for(ICompletionProposal proposal: proposals) {
			if (expectedText.equals(toString(proposal))) {
				return new ProposalTester(proposal);
			}
		}
		Assert.fail("No such proposal: " + expectedText + " Found: " + toString(proposals));
		return null;
	}

	public ContentAssistProcessorTestBuilder assertTextAtCursorPosition(
			String cursorPosition, String... expectedText) throws Exception {
		return assertTextAtCursorPosition(getModel().indexOf(cursorPosition), expectedText);
	}
	
	public ContentAssistProcessorTestBuilder assertTextAtCursorPosition(
			String cursorPosition, int offset, String... expectedText) throws Exception {
		return assertTextAtCursorPosition(getModel().indexOf(cursorPosition) + offset, expectedText);
	}
	
	public ContentAssistProcessorTestBuilder assertTextAtCursorPosition(int cursorPosition, String... expectations)
			throws Exception {

		String currentModelToParse = getFullTextToBeParsed();

		ICompletionProposal[] computeCompletionProposals = computeCompletionProposals(currentModelToParse,
				cursorPosition);

		if (computeCompletionProposals == null)
			computeCompletionProposals = new ICompletionProposal[0];

		Arrays.sort(expectations);
		List<String> sortedExpectations = Lists.newArrayList();
		for (String expectation : expectations) {
			sortedExpectations.add(LineDelimiters.toPlatform(expectation));
		}
		final String expectation = Strings.concat(Strings.newLine(), sortedExpectations);
		final String actual = Strings.concat(Strings.newLine(), toString(computeCompletionProposals));
		
		Assert.assertEquals(expectation, actual);
		
		for (int i = 0; i < computeCompletionProposals.length; i++) {
			ICompletionProposal completionProposal = computeCompletionProposals[i];
			String proposedText = getProposedText(completionProposal);
			Assert.assertTrue("Missing proposal '" + proposedText + "'. Expect completionProposal text '" + expectation + "', but got " +
					actual,
					sortedExpectations.contains(proposedText));
		}

		return this;
	}

	protected String getProposedText(ICompletionProposal completionProposal) {
		String proposedText = completionProposal.getDisplayString();
		if (completionProposal instanceof ConfigurableCompletionProposal) {
			ConfigurableCompletionProposal configurableProposal = (ConfigurableCompletionProposal) completionProposal;
			proposedText = configurableProposal.getReplacementString();
			if (configurableProposal.getTextApplier() instanceof ReplacementTextApplier) {
				proposedText = ((ReplacementTextApplier) configurableProposal.getTextApplier()).getActualReplacementString(configurableProposal);
			}
		}
		return proposedText;
	}
	
	public ContentAssistProcessorTestBuilder assertMatchString(String matchString)
			throws Exception {
		String currentModelToParse = getModel();
		final XtextResource xtextResource = loadHelper.getResourceFor(new StringInputStream(currentModelToParse));
		final IXtextDocument xtextDocument = getDocument(xtextResource, currentModelToParse);
		XtextSourceViewerConfiguration configuration = get(XtextSourceViewerConfiguration.class);
		Shell shell = new Shell();
		try {
			ISourceViewer sourceViewer = getSourceViewer(shell, xtextDocument, configuration);
			IContentAssistant contentAssistant = configuration.getContentAssistant(sourceViewer);
			String contentType = xtextDocument.getContentType(currentModelToParse.length());
			if (contentAssistant.getContentAssistProcessor(contentType) != null) {
				ContentAssistContext.Factory factory = get(ContentAssistContext.Factory.class);
				ContentAssistContext[] contexts = factory.create(sourceViewer, currentModelToParse.length(), xtextResource);
				for(ContentAssistContext context: contexts) {
					Assert.assertTrue("matchString = '" + matchString + "', actual: '" + context.getPrefix() + "'",
							"".equals(context.getPrefix()) || matchString.equals(context.getPrefix()));
				}
			} else {
				Assert.fail("No content assistant for content type " + contentType);
			}
			return this;
		} finally {
			shell.dispose();
		}
	}

	public ContentAssistProcessorTestBuilder assertCursorIsAfter(String text) {
		Assert.assertTrue("cursor should be after '" + text + "' but it's after " + model.substring(0, getCursorPosition()), 
				model.substring(getCursorPosition() - text.length()).startsWith(text));
		return this;
	}
	
	public ContentAssistProcessorTestBuilder assertCursorIsBefore(String text) {
		Assert.assertTrue("cursor should be before '" + text + "' but it's before " + model.substring(getCursorPosition()), 
				model.substring(getCursorPosition()).startsWith(text));
		return this;
	}
	
	protected String getModel() {
		return this.model == null ? "":model;
	}
	
	protected String getFullTextToBeParsed() {
		return getModel()+(this.suffix== null ? "":suffix);
	}

	public List<String> toDisplayString(ICompletionProposal[] proposals) {
		if (proposals == null)
			return Collections.emptyList();
		List<String> res = new ArrayList<String>(proposals.length);
		for (ICompletionProposal proposal : proposals) {
			String proposedText = proposal.getDisplayString();
			res.add(proposedText);
		}
		Collections.sort(res);
		return res;
	}
	
	public List<String> toString(ICompletionProposal[] proposals) {
		if (proposals == null)
			return Collections.emptyList();
		List<String> res = new ArrayList<String>(proposals.length);
		for (ICompletionProposal proposal : proposals) {
			String proposedText = toString(proposal);
			res.add(proposedText);
		}
		Collections.sort(res);
		return res;
	}

	protected String toString(ICompletionProposal proposal) {
		return getProposedText(proposal);
	}

	public ContentAssistProcessorTestBuilder assertCountAtCursorPosition(int completionProposalCount, int cursorPosition)
			throws Exception {

		String currentModelToParse = getFullTextToBeParsed();

		ICompletionProposal[] computeCompletionProposals = computeCompletionProposals(currentModelToParse,
				cursorPosition);

		StringBuffer computedProposals = new StringBuffer();
		for (int i = 0; i < computeCompletionProposals.length; i++) {
			computedProposals.append(computeCompletionProposals[i].getDisplayString());
			if (i<(computeCompletionProposals.length-1)) {
				computedProposals.append(",");
			}
		}
		Assert.assertEquals("expect only " + completionProposalCount + " CompletionProposal item for model '"
				+ currentModelToParse + "' but got '"+computedProposals+"'", completionProposalCount, computeCompletionProposals.length);

		return this;
	}

	public ICompletionProposal[] computeCompletionProposals(final String currentModelToParse, int cursorPosition)
			throws Exception {
		try {
			final IXtextDocument xtextDocument = getDocument(currentModelToParse);
			return computeCompletionProposals(xtextDocument, cursorPosition);
		} finally {
			if (announceDirtyState) {
				dirtyStateManager.discardDirtyState(dirtyResource);
			}
		}
	}

	protected ICompletionProposal[] computeCompletionProposals(final IXtextDocument xtextDocument, int cursorPosition)
			throws BadLocationException {
		Shell shell = new Shell();
		try {
			return computeCompletionProposals(xtextDocument, cursorPosition, shell);
		} finally {
			shell.dispose();
		}
	}

	protected ICompletionProposal[] computeCompletionProposals(final IXtextDocument xtextDocument, int cursorPosition,
			Shell shell) throws BadLocationException {
		XtextSourceViewerConfiguration configuration = get(XtextSourceViewerConfiguration.class);
		ISourceViewer sourceViewer = getSourceViewer(shell, xtextDocument, configuration);
		return computeCompletionProposals(xtextDocument, cursorPosition, configuration, sourceViewer);
	}

	protected ICompletionProposal[] computeCompletionProposals(final IXtextDocument xtextDocument, int cursorPosition,
			XtextSourceViewerConfiguration configuration, ISourceViewer sourceViewer) throws BadLocationException {
		IContentAssistant contentAssistant = configuration.getContentAssistant(sourceViewer);
		String contentType = xtextDocument.getContentType(cursorPosition);
		IContentAssistProcessor processor = contentAssistant.getContentAssistProcessor(contentType);
		if (processor != null) {
			return processor.computeCompletionProposals(sourceViewer, cursorPosition);
		}
		return new ICompletionProposal[0];
	}
	
	public ContentAssistProcessorTestBuilder withDirtyState() throws Exception {
		ContentAssistProcessorTestBuilder result = clone(model, cursorPosition);
		result.announceDirtyState = true;
		return result;
	}

	protected IXtextDocument getDocument(final String currentModelToParse) {
		final XtextResource xtextResource = loadHelper.getResourceFor(new StringInputStream(Strings.emptyIfNull(currentModelToParse)));
		if (announceDirtyState) {
			dirtyResource = new IDirtyResource() {
				@Override
				public String getContents() {
					return currentModelToParse;
				}

				@Override
				public String getActualContents() {
					return currentModelToParse;
				}

				@Override
				public IResourceDescription getDescription() {
					return xtextResource.getResourceServiceProvider().getResourceDescriptionManager().getResourceDescription(xtextResource);
				}

				@Override
				public URI getURI() {
					return xtextResource.getURI();
				}
			};
			dirtyStateManager.manageDirtyState(dirtyResource);
		}
		return getDocument(xtextResource, currentModelToParse);
	}

	protected ISourceViewer getSourceViewer(Shell shell, final IXtextDocument xtextDocument,
			XtextSourceViewerConfiguration configuration) {
		XtextSourceViewer.Factory factory = get(XtextSourceViewer.Factory.class);
		ISourceViewer sourceViewer = factory.createSourceViewer(shell, null, null, false, 0);
		sourceViewer.configure(configuration);
		sourceViewer.setDocument(xtextDocument);
		return sourceViewer;
	}

	public ICompletionProposal[] computeCompletionProposals(int cursorPosition) throws Exception {
		return computeCompletionProposals(getFullTextToBeParsed(), cursorPosition);
	}
	
	public ICompletionProposal[] computeCompletionProposals(String cursorPosition) throws Exception {
		return computeCompletionProposals(getFullTextToBeParsed(), getModel().indexOf(cursorPosition));
	}
	
	public ICompletionProposal[] computeCompletionProposals() throws Exception {
		return computeCompletionProposals(getFullTextToBeParsed(), cursorPosition);
	}

	@Override
	public String toString() {
		return getModel() + "\n length: " + getModel().length() + "\n cursor at: "
				+ this.cursorPosition;
	}

	public IXtextDocument getDocument(final XtextResource xtextResource, final String model) {
		XtextDocument document = get(XtextDocument.class);
		document.set(model);
		document.setInput(xtextResource);
		DocumentPartitioner partitioner = get(DocumentPartitioner.class);
		partitioner.connect(document);
		document.setDocumentPartitioner(partitioner);
		return document;
	}

	public ITextViewer getSourceViewer(final String currentModelToParse, final IXtextDocument xtextDocument) {
		ITextViewer result = new MockableTextViewer() {
			@Override
			public IDocument getDocument() {
				return xtextDocument;
			}
			
			@Override
			public ISelectionProvider getSelectionProvider() {
				return new MockableSelectionProvider() {
					@Override
					public ISelection getSelection() {
						return TextSelection.emptySelection();
					}
				};
			}
			
			@Override
			public StyledText getTextWidget() {
				return null;
			}
		};
		return result;
	}

	protected ContentAssistProcessorTestBuilder clone(String model, int offset) throws Exception {
		ContentAssistProcessorTestBuilder builder = (ContentAssistProcessorTestBuilder) clone();
		builder.model = model;
		builder.cursorPosition = offset;
		builder.suffix = this.suffix;
		builder.announceDirtyState = announceDirtyState;
		return builder;
	}
	
	protected ContentAssistProcessorTestBuilder cloneWithSuffix(String postFix) throws Exception {
		ContentAssistProcessorTestBuilder builder = (ContentAssistProcessorTestBuilder) clone();
		builder.model = this.model;
		builder.cursorPosition = this.cursorPosition;
		builder.suffix = postFix;
		builder.announceDirtyState = announceDirtyState;
		return builder;
	}

	public <T> T get(Class<T> clazz) {
		return injector.getInstance(clazz);
	}

	protected int getCursorPosition() {
		return cursorPosition;
	}
	
	public class ProposalTester {
		
		private ICompletionProposal proposal;

		protected ProposalTester(ICompletionProposal proposal) {
			this.proposal = proposal;
		}
		
		public ProposalTester withDisplayString(String displayString) {
			Assert.assertEquals("displayString", displayString, proposal.getDisplayString());
			return this;
		}
		
		public ContentAssistProcessorTestBuilder apply() throws Exception {
			return ContentAssistProcessorTestBuilder.this.applyProposal(proposal);
		}
		
	}
}
