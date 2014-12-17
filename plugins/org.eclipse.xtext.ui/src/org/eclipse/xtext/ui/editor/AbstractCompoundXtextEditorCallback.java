/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.List;

import org.apache.log4j.Logger;

import com.google.common.collect.Lists;

/**
 * Abstract base class for compound editor callback implementations.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
public abstract class AbstractCompoundXtextEditorCallback implements IXtextEditorCallback {

	private List<IXtextEditorCallback> editorCallbacks = Lists.newArrayList();
	private Logger log = Logger.getLogger(CompoundXtextEditorCallback.class);

	protected void handle(Exception e) {
		log.error(e.getMessage(), e);
	}
	
	protected List<IXtextEditorCallback> getEditorCallbacks() {
		return editorCallbacks;
	}
	
	public void addCallback(IXtextEditorCallback callback) {
		getEditorCallbacks().add(callback);
	}
	
	public void removeCallback(IXtextEditorCallback callback) {
		getEditorCallbacks().remove(callback);
	}
	
	@Override
	public void afterCreatePartControl(XtextEditor xtextEditor) {
		for (IXtextEditorCallback xtextEditorCallback : getEditorCallbacks()) {
			try {
				xtextEditorCallback.afterCreatePartControl(xtextEditor);
			} catch (Exception e) {
				handle(e);
			}
		}
	}

	@Override
	public void afterSave(XtextEditor xtextEditor) {
		for (IXtextEditorCallback xtextEditorCallback : getEditorCallbacks()) {
			try {
				xtextEditorCallback.afterSave(xtextEditor);
			} catch (Exception e) {
				handle(e);
			}
		}
	}

	@Override
	public void beforeDispose(XtextEditor xtextEditor) {
		for (IXtextEditorCallback xtextEditorCallback : getEditorCallbacks()) {
			try {
				xtextEditorCallback.beforeDispose(xtextEditor);
			} catch (Exception e) {
				handle(e);
			}
		}
	}

	@Override
	public boolean onValidateEditorInputState(XtextEditor xtextEditor) {
		for (IXtextEditorCallback xtextEditorCallback : getEditorCallbacks()) {
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

	@Override
	public void beforeSetInput(XtextEditor xtextEditor) {
		for (int i = getEditorCallbacks().size() - 1; i >= 0; i--) {
			try {
				editorCallbacks.get(i).beforeSetInput(xtextEditor);
			} catch (Exception e) {
				handle(e);
			}
		}
	}

	@Override
	public void afterSetInput(XtextEditor xtextEditor) {
		for (IXtextEditorCallback xtextEditorCallback : getEditorCallbacks()) {
			try {
				xtextEditorCallback.afterSetInput(xtextEditor);
			} catch (Exception e) {
				handle(e);
			}
		}
	}
}
