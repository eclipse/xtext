/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.List;

import org.eclipse.emf.common.util.URI;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.7
 * @noimplement
 * @noextend
 */
public interface IDirtyStateManagerExtension {

	List<URI> getDirtyResourceURIs();
}
