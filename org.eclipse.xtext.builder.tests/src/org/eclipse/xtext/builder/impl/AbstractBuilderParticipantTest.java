/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.BuilderParticipant;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess;
import org.eclipse.xtext.builder.tests.BuilderTestLanguageInjectorProvider;
import org.eclipse.xtext.builder.tests.DelegatingBuilderParticipant;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfigurationProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author kosyakov - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(BuilderTestLanguageInjectorProvider.class)
public abstract class AbstractBuilderParticipantTest extends AbstractBuilderTest {

	@Inject
	private IXtextBuilderParticipant delegatingParticipant;
	private IXtextBuilderParticipant oldDelegate;
	
	@Inject
	protected BuilderParticipant participant;
	@Inject
	protected IPreferenceStoreAccess preferenceStoreAccess;

	@Before
	public void redirectBuilderParticipnt() throws Exception {
		oldDelegate = ((DelegatingBuilderParticipant) delegatingParticipant).getDelegate();
		((DelegatingBuilderParticipant) delegatingParticipant).setDelegate(participant);
	}
	
	@After
	public void resetBuilderParticipant() throws Exception {
		((DelegatingBuilderParticipant) delegatingParticipant).setDelegate(oldDelegate);
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

}
