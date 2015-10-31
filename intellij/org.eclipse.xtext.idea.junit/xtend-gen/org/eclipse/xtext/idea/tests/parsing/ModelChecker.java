/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.tests.parsing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;

@SuppressWarnings("all")
public interface ModelChecker {
  public abstract XtextResource checkResource(final String code, final boolean validate);
  
  public abstract <T extends EObject> T checkModel(final String code, final boolean validate);
  
  public abstract <T extends EObject> T checkModel(final String path, final String code, final boolean validate);
}
