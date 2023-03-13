/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.resource;

import java.util.Collections;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.resource.XbaseResourceDescription;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

public class XtendResourceDescription extends XbaseResourceDescription {
	public XtendResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy, IResourceScopeCache cache,
			IBatchTypeResolver typeResolver, IQualifiedNameConverter nameConverter) {
		super(resource, strategy, cache, typeResolver, nameConverter);
	}

	@Override
	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return Collections.emptyList();
	}
}
