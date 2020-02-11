/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder;

import static com.google.common.collect.Lists.*;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.generator.IDerivedResourceMarkers;
import org.eclipse.xtext.util.Exceptions;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class DerivedResourceMarkers implements IDerivedResourceMarkers {

	public final static String MARKER_ID = "org.eclipse.xtext.builder.derivedresource"; 
	public final static String ATTR_SOURCE = "source"; 
	public final static String ATTR_GENERATOR = "generator"; 
	
	public static class GeneratorIdProvider {
		@Inject(optional = true)
		@Named(Constants.LANGUAGE_NAME)
		private String languageName = "no-language";
		
		public String getGeneratorIdentifier() {
			return languageName;
		}
	}
	
	@Inject
	private GeneratorIdProvider generatorIdProvider;
	
	/**
	 * @since 2.3
	 */
	public List<IMarker> findGeneratorMarkers(IContainer container) throws CoreException {
		return findGeneratorMarkers(container, generatorIdProvider.getGeneratorIdentifier());
	}
	
	/**
	 * @since 2.3
	 */
	public List<IMarker> findGeneratorMarkers(IContainer container, String generator) throws CoreException {
		List<IMarker> result = newArrayList();
		if (!container.exists())
			return result;
		IMarker[] markers = container.findMarkers(MARKER_ID, true, IResource.DEPTH_INFINITE);
		for (IMarker marker : markers) {
			if (generator.equals(marker.getAttribute(ATTR_GENERATOR)))
				result.add(marker);
		}
		return result;
	}
	
	/**
	 * @since 2.3
	 */
	public List<IFile> findDerivedResources(List<IMarker> generatorMarkers, String source) throws CoreException {
		List<IFile> result = newArrayList();
		for (IMarker marker : generatorMarkers) {
			if (marker.exists() && (source == null || source.equals(marker.getAttribute(ATTR_SOURCE)))) {
				result.add((IFile)marker.getResource());
			}
		}
		return result;
	}
	
	@Override
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
	
	@Deprecated
	public IMarker[] findDerivedResourceMarkers(IFile file) throws CoreException {
		return findDerivedResourceMarkers((IResource)file);
	}
	
	/**
	 * @since 2.3
	 */
	@Override
	public IMarker[] findDerivedResourceMarkers(IResource file) throws CoreException {
		if (!file.isAccessible())
			return new IMarker[0];
		return file.findMarkers(MARKER_ID, true, IResource.DEPTH_INFINITE);
	}
	
	/**
	 * @since 2.3
	 */
	@Override
	public Iterable<IMarker> findDerivedResourceMarkers(IResource file, final String generatorId) throws CoreException {
		Iterable<IMarker> filtered = Iterables.filter(Arrays.asList(findDerivedResourceMarkers(file)), new Predicate<IMarker>() {
			@Override
			public boolean apply(IMarker input) {
				if (input.exists()) {
					try {
						if (generatorId != null && generatorId.equals(input.getAttribute(ATTR_GENERATOR))) {
							return true;
						}
					} catch (CoreException e) {
						return Exceptions.throwUncheckedException(e);
					}
				}
				return false;
			}
		});
		// filter only once
		return Lists.newArrayList(filtered);
	}
	
	@Override
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
	
	@Override
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
	
	@Override
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
