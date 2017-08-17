/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.refactoring

import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Data

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
interface XtextMoveStrategy {
	def void applyMove(XtextMoveArguments arguments, RefactoringIssueAcceptor issues)
}

@Data
class XtextMoveArguments {
	ResourceSet resourceSet
	// TODO pass error reporting facility
	List<ResourceMove> moves
}

@Data
class ResourceMove {
	URI oldURI
	URI newURI
}

