package org.eclipse.xtext.idea.example.entities.idea.lang;

import org.eclipse.xtext.idea.example.entities.idea.lang.AbstractEntitiesFileType;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;

@SuppressWarnings("all")
public class EntitiesFileType extends AbstractEntitiesFileType {
  public final static EntitiesFileType INSTANCE = new EntitiesFileType();
  
  public EntitiesFileType() {
    super(EntitiesLanguage.INSTANCE);
  }
}
