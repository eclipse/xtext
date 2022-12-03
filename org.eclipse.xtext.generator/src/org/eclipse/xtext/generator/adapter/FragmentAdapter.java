/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.adapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.PostProcessor;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.generator.IGeneratorFragmentExtension;
import org.eclipse.xtext.generator.IGeneratorFragmentExtension2;
import org.eclipse.xtext.generator.IGeneratorFragmentExtension3;
import org.eclipse.xtext.generator.IGeneratorFragmentExtension4;
import org.eclipse.xtext.generator.LanguageConfig;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.NamingAware;
import org.eclipse.xtext.generator.NewlineNormalizer;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.MweIssues;
import org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @since 2.9
 * 
 * @deprecated please rewrite your fragment with the new generator
 * infrastructure.
 */
@Deprecated(forRemoval = true)
public class FragmentAdapter extends AbstractXtextGeneratorFragment {
	@Inject
	private CodeConfig codeConfig;

	@Inject
	private IEncodingProvider encodingProvider;

	@Inject
	private XtextGeneratorNaming xtextGeneratorNaming;

	private IGeneratorFragment fragment;

	private Naming naming;

	private final List<PostProcessor> postProcessors = new ArrayList<>();

	public FragmentAdapter() {
	}

	public FragmentAdapter(IGeneratorFragment fragment) {
		setFragment(fragment);
	}

	public void addPostProcessor(PostProcessor postProcessor) {
		postProcessors.add(postProcessor);
	}

	@Override
	public void checkConfiguration(Issues issues) {
		if (naming == null) {
			naming = createNaming();
		}
		if (fragment == null) {
			issues.addError("The property \'fragment\' must be set.", this);
		} else {
			fragment.checkConfiguration(((MweIssues) issues).getDelegate());
		}
	}

	@Override
	public void generate() {
		if (naming == null) {
			naming = createNaming();
		}
		XpandExecutionContext ctx = createExecutionContext();
		LanguageConfig config1 = createLanguageConfig();
		if (fragment instanceof IGeneratorFragmentExtension2) {
			((IGeneratorFragmentExtension2) fragment).generate(config1, ctx);
		} else {
			fragment.generate(config1.getGrammar(), ctx);
		}
		generateStandaloneSetup(config1, ctx);
		generateGuiceModuleRt(config1, ctx);
		generateGuiceModuleUi(config1, ctx);
		generatePluginXmlRt(config1, ctx);
		generateManifestRt(config1, ctx);
		generatePluginXmlUi(config1, ctx);
		generateManifestUi(config1, ctx);
		generateManifestIde(config1, ctx);
		generateManifestTests(config1, ctx);
	}

	private void generateStandaloneSetup(LanguageConfig config1, XpandExecutionContext ctx) {
		ctx.getOutput().openFile(null, StringConcatOutputImpl.STRING_OUTLET);
		try {
			IXtextGeneratorLanguage config2 = getLanguage();
			if (fragment instanceof IGeneratorFragmentExtension2) {
				((IGeneratorFragmentExtension2) fragment).addToStandaloneSetup(config1, ctx);
			} else {
				fragment.addToStandaloneSetup(config1.getGrammar(), ctx);
			}
			StringConcatenation result = ((StringConcatOutputImpl) ctx.getOutput()).getStringOutlet();
			config2.getRuntimeGenSetup().getRegistrations().add(new StringConcatenationClient() {
				@Override
				protected void appendTo(StringConcatenationClient.TargetStringConcatenation builder) {
					builder.append(decreaseIndentation(result.toString(), 2));
				}
			});
			config2.getRuntimeGenSetup().getImports().add(new TypeReference("org.eclipse.emf.ecore.EPackage"));
			config2.getRuntimeGenSetup().getImports().add(new TypeReference("org.eclipse.emf.ecore.resource.Resource"));
		} finally {
			ctx.getOutput().closeFile();
		}
	}

