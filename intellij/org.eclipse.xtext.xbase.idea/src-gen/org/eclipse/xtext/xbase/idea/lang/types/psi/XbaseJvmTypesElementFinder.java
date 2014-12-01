package org.eclipse.xtext.xbase.idea.lang.types.psi;

import com.intellij.openapi.project.Project;
import org.eclipse.xtext.idea.types.psi.JvmTypesElementFinder;
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;

public class XbaseJvmTypesElementFinder extends JvmTypesElementFinder {

	public XbaseJvmTypesElementFinder(Project project) {
		super(XbaseLanguage.INSTANCE, project);
	}

}
