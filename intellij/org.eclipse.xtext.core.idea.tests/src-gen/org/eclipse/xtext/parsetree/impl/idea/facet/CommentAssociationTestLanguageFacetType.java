package org.eclipse.xtext.parsetree.impl.idea.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetTypeId;
import org.eclipse.xtext.idea.facet.AbstractFacetType;

public class CommentAssociationTestLanguageFacetType  extends AbstractFacetType<CommentAssociationTestLanguageFacetConfiguration> {
	private static String TYPE_ID_STRING = "org.eclipse.xtext.parsetree.impl.CommentAssociationTestLanguage";

	public static  FacetTypeId<Facet<CommentAssociationTestLanguageFacetConfiguration>> TYPEID = new FacetTypeId<Facet<CommentAssociationTestLanguageFacetConfiguration>>(TYPE_ID_STRING);

	public CommentAssociationTestLanguageFacetType() {
		super(TYPEID, TYPE_ID_STRING, "CommentAssociationTestLanguage");
		org.eclipse.xtext.parsetree.impl.idea.lang.CommentAssociationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

}
