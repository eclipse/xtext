/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.contentassist;

import static org.eclipse.xtext.util.Strings.*;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextUtilities;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class WhitespaceHelper {

	private static Logger LOG = Logger.getLogger(WhitespaceHelper.class);

	private int offset;

	private int length;

	private String prefix;

	private String suffix;

	private String lineSeparator;

	public void initialize(IDocument document, int offset, int length, boolean ensureEmptyLinesAround) {
		this.offset = offset;
		this.length = length;
		this.lineSeparator = TextUtilities.getDefaultLineDelimiter(document);
		if (ensureEmptyLinesAround) {
			prefix = calculateLeadingWhitespace(document);
			suffix = calculateTrailingWhitespace(document);
		}
	}

	public int getTotalOffset() {
		return offset;
	}

	public int getTotalLength() {
		return length;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	protected String calculateLeadingWhitespace(IDocument document) {
		try {
			IRegion line = document.getLineInformationOfOffset(offset);
			if (line != null) {
				String linePrefix = document.get(line.getOffset(), offset - line.getOffset());
				if (isEmpty(linePrefix.trim())) {
					int lineNr = document.getLineOfOffset(offset);
					if (lineNr > 0) {
						IRegion lineInformation = document.getLineInformation(lineNr - 1);
						if (isEmpty(document.get(lineInformation.getOffset(), lineInformation.getLength()).trim())) {
							int lineDelimiterLength = document.getLineDelimiter(lineNr - 1).length();
							int skipLeadingWhitespace = linePrefix.length() + lineDelimiterLength;
							offset -= skipLeadingWhitespace;
							length += skipLeadingWhitespace;
							return lineSeparator;
						} else {
							return lineSeparator;
						}
					}
				} else {
					return lineSeparator + lineSeparator;
				}
			}
		} catch (BadLocationException e) {
			LOG.error("Error calculating leading whitespace", e);
		}
		return null;
	}

	protected String calculateTrailingWhitespace(IDocument document) {
		try {
			IRegion line = document.getLineInformationOfOffset(offset + length);
			if (line != null) {
				String lineSuffix = document.get(offset + length,
						line.getLength() - (offset + length - line.getOffset()));
				if (isEmpty(lineSuffix.trim())) {
					length += lineSuffix.length();
					int lineNr = document.getLineOfOffset(offset + length);
					if (lineNr < document.getNumberOfLines() - 1) {
						IRegion lineInformation = document.getLineInformation(lineNr + 1);
						if (!isEmpty(document.get(lineInformation.getOffset(), lineInformation.getLength()).trim())) {
							return lineSeparator;
						}
					}
				} else {
					for (int i = 0; i < lineSuffix.length(); ++i) {
						if (Character.isWhitespace(lineSuffix.charAt(i)))
							++length;
						else
							break;
					}
					return lineSeparator + lineSeparator;
				}
			}
		} catch (BadLocationException e) {
			LOG.error("Error calculating trailing whitespace", e);
		}
		return null;
	}
}
