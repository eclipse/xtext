/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.collect.Collections2;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultResourceDescriptionDelta implements IResourceDescription.Delta {
	
	private IResourceDescription _new;
	private IResourceDescription old;
	
	public DefaultResourceDescriptionDelta(IResourceDescription old, IResourceDescription _new) {
		super();
		if (old==_new) {
			throw new AssertionError("'old!=_new' constraint violated");
		}
		if (_new!=null && old!=null && !old.getURI().equals(_new.getURI())) {
			URI oldURI = old.getURI();
			URI newURI = _new.getURI();
			throw new AssertionError("'_new!=null && old!=null && !old.getURI().equals(_new.getURI())' constraint violated, old was" + 
					oldURI + " new was: " + newURI);
		}
		this.old = old;
		this._new = _new;
	}

	public IResourceDescription getNew() {
		return _new;
	}

	public IResourceDescription getOld() {
		return old;
	}
	
	private Boolean hasChanges;

	public boolean hasChanges() {
		if (hasChanges==null) {
			hasChanges = internalHasChanges();
		}
		return hasChanges.booleanValue();
	}
	
	protected boolean internalHasChanges() {
		if (_new==null || old==null)
			return true;
		
		Collection<IEObjectDescription> oldEObjects = Collections2.forIterable(old.getExportedObjects());
		Collection<IEObjectDescription> newEObjects = Collections2.forIterable(_new.getExportedObjects());
		if (oldEObjects.size()!=newEObjects.size())
			return true;
		
		Iterator<IEObjectDescription> iterator1 = oldEObjects.iterator();
		Iterator<IEObjectDescription> iterator2 = newEObjects.iterator();
		while (iterator1.hasNext()) {
			if (!equals(iterator1.next(),iterator2.next()))
				return true;
		}

		return false;
	}

	protected boolean equals(IEObjectDescription next, IEObjectDescription next2) {
		if (next.getEClass()!=next2.getEClass())
			return false;
		if (next.getName()!=null && !next.getName().equals(next2.getName()))
			return false;
		if (!next.getEObjectURI().equals(next2.getEObjectURI()))
			return false;
		if (!Arrays.equals(next.getUserDataKeys(),next2.getUserDataKeys()))
			return false;
		for (String key : next.getUserDataKeys()) {
			String userData = next.getUserData(key);
			String userData2 = next2.getUserData(key);
			if (userData!=userData2 || 
				(userData!=null && !userData.equals(userData2)))
				return false;
		}
		return true;
	}

	public URI getUri() {
		return old==null?_new.getURI():old.getURI();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+" for "+getUri()+" old :"+(getOld()!=null)+",new :"+(getNew()!=null);
	}
}
