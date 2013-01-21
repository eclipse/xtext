/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.linking;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.tests.linking.JvmModelBasedLinkingTest;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseWithLogicalContainerInjectorProvider;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseWithLogicalContainerInjectorProvider.class)
@SuppressWarnings("all")
public class JvmModelBasedLinkingTest2 extends JvmModelBasedLinkingTest {
}
