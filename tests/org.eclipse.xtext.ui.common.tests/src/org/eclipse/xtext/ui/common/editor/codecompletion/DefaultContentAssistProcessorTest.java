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
import static org.easymock.EasyMock.reset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.testlanguages.ReferenceGrammarStandaloneSetup;
import org.eclipse.xtext.testlanguages.ReferenceGrammarUiConfig;
import org.eclipse.xtext.ui.common.AbstractUiTest;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;


/**
 * Unit test for class <code>DefaultContentAssistProcessor</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 * @see org.eclipse.xtext.ui.common.editor.codecompletion.DefaultContentAssistProcessor
 */
@SuppressWarnings("unchecked")
public class DefaultContentAssistProcessorTest extends AbstractUiTest 
{

	private DefaultContentAssistProcessor defaultContentAssistProcessor;
    private ITextViewer textViewerMock;
    private IXtextDocument xtextDocumentMock;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		withUi(ReferenceGrammarStandaloneSetup.class,ReferenceGrammarUiConfig.class);
		textViewerMock = createMock(ITextViewer.class);
		xtextDocumentMock = createMock(IXtextDocument.class);
		defaultContentAssistProcessor = new DefaultContentAssistProcessor();
		ServiceRegistry.injectServices(getCurrentServiceScope(), defaultContentAssistProcessor);
	}
	
	public void testComputeCompletionProposalsCount() throws Exception {
		
		Map<String, Integer> model2ExpectedProposalCountMap = new HashMap<String, Integer>();
		StringBuilder modelBuilder = new StringBuilder("");
		model2ExpectedProposalCountMap.put(modelBuilder.toString(), 1);
		model2ExpectedProposalCountMap.put(modelBuilder.append("spielplatz ").toString(), 2);
		model2ExpectedProposalCountMap.put(modelBuilder.append("1 ").toString(), 3);
		model2ExpectedProposalCountMap.put(modelBuilder.append("\"JUNIT\" ").toString(), 1);
		model2ExpectedProposalCountMap.put(modelBuilder.append("{ ").toString(), 5);
		model2ExpectedProposalCountMap.put(modelBuilder.append("kind ").toString(), 1);
		model2ExpectedProposalCountMap.put(modelBuilder.append("(k1 0) erwachsener(e1 0) erwachsener(e2 0) familie( f1 ").toString(),2);
		model2ExpectedProposalCountMap.put(modelBuilder.append("e1 ").toString(),2);
		model2ExpectedProposalCountMap.put(modelBuilder.append("e2 ").toString(),1);

		for (Iterator<String> iterator = model2ExpectedProposalCountMap.keySet()
				.iterator(); iterator.hasNext();) {

			String testDslModel = iterator.next();
			
			int expectedProposalCount = model2ExpectedProposalCountMap.get(testDslModel);

			CompositeNode rootNode = getRootNode(testDslModel);
			
			reset(textViewerMock,xtextDocumentMock,textViewerMock);
			
			expect(textViewerMock.getDocument()).andReturn(xtextDocumentMock);
			expect(xtextDocumentMock.readOnly((UnitOfWork<CompositeNode>) anyObject())).andReturn(rootNode);
			expect(textViewerMock.getTextWidget()).andReturn(newStyledTextWidgetMock(testDslModel));
			
			replay(textViewerMock,xtextDocumentMock);

			ICompletionProposal[] computeCompletionProposals = defaultContentAssistProcessor
					.computeCompletionProposals(textViewerMock, testDslModel
							.length());
			
			assertEquals("expect only " + expectedProposalCount+ " CompletionProposal item for model '" + testDslModel+ "'", 
					expectedProposalCount,
					computeCompletionProposals.length);
		}

	}
	
	public void testComputeCompletionProposalsText() throws Exception {
		
		Map<String, List<String>> model2ExpectedProposalTextMap = new HashMap<String, List<String>>();
		StringBuilder modelBuilder = new StringBuilder("");
		model2ExpectedProposalTextMap.put(modelBuilder.toString(), Arrays.asList("spielplatz "));
		model2ExpectedProposalTextMap.put(modelBuilder.append("spielplatz ").toString(), Arrays.asList("0","1"));
		model2ExpectedProposalTextMap.put(modelBuilder.append("1 ").toString(), Arrays.asList("\"SpielplatzBeschreibungSTRING\"","\"SpielplatzBeschreibung\"","{"));
		model2ExpectedProposalTextMap.put(modelBuilder.append("\"SpielplatzBeschreibung\" ").toString(), Arrays.asList("{"));
		model2ExpectedProposalTextMap.put(modelBuilder.append("{ ").toString(), Arrays.asList("erwachsener ","familie ","spielzeug ","kind ","}"));
		model2ExpectedProposalTextMap.put(modelBuilder.append("erwachsener ").toString(), Arrays.asList("("));
		model2ExpectedProposalTextMap.put(modelBuilder.append("( ").toString(), Arrays.asList("ErwachsenerNameID","ErwachsenerName"));
		model2ExpectedProposalTextMap.put(modelBuilder.append("e1 ").toString(), Arrays.asList("0","1"));
		model2ExpectedProposalTextMap.put(modelBuilder.append("0 ").toString(), Arrays.asList(")"));
		modelBuilder.append(")").append("erwachsener (e2 0)");
		model2ExpectedProposalTextMap.put(modelBuilder.append("kind ").toString(), Arrays.asList("("));
		model2ExpectedProposalTextMap.put(modelBuilder.append("( ").toString(), Arrays.asList("KindNameID","KindName"));
		model2ExpectedProposalTextMap.put(modelBuilder.append("k1 ").toString(), Arrays.asList("0","1"));
		model2ExpectedProposalTextMap.put(modelBuilder.append("0 ").toString(), Arrays.asList(")"));
		modelBuilder.append(")").append("kind (k2 0)");
		model2ExpectedProposalTextMap.put(modelBuilder.append("familie ").toString(), Arrays.asList("("));
		model2ExpectedProposalTextMap.put(modelBuilder.append("( ").toString(), Arrays.asList("keyword ","\"FamilieNameSTRING\"","FamilieNameID"));
		model2ExpectedProposalTextMap.put(modelBuilder.append("keyword ").toString(), Arrays.asList("e1","e2"));
		model2ExpectedProposalTextMap.put(modelBuilder.append("e1 ").toString(), Arrays.asList("e1","e2"));
		model2ExpectedProposalTextMap.put(modelBuilder.append("").toString(), Arrays.asList("e1","e2"));
		model2ExpectedProposalTextMap.put(modelBuilder.append("e2 ").toString(), Arrays.asList("k1","k2"));
		model2ExpectedProposalTextMap.put(modelBuilder.append("k").toString(), Arrays.asList("k1","k2",",",")"));
		model2ExpectedProposalTextMap.put(modelBuilder.append("1 ").toString(), Arrays.asList(",",")"));
		model2ExpectedProposalTextMap.put(modelBuilder.append("k2 ").toString(), Arrays.asList(",",")"));
		
		for (Iterator<String> iterator = model2ExpectedProposalTextMap.keySet()
				.iterator(); iterator.hasNext();) {

			String testDslModel = iterator.next();
			
			List<String> expectedTextList = model2ExpectedProposalTextMap.get(testDslModel);

			CompositeNode rootNode = getRootNode(testDslModel);
			
			reset(textViewerMock,xtextDocumentMock,textViewerMock);
			
			expect(textViewerMock.getDocument()).andReturn(xtextDocumentMock);
			expect(xtextDocumentMock.readOnly((UnitOfWork<CompositeNode>) anyObject())).andReturn(rootNode);
			expect(textViewerMock.getTextWidget()).andReturn(newStyledTextWidgetMock(testDslModel));
			
			replay(textViewerMock,xtextDocumentMock);

			ICompletionProposal[] computeCompletionProposals = defaultContentAssistProcessor
					.computeCompletionProposals(textViewerMock, testDslModel
							.length());
			
			assertEquals("expect only " + expectedTextList.size()+ " CompletionProposal item for model '" + testDslModel+ "'", 
					expectedTextList.size(),
					computeCompletionProposals.length);
			
			for (int i = 0; i < computeCompletionProposals.length; i++) {
				ICompletionProposal completionProposal = computeCompletionProposals[i];
				assertTrue("expect completionProposal text '"+completionProposal+"' ", expectedTextList.contains(completionProposal.getDisplayString()));
			}
			
			
		}

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