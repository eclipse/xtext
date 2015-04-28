package org.eclipse.xtend.core.idea.lang.types;

import com.intellij.openapi.project.Project;
import org.eclipse.xtext.xbase.idea.types.JvmTypesShortNamesCache;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;

class XtendJvmTypesShortNamesCache extends JvmTypesShortNamesCache {

	public XtendJvmTypesShortNamesCache(Project project) {
		super(XtendLanguage.INSTANCE, project);
	}

}
