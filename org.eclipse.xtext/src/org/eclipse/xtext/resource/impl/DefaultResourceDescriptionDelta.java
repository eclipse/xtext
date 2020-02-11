/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.Arrays;

import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultResourceDescriptionDelta implements IResourceDescription.Delta {

	private IResourceDescription _new;
	private IResourceDescription old;

	public DefaultResourceDescriptionDelta(IResourceDescription old, IResourceDescription _new) {
		super();
		if (old == _new) {
			throw new AssertionError("'old!=_new' constraint violated");
		}
		if (_new != null && old != null && !old.getURI().equals(_new.getURI())) {
			URI oldURI = old.getURI();
			URI newURI = _new.getURI();
			throw new AssertionError(
					"'_new!=null && old!=null && !old.getURI().equals(_new.getURI())' constraint violated, old was "
							+ oldURI + " new was: " + newURI);
		}
		this.old = old;
		this._new = _new;
	}

	@Override
	public IResourceDescription getNew() {
		return _new;
	}

	@Override
	public IResourceDescription getOld() {
		return old;
	}

	private Boolean hasChanges;

	@Override
	public boolean haveEObjectDescriptionsChanged() {
		if (hasChanges == null) {
			hasChanges = internalHasChanges();
		}
		return hasChanges.booleanValue();
	}

	protected boolean internalHasChanges() {
		if (_new == null || old == null)
			return true;

		Iterable<IEObjectDescription> oldEObjects = old.getExportedObjects();
		Iterable<IEObjectDescription> newEObjects = _new.getExportedObjects();
		if (Iterables.size(oldEObjects) != Iterables.size(newEObjects))
			return true;

		Iterator<IEObjectDescription> iterator1 = oldEObjects.iterator();
		Iterator<IEObjectDescription> iterator2 = newEObjects.iterator();
		while (iterator1.hasNext()) {
			if (!equals(iterator1.next(), iterator2.next()))
				return true;
		}
		return false;
	}

	protected boolean equals(IEObjectDescription oldObj, IEObjectDescription newObj) {
		if (oldObj == newObj)
			return true;
		if (oldObj.getEClass() != newObj.getEClass())
			return false;
		if (oldObj.getName() != null && !oldObj.getName().equals(newObj.getName()))
			return false;
		if (!oldObj.getEObjectURI().equals(newObj.getEObjectURI()))
			return false;
		String[] oldKeys = oldObj.getUserDataKeys();
		String[] newKeys = newObj.getUserDataKeys();
		if (oldKeys.length != newKeys.length)
			return false;
		for (String key : oldKeys) {
			if (!Arrays.contains(newKeys, key))
				return false;
			String oldValue = oldObj.getUserData(key);
			String newValue = newObj.getUserData(key);
			if (oldValue == null) {
				if (newValue != null)
					return false;
			} else if (!oldValue.equals(newValue)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public URI getUri() {
		return old == null ? _new.getURI() : old.getURI();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " for " + getUri() + " old :" + (getOld() != null) + ",new :"
				+ (getNew() != null);
	}
}
