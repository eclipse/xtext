/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.highlighting;

import java.util.Optional;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.css.swt.theme.ITheme;
import org.eclipse.e4.ui.css.swt.theme.IThemeEngine;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingConfiguration;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
public class XtendHighlightingConfiguration extends XbaseHighlightingConfiguration implements XtendHighlightingStyles {

	private static final String THEME_ID_DARK = "org.eclipse.e4.ui.css.theme.e4_dark";

	public XtendHighlightingConfiguration () {
		initThemeManaging();
	}
	

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

	private void initThemeManaging() {
		if (PlatformUI.isWorkbenchRunning()) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			IEventBroker eventBroker = workbench.getService(IEventBroker.class);
			if (eventBroker != null) {
				EventHandler eventHandler = evt -> initTheme(evt);
				eventBroker.subscribe("org/eclipse/e4/ui/css/swt/theme/ThemeManager/themeChanged", eventHandler);
				initTheme(null);
			}
		}
	}

	private void initTheme(Event evt) {
		IThemeEngine themeEngine = PlatformUI.getWorkbench().getService(IThemeEngine.class);
		ITheme theme = themeEngine.getActiveTheme();

		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(XtendActivator.ORG_ECLIPSE_XTEND_CORE_XTEND);
		
		if (THEME_ID_DARK.equals(theme.getId())) {
			themeEngine.applyStyles(preferences, false);
		} else {
			configure((id,name,style) -> {
				RGB color = Optional.ofNullable(style.getColor()).orElse(new RGB(0,0,0));
				preferences.put(String.format("%s.syntaxColorer.tokenStyles.%s.color", XtendActivator.ORG_ECLIPSE_XTEND_CORE_XTEND, id), String.format("%d,%d,%d", color.red, color.green, color.blue));
			}
			);
			themeEngine.applyStyles(preferences, false);
		}
	}
}
