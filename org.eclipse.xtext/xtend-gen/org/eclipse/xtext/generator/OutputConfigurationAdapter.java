/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator;

import com.google.common.base.Objects;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @noreference
 */
@Data
@SuppressWarnings("all")
public class OutputConfigurationAdapter extends AdapterImpl {
  private final Map<String, Set<OutputConfiguration>> outputConfigurationsPerLanguage;
  
  @Override
  public boolean isAdapterForType(final Object type) {
    return Objects.equal(type, OutputConfigurationAdapter.class);
  }
  
  public OutputConfigurationAdapter(final Map<String, Set<OutputConfiguration>> outputConfigurationsPerLanguage) {
    super();
    this.outputConfigurationsPerLanguage = outputConfigurationsPerLanguage;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.outputConfigurationsPerLanguage== null) ? 0 : this.outputConfigurationsPerLanguage.hashCode());
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OutputConfigurationAdapter other = (OutputConfigurationAdapter) obj;
    if (this.outputConfigurationsPerLanguage == null) {
      if (other.outputConfigurationsPerLanguage != null)
        return false;
    } else if (!this.outputConfigurationsPerLanguage.equals(other.outputConfigurationsPerLanguage))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    return new ToStringBuilder(this)
    	.addAllFields()
    	.toString();
  }
  
  @Pure
  public Map<String, Set<OutputConfiguration>> getOutputConfigurationsPerLanguage() {
    return this.outputConfigurationsPerLanguage;
  }
}
