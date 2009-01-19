/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;


import org.eclipse.jface.text.IDocumentListener;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 */
public interface IXtextDocumentContentObserver extends IDocumentListener {

	/**
	 * 
	 *
	 */
	public interface Processor {
		<T> T process(UnitOfWork<T> transaction);
	}

	/**
	 * is called before some other code requests access to an IXtextDocument's state via
	 * {@link IXtextDocument#readOnly(UnitOfWork)} or {@link IXtextDocument#modify(UnitOfWork)}
	 * 
	 * Implementers get the chance to do any work using the passed {@link Processor}
	 * 
	 * @param processor
	 */
	void performNecessaryUpdates(Processor processor);
	
}
