/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NodeModelBasedRegionAccess extends AbstractRegionAccess {

	private final Map<EObject, AbstractEObjectRegion> eObjectToTokens;
	private final XtextResource resource;

	protected NodeModelBasedRegionAccess(NodeModelBasedRegionAccessBuilder builder) {
		this.resource = builder.getXtextResource();
		this.eObjectToTokens = ImmutableMap.copyOf(builder.getEObjectToTokensMap(this));
	}

	@Override
	public XtextResource getResource() {
		return this.resource;
	}

	@Override
	protected String getText() {
		return getResource().getParseResult().getRootNode().getText();
	}

	@Override
	public String textForOffset(int offset, int length) {
		return getResource().getParseResult().getRootNode().getText().substring(offset, offset + length);
	}

	@Override
	public boolean hasSyntaxError() {
		return getResource().getParseResult().hasSyntaxErrors();
	}

	@Override
	public boolean hasSyntaxError(EObject object) {
		BidiTreeIterator<INode> it = NodeModelUtils.getNode(object).getAsTreeIterable().iterator();
		while (it.hasNext()) {
			if (it.next().getSyntaxErrorMessage() != null)
				return true;
		}
		return false;
	}

	@Override
	public AbstractEObjectRegion regionForEObject(EObject obj) {
		return eObjectToTokens.get(obj);
	}

	@Override
	public IEObjectRegion regionForRootEObject() {
		return regionForEObject(resource.getContents().get(0));
	}

	@Override
	public ITextSegment regionForDocument() {
		return new TextSegment(this, 0, resource.getParseResult().getRootNode().getTotalEndOffset());
	}

	@Override
	public List<IEObjectRegion> regionsForAllEObjects() {
		return ImmutableList.<IEObjectRegion> copyOf(eObjectToTokens.values());
	}

}
