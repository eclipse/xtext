package org.eclipse.xtext.idea.lang;

public interface IXtextLanguage {

	public <T> T getInstance(Class<? extends T> clazz);
	
	public void injectMembers(Object o);
}
