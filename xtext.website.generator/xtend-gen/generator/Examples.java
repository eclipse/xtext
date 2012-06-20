package generator;

import bootstrap.Body;
import com.google.inject.Inject;
import generator.Documentation;
import generator.ExampleSetup;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xdoc.XdocStandaloneSetup;
import org.eclipse.xtext.xdoc.xdoc.Document;

@SuppressWarnings("all")
public class Examples extends Documentation {
  @Inject
  private Body _body;
  
  public XdocStandaloneSetup getStandaloneSetup() {
    ExampleSetup _exampleSetup = new ExampleSetup();
    return _exampleSetup;
  }
  
  public String getXdocDocumentRootFolder() {
    return "../docs/org.xtext.sevenlanguages.doc.xdoc/xdoc";
  }
  
  public String path() {
    return "examples.html";
  }
  
  public CharSequence contents() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.append("<!--Container-->");
    _builder.newLine();
    _builder.append("<div id=\"header_wrapper\" class=\"container\" >");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"inner\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<div class=\"container\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<div class=\"page-heading\"><h1>Documentation</h1></div>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</div> <!-- /.container -->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</div> <!-- /inner -->");
    _builder.newLine();
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("<div id=\"page\">  ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"inner\">");
    _builder.newLine();
    _builder.append("\t\t");
    Document _document = this.getDocument();
    CharSequence _body = this._body.body(_document);
    _builder.append(_body, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
}
