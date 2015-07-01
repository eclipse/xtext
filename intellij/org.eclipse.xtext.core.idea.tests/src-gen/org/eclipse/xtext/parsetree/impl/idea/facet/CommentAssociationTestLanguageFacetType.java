package org.eclipse.xtext.parsetree.impl.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class CommentAssociationTestLanguageFacetType  extends AbstractFacetType<CommentAssociationTestLanguageFacetConfiguration> {

	public static final FacetTypeId<Facet<CommentAssociationTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<CommentAssociationTestLanguageFacetConfiguration>>("org.eclipse.xtext.parsetree.impl.CommentAssociationTestLanguage");

	public CommentAssociationTestLanguageFacetType() {
		super(TYPEID, "org.eclipse.xtext.parsetree.impl.CommentAssociationTestLanguage", "CommentAssociationTestLanguage");
		org.eclipse.xtext.parsetree.impl.idea.lang.CommentAssociationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
