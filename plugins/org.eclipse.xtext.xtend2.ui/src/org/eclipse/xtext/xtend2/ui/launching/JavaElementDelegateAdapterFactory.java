/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.launching;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Use intermediate delegate to not interfere with JDTs adapters
 */
@Singleton
public class JavaElementDelegateAdapterFactory implements IAdapterFactory {
	
	@Inject
	private Provider<JavaElementDelegate> delegateProvider;
	
	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes")  Class adapterType) {
		if (JavaElementDelegate.class.equals(adapterType)) {
			if (adaptableObject instanceof IFileEditorInput) {
				JavaElementDelegate result = delegateProvider.get();
				result.initializeWith((IFileEditorInput) adaptableObject);
				return result;
			}
			if (adaptableObject instanceof IResource) {
				JavaElementDelegate result = delegateProvider.get();
				result.initializeWith((IResource) adaptableObject);
				return result;
			}
			if (adaptableObject instanceof IEditorPart) {
				JavaElementDelegate result = delegateProvider.get();
				result.initializeWith((IEditorPart) adaptableObject);
				return result;
			}
		}
		if (adaptableObject instanceof JavaElementDelegate) {
			return ((JavaElementDelegate) adaptableObject).getAdapter(adapterType);
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public Class[] getAdapterList() {
		return new Class[] { JavaElementDelegate.class };
	}
	
}
