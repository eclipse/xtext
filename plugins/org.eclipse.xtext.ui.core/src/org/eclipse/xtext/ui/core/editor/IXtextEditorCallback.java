/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(IXtextEditorCallback.NullImpl.class)
public interface IXtextEditorCallback {
	
	public void afterCreatePartControl(XtextEditor editor);
	
	public void afterSave(XtextEditor editor);
	
	public static class NullImpl implements IXtextEditorCallback {

		public void afterCreatePartControl(XtextEditor editor) {
		}

		public void afterSave(XtextEditor editor) {
		}
		
	}
}
