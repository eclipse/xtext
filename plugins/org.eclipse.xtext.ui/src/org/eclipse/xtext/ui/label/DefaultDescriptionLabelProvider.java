/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.label;

import java.util.Iterator;

import org.eclipse.core.resources.IStorage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DefaultDescriptionLabelProvider extends DeclarativeLabelProvider {

	@Inject
	private IStorage2UriMapper storage2UriMapper;

	@Inject 
	private DefaultEditorImageUtil imageUtil;

	public Object image(IEObjectDescription element) {
		return image(element.getEClass());
	}

	public Object image(IResourceDescription element) {
		String fileName = element.getURI().lastSegment();
		return imageUtil.getDefaultEditorImageDescriptor(fileName);
	}

	public Object text(IEObjectDescription element) {
		return element.getQualifiedName() + " - " + element.getEClass().getName();
	}

	public Object text(IResourceDescription element) {
		Iterator<IStorage> storages = storage2UriMapper.getStorages(element.getURI()).iterator();
		if (storages.hasNext()) {
			IStorage storage = storages.next();
			return storage.getFullPath().toString();
		}
		return null;
	}
}
