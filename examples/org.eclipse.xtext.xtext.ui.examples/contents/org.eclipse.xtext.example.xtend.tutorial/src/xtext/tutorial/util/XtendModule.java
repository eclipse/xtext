package xtext.tutorial.util;

import xtext.tutorial.basics.Xtend11_PersonExtensions;
import xtext.tutorial.basics.Xtend11_PersonExtensionsSubclass;

import com.google.inject.AbstractModule;

public class XtendModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Xtend11_PersonExtensions.class).to(Xtend11_PersonExtensionsSubclass.class);
	}
	
}
