/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import com.google.inject.Singleton;

/**
 * Obtain an instance of the DispatchingEditorCallback, if you want to
 * register a general, additional listener to the XtextEditor.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
@Singleton
public class ObservableEditorCallback extends AbstractCompoundXtextEditorCallback {
}
