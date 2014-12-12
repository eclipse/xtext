/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.launching;

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
	@Inject
	private Provider<JavaElementDelegateJunitLaunch> junitDelegateProvider;
	@Inject
	private Provider<JavaElementDelegateMainLaunch> mainDelegateProvider;
	
	@Override
	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes")  Class adapterType) {
		if (adaptableObject instanceof JavaElementDelegate) {
			return ((JavaElementDelegate) adaptableObject).getAdapter(adapterType);
		}
		JavaElementDelegate result = null;
		if (JavaElementDelegateJunitLaunch.class.equals(adapterType)) {
			result = junitDelegateProvider.get();
		} else if (JavaElementDelegateMainLaunch.class.equals(adapterType)) {
			result = mainDelegateProvider.get();
		} else if (JavaElementDelegate.class.equals(adapterType)) {
			result = delegateProvider.get();
		}
		if (result != null) {
			if (adaptableObject instanceof IFileEditorInput) {
				result.initializeWith((IFileEditorInput) adaptableObject);
				return result;
			}
			if (adaptableObject instanceof IResource) {
				result.initializeWith((IResource) adaptableObject);
				return result;
			}
			if (adaptableObject instanceof IEditorPart) {
				result.initializeWith((IEditorPart) adaptableObject);
				return result;
			}
		}
		return null;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Class[] getAdapterList() {
		return new Class[] { JavaElementDelegate.class };
	}
	
}
