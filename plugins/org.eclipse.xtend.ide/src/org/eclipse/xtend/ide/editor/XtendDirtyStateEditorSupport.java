/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import static com.google.common.collect.Sets.*;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.DirtyStateEditorSupport;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendDirtyStateEditorSupport extends DirtyStateEditorSupport {

	@Override
	protected Collection<Resource> collectAffectedResources(XtextResource resource, Event event) {
		ResourceSet resourceSet = resource.getResourceSet();
		for (IResourceDescription.Delta delta : event.getDeltas()) {
			if (haveReferencedJvmElementsChangedInXtend(resourceSet, delta)) {
				Set<Resource> affectedResources = newHashSet(resourceSet.getResources());
				affectedResources.remove(resource);
				return affectedResources;
			}
		}
		return super.collectAffectedResources(resource, event);
	}

	private boolean haveReferencedJvmElementsChangedInXtend(ResourceSet resourceSet, IResourceDescription.Delta delta) {
		if (delta.haveEObjectDescriptionsChanged())
			return isInferredJvmElementLoadedAsTypeResource(delta.getOld(), resourceSet)
					|| isInferredJvmElementLoadedAsTypeResource(delta.getNew(), resourceSet);
		else
			return false;
	}

	protected boolean isInferredJvmElementLoadedAsTypeResource(IResourceDescription resourceDescription,
			ResourceSet loadedResources) {
		if (resourceDescription != null) {
			for (IEObjectDescription exported : resourceDescription.getExportedObjects()) {
				EClass eClass = exported.getEClass();
				if (eClass != null && TypesPackage.Literals.JVM_DECLARED_TYPE.isSuperTypeOf(eClass)) {
					QualifiedName qualifiedName = exported.getQualifiedName();
					URI uri = URI.createURI("java:/Objects").appendSegment(qualifiedName.toString());
					if (loadedResources.getResource(uri, false) != null)
						return true;
				}
			}
		}
		return false;
	}
}
