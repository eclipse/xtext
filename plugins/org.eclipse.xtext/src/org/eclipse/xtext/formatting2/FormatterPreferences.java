/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.eclipse.xtext.preferences.IPreferenceValuesProvider;

import com.google.inject.BindingAnnotation;

/**
 * A marker annotation for Google Guice.
 * 
 * Marks an instance of {@link IPreferenceValuesProvider} as the one that sould be used by the formatter.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface FormatterPreferences {

}
