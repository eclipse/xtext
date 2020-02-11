/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import java.util.List;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.generator.trace.FileOpener;
import org.eclipse.xtext.ui.generator.trace.OppositeFileOpenerContributor;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class OpenSourceFilePropertyTester extends PropertyTester {

	private static class ExceptionThrowingOpenerAcceptor implements IAcceptor<FileOpener> {
		@Override
		public void accept(FileOpener t) {
			throw new SourceFileFound();
		}
	}

	@SuppressWarnings("serial")
	private static class SourceFileFound extends RuntimeException {
	}

	private List<? extends OppositeFileOpenerContributor> oppositeFileOpenerContributors;

	protected boolean canOpenSourceFile(IEditorPart editorPart) {
		IAcceptor<FileOpener> acceptor = new ExceptionThrowingOpenerAcceptor();
		try {
			for (OppositeFileOpenerContributor collector : oppositeFileOpenerContributors)
				collector.collectSourceFileOpeners(editorPart, acceptor);
			return false;
		} catch (SourceFileFound e) {
			return true;
		}
	}

	@Inject
	protected void initialize(ISharedStateContributionRegistry registry) {
		oppositeFileOpenerContributors = registry.getContributedInstances(OppositeFileOpenerContributor.class);
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof IEditorPart) {
			if ("canOpenSourceFile".equals(property))
				return canOpenSourceFile((IEditorPart) receiver);
		}
		return false;
	}

}