	private void generateGuiceModuleRt(LanguageConfig config1, XpandExecutionContext ctx) {
		IXtextGeneratorLanguage config2 = getLanguage();
		Set<Binding> bindings = fragment.getGuiceBindingsRt(config1.getGrammar());
		if (bindings != null) {
			config2.getRuntimeGenModule().addAll(Iterables.transform(bindings, it -> translateBinding(it)));
		}
		if (fragment instanceof IGeneratorFragmentExtension4) {
			String superClass = ((IGeneratorFragmentExtension4) fragment)
					.getDefaultRuntimeModuleClassName(config1.getGrammar());
			if (superClass != null) {
				config2.getRuntimeGenModule().setSuperClass(new TypeReference(superClass));
			}
		}
	}

	private void generateGuiceModuleUi(LanguageConfig config1, XpandExecutionContext ctx) {
		IXtextGeneratorLanguage config2 = getLanguage();
		Set<Binding> bindings = fragment.getGuiceBindingsUi(config1.getGrammar());
		if (bindings != null) {
			config2.getEclipsePluginGenModule().addAll(Iterables.transform(bindings, it -> translateBinding(it)));
		}
		if (fragment instanceof IGeneratorFragmentExtension4) {
			String superClass = ((IGeneratorFragmentExtension4) fragment)
					.getDefaultUiModuleClassName(config1.getGrammar());
			if (superClass != null) {
				config2.getEclipsePluginGenModule().setSuperClass(new TypeReference(superClass));
			}
		}
	}

	private GuiceModuleAccess.Binding translateBinding(Binding it) {
		GuiceModuleAccess.BindKey newKey;
		String[] statements = it.getValue().getStatements();
		if (statements == null
				|| statements.length==0) {
			String type = it.getKey().getType();
			TypeReference guessTypeRef = null;
			if (type != null) {
				guessTypeRef = TypeReference.guessTypeRef(type);
			}
			newKey = new GuiceModuleAccess.BindKey(null, guessTypeRef, it.getKey().isSingleton(), it.getKey().isEagerSingleton());
		} else {
			newKey = new GuiceModuleAccess.BindKey(getClassName(it.getKey().getType()), null, it.getKey().isSingleton(), it.getKey().isEagerSingleton());
		}
		String typeName = it.getValue().getTypeName();
		TypeReference guessTypeRef2 = null;
		if (typeName != null) {
			guessTypeRef2 = TypeReference.guessTypeRef(typeName);
		}
		@SuppressWarnings("unchecked")
		List<String> statementList = (List<String>) Conversions.doWrapArray(statements);
		GuiceModuleAccess.BindValue newValue = new GuiceModuleAccess.BindValue(it.getValue().getExpression(), guessTypeRef2,
				it.getValue().isProvider(), Lists.transform(
						statementList, (String s) -> {
							if (s.endsWith(";")) {
								return s;
							} else {
								return s + ";";
							}
						}));
		return new GuiceModuleAccess.Binding(newKey, newValue, it.isFinal(), it.getContributedBy());
	}

	private String getClassName(String qualifiedName) {
		int classStart = qualifiedName.length();
		for (int i = qualifiedName.length() - 1; i >= 0; i--) {
			if (matches(qualifiedName.charAt(i), '.')) {
				if (Character.isLowerCase(qualifiedName.charAt((i + 1)))) {
					return qualifiedName.substring(classStart);
				} else {
					classStart = i + 1;
				}
			}
		}
		return qualifiedName;
	}

	private void generatePluginXmlRt(LanguageConfig config1, XpandExecutionContext ctx) {
		if (getProjectConfig().getRuntime().getPluginXml() != null) {
			ctx.getOutput().openFile(null, StringConcatOutputImpl.STRING_OUTLET);
			try {
				if (fragment instanceof IGeneratorFragmentExtension2) {
					((IGeneratorFragmentExtension2) fragment).addToPluginXmlRt(config1, ctx);
				} else {
					fragment.addToPluginXmlRt(config1.getGrammar(), ctx);
				}
				StringConcatenation result = ((StringConcatOutputImpl) ctx.getOutput()).getStringOutlet();
				StringBuilder entry = decreaseIndentation(result.toString(), 1);
				if (!entry.toString().trim().isEmpty()) {
					getProjectConfig().getRuntime().getPluginXml().getEntries().add(entry);
				}
			} finally {
				ctx.getOutput().closeFile();
			}
		}
	}

