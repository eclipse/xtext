package org.eclipse.xtext.parsetree.transientvalues.idea.lang;

import org.eclipse.xtext.parsetree.transientvalues.idea.lang.AbstractTransientValuesTestFileType;
import org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestLanguage;

@SuppressWarnings("all")
public class TransientValuesTestFileType extends AbstractTransientValuesTestFileType {
  public final static TransientValuesTestFileType INSTANCE = new TransientValuesTestFileType();
  
  public TransientValuesTestFileType() {
    super(TransientValuesTestLanguage.INSTANCE);
  }
}
