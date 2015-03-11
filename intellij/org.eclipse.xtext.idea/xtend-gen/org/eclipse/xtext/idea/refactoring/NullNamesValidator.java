/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.refactoring;

import com.google.common.base.Objects;
import com.intellij.lang.refactoring.NamesValidator;
import com.intellij.openapi.project.Project;

@SuppressWarnings("all")
public class NullNamesValidator implements NamesValidator {
  @Override
  public boolean isIdentifier(final String name, final Project project) {
    return (!Objects.equal(name, null));
  }
  
  @Override
  public boolean isKeyword(final String name, final Project project) {
    return false;
  }
}
