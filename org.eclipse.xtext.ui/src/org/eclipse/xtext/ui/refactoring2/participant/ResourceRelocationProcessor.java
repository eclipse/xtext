/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.refactoring2.participant;

import static org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.resource.MoveResourceChange;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange;
import org.eclipse.xtext.ide.refactoring.IResourceRelocationStrategy;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.refactoring2.ChangeConverter;
import org.eclipse.xtext.ui.refactoring2.LtkIssueAcceptor;
import org.eclipse.xtext.ui.refactoring2.ResourceURIConverter;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.LiveScopeResourceSetInitializer;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
public class ResourceRelocationProcessor {

	private static final Logger LOG = Logger.getLogger(ResourceRelocationProcessor.class);

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject
	private LiveScopeResourceSetInitializer liveScopeResourceSetInitializer;

	@Inject
	private LtkIssueAcceptor issues;

	@Inject
	private ResourceURIConverter resourceURIConverter;

	@Inject
	private Provider<IChangeSerializer> changeSerializerProvider;

	@Inject
	private ResourceRelocationStrategyRegistry strategyRegistry;

	@Inject
	private ChangeConverter.Factory changeConverterFactory;

	private final List<ResourceRelocationChange> uriChanges = new ArrayList<>();

	private final Set<IResource> excludedResources = new HashSet<>();

	private IProject project;

	public Change createChange(String name, ResourceRelocationContext.ChangeType type, IProgressMonitor pm)
			throws CoreException, OperationCanceledException {
		if (uriChanges.isEmpty()) {
			return null;
		}

		SubMonitor subMonitor = SubMonitor.convert(pm);
		// Declaring the task and its effort in 'SubMonitor.convert(...)' doesn't yield the expected UI updates
		// so let's do it separately; the total effort of '5' is chosen for weighting the subsequent efforts
		subMonitor.beginTask("Preparing the refactoring...", 5);

		IChangeSerializer changeSerializer = changeSerializerProvider.get();
		ResourceSet resourceSet = resourceSetProvider.get(project);

		ResourceRelocationContext context = new ResourceRelocationContext(type, uriChanges, issues, changeSerializer, resourceSet);
		boolean persistedIndexUsageRequested = isPersistedIndexUsageRequested(context);

		// TODO check preconditions like all editors being saved if 'persistedIndexUsageRequested' == true

		initializeResourceSet(persistedIndexUsageRequested, context);
		executeParticipants(context, subMonitor.split(1));

		ChangeConverter changeConverter = changeConverterFactory.create(name, //
				(it) -> {
					return (!(it instanceof MoveResourceChange || it instanceof RenameResourceChange)
							|| !excludedResources.contains(it.getModifiedElement()));
				}, issues);

		SubMonitor modificationApplicationMonitor = subMonitor.split(4); // remaining effort is assigned to 'changeSerializer's work
		changeSerializer.setProgressMonitor(modificationApplicationMonitor);
		changeSerializer.applyModifications(changeConverter);
		modificationApplicationMonitor.done();
		return changeConverter.getChange();
	}

	/**
	 * @since 2.18
	 */
	protected boolean isPersistedIndexUsageRequested(ResourceRelocationContext context) {
		List<? extends IResourceRelocationStrategy> strategies = strategyRegistry.getStrategies();
		return strategies.stream().anyMatch(strategy -> strategy.requiresUsageOfPersistedIndex(context));
	}

	/**
	 * @since 2.18
	 */
	protected void initializeResourceSet(boolean persistedIndexUsageRequested, ResourceRelocationContext context) {
		if (persistedIndexUsageRequested) {
			context.getResourceSet().getLoadOptions().put(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS, Boolean.TRUE);
		} else {
			liveScopeResourceSetInitializer.initialize(context.getResourceSet());
		}
	}

	protected void executeParticipants(ResourceRelocationContext context, SubMonitor monitor) {
		List<? extends IResourceRelocationStrategy> strategies = strategyRegistry.getStrategies();
		if (context.getChangeType() == ResourceRelocationContext.ChangeType.COPY) {
			context.getChangeSerializer().setUpdateRelatedFiles(false);
		}

		monitor.setWorkRemaining(strategies.size());

		for (IResourceRelocationStrategy strategy : strategies) {
			try {
				monitor.split(1);
				strategy.applyChange(context);
			} catch (OperationCanceledException t) {
				issues.add(ERROR, "Operation was cancelled while applying resource changes", t);
				LOG.error(t.getMessage(), t);
				break;
			}
		}
	}

	public void addChangedResource(IResource resource, IPath fromPath, IPath toPath) {
		if (project == null) {
			project = resource.getProject();
		}

		if (fromPath.isPrefixOf(resource.getFullPath())) {
			URI oldURI = resourceURIConverter.toURI(resource);
			URI newURI = resourceURIConverter.toURI(toPath.append(resource.getFullPath().removeFirstSegments(fromPath.segmentCount())));
			excludedResources.add(resource);
			if (resource instanceof IFile) {
				ResourceRelocationChange uriChange = new ResourceRelocationChange(oldURI, newURI, true);
				uriChanges.add(uriChange);
			} else if (resource instanceof IContainer) {
				ResourceRelocationChange uriChange = new ResourceRelocationChange(oldURI, newURI, false);
				uriChanges.add(uriChange);

				try {
					for (IResource member : ((IContainer) resource).members()) {
						addChangedResource(member, fromPath, toPath);
					}
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	LtkIssueAcceptor getIssues() {
		return issues;
	}
}
