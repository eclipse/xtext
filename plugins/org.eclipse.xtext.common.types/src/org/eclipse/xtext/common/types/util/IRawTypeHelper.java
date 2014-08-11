/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated This class does not guard against recursive, broken type references, e.g. {@code T extends T}. Use the
 *             {@link RawTypeReferenceComputer} instead.
 */
@Deprecated
@ImplementedBy(RawTypeHelper.class)
public interface IRawTypeHelper {

	List<JvmType> getAllRawTypes(JvmTypeReference reference, Resource resource);

	JvmTypeReference getRawTypeReference(JvmTypeReference reference, Resource resource);

}
