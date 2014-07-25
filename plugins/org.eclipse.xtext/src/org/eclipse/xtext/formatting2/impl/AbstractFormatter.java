/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.impl;

import java.util.List;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IFormatter;
import org.eclipse.xtext.formatting2.IFormatterRequest;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ITextRegionAccess;
import org.eclipse.xtext.formatting2.ITextReplacement;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractFormatter implements IFormatter {

	@Inject
	private HiddenRegionReplacer.Factory gapReplacerFactory;

	@Extension
	protected ITextRegionAccess regionAccess;

	private IFormatterRequest request = null;

	protected IFormattableDocument createFormattableDocument() {
		return new FormattableDocument.RootDocument(getRequest(), 0, gapReplacerFactory);
	}

	protected abstract void format(IFormattableDocument document);

	final public List<ITextReplacement> format(IFormatterRequest request) {
		if (this.request != null)
			throw new IllegalStateException("A formatter-object can only be used once.");
		this.request = request;
		this.regionAccess = request.getTokens();
		initalize();
		IFormattableDocument document = createFormattableDocument();
		format(document);
		return document.renderToTextReplacements();
	}

	public ITextReplacer.Factory<IHiddenRegionFormatting> getGapReplacerFactory() {
		return gapReplacerFactory;
	}

	public IFormatterRequest getRequest() {
		return request;
	}

	protected void initalize() {
	}

}
