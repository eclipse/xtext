/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.ecore2xtext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectInfo;
import org.eclipse.xtext.xtext.wizard.EPackageInfo;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Ecore2XtextGenerator extends AbstractWorkflowComponent2 {

	private static final Logger log = Logger.getLogger(Ecore2XtextGenerator.class);

	private ResourceSet resourceSet;

	private String genPath;

	private String rootElementClassName;

	private String languageName;

	private XtextProjectInfo xtextProjectInfo;

	public Ecore2XtextGenerator() {
		resourceSet = new XtextResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
	}

	public void addEcoreFile(String uri) {
		if (uri.startsWith("/")) {
			uri = uri.substring(1);
		}
		if (languageName == null) {
			languageName = uri.replaceAll("/", ".").substring(0, uri.lastIndexOf('.'));
		}
		resourceSet.getResource(URI.createURI("platform:/resource/org.eclipse.xtext.xtext.ui.tests/src/" + uri), true);
	}

	public void setGenPath(String genPath) {
		this.genPath = genPath;
	}

	public void setRootElement(String rootElementClassName) {
		this.rootElementClassName = rootElementClassName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	@Override
	protected void invokeInternal(final WorkflowContext ctx, ProgressMonitor monitor, final Issues issues) {
		createXtextProjectInfo(issues);
		CharSequence grammar = xtextProjectInfo.getRuntimeProject().grammar();
		try {
			Files.write(grammar, new File(genPath, xtextProjectInfo.getRuntimeProject().getGrammarFilePath()), Charsets.ISO_8859_1);
		} catch (IOException e) {
			String message = "Can't create grammar file";
			log.error(message, e);
			issues.addError(Ecore2XtextGenerator.this, message, this, e, null);
		}
	}

	private void createXtextProjectInfo(Issues issues) {
		if (xtextProjectInfo == null) {
			xtextProjectInfo = new XtextProjectInfo();
			List<EPackageInfo> ePackageInfos = new ArrayList<EPackageInfo>();
			EClass rootElementClass = null;
			for (Iterator<Notifier> i = resourceSet.getAllContents(); i.hasNext();) {
				Notifier next = i.next();
				if (next instanceof EPackage) {
					EPackage ePackage = (EPackage) next;
					ePackageInfos.add(new EPackageInfo(ePackage, URI.createURI(ePackage.getNsURI()), null, null, null));
					if (rootElementClass == null) {
						EClassifier rootElementClassifier = ePackage.getEClassifier(rootElementClassName);
						if (rootElementClassifier instanceof EClass) {
							rootElementClass = (EClass) rootElementClassifier;
						}
					}
				}
			}
			if (ePackageInfos.isEmpty()) {
				issues.addError("No EPackages found");
			} else {
				xtextProjectInfo.getEcore2Xtext().setDefaultEPackageInfo(ePackageInfos.get(0));
			}
			if (rootElementClass == null) {
				issues.addError("No rootElement EClass " + rootElementClassName + " found");
			}
			if (languageName == null) {
				issues.addError("languageName must be set");
			}
			xtextProjectInfo.getLanguage().setName(languageName);
			xtextProjectInfo.getEcore2Xtext().getEPackageInfos().addAll(ePackageInfos);
			xtextProjectInfo.getEcore2Xtext().setRootElementClass(rootElementClass);
		}
	}

	@Override
	protected void checkConfigurationInternal(Issues issues) {
		if (genPath == null) {
			issues.addError("genPath not set");
		}
		if (rootElementClassName == null) {
			issues.addError("rootElement not set");
		}
		if (!issues.hasErrors()) {
			createXtextProjectInfo(issues);
		}
	}
}
