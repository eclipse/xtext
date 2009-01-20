/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.List;

/**
 * Interface for a method/function call. Used to provide alternative
 * implementations in Java or Xtend.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface IInvocationHandler<T> {
	T invoke(String functionName, List<Class<?>> parameterTypes, List<?> parameterValues);
}
