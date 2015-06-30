/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ide.highlighting

import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
interface XbaseHighlightingStyles extends HighlightingStyles {
	
	String STATIC_METHOD_INVOCATION = "xbase.static.method.invocation";      
	String STATIC_FIELD = "xbase.static.field";                              
	String FIELD = "xbase.field";                                            
	String ANNOTATION = "xbase.annotation";                                  
	String EXTENSION_METHOD_INVOCATION = "xbase.extension.method.invacation";
	String DEPRECATED_MEMBERS = "xbase.deprecated.members";                  
	
}