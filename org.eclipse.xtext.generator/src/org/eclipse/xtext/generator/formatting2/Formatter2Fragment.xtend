/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.formatting2

import com.google.inject.Inject
import java.util.Set
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.formatting2.IFormatter2
import org.eclipse.xtext.generator.BindFactory
import org.eclipse.xtext.generator.Binding
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment
import org.eclipse.xtext.preferences.IPreferenceValuesProvider
import org.eclipse.xtext.formatting2.FormatterPreferences
import org.eclipse.xtext.formatting2.FormatterPreferenceValuesProvider

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated
class Formatter2Fragment extends Xtend2GeneratorFragment {

	FormatterStubGenerator stubGenerator

	@Inject
	def void init(FormatterStubGenerator.Service stubGeneratorService, Grammar grammar) {
		this.stubGenerator = stubGeneratorService.createGenerator(grammar)
	}

	def String cls(Class<?> clazz) {
		clazz.name + ".class"
	}

	override Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		val cfg = new StringBuilder
		cfg.append('''binder.bind(«IPreferenceValuesProvider.name».class)''')
		cfg.append('''.annotatedWith(«FormatterPreferences.name».class)''')
		cfg.append('''.to(«FormatterPreferenceValuesProvider.name».class);''')
		val bf = new BindFactory();
		bf.addTypeToType(IFormatter2.name, stubGenerator.stubQualifiedName);
		bf.addConfiguredBinding(FormatterPreferences.name, cfg.toString)
		return bf.bindings;
	}

	override getGuiceBindingsUi(Grammar grammar) {
		val bf = new BindFactory();
		bf.addTypeToType(
			"org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory",
			"org.eclipse.xtext.ui.editor.formatting2.ContentFormatterFactory"
		)
		return bf.bindings
	}

	override generate(Xtend2ExecutionContext ctx) {
		ctx.writeFile(Generator.SRC, stubGenerator.stubFileName, stubGenerator.generateStubFileContents)
	}
}
