package extractingPDB;

public class PDB {
	String structureId;
	String chainId;
	String experimentalTechnique;
	String releaseDate;
	String resolution;
	String residueCount;
	String chainLength;
	String secondaryStructure;
	String citationAuthor;
	String publicationYear;
	String journalName;
	String volumeId;
	String firstPage;
	String lastPage;
	String doi;

	public PDB(String structureId, String chainId,
			String experimentalTechnique, String releaseDate,
			String resolution, String residueCount, String chainLength,
			String secondaryStructure, String citationAuthor,
			String publicationYear, String journalName, String volumeId,
			String firstPage, String lastPage, String doi) {

		this.structureId = structureId;
		this.chainId = chainId;
		this.experimentalTechnique = experimentalTechnique;
		this.releaseDate = releaseDate;
		this.resolution = resolution;
		this.residueCount = residueCount;
		this.chainLength = chainLength;
		this.secondaryStructure = secondaryStructure;
		this.citationAuthor = citationAuthor;
		this.publicationYear = publicationYear;
		this.journalName = journalName;
		this.volumeId = volumeId;
		this.firstPage = firstPage;
		this.lastPage = lastPage;
		this.doi = doi;
	}

	public String getStructureId() {
		return structureId;
	}

	public void setStructureId(String structureId) {
		this.structureId = structureId;
	}

	public String getChainId() {
		return chainId;
	}

	public void setChainId(String chainId) {
		this.chainId = chainId;
	}

	public String getExperimentalTechnique() {
		return experimentalTechnique;
	}

	public void setExperimentalTechnique(String experimentalTechnique) {
		this.experimentalTechnique = experimentalTechnique;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getResidueCount() {
		return residueCount;
	}

	public void setResidueCount(String residueCount) {
		this.residueCount = residueCount;
	}

	public String getChainLength() {
		return chainLength;
	}

	public void setChainLength(String chainLength) {
		this.chainLength = chainLength;
	}

	public String getSecondaryStructure() {
		return secondaryStructure;
	}

	public void setSecondaryStructure(String secondaryStructure) {
		this.secondaryStructure = secondaryStructure;
	}

	public String getCitationAuthor() {
		return citationAuthor;
	}

	public void setCitationAuthor(String citationAuthor) {
		this.citationAuthor = citationAuthor;
	}

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

	public String getVolumeId() {
		return volumeId;
	}

	public void setVolumeId(String volumeId) {
		this.volumeId = volumeId;
	}

	public String getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(String firstPage) {
		this.firstPage = firstPage;
	}

	public String getLastPage() {
		return lastPage;
	}

	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}
	
}
