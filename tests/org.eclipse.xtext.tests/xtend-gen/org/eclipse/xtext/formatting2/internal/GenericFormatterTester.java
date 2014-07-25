/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.internal;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.xtext.formatting2.internal.FormatterTesterWithImpl;
import org.eclipse.xtext.formatting2.internal.GenericFormatterTestRequest;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class GenericFormatterTester {
  @Inject
  private FormatterTesterWithImpl tester;
  
  @Inject
  private Provider<GenericFormatterTestRequest> requestProvider;
  
  public void assertFormatted(final Procedure1<? super GenericFormatterTestRequest> test) {
    final GenericFormatterTestRequest request = this.requestProvider.get();
    test.apply(request);
    this.tester.assertFormatted(request);
  }
}
