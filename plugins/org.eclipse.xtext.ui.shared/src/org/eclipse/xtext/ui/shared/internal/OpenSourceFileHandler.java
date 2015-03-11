/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.generator.trace.OpenOppositeFileHandler;
import org.eclipse.xtext.ui.generator.trace.FileOpener;
import org.eclipse.xtext.ui.generator.trace.OppositeFileOpenerContributor;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class OpenSourceFileHandler extends OpenOppositeFileHandler {

	@Inject
	private ISharedStateContributionRegistry registry;

	@Override
	protected void collectOpeners(IEditorPart editor, IAcceptor<FileOpener> acceptor) {
		for (OppositeFileOpenerContributor collector : registry.getContributedInstances(OppositeFileOpenerContributor.class))
			collector.collectSourceFileOpeners(editor, acceptor);
	}
}
