/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.selection;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.texteditor.IUpdate;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.internal.Lists;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class SelectionHistory {
	private List<ITextRegion> selections = Lists.newArrayList();
	private int selectionChangeListenerCounter;
	private XtextEditor xtextEditor;
	private ISelectionChangedListener selectionListener;
	private final ListenerList selectionHistoryListeners = new ListenerList(ListenerList.IDENTITY);

	public SelectionHistory(XtextEditor editor) {
		Assert.isNotNull(editor);
		xtextEditor = editor;
		selectionListener = getSelectionChangedListener();
		xtextEditor.getSelectionProvider().addSelectionChangedListener(selectionListener);
	}

	public void addSelectionHistoryListener(IUpdate listener) {
		Assert.isNotNull(listener);
		selectionHistoryListeners.add(listener);
	}

	public void removeSelectionHistoryListener(IUpdate listener) {
		Assert.isNotNull(listener);
		selectionHistoryListeners.remove(listener);
	}

	protected ISelectionChangedListener getSelectionChangedListener() {
		if (selectionListener == null) {
			selectionListener = new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					if (selectionChangeListenerCounter == 0) {
						flush();
					}
				}
			};
		}
		return selectionListener;
	}

	protected void notifySelectionHistoryListeners() {
		Object[] listeners = selectionHistoryListeners.getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IUpdate) listeners[i]).update();
		}
	}

	public boolean isEmpty() {
		return selections.isEmpty();
	}

	public void remember(ITextRegion range) {
		selections.add(range);
		notifySelectionHistoryListeners();
	}

	public ITextRegion getLast() {
		if (isEmpty()) {
			return null;
		}
		ITextRegion result = selections.remove(selections.size() - 1);
		notifySelectionHistoryListeners();
		return result;
	}

	public void flush() {
		if (selections.isEmpty())
			return;
		selections.clear();
		notifySelectionHistoryListeners();
	}

	public void ignoreSelectionChanges() {
		selectionChangeListenerCounter++;
	}

	public void listenToSelectionChanges() {
		selectionChangeListenerCounter--;
	}

	public void dispose() {
		if (xtextEditor.getSelectionProvider() != null) {
			xtextEditor.getSelectionProvider().removeSelectionChangedListener(selectionListener);
		}
	}

}
