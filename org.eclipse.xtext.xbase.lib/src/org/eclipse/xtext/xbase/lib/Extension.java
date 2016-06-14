/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

/**
 * Marks a field, parameter or local variable as extension provider.
 * 
 * Annotated extension fields are inherited if their visibility is set
 * accordingly.
 *  
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @since 2.4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({
    ElementType.FIELD,
    ElementType.PARAMETER,
    ElementType.LOCAL_VARIABLE
})
@Documented
@Beta
@GwtCompatible public @interface Extension {

}
