/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.inject.Binding;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;

/**
 * TODO: replace with Guice2 http://code.google.com/p/google-guice/wiki/Multibindings
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class CompoundXtextEditorCallback implements IXtextEditorCallback {
	private List<IXtextEditorCallback> editorCallbacks = Lists.newArrayList();

	@Inject
	public CompoundXtextEditorCallback(Injector injector) {
		List<Binding<IXtextEditorCallback>> bindingsByType = injector.findBindingsByType(TypeLiteral
				.get(IXtextEditorCallback.class));
		for (Binding<IXtextEditorCallback> binding : bindingsByType) {
			editorCallbacks.add(binding.getProvider().get());
		}
	}

	public void afterCreatePartControl(XtextEditor xtextEditor) {
		for (IXtextEditorCallback xtextEditorCallback : editorCallbacks) {
			xtextEditorCallback.afterCreatePartControl(xtextEditor);
		}
	}

	public void afterSave(XtextEditor xtextEditor) {
		for (IXtextEditorCallback xtextEditorCallback : editorCallbacks) {
			xtextEditorCallback.afterSave(xtextEditor);
		}
	}

	public void beforeDispose(XtextEditor xtextEditor) {
		for (IXtextEditorCallback xtextEditorCallback : editorCallbacks) {
			xtextEditorCallback.beforeDispose(xtextEditor);
		}
	}

	public boolean onValidateEditorInputState(XtextEditor xtextEditor) {
		for (IXtextEditorCallback xtextEditorCallback : editorCallbacks) {
			if (!xtextEditorCallback.onValidateEditorInputState(xtextEditor)) {
				return false;
			}
		}
		return true;
	}

	public void afterSetInput(XtextEditor xtextEditor) {
		for (IXtextEditorCallback xtextEditorCallback : editorCallbacks) {
			xtextEditorCallback.afterSetInput(xtextEditor);
		}
	}

}
