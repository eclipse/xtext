/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testing.tests;

import static org.junit.Assert.assertNotNull;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Test for {@link InjectionExtension}.
 * Copied from {@link XtextRunnerTest}.
 * 
 * @author Karsten Thoms - Initial contribution and API
 */
@InjectWith(InjectionExtensionTest.MyInjectorProvider.class)
@ExtendWith(InjectionExtension.class)
public class InjectionExtensionTest extends AbstractJUnitIntegrationTest {
	@Inject Injector injector;
	
	@BeforeEach
	public void setUp () {
		assertNotNull(injector);
	}
}
