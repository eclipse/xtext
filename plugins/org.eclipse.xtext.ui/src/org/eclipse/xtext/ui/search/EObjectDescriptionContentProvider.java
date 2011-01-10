/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.search;

import java.util.Iterator;

import org.eclipse.jface.viewers.ILazyContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EObjectDescriptionContentProvider implements ILazyContentProvider {

	private Iterable<IEObjectDescription> matches;

	private int currentCount;

	private Iterator<IEObjectDescription> currentIterator;

	private TableViewer viewer;

	public void dispose() {
		viewer = null;
		matches = null;
	}

	@SuppressWarnings("unchecked")
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = (TableViewer) viewer;
		if (newInput instanceof Iterable<?>) {
			matches = (Iterable<IEObjectDescription>) newInput;
			reset();
			viewer.refresh();
		}
	}

	public void updateElement(int index) {
		if (index < currentCount) {
			reset();
		}
		for (; index > currentCount && currentIterator.hasNext(); ++currentCount) {
			currentIterator.next();
		}
		if (currentIterator.hasNext()) {
			++currentCount;
			viewer.replace(currentIterator.next(), index);
		}
	}

	private void reset() {
		currentCount = 0;
		currentIterator = matches.iterator();
	}

}