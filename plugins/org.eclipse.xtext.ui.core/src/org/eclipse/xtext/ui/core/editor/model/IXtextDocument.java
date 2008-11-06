/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import org.eclipse.jface.text.IDocument;

/**
 * @author Sebastian Zarnekow
 */
public interface IXtextDocument extends IDocument {

	public <T> T readOnly(UnitOfWork<T> work);

	public <T> T modify(UnitOfWork<T> work);
	
	public <T> T getAdapter(Class<T> adapterType);

	public void addModelListener(IXtextModelListener listener);

	public void removeModelListener(IXtextModelListener listener);
	
	void addXtextDocumentContentObserver(IXtextDocumentContentObserver listener);
	
	void removeXtextDocumentContentObserver(IXtextDocumentContentObserver listener);

}
