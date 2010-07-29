/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.autoedit;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.formatting.IIndentationInformation;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MultiLineTerminalsEditStrategy extends AbstractEditStrategy {

	private final static Logger log = Logger.getLogger(MultiLineTerminalsEditStrategy.class);
	
	private String leftTerminal, rightTerminal, indentationString;

	@Inject
	private IIndentationInformation indentationInformation;

	private boolean explicitIndentation;

	private String significantRightTerminalPart;

	private String significantInsertableIndentationString;
	private String significantLookupIndentationString;

	public MultiLineTerminalsEditStrategy configure(String leftTerminal, String indentationString, String rightTerminal) {
		String insignificantPrefix = getInsignificantPart(indentationString, rightTerminal);
		return configure(leftTerminal, indentationString, rightTerminal, insignificantPrefix);
	}
	
	public MultiLineTerminalsEditStrategy configure(String leftTerminal, String indentationString, String rightTerminal, String insignificantPrefix) {
		this.leftTerminal = leftTerminal;
		this.rightTerminal = rightTerminal;
		this.significantRightTerminalPart = rightTerminal.substring(insignificantPrefix.length());
		this.indentationString = indentationString == null 
				? indentationInformation.getIndentString()
				: indentationString;
		this.explicitIndentation = indentationString != null;
		if (this.explicitIndentation) {
			this.significantInsertableIndentationString = this.indentationString.substring(insignificantPrefix.length());
			this.significantLookupIndentationString = this.indentationString.trim();
		}
		return this;
	}

	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		try {
			if (command.length != 0)
				return;
			String originalText = command.text;
			String[] lineDelimiters = document.getLegalLineDelimiters();
			int delimiterIndex = TextUtilities.startsWith(lineDelimiters, originalText);
			if (delimiterIndex != -1) {
				IRegion currentLineRegion = document.getLineInformationOfOffset(command.offset);
				String currentLine = document.get(currentLineRegion.getOffset(), command.offset - currentLineRegion.getOffset());
//				currentLine = currentLine.substring(0, command.offset - currentLineRegion.getOffset());
				int lastLeftTerminal = currentLine.lastIndexOf(leftTerminal);
				if (lastLeftTerminal != -1) {
					// open left terminal
					int lastRightTerminal = currentLine.lastIndexOf(significantRightTerminalPart);
					if (lastRightTerminal == -1 || lastLeftTerminal > lastRightTerminal + leftTerminal.length()) {
						StringBuilder commandString = new StringBuilder(lastLeftTerminal + indentationString.length() + command.text.length());
						commandString.append(command.text);
						int firstNonWsCharacter = findFirstNonWsCharacter(currentLine, lastLeftTerminal);
						int numberOfSpaces = lastLeftTerminal - firstNonWsCharacter;
						appendSpaces(commandString, numberOfSpaces);
						commandString.append(indentationString);
						
						command.text = commandString.toString();
						command.caretOffset = command.offset + command.text.length();
						command.shiftsCaret = false;
						String documentContent = getDocumentContent(document, command);
						int opening = count(leftTerminal, documentContent);
						int closing = count(significantRightTerminalPart, documentContent);
						if (opening > closing) {
							commandString.append(originalText);
							appendSpaces(commandString, numberOfSpaces);
							commandString.append(rightTerminal);
							command.text = commandString.toString();
						} else {
							if (currentLine.length() < currentLineRegion.getLength()) {
								String trailingCurrentLine = document.get(currentLineRegion.getOffset(), currentLineRegion.getLength());
								trailingCurrentLine = trailingCurrentLine.substring(currentLine.length());
								int trailingRightTerminalIndex = trailingCurrentLine.indexOf(significantRightTerminalPart);
								if (trailingRightTerminalIndex != -1) {
									if (hasNonWsBefore(trailingCurrentLine, trailingRightTerminalIndex))
										return;
									commandString.append(originalText);
									appendSpaces(commandString, numberOfSpaces);
									commandString.append(rightTerminal);
									command.text = commandString.toString();
									command.length += trailingRightTerminalIndex + significantRightTerminalPart.length();
								}
							}
						}
					}
				} else if (explicitIndentation) {
					// continuous auto edit
					int indentationStringIndex = currentLine.indexOf(significantLookupIndentationString);
					if (shouldAppendIndentationString(document, command, currentLine, indentationStringIndex)) {
						StringBuilder commandString = new StringBuilder(indentationStringIndex + significantInsertableIndentationString.length() + command.text.length());
						commandString.append(command.text);
						commandString.append(significantInsertableIndentationString);
						command.text = commandString.toString();
					}
				}
			}
		} catch (BadLocationException ex) {
			log.error("Exception in AutoEditStrategy", ex);
		}
	}

	protected boolean shouldAppendIndentationString(IDocument document, DocumentCommand command, String currentLine,
			int indentationStringIndex) {
		if (indentationStringIndex == -1) 
			return false;
		String prefixInDocument = getDocumentContent(document, command).substring(0, command.offset);
		int previousLeftTerminalInDocument = prefixInDocument.lastIndexOf(leftTerminal);
		if (previousLeftTerminalInDocument == -1)
			return false;
		int previousRightTerminalInDocument = prefixInDocument.lastIndexOf(significantRightTerminalPart);
		if (previousRightTerminalInDocument != -1 && previousLeftTerminalInDocument < previousRightTerminalInDocument + leftTerminal.length())
			return false;
		if (hasNonWsBefore(currentLine, indentationStringIndex))
			return false;
		return true;
	}

	protected boolean hasNonWsBefore(String line, int index) {
		int idx = 0;
		while(idx < index) {
			if (!Character.isWhitespace(line.charAt(idx)))
				return true;
			idx++;
		}
		return false;
	}

	protected void appendSpaces(StringBuilder commandString, int count) {
		if (explicitIndentation) {
			int i = 0;
			while(i < count) {
				commandString.append(' ');
				i++;
			}
		}
	}

	protected int findFirstNonWsCharacter(String currentLine, int maxIndex) {
		int i = 0;
		while(i < maxIndex) {
			if (Character.isWhitespace(currentLine.charAt(i))) {
				i++;								
			} else {
				break;
			}
		}
		return i;
	}

	protected String getInsignificantPart(String first, String second) {
		if (first == null || second == null)
			return "";
		int minLen = Math.min(first.length(), second.length());
		for(int i = 0; i < minLen; i++) {
			if (!Character.isWhitespace(first.charAt(i)) || first.charAt(i) != second.charAt(i)) {
				return first.substring(0, i);
			}
		}
		return "";
	}
	
	/**
	 * @deprecated use {@link IDocument#getLegalLineDelimiters()} instead
	 */
	@Deprecated
	protected String getNewLine() {
		return "\n";
	}
	
}
