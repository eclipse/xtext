/*******************************************************************************
 * Copyright (c) itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

public abstract class AbstractToStringConverter<T> extends AbstractNullSafeConverter<T> {

	public final String internalToString(T value) {
		return value.toString();
	}

}
