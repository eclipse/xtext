/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.testing;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @since 2.12
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
