package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractAnnotationBuilder extends AbstractCodeBuilder {
  @Accessors
  private String annotationName;
  
  public String getImage() {
    return "newannotation_wiz.gif";
  }
  
  @Pure
  public String getAnnotationName() {
    return this.annotationName;
  }
  
  public void setAnnotationName(final String annotationName) {
    this.annotationName = annotationName;
  }
}
