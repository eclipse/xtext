package org.eclipse.xtext.idea.common.types.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class RefactoringTestLanguageFacetType  extends AbstractFacetType<RefactoringTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.idea.common.types.RefactoringTestLanguage";

	public static  FacetTypeId<Facet<RefactoringTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<RefactoringTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public RefactoringTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "RefactoringTestLanguage");
		org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
