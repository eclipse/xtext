package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;

@SuppressWarnings("all")
public abstract class AbstractAnnotationBuilder extends AbstractCodeBuilder {
  private String _annotationName;
  
  public String getAnnotationName() {
    return this._annotationName;
  }
  
  public void setAnnotationName(final String annotationName) {
    this._annotationName = annotationName;
  }
  
  public String getImage() {
    return "newannotation_wiz.gif";
  }
}
