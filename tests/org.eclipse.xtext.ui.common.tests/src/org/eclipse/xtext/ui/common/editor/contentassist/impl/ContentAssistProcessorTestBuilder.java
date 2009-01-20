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
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Strings;

/**
 * Represents a builder for <code>IContentAssistProcessor</code> tests.
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Sven Efftinge
 */
public class ContentAssistProcessorTestBuilder {

	private IContentAssistProcessor contentAssistProcessor;
	private IServiceScope serviceScope;
	private ITextViewer textViewerMock;
	private String model;
	private int cursorPosition;

	public ContentAssistProcessorTestBuilder(IServiceScope serviceScope, IContentAssistProcessor contentAssistProcessor) {
		this.contentAssistProcessor = contentAssistProcessor;
		this.serviceScope = serviceScope;
		this.textViewerMock = EasyMock.createMock(ITextViewer.class);
		ServiceRegistry.injectServices(serviceScope, this.contentAssistProcessor);
	}
	
	public ContentAssistProcessorTestBuilder reset() {
		return clone("",0);
	}

	public ContentAssistProcessorTestBuilder append(String model) {
		return clone(getModel()+model, cursorPosition+model.length());
	}

	public ContentAssistProcessorTestBuilder appendNl(String model) {
		return append(model).append(Strings.newLine());
	}

	public ContentAssistProcessorTestBuilder insert(String model, int cursorPosition) {
		StringBuilder builder = new StringBuilder(getModel()).insert(cursorPosition, model);
		return clone(builder.toString(), cursorPosition + model.length());
	}

	public ContentAssistProcessorTestBuilder cursorBack(int times) {
		return clone(model,this.cursorPosition -= times);
	}

	public ContentAssistProcessorTestBuilder applyText() throws Exception {
		return applyText(0, true);
	}

	public ContentAssistProcessorTestBuilder applyText(boolean appendSpace) throws Exception {
		return applyText(0, appendSpace);
	}

	public ContentAssistProcessorTestBuilder applyText(int index, boolean appendSpace) throws Exception {
		ContentAssistProcessorTestBuilder ret = append(computeCompletionProposals(getModel(), this.cursorPosition)[index].getDisplayString());
		if (appendSpace) {
			return ret.append(" ");
		}
		return ret;
	}

	public ContentAssistProcessorTestBuilder assertCount(int completionProposalCount) throws Exception {
		return assertCountAtCursorPosition(completionProposalCount, this.cursorPosition);
	}

	public ContentAssistProcessorTestBuilder assertText(String... expectedText) throws Exception {
		return assertTextAtCursorPosition(this.cursorPosition, expectedText);
	}

	public ContentAssistProcessorTestBuilder assertTextAtCursorPosition(int cursorPosition, String... expectedText)
			throws Exception {

		String currentModelToParse = getModel();

		ICompletionProposal[] computeCompletionProposals = computeCompletionProposals(currentModelToParse,
				cursorPosition);

		assertEquals("expect only " + expectedText.length + " CompletionProposal item for model '"
				+ currentModelToParse + "': expectation was:\n" + Strings.concat(", ", Arrays.asList(expectedText))
				+ "\nbut actual was:\n" + Strings.concat(", ", toString(computeCompletionProposals)),
				expectedText.length, computeCompletionProposals.length);

		for (int i = 0; i < computeCompletionProposals.length; i++) {
			ICompletionProposal completionProposal = computeCompletionProposals[i];
			assertTrue("expect completionProposal text '" + completionProposal + "' ", Arrays.asList(expectedText)
					.contains(completionProposal.getDisplayString()));
		}

		return this;
	}
	
	public ContentAssistProcessorTestBuilder assertMatchString(String matchString)
			throws Exception {

		final String currentModelToParse = getModel();

		final XtextResource xtextResource = getResource(new StringInputStream(currentModelToParse));

		final IXtextDocument xtextDocument = getDocument(xtextResource);

		IContentAssistContext contentAssistContext = new DefaultContentAssistProcessor() {
			@Override
			public IContentAssistContext createContext(XtextResource resource, ITextViewer viewer, int offset) {
				IContentAssistContext createContext = super.createContext(resource,viewer,offset);
				return createContext;
			}
		}.createContext(xtextResource, resetTextViewerMock(currentModelToParse, xtextDocument),cursorPosition);
			

		assertEquals(matchString, contentAssistContext.getMatchString());

		return this;
	}

	private String getModel() {
		return this.model == null ? "":model;
	}

	private List<String> toString(ICompletionProposal[] proposals) {
		List<String> res = new ArrayList<String>(proposals.length);
		for (ICompletionProposal proposal : proposals) {
			res.add(proposal.getDisplayString());
		}
		return res;
	}

	public ContentAssistProcessorTestBuilder assertCountAtCursorPosition(int completionProposalCount, int cursorPosition)
			throws Exception {

		String currentModelToParse = getModel();

		ICompletionProposal[] computeCompletionProposals = computeCompletionProposals(currentModelToParse,
				cursorPosition);

		assertEquals("expect only " + completionProposalCount + " CompletionProposal item for model '"
				+ currentModelToParse + "'", completionProposalCount, computeCompletionProposals.length);

		return this;
	}

	public ICompletionProposal[] computeCompletionProposals(final String currentModelToParse, int cursorPosition)
			throws Exception {
		
		final XtextResource xtextResource = getResource(new StringInputStream(currentModelToParse));
		
		final IXtextDocument xtextDocument = getDocument(xtextResource);

		return this.contentAssistProcessor.computeCompletionProposals(resetTextViewerMock(currentModelToParse, xtextDocument), cursorPosition);
	}


	@Override
	public String toString() {
		return getModel() + "\n length: " + getModel().length() + "\n cursor at: "
				+ this.cursorPosition;
	}

	private XtextResource getResource(InputStream in) throws Exception {
		ResourceSet rs = new XtextResourceSet();
		XtextResource resource = (XtextResource) rs.createResource(URI.createURI("mytestmodel."
				+ getResourceFactory().getModelFileExtensions()[0]));
		resource.load(in, null);
		return resource;
	}

	private IXtextDocument getDocument(final XtextResource xtextResource) {
		final IXtextDocument xtextDocument = (IXtextDocument) Proxy.newProxyInstance(getClass().getClassLoader(),
				new Class[] { IXtextDocument.class }, new InvocationHandler() {

					@SuppressWarnings("unchecked")
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if (args[0] instanceof UnitOfWork)
							return ((UnitOfWork<XtextResource>) args[0]).exec(xtextResource);
						if (method.getName().equals("get"))
							return model;
						throw new UnsupportedOperationException("The test mock IXtextDocument does not support the operation "+method);
					}
				});
		return xtextDocument;
	}
	
	private IResourceFactory getResourceFactory() {
		return ServiceRegistry.getService(this.serviceScope, IResourceFactory.class);
	}
	
	private ITextViewer resetTextViewerMock(final String currentModelToParse, final IXtextDocument xtextDocument) {
		EasyMock.reset(textViewerMock);
		expect(textViewerMock.getDocument()).andReturn(xtextDocument);
		expect(textViewerMock.getTextWidget()).andReturn(newStyledTextWidgetMock(currentModelToParse));
		replay(textViewerMock);
		return textViewerMock;
	}
	
	private ContentAssistProcessorTestBuilder clone(String model, int offset) {
		ContentAssistProcessorTestBuilder builder = new ContentAssistProcessorTestBuilder(this.serviceScope, this.contentAssistProcessor);
		builder.model = model;
		builder.cursorPosition = offset;
		return builder;
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
