package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractAnnotationBuilder extends AbstractCodeBuilder {
  @Property
  private String _annotationName;
  
  public String getImage() {
    return "newannotation_wiz.gif";
  }
  
  @Pure
  public String getAnnotationName() {
    return this._annotationName;
  }
  
  public void setAnnotationName(final String annotationName) {
    this._annotationName = annotationName;
  }
}
