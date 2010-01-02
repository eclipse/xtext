/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Peter Friese - Implementation
 * @author Sebastian Zarnekow
 * @author Michael Clay
 */
public class DefaultLabelProvider extends SimpleLabelProvider {
	@Inject
	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;

	@Override
	public Image getImage(Object element) {
		String imageName = getImageDispatcher().invoke(element);
		if (imageName == null && adapterFactoryLabelProvider != null)
			return adapterFactoryLabelProvider.getImage(element);
		return getImageHelper().getImage(imageName);
	}

	public AdapterFactoryLabelProvider getAdapterFactoryLabelProvider() {
		return adapterFactoryLabelProvider;
	}

	public void setAdapterFactoryLabelProvider(AdapterFactoryLabelProvider adapterFactoryLabelProvider) {
		this.adapterFactoryLabelProvider = adapterFactoryLabelProvider;
	}

	public StyledString createStyledString(Object object) {
		return createStyledString(object, null);
	}

	public StyledString createStyledString(Object object, Styler styler) {
		return new StyledString(getNullSafeDefaultText(object), styler);
	}

	public String getNullSafeDefaultText(Object element) {
		String text = text(element);
		return null == text ? "" : text;
	}

	/**
	 * @see DefaultLabelProvider#createStyler(FontDescriptor, String, String)
	 */
	public static Styler createStyler(String foregroundColorName, String backgroundColorName) {
		return new DefaultFontStyler(null, foregroundColorName, backgroundColorName);
	}

	/**
	 * Creates a styler that takes the given descriptor of a font, foreground and background colors from the JFace color
	 * registry.
	 * 
	 * @param fontDescriptor
	 *            the descriptor of a font to apply
	 * @param foregroundColorName
	 *            the color name for the foreground color
	 * @param backgroundColorName
	 *            the color name for the background color
	 * 
	 * @return the created style
	 */
	public static Styler createStyler(FontDescriptor fontDescriptor, String foregroundColorName,
			String backgroundColorName) {
		return new DefaultFontStyler(fontDescriptor, foregroundColorName, backgroundColorName);
	}

	/**
	 * Creates an adapter styler for {@link org.eclipse.xtext.ui.core.editor.utils.TextStyle XtextStyles}.
	 * 
	 * @param xtextStyle
	 *            the xtextStyle to apply
	 * @return the created style
	 */
	public static Styler createXtextStyleAdapterStyler(org.eclipse.xtext.ui.core.editor.utils.TextStyle xtextStyle) {
		return new XtextStyleAdapterStyler(xtextStyle);
	}

	private static class XtextStyleAdapterStyler extends Styler {
		private org.eclipse.xtext.ui.core.editor.utils.TextStyle textStyle;

		public XtextStyleAdapterStyler(org.eclipse.xtext.ui.core.editor.utils.TextStyle textStyle) {
			this.textStyle = textStyle;
		}

		@Override
		public void applyStyles(TextStyle textStyle) {
			this.textStyle.applyTo(textStyle);
		}
	}

	private static class DefaultFontStyler extends Styler {
		private final FontDescriptor fontDescriptor;
		private final String foregroundColorName;
		private final String backgroundColorName;

		public DefaultFontStyler(FontDescriptor fontDescriptor, String foregroundColorName, String backgroundColorName) {
			this.fontDescriptor = fontDescriptor;
			this.foregroundColorName = foregroundColorName;
			this.backgroundColorName = backgroundColorName;
		}

		@Override
		public void applyStyles(TextStyle textStyle) {
			ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
			if (fontDescriptor != null) {
				textStyle.font = fontDescriptor.createFont(Display.getCurrent());
			}
			if (foregroundColorName != null) {
				textStyle.foreground = colorRegistry.get(foregroundColorName);
			}
			if (backgroundColorName != null) {
				textStyle.background = colorRegistry.get(backgroundColorName);
			}
		}
	}
}
