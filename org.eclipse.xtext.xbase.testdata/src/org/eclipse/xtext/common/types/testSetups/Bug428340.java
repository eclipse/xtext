/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@org.eclipse.xtext.common.types.testSetups.Bug428340.MyAnnotation(emptyArray = {})
public class Bug428340 {
	
	@Retention(RetentionPolicy.RUNTIME)
	public @interface MyAnnotation {
		String[] emptyArray() default {""};
	}
	
}
