/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.TextInvocationContext;

/**
 * Adds the option to suppress the selection of the error region to the
 * {@link org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext context}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.0
 */
public class QuickAssistInvocationContext extends TextInvocationContext {

	private final boolean suppressSelection;

	public QuickAssistInvocationContext(ISourceViewer sourceViewer, int offset, int length, boolean suppressSelection) {
		super(sourceViewer, offset, length);
		this.suppressSelection = suppressSelection;
	}

	public boolean isSuppressSelection() {
		return suppressSelection;
	}

}
