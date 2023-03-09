/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.internal;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation is <b>not</b> intended to be used to do <b>null analysis</b>.
 * The only purpose is to allow Google Guice to inject <code>@Inject(optional=true)</code> places with <code>null</code> instances.
 * 
 * @author Christian Dietrich - Initial contribution and API
 * 
 * @since 2.12
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Nullable {
	
}
