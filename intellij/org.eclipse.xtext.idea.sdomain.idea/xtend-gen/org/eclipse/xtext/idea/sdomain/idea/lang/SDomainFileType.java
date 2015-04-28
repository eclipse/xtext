package org.eclipse.xtext.idea.sdomain.idea.lang;

import org.eclipse.xtext.idea.sdomain.idea.lang.AbstractSDomainFileType;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;

@SuppressWarnings("all")
public class SDomainFileType extends AbstractSDomainFileType {
  public final static SDomainFileType INSTANCE = new SDomainFileType();
  
  public SDomainFileType() {
    super(SDomainLanguage.INSTANCE);
  }
}
