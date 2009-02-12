import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class GenerateProxyAndPserverPsf {

	private static final String XTEXT_PROJECTSET_PSF = "/xtext-projectset.psf";

	public static void main(String[] args) {
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader("psf/extssh"+ XTEXT_PROJECTSET_PSF));
			BufferedWriter proxy = new BufferedWriter(new FileWriter("psf/extssh-withProxy" + XTEXT_PROJECTSET_PSF));
			BufferedWriter pserver = new BufferedWriter(new FileWriter("psf/pserver" + XTEXT_PROJECTSET_PSF));
			String line;
			while((line = fileReader.readLine())!= null) {
				proxy.write(line.replaceAll(":extssh:dev\\.eclipse\\.org:", ":extssh:proxy.eclipse.org:443:"));
				proxy.newLine();
				pserver.write(line.replaceAll(":extssh:", ":pserver:anonymous@"));
				pserver.newLine();
			}
			fileReader.close();
			proxy.close();
			pserver.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
