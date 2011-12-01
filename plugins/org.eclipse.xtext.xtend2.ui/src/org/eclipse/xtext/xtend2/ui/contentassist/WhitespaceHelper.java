/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.contentassist;

import static org.eclipse.xtext.util.Strings.*;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class WhitespaceHelper {

	private static Logger LOG = Logger.getLogger(WhitespaceHelper.class);

	private IDocument document;

	private int offset;

	private int length;

	private String prefix;

	private String suffix;

	public void initialize(IDocument document, int offset, int length, boolean ensureEmptyLinesAround) {
		this.document = document;
		this.offset = offset;
		this.length = length;
		if (ensureEmptyLinesAround) {
			prefix = calculateLeadingWhitespace();
			suffix = calculateTrailingWhitespace();
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

	protected String calculateLeadingWhitespace() {
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
							return "\n";
						} else {
							return "\n";
						}
					}
				} else {
					return "\n\n";
				}
			}
		} catch (BadLocationException e) {
			LOG.error("Error ensuring regex in document", e);
		}
		return null;
	}

	protected String calculateTrailingWhitespace() {
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
							return "\n";
						}
					}
				} else {
					for (int i = 0; i < lineSuffix.length(); ++i) {
						if (Character.isWhitespace(lineSuffix.charAt(i)))
							++length;
						else
							break;
					}
					return "\n\n";
				}
			}
		} catch (BadLocationException e) {
			LOG.error("Error ensuring regex in document", e);
		}
		return null;
	}
}
