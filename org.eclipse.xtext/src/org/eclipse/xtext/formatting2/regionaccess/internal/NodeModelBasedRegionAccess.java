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
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.resource.XtextResource;

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
	public AbstractEObjectRegion regionForEObject(EObject obj) {
		AbstractEObjectRegion region = eObjectToTokens.get(obj);
		if (region == null && obj != null && obj.eResource() != resource) {
			throw new IllegalArgumentException("ITextRegionAccess.regionForEObject may not be called for resource external EObjects.");
		}
		return region;
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
	public boolean hasSyntaxError() {
		return resource.getParseResult().hasSyntaxErrors();
	}

}
