/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.refactoring

import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Data

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@Data
class RenameChange {
	String newName
	URI targetURI
}