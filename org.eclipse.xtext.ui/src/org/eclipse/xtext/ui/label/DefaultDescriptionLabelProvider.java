/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.label;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultDescriptionLabelProvider extends DeclarativeLabelProvider {

	@Inject
	private IStorage2UriMapper storage2UriMapper;

	@Inject
	private DefaultEditorImageUtil imageUtil;

	public Object image(IEObjectDescription element) {
		return doGetImage(element.getEClass());
	}

	public Object image(IResourceDescription element) {
		return getImageForURI(element.getURI());
	}

	/**
	 * This method is only invoked if the containerEObjectURI of the {@link IReferenceDescription} is null, i.e. the
	 * reference is owned by an element without any indexed container.
	 * 
	 * @since 2.1
	 */
	public Object image(IReferenceDescription referenceDescription) {
		if (referenceDescription.getSourceEObjectUri() != null)
			return getImageForURI(referenceDescription.getSourceEObjectUri());
		return null;
	}

	/**
	 * @since 2.1
	 */
	protected Object getImageForURI(URI uri) {
		String fileName = uri.lastSegment();
		return imageUtil.getDefaultEditorImageDescriptor(fileName);
	}

	public Object text(IEObjectDescription element) {
		return element.getQualifiedName() + " - " + element.getEClass().getName();
	}

	public Object text(IResourceDescription element) {
		Iterator<Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(element.getURI()).iterator();
		if (storages.hasNext()) {
			IStorage storage = storages.next().getFirst();
			return storage.getFullPath().toString();
		}
		return null;
	}

	/**
	 * This method is only invoked if the containerEObjectURI of the {@link IReferenceDescription} is null, i.e. the
	 * reference is owned by an element without any indexed container.
	 * 
	 * @since 2.1
	 */
	public Object text(IReferenceDescription referenceDescription) {
		return "<unnamed>";
	}

}
