/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service.ui.view;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.ServiceRegistry.Entry;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class ServiceRegistryContentProvider implements ITreeContentProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface
	 * .viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Collection<?>) {
			return ((Collection<?>) inputElement).toArray();
		}
		else
			return getChildren(inputElement);
	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IServiceScope) {
			List<Entry> registeredServices = ServiceRegistry.getRegisteredServices((IServiceScope) parentElement);
			Collections.sort(registeredServices, new Comparator<Entry>() {
				public int compare(Entry o1, Entry o2) {
					int result = o1.getServiceInterface().getName().compareTo(o2.getServiceInterface().getName());
					if (result == 0)
						return o1.compareTo(o2);
					return result;
				}
			});
			return registeredServices.toArray();
		}
		return new Object[] {};
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {
		Object[] children = getChildren(element);
		return children != null && children.length > 0;
	}
}
