/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl;
import org.eclipse.xtext.builder.builderState.impl.ReferenceDescriptionImpl;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 */
public class BuilderStateUtil {
	
	public static ResourceDescriptionImpl create(IResourceDescription desc) {
		if (desc instanceof ResourceDescriptionImpl)
			return (ResourceDescriptionImpl) desc;
		ResourceDescriptionImpl result = (ResourceDescriptionImpl) BuilderStateFactory.eINSTANCE.createResourceDescription();
		result.setURI(desc.getURI());
		copyExportedObject(desc, result);
		copyReferenceDescriptions(desc, result);
		copyImportedNames(desc, result);
		return result;
	}

	public static void copyImportedNames(IResourceDescription from, ResourceDescriptionImpl result) {
		Iterable<QualifiedName> importedNames = from.getImportedNames();
		if (importedNames instanceof Collection<?>) {
			Collection<? extends QualifiedName> sourceImportedNames = (Collection<? extends QualifiedName>) importedNames;
			if (!sourceImportedNames.isEmpty()) {
				InternalEList<QualifiedName> targetImportedNames = (InternalEList<QualifiedName>) result.getImportedNames();
				targetImportedNames.addAllUnique(sourceImportedNames);
			}
		} else {
			Iterator<QualifiedName> importedNamesIterator = importedNames.iterator();
			if (importedNamesIterator.hasNext()) {
				InternalEList<QualifiedName> targetImportedNames = (InternalEList<QualifiedName>) result.getImportedNames();
				do {
					targetImportedNames.addUnique(importedNamesIterator.next());
				} while(importedNamesIterator.hasNext());
			}
		}
	}

	public static void copyReferenceDescriptions(IResourceDescription from, ResourceDescriptionImpl result) {
		Iterator<IReferenceDescription> sourceReferenceDescriptions = from.getReferenceDescriptions().iterator();
		if (sourceReferenceDescriptions.hasNext()) {
			InternalEList<IReferenceDescription> targetReferenceDescriptions = (InternalEList<IReferenceDescription>) result.getReferenceDescriptions();
			do {
				targetReferenceDescriptions.addUnique(BuilderStateUtil.create(sourceReferenceDescriptions.next()));	
			} while(sourceReferenceDescriptions.hasNext());
		}
	}

	public static void copyExportedObject(IResourceDescription from, ResourceDescriptionImpl result) {
		Iterator<IEObjectDescription> sourceExportedObjects = from.getExportedObjects().iterator();
		if (sourceExportedObjects.hasNext()) {
			InternalEList<IEObjectDescription> targetExportedObjects = (InternalEList<IEObjectDescription>) result.getExportedObjects();
			do {
				targetExportedObjects.addUnique(BuilderStateUtil.create(sourceExportedObjects.next()));
			} while(sourceExportedObjects.hasNext());
		}
	}
	
	public static ReferenceDescriptionImpl create(IReferenceDescription desc) {
		ReferenceDescriptionImpl description = (ReferenceDescriptionImpl) BuilderStateFactory.eINSTANCE.createReferenceDescription();
		description.setIndexInList(desc.getIndexInList());
		description.setSourceEObjectUri(desc.getSourceEObjectUri());
		description.setTargetEObjectUri(desc.getTargetEObjectUri());
		description.setReference(desc.getEReference());
		description.setContainerEObjectURI(desc.getContainerEObjectURI());
		return description;
	}

	public static EObjectDescriptionImpl create(IEObjectDescription desc) {
		EObjectDescriptionImpl objectDescription = (EObjectDescriptionImpl) BuilderStateFactory.eINSTANCE.createEObjectDescription();
		objectDescription.setEClass(desc.getEClass());
		objectDescription.setFragment(desc.getEObjectURI().fragment());
		objectDescription.setName(desc.getName());
		for (String key : desc.getUserDataKeys()) {
			objectDescription.getUserData().put(key, desc.getUserData(key));
		}
		return objectDescription;
	}
}
