/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SemanticHighlightingConfiguration extends DefaultHighlightingConfiguration {

	public static final String RULE_DECLARATION_ID = "RuleDeclaration";
	public static final String TYPE_REFERENCE_ID = "TypeReference";
	public static final String DATA_TYPE_RULE_ID = "DataTypeIndicator";
	public static final String UNUSED_VALUE_ID = "UnusedValue";
	public static final String NEVER_CALLED_RULE_ID = "NeverCalledRule";
	
	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(RULE_DECLARATION_ID, "Rule Declaration", defaultTextStyle());
		acceptor.acceptDefaultHighlighting(TYPE_REFERENCE_ID, "Type Reference", typeReference());
		acceptor.acceptDefaultHighlighting(DATA_TYPE_RULE_ID, "Data Type Rule", dataTypeRule());
		acceptor.acceptDefaultHighlighting(UNUSED_VALUE_ID, "Unused Value", unusedValue());
		acceptor.acceptDefaultHighlighting(NEVER_CALLED_RULE_ID, "Uncalled Rule", unusedRule());
	}

	public TextStyle typeReference() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}
	
	public TextStyle dataTypeRule() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 0, 192));
		return textStyle;
	}
	
	public TextStyle unusedValue() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(128, 128, 128));
		return textStyle;
	}
	
	public TextStyle unusedRule() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(128, 128, 128));
		return textStyle;
	}
	
}
