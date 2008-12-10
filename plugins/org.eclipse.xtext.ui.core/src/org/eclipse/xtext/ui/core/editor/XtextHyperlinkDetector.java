/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;

/**
 * Represents an implementation of interface {@link IHyperlinkDetector} to find
 * and convert {@link CrossReference elements}, at a given location, to
 * <code>IHyperlink</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 * @see org.eclipse.jface.text.hyperlink.IHyperlinkDetector
 * @see org.eclipse.jface.text.hyperlink.IHyperlink
 */
public class XtextHyperlinkDetector implements IHyperlinkDetector {

	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.hyperlink.IHyperlinkDetector#detectHyperlinks(
	 * org.eclipse.jface.text.ITextViewer, org.eclipse.jface.text.IRegion,
	 * boolean)
	 */
	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region, boolean canShowMultipleHyperlinks) {

		// TODO: should all of this be part of the read transaction?
		CompositeNode rootNode = getRootNode(textViewer.getDocument());
		LeafNode currentNode = (LeafNode) ParseTreeUtil.getCurrentOrFollowingNodeByOffset(rootNode, region.getOffset());

		if (currentNode.getGrammarElement() instanceof CrossReference) {

			EObject semanticModel = NodeUtil.getNearestSemanticObject(currentNode);
			EReference eReference = GrammarUtil.getReference((CrossReference) currentNode.getGrammarElement(),
					semanticModel.eClass());
			EObject linkMe = null;
			if (eReference.isMany()) {
				List<?> values = (List<?>) semanticModel.eGet(eReference);
				if (!values.isEmpty() && values.get(0) instanceof EObject)
					linkMe = (EObject) values.get(0);
			} else {
				Object value = semanticModel.eGet(eReference);
				if (value instanceof EObject)
					linkMe = (EObject) value;
			}
//			List<EObject> linkedObjects = this.linkingService.getLinkedObjects(semanticModel, eReference, currentNode);

			if (linkMe != null) {
				return createXtextHyperlink(currentNode, linkMe);
			}

		}

		return null;
	}

	private IHyperlink[] createXtextHyperlink(final LeafNode currentNode, final EObject referenceEObject) {

		return new IHyperlink[] { new IHyperlink() {

			public IRegion getHyperlinkRegion() {
				return new Region(currentNode.getTotalOffset(), currentNode.getTotalLength());
			}

			public String getHyperlinkText() {
				return currentNode.getText();
			}

			public String getTypeLabel() {
				return null;
			}

			public void open() {

				IFile targetFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
						new Path(referenceEObject.eResource().getURI().toPlatformString(true)));

				if (targetFile != null) {

					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

					try {
						IEditorPart openEditor = IDE.openEditor(page, targetFile);

						if (openEditor instanceof ITextEditor) {

							NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(referenceEObject);
							((ITextEditor) openEditor).selectAndReveal(nodeAdapter.getParserNode().getOffset(),
									nodeAdapter.getParserNode().getLength());
						}
					}
					catch (PartInitException partInitException) {
						logger.error("Error while opening editor part from workbench with file '" + targetFile + "'",
								partInitException);
					}
				}
			}
		} };
	}

	private CompositeNode getRootNode(IDocument document) {

		CompositeNode rootNode = ((IXtextDocument) document).readOnly(new UnitOfWork<CompositeNode>() {
			public CompositeNode exec(XtextResource resource) throws Exception {
				IParseResult parseResult = resource.getParseResult();
				Assert.isNotNull(parseResult);
				return parseResult.getRootNode();
			}
		});

		return rootNode;
	}

}
