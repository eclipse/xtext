/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;

import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.xtext.common.types.ui.refactoring.JvmRenameRefactoringProvider;
import org.eclipse.xtext.common.types.ui.refactoring.participant.TextChangeCombiner;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelJdtRenameParticipantContext;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class CombinedJvmJdtRenameRefactoringProvider extends JvmRenameRefactoringProvider {

	@Inject
	private Provider<CombinedJvmJdtRenameProcessor> combinedRenameProcessorProvider;

	@Inject
	private Provider<JdtRenameRefactoringParticipantProcessor> jdtRenameParticipantProcessorProvider;

	@Inject
	private TextChangeCombiner textChangeCombiner;
	
	@Override
	public ProcessorBasedRefactoring getRenameRefactoring(IRenameElementContext renameElementContext) {
		if (renameElementContext instanceof CombinedJvmJdtRenameContext) {
			RenameProcessor renameProcessor = getRenameProcessor(renameElementContext);
			if (renameProcessor != null) {
				return createChangeCombiningRefactoring(renameProcessor);
			}
			return null;
		}
		return super.getRenameRefactoring(renameElementContext);
	}

	@Override
	public RenameProcessor getRenameProcessor(IRenameElementContext renameElementContext) {
		RenameElementProcessor processor = null;
		if (renameElementContext instanceof JvmModelJdtRenameParticipantContext)
			processor = jdtRenameParticipantProcessorProvider.get();
		else if (renameElementContext instanceof CombinedJvmJdtRenameContext)
			processor = combinedRenameProcessorProvider.get();
		if (processor != null) {
			if (processor.initialize(renameElementContext))
				return processor;
			else
				return null;
		}
		return super.getRenameProcessor(renameElementContext);
	}
	
	protected ProcessorBasedRefactoring createChangeCombiningRefactoring(RenameProcessor renameProcessor) {
		return new ChangeCombiningRenameRefactoring(renameProcessor, textChangeCombiner);
	}
}
