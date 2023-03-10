/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IJdtTypeProvider extends IJvmTypeProvider {

	TypeURIHelper getTypeUriHelper();

	IJavaProject getJavaProject();

}
