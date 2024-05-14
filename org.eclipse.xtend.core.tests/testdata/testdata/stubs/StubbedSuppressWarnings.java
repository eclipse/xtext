/*******************************************************************************
 * Copyright (c) 2024 Lorenzo Bettini and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata.stubs;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A stub type to use instead of relying on Java API {@link SuppressWarnings}, which, in Java 21 has lost the
 * {@link java.lang.annotation.Target} specification.
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 */
@Target({ TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE })
@Retention(RetentionPolicy.SOURCE)
public @interface StubbedSuppressWarnings {
	String[] value();
}
