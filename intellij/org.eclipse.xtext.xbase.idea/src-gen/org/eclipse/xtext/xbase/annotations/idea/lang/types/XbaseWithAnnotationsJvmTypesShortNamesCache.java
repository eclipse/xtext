package org.eclipse.xtext.xbase.annotations.idea.lang.types;

import com.intellij.openapi.project.Project;
import org.eclipse.xtext.idea.types.JvmTypesShortNamesCache;
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage;

class XbaseWithAnnotationsJvmTypesShortNamesCache extends JvmTypesShortNamesCache {

	public XbaseWithAnnotationsJvmTypesShortNamesCache(Project project) {
		super(XbaseWithAnnotationsLanguage.INSTANCE, project);
	}

}
