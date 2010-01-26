/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.resource;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IStorage;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DefaultDescriptionLabelProvider extends LabelProvider implements IDescriptionLabelProvider {

	private ImageRegistry imageRegistry = new ImageRegistry();
	
	@Inject
	private IStorage2UriMapper storage2UriMapper;

	private static final Logger LOG = Logger.getLogger(DefaultDescriptionLabelProvider.class);

	@Override
	public Image getImage(Object description) {
		if (description instanceof IResourceDescription) {
			try {
				IEditorDescriptor defaultEditor = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
						((IResourceDescription) description).getURI().lastSegment());
				Image image = imageRegistry.get(defaultEditor.getId());
				if (image == null) {
					image = defaultEditor.getImageDescriptor().createImage();
					imageRegistry.put(defaultEditor.getId(), image);
				}
				return image;
			} catch (Exception exc) {
				LOG.error("Error finding image for resource descriptor", exc);
			}
		}
		return null;
	}

	@Override
	public String getText(Object description) {
		if (description == null) {
			return "<null>";
		} else if (description instanceof IEObjectDescription) {
			IEObjectDescription eObjectDescription = (IEObjectDescription) description;
			return eObjectDescription.getQualifiedName() + " - " + eObjectDescription.getEClass().getName();
		} else if (description instanceof IResourceDescription) {
			Iterator<IStorage> storages = storage2UriMapper.getStorages(((IResourceDescription) description).getURI())
					.iterator();
			if (storages.hasNext()) {
				return storages.next().toString();
			}
		}
		return description.toString();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		imageRegistry.dispose();
	}
}
