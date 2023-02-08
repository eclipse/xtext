/**
 * Copyright (c) 2019, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.fowlerdsl.ui.wizard;

import com.google.inject.Inject;
import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;
import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider;

/**
 * Create a list with all project templates to be shown in the template new project wizard.
 * 
 * Each template is able to generate one or more projects. Each project can be configured such that any number of files are included.
 * 
 * @author miklossy - Initial contribution and API
 */
@SuppressWarnings("all")
public class StatemachineProjectTemplateProvider implements IProjectTemplateProvider {
  @Inject
  private MrsGrantsSecretCompartmentsProject project;

  @Override
  public AbstractProjectTemplate[] getProjectTemplates() {
    return new AbstractProjectTemplate[] { this.project };
  }
}
