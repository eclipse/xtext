/**
 * Copyright (c) 2019, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.fowlerdsl.ui.wizard;

import org.eclipse.xtext.ui.wizard.template.AbstractFileTemplate;
import org.eclipse.xtext.ui.wizard.template.IFileTemplateProvider;

/**
 * Create a list with all file templates to be shown in the template new file wizard.
 * 
 * Each template is able to generate one or more files.
 * 
 * @author miklossy - Initial contribution and API
 */
@SuppressWarnings("all")
public class StatemachineFileTemplateProvider implements IFileTemplateProvider {
  @Override
  public AbstractFileTemplate[] getFileTemplates() {
    EmptyFile _emptyFile = new EmptyFile();
    MrsGrantsSecretCompartmentsFile _mrsGrantsSecretCompartmentsFile = new MrsGrantsSecretCompartmentsFile();
    return new AbstractFileTemplate[] { _emptyFile, _mrsGrantsSecretCompartmentsFile };
  }
}
