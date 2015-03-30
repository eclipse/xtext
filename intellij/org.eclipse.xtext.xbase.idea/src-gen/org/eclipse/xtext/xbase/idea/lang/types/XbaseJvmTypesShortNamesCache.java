package org.eclipse.xtext.xbase.idea.lang.types;

import org.eclipse.xtext.idea.types.JvmTypesShortNamesCache;
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;

import com.intellij.openapi.project.Project;

class XbaseJvmTypesShortNamesCache extends JvmTypesShortNamesCache {

	public XbaseJvmTypesShortNamesCache(Project project) {
		super(XbaseLanguage.INSTANCE, project);
	}

}
