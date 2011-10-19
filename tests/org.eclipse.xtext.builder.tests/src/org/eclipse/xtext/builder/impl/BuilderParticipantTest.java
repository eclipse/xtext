/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.*;
import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.BuilderParticipant;
import org.eclipse.xtext.builder.DerivedResourceCleanerJob;
import org.eclipse.xtext.builder.DerivedResourceMarkers;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess;
import org.eclipse.xtext.builder.tests.Activator;
import org.eclipse.xtext.builder.tests.DelegatingBuilderParticipant;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfigurationProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class BuilderParticipantTest extends AbstractBuilderTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		final Injector injector = getInjector();
		IXtextBuilderParticipant instance = injector
				.getInstance(IXtextBuilderParticipant.class);
		participant = injector.getInstance(BuilderParticipant.class);
		preferenceStoreAccess = injector.getInstance(IPreferenceStoreAccess.class);
		DelegatingBuilderParticipant delegatingParticipant = (DelegatingBuilderParticipant) instance;
		delegatingParticipant.setDelegate(participant);
	}

	protected Injector getInjector() {
		final Injector injector = Activator.getInstance()
				.getInjector("org.eclipse.xtext.builder.tests.BuilderTestLanguage");
		return injector;
	}
	
	private BuilderParticipant participant;
	private IPreferenceStoreAccess preferenceStoreAccess;
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		participant = null;
	}

	public void testCleanUpDerivedResources() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = project.getProject().getFolder("src");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		waitForAutoBuild();
		IFile generatedFile = project.getProject().getFile("./src-gen/Foo.txt");
		assertTrue(generatedFile.exists());
		preferenceStoreAccess.getWritablePreferenceStore().setValue(getDefaultOutputDirectoryKey(), "./src2-gen");
		
		DerivedResourceCleanerJob derivedResourceCleanerJob = getInjector().getInstance(DerivedResourceCleanerJob.class);
		derivedResourceCleanerJob.setUser(true);
		derivedResourceCleanerJob.initialize(project.getProject(), "src-gen");
		derivedResourceCleanerJob.schedule();
		waitForResourceCleanerJob();
		generatedFile = project.getProject().getFile("./src-gen/Foo.txt");
		assertFalse(generatedFile.exists());
		file.touch(monitor());
		waitForAutoBuild();
		generatedFile = project.getProject().getFile("./src2-gen/Foo.txt");
		assertTrue(generatedFile.exists());
		preferenceStoreAccess.getWritablePreferenceStore().setValue(getDefaultOutputDirectoryKey(), "./src-gen");
	}

	public void testDefaultConfiguration() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = project.getProject().getFolder("src");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		waitForAutoBuild();
		IFile generatedFile = project.getProject().getFile("./src-gen/Foo.txt");
		assertTrue(generatedFile.exists());
		assertTrue(generatedFile.isDerived());
		assertTrue(generatedFile.findMarkers(DerivedResourceMarkers.MARKER_ID, false, IResource.DEPTH_ZERO).length == 1);
		assertEquals("object Foo", getContents(generatedFile).trim());
		
		file.setContents(new StringInputStream("object Bar"), true, true, monitor());
		waitForAutoBuild();
		assertFalse(generatedFile.exists());
		generatedFile = project.getProject().getFile("./src-gen/Bar.txt");
		assertTrue(generatedFile.exists());
		assertTrue(generatedFile.isDerived());
		assertTrue(generatedFile.findMarkers(DerivedResourceMarkers.MARKER_ID, false, IResource.DEPTH_ZERO).length == 1);
		assertEquals("object Bar", getContents(generatedFile).trim());
		
		file.delete(true, monitor());
		waitForAutoBuild();
		assertFalse(generatedFile.exists());
	}
	
	public void testClean() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = project.getProject().getFolder("src");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		waitForAutoBuild();
		IFile generatedFile = project.getProject().getFile("./src-gen/Foo.txt");
		assertTrue(generatedFile.exists());
		assertTrue(generatedFile.isDerived());
		assertTrue(generatedFile.findMarkers(DerivedResourceMarkers.MARKER_ID, false, IResource.DEPTH_ZERO).length == 1);
		assertEquals("object Foo", getContents(generatedFile).trim());
		
		cleanBuild();
		assertFalse(generatedFile.exists());
	}
	
	public void testNoCleanUpNoDerived() throws Exception {
		OutputConfigurationProvider outputConfigurationProvider = new OutputConfigurationProvider() {
			@Override
			public Set<OutputConfiguration> getOutputConfigurations() {
				final Set<OutputConfiguration> result = super.getOutputConfigurations();
				OutputConfiguration configuration = result.iterator().next();
				configuration.setCanClearOutputDirectory(false);
				configuration.setCleanUpDerivedResources(false);
				configuration.setSetDerivedProperty(false);
				return result;
			}
		};
		BuilderPreferenceAccess.Initializer initializer = new BuilderPreferenceAccess.Initializer();
		initializer.setOutputConfigurationProvider(outputConfigurationProvider);
		initializer.initialize(preferenceStoreAccess);
		
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = project.getProject().getFolder("src");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		waitForAutoBuild();
		IFile generatedFile = project.getProject().getFile("./src-gen/Foo.txt");
		assertTrue(generatedFile.exists());
		assertFalse(generatedFile.isDerived());
		assertTrue(generatedFile.findMarkers(DerivedResourceMarkers.MARKER_ID, false, IResource.DEPTH_ZERO).length == 1);
		assertEquals("object Foo", getContents(generatedFile).trim());
		
		file.setContents(new StringInputStream("object Bar"), true, true, monitor());
		waitForAutoBuild();
		assertTrue(generatedFile.exists());
		generatedFile = project.getProject().getFile("./src-gen/Bar.txt");
		assertTrue(generatedFile.exists());
		assertFalse(generatedFile.isDerived());
		assertTrue(generatedFile.findMarkers(DerivedResourceMarkers.MARKER_ID, false, IResource.DEPTH_ZERO).length == 1);
		assertEquals("object Bar", getContents(generatedFile).trim());
		
		file.delete(true, monitor());
		waitForAutoBuild();
		assertTrue(generatedFile.exists());
		cleanBuild();
		assertTrue(generatedFile.exists());
	}
	
	public void testDisabled() throws Exception {
		IJavaProject project = createJavaProject("foo");
		participant.getBuilderPreferenceAccess().setAutoBuildEnabled(project, false);
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = project.getProject().getFolder("src");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		waitForAutoBuild();
		IFile generatedFile = project.getProject().getFile("./src-gen/Foo.txt");
		assertFalse(generatedFile.exists());
		participant.getBuilderPreferenceAccess().setAutoBuildEnabled(project, true);
		file.touch(monitor());
		waitForAutoBuild();
		assertTrue(generatedFile.exists());
	}

	public void testNoOutputFolderCreation() throws Exception {
		OutputConfigurationProvider outputConfigurationProvider = new OutputConfigurationProvider() {
			@Override
			public Set<OutputConfiguration> getOutputConfigurations() {
				final Set<OutputConfiguration> result = super.getOutputConfigurations();
				OutputConfiguration configuration = result.iterator().next();
				configuration.setCreateOutputDirectory(false);
				return result;
			}
		};
		BuilderPreferenceAccess.Initializer initializer = new BuilderPreferenceAccess.Initializer();
		initializer.setOutputConfigurationProvider(outputConfigurationProvider);
		initializer.initialize(preferenceStoreAccess);
		
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = project.getProject().getFolder("src");
		IFile file = folder.getFile("Foo" + F_EXT);
		file.create(new StringInputStream("object Foo"), true, monitor());
		waitForAutoBuild();
		final IFile generatedFile = project.getProject().getFile("./src-gen/Foo.txt");
		assertFalse(generatedFile.exists());
	}
	
	protected String getContents(IFile file) throws CoreException, IOException {
		InputStream contents = file.getContents();
		InputStreamReader reader = new InputStreamReader(contents, file.getCharset());
		BufferedReader reader2 = new BufferedReader(reader);
		String line = null;
		StringBuilder result = new StringBuilder();
		while ((line = reader2.readLine()) != null) {
			result.append(line);
		}
		return result.toString();
	}

	protected void createTwoReferencedProjects() throws CoreException {
		IJavaProject firstProject = createJavaProjectWithRootSrc("first");
		IJavaProject secondProject = createJavaProjectWithRootSrc("second");
		addProjectReference(secondProject, firstProject);
	}
	
	protected IJavaProject createJavaProjectWithRootSrc(String string) throws CoreException {
		IJavaProject project = createJavaProject(string);
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		return project;
	}

	public static void waitForResourceCleanerJob() {
		boolean wasInterrupted = false;
		do {
			try {
				Job.getJobManager().join(DerivedResourceCleanerJob.DERIVED_RESOURCE_CLEANER_JOB_FAMILY, null);
				wasInterrupted = false;
			} catch (OperationCanceledException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				wasInterrupted = true;
			}
		} while (wasInterrupted);
	}

	protected String getDefaultOutputDirectoryKey() {
		return OUTPUT_PREFERENCE_TAG + PreferenceConstants.SEPARATOR + IFileSystemAccess.DEFAULT_OUTPUT
				+ PreferenceConstants.SEPARATOR + OUTPUT_DIRECTORY;
	}
}
