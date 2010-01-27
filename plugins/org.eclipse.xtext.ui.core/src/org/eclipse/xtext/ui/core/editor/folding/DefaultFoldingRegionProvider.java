/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.folding;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Lists;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class DefaultFoldingRegionProvider implements IFoldingRegionProvider {
	private static final Logger log = Logger.getLogger(DefaultFoldingRegionProvider.class);

	public List<IFoldingRegion> getFoldingRegions(final IXtextDocument xtextDocument) {
		return xtextDocument.readOnly(new IUnitOfWork<List<IFoldingRegion>, XtextResource>() {
			public List<IFoldingRegion> exec(XtextResource xtextResource) throws Exception {
				return doGetFoldingRegions(xtextDocument, xtextResource);
			}
		});
	}

	protected List<IFoldingRegion> doGetFoldingRegions(IXtextDocument xtextDocument, XtextResource xtextResource) {
		List<IFoldingRegion> foldingRegions = Lists.newArrayList();
		Iterator<EObject> allContents = xtextResource.getAllContents();
		while (allContents.hasNext()) {
			EObject eObject = allContents.next();
			if (isHandled(eObject)) {
				addFoldingRegion(xtextDocument, eObject, foldingRegions);
			}
		}
		return foldingRegions;
	}

	protected void addFoldingRegion(IXtextDocument xtextDocument, EObject eObject, List<IFoldingRegion> foldingRegions) {
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(eObject);
		CompositeNode compositeNode = nodeAdapter.getParserNode();
		Position position = getPosition(xtextDocument, compositeNode);
		if (position != null) {
			IFoldingRegion foldingRegion = createFoldingRegion(position,eObject);
			Assert.isNotNull(foldingRegion, "foldingRegion must not be null");
			foldingRegions.add(foldingRegion);
		}
	}

	protected Position getPosition(IXtextDocument xtextDocument, CompositeNode compositeNode) {
		Position position = null;
		try {
			int startLine = xtextDocument.getLineOfOffset(compositeNode.getOffset());
			int endLine = xtextDocument.getLineOfOffset(compositeNode.getOffset() + compositeNode.getLength());
			if (startLine < endLine) {
				int start = xtextDocument.getLineOffset(startLine);
				int end = xtextDocument.getLineOffset(endLine) + xtextDocument.getLineLength(endLine);
				position = new Position(start, end - start);
			}

		} catch (BadLocationException e) {
			log.error(e);
		}
		return position;

	}

	protected boolean isHandled(EObject eObject) {
		return eObject.eContainer() != null && !eObject.eContents().isEmpty();
	}

	protected IFoldingRegion createFoldingRegion(Position position, EObject eObject) {
		return new DefaultFoldingRegion(position);
	}

	protected IFoldingRegion createFoldingRegion(Position position, StyledString styledString) {
		return new DefaultFoldingRegion(position, styledString);
	}

}
