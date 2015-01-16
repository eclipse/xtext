/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.editor;

import org.eclipse.jdt.ui.PreferenceConstants;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class FoldingPreferences {
  public boolean isEnabled() {
    return (this.getBoolean(PreferenceConstants.EDITOR_FOLDING_ENABLED)).booleanValue();
  }
  
  public boolean isFoldImports() {
    return (this.getBoolean(PreferenceConstants.EDITOR_FOLDING_IMPORTS)).booleanValue();
  }
  
  public boolean isFoldHeader() {
    return (this.getBoolean(PreferenceConstants.EDITOR_FOLDING_HEADERS)).booleanValue();
  }
  
  public boolean isFoldInnerTypes() {
    return (this.getBoolean(PreferenceConstants.EDITOR_FOLDING_INNERTYPES)).booleanValue();
  }
  
  public boolean isFoldMethods() {
    return (this.getBoolean(PreferenceConstants.EDITOR_FOLDING_METHODS)).booleanValue();
  }
  
  public boolean isFoldComments() {
    return (this.getBoolean(PreferenceConstants.EDITOR_FOLDING_JAVADOC)).booleanValue();
  }
  
  protected Boolean getBoolean(final String string) {
    String _preference = PreferenceConstants.getPreference(string, null);
    return Boolean.valueOf(_preference);
  }
}
