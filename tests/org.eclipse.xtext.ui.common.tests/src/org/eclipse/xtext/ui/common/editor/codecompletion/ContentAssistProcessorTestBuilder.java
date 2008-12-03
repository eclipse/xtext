/*******************************************************************************
 * __  ___            _   
 * \ \/ / |_ _____  __ |_
 *  \  /| __/ _ \ \/ / __|
 *  /  \| |_  __/>  <| |_
 * /_/\_\\__\___/_/\_\\__|
 * 
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.codecompletion;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Strings;

/**
 * Represents a builder for <code>IContentAssistProcessor</code> tests.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class ContentAssistProcessorTestBuilder {

	private IContentAssistProcessor contentAssistProcessor;
	private ITextViewer textViewerMock;
	private IXtextDocument xtextDocumentMock;
	private IServiceScope serviceScope;
	private StringBuilder modelBuilder = new StringBuilder("");
	private int cursorPosition;

	public ContentAssistProcessorTestBuilder(IServiceScope serviceScope, IContentAssistProcessor contentAssistProcessor) {
		this.contentAssistProcessor = contentAssistProcessor;
		this.textViewerMock = createMock(ITextViewer.class);
		this.xtextDocumentMock = createMock(IXtextDocument.class);
		this.serviceScope = serviceScope;
		ServiceRegistry.injectServices(serviceScope, this.contentAssistProcessor);
	}

	public ContentAssistProcessorTestBuilder set(String model) {
		this.modelBuilder = new StringBuilder(model);
		this.cursorPosition = model.length();
		return this;
	}

	public ContentAssistProcessorTestBuilder clear(String model) {
		this.modelBuilder = new StringBuilder("");
		this.cursorPosition = 0;
		return this;
	}

	public ContentAssistProcessorTestBuilder append(String model) {
		this.modelBuilder.append(model);
		this.cursorPosition += model.length();
		return this;
	}
	
	public ContentAssistProcessorTestBuilder appendNl(String model) {
		return append(model).append(Strings.newLine());
	}

	public ContentAssistProcessorTestBuilder insert(String model, int cursorPosition) {
		this.modelBuilder.insert(cursorPosition, model);
		this.cursorPosition = cursorPosition + model.length();
		return this;
	}

	public ContentAssistProcessorTestBuilder delete(int times) {
		this.modelBuilder.delete(this.cursorPosition - times, this.cursorPosition);
		this.cursorPosition = this.modelBuilder.length();
		return this;
	}

	public ContentAssistProcessorTestBuilder cursorBack(int times) {
		this.cursorPosition -= times;
		return this;
	}

	public ContentAssistProcessorTestBuilder applyText() throws Exception {
		applyText(0, true);
		return this;
	}

	public ContentAssistProcessorTestBuilder applyText(boolean appendSpace) throws Exception {
		applyText(0, appendSpace);
		return this;
	}

	public ContentAssistProcessorTestBuilder applyText(int index, boolean appendSpace) throws Exception {
		append(computeCompletionProposals(this.modelBuilder.toString(), this.cursorPosition)[index].getDisplayString());
		if (appendSpace) {
			append(" ");
		}
		return this;
	}

	public ContentAssistProcessorTestBuilder assertCount(int completionProposalCount) throws Exception {
		assertCountAtCursorPosition(completionProposalCount, this.cursorPosition);
		return this;
	}

	public ContentAssistProcessorTestBuilder assertText(String... expectedText) throws Exception {
		assertTextAtCursorPosition(this.cursorPosition, expectedText);
		return this;
	}

	public ContentAssistProcessorTestBuilder assertTextAtCursorPosition(int cursorPosition, String... expectedText)
			throws Exception {

		String currentModelToParse = this.modelBuilder.toString();

		ICompletionProposal[] computeCompletionProposals = computeCompletionProposals(currentModelToParse,
				cursorPosition);

		assertEquals("expect only " + expectedText.length + " CompletionProposal item for model '"
				+ currentModelToParse + "': expectation was:\n" + 
				Strings.concat(", ", Arrays.asList(expectedText)) + 
				"\nbut actual was:\n" + Strings.concat(", ", toString(computeCompletionProposals)),
				expectedText.length, computeCompletionProposals.length);

		for (int i = 0; i < computeCompletionProposals.length; i++) {
			ICompletionProposal completionProposal = computeCompletionProposals[i];
			assertTrue("expect completionProposal text '" + completionProposal + "' ", Arrays.asList(expectedText)
					.contains(completionProposal.getDisplayString()));
		}

		return this;
	}
	
	private List<String> toString(ICompletionProposal[] proposals) {
		List<String> res = new ArrayList<String>(proposals.length);
		for(ICompletionProposal proposal: proposals) {
			res.add(proposal.getDisplayString());
		}
		return res;
	}

	public ContentAssistProcessorTestBuilder assertCountAtCursorPosition(int completionProposalCount, int cursorPosition)
			throws Exception {

		String currentModelToParse = this.modelBuilder.toString();

		ICompletionProposal[] computeCompletionProposals = computeCompletionProposals(currentModelToParse,
				cursorPosition);

		assertEquals("expect only " + completionProposalCount + " CompletionProposal item for model '"
				+ currentModelToParse + "'", completionProposalCount, computeCompletionProposals.length);

		return this;
	}

	public ICompletionProposal[] computeCompletionProposals(String currentModelToParse, int cursorPosition)
			throws Exception {
		CompositeNode rootNode = getRootNode(currentModelToParse);

		org.easymock.EasyMock.reset(textViewerMock, xtextDocumentMock, textViewerMock);

		expect(textViewerMock.getDocument()).andReturn(xtextDocumentMock);
		expect(xtextDocumentMock.readOnly((UnitOfWork<CompositeNode>) anyObject())).andReturn(rootNode);
		expect(textViewerMock.getTextWidget()).andReturn(newStyledTextWidgetMock(currentModelToParse));

		replay(textViewerMock, xtextDocumentMock);

		ICompletionProposal[] computeCompletionProposals = this.contentAssistProcessor.computeCompletionProposals(
				textViewerMock, cursorPosition);
		return computeCompletionProposals;
	}

	@Override
	public String toString() {
		return this.modelBuilder.toString() + "\n length: " + this.modelBuilder.toString().length() + "\n cursor at: "
				+ this.cursorPosition;
	}

	private CompositeNode getRootNode(String model) throws Exception {
		return getRootNode(new StringInputStream(model));
	}

	private CompositeNode getRootNode(InputStream model) throws Exception {
		XtextResource resource = getResource(model);
		return getRootNode(resource);
	}

	private XtextResource getResource(InputStream in) throws Exception {
		ResourceSet rs = new XtextResourceSet();
		XtextResource resource = (XtextResource) rs.createResource(URI.createURI("mytestmodel."
				+ getResourceFactory().getModelFileExtensions()[0]));
		resource.load(in, null);
		return resource;
	}

	private IResourceFactory getResourceFactory() {
		return ServiceRegistry.getService(this.serviceScope, IResourceFactory.class);
	}

	private CompositeNode getRootNode(XtextResource resource) {
		return resource.getParseResult().getRootNode();
	}

	private StyledText newStyledTextWidgetMock(final String testDslModel) {
		return new StyledText(new Shell(), SWT.NONE) {
			@Override
			public int getCharCount() {
				return testDslModel.length();
			}

			@Override
			public String getText(int start, int end) {
				return testDslModel.substring(start, end + 1);
			}
		};
	}

}
