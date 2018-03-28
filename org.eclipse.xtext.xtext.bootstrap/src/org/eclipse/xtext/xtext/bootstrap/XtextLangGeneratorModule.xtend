package org.eclipse.xtext.xtext.bootstrap

import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.TypeReference

class XtextLangGeneratorModule extends DefaultGeneratorModule {
	
	def Class<? extends XtextGeneratorNaming> bindNaming() {
		return XtextLangGeneratorNaming
	}
	
	static class XtextLangGeneratorNaming extends XtextGeneratorNaming {
		
		override getGenericIdeBasePackage(Grammar grammar) {
			if (isXtext(grammar)) {
				return "org.eclipse.xtext.xtext.ide";
			} else {
				return super.getGenericIdeBasePackage(grammar);
			}
		}
		
		override getEclipsePluginBasePackage(Grammar grammar) {
			if (isXtext(grammar)) {
				return "org.eclipse.xtext.xtext.ui";
			} else {
				return super.getEclipsePluginBasePackage(grammar);
			}
		}
		
		override getEclipsePluginActivator() {
			return new TypeReference("org.eclipse.xtext.xtext.ui.internal", "Activator");
		}
		
		def boolean isXtext(Grammar grammar) {
			return grammar.getName().equals("org.eclipse.xtext.Xtext");
		}
	}
}