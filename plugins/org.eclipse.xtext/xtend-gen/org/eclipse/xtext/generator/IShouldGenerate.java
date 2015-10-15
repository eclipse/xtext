/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator;

import com.google.common.annotations.Beta;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
@Beta
@ImplementedBy(IShouldGenerate.OnlyWithoutErrors.class)
@SuppressWarnings("all")
public interface IShouldGenerate {
  @Beta
  public static class OnlyWithoutErrors implements IShouldGenerate {
    @Inject
    private IResourceValidator resourceValidator;
    
    @Override
    public boolean shouldGenerate(final Resource resource, final String projectName, final CancelIndicator cancelIndicator) {
      List<Issue> _validate = this.resourceValidator.validate(resource, CheckMode.NORMAL_AND_FAST, cancelIndicator);
      return _validate.isEmpty();
    }
  }
  
  @Beta
  public static class Always implements IShouldGenerate {
    @Override
    public boolean shouldGenerate(final Resource resource, final String projectName, final CancelIndicator cancelIndicator) {
      return true;
    }
  }
  
  /**
   * whether code should be generated for this resource.
   * 
   * @param projectName the name of the currently built project. May be null which indicates that the given resource
   * 	is located in the source tree of the currently built project.
   */
  public abstract boolean shouldGenerate(final Resource resource, final String projectName, final CancelIndicator cancelIndicator);
}
