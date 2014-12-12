/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import java.io.IOException;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.ui.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.crossReferenceProposalTest.Class;
import org.eclipse.xtext.ui.tests.editor.contentassist.crossReferenceProposalTest.CrossReferenceProposalTestFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.crossReferenceProposalTest.CrossReferenceProposalTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.crossReferenceProposalTest.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.crossReferenceProposalTest.impl.ClassImpl;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.CrossReferenceProposalTestLanguageGrammarAccess;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.CrossReferenceProposalTestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CrossReferenceProposalTest extends AbstractContentAssistProcessorTest {

	@Override
	public ISetup doGetSetup() {
		return new CrossReferenceProposalTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(
						new CrossReferenceProposalTestLanguageRuntimeModule(),
						new CrossReferenceProposalTestLanguageUiModule(
						Activator.getInstance()),
						new SharedStateModule()));
			}
		};
	}
	
	@Test public void testBug276742_08() throws Exception {
		newBuilder().append("Foo {}").assertText("Foo", "Name", "}");
	}

	@Test public void testBug276742_08b() throws Exception {
		String modelAsString = "Foo {}";
		ContentAssistProcessorTestBuilder builder = newBuilder();
		XtextContentAssistProcessor processor = get(XtextContentAssistProcessor.class);
		XtextResource resource = getResourceFromString(modelAsString);

		ITextViewer viewer = builder.getSourceViewer(modelAsString, builder.getDocument(resource, modelAsString));
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

	@Test public void testBug276742_09() throws Exception {
		newBuilder().append("Foo {}").assertTextAtCursorPosition(0,
				"Foo", "Name");
	}

	@Test public void testBug276742_09b() throws Exception {
		String modelAsString = "Foo {}";
		ContentAssistProcessorTestBuilder builder = newBuilder();
		XtextContentAssistProcessor processor = get(XtextContentAssistProcessor.class);
		XtextResource resource = getResourceFromString(modelAsString);

		ITextViewer viewer = builder.getSourceViewer(modelAsString, builder.getDocument(resource, modelAsString));
		ContentAssistContext[] contexts = processor.getContextFactory().create(viewer, 0, resource);
		assertEquals(1, contexts.length);
		for (ContentAssistContext context : contexts) {
			assertEquals(CrossReferenceProposalTestPackage.Literals.MODEL, context.getCurrentModel().eClass());
		}
	}

	@Test public void testBug276742_10() throws Exception {
		newBuilder().assertText("Name");
	}

	@Test public void testBug356185() throws Exception {
		with(getSetup());
		final String content = "Foo {}";
		XtextResourceSet rs = new XtextResourceSet(){
			@Override
			protected void demandLoad(Resource resource) throws IOException {
				resource.load(new StringInputStream(content), null);
			}
		};
		rs.setClasspathURIContext(getClass());
		XtextResource resource1 = (XtextResource) rs.createResource(URI.createURI("test1." + getCurrentFileExtension()));
		resource1.load(new StringInputStream(content), null);
		Model model = (Model) resource1.getContents().get(0);
		URI classToShowURI = EcoreUtil.getURI(model.getElements().get(0));
		resource1.unload();
		ClassImpl classToShow = (ClassImpl) CrossReferenceProposalTestFactory.eINSTANCE.createClass();
		classToShow.eSetProxyURI(classToShowURI);
		ResourceSet resourceSet = resource1.getResourceSet();
		XtextResource resource2 = (XtextResource) resourceSet.createResource(URI.createURI("test." + getCurrentFileExtension()));
		resource2.load(new StringInputStream("Foo <- Bar {}"), null);
		ContentAssistContext.Builder builder = get(ContentAssistContext.Builder.class);
		builder.setResource(resource2);
		builder.setReplaceRegion(new Region(0,0));
		model = (Model) resource2.getContents().get(0);
		Class contextClass = model.getElements().get(0);
		ICompositeNode node = NodeModelUtils.getNode(contextClass);
		builder.setCurrentNode(node);
		builder.setMatcher(new PrefixMatcher() {
			@Override
			public boolean isCandidateMatchingPrefix(String name, String prefix) {
				return true;
			}
		});
		ContentAssistContext context = builder.toContext();
		ContentProposalProvider proposalProvider = get(ContentProposalProvider.class);
		proposalProvider.setConflictHelper(new IProposalConflictHelper(){
			@Override
			public boolean existsConflict(String proposal, ContentAssistContext context) {
				return false;
			}});
		Function<IEObjectDescription, ICompletionProposal> proposalFactory = proposalProvider.getProposalFactory(context);
		ConfigurableCompletionProposal proposal = (ConfigurableCompletionProposal) proposalFactory.apply(new EObjectDescription(QualifiedName.create("Foo"), classToShow, null));
		assertTrue(classToShow.eIsProxy());
		Object additionalProposalInfo = proposal.getAdditionalProposalInfo(new NullProgressMonitor());
		assertNotNull(additionalProposalInfo);

	}

}
