/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.common.types.util.JvmVisibilityServiceTest;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;
import org.eclipse.xtext.xbase.typesystem.legacy.LegacyVisibilityService;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
@RunWith(XtextRunner.class)
@InjectWith(XbaseInjectorProvider.class)
public class LegacyVisibilityServiceTest extends JvmVisibilityServiceTest {

	@Inject
	private LegacyVisibilityService visibilityService;
	
	@Override
	protected LegacyVisibilityService createVisibilityService() {
		assertNotNull(visibilityService);
		return visibilityService;
	}
	
}
