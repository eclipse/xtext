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

import java.util.List;
import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment;
import org.eclipse.xtext.util.Strings;

/**
 * An {@link IGeneratorFragment} to create a formatter for an Xtext language.
 *
 * @author Sven Efftinge - Initial contribution and API
 */
public class GeneratorFragment extends AbstractGeneratorFragment {
	
	private boolean generateMwe = false;
	private boolean generateJavaMain = false;
	private boolean generatorStub = true;
	
	public void setGeneratorStub(boolean generatorStub) {
		this.generatorStub = generatorStub;
	}
	
	public void setGenerateJavaMain(boolean generateJavaMain) {
		this.generateJavaMain = generateJavaMain;
	}
	
	public void setGenerateMwe(boolean generateMwe) {
		this.generateMwe = generateMwe;
	}
	
	public boolean isGenerateStub(Grammar grammar) {
		if (XbaseGeneratorFragment.doesUseXbase(grammar)) {
			return false;
		}
		return generatorStub;
	}
	
	public boolean isGenerateJavaMain(Grammar grammar) {
		if (XbaseGeneratorFragment.doesUseXbase(grammar)) {
			return false;
		}
		return generateJavaMain;
	}
	
	public boolean isGenerateMwe(Grammar grammar) {
		if (XbaseGeneratorFragment.doesUseXbase(grammar)) {
			return false;
		}
		return generateMwe;
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return newArrayList((Object)isGenerateStub(grammar), (Object)isGenerateMwe(grammar), (Object)isGenerateJavaMain(grammar));
	}
	
	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory().addTypeToType(IGenerator.class.getName(), getGeneratorName(grammar, getNaming())).getBindings();
	}

	@Override
	public String[] getImportedPackagesRt(Grammar grammar) {
		if (isGenerateStub(grammar))
			return new String[] {
					"org.eclipse.xtext.xbase.lib",
					"org.eclipse.xtext.xtend2.lib"
			};
		return Strings.EMPTY_ARRAY;
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
