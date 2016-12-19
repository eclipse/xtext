package org.eclipse.xtext.xtext.bootstrap;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@SuppressWarnings("all")
public class XtextLangGeneratorModule extends DefaultGeneratorModule {
  public static class XtextLangGeneratorNaming extends XtextGeneratorNaming {
    @Override
    public String getGenericIdeBasePackage(final Grammar grammar) {
      boolean _isXtext = this.isXtext(grammar);
      if (_isXtext) {
        return "org.eclipse.xtext.xtext.ide";
      } else {
        return super.getGenericIdeBasePackage(grammar);
      }
    }
    
    @Override
    public String getEclipsePluginBasePackage(final Grammar grammar) {
      boolean _isXtext = this.isXtext(grammar);
      if (_isXtext) {
        return "org.eclipse.xtext.xtext.ui";
      } else {
        return super.getEclipsePluginBasePackage(grammar);
      }
    }
    
    @Override
    public TypeReference getEclipsePluginActivator() {
      return new TypeReference("org.eclipse.xtext.xtext.ui.internal", "Activator");
    }
    
    public boolean isXtext(final Grammar grammar) {
      String _name = grammar.getName();
      return _name.equals("org.eclipse.xtext.Xtext");
    }
  }
  
  public Class<? extends XtextGeneratorNaming> bindNaming() {
    return XtextLangGeneratorModule.XtextLangGeneratorNaming.class;
  }
}
