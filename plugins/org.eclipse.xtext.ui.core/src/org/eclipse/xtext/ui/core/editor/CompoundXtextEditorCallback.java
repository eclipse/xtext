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

import org.apache.log4j.Logger;

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
	private Logger log = Logger.getLogger(CompoundXtextEditorCallback.class);

	protected void handle(Exception e) {
		log.error(e.getMessage(), e);
	}

	@Inject
	public CompoundXtextEditorCallback(Injector injector) {
		List<Binding<IXtextEditorCallback>> bindingsByType = injector.findBindingsByType(TypeLiteral
				.get(IXtextEditorCallback.class));
		for (Binding<IXtextEditorCallback> binding : bindingsByType) {
			try {
				editorCallbacks.add(binding.getProvider().get());
			} catch (Exception e) {
				handle(e);
			}
		}
	}

	public void afterCreatePartControl(XtextEditor xtextEditor) {
		for (IXtextEditorCallback xtextEditorCallback : editorCallbacks) {
			try {
				xtextEditorCallback.afterCreatePartControl(xtextEditor);
			} catch (Exception e) {
				handle(e);
			}
		}
	}

	public void afterSave(XtextEditor xtextEditor) {
		for (IXtextEditorCallback xtextEditorCallback : editorCallbacks) {
			try {
				xtextEditorCallback.afterSave(xtextEditor);
			} catch (Exception e) {
				handle(e);
			}
		}
	}

	public void beforeDispose(XtextEditor xtextEditor) {
		for (IXtextEditorCallback xtextEditorCallback : editorCallbacks) {
			try {
				xtextEditorCallback.beforeDispose(xtextEditor);
			} catch (Exception e) {
				handle(e);
			}
		}
	}

	public boolean onValidateEditorInputState(XtextEditor xtextEditor) {
		for (IXtextEditorCallback xtextEditorCallback : editorCallbacks) {
			try {
				if (!xtextEditorCallback.onValidateEditorInputState(xtextEditor)) {
					return false;
				}
			} catch (Exception e) {
				handle(e);
			}
		}
		return true;
	}

	public void afterSetInput(XtextEditor xtextEditor) {
		for (IXtextEditorCallback xtextEditorCallback : editorCallbacks) {
			try {
				xtextEditorCallback.afterSetInput(xtextEditor);
			} catch (Exception e) {
				handle(e);
			}
		}
	}

}
