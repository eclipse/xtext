/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public interface ITypeArgumentContext {
	
	JvmTypeReference getBoundArgument(JvmTypeParameter parameter);
	
	JvmTypeReference getLowerBound(JvmTypeReference reference);
	
	JvmTypeReference getUpperBound(JvmTypeReference element, Notifier context);
	
	JvmTypeReference resolve(JvmTypeReference reference);
	
	boolean isRawTypeContext();
}
