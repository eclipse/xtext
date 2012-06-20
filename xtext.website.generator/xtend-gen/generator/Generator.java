package generator;

import generator.Examples;
import generator.Resource;
import java.io.File;

@SuppressWarnings("all")
public class Generator {
  public static void main(final String[] args) {
    File _file = new File("website");
    final File out = _file;
    Examples _examples = new Examples();
    Generator.generateFiles(out, _examples);
  }
  
  public static void generateFiles(final File targetDir, final Resource... sites) {
    for (final Resource site : sites) {
      site.generateTo(targetDir);
    }
  }
}
