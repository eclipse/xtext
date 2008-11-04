/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service.ui.view;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry.Entry;
import org.eclipse.xtext.service.ui.internal.ServicePluginImages;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class ServiceLabelProvider extends LabelProvider implements IStyledLabelProvider {

	private static final String EXTENDS = " extends ";
	private final ServiceRegistryViewSettings configs;

	/**
	 * @param configs
	 */
	public ServiceLabelProvider(ServiceRegistryViewSettings configs) {
		this.configs = configs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		return getStyledText(element).getString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof IServiceScope) {
			return ServicePluginImages.get(ServicePluginImages.OBJ_DESC_LANGUAGE);
		}
		if (element instanceof Entry) {
			// Entry entry = (Entry) element;
			return ServicePluginImages.get(ServicePluginImages.OBJ_DESC_SERVICE_LOADED);
			// if (entry.isLoaded()) {
			// return
			// ServicePluginImages.get(ServicePluginImages.OBJ_DESC_SERVICE_LOADED);
			// }
			// else {
			// return
			// ServicePluginImages.get(ServicePluginImages.OBJ_DESC_SERVICE_NOT_LOADED);
			//
			// }
		}

		return super.getImage(element);
	}

	private String simpleName(Object element) {
		if (element instanceof IServiceScope) {
			String id = ((IServiceScope) element).getId();
			int indexOf = id.lastIndexOf('.');
			if (indexOf >= 0 && indexOf + 1 < id.length()) {
				return id.substring(indexOf + 1);
			}
		}
		else if (element instanceof Entry) {
			return ((Entry) element).getServiceInterface().getSimpleName();
		}
		return fqName(element);
	}

	private String fqName(Object element) {
		if (element instanceof IServiceScope) {
			return ((IServiceScope) element).getId();
		}
		else if (element instanceof Entry) {
			return ((Entry) element).getServiceInterface().getName();
		}
		return super.getText(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.
	 * IStyledLabelProvider#getStyledText(java.lang.Object)
	 */
	public StyledString getStyledText(Object element) {
		String text = configs.isShowFQNames() ? fqName(element) : simpleName(element);
		StyledString ss = new StyledString(text);
		// additional prefixes by Type
		if (element instanceof IServiceScope) {
			if (((IServiceScope) element).getParentScope() != null)
				return ss.append(EXTENDS, StyledString.COUNTER_STYLER).append(
						getText(((IServiceScope) element).getParentScope()));
		}
		else if (element instanceof Entry) {
			ss.append(" Prio: " + Integer.toString(((Entry) element).getPriority()), StyledString.QUALIFIER_STYLER);
		}
		return ss;
	}
}
