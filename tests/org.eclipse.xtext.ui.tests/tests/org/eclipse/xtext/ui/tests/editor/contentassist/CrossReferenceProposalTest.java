/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.UIPluginModule;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.junit.editor.contentassist.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.crossReferenceProposalTest.CrossReferenceProposalTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.CrossReferenceProposalTestLanguageGrammarAccess;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.CrossReferenceProposalTestLanguageUiModule;

import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CrossReferenceProposalTest extends AbstractContentAssistProcessorTest {

	public ISetup getCrossReferenceProposalTestLanguageSetup() {
		return new CrossReferenceProposalTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new CrossReferenceProposalTestLanguageUiModule(), new UIPluginModule(
						Activator.getInstance()));
			}
		};
	}
	
	public void testBug276742_08() throws Exception {
		newBuilder(getCrossReferenceProposalTestLanguageSetup()).append("Foo {}").assertText("Foo", "Name", "}");
	}

	public void testBug276742_08b() throws Exception {
		String modelAsString = "Foo {}";
		ContentAssistProcessorTestBuilder builder = newBuilder(getCrossReferenceProposalTestLanguageSetup());
		XtextContentAssistProcessor processor = get(XtextContentAssistProcessor.class);
		XtextResource resource = getResourceFromString(modelAsString);

		ITextViewer viewer = builder.getTextViewer(modelAsString, builder.getDocument(resource, modelAsString));
		ContentAssistContext[] contexts = processor.getContextFactory()
				.create(viewer, modelAsString.length(), resource);
		assertEquals(2, contexts.length);
		Set<EClass> contextTypes = Sets.newHashSet(CrossReferenceProposalTestPackage.Literals.MODEL,
				CrossReferenceProposalTestPackage.Literals.CLASS);
		CrossReferenceProposalTestLanguageGrammarAccess grammarAccess = get(CrossReferenceProposalTestLanguageGrammarAccess.class);
		for (ContentAssistContext context : contexts) {
			EObject model = context.getCurrentModel();
			assertTrue(contextTypes.remove(model.eClass()));
			if (context.getFirstSetGrammarElements().contains(
					grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3())) {
				assertEquals(CrossReferenceProposalTestPackage.Literals.CLASS, model.eClass());
			}
			else {
				assertEquals(CrossReferenceProposalTestPackage.Literals.MODEL, model.eClass());
			}
		}
	}

	public void testBug276742_09() throws Exception {
		newBuilder(getCrossReferenceProposalTestLanguageSetup()).append("Foo {}").assertTextAtCursorPosition(0,
				"Foo", "Name");
	}

	public void testBug276742_09b() throws Exception {
		String modelAsString = "Foo {}";
		ContentAssistProcessorTestBuilder builder = newBuilder(getCrossReferenceProposalTestLanguageSetup());
		XtextContentAssistProcessor processor = get(XtextContentAssistProcessor.class);
		XtextResource resource = getResourceFromString(modelAsString);

		ITextViewer viewer = builder.getTextViewer(modelAsString, builder.getDocument(resource, modelAsString));
		ContentAssistContext[] contexts = processor.getContextFactory().create(viewer, 0, resource);
		assertEquals(1, contexts.length);
		for (ContentAssistContext context : contexts) {
			assertEquals(CrossReferenceProposalTestPackage.Literals.MODEL, context.getCurrentModel().eClass());
		}
	}

	public void testBug276742_10() throws Exception {
		newBuilder(getCrossReferenceProposalTestLanguageSetup()).assertText("Name");
	}
}
