/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.collect.Lists;

/**
 * A slot entry filtering all contents of the resource set rather than the exported objects only.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ResourceSetBasedSlotEntry extends SlotEntry {

	@Override
	protected List<EObject> findEObjectsOfType(Set<EClass> eClasses, IResourceDescriptions resourceDescriptions,
			ResourceSet resourceSet) {
		List<EObject> result = Lists.newArrayList();
		for (Resource resource : resourceSet.getResources()) {
			if (!resource.isLoaded()) {
				try {
					resource.load(null);
				} catch (IOException e) {
					throw new WrappedException(e);
				}
			}
		}
		for (Iterator<Notifier> i = resourceSet.getAllContents(); i.hasNext();) {
			Notifier next = i.next();
			if (next instanceof EObject && matches(eClasses, (EObject) next)) {
				result.add((EObject) next);
			}
		}
		return result;
	}

	protected boolean matches(Set<EClass> eClasses, EObject eObject) {
		if(eClasses.isEmpty()) {
			return true;
		}
		EClass candidateEClass = eObject.eClass();
		for (EClass eClass: eClasses) {
			if(EcorePackage.Literals.EOBJECT == eClass || eClass.isSuperTypeOf(candidateEClass)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void setName(String name) {
		throw new UnsupportedOperationException("This implementation does not support name filtering.");
	}
	
}
