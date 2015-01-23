/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.actionSystem

import com.intellij.openapi.actionSystem.DataContext

import static com.intellij.openapi.actionSystem.CommonDataKeys.*

class DataContextExtensions {
	
	static def getProject(DataContext dataContext) {
		PROJECT.getData(dataContext)
	}
	
	static def getEditor(DataContext dataContext) {
		EDITOR.getData(dataContext)
	}
	
	static def getPsiFile(DataContext dataContext) {
		PSI_FILE.getData(dataContext)
	}
	
	static def getPsiElement(DataContext dataContext) {
		PSI_ELEMENT.getData(dataContext)
	}
	
}