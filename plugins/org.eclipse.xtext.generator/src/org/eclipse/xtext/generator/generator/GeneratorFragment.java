/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.generator;

import static com.google.common.collect.Lists.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.generator.IStubGenerating;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment;
import org.eclipse.xtext.util.Strings;

/**
 * An {@link IGeneratorFragment} to create a generator for an Xtext language.
 *
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public class GeneratorFragment extends AbstractGeneratorFragment implements IStubGenerating {
	
	private boolean generateStub = true;
	private boolean generateMwe = false;
	private boolean generateJavaMain = false;
	private boolean generateXtendMain = false;
	
	public void setGenerateJavaMain(boolean generateJavaMain) {
		this.generateJavaMain = generateJavaMain;
	}
	
	public void setGenerateXtendMain(boolean generateXtendMain) {
		this.generateXtendMain = generateXtendMain;
	}
	
	public void setGenerateMwe(boolean generateMwe) {
		this.generateMwe = generateMwe;
	}
	
	/**
	 * @deprecated use {@link #setGenerateStub(boolean)} instead
	 */
	@Deprecated
	public void setGeneratorStub(boolean isGenerateStub) {
		setGenerateStub(isGenerateStub);
	}		
	
	public void setGenerateStub(boolean isGenerateStub) {
		this.generateStub = isGenerateStub;
	}
	
	public boolean isGenerateStub() {
		return generateStub;
	}
	
	public boolean isGenerateStub(Grammar grammar) {
		if (XbaseGeneratorFragment.doesUseXbase(grammar)) {
			return false;
		}
		return isGenerateStub();
	}
	
	public boolean isGenerateJavaMain(Grammar grammar) {
		if (XbaseGeneratorFragment.doesUseXbase(grammar)) {
			return false;
		}
		return generateJavaMain;
	}
	
	public boolean isGenerateXtendMain(Grammar grammar) {
		if (XbaseGeneratorFragment.doesUseXbase(grammar)) {
			return false;
		}
		return generateXtendMain;
	}
	
	public boolean isGenerateMwe(Grammar grammar) {
		if (XbaseGeneratorFragment.doesUseXbase(grammar)) {
			return false;
		}
		return generateMwe;
	}
	
	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if(generateJavaMain && generateXtendMain) {
			issues.addWarning("Options 'generateJavaMain' and 'generateXtendMain' are mutually exclusive. Generating Xtend only.");
			generateJavaMain = false;
		}
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return newArrayList((Object)isGenerateStub(grammar), (Object)isGenerateMwe(grammar), (Object)isGenerateJavaMain(grammar), (Object)isGenerateXtendMain(grammar));
	}
	
	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		if (isGenerateStub(grammar))
			return new BindFactory().addTypeToType(IGenerator.class.getName(), getGeneratorName(grammar, getNaming())).getBindings();
		return Collections.emptySet();
	}

	@Override
	public String[] getImportedPackagesRt(Grammar grammar) {
		if (isGenerateStub(grammar))
			return new String[] {
					"org.eclipse.xtext.xbase.lib"
			};
		return Strings.EMPTY_ARRAY;
	}
	
	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] {
				"org.eclipse.xtext.builder"
		};
	}

	public static String getGeneratorName(Grammar grammar, Naming naming) {
		return naming.basePackageRuntime(grammar) + ".generator." + GrammarUtil.getName(grammar) + "Generator";
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
		.addTypeToType("org.eclipse.xtext.builder.IXtextBuilderParticipant", "org.eclipse.xtext.builder.BuilderParticipant")
		.addTypeToInstance("org.eclipse.core.resources.IWorkspaceRoot", "org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot()")
		.addConfiguredBinding(
						"BuilderPreferenceStoreInitializer",
						"binder.bind(org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer.class)" +
						".annotatedWith(com.google.inject.name.Names.named(\"builderPreferenceInitializer\"))" +
						".to(org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess.Initializer.class)")
		.getBindings();
	}
	
	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		if (isGenerateStub(grammar) || isGenerateJavaMain(grammar))
			return new String[] { Strings.skipLastToken(getGeneratorName(grammar, getNaming()), ".") };
		else 
			return new String[0];
	}
}
