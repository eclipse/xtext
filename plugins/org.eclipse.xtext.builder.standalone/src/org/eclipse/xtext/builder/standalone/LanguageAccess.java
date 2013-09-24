/**
 * 
 */
package org.eclipse.xtext.builder.standalone;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.xtext.common.types.descriptions.IStubGenerator;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfigurationProvider;
import org.eclipse.xtext.parser.IEncodingProvider.Runtime;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.collect.Sets;

/**
 * @author Dennis Huebner - Initial contribution and API
 * 
 */
public class LanguageAccess {
	private static final Logger LOG = Logger.getLogger(LanguageAccess.class);

	private Set<OutputConfiguration> outputConfigs;
	private IResourceServiceProvider resourceServiceProvider;
	private boolean linkAgainstJava = true;
	private JavaIoFileSystemAccess fsa;

	public LanguageAccess(Set<OutputConfiguration> outputConfigurations,
			IResourceServiceProvider resourceServiceProvider) {
		this.outputConfigs = outputConfigurations;
		this.resourceServiceProvider = resourceServiceProvider;
	}

	public IGenerator getGenerator() {
		return resourceServiceProvider.get(IGenerator.class);
	}

	public IStubGenerator getStubGenerator() {
		return resourceServiceProvider.get(IStubGenerator.class);
	}

	public JavaIoFileSystemAccess getFileSystemAccess() {
		if (fsa == null) {
			fsa = configuredFileSystemAccess(resourceServiceProvider.get(JavaIoFileSystemAccess.class));
		}
		return fsa;
	}

	private JavaIoFileSystemAccess configuredFileSystemAccess(JavaIoFileSystemAccess fsaToConfigure) {
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
		Map<String, OutputConfiguration> asMap = IterableExtensions.toMap(confsForFsa,
				new Function1<OutputConfiguration, String>() {
					public String apply(final OutputConfiguration it) {
						return it.getName();
					}
				});
		fsaToConfigure.setOutputConfigurations(asMap);
		return fsaToConfigure;
	}

	public Set<OutputConfiguration> getConfiguredOutputConfigs() {
		return outputConfigs;
	}

	public IResourceDescription.Manager getResourceDescriptionManager() {
		return resourceServiceProvider.getResourceDescriptionManager();
	}

	public OutputConfigurationProvider getOutputConfigurationProvider() {
		return resourceServiceProvider.get(OutputConfigurationProvider.class);
	}

	public Runtime getEncodingProvider() {
		return resourceServiceProvider.get(Runtime.class);
	}

	public IResourceValidator getResourceValidator() {
		return resourceServiceProvider.getResourceValidator();
	}

	public void setLinkAgainstJava(boolean linkAgainstJava) {
		this.linkAgainstJava = linkAgainstJava;
	}

	public boolean isLinkAgainstJava() {
		return linkAgainstJava;
	}
}
