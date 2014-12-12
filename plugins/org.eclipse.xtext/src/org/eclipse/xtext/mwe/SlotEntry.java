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
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Jan Koehnlein - introduced QualifiedName
 */
public class SlotEntry implements ISlotEntry {
	
	private String slot = "model";
	private String name;
	private String namespaceDelimiter = ".";
	private String nsURI;
	private String type;
	private boolean firstOnly = false;

	private static final Logger log = Logger.getLogger(SlotEntry.class);

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

	public String getNamespaceDelimiter() {
		return namespaceDelimiter;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	/**
	 * The delimiter to use for the names. When not set the dot (".") is used.
	 * Must be set to an empty string ("") if no delimiter should be used.
	 */
	public void setNamespaceDelimiter(String namespaceDelimiter) {
		this.namespaceDelimiter = namespaceDelimiter;
	}

	public void setFirstOnly(boolean firstOnly) {
		this.firstOnly = firstOnly;
	}

	public boolean isFirstOnly() {
		return firstOnly;
	}
	
	@Override
	public void put(WorkflowContext ctx, IResourceDescriptions resourceDescriptions, ResourceSet resourceSet) {
		Set<EClass> eClasses = findEClasses(resourceSet, nsURI, type);
		List<EObject> elements = findEObjectsOfType(eClasses, resourceDescriptions, resourceSet);
		if (elements.isEmpty()) {
			log.warn("Could not find any exported element of type '" + type + "' -> Slot '" + slot + "' is empty.");
			ctx.set(slot, Collections.emptyList());
		} else if (firstOnly) {
			ctx.set(slot, elements.get(0));
		} else {
			ctx.set(slot, elements);
		}
	}

	protected List<EObject> findEObjectsOfType(Set<EClass> eClasses, IResourceDescriptions resourceDescriptions,
			ResourceSet resourceSet) {
		List<EObject> elements = Lists.newArrayList();
		Iterable<IResourceDescription> descriptions = resourceDescriptions.getAllResourceDescriptions();
		for (IResourceDescription resDesc : descriptions) {
			Iterable<IEObjectDescription> objects = resDesc.getExportedObjects();
			for (IEObjectDescription description : objects) {
				if (matches(eClasses, description))
					elements.add(resourceSet.getEObject(description.getEObjectURI(), true));
			}
		}
		return elements;
	}

	protected Set<EClass> findEClasses(ResourceSet resourceSet, String nsURI2, String typeName2) {
		if (typeName2 == null)
			return Collections.emptySet();
		Set<EClass> result = Sets.newHashSet();
		Set<String> keySet = getNsUris();
		for (String string : keySet) {
			try {
				EPackage ePackage = resourceSet.getPackageRegistry().getEPackage(string);
				if (ePackage != null) {
					EClassifier classifier = ePackage.getEClassifier(typeName2);
					if (classifier instanceof EClass)
						result.add((EClass) classifier);
				}
			} catch(NoClassDefFoundError e) {
				throw new NoClassDefFoundError("NoClassDefFoundError while loading ePackage: " + string + " - " + e.getMessage());
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
			valid = valid || EcorePackage.Literals.EOBJECT == eClass || eClass.isSuperTypeOf(desc.getEClass());
		}
		if (name != null) {
			if (Strings.isEmpty(namespaceDelimiter)) {
				return valid && name.equals(desc.getName().toString());
			} else {
				QualifiedName qualifiedName = QualifiedName.create(name.split(Pattern.quote(getNamespaceDelimiter())));
				return valid && (qualifiedName == null || qualifiedName.equals(desc.getName()));
			}
		} 
		return valid;
	}

	protected EObject getEObject(IEObjectDescription description, ResourceSet resourceSet) {
		return resourceSet.getEObject(description.getEObjectURI(), true);
	}

	@Override
	public void preInvoke() {
		// TODO Auto-generated method stub
		
	}
}