/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.*;
import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.BuilderParticipant;
import org.eclipse.xtext.builder.DerivedResourceCleanerJob;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess;
import org.eclipse.xtext.builder.tests.DelegatingBuilderParticipant;
import org.eclipse.xtext.builder.tests.internal.TestsActivator;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfigurationProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Procedures;

import com.google.inject.Injector;

/**
 * @author kosyakov - Initial contribution and API
 */
public abstract class AbstractBuilderParticipantTest extends AbstractBuilderTest {
	
	private IXtextBuilderParticipant oldDelegate;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		final Injector injector = getInjector();
		IXtextBuilderParticipant instance = injector.getInstance(IXtextBuilderParticipant.class);
		participant = injector.getInstance(BuilderParticipant.class);
		preferenceStoreAccess = injector.getInstance(IPreferenceStoreAccess.class);
		DelegatingBuilderParticipant delegatingParticipant = (DelegatingBuilderParticipant) instance;
		oldDelegate = delegatingParticipant.getDelegate();
		delegatingParticipant.setDelegate(participant);
	}

	protected Injector getInjector() {
		final Injector injector = TestsActivator.getInstance().getInjector(
				TestsActivator.ORG_ECLIPSE_XTEXT_BUILDER_TESTS_BUILDERTESTLANGUAGE);
		return injector;
	}

	protected BuilderParticipant participant;
	protected IPreferenceStoreAccess preferenceStoreAccess;

	@Override
	public void tearDown() throws Exception {
		IXtextBuilderParticipant instance = getInjector().getInstance(IXtextBuilderParticipant.class);
		DelegatingBuilderParticipant delegatingParticipant = (DelegatingBuilderParticipant) instance;
		delegatingParticipant.setDelegate(oldDelegate);
		super.tearDown();
		participant = null;
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

	protected String getNonDefaultEncoding() throws CoreException {
		String defaultCharset = root().getDefaultCharset();
		if (equal(defaultCharset, "UTF-8")) {
			return "ISO-8859-1";
		} else {
			return "UTF-8";
		}
	}

	protected String getUseOutputPerSourceFolderKey() {
		return OUTPUT_PREFERENCE_TAG + PreferenceConstants.SEPARATOR + IFileSystemAccess.DEFAULT_OUTPUT
				+ PreferenceConstants.SEPARATOR + USE_OUTPUT_PER_SOURCE_FOLDER;
	}

	protected String getOutputForSourceFolderKey(String sourceFolder) {
		return BuilderPreferenceAccess.getOutputForSourceFolderKey(new OutputConfiguration(
				IFileSystemAccess.DEFAULT_OUTPUT), sourceFolder);
	}
	
	protected void withOutputConfiguration(
		final Procedures.Procedure1<OutputConfiguration> outputConfigurationInitializer,
		Procedures.Procedure0 test
	) {
		OutputConfigurationProvider outputConfigurationProvider = new OutputConfigurationProvider() {
			@Override
			public Set<OutputConfiguration> getOutputConfigurations() {
				final Set<OutputConfiguration> result = super.getOutputConfigurations();
				outputConfigurationInitializer.apply(result.iterator().next());
				return result;
			}
		};
		try {
			BuilderPreferenceAccess.Initializer initializer = new BuilderPreferenceAccess.Initializer();
			initializer.setOutputConfigurationProvider(outputConfigurationProvider);
			initializer.initialize(preferenceStoreAccess);
			test.apply();
		} finally {
			BuilderPreferenceAccess.Initializer initializer = new BuilderPreferenceAccess.Initializer();
			initializer.setOutputConfigurationProvider(new OutputConfigurationProvider());
			initializer.initialize(preferenceStoreAccess);
		}
	}
	
	protected void waitForBuild() {
		IResourcesSetupUtil.reallyWaitForAutoBuild();
	}

}
