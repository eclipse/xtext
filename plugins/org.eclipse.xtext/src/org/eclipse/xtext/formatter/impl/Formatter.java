/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatter.impl;

import java.util.List;

import org.eclipse.xtext.formatter.IFormattableDocument;
import org.eclipse.xtext.formatter.IFormatter;
import org.eclipse.xtext.formatter.IGapFormatting;
import org.eclipse.xtext.formatter.ITextReplacement;
import org.eclipse.xtext.formatter.ITextReplacer;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class Formatter implements IFormatter {

	public interface Impl {
		public void format(IFormattableDocument document);
	}

	public class NullFormatter implements Impl {
		public NullFormatter() {
			super();
		}

		public void format(IFormattableDocument document) {
		}
	}

	@Inject
	private GapReplacer.Factory gapReplacerFactory;

	protected IFormattableDocument createFormattableDocument(Request request) {
		return new FormattableDocument.RootDocument(request, 0, gapReplacerFactory);
	}

	protected Impl createFormatterImpl(Request request) {
		return new NullFormatter();
	}

	public List<ITextReplacement> format(Request request) {
		IFormattableDocument document = createFormattableDocument(request);
		Impl formatter = createFormatterImpl(request);
		formatter.format(document);
		return document.renderToTextReplacements();
	}

	public ITextReplacer.Factory<IGapFormatting> getGapReplacerFactory() {
		return gapReplacerFactory;
	}

}
