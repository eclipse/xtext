package org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang;

import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.AbstractRegionAccessTestLanguageFileType;
import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageLanguage;

@SuppressWarnings("all")
public class RegionAccessTestLanguageFileType extends AbstractRegionAccessTestLanguageFileType {
  public final static RegionAccessTestLanguageFileType INSTANCE = new RegionAccessTestLanguageFileType();
  
  public RegionAccessTestLanguageFileType() {
    super(RegionAccessTestLanguageLanguage.INSTANCE);
  }
}
