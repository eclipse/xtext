/**
 * 
 */
package org.eclipse.xtext.maven;

import static com.google.common.collect.Iterables.filter;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.LanguageAccessFactory;
import org.eclipse.xtext.builder.standalone.StandaloneBuilder;
import org.eclipse.xtext.builder.standalone.compiler.CompilerConfiguration;
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Dennis Huebner - Initial contribution and API
 * 
 * @goal generate
 * @phase generate-sources
 * @requiresDependencyResolution compile
 */
public class XtextGenerator extends AbstractMojo {

	/**
	 * Location of the generated source files.
	 * 
	 * @parameter expression="${project.build.directory}/xtext-temp"
	 * @readonly
	 */
	private String tmpClassDirectory;

	/**
	 * File encoding argument for the generator.
	 * 
	 * @parameter expression="${encoding}"
	 *            default-value="${project.build.sourceEncoding}"
	 */
	protected String encoding;

	/**
	 * The project itself. This parameter is set by maven.
	 * 
	 * @parameter expression="${project}"
	 * @required
	 */
	protected MavenProject project;

	/**
	 * Project classpath.
	 * 
	 * @parameter expression="${project.compileClasspathElements}"
	 * @readonly
	 * @required
	 */
	private List<String> classpathElements;

	/**
	 * Project source roots.
	 * 
	 * @parameter expression="${sourceRoots}"
	 *            default-value="${project.compileSourceRoots}"
	 * @required
	 */
	private List<String> sourceRoots;

	/**
	 * @parameter
	 * @required
	 */
	private List<Language> languages;

	/**
	 * @parameter default-value="false"
	 */
	private Boolean skip;

	/**
	 * @parameter default-value="false"
	 */
	private Boolean failOnValidationError;

	/**
	 * @parameter expression="${maven.compiler.source}" default-value="1.5"
	 */
	private String compilerSourceLevel;

	/**
	 * @parameter expression="${maven.compiler.target}" default-value="1.5"
	 */
	private String compilerTargetLevel;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.maven.plugin.Mojo#execute()
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {
		if (skip) {
			getLog().info("skipped.");
		} else {
			new MavenLog4JConfigurator().configureLog4j(getLog());
			internalExecute();
		}
	}

	protected void internalExecute() throws MojoExecutionException, MojoFailureException {
		Map<String, LanguageAccess> languages = new LanguageAccessFactory().createLanguageAccess(getLanguages(), this
				.getClass().getClassLoader());
		Iterable<String> classPathEntries = filter(getClasspathElements(), emptyStringFilter());
		Injector injector = Guice.createInjector(new MavenStandaloneBuilderModule());
		StandaloneBuilder builder = injector.getInstance(StandaloneBuilder.class);
		builder.setLanguages(languages);
		builder.setEncoding(encoding);
		builder.setClassPathEntries(classPathEntries);
		builder.setSourceDirs(Lists.newArrayList(sourceRoots));
		builder.setTempDir(createTempDir().getAbsolutePath());
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
		conf.setVerbose(false);
	}

	private void logState() {
		getLog().info("Encoding: " + encoding);
		getLog().info("Compiler source level: " + compilerSourceLevel);
		getLog().info("Compiler target level: " + compilerTargetLevel);
		if (getLog().isDebugEnabled()) {
			getLog().debug("Source dirs: " + IterableExtensions.join(sourceRoots, ", "));
			getLog().debug("Classpath entries: " + IterableExtensions.join(classpathElements, ", "));
		}
	}

	private File createTempDir() {
		File tmpDir = new File(tmpClassDirectory);
		tmpDir.mkdirs();
		return tmpDir;
	}

	private Predicate<String> emptyStringFilter() {
		return new Predicate<String>() {
			public boolean apply(String input) {
				return !Strings.isEmpty(input.trim());
			}
		};
	}

	public List<String> getClasspathElements() {
		return classpathElements;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
}
