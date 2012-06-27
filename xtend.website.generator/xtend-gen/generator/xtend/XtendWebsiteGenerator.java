package generator.xtend;

import generator.Generator;
import generator.Resource;
import generator.xtend.Community;
import generator.xtend.Documentation;
import generator.xtend.Download;
import generator.xtend.Index;
import java.io.File;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class XtendWebsiteGenerator {
  public static void main(final String[] args) {
    System.setProperty("java.awt.headless", "true");
    File _file = new File("website");
    final File out = _file;
    Index _index = new Index();
    Download _download = new Download();
    Documentation _documentation = new Documentation();
    Community _community = new Community();
    Generator.generateFiles(out, _index, _download, _documentation, _community);
    InputOutput.<String>println("Done.");
  }
  
  public static void generateFiles(final File targetDir, final Resource... sites) {
    for (final Resource site : sites) {
      site.generateTo(targetDir);
    }
  }
}
