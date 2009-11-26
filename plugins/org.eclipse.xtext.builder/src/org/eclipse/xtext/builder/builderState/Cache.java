/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.builderState.BuilderStatePackage;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.collect.Maps;

public class Cache extends AdapterImpl {
	private Map<URI,IResourceDescription> uri2ResourceDescription = Maps.newHashMap();
	private Map<String,IResourceDescription> storage2ResourceDescription = Maps.newHashMap();
	
	@SuppressWarnings("unchecked")
	@Override
	public void notifyChanged(Notification msg) {
		if (msg.getFeature()==BuilderStatePackage.Literals.BUILDER_STATE__RESOURCE_DESCRIPTIONS) {
			switch (msg.getEventType()) {
				case Notification.ADD :
					IResourceDescription desc = (IResourceDescription) msg.getNewValue();
					register(desc);
					break;
				case Notification.ADD_MANY :
					List<IResourceDescription> descs = (List<IResourceDescription>) msg.getNewValue();
					for (IResourceDescription desc1 : descs) {
						register(desc1);
					}
					break;
				case Notification.REMOVE :
					IResourceDescription desc2 = (IResourceDescription) msg.getOldValue();
					deregister(desc2);
					break;
				case Notification.REMOVE_MANY :
					List<IResourceDescription> descs1 = (List<IResourceDescription>) msg.getOldValue();
					for (IResourceDescription desc3 : descs1) {
						deregister(desc3);
					}
					break;
			}
		}
		super.notifyChanged(msg);
	}
	
	private void deregister(IResourceDescription desc2) {
		uri2ResourceDescription.remove(desc2.getURI());
		storage2ResourceDescription.remove(((ResourceDescriptionImpl)desc2).getPathToStorage());
	}

	private void register(IResourceDescription desc) {
		uri2ResourceDescription.put(desc.getURI(),desc);
		storage2ResourceDescription.put(((ResourceDescriptionImpl)desc).getPathToStorage(),desc);
	}

	public IResourceDescription getResourceDescription(URI uri) {
		return uri2ResourceDescription.get(uri);
	}

	public IResourceDescription getResourceDescriptionForStorage(String externalStorageForm) {
		return storage2ResourceDescription.get(externalStorageForm);
	}
}