package org.eclipse.xtext.idea.lang;

import com.google.inject.Injector;
import com.intellij.lang.Language;

public abstract class AbstractXtextLanguage extends Language implements IXtextLanguage {

	
	public AbstractXtextLanguage(Language baseLanguage, String ID,
			String... mimeTypes) {
		super(baseLanguage, ID, mimeTypes);
	}

	public AbstractXtextLanguage(String id, boolean register) {
		super(id, register);
	}

	public AbstractXtextLanguage(String ID, String... mimeTypes) {
		super(ID, mimeTypes);
	}

	public AbstractXtextLanguage(String id) {
		super(id);
	}

	abstract protected Injector getInjector(); 
	
	public <T> T getInstance(Class<? extends T> clazz) {
		return getInjector().getInstance(clazz);
	}
	
	public void injectMembers(Object o) {
		getInjector().injectMembers(o);
	}
}
