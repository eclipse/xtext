/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.actions;

import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.ide.actions.CreateFromTemplateAction;
import com.intellij.ide.actions.JavaCreateTemplateInPackageAction;
import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.ide.fileTemplates.FileTemplateUtil;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import java.util.Properties;
import org.eclipse.xtend.core.idea.icons.XtendIcons;
import org.eclipse.xtend.core.idea.lang.XtendFileType;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class NewXtendFileAction extends JavaCreateTemplateInPackageAction<PsiElement> {
  public NewXtendFileAction() {
    super("Xtend Type", "Create New Xtend Type", XtendIcons.Xtend_ICON, true);
  }
  
  @Override
  public void buildDialog(final Project project, final PsiDirectory directory, final CreateFileFromTemplateDialog.Builder builder) {
    CreateFileFromTemplateDialog.Builder _setTitle = builder.setTitle("Xtend Type");
    CreateFileFromTemplateDialog.Builder _addKind = _setTitle.addKind("Class", XtendIcons.Xtend_CLASS, "Xtend Class");
    CreateFileFromTemplateDialog.Builder _addKind_1 = _addKind.addKind("Interface", XtendIcons.Xtend_INTERFACE, "Xtend Interface");
    CreateFileFromTemplateDialog.Builder _addKind_2 = _addKind_1.addKind("Enum", XtendIcons.Xtend_ENUM, "Xtend Enum");
    _addKind_2.addKind("Annotation Type", XtendIcons.Xtend_ANNOTATIONTYPE, "Xtend Annotation Type");
  }
  
  @Override
  protected String getActionName(final PsiDirectory directory, final String newName, final String templateName) {
    return "Xtend Type";
  }
  
  @Override
  protected PsiElement doCreate(final PsiDirectory dir, final String name, final String templateName) throws IncorrectOperationException {
    Project project = dir.getProject();
    FileTemplateManager _instance = FileTemplateManager.getInstance(project);
    FileTemplate template = _instance.getInternalTemplate(templateName);
    FileTemplateManager _instance_1 = FileTemplateManager.getInstance(project);
    Properties defaultProperties = _instance_1.getDefaultProperties();
    Properties properties = new Properties(defaultProperties);
    properties.setProperty(FileTemplate.ATTRIBUTE_NAME, name);
    String _defaultExtension = XtendFileType.INSTANCE.getDefaultExtension();
    String fileName = ((name + ".") + _defaultExtension);
    PsiElement element = null;
    try {
      PsiElement _createFromTemplate = FileTemplateUtil.createFromTemplate(template, fileName, properties, dir);
      element = _createFromTemplate;
    } catch (final Throwable _t) {
      if (_t instanceof IncorrectOperationException) {
        final IncorrectOperationException e = (IncorrectOperationException)_t;
        throw e;
      } else if (_t instanceof Exception) {
        final Exception e_1 = (Exception)_t;
        CreateFromTemplateAction.LOG.error(e_1);
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    if ((element == null)) {
      return null;
    }
    return element;
  }
  
  @Override
  protected PsiElement getNavigationElement(final PsiElement createdElement) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
