/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import io.typefox.lsapi.Position
import io.typefox.lsapi.TextEdit
import org.eclipse.xtend.lib.annotations.Data

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@Data class Document {
    
    int version
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
        throw new IndexOutOfBoundsException(position.toString + " text was : "+contents)
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
        return new Document(version + 1, newContent)
    }
    
}