/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.internal.AbstractTrace;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfig;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfigProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.workspace.IProjectConfig;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractEclipseTrace extends AbstractTrace implements IEclipseTrace {

	@Inject
	private IStorage2UriMapper storage2uriMapper;
	
	@Inject
	private IWorkspace workspace;
	
	@Inject
	private EclipseProjectConfigProvider projectConfigProvider;
	
	protected IProject findProject(String projectName) {
		IProject result = workspace.getRoot().getProject(projectName);
		return result;
	}

	protected IWorkspace getWorkspace() {
		return workspace;
	}

	protected IStorage2UriMapper getStorage2uriMapper() {
		return storage2uriMapper;
	}
	
	protected AbsoluteURI getURIForStorage(IStorage storage) {
		final URI uri = storage2uriMapper.getUri(storage);
		if (uri != null) {
			return new AbsoluteURI(uri);
		}
		return new AbsoluteURI(URI.createPlatformResourceURI(storage.getFullPath().toString(), true));
	}
	
	protected abstract IStorage findStorage(SourceRelativeURI srcRelativeLocation, IProject project);

	@Override
	protected InputStream getContents(SourceRelativeURI uri) throws IOException {
		return getContents(uri, ((EclipseProjectConfig) getLocalProjectConfig()).getProject());
	}

	protected abstract InputStream getContents(SourceRelativeURI uri, IProject project) throws IOException;

	@Override
	protected Reader getContentsAsText(SourceRelativeURI uri) throws IOException {
		return getContentsAsText(uri, ((EclipseProjectConfig) getLocalProjectConfig()).getProject());
	}

	protected abstract Reader getContentsAsText(SourceRelativeURI uri, IProject projectConfig) throws IOException;

	@Override
	protected Reader getLocalContentsAsText() throws IOException {
		return getLocalContentsAsText(((EclipseProjectConfig) getLocalProjectConfig()).getProject());
	}

	protected abstract Reader getLocalContentsAsText(IProject project) throws IOException;

	/* @Nullable */
	@Override
	public ILocationInEclipseResource getBestAssociatedLocation(ITextRegion region, IStorage associatedStorage) {
		AbsoluteURI uri = getURIForStorage(associatedStorage);
		return getBestAssociatedLocation(region, uri);
	}

	@Override
	public Iterable<? extends ILocationInEclipseResource> getAllAssociatedLocations(ITextRegion localRegion,
			IStorage associatedStorage) {
		AbsoluteURI uri = getURIForStorage(associatedStorage);
		return getAllAssociatedLocations(localRegion, uri);
	}

	@Override
	public Iterable<? extends ILocationInEclipseResource> getAllAssociatedLocations(IStorage associatedStorage) {
		AbsoluteURI uri = getURIForStorage(associatedStorage);
		return getAllAssociatedLocations(uri);
	}

	@Override
	public ILocationInEclipseResource getBestAssociatedLocation(ITextRegion region) {
		return (ILocationInEclipseResource) super.getBestAssociatedLocation(region);
	}

	@Override
	protected ILocationInEclipseResource createLocationInResource(ITextRegionWithLineInformation region, SourceRelativeURI srcRelativePath) {
		return new LocationInEclipseResource(region.getOffset(), region.getLength(), region.getLineNumber(), region.getEndLineNumber(), srcRelativePath, this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<? extends ILocationInEclipseResource> getAllAssociatedLocations(ITextRegion localRegion) {
		return (Iterable<? extends ILocationInEclipseResource>) super.getAllAssociatedLocations(localRegion);
	}

	@Override
	public ILocationInEclipseResource getBestAssociatedLocation(ITextRegion localRegion, AbsoluteURI uri) {
		return (ILocationInEclipseResource) super.getBestAssociatedLocation(localRegion, uri);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<? extends ILocationInEclipseResource> getAllAssociatedLocations(ITextRegion localRegion, AbsoluteURI uri) {
		return (Iterable<? extends ILocationInEclipseResource>) super.getAllAssociatedLocations(localRegion, uri);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<? extends ILocationInEclipseResource> getAllAssociatedLocations(AbsoluteURI uri) {
		return (Iterable<? extends ILocationInEclipseResource>) super.getAllAssociatedLocations(uri);
	}

	@Override
	public IProjectConfig getLocalProjectConfig() {
		return projectConfigProvider.createProjectConfig(getLocalProject());
	}
	
	abstract public IProject getLocalProject();

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<? extends ILocationInEclipseResource> getAllAssociatedLocations() {
		return (Iterable<? extends ILocationInEclipseResource>) super.getAllAssociatedLocations();
	}
	
}
