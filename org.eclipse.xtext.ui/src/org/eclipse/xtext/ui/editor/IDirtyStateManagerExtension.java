/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
