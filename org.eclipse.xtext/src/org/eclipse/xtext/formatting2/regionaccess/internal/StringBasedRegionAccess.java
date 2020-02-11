/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringBasedRegionAccess extends AbstractRegionAccess {

	private final Map<EObject, AbstractEObjectRegion> eObjectToTokens = Maps.newLinkedHashMap();
	private final XtextResource resource;
	private AbstractEObjectRegion root;
	private final StringBuilder string = new StringBuilder();

	protected StringBasedRegionAccess(XtextResource resource) {
		this.resource = resource;
	}

	protected void add(AbstractEObjectRegion tokens) {
		eObjectToTokens.put(tokens.getSemanticElement(), tokens);
	}

	protected int append(String value) {
		int length = string.length();
		string.append(value);
		return length;
	}

	@Override
	public XtextResource getResource() {
		return resource;
	}

	@Override
	protected String getText() {
		return string.toString();
	}

	@Override
	public ITextSegment regionForDocument() {
		return new TextSegment(this, 0, string.length());
	}

	@Override
	public AbstractEObjectRegion regionForEObject(EObject obj) {
		return eObjectToTokens.get(obj);
	}

	@Override
	public IEObjectRegion regionForRootEObject() {
		return root;
	}

	public void setRootEObject(AbstractEObjectRegion root) {
		this.root = root;
	}

	@Override
	public String textForOffset(int offset, int length) {
		return string.substring(offset, offset + length);
	}

	@Override
	public boolean hasSyntaxError() {
		return false;
	}

}
