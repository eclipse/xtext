/**
 * 
 */
package org.eclipse.xtext.maven;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.LanguageAccessFactory;
import org.eclipse.xtext.builder.standalone.StandaloneBuilder;
import org.eclipse.xtext.builder.standalone.compiler.CompilerConfiguration;
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Predicate;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public abstract class AbstractXtextGeneratorMojo extends AbstractMojo {

	/**
	 * Lock object to ensure thread-safety
	 */
	private static final Object lock = new Object();

	/**
	 * Location of the generated source files.
	 */
	@Parameter(defaultValue = "${project.build.directory}/xtext-temp")
	private String tmpClassDirectory;

	/**
	 * File encoding argument for the generator.
	 */
	@Parameter(property = "xtext.encoding", defaultValue = "${project.build.sourceEncoding}")
	protected String encoding;

	/**
	 * The project itself. This parameter is set by maven.
	 */
	@Parameter(defaultValue = "${project}", readonly = true, required = true)
	protected MavenProject project;

	/**
	 * Project source roots. List of folders, where the source models are located.<br>
	 * The default value is a reference to the project's ${project.compileSourceRoots}.<br>
	 * When adding a new entry the default value will be overwritten not extended.
	 */
	@Parameter(defaultValue = "${project.compileSourceRoots}", required = true)
	private List<String> sourceRoots;

	/**
	 * Java source roots. List of folders, where the java source files are located.<br>
	 * The default value is a reference to the project's ${project.compileSourceRoots}.<br>
	 * When adding a new entry the default value will be overwritten not extended.<br>
	 * Used when your language needs java.
	 */
	@Parameter(defaultValue = "${project.compileSourceRoots}", required = true)
	private List<String> javaSourceRoots;

	@Parameter(required = true)
	private List<Language> languages;

	/**
	 * you can specify a list of project mappings that is used to populate the EMF Platform Resource Map.
	 * 
	 * <pre>
		&lt;projectMappings&gt;
			&lt;projectMapping&gt;
				&lt;projectName&gt;sample.emf&lt;/projectName&gt;
				&lt;path&gt;${project.basedir}&lt;/path&gt;
			&lt;/projectMapping&gt;
			&lt;projectMapping&gt;
				&lt;projectName&gt;sample.emf.edit&lt;/projectName&gt;
				&lt;path&gt;${project.basedir}/../sample.emf.edit&lt;/path&gt;
			&lt;/projectMapping&gt;
		&lt;/projectMappings&gt;
	 * </pre>
	 */
	@Parameter
	private List<ProjectMapping> projectMappings;

	@Parameter(property = "xtext.generator.skip", defaultValue = "false")
	private Boolean skip;

	@Parameter(defaultValue = "true")
	private Boolean failOnValidationError;

	@Parameter(property = "maven.compiler.source", defaultValue = "1.6")
	private String compilerSourceLevel;

	@Parameter(property = "maven.compiler.target", defaultValue = "1.6")
	private String compilerTargetLevel;

	@Parameter(defaultValue = "false")
	private Boolean compilerSkipAnnotationProcessing;

	@Parameter(defaultValue = "false")
	private Boolean compilerPreserveInformationAboutFormalParameters;

	/**
	 * RegEx expression to filter class path during model files look up
	 */
	@Parameter
	private String classPathLookupFilter;

	/**
	 * Clustering configuration to avoid OOME
	 */
	@Parameter
	private ClusteringConfig clusteringConfig;

	/**
	 * if enabled the plugin will scan the project and its siblings and add them to the platform resource map automatically
	 */
	@Parameter(defaultValue = "false")
	private Boolean autoFillPlatformResourceMap = Boolean.FALSE;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.maven.plugin.Mojo#execute()
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {
		if (skip) {
			getLog().info("skipped.");
		} else {
			synchronized (lock) {
				new MavenLog4JConfigurator().configureLog4j(getLog());
				autoAddToPlatformResourceMap(project);
				manuallyAddToPlatformResourceMap();
				internalExecute();
			}
		}
	}

	protected void internalExecute() throws MojoExecutionException, MojoFailureException {
		Map<String, LanguageAccess> languages = new LanguageAccessFactory().createLanguageAccess(getLanguages(), this.getClass().getClassLoader());
		Injector injector = Guice.createInjector(new MavenStandaloneBuilderModule());
		StandaloneBuilder builder = injector.getInstance(StandaloneBuilder.class);
		builder.setBaseDir(project.getBasedir().getAbsolutePath());
		builder.setLanguages(languages);
		builder.setEncoding(encoding);
		builder.setClassPathEntries(getClasspathElements());
		builder.setClassPathLookUpFilter(classPathLookupFilter);
		builder.setSourceDirs(sourceRoots);
		builder.setJavaSourceDirs(javaSourceRoots);
		builder.setFailOnValidationError(failOnValidationError);
		builder.setTempDir(createTempDir().getAbsolutePath());
		builder.setDebugLog(getLog().isDebugEnabled());
		if (clusteringConfig != null)
			builder.setClusteringConfig(clusteringConfig.convertToStandaloneConfig());
		configureCompiler(builder.getCompiler());
		logState();
		boolean errorDetected = !builder.launch();
		if (errorDetected && failOnValidationError) {
			throw new MojoExecutionException("Execution failed due to a severe validation error.");
		}
	}

	private void configureCompiler(IJavaCompiler compiler) {
		CompilerConfiguration conf = compiler.getConfiguration();
		conf.setSourceLevel(compilerSourceLevel);
		conf.setTargetLevel(compilerTargetLevel);
		conf.setVerbose(getLog().isDebugEnabled());
		conf.setSkipAnnotationProcessing(compilerSkipAnnotationProcessing);
		conf.setPreserveInformationAboutFormalParameters(compilerPreserveInformationAboutFormalParameters);
	}

	private void logState() {
		getLog().info("Encoding: " + (encoding == null ? "not set. Encoding provider will be used." : encoding));
		getLog().info("Compiler source level: " + compilerSourceLevel);
		getLog().info("Compiler target level: " + compilerTargetLevel);
		if (getLog().isDebugEnabled()) {
			getLog().debug("Source dirs: " + IterableExtensions.join(sourceRoots, ", "));
			getLog().debug("Java source dirs: " + IterableExtensions.join(javaSourceRoots, ", "));
			getLog().debug("Classpath entries: " + IterableExtensions.join(getClasspathElements(), ", "));
		}
	}

	private File createTempDir() {
		File tmpDir = new File(tmpClassDirectory);
		if (!tmpDir.mkdirs() && !tmpDir.exists()) {
			throw new IllegalArgumentException("Couldn't create directory '" + tmpClassDirectory + "'.");
		}
		return tmpDir;
	}

	protected Predicate<String> emptyStringFilter() {
		return new Predicate<String>() {
			public boolean apply(String input) {
				return !Strings.isEmpty(input.trim());
			}
		};
	}

	public abstract Set<String> getClasspathElements();

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<ProjectMapping> getProjectMappings() {
		return projectMappings;
	}

	public void setProjectMappings(List<ProjectMapping> projectMappings) {
		this.projectMappings = projectMappings;
	}

	/**
	 * Adds the given project and its child modules ({@link MavenProject#getModules()}) to {@link EcorePlugin#getPlatformResourceMap()}. Furthermore, this traverses {@link MavenProject#getParent()} recursively, if set.
	 *
	 * @param project
	 *            the project
	 */
	private void autoAddToPlatformResourceMap(final MavenProject project) {
		if (autoFillPlatformResourceMap) {
			addToPlatformResourceMap(project.getBasedir());
			project.getModules().stream().map(module -> new File(project.getBasedir(), module)).forEach(e -> addToPlatformResourceMap(e));

			if (project.getParent() != null)
				autoAddToPlatformResourceMap(project.getParent());
		}
	}

	private void manuallyAddToPlatformResourceMap() {
		if (projectMappings != null) {
			for (ProjectMapping projectMapping : projectMappings) {
				if (projectMapping.getPath() != null && projectMapping.getProjectName() != null) {
					String path = projectMapping.getPath().toURI().toString();
					String name = projectMapping.getProjectName();
					getLog().info("Adding project '" + name + "' with path '" + path + "' to Platform Resource Map");
					final URI uri = URI.createURI(path);
					EcorePlugin.getPlatformResourceMap().put(name, uri);
				}
			}
		}
	}

	/**
	 * Adds the given file to EcorePlugin's platform resource map. The file's name will be used as the map entry's key.
	 *
	 * @param file
	 *            a file to register
	 * @return the registered URI pointing to the given file
	 * @see EcorePlugin#getPlatformResourceMap()
	 */
	private URI addToPlatformResourceMap(final File file) {
		getLog().info("Adding project '" + file.getName() + "' with path '" + file.toURI().toString() + "' to Platform Resource Map");
		final URI uri = URI.createURI(file.toURI().toString());
		return EcorePlugin.getPlatformResourceMap().put(file.getName(), uri);
	}
}
