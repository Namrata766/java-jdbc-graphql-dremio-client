package com.nam.dremioclient.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class CommercialAsset implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7845889010051348750L;
	
	private String assetId;
	private String accountId;
	private String siteId;
	private String groupId;
	private String warrantyCode;
	private String expiryDate;
	private String sacVersion;
	private String region;
	private String age;
	private String prodLob;
	private String prodLine;
	private String osName;
	private String modelNumber;
	private String error;
}
