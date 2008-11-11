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

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.testlanguages.ReferenceGrammarStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;


/**
 * Unit test for class <code>DefaultContentAssistProcessor</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 * @see org.eclipse.xtext.ui.common.editor.codecompletion.DefaultContentAssistProcessor
 */
public class DefaultContentAssistProcessorTest extends AbstractGeneratorTest 
{

	private DefaultContentAssistProcessor defaultContentAssistProcessor;
    private ITextViewer textViewerMock;
    private IXtextDocument xtextDocumentMock;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(ReferenceGrammarStandaloneSetup.class);
		textViewerMock = createMock(ITextViewer.class);
		xtextDocumentMock = createMock(IXtextDocument.class);
		defaultContentAssistProcessor = new DefaultContentAssistProcessor();
		defaultContentAssistProcessor.setProposalProvider(new AbstractProposalProvider(){
			@Override
			protected String getDefaultImageFilePath() {
				return "JUNIT";
			}

			@Override
			protected String getPluginId() {
				return "JUNIT";
			}}
		);
	}
	
	@SuppressWarnings("unchecked")
	public void testComputeCompletionProposalsCount() throws Exception {
		
		final String testDslModel = "spielplatz ";
		
		CompositeNode rootNode = getRootNode(testDslModel);
		expect(textViewerMock.getDocument()).andReturn(xtextDocumentMock);
		expect(xtextDocumentMock.readOnly((UnitOfWork<CompositeNode>) anyObject()))
				.andReturn(rootNode);
		expect(textViewerMock.getTextWidget()).andReturn(newStyledTextWidgetMock(testDslModel));
		replay(textViewerMock);
		replay(xtextDocumentMock);

		ICompletionProposal[] computeCompletionProposals = defaultContentAssistProcessor.computeCompletionProposals(textViewerMock, testDslModel.length());
		
		assertEquals("expect only 1 ICompletionProposal item",1,computeCompletionProposals.length);
	}

	private StyledText newStyledTextWidgetMock(final String testDslModel) {
		return new StyledText(new Shell(), SWT.NONE) {
			@Override
			public int getCharCount() {
				return testDslModel.length();
			}

			@Override
			public String getText(int start, int end) {
				return testDslModel.substring(start, end);
			}
		};
	}

}