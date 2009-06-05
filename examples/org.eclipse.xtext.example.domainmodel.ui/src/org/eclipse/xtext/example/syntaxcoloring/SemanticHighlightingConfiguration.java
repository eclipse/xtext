/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingConfiguration;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class SemanticHighlightingConfiguration implements ISemanticHighlightingConfiguration {
	
	public final static String CROSS_REF = "CrossReference"; 

	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(CROSS_REF, "Cross References", crossReferenceTextStyle());
	}

	public TextStyle defaultTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setBackgroundColor(new RGB(255, 255, 255));
		textStyle.setColor(new RGB(0, 0, 0));
		return textStyle;
	}
	
	public TextStyle crossReferenceTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}
}
