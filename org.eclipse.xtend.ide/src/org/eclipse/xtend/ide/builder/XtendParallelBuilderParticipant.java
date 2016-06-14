/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.builder;

import static com.google.common.collect.Maps.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.builder.ParallelBuilderParticipant;
import org.eclipse.xtext.generator.OutputConfiguration;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Anton Kosyakov - parallel support
 */
public class XtendParallelBuilderParticipant extends ParallelBuilderParticipant {

	private final static Logger logger = Logger.getLogger(XtendParallelBuilderParticipant.class);
	
	@Override
	protected boolean shouldGenerate(Resource resource, IBuildContext context) {
		// also create in case of errors
		return true;
	}
	
	@Override
	protected Map<OutputConfiguration, Iterable<IMarker>> getGeneratorMarkers(IProject builtProject,
			Collection<OutputConfiguration> outputConfigurations) throws CoreException {
		Map<OutputConfiguration, Iterable<IMarker>> generatorMarkers = newHashMap();
		List<IPath> sourcePath = getSourceFolderPathes(builtProject);
		for (OutputConfiguration config : outputConfigurations) {
			if (config.isCleanUpDerivedResources()) {
				List<IContainer> containerToSearchIn = Lists.newArrayList();
				for (IPath sourceFolder : sourcePath) {
					if (sourceFolder.segmentCount() == 1) {
						containerToSearchIn.add(builtProject);
					} else {
						IContainer sourcePathBasedContainer = builtProject.getWorkspace().getRoot()
								.getFolder(sourceFolder);
						containerToSearchIn.add(sourcePathBasedContainer);
					}
				}
				Collection<IMarker> markers = Lists.newArrayList();
				for (IContainer container : containerToSearchIn) {
					Iterables.addAll(markers, getDerivedResourceMarkers().findDerivedResourceMarkers(container,
							getGeneratorIdProvider().getGeneratorIdentifier()));
				}
				generatorMarkers.put(config, markers);
			}
		}
		return generatorMarkers;
	}
	
	public List<IPath> getSourceFolderPathes(IProject project){
		List<IPath> sourceFolder = Lists.newArrayList();
		try {
			if (project.isOpen() && project.hasNature(JavaCore.NATURE_ID)) {
				IJavaProject javaProject = JavaCore.create(project);
				List<IPackageFragmentRoot> packageFragmentRoots = Arrays.asList(javaProject.getPackageFragmentRoots());
				for(IPackageFragmentRoot packageFragmentRoot : packageFragmentRoots){
					if(packageFragmentRoot.getKind() == IPackageFragmentRoot.K_SOURCE){
						IPath path = packageFragmentRoot.getPath();
						sourceFolder.add(path);
					}
				}
			}
		} catch (JavaModelException e) {
			if (!e.isDoesNotExist())
				logger.error(e.getMessage(), e);
		} catch(CoreException e) {
			logger.error(e.getMessage(), e);
		}
		return sourceFolder;
	}

}
