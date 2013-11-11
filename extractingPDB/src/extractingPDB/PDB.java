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
	String title;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	String journalName;
	String volumeId;
	String firstPage;
	String lastPage;
	String doi;

	public PDB(String structureId, String chainId,
			String experimentalTechnique, String releaseDate,
			String resolution, String residueCount, String chainLength,
			String secondaryStructure, String citationAuthor,
			String publicationYear, String title, String journalName, String volumeId,
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
		this.title = title;
		this.publicationYear = publicationYear;
		this.journalName = journalName;
		this.volumeId = volumeId;
		this.firstPage = firstPage;
		this.lastPage = lastPage;
		this.doi = doi;
	}

	public void SetArguments(String argument, String value) {
		switch (argument) {
		case "structureId":
			setStructureId(value);
			return;

		case "chainId":
			setChainId(value);
			return;

		case "experimentalTechnique":
			setExperimentalTechnique(value);
			return;

		case "releaseDate":
			setReleaseDate(value);
			return;

		case "resolution":
			setResolution(value);
			return;

		case "residueCount":
			setResidueCount(value);
			return;

		case "chainLength":
			setChainId(value);
			return;

		case "secondaryStructure":
			setSecondaryStructure(value);
			return;

		case "citationAuthor":
			setCitationAuthor(value);
			return;

		case "publicationYear":
			setPublicationYear(value);
			return;
			
		case "title":
			setTitle(value);
			return;

		case "journalName":
			setJournalName(value);
			return;

		case "volumeId":
			setVolumeId(value);
			return;

		case "firstPage":
			setFirstPage(value);
			return;

		case "lastPage":
			setFirstPage(value);
			return;

		case "doi":
			setDoi(value);
			return;

		}
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

	



//	@Override
//	public String toString() {
//		return structureId +"\\cite{" + structureId + "}"+ " & " + experimentalTechnique + " & " + resolution
//				+ " & " + releaseDate + " & " + residueCount + " & " 
//				 + " & "+ doi + " \\\\";
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doi == null) ? 0 : doi.hashCode());
		result = prime * result
				+ ((firstPage == null) ? 0 : firstPage.hashCode());
		result = prime * result
				+ ((journalName == null) ? 0 : journalName.hashCode());
		result = prime * result
				+ ((lastPage == null) ? 0 : lastPage.hashCode());
		result = prime * result
				+ ((publicationYear == null) ? 0 : publicationYear.hashCode());
		result = prime * result
				+ ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result
				+ ((residueCount == null) ? 0 : residueCount.hashCode());
		result = prime * result
				+ ((structureId == null) ? 0 : structureId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result
				+ ((volumeId == null) ? 0 : volumeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PDB other = (PDB) obj;
		if (doi == null) {
			if (other.doi != null)
				return false;
		} else if (!doi.equals(other.doi))
			return false;
		if (firstPage == null) {
			if (other.firstPage != null)
				return false;
		} else if (!firstPage.equals(other.firstPage))
			return false;
		if (journalName == null) {
			if (other.journalName != null)
				return false;
		} else if (!journalName.equals(other.journalName))
			return false;
		if (lastPage == null) {
			if (other.lastPage != null)
				return false;
		} else if (!lastPage.equals(other.lastPage))
			return false;
		if (publicationYear == null) {
			if (other.publicationYear != null)
				return false;
		} else if (!publicationYear.equals(other.publicationYear))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (residueCount == null) {
			if (other.residueCount != null)
				return false;
		} else if (!residueCount.equals(other.residueCount))
			return false;
		if (structureId == null) {
			if (other.structureId != null)
				return false;
		} else if (!structureId.equals(other.structureId))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (volumeId == null) {
			if (other.volumeId != null)
				return false;
		} else if (!volumeId.equals(other.volumeId))
			return false;
		return true;
	}

	@Override
	public String toString(){
		return structureId +",\n"
						+"author =\"" + citationAuthor+ "\",\n"
						+"title =\""  + title +      "\",\n"
						+"year =\""   + publicationYear +    "\",\n"
						+"journal =\"" +journalName +     "\",\n"
						+"volume =\"" +volumeId +     "\",\n"
						+"pages =\"" +firstPage + "-" + lastPage  +"\",\n"
						+"doi =\""   +doi+   "\",\n"
						+"}";

	}
				//+ ", citationAuthor=" + citationAuthor + ", publicationYear="
				//+ publicationYear + ", journalName=" + journalName
				//+ ", volumeId=" + volumeId +  "\n" +  firstPage
				//+ "-" + lastPage;
	

}
