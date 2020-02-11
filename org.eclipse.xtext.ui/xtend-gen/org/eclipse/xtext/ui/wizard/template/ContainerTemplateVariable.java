/**
 * Copyright (c) 2017, 2019 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.wizard.template.TemplateVariable;

@SuppressWarnings("all")
public abstract class ContainerTemplateVariable extends TemplateVariable {
  public ContainerTemplateVariable(final String label, final String description, final ContainerTemplateVariable container) {
    super(label, description, container);
  }
  
  @Override
  public abstract Composite getWidget();
}
