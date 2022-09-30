/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.acme;

import java.io.Serializable;
import java.util.function.Supplier;

public class LoonyToon implements Supplier<Serializable> {

	@Override
	public Serializable get() {
		return null;
	}
	
	public void singSomeSong() {}
	
}
