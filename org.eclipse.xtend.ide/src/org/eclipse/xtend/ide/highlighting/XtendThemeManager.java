/*******************************************************************************
 * Copyright (c) 2020 Karakun GmbH (http://www.karakun.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.highlighting;

import static org.eclipse.xtend.ide.internal.XtendActivator.*;
import static org.eclipse.xtext.ui.editor.syntaxcoloring.CommonPreferenceConstants.*;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.css.swt.theme.ITheme;
import org.eclipse.e4.ui.css.swt.theme.IThemeEngine;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * Manages changing of syntax coloring preferences for Xtend when themes are changed.
 * <p>
 * This handler is registered to theme change events (topic {@link IThemeEngine.Events#THEME_CHANGED})
 * and applies the Xtend styles to the theme engine. 
 * </p>
 * <p>
 * When the theme is set to Dark the styles are defined by stylesheet {@code css/e4-dark_xtend_syntaxhighlighting.css}.
 * </p>
 * <p>
 * For other themes style preferences are resetted to the values defined by {@link XtendHighlightingConfiguration}.
 * </p>
 * 
 * @author Karsten Thoms - Initial contribution and API
 * @author Emmanuel Chebbi - Initial implementation draft
 */
public class XtendThemeManager implements EventHandler {
	// 
	private static final String THEME_ID_DARK = "org.eclipse.e4.ui.css.theme.e4_dark";


	@Override
	public void handleEvent(Event event) {
		if (!IThemeEngine.Events.THEME_CHANGED.equals(event.getTopic())) {
			return;
		}
		IThemeEngine themeEngine = PlatformUI.getWorkbench().getService(IThemeEngine.class);
		ITheme theme = themeEngine.getActiveTheme();

		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(ORG_ECLIPSE_XTEND_CORE_XTEND);
		
		if (THEME_ID_DARK.equals(theme.getId())) {
			themeEngine.applyStyles(preferences, false);
		} else {
			// resetting from dark theme does not work the same way
			// as a workaround reset the preferences by evaluating the highlightingConfiguration
			IHighlightingConfiguration highlightingConfiguration = new XtendHighlightingConfiguration();
			highlightingConfiguration.configure((id,name,style) -> {
				String colorKey = String.format("%s.%s.%s.%s.%s", ORG_ECLIPSE_XTEND_CORE_XTEND, SYNTAX_COLORER_PREFERENCE_TAG, TOKEN_STYLES_PREFERENCE_TAG, id, COLOR_SUFFIX);
				String bgColorKey = String.format("%s.%s.%s.%s.%s", ORG_ECLIPSE_XTEND_CORE_XTEND, SYNTAX_COLORER_PREFERENCE_TAG, TOKEN_STYLES_PREFERENCE_TAG, id, BACKGROUNDCOLOR_SUFFIX);
				String styleKey = String.format("%s.%s.%s.%s.%s", ORG_ECLIPSE_XTEND_CORE_XTEND, SYNTAX_COLORER_PREFERENCE_TAG, TOKEN_STYLES_PREFERENCE_TAG, id, STYLE_SUFFIX);

				RGB color = style.getColor();
				if (color != null) {
					preferences.put(colorKey, String.format("%d,%d,%d", color.red, color.green, color.blue));
				} else {
					if (preferences.get(colorKey, null) != null) {
						preferences.remove(colorKey);
					}
				}
				RGB bgColor = style.getBackgroundColor();
				if (bgColor != null) {
					preferences.put(bgColorKey, String.format("%d,%d,%d", bgColor.red, bgColor.green, bgColor.blue));
				} else {
					if (preferences.get(bgColorKey, null) != null) {
						preferences.remove(bgColorKey);
					}
				}
				int styleMask = style.getStyle();
				if (preferences.getInt(styleKey, -1) != -1) {
					preferences.remove(styleKey);
				}
				if (styleMask > 0) {
					preferences.putInt(styleKey, styleMask);
				}
			}
			);
			themeEngine.applyStyles(preferences, false);
		}
	}
	
}
