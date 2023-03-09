/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.formatting2;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.formatting2.FormatterPreferenceValuesProvider;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public class Formatter2Fragment extends Xtend2GeneratorFragment {
	private FormatterStubGenerator stubGenerator;

	@Inject
	public void init(FormatterStubGenerator.Service stubGeneratorService, Grammar grammar) {
		this.stubGenerator = stubGeneratorService.createGenerator(grammar);
	}

	public String cls(Class<?> clazz) {
		return clazz.getName() + ".class";
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		StringBuilder cfg = new StringBuilder();
		cfg.append("binder.bind(");
		cfg.append(IPreferenceValuesProvider.class.getName());
		cfg.append(".class)");
		cfg.append(".annotatedWith(");
		cfg.append(FormatterPreferences.class.getName());
		cfg.append(".class)");
		cfg.append(".to(");
		cfg.append(FormatterPreferenceValuesProvider.class.getName());
		cfg.append(".class);");
		BindFactory bf = new BindFactory();
		bf.addTypeToType(IFormatter2.class.getName(), stubGenerator.getStubQualifiedName());
		bf.addConfiguredBinding(FormatterPreferences.class.getName(), cfg.toString());
		return bf.getBindings();
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		BindFactory bf = new BindFactory();
		bf.addTypeToType("org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory",
				"org.eclipse.xtext.ui.editor.formatting2.ContentFormatterFactory");
		return bf.getBindings();
	}

	@Override
	public void generate(Xtend2ExecutionContext ctx) {
		ctx.writeFile(Generator.SRC, this.stubGenerator.getStubFileName(), stubGenerator.generateStubFileContents());
	}
}
