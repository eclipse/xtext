package org.eclipse.xtext.parser.indentation.idea.lang;

class IndentationAwareTestLanguageFileType extends AbstractIndentationAwareTestLanguageFileType {

	public static final IndentationAwareTestLanguageFileType INSTANCE = new IndentationAwareTestLanguageFileType()
	
	new() {
		super(IndentationAwareTestLanguageLanguage.INSTANCE)
	}

}
