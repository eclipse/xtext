/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.refactoring;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Deprecated
public class RefactorElementNameFragment extends AbstractGeneratorFragment {

	// no default (depends on whther xbase is used or not)
	private Boolean useJdtRefactoring = null;

	public void setUseJdtRefactoring(boolean useInferredJvmModel) {
		this.useJdtRefactoring = useInferredJvmModel;
	}
	
	protected boolean isUseJdtRefactoring(Grammar grammar) {
		if (useJdtRefactoring == null) {
			return XbaseGeneratorFragment.doesUseXbase(grammar);
		} else {
			return useJdtRefactoring.booleanValue();
		}
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		BindFactory bindFactory = new BindFactory();
		bindFactory
			.addTypeToType("org.eclipse.xtext.ui.refactoring.IRenameStrategy", 
					"org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy")
			.addTypeToType("org.eclipse.xtext.ui.refactoring.IReferenceUpdater", 
					"org.eclipse.xtext.ui.refactoring.impl.DefaultReferenceUpdater")
		    .addConfiguredBinding("org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer",
					"binder.bind("
							+ "org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer.class"
							+ ").annotatedWith("
							+ "com.google.inject.name.Names.named(\"RefactoringPreferences\")"
							+ ").to(" 
							+ "org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences.Initializer.class)");
		if (isUseJdtRefactoring(grammar))
			return bindFactory
					.addTypeToType("org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory",
							"org.eclipse.xtext.common.types.ui.refactoring.JdtRefactoringContextFactory")
					.addTypeToType("org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider",
							"org.eclipse.xtext.common.types.ui.refactoring.JvmRenameRefactoringProvider")
					.addTypeToType("org.eclipse.xtext.ui.refactoring.ui.IRenameSupport.Factory",
							"org.eclipse.xtext.common.types.ui.refactoring.JdtRenameSupport.Factory")
					.addTypeToType("org.eclipse.xtext.ui.refactoring.IRenameStrategy.Provider",
							"org.eclipse.xtext.common.types.ui.refactoring.participant.JvmMemberRenameStrategy.Provider")
					.addConfiguredBinding(
							"org.eclipse.xtext.common.types.ui.refactoring.participant.JvmMemberRenameStrategy.Provider.Delegate",
							"binder.bind("
							+ "org.eclipse.xtext.ui.refactoring.IRenameStrategy.Provider.class"
							+ ").annotatedWith("
							+ "org.eclipse.xtext.common.types.ui.refactoring.participant.JvmMemberRenameStrategy.Provider.Delegate.class"
							+ ").to(" 
							+ "org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategyProvider.class)")
					.getBindings();
		else
			return bindFactory
					.addTypeToType("org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider",
							"org.eclipse.xtext.ui.refactoring.impl.DefaultRenameRefactoringProvider")
					.addTypeToType("org.eclipse.xtext.ui.refactoring.ui.IRenameSupport.Factory",
							"org.eclipse.xtext.ui.refactoring.ui.DefaultRenameSupport.Factory")
					.getBindings();
	}

}
