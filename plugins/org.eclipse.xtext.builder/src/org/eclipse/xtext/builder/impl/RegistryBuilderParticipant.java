/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.internal.Activator;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein
 */
@Singleton
public class RegistryBuilderParticipant implements IXtextBuilderParticipant {

	private static final String PARTICIPANT = "participant"; //$NON-NLS-1$

	private static final String EXTENSION_POINT_ID = PARTICIPANT;

	private static final String ATT_CLASS = "class"; //$NON-NLS-1$
	
	private static final String ATT_FILE_EXTENSIONS = "fileExtensions"; //$NON-NLS-1$
	
	private static final Splitter FILE_EXTENSION_SPLITTER = Splitter.on(',').trimResults().omitEmptyStrings();

	private static final Logger readerLog = Logger.getLogger(BuilderParticipantReader.class);

	@Inject
	private IExtensionRegistry extensionRegistry;

	private volatile ImmutableList<IXtextBuilderParticipant> participants;

	private Map<String, IXtextBuilderParticipant> classToParticipant;

	public void build(IBuildContext buildContext, IProgressMonitor monitor) throws CoreException {
		ImmutableList<IXtextBuilderParticipant> participants = getParticipants();
		if (participants.isEmpty())
			return;
		SubMonitor progress = SubMonitor.convert(monitor, participants.size());
		progress.subTask(Messages.RegistryBuilderParticipant_InvokingBuildParticipants);
		for (IXtextBuilderParticipant participant : participants) {
			if (progress.isCanceled())
				throw new OperationCanceledException();
			participant.build(buildContext, progress.newChild(1));
		}
	}

	public ImmutableList<IXtextBuilderParticipant> getParticipants() {
		ImmutableList<IXtextBuilderParticipant> result = participants;
		if (participants == null) {
			result = initParticipants();
		}
		return result;
	}

	protected synchronized ImmutableList<IXtextBuilderParticipant> initParticipants() {
		ImmutableList<IXtextBuilderParticipant> result = participants;
		if (result == null) {
			if (classToParticipant == null) {
				classToParticipant = Maps.newHashMap();
				String pluginID = Activator.getDefault().getBundle().getSymbolicName();
				String extensionPointID = EXTENSION_POINT_ID;
				BuilderParticipantReader reader = new BuilderParticipantReader(extensionRegistry, pluginID, extensionPointID);
				reader.readRegistry();
			}
			result = ImmutableList.copyOf(classToParticipant.values());
			participants = result;
		}
		return result;
	}

	public class BuilderParticipantReader extends RegistryReader {

		public BuilderParticipantReader(IExtensionRegistry pluginRegistry, String pluginID, String extensionPointID) {
			super(pluginRegistry, pluginID, extensionPointID);
		}

		@Override
		protected boolean readElement(IConfigurationElement element, boolean add) {
			if (element.getName().equals(PARTICIPANT)) {
				String className = element.getAttribute(ATT_CLASS);
				if (className == null) {
					logMissingAttribute(element, ATT_CLASS);
				} else if (add) {
					IXtextBuilderParticipant participant = new DeferredBuilderParticipant(element);
					if (classToParticipant.containsKey(className)) {
						readerLog.warn("The builder participant '" + className + "' was registered twice."); //$NON-NLS-1$ //$NON-NLS-2$
					}
					classToParticipant.put(className, participant);
					participants = null;
					return true;
				} else {
					classToParticipant.remove(className);
					participants = null;
					return true;
				}
			}
			return false;
		}

		@Override
		protected void logError(IConfigurationElement element, String text) {
			IExtension extension = element.getDeclaringExtension();
			readerLog.error("Plugin " + extension.getContributor().getName() + ", extension " + extension.getExtensionPointUniqueIdentifier()); //$NON-NLS-1$ //$NON-NLS-2$
			readerLog.error(text);
		}

		private class DeferredBuilderParticipant implements IXtextBuilderParticipant {
			private IConfigurationElement element;
			
			private IXtextBuilderParticipant delegate;
			private ImmutableList<String> handledFileExtensions;

			public DeferredBuilderParticipant(IConfigurationElement element) {
				this.element = element;
			}

			public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
				getDelegate(context).build(context, monitor);
			}

			private IXtextBuilderParticipant getDelegate(IBuildContext context) {
				if (!interestedIn(context)) {
					return new NoOpBuilderParticipant();
				}
				if (delegate == null) {
					initDelegate();
				}
				return delegate;
			}

			private synchronized void initDelegate() {
				if (delegate != null) return;
				try {
					Object participant = element.createExecutableExtension(ATT_CLASS);
					if (participant instanceof IXtextBuilderParticipant) {
						delegate = (IXtextBuilderParticipant) participant;
					} else {
						logError(element, element.getAttribute(ATT_CLASS)
								+ " did not yield an instance of IXtextBuilderParticipant but " + //$NON-NLS-1$
								participant.getClass().getName());
					}
				} catch (CoreException e) {
					logError(element, e.getMessage());
				} catch (NoClassDefFoundError e) {
					logError(element, e.getMessage());
				}
				if (delegate == null) {
					delegate = new NoOpBuilderParticipant();
				}
			}

			private boolean interestedIn(IBuildContext context) {
				if (getHandledFileExtensions().isEmpty()) {
					return true;
				}
				for (Delta change : context.getDeltas()) {
					String fileExtension = change.getUri().fileExtension();
					if (getHandledFileExtensions().contains(fileExtension)) {
						return true;
					}
				}
				return false;
			}

			private List<String> getHandledFileExtensions() {
				if (handledFileExtensions == null) {
					initHandledFileExtensions();
				}
				return handledFileExtensions;
			}

			private synchronized void initHandledFileExtensions() {
				if (handledFileExtensions != null) return;
				String fileExtensionsAtt = Strings.nullToEmpty(element.getAttribute(ATT_FILE_EXTENSIONS));
				handledFileExtensions = ImmutableList.copyOf(FILE_EXTENSION_SPLITTER.split(fileExtensionsAtt));
			}
		}
	}

	private static class NoOpBuilderParticipant implements IXtextBuilderParticipant {
		public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		}
	}

}
