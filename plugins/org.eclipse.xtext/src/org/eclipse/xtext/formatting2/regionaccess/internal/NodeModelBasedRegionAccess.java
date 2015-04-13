/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.ImmutableMap;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NodeModelBasedRegionAccess extends AbstractRegionAccess {

	private final Map<EObject, AbstractEObjectRegion> eObjectToTokens;
	private final IHiddenRegion firstRegion;
	private final XtextResource resource;

	protected NodeModelBasedRegionAccess(NodeModelBasedRegionAccessBuilder builder) {
		this.resource = builder.getXtextResource();
		this.eObjectToTokens = ImmutableMap.copyOf(builder.getEObjectToTokensMap(this));
		this.firstRegion = builder.getFirstRegion();
	}

	@Override
	public IHiddenRegion getFirstRegionInFile() {
		return this.firstRegion;
	}

	@Override
	public int getLength() {
		return getResource().getParseResult().getRootNode().getTotalEndOffset();
	}

	@Override
	public XtextResource getResource() {
		return this.resource;
	}

	@Override
	public String getText() {
		return getResource().getParseResult().getRootNode().getText();
	}

	@Override
	public String getText(int offset, int length) {
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

}
