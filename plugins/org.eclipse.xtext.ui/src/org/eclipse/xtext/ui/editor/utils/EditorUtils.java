/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.utils;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.DataFormatException;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * @author Dennis Hübner - Initial contribution and API
 * @author Peter Friese
 */
public class EditorUtils {

	private static final Logger log = Logger.getLogger(EditorUtils.class);

	public static Font fontFromFontData(FontData[] fontDataArray) {
		if (fontDataArray != null && fontDataArray.length > 0) {
			String fontData = PreferenceConverter.getStoredRepresentation(fontDataArray);
			if (!JFaceResources.getFontRegistry().hasValueFor(fontData)) {
				FontData[] fData = PreferenceConverter.basicGetFontData(fontData);
				JFaceResources.getFontRegistry().put(fontData, fData);
			}
			Font font = JFaceResources.getFontRegistry().get(fontData);
			return font;
		}
		return null;
	}

	public static Color colorFromString(String rgbString) {
		if (rgbString != null && rgbString.trim().length() > 0) {
			Color col = JFaceResources.getColorRegistry().get(rgbString);
			try {
				if (col == null) {
					RGB rgb = StringConverter.asRGB(rgbString);
					JFaceResources.getColorRegistry().put(rgbString, rgb);
					col = JFaceResources.getColorRegistry().get(rgbString);
				}
			}
			catch (DataFormatException e) {
				log.error("Corrupt color value: " + rgbString, e);
			}
			return col;
		}
		return null;
	}

	public static Color colorFromRGB(RGB rgb) {
		if (rgb == null)
			return null;
		return colorFromString(StringConverter.asString(rgb));
	}
	
	public static XtextEditor getActiveXtextEditor(ExecutionEvent event) {
		IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (activeEditor == null)
			return null;
		XtextEditor xtextEditor = (XtextEditor) activeEditor.getAdapter(XtextEditor.class);
		return xtextEditor;
	}

	public static XtextEditor getActiveXtextEditor() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		if (workbenchWindow == null) 
			return null;
		IWorkbenchPage activePage = workbenchWindow.getActivePage();
		if (activePage == null) 
			return null;
		IEditorPart activeEditor = activePage.getActiveEditor();
		if (activeEditor == null)
			return null;
		XtextEditor xtextEditor = (XtextEditor) activeEditor.getAdapter(XtextEditor.class);
		return xtextEditor;
	}

	public static XtextEditor getXtextEditor(IEditorPart openEditor) {
		if (openEditor != null) {
			return (XtextEditor) openEditor.getAdapter(XtextEditor.class);
		}
		return null;
	}
	
}
