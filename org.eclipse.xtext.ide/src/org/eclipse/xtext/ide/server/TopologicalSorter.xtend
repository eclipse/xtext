/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import java.util.LinkedHashSet
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.resource.impl.ProjectDescription
import org.eclipse.xtext.util.IAcceptor

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
class TopologicalSorter {

    LinkedHashSet<ProjectDescription> result
    Map<String, Entry> name2entry
    IAcceptor<ProjectDescription> cyclicAcceptor
        
    def List<ProjectDescription> sortByDependencies(Iterable<ProjectDescription> descriptions, (ProjectDescription)=>void cyclicAcceptor) {
        this.cyclicAcceptor = cyclicAcceptor
        name2entry = descriptions.map[new Entry(it)].toMap[description.name]
        result = newLinkedHashSet
        name2entry.values.forEach [
            visit
        ]
        result.toList
    }
    
    protected def boolean visit(Entry current) {
        if(!result.contains(current.description) && !current.cyclic) {
            if(current.marked) {
                current.markCyclic
                return false                
            }
            current.marked = true
            for(it: current.description.dependencies) {
                val depEntry = name2entry.get(it)
                if(depEntry !== null && !depEntry.visit) {
                    current.markCyclic     
                    return false
                }
            }
            current.marked = false
            result.add(current.description)
        }        
        return true
    }
    
    protected def markCyclic(Entry it) {
        if(!cyclic)  {
            cyclic = true
            cyclicAcceptor.accept(description)     
        }
    }
    
    @FinalFieldsConstructor
    protected static class Entry {
        val ProjectDescription description
        boolean marked
        boolean cyclic
        
        override toString() {
            description.name
        }
    }
}