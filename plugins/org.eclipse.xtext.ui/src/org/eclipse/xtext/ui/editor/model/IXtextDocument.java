/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IReadAccess;
import org.eclipse.xtext.util.concurrent.IWriteAccess;

/**
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 * @author Jan Koehnlein
 */
public interface IXtextDocument extends IDocument, IDocumentExtension3, IReadAccess<XtextResource>, IWriteAccess<XtextResource> {

	public <T> T getAdapter(Class<T> adapterType);
	
	public void addModelListener(IXtextModelListener listener);

	public void removeModelListener(IXtextModelListener listener);
	
	void addXtextDocumentContentObserver(IXtextDocumentContentObserver listener);
	
	void removeXtextDocumentContentObserver(IXtextDocumentContentObserver listener);

}
