package org.eclipse.xtext.m2e

import com.google.common.collect.Lists
import org.eclipse.xtext.generator.IFileSystemAccess

class Languages implements Iterable<Language> {
	var languages = Lists.<Language>newArrayList

	def void addLanguage(Language lang) {
		languages.add(lang)
	}

	override iterator() {
		languages.iterator
	}
}

class Language {
	@Property String setup
	@Property var outputConfigurations = Lists.<OutputConfiguration>newArrayList

	def name() {
		//this seems a little hairy, but I have yet to see an example where this does not work ;)
		setup.replaceAll("StandaloneSetup", "")
	}
}

class OutputConfiguration {
	@Property String name = IFileSystemAccess.DEFAULT_OUTPUT;
	@Property String description = ""
	@Property String outputDirectory
	@Property boolean createOutputDirectory = true
	@Property boolean overrideExistingResources = true
	@Property boolean installDslAsPrimarySource = false
	@Property boolean hideSyntheticLocalVariables = true
	@Property boolean canClearOutputDirectory = false
	@Property boolean cleanUpDerivedResources = true

	def org.eclipse.xtext.generator.OutputConfiguration toGeneratorConfiguration() {
		new org.eclipse.xtext.generator.OutputConfiguration(this.name) => [
			description = this.description
			outputDirectory = this.outputDirectory
			createOutputDirectory = this.createOutputDirectory
			overrideExistingResources = this.overrideExistingResources
			installDslAsPrimarySource = this.installDslAsPrimarySource
			hideSyntheticLocalVariables = this.installDslAsPrimarySource
			canClearOutputDirectory = this.canClearOutputDirectory
			cleanUpDerivedResources = this.cleanUpDerivedResources
		]
	}
}
