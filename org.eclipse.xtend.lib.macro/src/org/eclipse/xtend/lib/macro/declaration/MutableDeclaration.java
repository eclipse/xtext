/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface MutableDeclaration extends MutableAnnotationTarget, Declaration {

	/**
	 * Indicate that this declaration is being read locally by some synthetically generated member. It effectively suppresses
	 * unused warnings.
	 * @since 2.6
	 */
	void markAsRead();
}
