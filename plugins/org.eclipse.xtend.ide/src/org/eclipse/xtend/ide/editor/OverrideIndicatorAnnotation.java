/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import org.eclipse.jface.text.source.Annotation;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class OverrideIndicatorAnnotation extends Annotation {
	public static final String ANNOTATION_TYPE = "org.eclipse.xtext.ui.overrideIndicator"; //$NON-NLS-1$
	private boolean isOverwriteIndicator;
	private String functionURIFragment;

	public OverrideIndicatorAnnotation(String text, String functionUri) {
		this(true, text, functionUri);
	}

	public OverrideIndicatorAnnotation(boolean isOverwriteIndicator, String text, String functionUri) {
		super(ANNOTATION_TYPE, false, text);
		this.isOverwriteIndicator = isOverwriteIndicator;
		this.functionURIFragment = functionUri;
	}

	public boolean isOverwriteIndicator() {
		return isOverwriteIndicator;
	}

	public String getFunctionURIFragment() {
		return functionURIFragment;
	}

}
