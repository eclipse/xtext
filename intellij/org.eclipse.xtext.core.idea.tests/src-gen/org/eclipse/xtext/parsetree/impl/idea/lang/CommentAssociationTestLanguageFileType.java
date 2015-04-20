package org.eclipse.xtext.parsetree.impl.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class CommentAssociationTestLanguageFileType extends LanguageFileType {

	public static final CommentAssociationTestLanguageFileType INSTANCE = new CommentAssociationTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "commentassociationtestlanguage";

	private CommentAssociationTestLanguageFileType() {
		super(CommentAssociationTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "CommentAssociationTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "CommentAssociationTestLanguage";
	}

}
