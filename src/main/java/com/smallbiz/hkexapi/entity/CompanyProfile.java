package com.smallbiz.hkexapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyProfile {
	@Id
	private String instrumentCode;
	private String shortName;
	private String nameEn;
	private String nameHk;
	private String nameCn;	
	private String principalActivitiesEn;//CorporateProfile
	private String principalActivitiesHk;//CorporateProfile
	private String principalActivitiesCn;//CorporateProfile
	private String classificationEn;//Industry
	private String classificationHk;//Industry
	private String classificationCn;//Industry
//	private String placeIncorporated;
	private String addressEn;//
	private String addressHk;//
	private String addressCn;//	
	private String website;//
	private String email;//
	private String telephone;//
	private String fax;//
	private int listingDate;//ListingDate
	private String tradeCurrency;
	private String parCurrency;//parCurrency
	private double parValue;//parValue
	private long boardLot;//boardLot	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompanyProfile [instrumentCode=");
		builder.append(instrumentCode);
		builder.append(", shortName=");
		builder.append(shortName);
		builder.append(", nameEn=");
		builder.append(nameEn);
		builder.append(", nameHk=");
		builder.append(nameHk);
		builder.append(", nameCn=");
		builder.append(nameCn);
		builder.append(", principalActivitiesEn=");
		builder.append(principalActivitiesEn);
		builder.append(", principalActivitiesHk=");
		builder.append(principalActivitiesHk);
		builder.append(", principalActivitiesCn=");
		builder.append(principalActivitiesCn);
		builder.append(", classificationEn=");
		builder.append(classificationEn);
		builder.append(", classificationHk=");
		builder.append(classificationHk);
		builder.append(", classificationCn=");
		builder.append(classificationCn);
		builder.append(", addressEn=");
		builder.append(addressEn);
		builder.append(", addressHk=");
		builder.append(addressHk);
		builder.append(", addressCn=");
		builder.append(addressCn);
		builder.append(", website=");
		builder.append(website);
		builder.append(", email=");
		builder.append(email);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", fax=");
		builder.append(fax);
		builder.append(", listingDate=");
		builder.append(listingDate);
		builder.append(", tradeCurrency=");
		builder.append(tradeCurrency);
		builder.append(", parCurrency=");
		builder.append(parCurrency);
		builder.append(", parValue=");
		builder.append(parValue);
		builder.append(", boardLot=");
		builder.append(boardLot);
		builder.append("]");
		return builder.toString();
	}	
	
}