	private void generatePluginXmlUi(LanguageConfig config1, XpandExecutionContext ctx) {
		if (getProjectConfig().getEclipsePlugin().getPluginXml() != null) {
			ctx.getOutput().openFile(null, StringConcatOutputImpl.STRING_OUTLET);
			try {
				if (fragment instanceof IGeneratorFragmentExtension2) {
					((IGeneratorFragmentExtension2) fragment).addToPluginXmlUi(config1, ctx);
				} else {
					fragment.addToPluginXmlUi(config1.getGrammar(), ctx);
				}
				StringConcatenation result = ((StringConcatOutputImpl) ctx.getOutput()).getStringOutlet();
				StringBuilder entry = decreaseIndentation(result.toString(), 1);
				if (!entry.toString().trim().isEmpty()) {
					getProjectConfig().getEclipsePlugin().getPluginXml().getEntries().add(entry);
				}
			} finally {
				ctx.getOutput().closeFile();
			}
		}
	}

	private void generateManifestRt(LanguageConfig config1, XpandExecutionContext ctx) {
		if (getProjectConfig().getRuntime().getManifest() != null) {
			String[] exported = fragment.getExportedPackagesRt(config1.getGrammar());
			if (exported != null) {
				CollectionExtensions.addAll(getProjectConfig().getRuntime().getManifest().getExportedPackages(),
						exported);
			}
			String[] required = fragment.getRequiredBundlesRt(config1.getGrammar());
			if (required != null) {
				CollectionExtensions.addAll(getProjectConfig().getRuntime().getManifest().getRequiredBundles(),
						required);
			}
			String[] imported = fragment.getImportedPackagesRt(config1.getGrammar());
			if (imported != null) {
				CollectionExtensions.addAll(getProjectConfig().getRuntime().getManifest().getImportedPackages(),
						imported);
			}
		}
	}

	private void generateManifestUi(LanguageConfig config1, XpandExecutionContext ctx) {
		if (getProjectConfig().getEclipsePlugin().getManifest() != null) {
			String[] exported = fragment.getExportedPackagesUi(config1.getGrammar());
			if (exported != null) {
				CollectionExtensions.addAll(getProjectConfig().getEclipsePlugin().getManifest().getExportedPackages(),
						exported);
			}
			String[] required = fragment.getRequiredBundlesUi(config1.getGrammar());
			if (required != null) {
				CollectionExtensions.addAll(getProjectConfig().getEclipsePlugin().getManifest().getRequiredBundles(),
						required);
			}
			String[] imported = fragment.getImportedPackagesUi(config1.getGrammar());
			if (imported != null) {
				CollectionExtensions.addAll(getProjectConfig().getEclipsePlugin().getManifest().getImportedPackages(),
						imported);
			}
		}
	}

	private void generateManifestIde(LanguageConfig config1, XpandExecutionContext ctx) {
		if (fragment instanceof IGeneratorFragmentExtension3
				&& getProjectConfig().getGenericIde().getManifest() != null) {
			IGeneratorFragmentExtension3 fr = ((IGeneratorFragmentExtension3) fragment);
			String[] exported = fr.getExportedPackagesIde(config1.getGrammar());
			if (exported != null) {
				CollectionExtensions.addAll(getProjectConfig().getGenericIde().getManifest().getExportedPackages(),
						exported);
			}
			String[] required = fr.getRequiredBundlesIde(config1.getGrammar());
			if (required != null) {
				CollectionExtensions.addAll(getProjectConfig().getGenericIde().getManifest().getRequiredBundles(),
						required);
			}
			String[] imported = fr.getImportedPackagesIde(config1.getGrammar());
			if (imported != null) {
				CollectionExtensions.addAll(getProjectConfig().getGenericIde().getManifest().getImportedPackages(),
						imported);
			}
		}
	}

