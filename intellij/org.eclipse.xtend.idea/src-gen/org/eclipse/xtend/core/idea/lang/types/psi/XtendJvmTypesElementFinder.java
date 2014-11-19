package org.eclipse.xtend.core.idea.lang.types.psi;

import com.intellij.openapi.project.Project;
import org.eclipse.xtext.idea.types.psi.JvmTypesElementFinder;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;

public class XtendJvmTypesElementFinder extends JvmTypesElementFinder {

	public XtendJvmTypesElementFinder(Project project) {
		super(XtendLanguage.INSTANCE, project);
	}

}
