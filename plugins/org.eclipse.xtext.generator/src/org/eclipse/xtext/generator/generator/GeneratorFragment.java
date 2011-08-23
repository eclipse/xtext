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
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return newArrayList((Object)generatorStub, (Object)generateMwe, (Object)generateJavaMain);
	}
	
	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory().addTypeToType(IGenerator.class.getName(), getGeneratorName(grammar, getNaming())).getBindings();
	}

	@Override
	public String[] getImportedPackagesRt(Grammar grammar) {
		return new String[] {
				"org.eclipse.xtext.xbase.lib",
				"org.eclipse.xtext.xtend2.lib"
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
		.getBindings();
	}
}
