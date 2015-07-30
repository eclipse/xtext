/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.tests.parsing

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.XtextResource

interface ModelChecker {
	
	def XtextResource checkResource(String code, boolean validate)
	
	def <T extends EObject> T checkModel(String code, boolean validate)
	def <T extends EObject> T checkModel(String path, String code, boolean validate)
	
}