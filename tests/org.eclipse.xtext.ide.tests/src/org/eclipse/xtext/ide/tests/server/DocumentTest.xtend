/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import io.typefox.lsapi.PositionImpl
import io.typefox.lsapi.RangeImpl
import io.typefox.lsapi.TextEditImpl
import org.eclipse.xtext.ide.server.Document
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author efftinge - Initial contribution and API
 */
class DocumentTest {
    
    @Test def void testOffSet() {
        new Document(1, '''
            hello world
            foo
            bar
        ''') => [
            assertEquals(0, getOffSet(position(0,0)))
            assertEquals(11, getOffSet(position(0,11)))
            try {
                getOffSet(position(0, 12))
                fail()
            } catch (IndexOutOfBoundsException e) {
                //expected
            }
            assertEquals(12, getOffSet(position(1,0)))
            assertEquals(13, getOffSet(position(1,1)))
            assertEquals(14, getOffSet(position(1,2)))
            assertEquals(16, getOffSet(position(2,0)))
            assertEquals(19, getOffSet(position(2,3)))
        ]
    }
    
    @Test def void testOffSet_empty() {
        new Document(1, "") => [
            assertEquals(0, getOffSet(position(0,0)))
            try {
                getOffSet(position(0, 12))
                fail()
            } catch (IndexOutOfBoundsException e) {
                //expected
            }
        ]
    }
    
    @Test def void testUpdate_01() {
        new Document(1, '''
            hello world
            foo
            bar
        ''') => [
            assertEquals('''
                hello world
                bar
            '''.toString, applyChanges(#[
                change(position(1,0), position(2,0), "")
            ]).contents)
        ]
    }
    
    @Test def void testUpdate_02() {
        new Document(1, '''
            hello world
            foo
            bar
        ''') => [
            assertEquals('''
                hello world
                future
                bar
            '''.toString, applyChanges(#[
                change(position(1,1), position(1,3), "uture")
            ]).contents)
        ]
    }
    
    @Test def void testUpdate_03() {
        new Document(1, '''
            hello world
            foo
            bar''') => [
            assertEquals('', applyChanges(#[
                change(position(0,0), position(2,3), "")
            ]).contents)
        ]
    }
    
    private def change(PositionImpl startPos, PositionImpl endPos, String newText) {
        new TextEditImpl => [
              range = new RangeImpl => [
                  start = startPos
                  end = endPos
              ]
              it.newText = newText
            ]
    }
    
    private def position(int l, int c) {
        new PositionImpl => [line=l character=c]
    }
    
}