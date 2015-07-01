package org.eclipse.xtext.idea.common.types.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class RefactoringTestLanguageFacetType  extends AbstractFacetType<RefactoringTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<RefactoringTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<RefactoringTestLanguageFacetConfiguration>>("org.eclipse.xtext.idea.common.types.RefactoringTestLanguage");

	public RefactoringTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.idea.common.types.RefactoringTestLanguage", "RefactoringTestLanguage");
		org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
