/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer;
import org.eclipse.xtext.resource.DefaultLocationInFileProvider;
import org.eclipse.xtext.resource.OutdatedStateManager;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Test;

import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OutlineTreeProviderTest extends AbstractXtextTests {

	private DefaultOutlineTreeProvider treeProvider;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		final Injector injector = Activator.getInstance().getInjector("org.eclipse.xtext.ui.tests.editor.outline.OutlineTestLanguage");
		with(new ISetup() {
			@Override
			public Injector createInjectorAndDoEMFRegistration() {
				return injector;
			}
		});
		treeProvider = new DefaultOutlineTreeProvider(new DefaultEObjectLabelProvider(),
				new DefaultLocationInFileProvider());
	}

	@Test public void testCreateRoot() throws Exception {
		XtextDocument document = createXtextDocument("element {}");
		IOutlineNode rootNode = treeProvider.createRoot(document);
		assertTrue(rootNode instanceof DocumentRootNode);
		assertEquals(treeProvider, ((DocumentRootNode)rootNode).getTreeProvider());
		assertEquals(new TextRegion(0, 10), rootNode.getFullTextRegion());
		assertEquals(new TextRegion(0, 10), rootNode.getSignificantTextRegion());
		assertEquals(document, ((DocumentRootNode) rootNode).getDocument());
	}
	
	@Test public void testCreateChildren() throws Exception {
		final String modelAsText = "element1 { element11 {}} element2 {}";
		IXtextDocument document = createXtextDocument(modelAsText);
		final IOutlineNode rootNode = treeProvider.createRoot(document);
		document.readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				treeProvider.createChildren(rootNode, state.getContents().get(0));
				assertEquals(1, rootNode.getChildren().size());
				IOutlineNode modelNode = rootNode.getChildren().get(0);
				assertEquals(state.getURI().trimFileExtension().lastSegment(), modelNode.getText());
				assertEquals(new TextRegion(0, modelAsText.length()), modelNode.getSignificantTextRegion());
				assertEquals(new TextRegion(0, modelAsText.length()), modelNode.getFullTextRegion());
				assertEquals(rootNode, modelNode.getParent());
				assertTrue(modelNode.hasChildren());
				
				assertEquals(2, modelNode.getChildren().size());
				IOutlineNode element1 = modelNode.getChildren().get(0);
				assertEquals("element1", element1.getText().toString());
				assertEquals(new TextRegion(0, 8), element1.getSignificantTextRegion());
				assertEquals(new TextRegion(0, 24), element1.getFullTextRegion());
				assertEquals(modelNode, element1.getParent());
				assertTrue(element1.hasChildren());
				
				IOutlineNode element2 = modelNode.getChildren().get(1);
				assertEquals("element2", element2.getText().toString());
				assertEquals(new TextRegion(25, 8), element2.getSignificantTextRegion());
				assertEquals(new TextRegion(25, 11), element2.getFullTextRegion());
				assertEquals(modelNode, element2.getParent());
				assertFalse(element2.hasChildren());
			}
		});
	}

	@Test public void testNoNames() throws Exception {
		final DefaultOutlineTreeProvider noNamesTreeProvider = new DefaultOutlineTreeProvider(new DefaultEObjectLabelProvider(),
				new DefaultLocationInFileProvider()) {
			@Override
			protected Object _text(Object modelElement) {
				return null;
			}
		};
		final String modelAsText = "element1 { element11 {}} element2 {}";
		IXtextDocument document = createXtextDocument(modelAsText);
		final IOutlineNode rootNode = noNamesTreeProvider.createRoot(document);
		document.readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				noNamesTreeProvider.createChildren(rootNode, state.getContents().get(0));
				
				assertEquals(1, rootNode.getChildren().size());
				IOutlineNode modelNode = rootNode.getChildren().get(0);
				assertEquals(state.getURI().trimFileExtension().lastSegment(), modelNode.getText());
				assertTrue(modelNode.hasChildren());
				
				assertEquals(1, modelNode.getChildren().size());
				IOutlineNode element1 = modelNode.getChildren().get(0);
				assertEquals("<unnamed>", element1.getText().toString());
				assertEquals(new TextRegion(0, 8), element1.getSignificantTextRegion());
				assertEquals(new TextRegion(0, 24), element1.getFullTextRegion());
				assertEquals(modelNode, element1.getParent());
				// node does not know that its children will be skipped
				assertTrue(element1.hasChildren());
				assertTrue(element1.getChildren().isEmpty());
			}
		});
	}
	
	protected XtextDocument createXtextDocument(String modelAsText) throws Exception {
		final XtextResource resource = getResource(modelAsText, "test.outlinetestlanguage");
		DocumentTokenSource tokenSource = new DocumentTokenSource();
		tokenSource.setLexer(new Provider<Lexer>(){
			@Override
			public Lexer get() {
				return new InternalXtextLexer();
			}});
		XtextDocument xtextDocument = new XtextDocument(tokenSource, null, new OutdatedStateManager(), new OperationCanceledManager());
		xtextDocument.setInput(resource);
		xtextDocument.set(modelAsText);
		return xtextDocument;	
	}
}
