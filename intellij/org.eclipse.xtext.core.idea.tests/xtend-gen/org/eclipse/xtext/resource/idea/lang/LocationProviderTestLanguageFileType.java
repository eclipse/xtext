package org.eclipse.xtext.resource.idea.lang;

import org.eclipse.xtext.resource.idea.lang.AbstractLocationProviderTestLanguageFileType;
import org.eclipse.xtext.resource.idea.lang.LocationProviderTestLanguageLanguage;

@SuppressWarnings("all")
public class LocationProviderTestLanguageFileType extends AbstractLocationProviderTestLanguageFileType {
  public final static LocationProviderTestLanguageFileType INSTANCE = new LocationProviderTestLanguageFileType();
  
  public LocationProviderTestLanguageFileType() {
    super(LocationProviderTestLanguageLanguage.INSTANCE);
  }
}
