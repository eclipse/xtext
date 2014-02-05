/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.xtext.common.types.tests.ClasspathBasedModule;

import com.google.inject.Module;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ClasspathFeatureOverridesServiceTest extends AbstractFeatureOverridesServiceTest {

	@Override
	protected Module getModule() {
		return new ClasspathBasedModule();
	}
}
