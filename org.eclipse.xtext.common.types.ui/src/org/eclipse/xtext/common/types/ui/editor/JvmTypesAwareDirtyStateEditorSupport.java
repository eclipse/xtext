/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.editor;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.editor.DirtyStateEditorSupport;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class JvmTypesAwareDirtyStateEditorSupport extends DirtyStateEditorSupport {
	
	@Override
	protected void processDelta(IResourceDescription.Delta delta, Resource context, List<Resource> result) {
		super.processDelta(delta, context, result);
		ResourceSet resourceSet = context.getResourceSet();
		if(delta.getNew() != null){
			Iterable<IEObjectDescription> exportedJvmTypes = delta.getNew().getExportedObjectsByType(TypesPackage.Literals.JVM_GENERIC_TYPE);
			for(IEObjectDescription jvmTypeDesc : exportedJvmTypes){
				URI uriToJvmType = URIHelperConstants.OBJECTS_URI.appendSegment(jvmTypeDesc.getQualifiedName().toString());
				Resource jvmResourceInResourceSet = resourceSet.getResource(uriToJvmType, false);
				if(jvmResourceInResourceSet != null)
					result.add(jvmResourceInResourceSet);
			}
		}
	}
}
