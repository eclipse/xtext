/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.utils;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.RGB;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class TextStyleConstants {

	public final static RGB DEFAULT_COLOR = new RGB(0, 0, 0);
	public final static RGB DEFAULT_BACKGROUNDCOLOR = new RGB(255, 255, 255);
	public static final String DEFAULT_FONT_NAME = JFaceResources.TEXT_FONT;

	public final static RGB KEYWORD_COLOR = new RGB(127, 0, 85);

	public final static RGB COMMENT_COLOR = new RGB(63, 127, 95);
	public final static RGB STRING_COLOR = new RGB(42, 0, 255);

	public final static RGB NUMBER_COLOR = new RGB(125, 125, 125);
	public static final RGB MULTILINE_COMMENT_COLOR = new RGB(33, 97, 65);

}
