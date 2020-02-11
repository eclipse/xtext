/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.highlighting;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingStyles;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill
 * @author Christian Schneider
 */
public class XbaseHighlightingConfiguration extends DefaultHighlightingConfiguration {
	
	public static final String STATIC_METHOD_INVOCATION = XbaseHighlightingStyles.STATIC_METHOD_INVOCATION;
	public static final String STATIC_FIELD = XbaseHighlightingStyles.STATIC_FIELD;
	public static final String FIELD = XbaseHighlightingStyles.FIELD;
	public static final String METHOD = XbaseHighlightingStyles.METHOD;
	public static final String ANNOTATION = XbaseHighlightingStyles.ANNOTATION;
	public static final String EXTENSION_METHOD_INVOCATION = XbaseHighlightingStyles.EXTENSION_METHOD_INVOCATION;
	public static final String DEPRECATED_MEMBERS = XbaseHighlightingStyles.DEPRECATED_MEMBERS;

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(STATIC_METHOD_INVOCATION, "Static method invocations", staticMethodInvocation());
		acceptor.acceptDefaultHighlighting(STATIC_FIELD, "Static fields", staticField());
		acceptor.acceptDefaultHighlighting(FIELD, "Fields", field());
		acceptor.acceptDefaultHighlighting(ANNOTATION, "Annotations", annotation());
		acceptor.acceptDefaultHighlighting(EXTENSION_METHOD_INVOCATION, "Extension method invocations", extensionMethodInvocation());
		acceptor.acceptDefaultHighlighting(DEPRECATED_MEMBERS, "Deprecated members", deprecatedMembers());
		
		acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.INTERFACE, "Interfaces", interfaces());
		acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.ENUM, "Enums", enums());
		acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.CLASS, "Classes", classes());
		acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.ABSTRACT_CLASS, "Abstract classes", abstractClasses());
		
		acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.STATIC_FINAL_FIELD, "Static final fields", staticFinalField());
		
		// not supported yet
		// acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.INHERITED_FIELD, "Inherited fields", inheritedField());
		
		acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.METHOD, "Methods", method());
		acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.ABSTRACT_METHOD_INVOCATION, "Abstract method invocations", abstractMethodInvocation());
		
		// not supported yet
		// acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.INHERITED_METHOD_INVOCATION, "Inherited method invocations", inheritedMethodInvocation());
		
		acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.LOCAL_VARIABLE, "Local variables", localVariable());
		acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.LOCAL_VARIABLE_DECLARATION, "Local variable declarations", localVariableDecl());
		acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE, "Local final variables", localFinalVariable());
		acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.LOCAL_FINAL_VARIABLE_DECLARATION, "Local final variable declarations", localFinalVariableDecl());
		acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.PARAMETER_VARIABLE, "Parameter variables", parameterVariable());
		acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.TYPE_VARIABLE, "Type variables", typeVariable());
		
		acceptor.acceptDefaultHighlighting(XbaseHighlightingStyles.TYPE_ARGUMENT, "Type arguments", typeArgument());
		
		super.configure(acceptor);
	}
	

	public TextStyle staticMethodInvocation() {
		TextStyle textStyle = method().copy();
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}
	
	public TextStyle staticField() {
		TextStyle textStyle = field().copy();
		textStyle.setStyle(SWT.ITALIC);
		textStyle.setColor(new RGB(0, 0, 192));
		return textStyle;
	}
	
	public TextStyle field() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 26, 171));
		return textStyle;
	}
	
	public TextStyle annotation() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(100,100,100));
		return textStyle;
	}
	
	public TextStyle extensionMethodInvocation() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(171, 48, 0));
		return textStyle;
	}
	
	public TextStyle deprecatedMembers() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setStyle(TextAttribute.STRIKETHROUGH);
		return textStyle;
	}

	public TextStyle interfaces() {
		return defaultTextStyle().copy();
	}

	public TextStyle enums() {
		return defaultTextStyle().copy();
	}
	
	public TextStyle classes() {
		return defaultTextStyle().copy();
	}
	
	public TextStyle abstractClasses() {
		return classes().copy();
	}
	
	public TextStyle staticFinalField() {
		return staticField().copy();
	}
	
	public TextStyle inheritedField() {
		return field().copy();
	}
	
	public TextStyle method() {
		return defaultTextStyle().copy();
	}
	
	public TextStyle abstractMethodInvocation() {
		return method().copy();
	}
	
	public TextStyle inheritedMethodInvocation() {
		return method().copy();
	}
	
	public TextStyle localVariable() {
		return defaultTextStyle().copy();
	}
	
	public TextStyle localVariableDecl() {
		return localVariable().copy();
	}
	
	public TextStyle localFinalVariable() {
		return localVariable().copy();
	}
	
	public TextStyle localFinalVariableDecl() {
		return localFinalVariable().copy();
	}
	
	public TextStyle parameterVariable() {
		return localVariable().copy();
	}
		
	public TextStyle typeVariable() {
		return typeArgument().copy();
	}
	
	public TextStyle typeArgument() {
		return defaultTextStyle().copy();
	}
}
