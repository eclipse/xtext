package org.eclipse.xtext.xbase.idea.lang.types.psi;

import org.eclipse.xtext.idea.types.psi.JvmTypesElementFinder;
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;

import com.intellij.openapi.project.Project;

public class XbaseJvmTypesElementFinder extends JvmTypesElementFinder {

	public XbaseJvmTypesElementFinder(Project project) {
		super(XbaseLanguage.INSTANCE, project);
	}

}
