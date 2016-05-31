/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.syntaxcoloring

/**
 * @author Sven Efftinge - Initial contribution and API
 */
interface IEditorHighlightingConfigurationProvider {
    
    def String getConfiguration(String editorName)
}