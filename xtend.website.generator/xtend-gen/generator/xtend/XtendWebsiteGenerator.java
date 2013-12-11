package generator.xtend;

import generator.Resource;
import generator.xtend.Community;
import generator.xtend.Documentation;
import generator.xtend.Download;
import generator.xtend.Index;
import generator.xtend.News;
import generator.xtend.ReleaseNotes;
import java.io.File;
import org.eclipse.xtend.core.XtendStandaloneSetup;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class XtendWebsiteGenerator {
  public static void main(final String[] args) {
    System.setProperty("java.awt.headless", "true");
    XtendStandaloneSetup.doSetup();
    File _file = new File("website");
    final File out = _file;
    Index _index = new Index();
    News _news = new News();
    Download _download = new Download();
    Documentation _documentation = new Documentation();
    ReleaseNotes _releaseNotes = new ReleaseNotes();
    Community _community = new Community();
    XtendWebsiteGenerator.generateFiles(out, _index, _news, _download, _documentation, _releaseNotes, _community);
    InputOutput.<String>println("Done.");
  }
  
  public static void generateFiles(final File targetDir, final Resource... sites) {
    for (final Resource site : sites) {
      site.generateTo(targetDir);
    }
  }
}
