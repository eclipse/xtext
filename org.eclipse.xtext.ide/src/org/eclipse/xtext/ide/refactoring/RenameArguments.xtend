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
 * The arguments passed to a {@link XtextMoveResourceStrategy}.
 * 
 * In the resourceSet the refactoring is already applied, i.e. all 
 * moved resources already have the new URI.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@Data
class XtextMoveArguments {
	ResourceSet resourceSet
	List<ResourceURIChange> changes
}

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@Data
class XtextMoveFolderArguments extends XtextMoveArguments {
	List<ResourceURIChange> folderChanges
}

/**
 * URIs can also refer to folders and non-Xtext resources.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@Data
class ResourceURIChange {
	URI oldURI
	URI newURI
}

