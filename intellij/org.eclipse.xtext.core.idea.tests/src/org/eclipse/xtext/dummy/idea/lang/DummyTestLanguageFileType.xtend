package org.eclipse.xtext.dummy.idea.lang;

class DummyTestLanguageFileType extends AbstractDummyTestLanguageFileType {

	public static final DummyTestLanguageFileType INSTANCE = new DummyTestLanguageFileType()
	
	new() {
		super(DummyTestLanguageLanguage.INSTANCE)
	}

}
