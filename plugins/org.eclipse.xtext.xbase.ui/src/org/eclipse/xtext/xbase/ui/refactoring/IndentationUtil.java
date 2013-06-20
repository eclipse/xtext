/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.refactoring;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class IndentationUtil {
	
	public static final Logger LOG = Logger.getLogger(IndentationUtil.class);

	private IDocument document;

	@Inject
	private IWhitespaceInformationProvider whitespaceInformationProvider;
	
	private String indentString;
	
	private String lineSeparator;
	
	public void initialize(IDocument document, URI resourceURI) {
		this.document = document;
		this.indentString = whitespaceInformationProvider.getIndentationInformation(resourceURI).getIndentString();
		this.lineSeparator = whitespaceInformationProvider.getLineSeparatorInformation(resourceURI)
				.getLineSeparator();
	}
	
	public int getIndentationLevelAtOffset(int offset) {
		try {
			if (offset <= 0)
				return 0;
			int currentOffset = offset - 1;
			char currentChr = document.getChar(currentOffset);
			int indentationOffset = 0;
			while (currentChr != '\n' && currentChr != '\r' && currentOffset > 0) {
				if (Character.isWhitespace(currentChr))
					++indentationOffset;
				else
					indentationOffset = 0;
				--currentOffset;
				currentChr = document.getChar(currentOffset);
			}
			return indentationOffset / getIndentString().length();
		} catch (BadLocationException e) {
			LOG.error("Error calculating indentation at offset", e);
		}
		return 0;
	}
	
	public String indent(int level) {
		String indentString = getIndentString();
		StringBuilder indentBuilder = new StringBuilder();
		for(int i=0; i<level; ++i) 
			indentBuilder.append(indentString);
		return indentBuilder.toString();
	}
	
	public String getIndentString() {
		return indentString;
	}

	public String getLineSeparator() {
		return lineSeparator;
	}
}
