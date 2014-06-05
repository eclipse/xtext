/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.highlighting;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill
 */
public class XbaseHighlightingConfiguration extends DefaultHighlightingConfiguration {
	
	public static final String STATIC_METHOD_INVOCATION = "xbase.static.method.invocation";
	public static final String STATIC_FIELD = "xbase.static.field";
	public static final String FIELD = "xbase.field";
	public static final String ANNOTATION = "xbase.annotation";
	public static final String EXTENSION_METHOD_INVOCATION = "xbase.extension.method.invacation";
	public static final String DEPRECATED_MEMBERS = "xbase.deprecated.members";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(STATIC_METHOD_INVOCATION, "Static method invocation", staticMethodInvocation());
		acceptor.acceptDefaultHighlighting(STATIC_FIELD, "Static Field", staticField());
		acceptor.acceptDefaultHighlighting(FIELD, "Field", field());
		acceptor.acceptDefaultHighlighting(ANNOTATION, "Annotation", annotation());
		acceptor.acceptDefaultHighlighting(EXTENSION_METHOD_INVOCATION, "Extension method invocation", extensionMethodInvocation());
		acceptor.acceptDefaultHighlighting(DEPRECATED_MEMBERS, "Deprecated members", deprecatedMembers());
	
		super.configure(acceptor);
	}
	

	public TextStyle staticMethodInvocation(){
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}
	
	public TextStyle staticField(){
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setStyle(SWT.ITALIC);
		textStyle.setColor(new RGB(0, 0, 192));
		return textStyle;
	}
	
	public TextStyle field(){
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 26, 171));
		return textStyle;
	}
	
	public TextStyle annotation(){
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(100,100,100));
		return textStyle;
	}
	
	public TextStyle extensionMethodInvocation(){
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(171, 48, 0));
		return textStyle;
	}
	
	public TextStyle deprecatedMembers(){
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setStyle(TextAttribute.STRIKETHROUGH);
		return textStyle;
	}
	

}
