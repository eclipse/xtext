/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IEObjectHandle;
import org.eclipse.xtext.util.concurrent.IStateAccess;

/**
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 */
public interface IXtextDocument extends IDocument, IStateAccess<XtextResource> {

	public <T> T getAdapter(Class<T> adapterType);
	
	/**
	 * If you want to hold a reference to an EObject outside a {@link IUnitOfWork}, you should
	 * create a handle using this method.
	 * 
	 * @param <T> - the EObject
	 * @return - the handle
	 */
	public <T extends EObject> IEObjectHandle<T> createHandle(T obj);

	public void addModelListener(IXtextModelListener listener);

	public void removeModelListener(IXtextModelListener listener);
	
	void addXtextDocumentContentObserver(IXtextDocumentContentObserver listener);
	
	void removeXtextDocumentContentObserver(IXtextDocumentContentObserver listener);

}
