/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.refactoring;

import static java.util.Collections.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RefactorElementNameFragment extends AbstractGeneratorFragment {

	private boolean useJdtRefactoring = false;

	public void setUseJdtRefactoring(boolean useInferredJvmModel) {
		this.useJdtRefactoring = useInferredJvmModel;
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		if (!useJdtRefactoring)
			return emptySet();
		return new BindFactory()
				.addTypeToType("org.eclipse.xtext.ui.refactoring.ui.RenameElementHandler",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.JvmRenameElementHandler")
				.addTypeToType("org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.JvmRenameRefactoringProvider")
				.addTypeToType("org.eclipse.xtext.ui.refactoring.IRenameProcessorAdapter$Factory",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.JavaRenameProcessorAdapter.Factory")
				.addTypeToType("org.eclipse.xtext.ui.refactoring.ui.IRenameSupport.Factory",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.JdtAwareRenameSupportFactory")
				.addTypeToType("org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelRefactoringResourceSetProvider")
				.getBindings();
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Collections.<Object>singletonList(useJdtRefactoring);
	}
}
