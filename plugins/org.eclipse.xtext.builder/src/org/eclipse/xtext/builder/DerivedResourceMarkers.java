/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.Constants;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class DerivedResourceMarkers {

	public final static String MARKER_ID = "org.eclipse.xtext.builder.derivedresource"; 
	public final static String ATTR_SOURCE = "source"; 
	public final static String ATTR_GENERATOR = "generator"; 
	
	public static class GeneratorIdProvider {
		@Inject
		@Named(Constants.LANGUAGE_NAME)
		private String languageName;
		
		public String getGeneratorIdentifier() {
			return languageName;
		}
	}
	
	@Inject
	private GeneratorIdProvider generatorIdProvider;

	public List<IFile> findDerivedResources(IContainer container, String source) throws CoreException {
		return findDerivedResources(container,generatorIdProvider.getGeneratorIdentifier(), source);
	}
	
	public List<IFile> findDerivedResources(IContainer container, String generator, String source) throws CoreException {
		List<IFile> result = newArrayList();
		if (!container.exists())
			return result;
		IMarker[] markers = container.findMarkers(MARKER_ID, true, IResource.DEPTH_INFINITE);
		for (IMarker iMarker : markers) {
			if (generator.equals(iMarker.getAttribute(ATTR_GENERATOR))) {
				if (source == null || source.equals(iMarker.getAttribute(ATTR_SOURCE))) {
					result.add((IFile) iMarker.getResource());
				}
			}
		}
		return result;
	}
	
	public IMarker[] findDerivedResourceMarkers(IFile file) throws CoreException {
		return file.findMarkers(MARKER_ID, true, IResource.DEPTH_ZERO);
	}
	
	public IMarker findDerivedResourceMarker(IFile file, String source) throws CoreException {
		return findDerivedResourceMarker(file, generatorIdProvider.getGeneratorIdentifier(), source);
	}
	
	public IMarker findDerivedResourceMarker(IFile file, String generator, String source) throws CoreException {
		IMarker[] markers = findDerivedResourceMarkers(file);
		for (IMarker iMarker : markers) {
			if (generator.equals(iMarker.getAttribute(ATTR_GENERATOR)) && source.equals(iMarker.getAttribute(ATTR_SOURCE)))
				return iMarker;
		}
		return null;
	}
	
	public String getSource(IMarker marker) {
		try {
			Object result = marker.getAttribute(ATTR_SOURCE);
			if (result instanceof String)
				return (String) result;
			return null;
		} catch (CoreException e) {
			return null;
		}
	}
	
	public boolean installMarker(IFile file, String source) throws CoreException {
		return installMarker(file, generatorIdProvider.getGeneratorIdentifier(), source);
	}
	
	public boolean installMarker(IFile file, String generator, String source) throws CoreException {
		if (!file.exists())
			return false;
		IMarker[] markers = file.findMarkers(MARKER_ID, true, IResource.DEPTH_INFINITE);
		for (IMarker marker : markers) {
			if (generator.equals(marker.getAttribute(ATTR_GENERATOR))
				&& source.equals(marker.getAttribute(ATTR_SOURCE)))
				return true;
		}
		IMarker marker = file.createMarker(MARKER_ID);
		marker.setAttribute(ATTR_GENERATOR, generator);
		marker.setAttribute(ATTR_SOURCE, source);
		return true;
	}
}
