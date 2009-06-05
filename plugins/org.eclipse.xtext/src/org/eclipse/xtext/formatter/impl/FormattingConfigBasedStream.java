/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatter.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatter.impl.AbstractFormattingConfig.ElementLocator;
import org.eclipse.xtext.formatter.impl.AbstractFormattingConfig.LocatorType;
import org.eclipse.xtext.formatter.impl.FormattingConfig.IndentationLocatorEnd;
import org.eclipse.xtext.formatter.impl.FormattingConfig.IndentationLocatorStart;
import org.eclipse.xtext.formatter.impl.FormattingConfig.LinewrapLocator;
import org.eclipse.xtext.formatter.impl.FormattingConfig.NoLinewrapLocator;
import org.eclipse.xtext.formatter.impl.FormattingConfig.NoSpaceLocator;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormattingConfigBasedStream extends BaseTokenStream {

	protected Set<ElementLocator> activeLocators = new HashSet<ElementLocator>();

	protected List<ElementLocator> activeRangeLocators = new ArrayList<ElementLocator>();

	protected FormattingConfig cfg;

	protected int column = 0;

	protected int indentationLevel = 0;

	protected EObject last = null;

	protected boolean preserveSpaces;

	protected boolean wsIsWritten = false;

	public FormattingConfigBasedStream(ITokenStream out,
			String initialIndentation, FormattingConfig cfg,
			boolean preserveSpaces) {
		super(out);
		this.cfg = cfg;
		this.preserveSpaces = preserveSpaces;
	}

	public void collectLocators(EObject left, EObject right) {
		activeLocators.addAll(activeRangeLocators);
		List<ElementLocator> a = cfg.getAfter(left);
		activeLocators.addAll(a);
		for (ElementLocator l : a)
			if (l.getType() == LocatorType.RANGE)
				activeRangeLocators.add(l);
		List<ElementLocator> b = cfg.getBefore(right);
		activeLocators.addAll(b);
		for (ElementLocator l : b)
			if (l.getType() == LocatorType.RANGE)
				activeRangeLocators.remove(l);
	}

	public String getSummarizedSpaces() {
		boolean nospace = false;
		int wrap = wrapNeeded() ? 1 : 0;
		for (ElementLocator e : activeLocators)
			if (e instanceof LinewrapLocator)
				wrap = Math.max(wrap, ((LinewrapLocator) e).getLines());
		for (ElementLocator e : activeLocators) {
			if (e instanceof NoSpaceLocator)
				nospace = true;
			else if (e instanceof NoLinewrapLocator)
				wrap = 0;
			else if (e instanceof IndentationLocatorStart)
				indentationLevel++;
			else if (e instanceof IndentationLocatorEnd)
				indentationLevel--;
		}
		if (wrap > 0)
			return wrap(wrap);
		else if (nospace)
			return "";
		else
			return " ";
	}

	public void startCollectingLocators() {
		activeLocators.clear();
	}

	protected String wrap(int lines) {
		column = 0;
		StringBuffer r = new StringBuffer();
		for (int i = 0; i < lines; i++)
			r.append("\n");
		for (int i = 0; i < indentationLevel; i++)
			r.append(cfg.getIndentationSpace());
		return r.toString();
	}

	protected boolean wrapNeeded() {
		return cfg.getCharsPerLine() < column;
	}

	public void writeHidden(EObject grammarElement, String value)
			throws IOException {
		if (preserveSpaces) {
			if (cfg.getWhitespaceRule() != grammarElement && !wsIsWritten) {
				writeWs(grammarElement);
			}
			out.writeHidden(grammarElement, value);
			if (cfg.getWhitespaceRule() != grammarElement)
				wsIsWritten = false;
		} else if (cfg.getWhitespaceRule() != grammarElement) {
			writeWs(grammarElement);
			out.writeHidden(grammarElement, value);
			wsIsWritten = false;
		}
	}

	public void writeSemantic(EObject grammarElement, String value)
			throws IOException {
		writeWs(grammarElement);
		out.writeSemantic(grammarElement, value);
		wsIsWritten = false;
	}

	protected void writeWs(EObject grammarElement) throws IOException {
		if (last != null) {
			collectLocators(last, grammarElement);
			String space = getSummarizedSpaces();
			startCollectingLocators();
			out.writeHidden(cfg.getWhitespaceRule(), space);
		}
		last = grammarElement;
	}

}
