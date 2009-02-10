/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.ILocationInFileProvider;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;

import com.google.inject.Inject;

/**
 * Represents an implementation of interface {@link IHyperlinkDetector} to find
 * and convert {@link CrossReference elements}, at a given location, to
 * <code>IHyperlink</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 * @see org.eclipse.jface.text.hyperlink.IHyperlinkDetector
 * @see org.eclipse.jface.text.hyperlink.IHyperlink
 */
public class DefaultHyperlinkDetector extends org.eclipse.core.commands.AbstractHandler implements IHyperlinkDetector {

	private ILinkingService linkingService;
	private ILocationInFileProvider locationProvider;
	private ILabelProvider labelProvider;
	
	
	@Inject
	public DefaultHyperlinkDetector(ILinkingService linkingService, ILocationInFileProvider locationProvider, ILabelProvider labelProvider) {
		super();
		this.linkingService = linkingService;
		this.locationProvider = locationProvider;
		this.labelProvider = labelProvider;
	}

	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.hyperlink.IHyperlinkDetector#detectHyperlinks(org.eclipse.jface.text.ITextViewer, org.eclipse.jface.text.IRegion, boolean)
	 */
	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, final IRegion region, boolean canShowMultipleHyperlinks) {
		return ((IXtextDocument)textViewer.getDocument()).readOnly(new UnitOfWork<IHyperlink[]>() {
			public IHyperlink[] exec(XtextResource resource) throws Exception {
				IParseResult parseResult = resource.getParseResult();
				Assert.isNotNull(parseResult);
				AbstractNode abstractNode = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(parseResult.getRootNode(),
						region.getOffset());
				final Region location = new Region(abstractNode.getOffset(), abstractNode.getLength());
				List<EObject> crossLinkedEObjects = findCrossLinkedEObject(abstractNode);
				if (crossLinkedEObjects.isEmpty())
					return null;
				List<IHyperlink> links = new ArrayList<IHyperlink>();
				for (EObject crossReffed : crossLinkedEObjects) {
					final String label = labelProvider.getText(crossReffed);
					final URI uri = EcoreUtil.getURI(crossReffed);
					links.add(new IHyperlink() {
							 
							public IRegion getHyperlinkRegion() {
								return location;
							}
							public String getHyperlinkText() {
								return label;
							}
							public String getTypeLabel() {
								return null;
							}
							public void open() {
								new OpenDeclarationAction(uri, locationProvider).run();
							}
							
						});
				}
				return links.toArray(new IHyperlink[links.size()]);
			}
		});
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor activeEditor = (XtextEditor) HandlerUtil.getActiveEditor(event);
		final IXtextDocument document = activeEditor.getDocument();
		final int offset = ((StyledText) activeEditor.getAdapter(Control.class)).getCaretOffset();
		document.readOnly(new UnitOfWork<Object>() {
			public Object exec(XtextResource resource) throws Exception {
				AbstractNode node = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(resource
						.getParseResult().getRootNode(), offset);
				List<EObject> crossLinkedEObject = findCrossLinkedEObject(node);
				if (crossLinkedEObject.isEmpty())
					return null;
				URI uri = EcoreUtil.getURI(crossLinkedEObject.get(0));
				new OpenDeclarationAction(uri, locationProvider).run();
				return null;
			}
		});
		return this;
	}
	
	protected List<EObject> findCrossLinkedEObject(AbstractNode node) {
		if (node instanceof LeafNode && node.getGrammarElement() instanceof CrossReference) {
			EObject semanticModel = NodeUtil.getNearestSemanticObject(node);
			EReference eReference = GrammarUtil.getReference((CrossReference) node.getGrammarElement(),
					semanticModel.eClass());	
			return linkingService.getLinkedObjects(semanticModel, eReference, (LeafNode) node);
		}
		return Collections.emptyList();
	}
}
