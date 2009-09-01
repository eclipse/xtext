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
package org.eclipse.xtext.ui.common.editor.contentassist;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Strings;

/**
 * Represents a builder for <code>IContentAssistProcessor</code> tests.
 *
 * @author Michael Clay - Initial contribution and API
 * @author Sven Efftinge
 */
public class ContentAssistProcessorTestBuilder {

	private final IContentAssistProcessor contentAssistProcessor;
	private String model;
	private int cursorPosition;
	private final ISetup setupClazz;
	private final AbstractXtextTests tests;

	public ContentAssistProcessorTestBuilder(ISetup setupClazz, AbstractXtextTests tests) throws Exception {
		this.setupClazz = setupClazz;
		this.tests = tests;
		tests.with(setupClazz);
		this.contentAssistProcessor = tests.get(IContentAssistProcessor.class);
	}

	public ContentAssistProcessorTestBuilder reset() throws Exception {
		return clone("",0);
	}

	public ContentAssistProcessorTestBuilder append(String model) throws Exception {
		return clone(getModel()+model, cursorPosition+model.length());
	}

	public ContentAssistProcessorTestBuilder appendNl(String model) throws Exception {
		return append(model).append(Strings.newLine());
	}

	public ContentAssistProcessorTestBuilder insert(String model, int cursorPosition) throws Exception {
		StringBuilder builder = new StringBuilder(getModel()).insert(cursorPosition, model);
		return clone(builder.toString(), cursorPosition + model.length());
	}

	public ContentAssistProcessorTestBuilder cursorBack(int times) throws Exception {
		return clone(model,this.cursorPosition -= times);
	}

	public ContentAssistProcessorTestBuilder applyText() throws Exception {
		return applyText(0, true);
	}

	public ContentAssistProcessorTestBuilder applyText(boolean appendSpace) throws Exception {
		return applyText(0, appendSpace);
	}

