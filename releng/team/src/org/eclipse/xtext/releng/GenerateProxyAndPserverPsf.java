package org.eclipse.xtext.releng;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class GenerateProxyAndPserverPsf {

	public static final String XTEXT_PROJECTSET_PSF = "./team/projectset/extssh/xtext.psf";
	public static final String TARGET_FOLDER = "./team/projectset";

	public static void main(String[] args) {
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(XTEXT_PROJECTSET_PSF));
			BufferedWriter proxy = new BufferedWriter(new FileWriter(TARGET_FOLDER+"/extssh-withProxy/xtext.psf"));
			BufferedWriter pserver = new BufferedWriter(new FileWriter(TARGET_FOLDER+"/pserver/xtext.psf"));
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
