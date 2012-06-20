package generator;

import generator.Community;
import generator.Documentation;
import generator.Download;
import generator.Examples;
import generator.Index;
import generator.Resource;
import java.io.File;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Generator {
  public static void main(final String[] args) {
    File _file = new File("website");
    final File out = _file;
    Index _index = new Index();
    Download _download = new Download();
    Examples _examples = new Examples();
    Documentation _documentation = new Documentation();
    Community _community = new Community();
    Generator.generateFiles(out, _index, _download, _examples, _documentation, _community);
    InputOutput.<String>println("Done.");
  }
  
  public static void generateFiles(final File targetDir, final Resource... sites) {
    for (final Resource site : sites) {
      site.generateTo(targetDir);
    }
  }
}
