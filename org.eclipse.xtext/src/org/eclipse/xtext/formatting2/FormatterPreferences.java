/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.eclipse.xtext.preferences.IPreferenceValuesProvider;

import com.google.inject.BindingAnnotation;

/**
 * <p>Marks an instance of {@link IPreferenceValuesProvider} as the one that should be used by the formatter.</p>
 * 
 * <p>A {@link BindingAnnotation marker annotation} for Google Guice.</p>
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FormatterPreferences {
}
