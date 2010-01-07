/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class SlotEntry {
	private String slot = "model";
	private String name;
	private String nsURI;
	private String type;
	private boolean firstOnly = false;

	public void setType(String typeName) {
		this.type = typeName;
	}

	public void setNsURI(String nsURI) {
		this.nsURI = nsURI;
	}

	public SlotEntry() {
	}

	public String getName() {
		return name;
	}

	public String getSlot() {
		return slot;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public void setFirstOnly(boolean firstOnly) {
		this.firstOnly = firstOnly;
	}

	public boolean isFirstOnly() {
		return firstOnly;
	}

	public void put(WorkflowContext ctx, IResourceDescriptions resourceDescriptions, ResourceSet resourceSet) {
		Set<EClass> eclasses = findEClasses(resourceSet, nsURI, type);

		List<EObject> elements = Lists.newArrayList();
		Iterable<IResourceDescription> descriptions = resourceDescriptions.getAllResourceDescriptions();
		for (IResourceDescription resDesc : descriptions) {
			Iterable<IEObjectDescription> objects = resDesc.getExportedObjects();
			for (IEObjectDescription description : objects) {
				if (matches(eclasses, description))
					elements.add(resourceSet.getEObject(description.getEObjectURI(), true));
			}
		}
		if (firstOnly) {
			ctx.set(slot, elements.isEmpty() ? null : elements.get(0));
		} else {
			ctx.set(slot, elements);
		}
	}

	protected Set<EClass> findEClasses(ResourceSet resourceSet, String nsURI2, String typeName2) {
		if (typeName2 == null)
			return Collections.emptySet();
		Set<EClass> result = Sets.newHashSet();
		Set<String> keySet = getNsUris();
		for (String string : keySet) {
			EPackage ePackage = resourceSet.getPackageRegistry().getEPackage(string);
			if (ePackage != null) {
				EClassifier classifier = ePackage.getEClassifier(typeName2);
				if (classifier instanceof EClass)
					result.add((EClass) classifier);
			}
		}
		if (result.isEmpty()) {
			throw new WorkflowInterruptedException("Couldn't find EClass for name '" + typeName2 + "'.");
		}
		return result;
	}

	protected Set<String> getNsUris() {
		if (nsURI != null)
			return Collections.singleton(nsURI);
		return Sets.newHashSet(EPackage.Registry.INSTANCE.keySet());
	}

	protected boolean matches(Set<EClass> eclasses, IEObjectDescription desc) {
		boolean valid = eclasses.isEmpty();
		for (Iterator<EClass> iterator = eclasses.iterator(); !valid && iterator.hasNext();) {
			EClass eClass = iterator.next();
			valid = valid || eClass.isSuperTypeOf(desc.getEClass());
		}
		return valid && (name == null || name.equals(desc.getName()));
	}

	protected EObject getEObject(IEObjectDescription description, ResourceSet resourceSet) {
		return resourceSet.getEObject(description.getEObjectURI(), true);
	}
}