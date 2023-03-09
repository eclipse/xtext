/*******************************************************************************
 * Copyright (c) 2009, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.editor.contentassist;

import org.eclipse.xtext.ide.editor.contentassist.ProposalConflictHelper;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AntlrProposalConflictHelper;

import com.google.inject.Inject;

public class ProposalConflictHelperAntlrTest extends AbstractProposalConflictHelperTest {

	@Inject
	private AntlrProposalConflictHelper helper;

	@Override
	protected ProposalConflictHelper helper() {
		return helper;
	}

}
