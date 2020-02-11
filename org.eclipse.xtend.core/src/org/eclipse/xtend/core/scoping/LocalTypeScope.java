/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class LocalTypeScope extends KnownTypesScope {

	public LocalTypeScope(List<? extends JvmType> localTypes, AbstractScope parent) {
		super(localTypes, parent);
	}

	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		IEObjectDescription element = getSingleElement(name);
		if (element == null)
			return Collections.emptyList();
		return Collections.singletonList(element);
	}
}
