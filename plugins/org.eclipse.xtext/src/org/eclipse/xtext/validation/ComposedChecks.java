/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that allows to modularize the validator into multiple classes.
 * 
 * The listed validators should override the method {@link AbstractDeclarativeValidator#register(EValidatorRegistrar)}
 * with an empty implementation otherwise all issues will be reported twice.
 *  
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE})
public @interface ComposedChecks {

	Class<? extends AbstractDeclarativeValidator>[] validators();

}
