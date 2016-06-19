/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.internal.GenericFormatterTestRequest;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class FormatterTesterWithImpl extends FormatterTestHelper {
  @Override
  protected IFormatter2 createFormatter(final FormatterTestRequest req) {
    return ((GenericFormatterTestRequest) req).getFormatter();
  }
}
