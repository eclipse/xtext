package org.eclipse.xtend.m2e;

import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.HIDE_LOCAL_SYNTHETIC_VARIABLES;
import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.INSTALL_DSL_AS_PRIMARY_SOURCE;
import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.OUTPUT_CLEANUP_DERIVED;
import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.OUTPUT_CLEAN_DIRECTORY;
import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.OUTPUT_CREATE_DIRECTORY;
import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.OUTPUT_DERIVED;
import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.OUTPUT_DESCRIPTION;
import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.OUTPUT_DIRECTORY;
import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.OUTPUT_KEEP_LOCAL_HISTORY;
import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.OUTPUT_NAME;
import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.OUTPUT_OVERRIDE;
import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.USE_OUTPUT_PER_SOURCE_FOLDER;
import static org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess.PREF_AUTO_BUILDING;
import static org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess.getIgnoreSourceFolderKey;
import static org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess.getKey;
import static org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess.getOutputForSourceFolderKey;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.MojoExecution;
import org.codehaus.plexus.util.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.m2e.core.project.configurator.AbstractProjectConfigurator;
import org.eclipse.m2e.core.project.configurator.ProjectConfigurationRequest;
import org.eclipse.xtend.core.compiler.XtendOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfiguration.SourceMapping;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.preferences.OptionsConfigurationBlock;
import org.eclipse.xtext.util.RuntimeIOException;
import org.osgi.service.prefs.BackingStoreException;

import com.google.common.base.Strings;

public class XtendProjectConfigurator extends AbstractProjectConfigurator {

	@Override
	public void configure(ProjectConfigurationRequest request,
			IProgressMonitor monitor) throws CoreException {
		addNature(request.getProject(), XtextProjectHelper.NATURE_ID, monitor);

		OutputConfiguration config = new XtendOutputConfigurationProvider()
				.getOutputConfigurations().iterator().next();
		config.setUseOutputPerSourceFolder(true);

		for (MojoExecution execution : getMojoExecutions(request, monitor)) {
			String goal = execution.getGoal();
			if (goal.equals("compile")) {
				readCompileConfig(config, request, execution);
			} else if (goal.equals("testCompile")) {
				readTestCompileConfig(config, request, execution);
			} else if (goal.equals("xtend-install-debug-info")) {
				readDebugInfoConfig(config, request, execution);
			} else if (goal.equals("xtend-test-install-debug-info")) {
				readTestDebugInfoConfig(config, request, execution);
			}
		}

		writePreferences(config, request.getProject());
	}

	private void writePreferences(OutputConfiguration configuration,
			IProject project) {
		ProjectScope projectPreferences = new ProjectScope(project);
		IEclipsePreferences languagePreferences = projectPreferences
				.getNode("org.eclipse.xtend.core.Xtend");
		languagePreferences.putBoolean(
				OptionsConfigurationBlock.IS_PROJECT_SPECIFIC, true);
		languagePreferences.putBoolean(PREF_AUTO_BUILDING, true);
		languagePreferences.put(getKey(configuration, OUTPUT_NAME),
				configuration.getName());
		languagePreferences.put(getKey(configuration, OUTPUT_DESCRIPTION),
				configuration.getDescription());
		languagePreferences.put(getKey(configuration, OUTPUT_DIRECTORY),
				configuration.getOutputDirectory());
		languagePreferences.putBoolean(getKey(configuration, OUTPUT_DERIVED),
				configuration.isSetDerivedProperty());
		languagePreferences.putBoolean(
				getKey(configuration, OUTPUT_CREATE_DIRECTORY),
				configuration.isCreateOutputDirectory());
		languagePreferences.putBoolean(
				getKey(configuration, OUTPUT_CLEAN_DIRECTORY),
				configuration.isCanClearOutputDirectory());
		languagePreferences.putBoolean(getKey(configuration, OUTPUT_OVERRIDE),
				configuration.isOverrideExistingResources());
		languagePreferences.putBoolean(
				getKey(configuration, OUTPUT_CLEANUP_DERIVED),
				configuration.isCleanUpDerivedResources());
		languagePreferences.putBoolean(
				getKey(configuration, INSTALL_DSL_AS_PRIMARY_SOURCE),
				configuration.isInstallDslAsPrimarySource());
		languagePreferences.putBoolean(
				getKey(configuration, HIDE_LOCAL_SYNTHETIC_VARIABLES),
				configuration.isHideSyntheticLocalVariables());
		languagePreferences.putBoolean(
				getKey(configuration, OUTPUT_KEEP_LOCAL_HISTORY),
				configuration.isKeepLocalHistory());
		languagePreferences.putBoolean(
				getKey(configuration, USE_OUTPUT_PER_SOURCE_FOLDER),
				configuration.isUseOutputPerSourceFolder());
		for (SourceMapping sourceMapping : configuration.getSourceMappings()) {
			languagePreferences.put(
					getOutputForSourceFolderKey(configuration,
							sourceMapping.getSourceFolder()),
					Strings.nullToEmpty(sourceMapping.getOutputDirectory()));
			languagePreferences.putBoolean(
					getIgnoreSourceFolderKey(configuration,
							sourceMapping.getSourceFolder()),
					sourceMapping.isIgnore());
		}

		try {
			languagePreferences.flush();
		} catch (BackingStoreException e) {
			throw new RuntimeIOException(e);
		}
	}

