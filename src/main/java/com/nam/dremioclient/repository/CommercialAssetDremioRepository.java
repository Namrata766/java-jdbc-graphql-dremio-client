package com.nam.dremioclient.repository;

import java.util.List;

import com.nam.dremioclient.domain.CommercialAsset;

public interface CommercialAssetDremioRepository {

	CommercialAsset getAssetById(String assetId) throws Exception;
	
	List<CommercialAsset> getAssets() throws Exception;
	
	public static final String FETCH_COMMERCIAL_ASSETS = "SELECT * FROM space.folder.\"vds\" fetch first 10 rows only";
	
	public static final String FETCH_COMMERCIAL_ASSETS_FOR_ID = "SELECT * FROM space.folder.\"vds\" WHERE ASSET_ID = %s";
}
