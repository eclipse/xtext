/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.notification;

import java.util.List;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.collect.Lists;

/**
 * Builder for {@link NameBasedEObjectDescription named EObject descriptions.}
 * It supports the very narrow use case of the {@link DeltaConverter} which is
 * traversing another data structure and automatically concatenating simple names
 * based on the nesting level of the other data structure. 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
//TODO consider to index the simple name, too
class NameBasedEObjectDescriptionBuilder {

	private List<IEObjectDescription> exported;
	private final QualifiedName baseName;
	
	NameBasedEObjectDescriptionBuilder(QualifiedName baseName) {
		this(baseName, Lists.<IEObjectDescription>newArrayList());
	}

	List<IEObjectDescription> getExported() {
		return exported;
	}
	
	private NameBasedEObjectDescriptionBuilder(QualifiedName baseName, List<IEObjectDescription> exported) {
		this.exported = exported;
		this.baseName = baseName;
		exported.add(new NameBasedEObjectDescription(baseName));
	}

	public void accept(String simpleName) {
		QualifiedName next = baseName.append(simpleName);
		exported.add(new NameBasedEObjectDescription(next));
	}

	public NameBasedEObjectDescriptionBuilder nest(String simpleName) {
		QualifiedName next = baseName.append(simpleName);
		return new NameBasedEObjectDescriptionBuilder(next, exported);
	}
	
	public NameBasedEObjectDescriptionBuilder nestType(String simpleName) {
		String newLastSegment = baseName.getLastSegment() + "$" + simpleName;
		QualifiedName next = baseName.skipLast(1).append(newLastSegment);
		return new NameBasedEObjectDescriptionBuilder(next, exported);
	}
}
