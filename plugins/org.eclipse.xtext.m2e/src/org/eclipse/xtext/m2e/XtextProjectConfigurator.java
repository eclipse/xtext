package org.eclipse.xtext.m2e;

import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.*;
import static org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess.*;

import java.util.List;

import org.apache.maven.plugin.MojoExecution;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.m2e.core.project.configurator.AbstractProjectConfigurator;
import org.eclipse.m2e.core.project.configurator.ProjectConfigurationRequest;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.preferences.OptionsConfigurationBlock;
import org.osgi.service.prefs.BackingStoreException;

import com.google.common.base.Throwables;

public class XtextProjectConfigurator extends AbstractProjectConfigurator {

	@Override
	public void configure(ProjectConfigurationRequest request,
			IProgressMonitor monitor) throws CoreException {
		addNature(request.getProject(), XtextProjectHelper.NATURE_ID, monitor);
		configureLanguages(request, monitor);
	}

	private void configureLanguages(ProjectConfigurationRequest request, IProgressMonitor monitor) throws CoreException {
		for (MojoExecution execution : getMojoExecutions(request, monitor)) {
			Languages languages = getParameterValue("languages", Languages.class, request.getMavenSession(), execution);
			ProjectScope projectPreferences = new ProjectScope(request.getProject());
			for (Language language : languages) {
				configureLanguage(projectPreferences, language);
			}
		}
	}

	private void configureLanguage(ProjectScope projectPreferences, Language language) throws CoreException {
		if (language.getOutputConfigurations().isEmpty()) return;
		
		IEclipsePreferences languagePreferences = projectPreferences.getNode(language.name());
		languagePreferences.putBoolean(OptionsConfigurationBlock.IS_PROJECT_SPECIFIC, true);
		languagePreferences.putBoolean(PREF_AUTO_BUILDING, true);
		for (OutputConfiguration outputConfiguration : language.getOutputConfigurations()) {
			configureOutlet(languagePreferences, outputConfiguration);
		}
		try {
			languagePreferences.flush();
		} catch (BackingStoreException e) {
			throw Throwables.propagate(e);
		}
	}

	private void configureOutlet(IEclipsePreferences languagePreferences, OutputConfiguration mavenConfiguration) {
		org.eclipse.xtext.generator.OutputConfiguration configuration = mavenConfiguration.toGeneratorConfiguration();
		languagePreferences.put(getKey(configuration, OUTPUT_NAME), configuration.getName());
		languagePreferences.put(getKey(configuration, OUTPUT_DESCRIPTION), configuration.getDescription());
		languagePreferences.put(getKey(configuration, OUTPUT_DIRECTORY), configuration.getOutputDirectory());
		languagePreferences.putBoolean(getKey(configuration, OUTPUT_DERIVED), configuration.isSetDerivedProperty());
		languagePreferences.putBoolean(getKey(configuration, OUTPUT_CREATE_DIRECTORY), configuration.isCreateOutputDirectory());
		languagePreferences.putBoolean(getKey(configuration, OUTPUT_CLEAN_DIRECTORY), configuration.isCanClearOutputDirectory());
		languagePreferences.putBoolean(getKey(configuration, OUTPUT_OVERRIDE), configuration.isOverrideExistingResources());
		languagePreferences.putBoolean(getKey(configuration, OUTPUT_CLEANUP_DERIVED), configuration.isCleanUpDerivedResources());
		languagePreferences.putBoolean(getKey(configuration, INSTALL_DSL_AS_PRIMARY_SOURCE), configuration.isInstallDslAsPrimarySource());
		languagePreferences.putBoolean(getKey(configuration, HIDE_LOCAL_SYNTHETIC_VARIABLES), configuration.isHideSyntheticLocalVariables());
		languagePreferences.putBoolean(getKey(configuration, OUTPUT_KEEP_LOCAL_HISTORY), configuration.isKeepLocalHistory());
	}
}