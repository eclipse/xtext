/**
 * 
 */
package org.eclipse.xtext.builder.standalone;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.common.types.descriptions.IStubGenerator;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfiguration.SourceMapping;
import org.eclipse.xtext.generator.URIBasedFileSystemAccess;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.parser.IEncodingProvider.Runtime;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * @author Dennis Huebner - Initial contribution and API
 * 
 */
public class LanguageAccess {
	private static final Logger LOG = Logger.getLogger(LanguageAccess.class);

	private Set<OutputConfiguration> outputConfigs;
	private IResourceServiceProvider resourceServiceProvider;
	private boolean linksAgainstJava = true;

	public LanguageAccess(Set<OutputConfiguration> outputConfigurations,
			IResourceServiceProvider resourceServiceProvider) {
		this(outputConfigurations, resourceServiceProvider, false);
	}

	public LanguageAccess(Set<OutputConfiguration> outputConfigurations,
			IResourceServiceProvider resourceServiceProvider, boolean linksAgainstJavaTypes) {
		this.outputConfigs = outputConfigurations;
		this.resourceServiceProvider = resourceServiceProvider;
		this.linksAgainstJava = linksAgainstJavaTypes;
	}

	public GeneratorDelegate getGenerator() {
		return resourceServiceProvider.get(GeneratorDelegate.class);
	}

	public IStubGenerator getStubGenerator() {
		return resourceServiceProvider.get(IStubGenerator.class);
	}
	
	/**
	 * @since 2.9
	 */
	public IResourceServiceProvider getResourceServiceProvider() {
		return resourceServiceProvider;
	}

	public JavaIoFileSystemAccess createFileSystemAccess(final File baseDir) {
		JavaIoFileSystemAccess fsa = resourceServiceProvider.get(JavaIoFileSystemAccess.class);
		try {
			configureFileSystemAccess(URI.createFileURI(baseDir.getCanonicalPath()), fsa);
		} catch (IOException e) {
			throw new WrappedException(e);
		}
		return fsa;
	}
	
	public URIBasedFileSystemAccess createUriBasedFileSystemAccess(final URI baseDir) {
		URIBasedFileSystemAccess fsa = resourceServiceProvider.get(URIBasedFileSystemAccess.class);
		configureFileSystemAccess(baseDir, fsa);
		return fsa;
	}

	private void configureFileSystemAccess(final URI baseDir, AbstractFileSystemAccess2 fsa) {
		Set<OutputConfiguration> confsForFsa = Sets.newHashSet();
		Set<OutputConfiguration> pomOutputConfigs = getConfiguredOutputConfigs();
		if (pomOutputConfigs != null && !pomOutputConfigs.isEmpty()) {
			for (OutputConfiguration pomConfig : pomOutputConfigs) {
				if (getOutputConfigurationProvider().getOutputConfigurations().contains(pomConfig)) {
					confsForFsa.add(pomConfig);
				} else {
					LOG.warn("Output '" + pomConfig.getName() + "' is not configured in OutputConfigurationProvider.");
				}
			}
		}
		confsForFsa.addAll(getOutputConfigurationProvider().getOutputConfigurations());
		Map<String, OutputConfiguration> asMap = IterableExtensions.toMap(
				Iterables.transform(confsForFsa, new Function<OutputConfiguration, OutputConfiguration>() {

					@Override
					public OutputConfiguration apply(OutputConfiguration output) {
						output.setOutputDirectory(resolveToBaseDir(output.getOutputDirectory(), baseDir));
						for (SourceMapping sourceMapping : output.getSourceMappings()) {
							sourceMapping.setOutputDirectory(resolveToBaseDir(sourceMapping.getOutputDirectory(), baseDir));
						}
						return output;
					}
				}), new Function1<OutputConfiguration, String>() {
					@Override
					public String apply(final OutputConfiguration it) {
						return it.getName();
					}
				});
		fsa.setOutputConfigurations(asMap);
	}

	public Set<OutputConfiguration> getConfiguredOutputConfigs() {
		return outputConfigs;
	}

	public IResourceDescription.Manager getResourceDescriptionManager() {
		return resourceServiceProvider.getResourceDescriptionManager();
	}

	public IOutputConfigurationProvider getOutputConfigurationProvider() {
		return resourceServiceProvider.get(IOutputConfigurationProvider.class);
	}

	public IEncodingProvider getEncodingProvider() {
		return resourceServiceProvider.get(Runtime.class);
	}

	public IResourceValidator getResourceValidator() {
		return resourceServiceProvider.getResourceValidator();
	}

	public void setLinksAgainstJava(boolean linksAgainstJava) {
		this.linksAgainstJava = linksAgainstJava;
	}

	public boolean isLinksAgainstJava() {
		return linksAgainstJava;
	}

	protected String resolveToBaseDir(final String directory, URI baseDir) {
		URI outDir = URI.createURI(directory);
		if (outDir.isRelative()) {
			outDir = outDir.resolve(baseDir);
		}
		return outDir.toString();
	}
}
