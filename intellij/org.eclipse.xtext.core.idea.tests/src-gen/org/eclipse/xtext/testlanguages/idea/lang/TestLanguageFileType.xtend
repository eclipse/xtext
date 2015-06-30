package org.eclipse.xtext.testlanguages.idea.lang;

class TestLanguageFileType extends AbstractTestLanguageFileType {

	public static final TestLanguageFileType INSTANCE = new TestLanguageFileType()
	
	new() {
		super(TestLanguageLanguage.INSTANCE)
	}

}
