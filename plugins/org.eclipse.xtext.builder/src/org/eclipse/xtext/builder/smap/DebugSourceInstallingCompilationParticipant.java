/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.smap;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.BuildContext;
import org.eclipse.jdt.core.compiler.CompilationParticipant;
import org.eclipse.jdt.internal.core.Region;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.builder.trace.AbstractTrace;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.generator.trace.SmapSupport;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.ResourceUtil;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Moritz Eysholdt
 */
public class DebugSourceInstallingCompilationParticipant extends CompilationParticipant {

	private static final Logger log = Logger.getLogger(DebugSourceInstallingCompilationParticipant.class);

	private List<BuildContext> files;

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	@Inject
	private SmapSupport smapSupport;

	@Inject
	private PrimarySourceInstaller traceAsPrimarySource;

	@Inject
	private ITraceInformation traceInformation;

	protected OutputConfiguration findOutputConfiguration(URI dslSourceFile, IFile generatedJavaFile) {
		IResourceServiceProvider serviceProvider = serviceProviderRegistry.getResourceServiceProvider(dslSourceFile);
		if (serviceProvider == null)
			return null;
		EclipseOutputConfigurationProvider cfgProvider = serviceProvider.get(EclipseOutputConfigurationProvider.class);
		IProject project = generatedJavaFile.getProject();
		for (OutputConfiguration out : cfgProvider.getOutputConfigurations(project)) {
			IContainer container = ResourceUtil.getContainer(project, out.getOutputDirectory());
			if (container != null && container.getFullPath().isPrefixOf(generatedJavaFile.getFullPath()))
				return out;
		}
		return null;
	}

	@Override
	public void buildFinished(IJavaProject project) {
		try {
			super.buildFinished(project);
			if (files == null)
				return;
			for (BuildContext ctx : files) {
				try {
					IFile generatedJavaFile = ctx.getFile();

					// This may fail if there is no trace file.
					AbstractTraceRegion traceToSource = findRootTraceRegion(generatedJavaFile);
					if (traceToSource == null)
						continue;
					URI dslSourceFile = traceToSource.getAssociatedPath();

					// OutputConfigurations are only available for folders targeted by Xtext's code generation.
					OutputConfiguration outputConfiguration = findOutputConfiguration(dslSourceFile, generatedJavaFile);
					if (outputConfiguration == null)
						continue;

					IJavaElement element = JavaCore.create(generatedJavaFile);
					if (element == null)
						continue;

					if (outputConfiguration.isInstallDslAsPrimarySource()) {
						boolean hideSyntheticLocalVariables = outputConfiguration.isHideSyntheticLocalVariables();
						for (IFile javaClassFile : findGeneratedJavaClassFiles(element)) {
							traceAsPrimarySource.install(javaClassFile, traceToSource, hideSyntheticLocalVariables);
						}
					} else {
						String smap = smapSupport.generateSmap(traceToSource, generatedJavaFile.getName());
						for (IFile javaClassFile : findGeneratedJavaClassFiles(element))
							installSmapInformation(javaClassFile, smap);
					}
				} catch (Exception e) {
					String msg = "Could not process %s to install source information: %s";
					log.error(String.format(msg, ctx.getFile().getFullPath().toString(), e.getMessage()), e);
				}
			}
		} finally {
			files = null;
		}
	}

	@Override
	public void buildStarting(BuildContext[] files, boolean isBatch) {
		super.buildStarting(files, isBatch);
		if (this.files != null)
			this.files.addAll(Arrays.asList(files));
		else
			this.files = Lists.newArrayList(files);
	}

	protected List<IFile> findGeneratedJavaClassFiles(IJavaElement element) {
		Region region = new Region();
		region.add(element);
		List<IFile> result = Lists.newLinkedList();
		for (IResource res : JavaCore.getGeneratedResources(region, false))
			if (res instanceof IFile)
				result.add((IFile) res);
		return result;
	}

	@SuppressWarnings("null")
	protected AbstractTraceRegion findRootTraceRegion(IFile javaFile) {
		ITrace traceToSource = traceInformation.getTraceToSource(javaFile);
		if (!(traceToSource instanceof AbstractTrace))
			return null;
		return ((AbstractTrace) traceToSource).getRootTraceRegion();
	}

	protected void installSmapInformation(IFile compiledFile, String smap) {
		try {
			InputStream newByteCode = smapSupport.getModifiedByteCode(smap, compiledFile.getContents());
			compiledFile.setContents(newByteCode, 0, null);
		} catch (Exception e) {
			String msg = "Could not install smap information into %s: %s";
			log.error(String.format(msg, compiledFile.getFullPath().toString(), e.getMessage()), e);
		}
	}

	@Override
	public boolean isActive(IJavaProject project) {
		return XtextProjectHelper.hasNature(project.getProject());
	}

}
