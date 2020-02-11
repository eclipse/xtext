/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.compare;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Michael Clay - Initial contribution and API
 */
public abstract class AbstractContentViewer extends Viewer {
	protected Composite parent;
	protected CompareConfiguration compareConfiguration;
	protected ISelection selection;
	protected ISourceViewer sourceViewer;
	protected Object input;

	public void init(Composite parent, CompareConfiguration config) {
		this.parent = parent;
		this.compareConfiguration = config;
	}

	@Override
	public Control getControl() {
		if (sourceViewer == null) {
			sourceViewer = createSourceViewer();
			configureSourceViewer(sourceViewer);
		}
		return sourceViewer != null ? sourceViewer.getTextWidget() : null;
	}

	protected abstract ISourceViewer createSourceViewer();

	protected abstract void configureSourceViewer(ISourceViewer sourceViewer);

	@Override
	public Object getInput() {
		return this.input;
	}

	@Override
	public ISelection getSelection() {
		return this.selection;
	}

	@Override
	public void refresh() {
	}

	@Override
	public void setInput(Object input) {
		this.input = input;
	}

	@Override
	public void setSelection(ISelection selection, boolean reveal) {
		this.selection = selection;
	}

	public Composite getParent() {
		return parent;
	}

	public CompareConfiguration getCompareConfiguration() {
		return compareConfiguration;
	}

}
