/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.formatting;

import static java.util.Collections.*;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.generator.AbstractStubGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.util.Strings;

/**
 * An {@link IGeneratorFragment} to create a formatter for an Xtext language.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public class FormatterFragment extends AbstractStubGeneratorFragment {
	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		if(isGenerateStub())
			return new BindFactory().addTypeToType(IFormatter.class.getName(), getFormatterName(grammar, getNaming()))
				.getBindings();
		else
			return emptySet();
	}

	public static String getFormatterName(Grammar grammar, Naming naming) {
		return naming.basePackageRuntime(grammar) + ".formatting." + GrammarUtil.getSimpleName(grammar) + "Formatter";
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		if(isGenerateStub())
			return new String[] { Strings.skipLastToken(getFormatterName(grammar, getNaming()), ".") };
		else
			return null;
	}
	
}
