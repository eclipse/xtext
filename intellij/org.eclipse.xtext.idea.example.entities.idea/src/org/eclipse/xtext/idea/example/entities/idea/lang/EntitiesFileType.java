package org.eclipse.xtext.idea.example.entities.idea.lang;

public class EntitiesFileType extends AbstractEntitiesFileType {

	public static final EntitiesFileType INSTANCE = new EntitiesFileType();
	
	private EntitiesFileType() {
		super(EntitiesLanguage.INSTANCE);
	}

}
