/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.parser.fragments;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.fragments.AbstractFragmentsTest;
import org.eclipse.xtext.parser.fragments.FragmentsEagerLinkingInjectorProvider;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FragmentsEagerLinkingInjectorProvider.class)
@SuppressWarnings("all")
public class FragmentEagerLinkingTest extends AbstractFragmentsTest {
}
