package org.eclipse.xtext.purexbase.idea.lang;

import org.eclipse.xtext.purexbase.idea.lang.AbstractPureXbaseFileType;
import org.eclipse.xtext.purexbase.idea.lang.PureXbaseLanguage;

@SuppressWarnings("all")
public class PureXbaseFileType extends AbstractPureXbaseFileType {
  public final static PureXbaseFileType INSTANCE = new PureXbaseFileType();
  
  public PureXbaseFileType() {
    super(PureXbaseLanguage.INSTANCE);
  }
}
