package extractingPDB;
/*** written by lina <lina.oahz@gmail.com>
 * on Sat Nov  9 22:34:23 SGT 2013
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class Extracting {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String inputFileName = "results.do";
		File inFile = new File(inputFileName);
		FileReader fr = new FileReader(inFile);
		BufferedReader br = new BufferedReader(fr);
		
		Set <String> pdbs = new HashSet<String>();
		
		String pdbS = "					<a class=.*structureId=(.*)\">";			
		Pattern pdbSp = Pattern.compile(pdbS);
		
		String line;
		while( (line = br.readLine() ) != null ){
			
			Matcher pdbmatcher = pdbSp.matcher(line);
			
			if(pdbmatcher.matches()){
				pdbs.add(pdbmatcher.group(1));
				
			}
			
		}
		
		fr.close();
		System.out.println(pdbs.size());
		for (String s: pdbs){
			System.out.print(s+",");
		}
		String outputFileName = "output";
		File output = new File(outputFileName);
	//	String urlLink = "http://www.rcsb.org/pdb/rest/customReport?pdbids=1stp,2jef,1cdg&customReportColumns="
	//			+ "structureId,structureTitle,experimentalTechnique";
		String urlLink = "http://www.rcsb.org/pdb/rest/customReport?pdbids=1AAP,"
				+ "%201AMB,%201AMC,%201AML,%201BA4,%201BA6,%201BJB,%201BJC,%201BRC,%201CA0,"
				+ "%201HZ3,%201IYT,%201MWP,%201NMJ,%201OQN,%201OWT,%201QCM,%201QWP,%201QXC,"
				+ "%201QYT,%201TAW,%201TKN,%201X11,%201ZE7,%201ZE9,%201ZJD,%202BEG,%202BP4,"
				+ "%202FJZ,%202FK1,%202FK2,%202FK3,%202FKL,%202FMA,%202G47,%202IPU,%202LFM,"
				+ "%202LI9,%202LLM,%202LMN,%202LMO,%202LMP,%202LMQ,%202LNQ,%202LOH,%202LP1,"
				+ "%202LZ3,%202LZ4,%202M4J,%202M9R,%202M9S,%202OTK,%202R0W,%202ROZ,%202WK3,"
				+ "%202Y29,%202Y2A,%202Y3J,%202Y3K,%202Y3L,%203AYU,%203BAE,%203BKJ,%203DXC,"
				+ "%203DXD,%203DXE,%203GCI,%203IFL,%203IFN,%203IFO,%203IFP,%203JQ5,%203JQL,%203JTI,"
				+ "%203KTM,%203L33,%203L81,%203MOQ,%203MXC,%203NYJ,%203NYL,%203OVJ,%203OW9,%203SV1,"
				+ "%203U0T,%203UMH,%203UMI,%203UMK,%204HIX&customReportColumns=experimentalTechnique,"
				+ "releaseDate,resolution,residueCount,chainLength,secondaryStructure,citationAuthor,"
				+ "publicationYear,title,journalName,volumeId,firstPage,lastPage,"
				+ "doi&service=wsfile&format=xml&ssa=n&primaryOnly=1";
		//URL url = new URL(urlLink);
		//FileUtils.copyURLToFile(url, output);
		
		Set<PDB> records = new HashSet<PDB>();
		
		String linex;
//		Integer no = 15;
//		String regExpressions []= new String[no];
//		Pattern patterns [] = new Pattern[no];
//		Matcher matches[] = new Matcher[no];
		
		Map<String, String> strexp = new HashMap<String, String>();
		String regexpr = "    <dim(Entity|Structure).(.*)>(.*)</.*";
		Pattern pattern = Pattern.compile(regexpr);
		
//		regExpressions[ 0 ]="    <dimEntity.structureId>(.*)</dimEntity.structureId>";
//		regExpressions[ 1 ]=" 	 <dimEntity.chainId>(.*)</dimEntity.chainId>";
//		regExpressions[ 2 ]="    <dimStructure.experimentalTechnique>(.*)</dimStructure.experimentalTechnique>";
//		regExpressions[ 3 ]="    <dimStructure.releaseDate>(.*)</dimStructure.releaseDate>";
//		regExpressions[ 4 ]="    <dimStructure.resolution>(.*)</dimStructure.resolution>";
//		regExpressions[ 5 ]="    <dimStructure.residueCount>(.*)</dimStructure.residueCount>";
//		regExpressions[ 6 ]="    <dimEntity.chainLength>(.*)</dimEntity.chainLength>";
//		regExpressions[ 7 ]="    <dimEntity.secondaryStructure>(.*)<dimEntity.secondaryStructure>";
//		regExpressions[ 8 ]="    <dimStructure.citationAuthor>(.*)<dimStructure.citationAuthor>";
//		regExpressions[ 9 ]="    <dimStructure.publicationYear>(.*)<dimStructure.publicationYear";
//		regExpressions[ 10 ]="    <dimStructure.journalName>(.*)</dimStructure.journalName>";
//		regExpressions[ 11 ]="    <dimStructure.volumeId>(.*)</dimStructure.volumeId>";
//		regExpressions[ 12 ]="    <dimStructure.firstPage>(.*)</dimStructure.firstPage>";
//		regExpressions[ 13 ]="    <dimStructure.lastPage>(.*)</dimStructure.lastPage>";
//		regExpressions[ 14 ]="    <dimStructure.doi>(.*)</dimStructure.doi>";
//		

		FileReader xmlfr = new FileReader(output);
		BufferedReader xmlbr = new BufferedReader(xmlfr);
		PDB tmpPDB = new PDB(null, null, null, null, null, null, null,null,null,null,null,null,null,null);
		while( (linex = xmlbr.readLine()) != null){
			Matcher match = pattern.matcher(linex);
			if(match.matches()){
				System.out.println(match.group(2) + "\t" + match.group(3));
			}

			
		}
		xmlbr.close();
	}

}
