/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.TextEdit
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.lsp4j.Range

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@Data class Document {

    Integer version
    String contents

    def int getOffSet(Position position) {
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
        throw new IndexOutOfBoundsException(position.toString + " text was : " + contents)
    }

    def Position getPosition(int offset) {
        val l = contents.length
        if (offset < 0 || offset > l)
            throw new IndexOutOfBoundsException(offset + " text was : " + contents)

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
    
    def String getSubstring(Range range) {
    		val start = getOffSet(range.start)
    		val end = getOffSet(range.end)
    		return this.contents.substring(start, end)
    }

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

}
