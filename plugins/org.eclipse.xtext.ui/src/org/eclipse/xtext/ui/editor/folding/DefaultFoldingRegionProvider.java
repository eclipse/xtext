/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.folding;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class DefaultFoldingRegionProvider implements IFoldingRegionProvider {
	private static final Logger log = Logger.getLogger(DefaultFoldingRegionProvider.class);
	protected static final Predicate<ITypedRegion> COMMENT_REGION_PREDICATE = new Predicate<ITypedRegion>() {
		public boolean apply(ITypedRegion rule) {
			return TerminalsTokenTypeToPartitionMapper.COMMENT_PARTITION.equals(rule.getType());
		}
	};

	public List<IFoldingRegion> getFoldingRegions(final IXtextDocument xtextDocument) {
		return xtextDocument.readOnly(new IUnitOfWork<List<IFoldingRegion>, XtextResource>() {
			public List<IFoldingRegion> exec(XtextResource xtextResource) throws Exception {
				if (xtextResource == null)
					return Collections.emptyList();
				return doGetFoldingRegions(xtextDocument, xtextResource);
			}
		});
	}

	protected List<IFoldingRegion> doGetFoldingRegions(IXtextDocument xtextDocument, XtextResource xtextResource) {
		List<IFoldingRegion> foldingRegions = Lists.newArrayList();
		IFoldingRegionAcceptor foldingRegionAcceptor = createAcceptor(xtextDocument, foldingRegions);
		computeObjectFolding(xtextDocument, xtextResource, foldingRegionAcceptor);
		computeCommentFolding(xtextDocument, foldingRegionAcceptor);
		return foldingRegions;
	}

	protected IFoldingRegionAcceptor createAcceptor(IXtextDocument xtextDocument, List<IFoldingRegion> foldingRegions) {
		return new DefaultFoldingRegionAcceptor(xtextDocument, foldingRegions);
	}

	protected void computeObjectFolding(IXtextDocument xtextDocument, XtextResource xtextResource,
			IFoldingRegionAcceptor foldingRegionAcceptor) {
		Iterator<EObject> allContents = xtextResource.getAllContents();
		while (allContents.hasNext()) {
			EObject eObject = allContents.next();
			if (isHandled(eObject)) {
				computeObjectFolding(xtextDocument, eObject, foldingRegionAcceptor);
			}
		}
	}

	protected void computeObjectFolding(IXtextDocument xtextDocument, EObject eObject,
			IFoldingRegionAcceptor foldingRegionAcceptor) {
		ICompositeNode compositeNode = NodeModelUtils.getNode(eObject);
		if (compositeNode != null) {
			foldingRegionAcceptor.accept(compositeNode.getOffset(), compositeNode.getLength());
		}
	}

	protected void computeCommentFolding(IXtextDocument xtextDocument, IFoldingRegionAcceptor foldingRegionAcceptor) {
		try {
			ITypedRegion[] typedRegions = xtextDocument.computePartitioning(0, xtextDocument.getLength());
			for (ITypedRegion typedRegion : Iterables.filter(Arrays.asList(typedRegions), COMMENT_REGION_PREDICATE)) {
				foldingRegionAcceptor.accept(typedRegion.getOffset(), typedRegion.getLength());
			}
		} catch (BadLocationException e) {
			log.error(e);
		}
	}

	protected boolean isHandled(EObject eObject) {
		return eObject.eContainer() != null;
	}

}
