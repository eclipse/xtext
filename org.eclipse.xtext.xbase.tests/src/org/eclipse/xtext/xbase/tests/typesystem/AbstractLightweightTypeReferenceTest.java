/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractLightweightTypeReferenceTest extends AbstractXbaseTestCase {
	@Inject
	private CommonTypeComputationServices services;

	@Inject
	private XtextResourceSet resourceSet;

	protected ITypeReferenceOwner getOwner() {
		return new StandardTypeReferenceOwner(services, resourceSet);
	}

	protected LightweightTypeReference typeRef(Class<?> type) {
		return getOwner().toLightweightTypeReference(type(type));
	}

	protected JvmType type(Class<?> type) {
		return services.getTypeReferences().findDeclaredType(type, resourceSet);
	}
}
