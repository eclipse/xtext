/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.execution;

import com.intellij.execution.filters.ExceptionFilterFactory;
import com.intellij.execution.filters.Filter;
import com.intellij.psi.search.GlobalSearchScope;
import org.eclipse.xtext.idea.execution.TraceBasedExceptionFilter;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class TraceBasedExceptionFilterFactory implements ExceptionFilterFactory {
  @Override
  public Filter create(final GlobalSearchScope searchScope) {
    return new TraceBasedExceptionFilter(searchScope);
  }
}
