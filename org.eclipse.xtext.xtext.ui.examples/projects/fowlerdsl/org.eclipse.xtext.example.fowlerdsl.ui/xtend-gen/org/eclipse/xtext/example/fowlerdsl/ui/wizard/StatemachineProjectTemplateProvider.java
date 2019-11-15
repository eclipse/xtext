/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.fowlerdsl.ui.wizard;

import org.eclipse.xtext.example.fowlerdsl.ui.wizard.MrsGrantsSecretCompartmentsProject;
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
  @Override
  public AbstractProjectTemplate[] getProjectTemplates() {
    MrsGrantsSecretCompartmentsProject _mrsGrantsSecretCompartmentsProject = new MrsGrantsSecretCompartmentsProject();
    return new AbstractProjectTemplate[] { _mrsGrantsSecretCompartmentsProject };
  }
}
