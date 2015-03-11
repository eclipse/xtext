/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.ui;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MockableSelectionProvider implements ISelectionProvider {

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ISelection getSelection() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSelection(ISelection selection) {
		throw new UnsupportedOperationException();
	}

}
