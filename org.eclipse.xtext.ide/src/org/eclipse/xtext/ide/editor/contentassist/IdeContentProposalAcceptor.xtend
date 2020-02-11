/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist

import java.util.Comparator
import java.util.TreeSet

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.11
 */
class IdeContentProposalAcceptor implements IIdeContentProposalAcceptor, Comparator<Pair<Integer, ContentAssistEntry>> {
    
    protected val entries = new TreeSet<Pair<Integer, ContentAssistEntry>>(this)
    
    override accept(ContentAssistEntry entry, int priority) {
        if (entry !== null) {
            if (entry.proposal === null)
                throw new IllegalArgumentException('proposal must not be null.')
            entries.add(priority -> entry)
        }
    }

    override canAcceptMoreProposals() {
        entries.size < 100
    }
    
    override compare(Pair<Integer, ContentAssistEntry> p1, Pair<Integer, ContentAssistEntry> p2) {
        val prioResult = p2.key.compareTo(p1.key)
        if (prioResult != 0)
            return prioResult
        val s1 = p1.value.label ?: p1.value.proposal
        val s2 = p2.value.label ?: p2.value.proposal
        val ignoreCase = s1.compareToIgnoreCase(s2)
        if (ignoreCase === 0) {
            return s1.compareTo(s2)
        }
        return ignoreCase
    }
    
    def Iterable<ContentAssistEntry> getEntries() {
        entries.map[value]
    }
        
}