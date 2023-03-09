/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;

public class HoverContext {
	private final Document document;

	private final XtextResource resource;

	private final int offset;

	private final ITextRegion region;

	private final EObject element;

	public HoverContext(Document document, XtextResource resource, int offset, ITextRegion region, EObject element) {
		this.document = document;
		this.resource = resource;
		this.offset = offset;
		this.region = region;
		this.element = element;
	}

	public Document getDocument() {
		return document;
	}

	public XtextResource getResource() {
		return resource;
	}

	public int getOffset() {
		return offset;
	}

	public ITextRegion getRegion() {
		return region;
	}

	public EObject getElement() {
		return element;
	}

	@Override
	public String toString() {
		return "HoverContext [document=" + document + ", resource=" + (resource == null ? "null" : resource.getURI())
				+ ", offset=" + offset + ", region=" + region + ", element="
				+ (element == null ? "null" : EcoreUtil.getURI(element)) + "]";
	}

}
