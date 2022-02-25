/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.tokens;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.google.inject.BindingAnnotation;

/**
 * Indicates that a scope provider is requested that is used
 * to serialize existing cross references.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface SerializerScopeProviderBinding {}