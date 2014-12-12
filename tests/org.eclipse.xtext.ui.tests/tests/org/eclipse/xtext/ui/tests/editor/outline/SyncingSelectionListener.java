/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import java.util.concurrent.TimeoutException;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SyncingSelectionListener implements ISelectionChangedListener {

	private volatile DisplaySafeSyncer syncer = new DisplaySafeSyncer();
	
	public void start() throws InterruptedException {
		syncer.start();
	}
	
	public void awaitSignal(long timeout) throws TimeoutException, InterruptedException {
		syncer.awaitSignal(timeout);
	}
	
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		syncer.signal();
	}
	
}
