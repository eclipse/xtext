/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.validation;

import java.util.Map;
import org.eclipse.core.resources.IResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.ui.validation.ProjectAwareUniqueClassNameValidator;

@SuppressWarnings("all")
public class MockedProjectAwareUniqueClassNameValidator extends ProjectAwareUniqueClassNameValidator {
  private Map<Object, Object> context = CollectionLiterals.<Object, Object>newHashMap();
  
  @Override
  public Map<Object, Object> getContext() {
    return this.context;
  }
  
  @Override
  public boolean isDerived(final IResource resource) {
    return super.isDerived(resource);
  }
}
