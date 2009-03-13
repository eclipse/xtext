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

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
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

	private final IContentAssistProcessor contentAssistProcessor;
	private final ITextViewer textViewerMock;
	private String model;
	private int cursorPosition;
	private final ISetup setupClazz;
	private final AbstractXtextTests tests;

	public ContentAssistProcessorTestBuilder(ISetup setupClazz, AbstractXtextTests tests) throws Exception {
		this.setupClazz = setupClazz;
		this.tests = tests;
		tests.with(setupClazz);
		this.contentAssistProcessor = tests.get(IContentAssistProcessor.class);
		this.textViewerMock = EasyMock.createMock(ITextViewer.class);
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

		Assert.assertEquals("expect " + expectedText.length + " CompletionProposal item for model '"
				+ currentModelToParse + "': expectation was:\n" + Strings.concat(", ", Arrays.asList(expectedText))
				+ "\nbut actual was:\n" + Strings.concat(", ", toString(computeCompletionProposals)),
				expectedText.length, computeCompletionProposals.length);

		for (int i = 0; i < computeCompletionProposals.length; i++) {
			ICompletionProposal completionProposal = computeCompletionProposals[i];
			Assert.assertTrue("expect completionProposal text '" + completionProposal.getDisplayString() + "' ", Arrays.asList(expectedText)
					.contains(completionProposal.getDisplayString()));
		}

		return this;
	}

	public ContentAssistProcessorTestBuilder assertMatchString(String matchString)
			throws Exception {
		String currentModelToParse = getModel();
		final XtextResource xtextResource = tests.getResource(new StringInputStream(currentModelToParse));
		List<IContentAssistContext> contentAssistContextList = new DefaultContentAssistProcessor() {
			@Override
			public List<IContentAssistContext> createContextList(XtextResource resource, String text, final int offset) {
				return super.createContextList(xtextResource, text, offset);
			}
		}.createContextList(xtextResource, currentModelToParse,cursorPosition);

		for (IContentAssistContext contentAssistContext : contentAssistContextList) {
			Assert.assertEquals(matchString, contentAssistContext.getMatchString());
			break;
		}
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

		final XtextResource xtextResource = tests.getResource(new StringInputStream(currentModelToParse));

		final IXtextDocument xtextDocument = getDocument(xtextResource);

		return this.contentAssistProcessor.computeCompletionProposals(resetTextViewerMock(currentModelToParse, xtextDocument), cursorPosition);
	}


	@Override
	public String toString() {
		return getModel() + "\n length: " + getModel().length() + "\n cursor at: "
				+ this.cursorPosition;
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

	private ITextViewer resetTextViewerMock(final String currentModelToParse, final IXtextDocument xtextDocument) {
		EasyMock.reset(textViewerMock);
		expect(textViewerMock.getDocument()).andReturn(xtextDocument);
		expect(textViewerMock.getTextWidget()).andReturn(newStyledTextWidgetMock(currentModelToParse)).times(2);
		replay(textViewerMock);
		return textViewerMock;
	}

	private ContentAssistProcessorTestBuilder clone(String model, int offset) throws Exception {
		ContentAssistProcessorTestBuilder builder = new ContentAssistProcessorTestBuilder(setupClazz, tests);
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

			@Override
			public String getText() {
				return testDslModel;
			}
		};
	}

	public <T> T get(Class<T> clazz) {
		return tests.get(clazz);
	}

}
