/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
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
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface PrimitiveType extends Type {
	/**
	 * Returns the kind of primitive type that this object represents.
	 * 
	 * @return the kind of primitive type that this object represents
	 */
	Kind getKind();

	/**
	 * An enumeration of the different kinds of primitive types.
	 */
	enum Kind {
		/** The primitive type <tt>boolean</tt> */
		BOOLEAN,
		/** The primitive type <tt>byte</tt> */
		BYTE,
		/** The primitive type <tt>short</tt> */
		SHORT,
		/** The primitive type <tt>int</tt> */
		INT,
		/** The primitive type <tt>long</tt> */
		LONG,
		/** The primitive type <tt>char</tt> */
		CHAR,
		/** The primitive type <tt>float</tt> */
		FLOAT,
		/** The primitive type <tt>double</tt> */
		DOUBLE
	}
}