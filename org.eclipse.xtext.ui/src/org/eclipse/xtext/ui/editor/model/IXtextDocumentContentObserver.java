/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;


import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IXtextDocumentContentObserver extends IDocumentListener {

	/**
	 * Releases all read locks on the document held by the current thread, acquires a write lock 
	 * and executes the {@link IUnitOfWork} in it. Then re-acquires the read locks.
	 */
	public interface Processor {
		<T> T process(IUnitOfWork<T, XtextResource> transaction);
	}

	/**
	 * Called by the document before any client requests access to an IXtextDocument's state via
	 * {@link IXtextDocument#readOnly(IUnitOfWork)} or {@link IXtextDocument#modify(IUnitOfWork)}
	 * 
	 * Implementers get the chance to do any work using the passed {@link Processor}
	 * 
	 * @since 2.7
	 */
	boolean performNecessaryUpdates(Processor processor);
	
	/**
	 * @since 2.7
	 */
	boolean hasPendingUpdates();
	
}
