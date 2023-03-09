/*******************************************************************************
 * Copyright (c) 2020 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.impl.CaseInsensitivityHelper;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * <p>
 * Legacy case-sensitive, unique name validation context that ensures the exported names to be unique per resource.
 * </p>
 * <p>
 * This is used to detect specializations that require fallback to the behavior prior to Xtext 2.22.
 * </p>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated Can be replaced by direct usage of the {@link DefaultUniqueNameContext}.
 * @since 2.22
 */
@Deprecated
public class UniqueInResourceContext extends DefaultUniqueNameContext {

	public UniqueInResourceContext(IResourceDescription resourceDescription, CancelIndicator ci) {
		super(resourceDescription, resourceDescription, new CaseInsensitivityHelper(), ci);
	}

}
