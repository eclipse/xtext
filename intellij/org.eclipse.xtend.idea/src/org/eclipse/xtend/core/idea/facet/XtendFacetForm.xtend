/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.facet

import com.intellij.openapi.module.Module
import javax.swing.JCheckBox
import org.eclipse.xtext.idea.facet.GeneratorFacetForm
import org.eclipse.xtext.idea.util.IdeaWidgetFactory
import org.eclipse.xtext.idea.util.IdeaWidgetFactory.TwoColumnPanel

/**
 * @author dhuebner - Initial contribution and API
 */
class XtendFacetForm extends GeneratorFacetForm<XtendGeneratorConfigurationState> {
	extension IdeaWidgetFactory = new IdeaWidgetFactory

	JCheckBox useJavasSourcelevel

	JCheckBox generateGeneratedAnno

	JCheckBox generateSuppressWarnAnno

	JCheckBox ignoreGeneratedJava

	new(Module module) {
		super(module)
	}

	override createGeneralSection(extension TwoColumnPanel it) {
		super.createGeneralSection(it)
		row [useJavasSourcelevel = checkBox("Use source compatibility level from Java settings")]
		row [generateSuppressWarnAnno = checkBox("Generate @SuppressWarnings annotations")]
		row [generateGeneratedAnno = checkBox("Generate @Generated annotations")]
	}

	override createOutputSection(extension TwoColumnPanel it) {
		super.createOutputSection(it)
		row [ignoreGeneratedJava = checkBox("Ignore generated Java source when debugging (Use for Android)")]
	}

}