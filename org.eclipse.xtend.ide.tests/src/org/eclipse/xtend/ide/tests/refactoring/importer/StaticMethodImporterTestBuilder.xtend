/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring.importer

import com.google.inject.Inject
import java.util.regex.Pattern
import org.eclipse.jface.text.TextSelection
import org.eclipse.xtend.ide.refactoring.importer.StaticMethodImporter
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.ui.editor.model.IXtextDocument

import static org.junit.Assert.assertEquals
import static org.junit.Assert.fail
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil

/**
 * Usage is:
 * 
 * <pre>
 * 'test.Test.xtend'.create('''
 *      package test
 *          
 *      import test.other.Other
 *          
 *      class Test {
 *          def test() {
 *              Other.doSo|mething('test')
 *          }
 *      }
 * ''').assertResult('''
 *      package test
 *          
 *      import static test.other.Other.doSomething
 *          
 *      class Test {
 *          def test() {
 *              doSomething('test')
 *          }
 *      }
 * ''')
 * </pre>
 * 
 * | or <|> are used to mark the selection in the document.
 * 
 * @author vivien.jovet - Initial contribution and API
 */
class StaticMethodImporterTestBuilder {

    @Inject
    SyncUtil syncUtil

    @Inject
    extension StaticMethodImporter staticMethodImporter

    @Inject
    extension WorkbenchTestHelper workbenchTestHelper

    val primaryPositionMarker = '<|>'
    val secondaryPositionMarker = '|'
    String result

    /**
     * Creates an Xtend file with the given content and perform the import static operation on it.
     */
    def create(String fileName, String content) {
        val positionMarker = content.positionMarker
        val file = createFile(fileName, content.replace(positionMarker, ''))
        val caretOffset = content.indexOf(positionMarker)
        val document = file.openEditor.document
        syncUtil.totalSync(true)
        doImportStaticMethod(document, caretOffset)
        result = document.get
        this
    }

    def protected boolean doImportStaticMethod(IXtextDocument document, int caretOffset) {
        document.importStaticMethod(new TextSelection(caretOffset, 1))
    }

    /**
     * Asserts that the given string is the same as the refactored document content.
     */
    def assertResult(String expected) {
        assertEquals(expected, result)
    }

    def protected getPositionMarker(String content) {
        if (content.count(primaryPositionMarker) == 1)
            primaryPositionMarker
        else if (content.count(secondaryPositionMarker) == 1)
            secondaryPositionMarker
        else
            fail('''«primaryPositionMarker» may be used to disambiguate ordinary «secondaryPositionMarker» from a position marker!''')
    }

    def protected count(String model, String positionMarker) {
        val regex = Pattern.quote(positionMarker)
        model.split(regex).length - 1
    }

}
