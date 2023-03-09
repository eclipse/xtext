/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.adapter;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.LanguageConfig;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.XtextProjectConfig;

import com.google.common.base.Joiner;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @since 2.9
 */
@Deprecated(forRemoval = true)
public class Generator2AdapterSetup {
	private LanguageConfig languageConfig;

	private XpandExecutionContext xpandContext;

	private Naming naming;

	private Injector injector;

	private com.google.inject.Module additionalGeneratorBindings = (Binder it) -> {
	};

	private com.google.inject.Module additionalLanguageBindings = (Binder it) -> {
	};

	public Generator2AdapterSetup(LanguageConfig languageConfig, XpandExecutionContext xpandContext, Naming naming) {
		this.languageConfig = languageConfig;
		this.xpandContext = xpandContext;
		this.naming = naming;
	}

	public Injector getInjector() {
		if (injector == null) {
			injector = createInjector();
		}
		return injector;
	}

	private Injector createInjector() {
		DefaultGeneratorModule generatorModule = new DefaultGeneratorModule() {
			@Override
			public void configure(Binder binder) {
				super.configure(binder);
				binder.install(additionalGeneratorBindings);
			}
		};
		generatorModule.setProject(createProjectConfig());
		generatorModule.setCode(createCodeConfig());

		Injector generatorInjector = Guice.createInjector(generatorModule);
		generatorModule.getProject().initialize(generatorInjector);
		generatorModule.getCode().initialize(generatorInjector);
		IXtextGeneratorLanguage language = this.createLanguage(generatorInjector);
		com.google.inject.Module languageModule = new com.google.inject.Module() {
			@Override
			public void configure(Binder binder) {
				binder.bind(IXtextGeneratorLanguage.class).toInstance(language);
				binder.bind(Grammar.class).toInstance(language.getGrammar());
				binder.bind(XtextGeneratorNaming.class).toInstance(new NamingAdapter(naming));
				binder.install(additionalLanguageBindings);
			}
		};
		return generatorInjector.createChildInjector(languageModule);
	}

	private XtextProjectConfig createProjectConfig() {
		StandardProjectConfig cfg = new StandardProjectConfig();
		cfg.setCreateEclipseMetaData(true);
		cfg.setBaseName(naming.getProjectNameRt());
		String runtimeRoot = xpandContext.getOutput().getOutlet(Generator.PLUGIN_RT).getPath();
		int projectNameIndex = runtimeRoot.lastIndexOf(cfg.getBaseName());
		if (projectNameIndex >= 0) {
			cfg.setRootPath(runtimeRoot.substring(0, projectNameIndex));
		} else {
			cfg.setRootPath(runtimeRoot);
		}
		cfg.getRuntime().setName(cfg.getBaseName());
		cfg.getRuntime().setRoot(runtimeRoot);
		cfg.getRuntime().setSrc(xpandContext.getOutput().getOutlet(Generator.SRC).getPath());
		cfg.getRuntime().setSrcGen(xpandContext.getOutput().getOutlet(Generator.SRC_GEN).getPath());
		cfg.getRuntime().setEcoreModel(xpandContext.getOutput().getOutlet(Generator.MODEL).getPath());
		cfg.getEclipsePlugin().setEnabled(true);
		cfg.getEclipsePlugin().setName(naming.getProjectNameUi());
		cfg.getEclipsePlugin().setRoot(xpandContext.getOutput().getOutlet(Generator.PLUGIN_UI).getPath());
		cfg.getEclipsePlugin().setSrc(xpandContext.getOutput().getOutlet(Generator.SRC_UI).getPath());
		cfg.getEclipsePlugin().setSrcGen(xpandContext.getOutput().getOutlet(Generator.SRC_GEN_UI).getPath());
		cfg.getGenericIde().setEnabled(true);
		cfg.getGenericIde().setName(naming.getProjectNameIde());
		cfg.getGenericIde().setRoot(xpandContext.getOutput().getOutlet(Generator.PLUGIN_IDE).getPath());
		cfg.getGenericIde().setSrc(xpandContext.getOutput().getOutlet(Generator.SRC_IDE).getPath());
		cfg.getGenericIde().setSrcGen(xpandContext.getOutput().getOutlet(Generator.SRC_GEN_IDE).getPath());
		return cfg;
	}

	private CodeConfig createCodeConfig() {
		CodeConfig codeConfig = new CodeConfig();
		codeConfig.setLineDelimiter(naming.getLineDelimiter());
		codeConfig.setFileHeader(naming.fileHeader());
		return codeConfig;
	}

	private IXtextGeneratorLanguage createLanguage(Injector generatorInjector) {
		XtextGeneratorLanguage xtextGeneratorLanguage = new XtextGeneratorLanguage();
		xtextGeneratorLanguage.setGrammarUri(languageConfig.getGrammar().eResource().getURI().toString());
		xtextGeneratorLanguage.setResourceSet(languageConfig.getGrammar().eResource().getResourceSet());
		xtextGeneratorLanguage
				.setFileExtensions(Joiner.on(',').join(languageConfig.getFileExtensions(languageConfig.getGrammar())));
		generatorInjector.injectMembers(xtextGeneratorLanguage);
		xtextGeneratorLanguage.initialize(languageConfig.getGrammar());
		return xtextGeneratorLanguage;
	}

	public void setAdditionalGeneratorBindings(com.google.inject.Module additionalGeneratorBindings) {
		this.additionalGeneratorBindings = additionalGeneratorBindings;
	}

	public void setAdditionalLanguageBindings(com.google.inject.Module additionalLanguageBindings) {
		this.additionalLanguageBindings = additionalLanguageBindings;
	}
}
