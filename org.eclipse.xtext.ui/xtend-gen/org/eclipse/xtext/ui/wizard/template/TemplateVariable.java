/**
 * Copyright (c) 2017, 2019 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.wizard.template;

import com.google.common.annotations.Beta;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ui.wizard.template.ContainerTemplateVariable;
import org.eclipse.xtext.ui.wizard.template.ParameterComposite;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Part of a template the variable defines the UI for the user to configure the generated files.
 * A variable will be associated with a widget to represent it inside the UI.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
@Beta
@SuppressWarnings("all")
public abstract class TemplateVariable {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final String label;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final String description;
  
  @Accessors
  private boolean enabled;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private ContainerTemplateVariable container;
  
  TemplateVariable(final String label, final String description, final ContainerTemplateVariable container) {
    this.label = label;
    this.description = description;
    this.enabled = true;
    this.container = container;
  }
  
  /**
   * Subclasses should override and create a widget representing the variable in UI. A reference to the widget should
   * be maintained.
   */
  public abstract void createWidget(final ParameterComposite parameterComposite, final Composite parent);
  
  /**
   * Subclasses should override to refresh the UI widget with data set to the variable in the meantime.
   */
  public abstract void refresh();
  
  public abstract Control getWidget();
  
  public boolean isLabeled() {
    return true;
  }
  
  @Pure
  public String getLabel() {
    return this.label;
  }
  
  @Pure
  public String getDescription() {
    return this.description;
  }
  
  @Pure
  public boolean isEnabled() {
    return this.enabled;
  }
  
  public void setEnabled(final boolean enabled) {
    this.enabled = enabled;
  }
  
  @Pure
  public ContainerTemplateVariable getContainer() {
    return this.container;
  }
}
