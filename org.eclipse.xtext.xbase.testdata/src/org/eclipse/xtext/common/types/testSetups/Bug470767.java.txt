/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
public class Bug470767 {
	
	@Retention(RetentionPolicy.SOURCE)
    private @interface RemoveMe {}
	protected @interface KeepMe {}
	public void paramIsAnnotated(@RemoveMe int gravity) {}

}
