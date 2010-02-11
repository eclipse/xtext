/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class DefaultContentOutlineNodeAdapterFactory implements IContentOutlineNodeAdapterFactory {

	@SuppressWarnings("rawtypes")
	private static final Class[] EMPTY_CLASSES = new Class[0];
	
	static final Logger logger = Logger.getLogger(DefaultContentOutlineNodeAdapterFactory.class);

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (logger.isDebugEnabled()) {
			logger.debug("Requesting adapter type " + adapterType.getName() + ", adaptableObject type is "
					+ adaptableObject.getClass().getName());
		}
		if (adaptableObject instanceof ContentOutlineNode) {
			ContentOutlineNode node = (ContentOutlineNode) adaptableObject;
			EClass clazz = node.getClazz();
			if (clazz != null) {
				if (clazz.getInstanceClass().equals(adapterType)) {
					return Boolean.TRUE;
				}
				else if (IFile.class.equals(adapterType)) {
					return getUnderlyingResource();
				}
				else if (IResource.class.equals(adapterType)) {
					return getUnderlyingResource();
				}
			}

		}
		return null;
	}

	private Object getUnderlyingResource() {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		XtextEditor activeEditor = (XtextEditor) activePage.getActiveEditor();
		return activeEditor.getResource();
	}

	/**
	 * Subclasses should override this method.
	 */
	@SuppressWarnings("rawtypes")
	public Class[] getAdapterList() {
		return EMPTY_CLASSES;
	}

}
