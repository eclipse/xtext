package org.eclipse.xtext.linking.lazy.idea.lang;

import org.eclipse.xtext.linking.lazy.idea.lang.AbstractLazyLinkingTestLanguageFileType;
import org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageLanguage;

@SuppressWarnings("all")
public class LazyLinkingTestLanguageFileType extends AbstractLazyLinkingTestLanguageFileType {
  public final static LazyLinkingTestLanguageFileType INSTANCE = new LazyLinkingTestLanguageFileType();
  
  public LazyLinkingTestLanguageFileType() {
    super(LazyLinkingTestLanguageLanguage.INSTANCE);
  }
}
