/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.actions

import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.ide.actions.JavaCreateTemplateInPackageAction
import com.intellij.ide.fileTemplates.FileTemplate
import com.intellij.ide.fileTemplates.FileTemplateManager
import com.intellij.ide.fileTemplates.FileTemplateUtil
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import com.intellij.util.IncorrectOperationException
import java.util.Properties
import org.eclipse.xtend.core.idea.icons.XtendIcons
import org.eclipse.xtend.core.idea.lang.XtendFileType

/**
 * 
 */
class NewXtendFileAction extends JavaCreateTemplateInPackageAction<PsiElement> {

	new() {
		super("Xtend Type", "Create New Xtend Type", XtendIcons.Xtend_ICON, true);
	}

	override void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
		builder.setTitle("Xtend Type")
			.addKind("Class", XtendIcons.Xtend_CLASS, "Xtend Class")
			.addKind("Interface", XtendIcons.Xtend_INTERFACE, "Xtend Interface")
			.addKind("Enum", XtendIcons.Xtend_ENUM, "Xtend Enum")
			.addKind("Annotation Type", XtendIcons.Xtend_ANNOTATIONTYPE, "Xtend Annotation Type");
	}

	override protected String getActionName(PsiDirectory directory, String newName, String templateName) {
		return "Xtend Type";
	}

	override protected doCreate(PsiDirectory dir, String name, String templateName) throws IncorrectOperationException {
		var Project project = dir.getProject()
		var FileTemplate template = FileTemplateManager.getInstance(project).getInternalTemplate(templateName)
		var Properties defaultProperties = FileTemplateManager.getInstance(project).getDefaultProperties()
		var Properties properties = new Properties(defaultProperties)
		properties.setProperty(FileTemplate.ATTRIBUTE_NAME, name)
		var String fileName = name+'.'+XtendFileType.INSTANCE.defaultExtension
		var PsiElement element
		try {
			element = FileTemplateUtil.createFromTemplate(template, fileName, properties, dir)
		} catch (IncorrectOperationException e) {
			throw e
		} catch (Exception e) {
			LOG.error(e)
			return null
		}
		if(element === null) return null
		return element;
	}

	override protected getNavigationElement(PsiElement createdElement) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}