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
 * @author Christian Schneider
 */
interface XbaseHighlightingStyles extends HighlightingStyles {

	String INTERFACE = "xbase.interface";
	String ENUM = "xbase.enum";
	String CLASS = "xbase.class";
	String ABSTRACT_CLASS = "xbase.abstract.class";
	
	String ANNOTATION = "xbase.annotation";
	
	String FIELD = "xbase.field";
	String STATIC_FIELD = "xbase.static.field";
	String STATIC_FINAL_FIELD = "xbase.static.final.field";
	
	// not supported yet
	// String INHERITED_FIELD = "xbase.inherited.field";
	
	String METHOD = "xbase.method";
	String STATIC_METHOD_INVOCATION = "xbase.static.method.invocation";      
	String ABSTRACT_METHOD_INVOCATION = "xbase.abstract.method.invocation";
	String EXTENSION_METHOD_INVOCATION = "xbase.extension.method.invacation";
	
	// not supported yet
	// String INHERITED_METHOD_INVOCATION = "xbase.inherited.method.invacation";
	
	String DEPRECATED_MEMBERS = "xbase.deprecated.members";
	
	String LOCAL_VARIABLE = "xbase.local.variable";
	String LOCAL_VARIABLE_DECLARATION = "xbase.local.variable.declaration";
	String LOCAL_FINAL_VARIABLE = "xbase.local.final.variable"
	String LOCAL_FINAL_VARIABLE_DECLARATION = "xbase.local.final.variable.declaration"
	
	String PARAMETER_VARIABLE = "xbase.parameter.variable";
	String TYPE_VARIABLE = "xbase.type.variable";
	
	String TYPE_ARGUMENT = "xbase.type.argument";	
	
	String AUTOBOXING = "xbase.autoboxing";
}