/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.indentation;

import com.google.inject.Inject;
import org.eclipse.xtext.ide.editor.contentassist.CompletionPrefixProvider;
import org.eclipse.xtext.ide.tests.indentation.AbstractCompletePrefixProviderTest;
import org.eclipse.xtext.ide.tests.testlanguage.tests.IndentationAwareUiTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(IndentationAwareUiTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class CompletionPrefixProviderTest extends AbstractCompletePrefixProviderTest {
  @Inject
  private CompletionPrefixProvider testee;
  
  @Override
  public CompletionPrefixProvider getTestee() {
    return this.testee;
  }
}
