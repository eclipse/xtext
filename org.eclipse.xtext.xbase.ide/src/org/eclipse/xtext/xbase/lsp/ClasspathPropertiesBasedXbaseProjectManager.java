/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lsp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.JvmTypeChangeDispatcher;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.IClassMirror;
import org.eclipse.xtext.common.types.descriptions.TypeResourceDescription;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @since 2.35
 */
public class ClasspathPropertiesBasedXbaseProjectManager extends ProjectManager {
	
	private static final Predicate<String> CP = Pattern.compile("^\\w+\\.(bin|cp).\\d+$").asPredicate();
	
	private static final Logger LOGGER = Logger.getLogger(ClasspathPropertiesBasedFileSystemScanner.class);
	
	@Inject
	private ClasspathPropertiesBasedFileSystemScanner classpathScanner;
	
	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	private final ForwardingClassLoader classpathURIContext = new ForwardingClassLoader();

	private Properties projectClasspath;

	@Override
	public void initialize(ProjectDescription description, IProjectConfig projectConfig,
			Procedure2<? super URI, ? super Iterable<Issue>> acceptor,
			IExternalContentProvider openedDocumentsContentProvider,
			Provider<Map<String, ResourceDescriptionsData>> indexProvider, CancelIndicator cancelIndicator) {
		super.initialize(description, projectConfig, acceptor, openedDocumentsContentProvider, indexProvider, cancelIndicator);
		
		projectClasspath = classpathScanner.getProjectClasspath(projectConfig.getPath());
		updateClassLoader();
	}

	protected void updateClassLoader() {
		if (projectClasspath != null) {
			Set<String> urls = new LinkedHashSet<>();
			projectClasspath.forEach((k, v) -> {
				String key = (String) k;
				String value = (String) v;
				if (CP.test(key)) {
					urls.add(value);
				}
			});
			URL[] cp = urls.stream().map(p -> {
				try {
					return new File(p).toURI().toURL();
				} catch (MalformedURLException e) {
					LOGGER.error(e.getMessage(), e);
					return null;
				}
			}).filter(Objects::nonNull).toArray(URL[]::new);
			classpathURIContext.setDelegate(new URLClassLoader(cp, ClassLoader.getPlatformClassLoader()));
			clearTypesCache();
		}
	}

	protected void clearTypesCache() {
		XtextResourceSet resourceSet = getResourceSet();
		if (resourceSet != null) {
			IJvmTypeProvider typeProvider = typeProviderFactory.findTypeProvider(resourceSet);
			if (typeProvider != null) {
				typeProvider.clearCache();
			}
			JvmTypeChangeDispatcher dispatcher = JvmTypeChangeDispatcher.findResourceChangeDispatcher(resourceSet);
			EObject dummy = EcoreFactory.eINSTANCE.createEObject();
			dispatcher.requestNotificationOnChange(dummy, ()->{});
			dummy.eNotify(new NotificationImpl(Notification.ADD, true, false));
		}
	}
	
	@Override
	protected BuildRequest newBuildRequest(List<URI> changedFiles, List<URI> deletedFiles, List<Delta> externalDeltas,
			CancelIndicator cancelIndicator) {
		Map<String, List<URI>> locationToTypeURI = null;
		List<URI> changedTypeResources = new ArrayList<>();
		for(URI changedFile: changedFiles) {
			if (ClasspathPropertiesBasedFileSystemScanner.XTEXT_CLASSPATH.equals(changedFile.lastSegment())) {
				Properties prev = projectClasspath;
				projectClasspath = classpathScanner.getProjectClasspath(getProjectConfig().getPath());
				updateClassLoader();
				
				if (locationToTypeURI == null) {
					locationToTypeURI = collectLocationURIs();
				}
				changedTypeResources.addAll(collectAffectedTypeResources(prev, projectClasspath, locationToTypeURI));
			} else if ("class".equals(changedFile.fileExtension())) {
				if (locationToTypeURI == null) {
					locationToTypeURI = collectLocationURIs();
				}
				List<URI> resources = locationToTypeURI.get(changedFile.toFileString());
				if (resources != null) {
					changedTypeResources.addAll(resources);
				}
			}
		}
		if (!changedTypeResources.isEmpty()) {
			changedFiles.addAll(changedTypeResources);
			for(URI changedTypeResource: changedTypeResources) {
				QualifiedName qn = qualifiedNameConverter.toQualifiedName(changedTypeResource.lastSegment());
				externalDeltas.add(new TypeResourceDescription.ChangedDelta(qn));
			}
			clearTypesCache();
		}
		return super.newBuildRequest(changedFiles, deletedFiles, externalDeltas, cancelIndicator);
	}
	
	private Map<String, List<URI>> collectLocationURIs() {
		Map<String, List<URI>> result = new HashMap<>();
		XtextResourceSet resourceSet = getResourceSet();
		if (resourceSet != null) {
			for(Resource resource: resourceSet.getResources()) {
				if (resource instanceof TypeResource) {
					IMirror mirror = ((TypeResource) resource).getMirror();
					if (mirror instanceof IClassMirror) {
						URI locationURI = ((IClassMirror) mirror).getLocationURI(resource);
						if (locationURI != null) {
							String locationString;
							if (locationURI.isArchive()) {
								String authority = locationURI.authority();
								locationString = URI.createURI(authority.substring(0, authority.length() - 1), true).toFileString();
							} else {
								locationString = new UriExtensions().withEmptyAuthority(locationURI).toFileString();
							}
							if (locationString != null) {
								result.computeIfAbsent(locationString, any->new ArrayList<>()).add(resource.getURI());
							}
						}
					}
				}
			}
		}
		return result;
	}

	protected List<URI> collectAffectedTypeResources(Properties oldClasspath, Properties newClasspath,
			Map<String, List<URI>> locationToTypeURI) {
		List<URI> result = new ArrayList<>();
		if (locationToTypeURI != null && oldClasspath != null) {
			Map<String, String> oldHashes = locationHashes(oldClasspath);
			Map<String, String> newHashes = locationHashes(newClasspath);
			MapDifference<String,String> difference = Maps.difference(oldHashes, newHashes);
			for(String diff: difference.entriesDiffering().keySet()) {
				List<URI> resources = locationToTypeURI.get(diff);
				if (resources != null) {
					result.addAll(resources);
				}
			}
			for(String diff: difference.entriesOnlyOnLeft().keySet()) {
				List<URI> resources = locationToTypeURI.get(diff);
				if (resources != null) {
					result.addAll(resources);
				}
			}
		}
		return result;
	}
	
	protected static Map<String, String> locationHashes(Properties config) {
		Map<String, String> result = new HashMap<>();
		config.forEach((k, v) -> {
			String key = (String) k;
			String value = (String) v;
			if (CP.test(key)) {
				String hash = (String) config.get(k + ".hash");
				if (hash != null) {
					result.put(value, hash);
				}
			}
		});
		return result;
	}

	@Override
	protected XtextResourceSet createFreshResourceSet(ResourceDescriptionsData newIndex) {
		XtextResourceSet result = super.createFreshResourceSet(newIndex);
		return result;
	}
	
	@Override
	public XtextResourceSet createNewResourceSet(ResourceDescriptionsData newIndex) {
		XtextResourceSet result = super.createNewResourceSet(newIndex);
		result.setClasspathURIContext(classpathURIContext);
		typeProviderFactory.createTypeProvider(result);
		return result;
	}

}