	private void generateManifestTests(LanguageConfig config1, XpandExecutionContext ctx) {
		if (fragment instanceof IGeneratorFragmentExtension
				&& getProjectConfig().getRuntimeTest().getManifest() != null) {
			IGeneratorFragmentExtension fr = ((IGeneratorFragmentExtension) fragment);
			String[] exported = fr.getExportedPackagesTests(config1.getGrammar());
			if (exported != null) {
				CollectionExtensions.addAll(getProjectConfig().getRuntimeTest().getManifest().getExportedPackages(),
						exported);
			}
			String[] required = fr.getRequiredBundlesTests(config1.getGrammar());
			if (required != null) {
				CollectionExtensions.addAll(getProjectConfig().getRuntimeTest().getManifest().getRequiredBundles(),
						required);
			}
			String[] imported = fr.getImportedPackagesTests(config1.getGrammar());
			if (imported != null) {
				CollectionExtensions.addAll(getProjectConfig().getRuntimeTest().getManifest().getImportedPackages(),
						imported);
			}
		}
	}

	protected Naming createNaming() {
		IXtextGeneratorLanguage config2 = getLanguage();
		Naming result = new Naming();
		IXtextGeneratorFileSystemAccess runtimeRoot = getProjectConfig().getRuntime().getRoot();
		String runtimeRootPath = null;
		if (runtimeRoot != null) {
			runtimeRootPath = runtimeRoot.getPath();
		}
		result.setProjectNameRt(getLastSegment(runtimeRootPath));
		IXtextGeneratorFileSystemAccess genericIdeRoot = getProjectConfig().getGenericIde().getRoot();
		String genericIdeRootPath = null;
		if (genericIdeRoot != null) {
			genericIdeRootPath = genericIdeRoot.getPath();
		}
		result.setProjectNameIde(getLastSegment(genericIdeRootPath));
		IXtextGeneratorFileSystemAccess eclipsePluginRoot = getProjectConfig().getEclipsePlugin().getRoot();
		String eclipsePluginRootPath = null;
		if (eclipsePluginRoot != null) {
			eclipsePluginRootPath = eclipsePluginRoot.getPath();
		}
		result.setProjectNameUi(getLastSegment(eclipsePluginRootPath));
		result.setIdeBasePackage(xtextGeneratorNaming.getGenericIdeBasePackage(config2.getGrammar()));
		result.setUiBasePackage(xtextGeneratorNaming.getEclipsePluginBasePackage(config2.getGrammar()));
		TypeReference eclipsePluginActivator = xtextGeneratorNaming.getEclipsePluginActivator();
		String activatorName = null;
		if (eclipsePluginActivator != null) {
			activatorName = eclipsePluginActivator.getName();
		}
		result.setActivatorName(activatorName);
		IXtextGeneratorFileSystemAccess runtimeTestRoot = getProjectConfig().getRuntimeTest().getRoot();
		String runtimeTestRootPath = null;
		if (runtimeTestRoot != null) {
			runtimeTestRootPath = runtimeTestRoot.getPath();
		}
		result.setPathTestProject(runtimeTestRootPath);
		result.setLineDelimiter(codeConfig.getLineDelimiter());
		result.setFileHeader(codeConfig.getFileHeader());
		result.setClassAnnotations(codeConfig.getClassAnnotationsAsString());
		result.setAnnotationImports(codeConfig.getAnnotationImportsAsString());
		result.setHasUI(result.getProjectNameUi() != null);
		result.setHasIde(result.getProjectNameIde() != null);
		result.setGrammarId(config2.getGrammar().getName());
		if (fragment instanceof NamingAware) {
			((NamingAware) fragment).registerNaming(result);
		}
		return result;
	}

	protected LanguageConfig createLanguageConfig() {
		XtextGeneratorLanguage config2 = (XtextGeneratorLanguage) getLanguage();
		LanguageConfig config = new LanguageConfig();
		config.setForcedResourceSet(config2.getResourceSet());
		config.setFileExtensions(Joiner.on(",").join(config2.getFileExtensions()));
		config.setUri(config2.getGrammarUri());
		config.registerNaming(naming);
		return config;
	}

