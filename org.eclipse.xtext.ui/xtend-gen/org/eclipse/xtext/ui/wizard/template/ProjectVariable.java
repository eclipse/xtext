/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ui.wizard.template.IParameterPage;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Part of a project template the variable defines the UI for the user to configure the generated files.
 * A variable will be associated with a widget to represent it inside the UI.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
@SuppressWarnings("all")
public abstract class ProjectVariable {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final String label;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final String description;
  
  @Accessors
  private boolean enabled;
  
  ProjectVariable(final String label, final String description) {
    this.label = label;
    this.description = description;
    this.enabled = true;
  }
  
  /**
   * Subclasses should override and create a widget representing the variable in UI. A reference to the widget should
   * be maintained.
   */
  public abstract void createWidget(final IParameterPage parameterPage);
  
  /**
   * Subclasses should override to refresh the UI widget with data set to the variable in the meantime.
   */
  public abstract void refresh();
  
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
}