	public ContentAssistProcessorTestBuilder applyText(int index, boolean appendSpace) throws Exception {
		ICompletionProposal proposal = computeCompletionProposals(getModel(), this.cursorPosition)[index];
		String text = proposal.getDisplayString();
		if (proposal instanceof ConfigurableCompletionProposal) {
			text = ((ConfigurableCompletionProposal) proposal).getReplacementString();
		}
		ContentAssistProcessorTestBuilder ret = append(text);
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

	public ContentAssistProcessorTestBuilder assertTextAtCursorPosition(
			String cursorPosition, String... expectedText) throws Exception {
		return assertTextAtCursorPosition(getModel().indexOf(cursorPosition), expectedText);
	}
	
	public ContentAssistProcessorTestBuilder assertTextAtCursorPosition(
			String cursorPosition, int offset, String... expectedText) throws Exception {
		return assertTextAtCursorPosition(getModel().indexOf(cursorPosition) + offset, expectedText);
	}
	
	public ContentAssistProcessorTestBuilder assertTextAtCursorPosition(int cursorPosition, String... expectedText)
			throws Exception {

		String currentModelToParse = getModel();

		ICompletionProposal[] computeCompletionProposals = computeCompletionProposals(currentModelToParse,
				cursorPosition);

		if (computeCompletionProposals == null)
			computeCompletionProposals = new ICompletionProposal[0];

		String expectation = Strings.concat(", ", Arrays.asList(expectedText));
		Assert.assertEquals("expect " + expectedText.length + " CompletionProposal item for model '"
				+ currentModelToParse + "': expectation was:\n" + expectation
				+ "\nbut actual was:\n" + Strings.concat(", ", toString(computeCompletionProposals)),
				expectedText.length, computeCompletionProposals.length);

		
		for (int i = 0; i < computeCompletionProposals.length; i++) {
			ICompletionProposal completionProposal = computeCompletionProposals[i];
			String proposedText = completionProposal.getDisplayString();
			if (completionProposal instanceof ConfigurableCompletionProposal)
				proposedText = ((ConfigurableCompletionProposal) completionProposal).getReplacementString();
			Assert.assertTrue("expect completionProposal text '" + expectation + "', but got " +
					Strings.concat(", ", toString(computeCompletionProposals)),
					Arrays.asList(expectedText).contains(proposedText));
		}

		return this;
	}

	public ContentAssistProcessorTestBuilder assertMatchString(String matchString)
			throws Exception {
		String currentModelToParse = getModel();
		final XtextResource xtextResource = tests.getResourceAndExpect(new StringInputStream(currentModelToParse), AbstractXtextTests.UNKNOWN_EXPECTATION);
		final IXtextDocument xtextDocument = getDocument(xtextResource, currentModelToParse);
		ITextViewer textViewer = getTextViewer(currentModelToParse, xtextDocument);
		ContentAssistContext.Factory factory = tests.get(ContentAssistContext.Factory.class);
		ContentAssistContext[] contexts = factory.create(textViewer, currentModelToParse.length(), xtextResource);
		for(ContentAssistContext context: contexts) {
			Assert.assertTrue("matchString = '" + matchString + "', actual: '" + context.getPrefix() + "'",
					"".equals(context.getPrefix()) || matchString.equals(context.getPrefix()));
		}
		return this;
	}

	private String getModel() {
		return this.model == null ? "":model;
	}

	private List<String> toString(ICompletionProposal[] proposals) {
		if (proposals == null)
			return Collections.emptyList();
		List<String> res = new ArrayList<String>(proposals.length);
		for (ICompletionProposal proposal : proposals) {
			String proposedText = proposal.getDisplayString();
			if (proposal instanceof ConfigurableCompletionProposal)
				proposedText = ((ConfigurableCompletionProposal) proposal).getReplacementString();
			res.add(proposedText);
		}
		return res;
	}

	public ContentAssistProcessorTestBuilder assertCountAtCursorPosition(int completionProposalCount, int cursorPosition)
			throws Exception {

		String currentModelToParse = getModel();

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

		final XtextResource xtextResource = tests.getResourceAndExpect(new StringInputStream(currentModelToParse), AbstractXtextTests.UNKNOWN_EXPECTATION);
		final IXtextDocument xtextDocument = getDocument(xtextResource, currentModelToParse);

		return this.contentAssistProcessor.computeCompletionProposals(getTextViewer(currentModelToParse, xtextDocument), cursorPosition);
	}


	@Override
	public String toString() {
		return getModel() + "\n length: " + getModel().length() + "\n cursor at: "
				+ this.cursorPosition;
	}

	public IXtextDocument getDocument(final XtextResource xtextResource, final String model) {
		final IXtextDocument xtextDocument = (IXtextDocument) Proxy.newProxyInstance(getClass().getClassLoader(),
				new Class[] { IXtextDocument.class }, new InvocationHandler() {

					@SuppressWarnings("unchecked")
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if (args!=null && args[0] instanceof IUnitOfWork)
							return ((IUnitOfWork<?,XtextResource>) args[0]).exec(xtextResource);
						if (method.getName().equals("get")) {
							if (args != null && args.length == 2) {
								int from = (Integer) args[0];
								int length = (Integer) args[1];
								return model.substring(from, length - from);
							}
							return model;
						}
						if (method.getName().equals("getLength"))
							return Integer.MAX_VALUE;
						throw new UnsupportedOperationException("The test mock IXtextDocument does not support the operation "+method);
					}
				});
		return xtextDocument;
	}

	public ITextViewer getTextViewer(final String currentModelToParse, final IXtextDocument xtextDocument) {
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
		};
		return result;
	}

	private ContentAssistProcessorTestBuilder clone(String model, int offset) throws Exception {
		ContentAssistProcessorTestBuilder builder = new ContentAssistProcessorTestBuilder(setupClazz, tests);
		builder.model = model;
		builder.cursorPosition = offset;
		return builder;
	}

	public <T> T get(Class<T> clazz) {
		return tests.get(clazz);
	}

}
