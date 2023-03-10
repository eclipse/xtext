/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.TextInvocationContext;
import org.eclipse.swt.custom.StyledText;

/**
 * Adds the option to suppress the selection of the error region to the
 * {@link org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext context}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.0
 */
public class QuickAssistInvocationContext extends TextInvocationContext {

	private final boolean suppressSelection;
	private boolean wasCancelled = false;

	public QuickAssistInvocationContext(ISourceViewer sourceViewer, int offset, int length, boolean suppressSelection) {
		super(sourceViewer, offset, length);
		this.suppressSelection = suppressSelection;
	}

	public boolean isSuppressSelection() {
		return suppressSelection;
	}
	
	/**
	 * May be called from all threads.
	 * @since 2.8
	 */
	public boolean isMarkedCancelled() {
		return wasCancelled;
	}
	
	/**
	 * May only be called from Display thread.
	 * @since 2.8
	 */
	public boolean isCancelled() {
		if (wasCancelled) {
			return true;
		}
		StyledText textWidget = getSourceViewer().getTextWidget();
		if (textWidget != null && !textWidget.isFocusControl()) {
			return wasCancelled = true;
		}
		return false;
	}

}