	protected XpandExecutionContext createExecutionContext() {
		String encoding = encodingProvider.getEncoding(null);
		StringConcatOutputImpl output = new StringConcatOutputImpl();
		if (getProjectConfig().getRuntime().getRoot() != null) {
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_RT, false,
					getProjectConfig().getRuntime().getRoot().getPath()));
		}
		if (getProjectConfig().getRuntime().getSrc() != null) {
			output.addOutlet(createOutlet(false, encoding, Generator.SRC, false,
					getProjectConfig().getRuntime().getSrc().getPath()));
		}
		if (getProjectConfig().getRuntime().getSrcGen() != null) {
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN, true,
					getProjectConfig().getRuntime().getSrcGen().getPath()));
		}
		if (getProjectConfig().getRuntime().getRoot() != null) {
			output.addOutlet(createOutlet(false, encoding, Generator.MODEL, false,
					getProjectConfig().getRuntime().getRoot().getPath() + "/model"));
		}
		if (getProjectConfig().getEclipsePlugin().getRoot() != null) {
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_UI, false,
					getProjectConfig().getEclipsePlugin().getRoot().getPath()));
		} else {
			if (getProjectConfig().getRuntime().getRoot() != null) {
				output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_UI, false,
						getProjectConfig().getRuntime().getRoot().getPath()));
			}
		}
		if (getProjectConfig().getEclipsePlugin().getSrc() != null) {
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_UI, false,
					getProjectConfig().getEclipsePlugin().getSrc().getPath()));
		} else {
			if (getProjectConfig().getRuntime().getSrc() != null) {
				output.addOutlet(createOutlet(false, encoding, Generator.SRC_UI, false,
						getProjectConfig().getRuntime().getSrc().getPath()));
			}
		}
		if (getProjectConfig().getEclipsePlugin().getSrcGen() != null) {
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_UI, true,
					getProjectConfig().getEclipsePlugin().getSrcGen().getPath()));
		} else {
			if (getProjectConfig().getRuntime().getSrcGen() != null) {
				output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_UI, true,
						getProjectConfig().getRuntime().getSrcGen().getPath()));
			}
		}
		if (getProjectConfig().getGenericIde().getRoot() != null) {
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_IDE, false,
					getProjectConfig().getGenericIde().getRoot().getPath()));
		} else {
			if (getProjectConfig().getEclipsePlugin().getRoot() != null) {
				output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_IDE, false,
						getProjectConfig().getEclipsePlugin().getRoot().getPath()));
			} else {
				if (getProjectConfig().getRuntime().getRoot() != null) {
					output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_IDE, false,
							getProjectConfig().getRuntime().getRoot().getPath()));
				}
			}
		}
		if (getProjectConfig().getGenericIde().getSrc() != null) {
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_IDE, false,
					getProjectConfig().getGenericIde().getSrc().getPath()));
		} else {
			if (getProjectConfig().getEclipsePlugin().getSrc() != null) {
				output.addOutlet(createOutlet(false, encoding, Generator.SRC_IDE, false,
						getProjectConfig().getEclipsePlugin().getSrc().getPath()));
			} else {
				if (getProjectConfig().getRuntime().getSrc() != null) {
					output.addOutlet(createOutlet(false, encoding, Generator.SRC_IDE, false,
							getProjectConfig().getRuntime().getSrc().getPath()));
				}
			}
		}
		if (getProjectConfig().getGenericIde().getSrcGen() != null) {
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_IDE, true,
					getProjectConfig().getGenericIde().getSrcGen().getPath()));
		} else {
			if (getProjectConfig().getEclipsePlugin().getSrcGen() != null) {
				output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_IDE, true,
						getProjectConfig().getEclipsePlugin().getSrcGen().getPath()));
			} else {
				if (getProjectConfig().getRuntime().getSrcGen() != null) {
					output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_IDE, true,
							getProjectConfig().getRuntime().getSrcGen().getPath()));
				}
			}
		}
		if (getProjectConfig().getRuntimeTest().getRoot() != null) {
			output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_TEST, false,
					getProjectConfig().getRuntimeTest().getRoot().getPath()));
		} else {
			if (getProjectConfig().getRuntime().getRoot() != null) {
				output.addOutlet(createOutlet(false, encoding, Generator.PLUGIN_TEST, false,
						getProjectConfig().getRuntime().getRoot().getPath()));
			}
		}
		if (getProjectConfig().getRuntimeTest().getSrc() != null) {
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_TEST, false,
					getProjectConfig().getRuntimeTest().getSrc().getPath()));
		} else {
			if (getProjectConfig().getRuntime().getSrc() != null) {
				output.addOutlet(createOutlet(false, encoding, Generator.SRC_TEST, false,
						getProjectConfig().getRuntime().getSrc().getPath()));
			}
		}
		if (getProjectConfig().getRuntimeTest().getSrcGen() != null) {
			output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_TEST, true,
					getProjectConfig().getRuntimeTest().getSrcGen().getPath()));
		} else {
			if (getProjectConfig().getRuntime().getSrcGen() != null) {
				output.addOutlet(createOutlet(false, encoding, Generator.SRC_GEN_TEST, true,
						getProjectConfig().getRuntime().getSrcGen().getPath()));
			}
		}
		Map<String, Variable> globalVars = Maps.newHashMap();
		globalVars.put(Naming.GLOBAL_VAR_NAME, new Variable(Naming.GLOBAL_VAR_NAME, naming));
		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null, globalVars, null, null);
		execCtx.getResourceManager().setFileEncoding("ISO-8859-1");
		execCtx.registerMetaModel(new JavaBeansMetaModel());
		execCtx = (XpandExecutionContextImpl) execCtx
				.cloneWithVariable(new Variable("modelPluginID", naming.getProjectNameRt()));
		return execCtx;
	}

	protected Outlet createOutlet(boolean append, String encoding, String name, boolean overwrite, String path) {
		Outlet outlet = new Outlet(append, encoding, name, overwrite, path);
		outlet.addPostprocessor(new NewlineNormalizer(codeConfig.getLineDelimiter()));
		for (PostProcessor pp : postProcessors) {
			outlet.addPostprocessor(pp);
		}
		return outlet;
	}

	protected String getPath(IFileSystemAccess2 fsa) {
		String path = fsa.getURI("").toFileString();
		if (path.endsWith(File.separator)) {
			return path.substring(0, path.length() - 1);
		} else {
			return path;
		}
	}

	private String getLastSegment(String path) {
		if (path != null) {
			return path.substring(path.lastIndexOf("/") + 1);
		}
		return null;
	}

	private StringBuilder decreaseIndentation(String text, int level) {
		StringBuilder result = new StringBuilder(text.length());
		boolean newLine = true;
		int skippedSpaces = 0;
		int skippedTabs = 0;
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			boolean append = false;
			if (matches(c, '\n', '\r')) {
				newLine = true;
				append = true;
				skippedTabs = 0;
				skippedSpaces = 0;
			} else {
				if (newLine) {
					if (matches(c, ' ')) {
						skippedSpaces++;
						if (skippedSpaces >= 4) {
							skippedSpaces = 0;
							skippedTabs++;
						}
					} else {
						if (matches(c, '\t')) {
							skippedSpaces = 0;
							skippedTabs++;
						} else {
							newLine = false;
							append = true;
						}
					}
					if (skippedTabs >= level) {
						newLine = false;
					}
				} else {
					append = true;
				}
			}
			if (append) {
				result.append(c);
			}
		}
		return result;
	}

	private boolean matches(char c, char... m) {
		for (int i = 0; i < m.length; i++) {
			if (c == m[i]) {
				return true;
			}
		}
		return false;
	}

	public IGeneratorFragment getFragment() {
		return fragment;
	}

	public void setFragment(IGeneratorFragment fragment) {
		this.fragment = fragment;
	}

	public Naming getNaming() {
		return naming;
	}

	public void setNaming(Naming naming) {
		this.naming = naming;
	}
}
