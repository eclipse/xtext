/*******************************************************************************
 * Copyright (c) 2012, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.smap;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaModelMarker;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IRegion;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.BuildContext;
import org.eclipse.jdt.core.compiler.CompilationParticipant;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceToBytecodeInstaller;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.TraceAsPrimarySourceInstaller;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.smap.TraceAsSmapInstaller;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.generator.trace.AbstractEclipseTrace;
import org.eclipse.xtext.ui.generator.trace.IEclipseTrace;
import org.eclipse.xtext.ui.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;
import org.osgi.framework.Version;

import com.google.common.collect.Lists;
import com.google.common.io.ByteStreams;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Moritz Eysholdt
 */
public class DebugSourceInstallingCompilationParticipant extends CompilationParticipant implements CompilationParticipantExtension {

	private static final Logger log = Logger.getLogger(DebugSourceInstallingCompilationParticipant.class);
	private static final Version VERSION_3_34_0 = new Version(3, 34, 0);

	private static Version installedJdtCoreVersion;
	
	private List<BuildContext> files;

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	@Inject
	private Provider<TraceAsSmapInstaller> traceAsSmapInstaller;

	@Inject
	private Provider<TraceAsPrimarySourceInstaller> traceAsPrimarySourceInstallerProvider;

	@Inject
	private ITraceForStorageProvider traceInformation;

	@Inject
	private DerivedResourceMarkerCopier markerReflector;
	
	@Override
	public boolean isPostProcessor() {
		return true;
	}

	protected OutputConfiguration findOutputConfiguration(SourceRelativeURI dslSourceFile, IFile generatedJavaFile) {
		IResourceServiceProvider serviceProvider = serviceProviderRegistry.getResourceServiceProvider(dslSourceFile.getURI());
		if (serviceProvider == null)
			return null;
		EclipseOutputConfigurationProvider cfgProvider = serviceProvider.get(EclipseOutputConfigurationProvider.class);
		IProject project = generatedJavaFile.getProject();
		Set<OutputConfiguration> configurations = cfgProvider.getOutputConfigurations(project);
		if (!configurations.isEmpty()) {
			if (configurations.size() == 1)
				return configurations.iterator().next();
			for (OutputConfiguration out : configurations) {
				for (String source : out.getSourceFolders()) {
					IContainer container = ResourceUtil.getContainer(project, out.getOutputDirectory(source));
					if (container != null && container.getFullPath().isPrefixOf(generatedJavaFile.getFullPath()))
						return out;
				}
			}
		}
		log.error("Could not find output configuration for file " + generatedJavaFile.getFullPath());
		return null;
	}

	protected ITraceToBytecodeInstaller getInstaller(OutputConfiguration config) {
		if (config.isInstallDslAsPrimarySource()) {
			TraceAsPrimarySourceInstaller installer = traceAsPrimarySourceInstallerProvider.get();
			installer.setHideSyntheticVariables(config.isHideSyntheticLocalVariables());
			return installer;
		} else {
			TraceAsSmapInstaller installer = traceAsSmapInstaller.get();
			return installer;
		}
	}

	@Override
	public Optional<byte[]> postProcess(BuildContext ctx, ByteArrayInputStream bytes) {
		Optional<byte[]> no_change = Optional.empty();
		if (!isJdtCoreGreaterOrEqual(VERSION_3_34_0)) {
			return no_change;
		}
		try {
			IFile generatedJavaFile = ctx.getFile();

			// This may fail if there is no trace file.
			IEclipseTrace traceToSource = traceInformation.getTraceToSource(generatedJavaFile);
			if (traceToSource == null) {
				return no_change;
			}
			AbstractTraceRegion rootTraceRegion = findRootTraceRegion(traceToSource);
			if (rootTraceRegion == null)
				return no_change;

			SourceRelativeURI dslSourceFile = rootTraceRegion.getAssociatedSrcRelativePath();

			// OutputConfigurations are only available for folders targeted by Xtext's code generation.
			OutputConfiguration outputConfiguration = findOutputConfiguration(dslSourceFile, generatedJavaFile);
			if (outputConfiguration == null)
				return no_change;

			IJavaElement element = JavaCore.create(generatedJavaFile);
			if (element == null)
				return no_change;

			deleteTaskMarkers(generatedJavaFile);
			markerReflector.reflectErrorMarkerInSource(generatedJavaFile, traceToSource);

			ITraceToBytecodeInstaller installer = getInstaller(outputConfiguration);
			installer.setTrace(generatedJavaFile.getName(), rootTraceRegion);
			byte[] byteCode = installer.installTrace(ByteStreams.toByteArray(bytes));
			if (byteCode != null) {
				return Optional.of(byteCode);
			} else {
				// touching not needed in newer java versions
			}
		} catch (Exception e) {
			String msg = "Could not process %s to install source information: %s";
			log.error(String.format(msg, ctx.getFile().getFullPath().toString(), e.getMessage()), e);
		}
		return no_change;
	}

