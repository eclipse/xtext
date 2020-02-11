/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import java.util.List
import org.eclipse.xtext.ide.server.TopologicalSorter
import org.eclipse.xtext.resource.impl.ProjectDescription
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class BuildOrderTest {
    
    @Test
    def testChain() {
        val a = new ProjectDescription => [ name = 'a' dependencies=#['b'] ]
        val b = new ProjectDescription => [ name = 'b' dependencies=#['c'] ]
        val c = new ProjectDescription => [ name = 'c' dependencies=#['d'] ]
        val d = new ProjectDescription => [ name = 'd' dependencies=#[] ]
        assertEquals(#[d,c,b,a], new TopologicalSorter().sortByDependencies(#[a,b,c,d], [
            fail
        ]))
    }
    
    @Test
    def testDiamond() {
        val a = new ProjectDescription => [ name = 'a' dependencies=#['b', 'c'] ]
        val b = new ProjectDescription => [ name = 'b' dependencies=#['c'] ]
        val c = new ProjectDescription => [ name = 'c' dependencies=#['d'] ]
        val d = new ProjectDescription => [ name = 'd' dependencies=#[] ]
        assertEquals(#[d,c,b,a], new TopologicalSorter().sortByDependencies(#[a,b,c,d], [
            fail
        ]))
    }
    
    @Test
    def testDiamond_1() {
        val a = new ProjectDescription => [ name = 'a' dependencies=#['b', 'c', 'd'] ]
        val b = new ProjectDescription => [ name = 'b' dependencies=#['c'] ]
        val c = new ProjectDescription => [ name = 'c' dependencies=#['d'] ]
        val d = new ProjectDescription => [ name = 'd' dependencies=#[] ]
        assertEquals(#[d,c,b,a], new TopologicalSorter().sortByDependencies(#[a,b,c,d], [
            fail
        ]))
    }
    
    @Test
    def testJustOne() {
        val a = new ProjectDescription => [ name = 'a' dependencies=#['b'] ]
        val b = new ProjectDescription => [ name = 'b' ]
        assertEquals(#[a], new TopologicalSorter().sortByDependencies(#[a], [fail]))
        assertEquals(#[b], new TopologicalSorter().sortByDependencies(#[b], [fail]))
    }

    
    @Test
    def testCycle() {
        val a = new ProjectDescription => [ name = 'a' dependencies=#['b', 'c'] ]
        val b = new ProjectDescription => [ name = 'b' dependencies=#['c', 'd'] ]
        val c = new ProjectDescription => [ name = 'c' dependencies=#['d'] ]
        val d = new ProjectDescription => [ name = 'd' dependencies=#['b'] ]
        val e = new ProjectDescription => [ name = 'e' dependencies=#[] ]
        val cyclic = newArrayList
        assertEquals(#[e], new TopologicalSorter().sortByDependencies(#[a,b,c,d,e], [cyclic.add(it)]))
        assertEquals(#[b,d,c,a], cyclic)
    }
    
    @Test
    def testCycle1() {
        val a = new ProjectDescription => [ name = 'a' dependencies=#['a'] ]
        val cyclic = newArrayList
        assertEquals(#[], new TopologicalSorter().sortByDependencies(#[a], [cyclic.add(it)]))
        assertEquals(#[a], cyclic)
    }

    def assertEquals(List<ProjectDescription> expected, List<ProjectDescription> actual) {
        assertEquals('''Expected: «expected.asString» but was «actual.asString»''', expected, actual)
    }
    
    def asString(List<ProjectDescription> list) {
        list.map[name].join(', ')
    }
}