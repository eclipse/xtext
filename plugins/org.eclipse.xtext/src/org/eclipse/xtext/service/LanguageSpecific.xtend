/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service

import com.google.inject.BindingAnnotation
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * An annotation marking a binding as language specific in contrast to a global service.
 * 
 * @since 2.9
 * @author kosyakov - Initial contribution and API
 */
@Retention(RetentionPolicy.RUNTIME)
@BindingAnnotation
annotation LanguageSpecific {
	
}