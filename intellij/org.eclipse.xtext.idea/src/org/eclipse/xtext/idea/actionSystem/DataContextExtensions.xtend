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