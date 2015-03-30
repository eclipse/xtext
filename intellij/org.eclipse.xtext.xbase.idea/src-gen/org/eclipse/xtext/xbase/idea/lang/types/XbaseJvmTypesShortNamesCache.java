package org.eclipse.xtext.xbase.idea.lang.types;

import com.intellij.openapi.project.Project;
import org.eclipse.xtext.xbase.idea.types.JvmTypesShortNamesCache;
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;

class XbaseJvmTypesShortNamesCache extends JvmTypesShortNamesCache {

	public XbaseJvmTypesShortNamesCache(Project project) {
		super(XbaseLanguage.INSTANCE, project);
	}

}
