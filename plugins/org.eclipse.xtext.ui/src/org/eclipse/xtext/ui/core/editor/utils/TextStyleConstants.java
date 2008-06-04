/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.utils;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class TextStyleConstants {

	public final static String DEFAULT_COLOR = "0,0,0";
	public final static String DEFAULT_BACKGROUNDCOLOR = "255,255,255";
	public final static int DEFAULT_STYLE = SWT.NONE;
	public static final String DEFAULT_FONT = JFaceResources.TEXT_FONT;

	public final static String KEYWORD_COLOR = "127, 0, 85";
	public final static int KEYWORD_STYLE = SWT.BOLD;

	public final static String COMMENT_COLOR = "63, 127, 95";

	public final static String STRING_COLOR = "42, 0, 255";
	
	public final static String NUMBER_COLOR = "125,125,125";

}