	private void readCompileConfig(OutputConfiguration config,
			ProjectConfigurationRequest request, MojoExecution execution)
			throws CoreException {
		for (String source : request.getMavenProject().getCompileSourceRoots()) {
			SourceMapping mapping = new SourceMapping(makeProjectRelative(
					source, request));
			String outputDirectory = getParameterValue("outputDirectory",
					String.class, request.getMavenSession(), execution);
			mapping.setOutputDirectory(makeProjectRelative(outputDirectory,
					request));
			config.getSourceMappings().add(mapping);
		}
	}

	private void readTestCompileConfig(OutputConfiguration config,
			ProjectConfigurationRequest request, MojoExecution execution)
			throws CoreException {
		for (String source : request.getMavenProject()
				.getTestCompileSourceRoots()) {
			SourceMapping mapping = new SourceMapping(makeProjectRelative(
					source, request));
			String testOutputDirectory = getParameterValue(
					"testOutputDirectory", String.class,
					request.getMavenSession(), execution);
			mapping.setOutputDirectory(makeProjectRelative(testOutputDirectory,
					request));
			config.getSourceMappings().add(mapping);
		}
	}

	private String makeProjectRelative(String fileName,
			ProjectConfigurationRequest request) {
		try {
			String baseDir = request.getMavenProject().getBasedir().getCanonicalPath();
			File file = new File(fileName);
			String relativePath;
			if (file.isAbsolute()) {
				relativePath = StringUtils.prechomp(file.getCanonicalPath(), baseDir);
			} else {
				relativePath = file.getPath();
			}
			String unixDelimited = relativePath.replaceAll("\\\\", "/");
			return StringUtils.prechomp(unixDelimited, "/");
		} catch (IOException e) {
			throw new RuntimeIOException(e);
		}
	}

	private void readDebugInfoConfig(OutputConfiguration config,
			ProjectConfigurationRequest request, MojoExecution execution)
			throws CoreException {
		config.setHideSyntheticLocalVariables(getParameterValue(
				"hideSyntheticVariables", Boolean.class,
				request.getMavenSession(), execution));
		config.setInstallDslAsPrimarySource(getParameterValue(
				"xtendAsPrimaryDebugSource", Boolean.class,
				request.getMavenSession(), execution));
	}

	private void readTestDebugInfoConfig(OutputConfiguration config,
			ProjectConfigurationRequest request, MojoExecution execution)
			throws CoreException {
		config.setHideSyntheticLocalVariables(getParameterValue(
				"hideSyntheticVariables", Boolean.class,
				request.getMavenSession(), execution));
		config.setInstallDslAsPrimarySource(getParameterValue(
				"xtendAsPrimaryDebugSource", Boolean.class,
				request.getMavenSession(), execution));
	}
}