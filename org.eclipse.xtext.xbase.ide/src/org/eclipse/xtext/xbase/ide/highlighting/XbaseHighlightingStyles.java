/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ide.highlighting;

import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Christian Schneider
 */
public interface XbaseHighlightingStyles extends HighlightingStyles {
	String INTERFACE = "xbase.interface";

	String ENUM = "xbase.enum";

	String CLASS = "xbase.class";

	String ABSTRACT_CLASS = "xbase.abstract.class";

	String ANNOTATION = "xbase.annotation";

	String FIELD = "xbase.field";

	String STATIC_FIELD = "xbase.static.field";

	String STATIC_FINAL_FIELD = "xbase.static.final.field";

	String METHOD = "xbase.method";

	String STATIC_METHOD_INVOCATION = "xbase.static.method.invocation";

	String ABSTRACT_METHOD_INVOCATION = "xbase.abstract.method.invocation";

	String EXTENSION_METHOD_INVOCATION = "xbase.extension.method.invacation";

	String DEPRECATED_MEMBERS = "xbase.deprecated.members";

	String LOCAL_VARIABLE = "xbase.local.variable";

	String LOCAL_VARIABLE_DECLARATION = "xbase.local.variable.declaration";

	String LOCAL_FINAL_VARIABLE = "xbase.local.final.variable";

	String LOCAL_FINAL_VARIABLE_DECLARATION = "xbase.local.final.variable.declaration";

	String PARAMETER_VARIABLE = "xbase.parameter.variable";

	String TYPE_VARIABLE = "xbase.type.variable";

	String TYPE_ARGUMENT = "xbase.type.argument";
}
