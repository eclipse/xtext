/*******************************************************************************
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.TextEdit
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.lsp4j.DidChangeTextDocumentParams
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextDocumentContentChangeEvent

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@Data class Document {

    Integer version
    String contents
    boolean printSourceOnError

    new(Integer version, String contents) {
        this(version, contents, true)
    }

    /**
     * @since 2.15
     */
    new(Integer version, String contents, boolean printSourceOnError) {
        this.version = version
        this.contents = contents
        this.printSourceOnError = printSourceOnError
    }

    def int getOffSet(Position position) throws IndexOutOfBoundsException {
        val l = contents.length
        val char NL = '\n'
        var line = 0
        var column = 0
        for (var i = 0; i < l; i++) {
            val ch = contents.charAt(i)
            if (position.line === line && position.character === column) {
                return i
            }
            if (ch === NL) {
                line++
                column = 0
            } else {
                column++
            }
        }
        if (position.line === line && position.character === column) {
            return l
        }
        throw new IndexOutOfBoundsException(position.toString + if (printSourceOnError) "" else (" text was : " + contents))
    }

    def Position getPosition(int offset) throws IndexOutOfBoundsException{
        val l = contents.length
        if (offset < 0 || offset > l)
            throw new IndexOutOfBoundsException(offset + if (printSourceOnError) "" else (" text was : " + contents))

        val char NL = '\n'
        var line = 0
        var column = 0
        for (var i = 0; i < l; i++) {
            val ch = contents.charAt(i)
            if (i === offset) {
                return new Position(line, column)
            }
            if (ch === NL) {
                line++
                column = 0
            } else {
                column++
            }
        }
        return new Position(line, column)
    }

    /**
     * Returns with the text for a certain line without the trailing end line marker. Throws an {@link IndexOutOfBoundsException} if the zero-based {@code lineNumber}
     * argument is negative or exceeds the number of lines in the document.
     */
    def String getLineContent(int lineNumber) throws IndexOutOfBoundsException {
        if (lineNumber < 0) {
            throw new IndexOutOfBoundsException(lineNumber + if (printSourceOnError) "" else (" text was : " + contents));
        }
        val char NL = '\n';
        val char LF = '\r';
        val l = contents.length;
        val lineContent = new StringBuilder;
        var line = 0;
        for (var i = 0; i < l; i++) {
            if (line > lineNumber) {
                return lineContent.toString;
            }
            val ch = contents.charAt(i);
            if (line === lineNumber && ch !== NL && ch !== LF) {
                lineContent.append(ch);
            }
            if (ch === NL) {
                line++;
            }
        }
        if (line < lineNumber) {
            throw new IndexOutOfBoundsException(lineNumber + if (printSourceOnError) "" else (" text was : " + contents));
        }
        return lineContent.toString;
    }

    /**
     * Get the number of lines in the document. Empty document has line count: {@code 1}.
     */
    def int getLineCount() {
        return getPosition(contents.length).line + 1;
    }

    def String getSubstring(Range range) {
    		val start = getOffSet(range.start)
    		val end = getOffSet(range.end)
    		return this.contents.substring(start, end)
    }

    /**
     * As opposed to {@link TextEdit}[] the positions in the edits of a 
     * {@link DidChangeTextDocumentParams} refer to the state after applying the preceding edits. See 
     * https://microsoft.github.io/language-server-protocol/specification#textedit-1 and 
     * https://github.com/microsoft/vscode/issues/23173#issuecomment-289378160 for details.
     * 
     * @return a new document with an incremented version and the text document changes applied.
     * @since 2.18
     */
    def Document applyTextDocumentChanges(Iterable<? extends TextDocumentContentChangeEvent> changes) {
        var currentDocument = this
        val newVersion = if (currentDocument.version !== null)
                currentDocument.version + 1
            else
                null
        for (change : changes) {
            val newContent = if (change.range === null) {
                    change.text
                } else {
                    val start = currentDocument.getOffSet(change.range.start)
                    val end = currentDocument.getOffSet(change.range.end)
                    currentDocument.contents.substring(0, start) + change.text + currentDocument.contents.substring(end)
                }
            currentDocument = new Document(newVersion, newContent, printSourceOnError)
        }
        return currentDocument
    }

    /**
     * Only use for testing.
     * 
     * All positions in the {@link TextEdit}s refer to the same original document (this).
     */
    def Document applyChanges(Iterable<? extends TextEdit> changes) {
        var newContent = contents
        for (change : changes) {
            if (change.range === null) {
                newContent = change.newText
            } else {
                val start = getOffSet(change.range.start)
                val end = getOffSet(change.range.end)
                newContent = newContent.substring(0, start) + change.newText + newContent.substring(end)
            }
        }
        return new Document(if (version !== null) version + 1 else null, newContent)
    }

    /**
     * @since 2.15
     */
    @Pure
    def boolean isPrintSourceOnError() {
    	printSourceOnError
    }

}
