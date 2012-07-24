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
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.BuildContext;
import org.eclipse.jdt.core.compiler.CompilationParticipant;
import org.eclipse.jdt.internal.core.Region;
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.generator.trace.SmapSupport;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.Files;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SmapInstallingCompilationParticipant extends CompilationParticipant {

	private static final Logger log = Logger.getLogger(SmapInstallingCompilationParticipant.class);
	
	@Inject
	private ITraceInformation traceInformation;
	
	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;
	
	@Inject 
	private SmapSupport smapSupport;

	private List<BuildContext> files;
	
	@Override
	public boolean isActive(IJavaProject project) {
		return XtextProjectHelper.hasNature(project.getProject());
	}

	@Override
	public void buildStarting(BuildContext[] files, boolean isBatch) {
		super.buildStarting(files, isBatch);
		if (this.files != null)
			this.files.addAll(Arrays.asList(files));
		else
			this.files = Lists.newArrayList(files);
	}
	
	@Override
	public void buildFinished(IJavaProject project) {
		try {
			super.buildFinished(project);
			if (files == null)
				return;
			for (BuildContext ctx : files) {
				try {
					IJavaElement element = JavaCore.create(ctx.getFile());
					if (element != null && element.exists()) {
						IFile smapFile = findSmapFile(ctx);
						if (smapFile != null && smapFile.exists()) {
							try {
								String smapAsString = Files.readStreamIntoString(smapFile.getContents());
								Region region = new Region();
								region.add(element);
								// install into bytecode
								installSmapInformation(smapAsString, JavaCore.getGeneratedResources(region, false));
							} catch (Exception e) {
								log.error(String.format("Could not read and install smap information from %s: %s", smapFile.getFullPath().toString(), e.getMessage()), e);
							} finally {
								try {
									smapFile.delete(true, null);
								} catch(CoreException e) {
									log.error(e.getMessage(), e);
								}
							}
						}
					}
				} catch (Exception e) {
					log.error(String.format("Could not process %s to install smap information: %s", ctx.getFile().getFullPath().toString(), e.getMessage()), e);
				}
			}
		} finally {
			files = null;
		}
	}

	protected void installSmapInformation(String smap, IResource[] resources) {
		for (IResource res : resources) {
			if (res instanceof IFile) {
				installSmapInformation(smap, (IFile) res);
			}
		}
	}

	protected void installSmapInformation(String smap, IFile compiledFile) {
		try {
			InputStream newByteCode = smapSupport.getModifiedByteCode(smap, compiledFile.getContents());
			compiledFile.setContents(newByteCode, IResource.KEEP_HISTORY, null);
		} catch (Exception e) {
			log.error(String.format("Could not install smap information into %s: %s", compiledFile.getFullPath().toString(), e.getMessage()), e);
		}
	}

	protected IFile findSmapFile(BuildContext ctx) {
		IFile compiledFile = ctx.getFile();
		IPath smapPath = compiledFile.getFullPath().removeFileExtension().addFileExtension("smap");
		IContainer container = compiledFile.getParent();
		IFile result = container.getFile(smapPath.removeFirstSegments(smapPath.segmentCount() - 1));
		return result;
	}

}
