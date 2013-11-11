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

	private static Map<String, String> strexp = new HashMap<String, String>();

	private static String[] arguments = { "structureId", "chainId",
			"experimentalTechnique", "releaseDate", "resolution",
			"residueCount", "chainLength", "secondaryStructure",
			"citationAuthor", "publicationYear", "title", "journalName", "volumeId",
			"firstPage", "lastPage", "doi" };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String inputFileName = "results.do";
		File inFile = new File(inputFileName);
		FileReader fr = new FileReader(inFile);
		BufferedReader br = new BufferedReader(fr);

		Set<String> pdbs = new HashSet<String>();

		String pdbS = "					<a class=.*structureId=(.*)\">";
		Pattern pdbSp = Pattern.compile(pdbS);

		String line;
		while ((line = br.readLine()) != null) {

			Matcher pdbmatcher = pdbSp.matcher(line);

			if (pdbmatcher.matches()) {
				pdbs.add(pdbmatcher.group(1));

			}

		}

		fr.close();
		System.out.println(pdbs.size());
//		for (String s : pdbs) {
//			System.out.print(s + ",");
//		}
		String outputFileName = "output";
		File output = new File(outputFileName);

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
		// URL url = new URL(urlLink);
		// FileUtils.copyURLToFile(url, output);

		Set<PDB> records = new HashSet<PDB>();

		String linex;

		String recordReg = "  <record>";
		Pattern recordPattern = Pattern.compile(recordReg);

		String regexpr = "    <dim(Entity|Structure).(.*)>(.*)</.*";
		Pattern pattern = Pattern.compile(regexpr);

		FileReader xmlfr = new FileReader(output);
		BufferedReader xmlbr = new BufferedReader(xmlfr);

		while ((linex = xmlbr.readLine()) != null) {
			Matcher matchRecord = recordPattern.matcher(linex);
			Matcher match = pattern.matcher(linex);
		//	System.out.println(linex);

			if (match.matches()) {
				strexp.put(match.group(2), match.group(3));
			}

			if (strexp.size() == 16) {
				PDB record = new PDB(null, null, null, null, null, null, null,
						null, null, null, null, null, null, null, null, null);
				for(String a : arguments){
					//System.out.println(a + "\t" + strexp.get(a));
					if( (!a.equals("citationAuthor")) && strexp.get(a)!=null){
						record.SetArguments(a,strexp.get(a));
					}
					if( a.equals("citationAuthor")){
						record.SetArguments(a, fix_author(strexp.get(a)));
					}
				}
				records.add(record);
				strexp = new HashMap<String, String>();
			}
		}
		System.out.println("structureId  & experimentalTechnique & resolution & releaseDate  & residueNumber & secondaryStructure  &  doi");

		Map <String, Set<String>> doiPDBs = new HashMap<String, Set<String>>();
		
		xmlbr.close();
		for(PDB record : records){
			if(record.getResidueCount()!=null)
				if(Integer.parseInt(record.getResidueCount()) > 42 ){ 
					System.out.print("@Article{");
					System.out.println(record);
				
			
					if(doiPDBs.containsKey(record.getDoi())){
						doiPDBs.get(record.getDoi()).add(record.getStructureId());
					}else{
						Set<String> temppdb = new HashSet<String>();
						temppdb.add(record.getStructureId());
						doiPDBs.put(record.getDoi(), temppdb);
					}
			}
		}
		
		System.out.println(records.size());
		for(String s : doiPDBs.keySet()){
			if(doiPDBs.get(s).size() > 1)
				System.out.println(s + "\t" + doiPDBs.get(s));
		}
	}
	
	public static String fix_author(String authors){
		String author[] = authors.split(",");
		String newauthor[] = new String[author.length];
		
		String a = "";
		for(Integer i=0; i<author.length; i+=2){
			if(!a.isEmpty())
				a += " and ";
			newauthor[i] = author[i+1];
			newauthor[i+1] = author[i];
			a = a + newauthor[i] + " " + newauthor[i+1];
		}
		//System.out.println(a);
		return a;	
	}
	
}
