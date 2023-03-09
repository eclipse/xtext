/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IUnresolvedTypeResolver {

	void resolve(TypeUsages usages, XtextResource resource);
}
