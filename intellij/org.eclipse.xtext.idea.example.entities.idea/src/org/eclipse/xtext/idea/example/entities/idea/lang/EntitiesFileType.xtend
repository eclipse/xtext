package org.eclipse.xtext.idea.example.entities.idea.lang;

class EntitiesFileType extends AbstractEntitiesFileType {

	public static final EntitiesFileType INSTANCE = new EntitiesFileType()
	
	new() {
		super(EntitiesLanguage.INSTANCE)
	}

}
