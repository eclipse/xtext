/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.common.annotations.GwtCompatible;

/**
 * @author Sven Efftinge
 * 
 * Creates a getter and setter method for the annotated field.
 * Prepends the field name with an underscore (e.g. <code>_myField</code>)
 */
@GwtCompatible
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface Property {
	
}
