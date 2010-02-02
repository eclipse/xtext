/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;


import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IXtextDocumentContentObserver extends IDocumentListener {

	public interface Processor {
		<T> T process(IUnitOfWork<T, XtextResource> transaction);
	}

	/**
	 * Called by the document before when any client requests access to an IXtextDocument's state via
	 * {@link IXtextDocument#readOnly(IUnitOfWork)} or {@link IXtextDocument#modify(IUnitOfWork)}
	 * 
	 * Implementers get the chance to do any work using the passed {@link Processor}
	 * 
	 * @param processor
	 */
	void performNecessaryUpdates(Processor processor);
	
}
