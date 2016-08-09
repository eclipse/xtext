/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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