/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server;

import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
public class Document {
	private final Integer version;

	private final String contents;

	private final boolean printSourceOnError;

	public Document(Integer version, String contents) {
		this(version, contents, true);
	}

	/**
	 * @since 2.15
	 */
	public Document(Integer version, String contents, boolean printSourceOnError) {
		this.version = version;
		this.contents = contents;
		this.printSourceOnError = printSourceOnError;
	}

	public int getOffSet(Position position) throws IndexOutOfBoundsException {
		int l = contents.length();
		char NL = '\n';
		int line = 0;
		int column = 0;
		for (int i = 0; i < l; i++) {
			char ch = contents.charAt(i);
			if (position.getLine() == line && position.getCharacter() == column) {
				return i;
			}
			if (ch == NL) {
				line++;
				column = 0;
			} else {
				column++;
			}
		}
		if (position.getLine() == line && position.getCharacter() == column) {
			return l;
		}
		throw new IndexOutOfBoundsException(position.toString() + getSourceOnError());
	}

	public Position getPosition(int offset) throws IndexOutOfBoundsException {
		int l = contents.length();
		if (offset < 0 || offset > l) {
			throw new IndexOutOfBoundsException(offset + getSourceOnError());
		}
		char NL = '\n';
		int line = 0;
		int column = 0;
		for (int i = 0; i < l; i++) {
			char ch = contents.charAt(i);
			if (i == offset) {
				return new Position(line, column);
			}
			if (ch == NL) {
				line++;
				column = 0;
			} else {
				column++;
			}
		}
		return new Position(line, column);
	}

	/**
	 * Returns with the text for a certain line without the trailing end line marker. Throws an
	 * {@link IndexOutOfBoundsException} if the zero-based {@code lineNumber} argument is negative or exceeds the number
	 * of lines in the document.
	 */
	public String getLineContent(int lineNumber) throws IndexOutOfBoundsException {
		if (lineNumber < 0) {
			throw new IndexOutOfBoundsException(lineNumber + getSourceOnError());
		}
		char NL = '\n';
		char LF = '\r';
		int l = contents.length();
		StringBuilder lineContent = new StringBuilder();
		int line = 0;
		for (int i = 0; i < l; i++) {
			if (line > lineNumber) {
				return lineContent.toString();
			}
			char ch = contents.charAt(i);
			if (line == lineNumber && ch != NL && ch != LF) {
				lineContent.append(ch);
			}
			if (ch == NL) {
				line++;
			}
		}
		if (line < lineNumber) {
			throw new IndexOutOfBoundsException(lineNumber + getSourceOnError());
		}
		return lineContent.toString();
	}
	
	/**
	 * @since 2.22
	 */
	protected String getSourceOnError() {
		String source = "";
		if (isPrintSourceOnError()) {
			source = " text was : " + contents;
		}
		return source;
	}

	/**
	 * Get the number of lines in the document. Empty document has line count: {@code 1}.
	 */
	public int getLineCount() {
		return getPosition(contents.length()).getLine() + 1;
	}

	public String getSubstring(Range range) {
		int start = getOffSet(range.getStart());
		int end = getOffSet(range.getEnd());
		return contents.substring(start, end);
	}

	/**
	 * As opposed to {@link TextEdit}[] the positions in the edits of a {@link DidChangeTextDocumentParams} refer to the
	 * state after applying the preceding edits. See
	 * https://microsoft.github.io/language-server-protocol/specification#textedit-1 and
	 * https://github.com/microsoft/vscode/issues/23173#issuecomment-289378160 for details.
	 * 
	 * @return a new document with an incremented version and the text document changes applied.
	 * @since 2.18
	 */
	public Document applyTextDocumentChanges(Iterable<? extends TextDocumentContentChangeEvent> changes) {
		Document currentDocument = this;
		Integer newVersion = null;
		if (currentDocument.version != null) {
			newVersion = Integer.valueOf(currentDocument.version.intValue() + 1);
		}
		for (TextDocumentContentChangeEvent change : changes) {
			final String newContent;
			if (change.getRange() == null) {
				newContent = change.getText();
			} else {
				int start = currentDocument.getOffSet(change.getRange().getStart());
				int end = currentDocument.getOffSet(change.getRange().getEnd());
				newContent = currentDocument.contents.substring(0, start) + change.getText()
						+ currentDocument.contents.substring(end);
			}
			currentDocument = new Document(newVersion, newContent, printSourceOnError);
		}
		return currentDocument;
	}

	/**
	 * Only use for testing.
	 * 
	 * All positions in the {@link TextEdit}s refer to the same original document (this).
	 */
	public Document applyChanges(Iterable<? extends TextEdit> changes) {
		String newContent = contents;
		for (TextEdit change : changes) {
			if (change.getRange() == null) {
				newContent = change.getNewText();
			} else {
				int start = getOffSet(change.getRange().getStart());
				int end = getOffSet(change.getRange().getEnd());
				newContent = newContent.substring(0, start) + change.getNewText() + newContent.substring(end);
			}
		}
		Integer newVersion = null;
		if (version != null) {
			newVersion = Integer.valueOf(version.intValue() + 1);
		}
		return new Document(newVersion, newContent);
	}

	/**
	 * @since 2.15
	 */
	public boolean isPrintSourceOnError() {
		return printSourceOnError;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + (printSourceOnError ? 1231 : 1237);
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		if (printSourceOnError != other.printSourceOnError)
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("version", version);
		b.add("contents", contents);
		b.add("printSourceOnError", printSourceOnError);
		return b.toString();
	}

	public Integer getVersion() {
		return version;
	}

	public String getContents() {
		return contents;
	}
}
