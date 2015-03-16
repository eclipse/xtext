/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringBasedRegionAccess extends AbstractRegionAccess {

	private final Map<EObject, AbstractEObjectTokens> eObjectToTokens = Maps.newLinkedHashMap();
	private final XtextResource resource;
	private AbstractEObjectTokens root;
	private final StringBuilder string = new StringBuilder();

	protected StringBasedRegionAccess(XtextResource resource) {
		this.resource = resource;
	}

	protected void add(AbstractEObjectTokens tokens) {
		eObjectToTokens.put(tokens.getSemanticElement(), tokens);
	}

	protected int append(String value) {
		int length = string.length();
		string.append(value);
		return length;
	}

	@Override
	public ITextSegment expandRegionsByLines(int leadingLines, int trailingLines, ITextSegment... regions) {
		return null;
	}

	@Override
	public IHiddenRegion getFirstRegionInFile() {
		return root.getLeadingGap();
	}

	@Override
	public int getLength() {
		return string.length();
	}

	@Override
	public XtextResource getResource() {
		return resource;
	}

	@Override
	public String getText() {
		return string.toString();
	}

	@Override
	public String getText(int offset, int length) {
		return string.substring(offset, offset + length);
	}

	@Override
	protected AbstractEObjectTokens getTokens(EObject obj) {
		return eObjectToTokens.get(obj);
	}

	@Override
	public boolean hasSyntaxError() {
		return false;
	}

	@Override
	public boolean hasSyntaxError(EObject object) {
		return false;
	}

	@Override
	public ITextSegment indentationRegion(int offset) {
		return null;
	}

	public void setRootEObject(AbstractEObjectTokens root) {
		this.root = root;
	}

}
