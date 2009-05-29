/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project;

import org.eclipse.xtext.Messages;
import org.eclipse.xtext.ui.core.wizard.IProjectInfo;
import org.eclipse.xtext.ui.core.wizard.XtextNewProjectWizard;

/**
 * This is a project wizard used to help in the creation of new Xtext Projects.
 * The wizard contains one page with the following configurations options
 * <p>
 * wizard page asks for:
 * <ul>
 * <li>Main project name (default: org.xtext.example.MyDsl)</li>
 * <li>Qualified language name (default: org.xtext.example.MyDsl)</li>
 * <li>DSL-File extensions (comma separated) (default: dsl)</li>
 * <li>Namespace URI (for the EPackage to be generated)
 * (default:http://example.xtext.org/MyDsl)</li>
 * </ul>
 * </p>
 * <p>
 * In addition there is a checkbox "Create generator project" to indicate the
 * creation of a new 'generator' project which is activated by default. The
 * wizard than creates three to four plug-in projects:
 * <ul>
 * <li>main project name}</li>
 * <li>main project name}.ui</li>
 * <li>[{main project name}.generator] based on the checkbox state mentioned
 * above</li>
 * </ul>
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Dennis Huebner
 * @author Peter Friese
 */
public class NewXtextProjectWizard extends XtextNewProjectWizard {

	private NewXtextProjectWizardPage page;

	public NewXtextProjectWizard() {
		super();
		setWindowTitle(Messages.NewXtextProjectWizard_WindowTitle);
	}

	@Override
	public void addPages() {
		page = new NewXtextProjectWizardPage(selection);
		addPage(page);
	}

	@Override
	protected IProjectInfo getProjectInfo() {
		return page.getXtextProjectInfo();
	}

}