/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.xbase;

import static java.util.Collections.*;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.xbase.XbaseUtil;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XbaseUiFragment extends AbstractGeneratorFragment {

	public static String getRenameStrategyName(Grammar grammar, Naming naming) {
		return naming.basePackageUi(grammar) + ".refactoring." + GrammarUtil.getName(grammar) + "RenameStrategy";
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		if (!XbaseUtil.usesXbaseGrammar(grammar))
			return emptySet();
		return new BindFactory()
				.addTypeToType("org.eclipse.xtext.ui.editor.findrefs.FindReferenceQueryDataFactory",
						"org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelFindReferenceQueryDataFactory")

				// rename refactoring
				.addTypeToType("org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelDependentElementsCalculator")
				.addTypeToType("org.eclipse.xtext.ui.refactoring.impl.RefactoringReferenceQueryDataFactory",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelFindRefsQueryDataFactory")
				.addTypeToType("org.eclipse.xtext.ui.refactoring.IReferenceUpdater",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelReferenceUpdater")
				.addTypeToType("org.eclipse.xtext.ui.refactoring.IRenameStrategy.Provider",
						getRenameStrategyName(grammar, getNaming())+".Provider").getBindings();
	}
}
