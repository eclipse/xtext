/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.wizard.template.ProjectVariable;

@SuppressWarnings("all")
public abstract class ContainerProjectVariable extends ProjectVariable {
  public ContainerProjectVariable(final String label, final String description, final ContainerProjectVariable container) {
    super(label, description, container);
  }
  
  @Override
  public abstract Composite getWidget();
}
