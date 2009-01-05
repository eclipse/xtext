/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.util.Function;
import org.eclipse.xtext.util.SimpleCache;

/**
 * Provides a default implementation of interface <code>IXtextSourceViewer</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 * 
 * @see IXtextSourceViewer
 */
public class XtextSourceViewer extends ProjectionViewer implements IXtextSourceViewer, IXtextModelListener {

	private CompositeNode rootNode;

	// SZ: Why do we cache this? 
	// Integer as keys are kind of problematic:
	// on the one hand will nobody refer to any of these integers
	// thus the cache will discard the entries nearly immediatly,
	// on the other hand are all integers smaller than 127 singletons
	// and therefore never discarded by the gc, so the corresponding entries
	// will never be discarded by the cache
	private SimpleCache<Integer, AbstractNode> referenceNodeCache;

	private SimpleCache<Integer, AbstractNode> nodeCache;

	public XtextSourceViewer(Composite parent, IVerticalRuler ruler, IOverviewRuler overviewRuler,
			boolean showsAnnotationOverview, int styles) {
		super(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
		init();
	}

	@Override
	protected void createControl(Composite parent, int styles) {
		// required for 'headless' standalone unit tests
		if (parent != null) {
			super.createControl(parent, styles);
		}
	}

	@Override
	public void setDocument(IDocument document, IAnnotationModel annotationModel) {
		if (getDocument() != null)
			((IXtextDocument) getDocument()).removeModelListener(this);
		init();
		super.setDocument(document, annotationModel);
		if (document != null)
			((IXtextDocument) getDocument()).addModelListener(this);
	}

	@Override
	public void setDocument(IDocument document, IAnnotationModel annotationModel, int modelRangeOffset,
			int modelRangeLength) {
		if (getDocument() != null)
			((IXtextDocument) getDocument()).removeModelListener(this);
		init();
		super.setDocument(document, annotationModel, modelRangeOffset, modelRangeLength);
		if (document != null)
			((IXtextDocument) getDocument()).addModelListener(this);
	}

	@Override
	public void setDocument(IDocument document, int visibleRegionOffset, int visibleRegionLength) {
		if (getDocument() != null)
			((IXtextDocument) getDocument()).removeModelListener(this);
		init();
		super.setDocument(document, visibleRegionOffset, visibleRegionLength);
		if (document != null)
			((IXtextDocument) getDocument()).addModelListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.core.editor.IXtextSourceViewer#getRootNode()
	 */
	public CompositeNode getRootNode() {

		if (null == rootNode) {

			IXtextDocument xtextDocument = (IXtextDocument) getDocument();

			this.rootNode = xtextDocument.readOnly(new UnitOfWork<CompositeNode>() {
				public CompositeNode exec(XtextResource resource) throws Exception {
					IParseResult parseResult = resource.getParseResult();
					Assert.isNotNull(parseResult);
					return parseResult.getRootNode();
				}
			});
		}
		return rootNode;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.core.editor.model.IXtextModelListener#modelChanged(org.eclipse.xtext.resource.XtextResource)
	 */
	public void modelChanged(XtextResource resource) {
		init();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.core.editor.IXtextSourceViewer#getReferenceNode(int)
	 */
	public AbstractNode getReferenceNode(int offset) {
		return this.referenceNodeCache.get(offset);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.core.editor.IXtextSourceViewer#getNode(int)
	 */
	public AbstractNode getNode(int offset) {
		return this.nodeCache.get(offset);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.core.editor.IXtextSourceViewer#getModel(int)
	 */
	public EObject getModel(int offset) {
		AbstractNode lastCompleteNode = getReferenceNode(offset);

		return lastCompleteNode instanceof AbstractNode ? NodeUtil
				.getNearestSemanticObject((AbstractNode) lastCompleteNode) : lastCompleteNode;
	}

	private SimpleCache<Integer, AbstractNode> createReferenceNodeCache() {
		return new SimpleCache<Integer, AbstractNode>(new Function<Integer, AbstractNode>() {
			public AbstractNode exec(Integer offset) {
				return ParseTreeUtil.getLastCompleteNodeByOffset(getRootNode(), offset);
			}
		});
	}

	private SimpleCache<Integer, AbstractNode> createNodeCache() {
		return new SimpleCache<Integer, AbstractNode>(new Function<Integer, AbstractNode>() {
			public AbstractNode exec(Integer offset) {
				return ParseTreeUtil.getCurrentOrFollowingNodeByOffset(getRootNode(), offset);
			}
		});
	}

	private void init() {
		referenceNodeCache = createReferenceNodeCache();
		nodeCache = createNodeCache();
		this.rootNode = null;
	}

}
