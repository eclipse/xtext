/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.impl.javasupport;

import org.eclipse.xtext.builder.impl.javasupport.AbstractCompilationUnitDelta;

/**
 * <p>
 * Intances of this delta type are used to commit unsubmitted deltas for the given compilation unit.
 * </p>
 */
@SuppressWarnings("all")
public class CommitResourceDescriptionDelta extends AbstractCompilationUnitDelta {
  public CommitResourceDescriptionDelta(final String compilationUnitName) {
    super(compilationUnitName);
  }
}
