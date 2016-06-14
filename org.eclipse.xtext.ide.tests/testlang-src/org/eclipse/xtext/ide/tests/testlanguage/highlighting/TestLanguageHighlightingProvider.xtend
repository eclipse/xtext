/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.highlighting

import org.eclipse.xtext.ide.editor.syntaxcoloring.IEditorHighlightingConfigurationProvider

/**
 * @author efftinge - Initial contribution and API
 */
class TestLanguageHighlightingProvider implements IEditorHighlightingConfigurationProvider {
    
    override getConfiguration(String editorName) {
        if (editorName == 'EclipseChe' || editorName == 'EclipseOrion') {
            return '''
                 [
                   {include: "orion.lib#string_doubleQuote"},
                   {include: "orion.lib#string_singleQuote"},
                   {include: "orion.lib#brace_open"},
                   {include: "orion.lib#brace_close"},
                   {include: "orion.lib#bracket_open"},
                   {include: "orion.lib#bracket_close"},
                   {include: "orion.lib#parenthesis_open"},
                   {include: "orion.lib#parenthesis_close"},
                   {include: "orion.lib#number_decimal"},
                   {include: "orion.lib#number_hex"},
                   {
                     match: "\\\\b(?:type|string|int|boolean)\\\\b", 
                     name: "keyword.json" 
                   }
                 ]
            '''
        } else {
            return '''
            '''
        }
    }
    
}