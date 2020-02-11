/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.highlighting;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingConfiguration;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
public class XtendHighlightingConfiguration extends XbaseHighlightingConfiguration implements XtendHighlightingStyles {

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(RICH_TEXT_ID, "Template Text", richTextStyle());
		acceptor.acceptDefaultHighlighting(RICH_TEXT_DELIMITER_ID, "Template Terminals", richTextDelimiterStyle());
		acceptor.acceptDefaultHighlighting(INSIGNIFICANT_TEMPLATE_TEXT, "Insignificant Template Whitespace", insignificantTemplateTextStyle());
		
		acceptor.acceptDefaultHighlighting(ACTIVE_ANNOTATION, "Active Annotations", activeAnnotationStyle());
		
		acceptor.acceptDefaultHighlighting(SINGLE_LINE_COMMENT, "Single Line Comments", commentTextStyle());
		acceptor.acceptDefaultHighlighting(MULTI_LINE_COMMENT, "Multi Line Comments", commentTextStyle());
	}
	
	public TextStyle richTextStyle() {
		TextStyle textStyle = stringTextStyle().copy();
		textStyle.setBackgroundColor(new RGB(220, 220, 220));
		return textStyle;
	}
	
	public TextStyle richTextDelimiterStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		return textStyle;
	}
	
	public TextStyle insignificantTemplateTextStyle() {
		TextStyle textStyle = stringTextStyle().copy();
		return textStyle;
	}

	public TextStyle activeAnnotationStyle() {
		TextStyle textStyle = extensionMethodInvocation().copy();
		return textStyle;
	}

}
