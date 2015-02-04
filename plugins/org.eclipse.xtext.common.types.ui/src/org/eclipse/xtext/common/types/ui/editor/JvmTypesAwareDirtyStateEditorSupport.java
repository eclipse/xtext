/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.editor;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.ui.editor.DirtyStateEditorSupport;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class JvmTypesAwareDirtyStateEditorSupport extends DirtyStateEditorSupport {
	
	@Override
	protected Collection<Resource> collectAffectedResources(XtextResource resource, Event event) {
		List<Resource> result = Lists.newArrayListWithExpectedSize(4);
		ResourceSet resourceSet = resource.getResourceSet();
		URIConverter converter = resourceSet.getURIConverter();
		Set<URI> normalizedURIs = Sets.newHashSetWithExpectedSize(event.getDeltas().size());
		for(IResourceDescription.Delta delta: event.getDeltas()) {
			normalizedURIs.add(converter.normalize(delta.getUri()));
			if(delta.getNew() != null){
				Iterable<IEObjectDescription> exportedJvmTypes = delta.getNew().getExportedObjectsByType(TypesPackage.Literals.JVM_GENERIC_TYPE);
				for(IEObjectDescription jvmTypeDesc : exportedJvmTypes){
					normalizedURIs.add(URIHelperConstants.OBJECTS_URI.appendSegment(jvmTypeDesc.getQualifiedName().toString()));
				}
			}
		}
		List<Resource> resources = resourceSet.getResources();
		for(int i = 0; i< resources.size(); i++) {
			Resource res = resources.get(i);
			if (res != resource && res != null) {
				URI uri = res.getURI();
				try {
					uri = converter.normalize(uri);
				} catch (org.eclipse.xtext.resource.ClasspathUriResolutionException e) {
					// ignore, since the classpath might be broken.
				}
				if (normalizedURIs.contains(uri))
					result.add(res);
			}
		}
		return result;
	}
}
