package generator;

import generator.Documentation;

@SuppressWarnings("all")
public class SevenLanguagesDocumentation extends Documentation {
  public String getXdocDocumentRootFolder() {
    return "../docs/org.xtext.sevenlanguages.doc.xdoc/xdoc";
  }
  
  public String path() {
    return "7languagesDoc.html";
  }
  
  public CharSequence additionalLinks() {
    return null;
  }
}
