/*******************************************************************************
 * Copyright (c) 2008,2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.highlighting;

import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TemplatesHighlightingConfiguration extends DefaultHighlightingConfiguration {

	public static final String TEMPLATE_BODY = "template.body";
	public static final String TEMPLATE_VARIABLE = "template.variable";
	public static final String TEMPLATE_VARIABLE_ARGUMENT = "template.variable.argument";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(TEMPLATE_BODY, "Template body", defaultTextStyle());
		acceptor.acceptDefaultHighlighting(TEMPLATE_VARIABLE, "Template variable", decorationsStyle());
		acceptor.acceptDefaultHighlighting(TEMPLATE_VARIABLE_ARGUMENT, "Template argument", counterStyle());
	}
	
	public TextStyle counterStyle() {
		TextStyle textStyle = new TextStyle();
		RGB color = JFaceResources.getColorRegistry().getRGB(JFacePreferences.COUNTER_COLOR);
		textStyle.setColor(color);
		return textStyle;
	}
	
	public TextStyle decorationsStyle() {
		TextStyle textStyle = new TextStyle();
		RGB color = JFaceResources.getColorRegistry().getRGB(JFacePreferences.DECORATIONS_COLOR);
		textStyle.setColor(color);
		return textStyle;
	}
	
}