	@Override
	public void buildFinished(IJavaProject project) {
		StoppedTask task = Stopwatches.forTask("DebugSourceInstallingCompilationParticipant.install");
		try {
			task.start();
			super.buildFinished(project);
			if (isJdtCoreGreaterOrEqual(VERSION_3_34_0)) {
				// nothing to do here
				return;
			} else {
				if (files == null)
					return;
				for (BuildContext ctx : files) {
					try {
						IFile generatedJavaFile = ctx.getFile();

						// This may fail if there is no trace file.
						IEclipseTrace traceToSource = traceInformation.getTraceToSource(generatedJavaFile);
						if (traceToSource == null) {
							continue;
						}
						AbstractTraceRegion rootTraceRegion = findRootTraceRegion(traceToSource);
						if (rootTraceRegion == null)
							continue;

						SourceRelativeURI dslSourceFile = rootTraceRegion.getAssociatedSrcRelativePath();

						// OutputConfigurations are only available for folders targeted by Xtext's code generation.
						OutputConfiguration outputConfiguration = findOutputConfiguration(dslSourceFile, generatedJavaFile);
						if (outputConfiguration == null)
							continue;

						IJavaElement element = JavaCore.create(generatedJavaFile);
						if (element == null)
							continue;

						deleteTaskMarkers(generatedJavaFile);
						markerReflector.reflectErrorMarkerInSource(generatedJavaFile, traceToSource);

						ITraceToBytecodeInstaller installer = getInstaller(outputConfiguration);
						installer.setTrace(generatedJavaFile.getName(), rootTraceRegion);
						for (IFile javaClassFile : findGeneratedJavaClassFiles(element)) {
							InputStream contents = javaClassFile.getContents();
							try {
								byte[] byteCode = installer.installTrace(ByteStreams.toByteArray(contents));
								if (byteCode != null) {
									javaClassFile.setContents(new ByteArrayInputStream(byteCode), 0, null);
								} else {
									// we need to touch the class file to do a respin of the build
									// otherwise a needsRebuild request is ignored since no IResourceDelta is available
									javaClassFile.touch(null);
								}
							} finally {
								contents.close();
							}
						}
					} catch (Exception e) {
						String msg = "Could not process %s to install source information: %s";
						log.error(String.format(msg, ctx.getFile().getFullPath().toString(), e.getMessage()), e);
					}
				}
			}
		} finally {
			files = null;
			task.stop();
		}
	}

	/**
	 * Deletes task markers in generated Java files, because they would duplicate the markers in the source file.
	 */
	protected void deleteTaskMarkers(IFile generatedJavaFile) throws CoreException {
		generatedJavaFile.deleteMarkers(IJavaModelMarker.TASK_MARKER, false, IResource.DEPTH_ZERO);
	}

	@Override
	public void buildStarting(BuildContext[] files, boolean isBatch) {
		super.buildStarting(files, isBatch);
		if (!isJdtCoreGreaterOrEqual(VERSION_3_34_0)) {
			if (this.files != null) {
				this.files.addAll(Arrays.asList(files));
			} else {
				this.files = Lists.newArrayList(files);
			}
		}
	}

	protected List<IFile> findGeneratedJavaClassFiles(IJavaElement element) {
		IRegion region = JavaCore.newRegion();
		region.add(element);
		List<IFile> result = Lists.newLinkedList();
		for (IResource res : JavaCore.getGeneratedResources(region, false))
			if (res instanceof IFile)
				result.add((IFile) res);
		return result;
	}

	protected AbstractTraceRegion findRootTraceRegion(ITrace traceToSource) {
		if (!(traceToSource instanceof AbstractEclipseTrace))
			return null;
		return ((AbstractEclipseTrace) traceToSource).getRootTraceRegion();
	}

	@Override
	public boolean isActive(IJavaProject project) {
		return XtextProjectHelper.hasNature(project.getProject());
	}

	private static boolean isJdtCoreGreaterOrEqual(Version version) {
		if (installedJdtCoreVersion == null) {
			installedJdtCoreVersion = JavaCore.getPlugin().getBundle().getVersion();
		}
		return installedJdtCoreVersion.compareTo(version) >= 0;
	}

}
