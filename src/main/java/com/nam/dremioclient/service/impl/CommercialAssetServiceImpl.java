package com.nam.dremioclient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nam.dremioclient.domain.CommercialAsset;
import com.nam.dremioclient.repository.CommercialAssetDremioRepository;
import com.nam.dremioclient.service.CommercialAssetService;

/**
 * @author Namrata_Kumari
 *
 */
@Service
public class CommercialAssetServiceImpl implements CommercialAssetService {

	@Autowired
	CommercialAssetDremioRepository caDremioRepo;
	
	/*
	 * Dremio JDBC Driver is not transactional. Hence, no transactional annotations.
	 */
	
	@Override
	public CommercialAsset getAssetById(String assetId) throws Exception {
		return caDremioRepo.getAssetById(assetId);
	}

	@Override
	public List<CommercialAsset> getAllAssets() throws Exception {
		return caDremioRepo.getAssets();
	}
}
